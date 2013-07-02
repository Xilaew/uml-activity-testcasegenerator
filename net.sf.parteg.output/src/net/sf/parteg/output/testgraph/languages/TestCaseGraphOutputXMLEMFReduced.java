package net.sf.parteg.output.testgraph.languages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.TemporalConfiguration;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.base.testsuiteexport.Call;
import net.sf.parteg.base.testsuiteexport.Check;
import net.sf.parteg.base.testsuiteexport.TC;
import net.sf.parteg.base.testsuiteexport.TS;
import net.sf.parteg.base.testsuiteexport.TestsuiteexportFactory;
import net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage;
import net.sf.parteg.base.testsuiteexport.Variable;
import net.sf.parteg.base.testsuiteexport.util.TestsuiteexportResourceFactoryImpl;
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.testcase.TestCaseValidValue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class TestCaseGraphOutputXMLEMFReduced extends TestCaseGraphOutputOO {

	private TS m_oTS;
	private TC m_oCurrentTestCase;
	
	private ResourceSet m_oResourceSet;
	private Resource m_oResource;
	Map<String, Object> m_oOpts;
	
	public TestCaseGraphOutputXMLEMFReduced(TestCaseGraphHelper in_oTCGHelper) {
		super(in_oTCGHelper);
		m_oTS = null;
		m_oResourceSet = null;
		m_oResource = null;
		m_oConverter = new OCLExpressionConverterJava();

		// prepare xml output
		m_oOpts=new HashMap<String, Object>();
		m_oOpts.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		m_oOpts.put(XMLResource.OPTION_ENCODING, "UTF-8");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance,
			TCGOCLExpression in_oCondition) {
		
		FormattedOutput oFO = new FormattedOutput();
		handleOCLExpression(in_oTransitionInstance, 
				in_oCondition, oFO);
		String sExp = oFO.getStringBuffer().toString();
		
		if(!sExp.isEmpty()) {
			Check oCheck = TestsuiteexportFactory.eINSTANCE.createCheck();
			oCheck.setSimpleExp(sExp);
			m_oCurrentTestCase.getAction().add(oCheck);
		}
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance) {

		FormattedOutput oFO = new FormattedOutput(); 
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"", "", oFO);
		
		String sExp = oFO.getStringBuffer().toString().split(
				System.getProperty("line.separator"))[0];

		if(!sExp.isEmpty()) {
			Check oCheck = TestsuiteexportFactory.eINSTANCE.createCheck();
			oCheck.setSimpleExp(sExp);
			m_oCurrentTestCase.getAction().add(oCheck);
		}
	}

	@Override
	protected String getTypeNameAccessFunction(String in_oTypeString) {
		return "";
	}

	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		// create output elements
		m_oTS = TestsuiteexportFactory.eINSTANCE.createTS();
	}

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		// add new tree to contents for output file
		m_oResource.getContents().add(m_oTS);
	}

	@Override
	public void createLocalEnd() {
		// do nothing
	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		createTestCase();
		
		// define tested objects only once per class (later: per predefined instance?)
		List<org.eclipse.uml2.uml.Class> oInstantiatedClasses = new ArrayList<org.eclipse.uml2.uml.Class>();
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values()) {
			if(!oInstantiatedClasses.contains(oContextClass)) {
				oInstantiatedClasses.add(oContextClass);
				// add new variable definition
				Variable oVar = TestsuiteexportFactory.eINSTANCE.createVariable();
				oVar.setName(m_sObjectName);
				oVar.setType(oContextClass.getName());
				oVar.setValue("");
				m_oCurrentTestCase.getDefine().add(oVar);
			}
		}
		
		// collect real parameters - and their sub attributes
		HashSet<TCGParameter> colRealParameter = new HashSet<TCGParameter>();
		
		// iterate through all collected parameter instances
		for(EventParameterInstance oParameter : in_colParameters.keySet()) {
			TCGParameter oSuperParam = TCGParameterHelperClass.getSuperParameter(
					oParameter.getParameter());
			
			if(!oParameter.isReturnParameter()) {

				// the super parameter is not the original parameter and was not used yet
				if(!oSuperParam.equals(oParameter.getParameter())) {
					if(!colRealParameter.contains(oSuperParam)) {
						colRealParameter.add(oSuperParam);
						// print all complex parameters
						Variable oVar = TestsuiteexportFactory.eINSTANCE.createVariable();
						oVar.setName(oSuperParam.getName() 
								+ oParameter.getTransitionInstance().getName());
						oVar.setType(getClassName(oSuperParam.getValueType()));
						oVar.setValue("");
						m_oCurrentTestCase.getDefine().add(oVar);
					}
					// print the referenced attribute properties
					boolean define = false; // only assign parameter values
					printParameterValue(in_colParameters, oParameter, define);
				}
				else
				{
					boolean define = true; // define a new parameter
					printParameterValue(in_colParameters, oParameter, define);
				}
			}
		}
	}

	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance) {
		
		// preconditions are of no interest ... do not check them
		
		// event call information
		TCGEvent oEvent = in_oTransitionInstance.getCalledEvent();
		if(oEvent != null && isEventPrintingAllowed(oEvent)) {
			String sEvent = oEvent.getName(); 
			if(sEvent.length() > 0) {
				Call oCall = TestsuiteexportFactory.eINSTANCE.createCall();
				String sNameSuffix = TCGParameterHelperClass.findTransitionInstanceDefiningTheCurrentEvent(
						in_oTransitionInstance).getName();
				oCall.setEvent(in_oTransitionInstance.getCalledEvent().getName());
				for(TCGParameter oParameter : in_oTransitionInstance.getCalledEvent().getParameters()) {
					if(oParameter.getName() != null && !oParameter.getName().isEmpty()) {
						oCall.getParam().add(
								oParameter.getName() + sNameSuffix);
					}
				}
				m_oCurrentTestCase.getAction().add(oCall);
			}
		}
		
//		Klasse Action (Check und Call erben) einführen - damit Reihenfolge erhalten bleibt
		
		// handle methods postcondition
		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPostConditions()) {
			if(oExpression != null)
				getOutputForConditionInTransitionInstance(
						in_oTransitionInstance, oExpression);			
		}
		
		// handle state invariants of the target state
		getOutputForDNFInTargetNodeOfTransitionInstance(in_oTransitionInstance);
		
	}

	@Override
	public String getFileType() {
		return ".xml";
	}

	private void createTestCase() {
		m_oCurrentTestCase = TestsuiteexportFactory.eINSTANCE.createTC();
		m_oTS.getTc().add(m_oCurrentTestCase);
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputOO#configurePrintStreams()
	 * 
	 * alternative implementation: do not use the formatted output but resource sets
	 */
	@Override
	public void startPrintStreams() {
		m_oResourceSet = new ResourceSetImpl();
		m_oResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
					(Resource.Factory.Registry.DEFAULT_EXTENSION, 
					 new TestsuiteexportResourceFactoryImpl());
		m_oResourceSet.getPackageRegistry().put(TestsuiteexportPackage.eNS_URI, 
				TestsuiteexportPackage.eINSTANCE);
		m_oResource = m_oResourceSet.createResource(URI.createURI(
				"file://" + TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutput()) 
				+ getFileType()));
	}

	@Override
	public void endPrintStreams() {
		try {
			// save the file
			m_oResource.save(m_oOpts);			
		} catch (IOException e) {
			Configuration.handleException(e);
		}
	}
	
	protected void printParameterValue(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters,
			EventParameterInstance in_oParameter,
			boolean in_bDefine)
	{
		if(!in_oParameter.isReturnParameter()) {
			TestCaseValidValue oValue = in_colParameters.get(in_oParameter);
			String sValue = "";
			if(oValue != null) {
				if(in_oParameter.getParameter().getValueType() instanceof org.eclipse.uml2.uml.Enumeration)
					sValue = getClassName(in_oParameter.getParameter().getValueType()) + "." + oValue.getValue();
				else
					sValue = oValue.getValue();
			}
			
			Variable oVar = TestsuiteexportFactory.eINSTANCE.createVariable();
			oVar.setName(TCGParameterHelperClass.getFullParameterInstanceAttributeName(in_oParameter));
			oVar.setType(getClassName(in_oParameter.getParameter().getValueType()));
			oVar.setValue(sValue);
			if(in_bDefine == true)
				m_oCurrentTestCase.getDefine().add(oVar);
			else
				m_oCurrentTestCase.getAssign().add(oVar);
		}
	}
}
