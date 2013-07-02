package net.sf.parteg.output.testgraph.languages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseGraphOutputXMLManualReduced extends TestCaseGraphOutputOO {

	
	public TestCaseGraphOutputXMLManualReduced(TestCaseGraphHelper in_oTCGHelper) {
		super(in_oTCGHelper);
		m_oConverter = new OCLExpressionConverterJava();
	}
	
	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		// xml root
		m_oFormattedOutput.appendln("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		m_oFormattedOutput.increaseIndent();
		m_oFormattedOutput.appendln("<TestSuiteXML>");
	}

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		m_oFormattedOutput.decreaseIndent();
		m_oFormattedOutput.appendln("");
		m_oFormattedOutput.appendln("</TestSuiteXML>");
	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		m_oFormattedOutput.increaseIndent();
		m_oFormattedOutput.appendln("<TestCaseXML>");
		
		// instance of SUT
		List<org.eclipse.uml2.uml.Class> oInstantiatedClasses = new ArrayList<org.eclipse.uml2.uml.Class>();
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values()) {
			if(!oInstantiatedClasses.contains(oContextClass)) {
				oInstantiatedClasses.add(oContextClass);
				m_oFormattedOutput.appendln("<define " +
						"name =\"" + m_sObjectName +
						"\" type=\"" + oContextClass.getName() + "\"/>"); 
			}
		}
		
		// collect real parameters - and their sub attributes
		HashSet<TCGParameter> colRealParameter = new HashSet<TCGParameter>();
		
		// iterate through all collected parameter instances
		for(EventParameterInstance oParameter : in_colParameters.keySet()) {
			if(!oParameter.isReturnParameter()) {

				TCGParameter oSuperParam = TCGParameterHelperClass.getSuperParameter(
						oParameter.getParameter());
				
				// the super parameter is not the original parameter and was not used yet
				if(!oSuperParam.equals(oParameter.getParameter())) {
					if(!colRealParameter.contains(oSuperParam)) {
						colRealParameter.add(oSuperParam);
						// print all complex parameters
						m_oFormattedOutput.appendln("<define " +
								"name =\"" + oSuperParam.getName() 
								+ oParameter.getTransitionInstance().getName() +
								"\" type=\"" + getClassName(oSuperParam.getValueType()) 
								+ "\"/>"); 
					}
					// print the referenced attribute properties
					m_oFormattedOutput.append("<assign ");
					printParameterValue(in_colParameters, oParameter);
				}
				else {
					m_oFormattedOutput.append("<define ");
					printParameterValue(in_colParameters, oParameter);
				}
			}
		}
	}

	@Override
	public void createLocalEnd() {
		m_oFormattedOutput.decreaseIndent();
		m_oFormattedOutput.appendln("");
		m_oFormattedOutput.appendln("</TestCaseXML>");
		m_oFormattedOutput.appendln("");
	}


	@Override
	protected String getTypeNameAccessFunction(String in_oTypeString) {
		return "";
	}

	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance) {
		createOutput(in_oTransitionInstance, m_oFormattedOutput);
	}

	protected void createOutput(
			TransitionInstance in_oTransitionInstance,
			FormattedOutput in_oFormattedOutput)
	{
		// preconditions are unnecessary?

		// write expressions for the used preconditions of this test case
//		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPreConditions()) {
//			if(oExpression != null) {
//				// only write non-complex guard conditions - complex ones can be violated
//				OCLTreeTCGOCLAtomCollectorVisitor oAtomCollector =
//					new OCLTreeTCGOCLAtomCollectorVisitor();
//				OCLTreeExpressionIterator.run(oExpression, oAtomCollector);
//				int nActiveAtomCounter = 0;
//				for(TCGOCLAtom oExpAtom : oAtomCollector.getExpressions()) {
//					if(!oExpAtom.getClassification().equals(VariableClassification.INDEPENDENT)) {
//						++nActiveAtomCounter;
//					}
//				}
//				if(nActiveAtomCounter < 2) {
//					getOutputForConditionInTransitionInstance(
//						in_oTransitionInstance, oExpression);
//				}
//				else { // tmp - to check the violated conditions
//					getOutputForConditionInTransitionInstance(
//							in_oTransitionInstance, oExpression,
//							"<check expression=\"", "\"/>",
//							m_oFormattedOutput);
//				}
//			}
//		}
		
		// handle methods event
		TCGEvent oEvent = in_oTransitionInstance.getCalledEvent();
		if(oEvent != null && isEventPrintingAllowed(oEvent)) {
			String sEvent = oEvent.getName(); 
			if(sEvent.length() > 0) {
				List<TCGParameter> oParamList = 
					TCGParameterHelperClass.copyAllButReturnValues(oEvent.getParameters());
				String sNameSuffix = TCGParameterHelperClass.findTransitionInstanceDefiningTheCurrentEvent(
						in_oTransitionInstance).getName();

				if(oParamList.isEmpty()) {
					in_oFormattedOutput.appendln("<call object=\"" + m_sObjectName +
							"\" event=\"" + sEvent + "\"/>");
				}
				else {
				
					in_oFormattedOutput.increaseIndent();
					in_oFormattedOutput.appendln("<call object=\"" + m_sObjectName +
							"\" event=\"" + sEvent + "\">");
					
					for(int i = 0; i < oParamList.size(); ++i) {
						if(i == oParamList.size() - 1) {
							in_oFormattedOutput.decreaseIndent();
						}
						TCGParameter oParameter = oParamList.get(i);
						in_oFormattedOutput.appendln("<param name=\"" +
								oParameter.getName() + sNameSuffix + "\"/>");
					}
					in_oFormattedOutput.appendln("</call>");
				}
			}
		}
		
		// handle methods postcondition
		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPostConditions())
		{
			if(oExpression != null)
				getOutputForConditionInTransitionInstance(
						in_oTransitionInstance, oExpression);			
		}
		
		// handle state invariants of the target state
		getOutputForDNFInTargetNodeOfTransitionInstance(in_oTransitionInstance);
	}
	
	@Override
	public String getFileType() {
		// TODO Auto-generated method stub
		return ".xml";
	}
	
	protected void printParameterValue(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters,
			EventParameterInstance in_oParameter)
	{
		if(!in_oParameter.isReturnParameter()) {
			TestCaseValidValue oValue = in_colParameters.get(in_oParameter);
			String sValue = null;
			if(oValue != null) {
				if(in_oParameter.getParameter().getValueType() instanceof org.eclipse.uml2.uml.Enumeration)
					sValue = getClassName(in_oParameter.getParameter().getValueType()) + "." + oValue.getValue();
				else
					sValue = oValue.getValue();
	
				m_oFormattedOutput.appendln(
						"name =\"" + TCGParameterHelperClass.getFullParameterInstanceAttributeName(in_oParameter) +
						"\" type=\"" + getClassName(in_oParameter.getParameter().getValueType()) +
						"\" value=\"" + sValue +
						"\"/>"); 
			}
			else {
				//sValue = "new " + getClassName(in_oParameter.getParameter().getValueType()) + " ()";
				m_oFormattedOutput.appendln(
						"name =\"" + TCGParameterHelperClass.getFullParameterInstanceAttributeName(in_oParameter) +
						"\" type=\"" + getClassName(in_oParameter.getParameter().getValueType()) + 
						"\"/>"); 
			}
		}
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance)
	{
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"<check expression=\"", "\"/>",
				m_oFormattedOutput);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition)
	{
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"<check expression=\"", "\"/>",
				m_oFormattedOutput);
	}
}
