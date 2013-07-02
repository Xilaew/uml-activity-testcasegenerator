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

public class TestCaseGraphOutputCppUnit_1_12 extends TestCaseGraphOutputCpp {

	protected FormattedOutputStream m_oFormattedOutputHeader;
	protected FormattedOutputStream m_oFormattedOutputMethods;
	
	@SuppressWarnings("null")
	public TestCaseGraphOutputCppUnit_1_12(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
		m_oFormattedOutputHeader = new FormattedOutputStream();
		m_oFormattedOutputMethods = new FormattedOutputStream();
		Object o = null;
		o.toString();
		// fails! should fail because the print operation is not working correctly!
		// Adapt it to Cpp output format! -> Separation in header and cpp
	}
	
	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		m_nTestMethodCounter = 0;
		
		
		m_oFormattedOutputHeader.appendln("#ifndef " + Configuration.getTestCaseOutputName());
		m_oFormattedOutputHeader.appendln("#define " + Configuration.getTestCaseOutputName());
		m_oFormattedOutputHeader.newline();
		
		// include test framework
		m_oFormattedOutputHeader.appendln("#include <cppunit/TestFixture.h>");
		m_oFormattedOutputHeader.appendln("#include <cppunit/extensions/HelperMacros.h>");
		
		// include tested classes
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			m_oFormattedOutputHeader.appendln("#include <" + 
					TemporalConfiguration.getClassNameAdaptation(
							oContextClass.getName()) + ".h>"); 
		}

		m_oFormattedOutputHeader.newline();
		m_oFormattedOutputHeader.appendln("using namespace std;");
		
		// test class
		m_oFormattedOutputHeader.appendln("// CppUnit 1.12.0");
		m_oFormattedOutputHeader.append("class " 
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName())
				+ " : public CPPUNIT_NS::TestFixture");
		m_oFormattedOutputHeader.openContext();

		// suite
		m_oFormattedOutputHeader.newline();
		m_oFormattedOutputHeader.appendln("CPPUNIT_TEST_SUITE ("
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + ");");
	}
	
	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		for(int i = 1; i <= m_nTestMethodCounter; ++i)
		{
			m_oFormattedOutputHeader.appendln("CPPUNIT_TEST (" 
					+ getTestMethodName(i) + ");");
		}
		m_oFormattedOutputHeader.appendln("CPPUNIT_TEST_SUITE_END ();");
		m_oFormattedOutputHeader.newline();
		
		// method headers
		m_oFormattedOutputHeader.increaseIndent();
		m_oFormattedOutputHeader.appendln("protected:");
		for(int i = 1; i <= m_nTestMethodCounter; ++i)
		{
			m_oFormattedOutputHeader.appendln("void "
					+ getTestMethodName(i) + "();");
		}		
		m_oFormattedOutputHeader.decreaseIndent();
		
		m_oFormattedOutputHeader.closeContext();
		m_oFormattedOutputHeader.appendln(";");
		m_oFormattedOutputHeader.newline();
		
		// reunite both formatted outputs
		StringBuffer oBuffer = m_oFormattedOutputHeader.getStringBuffer();
		oBuffer.append(m_oFormattedOutputMethods.getStringBuffer());
		m_oFormattedOutput.setStringBuffer(oBuffer);
		
		m_oFormattedOutputHeader.newline();
		m_oFormattedOutput.appendln("#endif");
	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		++m_nTestMethodCounter;
		m_oFormattedOutputMethods.newline();
		
		// method signature
		m_oFormattedOutputMethods.appendln("void "
				+ Configuration.getTestCaseOutputName()
				+ "::"
				+ getTestMethodName(m_nTestMethodCounter) + "()");
		m_oFormattedOutputMethods.openContext();
		
		// define tested objects
		List<org.eclipse.uml2.uml.Class> oInstantiatedClasses = new ArrayList<org.eclipse.uml2.uml.Class>();
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			if(!oInstantiatedClasses.contains(oContextClass)) {
				oInstantiatedClasses.add(oContextClass);
				m_oFormattedOutputMethods.appendln(oContextClass.getName() 
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
					m_oFormattedOutputMethods.append(getClassName(oSuperParam.getValueType()) + " ");
					m_oFormattedOutputMethods.appendln(oSuperParam.getName() 
							+ oParameter.getTransitionInstance().getName() + ";");
				}
				// print the referenced attribute properties
				printParameterValue(in_colParameters, oParameter,
						m_oFormattedOutputMethods);
			}
			else
			{
				m_oFormattedOutputMethods.append(getClassName(oParameter.getParameter().getValueType()) + " ");
				printParameterValue(in_colParameters, oParameter,
						m_oFormattedOutputMethods);
			}
		}
	}

	@Override
	public void createLocalEnd() {
		m_oFormattedOutputMethods.closeContext();
		m_oFormattedOutputMethods.newline();
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance)
	{
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"CPPUNIT_ASSERT_EQUAL(true, ", ");",
				m_oFormattedOutputMethods);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition)
	{
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"CPPUNIT_ASSERT_EQUAL(true, ", ");",
				m_oFormattedOutputMethods);
	}	
	
	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance) {
		createOutput(in_oTransitionInstance, m_oFormattedOutputMethods);
	}

	@Override
	protected String getTypeNameAccessFunction(String in_oTypeString) {
		return "";
	}

	@Override
	public String getFileType() {
		return ".cpp";
	}

	@Override
	public List<FormattedOutputStream> getFormattedOutputStreams() {
		List<FormattedOutputStream> colOutputs = new ArrayList<FormattedOutputStream>();
		colOutputs.add(m_oFormattedOutput);
		colOutputs.add(m_oFormattedOutputHeader);
		colOutputs.add(m_oFormattedOutputMethods);
		return colOutputs;
	}
}
