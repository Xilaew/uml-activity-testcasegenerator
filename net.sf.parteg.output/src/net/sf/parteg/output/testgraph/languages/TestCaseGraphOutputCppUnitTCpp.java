package net.sf.parteg.output.testgraph.languages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.TemporalConfiguration;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutputStream;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseGraphOutputCppUnitTCpp extends TestCaseGraphOutputCpp {


	public TestCaseGraphOutputCppUnitTCpp(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance,
			TCGOCLExpression in_oCondition) {
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"CPPUNIT_ASSERT_EQUAL(true, ", ");",
				m_oFormattedOutput);
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance) {
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"CPPUNIT_ASSERT_EQUAL(true, ", ");",
				m_oFormattedOutput);
	}

	@Override
	protected String getTypeNameAccessFunction(String in_oTypeString) {
		return "";
	}
	
	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		
		m_nTestMethodCounter = 0;

		// include test framework
		m_oFormattedOutput.appendln("#include <cppunit/TestFixture.h>");
		m_oFormattedOutput.appendln("#include \"" +
				TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + ".h\"");
	}	

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {

	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		++m_nTestMethodCounter;
		m_oFormattedOutput.newline();
		
		// method signature
		m_oFormattedOutput.appendln("void "
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName())
				+ "::"
				+ getTestMethodName(m_nTestMethodCounter) + "()");
		m_oFormattedOutput.openContext();
		
		// define tested objects
		List<org.eclipse.uml2.uml.Class> oInstantiatedClasses = new ArrayList<org.eclipse.uml2.uml.Class>();
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			if(!oInstantiatedClasses.contains(oContextClass)) {
				oInstantiatedClasses.add(oContextClass);
				m_oFormattedOutput.appendln(oContextClass.getName() 
					+ " " + m_sObjectName + ";");
			}
		}
		
		// collect real parameters - and their sub attributes
		HashSet<TCGParameter> colRealParameter = new HashSet<TCGParameter>();
		
		// iterate through all collected parameter instances
		for(EventParameterInstance oParameter : in_colParameters.keySet()) {

			if(oParameter.isReturnParameter()) {
				continue;
			}

			TCGParameter oSuperParam = TCGParameterHelperClass.getSuperParameter(
					oParameter.getParameter());
			
			// the super parameter is not the original parameter and was not used yet
			if(!oSuperParam.equals(oParameter.getParameter()))
			{
				if(!colRealParameter.contains(oSuperParam))
				{
					colRealParameter.add(oSuperParam);
					// print all complex parameters
					m_oFormattedOutput.append(getClassName(oSuperParam.getValueType()) + " ");
					m_oFormattedOutput.appendln(oSuperParam.getName() 
							+ oParameter.getTransitionInstance().getName() + ";");
				}
				// print the referenced attribute properties
				printParameterValue(in_colParameters, oParameter,
						m_oFormattedOutput);
			}
			else
			{
				m_oFormattedOutput.append(getClassName(oParameter.getParameter().getValueType()) + " ");
				printParameterValue(in_colParameters, oParameter,
						m_oFormattedOutput);
			}
		}
	}

	@Override
	public void createLocalEnd() {
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
	}

	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance) {
		createOutput(in_oTransitionInstance, m_oFormattedOutput);
	}

	@Override
	public String getFileType() {
		return ".cpp";
	}

	@Override
	public List<FormattedOutputStream> getFormattedOutputStreams() {
		List<FormattedOutputStream> colOutputs = new ArrayList<FormattedOutputStream>();
		colOutputs.add(m_oFormattedOutput);
		return colOutputs;
	}
}
