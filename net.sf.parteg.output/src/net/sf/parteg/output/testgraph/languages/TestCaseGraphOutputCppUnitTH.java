package net.sf.parteg.output.testgraph.languages;

import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.TemporalConfiguration;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseGraphOutputCppUnitTH extends TestCaseGraphOutputCpp {

	public TestCaseGraphOutputCppUnitTH(TestCaseGraphHelper in_oTCGHelper) 
	{
		super(in_oTCGHelper);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance,
			TCGOCLExpression in_oCondition) {
		// nothing ... the code is all in the .cpp
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance) {
		// nothing ... the code is all in the .cpp
	}

	@Override
	protected String getTypeNameAccessFunction(String in_oTypeString) {
		return "";
	}

	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		m_nTestMethodCounter = 0;
		
		m_oFormattedOutput.appendln("#ifndef " + 
				TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + "_H");
		m_oFormattedOutput.appendln("#define " + 
				TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + "_H");
		m_oFormattedOutput.newline();
		
		m_oFormattedOutput.appendln("#include <cppunit/extensions/HelperMacros.h>");
		m_oFormattedOutput.appendln("#include <cppunit/config/SourcePrefix.h>");
		m_oFormattedOutput.appendln("#include <cppunit/CompilerOutputter.h>");
		m_oFormattedOutput.appendln("#include <cppunit/extensions/TestFactoryRegistry.h>");
		m_oFormattedOutput.appendln("#include <cppunit/ui/text/TestRunner.h>");
		m_oFormattedOutput.appendln("#include <string>");

		m_oFormattedOutput.newline();
		
		// include tested classes
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			m_oFormattedOutput.appendln("#include \"" + oContextClass.getName() + ".h\""); 
		}

		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("using namespace std;");
		
		
		// test class
		m_oFormattedOutput.appendln("// CppUnit 1.12.0");
		m_oFormattedOutput.append("class " 
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName())
				+ " : public CPPUNIT_NS::TestFixture");
		m_oFormattedOutput.openContext();

		// suite
		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("CPPUNIT_TEST_SUITE ("
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + ");");
	}

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		for(int i = 1; i <= m_nTestMethodCounter; ++i) {
			m_oFormattedOutput.appendln("CPPUNIT_TEST (" 
					+ getTestMethodName(i) + ");");
		}
		m_oFormattedOutput.appendln("CPPUNIT_TEST_SUITE_END ();");
		m_oFormattedOutput.newline();
		
		// method headers
		m_oFormattedOutput.increaseIndent();
		m_oFormattedOutput.appendln("protected:");
		for(int i = 1; i <= m_nTestMethodCounter; ++i) {
			m_oFormattedOutput.appendln("void "
					+ getTestMethodName(i) + "();");
		}		
		m_oFormattedOutput.decreaseIndent();
		
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.appendln(";");
		m_oFormattedOutput.newline();
		
		m_oFormattedOutput.appendln("CPPUNIT_TEST_SUITE_REGISTRATION("
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()) + ");");
		
		m_oFormattedOutput.newline();

		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("#endif");	
	}


	@Override
	public void createLocalEnd() {
		// nothing ... the code is all in the .cpp
	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		// just increase the method counter
		++m_nTestMethodCounter;
	}

	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance) {
		// nothing ... the code is all in the .cpp
	}

	@Override
	public String getFileType() {
		return ".h";
	}
}
