package net.sf.parteg.output.testgraph.languages;

import java.util.ArrayList;
import java.util.HashMap;
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
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseGraphOutputJUnit_4_3 extends TestCaseGraphOutputJava {

	public TestCaseGraphOutputJUnit_4_3(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
	}

	public void createGlobalStart(TestSuite in_oTestSuite) {
		m_nTestMethodCounter = 0;
		
		// namespace
		String sPackage = Configuration.getTestFilePackage();
		if(sPackage.length() > 0) {
			m_oFormattedOutput.appendln("package " + sPackage + ";");
			m_oFormattedOutput.newline();
		}
		
		// includes
		m_oFormattedOutput.appendln("import org.junit.*;");
		m_oFormattedOutput.appendln("import static org.junit.Assert.*;");
		m_oFormattedOutput.newline();
		
		// test class
		m_oFormattedOutput.appendln("// JUnit 4.3");
		m_oFormattedOutput.append("public class " 
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()));
		m_oFormattedOutput.openContext();

		// suite
		m_oFormattedOutput.newline();
		m_oFormattedOutput.append("public static junit.framework.Test suite()");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.append("return new junit.framework.JUnit4TestAdapter(" 
				+ Configuration.getTestCaseOutputName() + ".class);");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
	}
	
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		m_oFormattedOutput.closeContext();
	}
	
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) {
		++m_nTestMethodCounter;

		if(m_nTestMethodCounter == 61) {
		}
		
		m_oFormattedOutput.newline();
		
		// method annotation
		m_oFormattedOutput.appendln("@Test");
		
		// method signature
		m_oFormattedOutput.appendln("public void test" + m_nTestMethodCounter + "()");
		m_oFormattedOutput.openContext();
		
		// define tested objects only once per class (later: per predefined instance?)
		List<org.eclipse.uml2.uml.Class> oInstantiatedClasses = new ArrayList<org.eclipse.uml2.uml.Class>();
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values()) {
			if(!oInstantiatedClasses.contains(oContextClass)) {
				oInstantiatedClasses.add(oContextClass);
				m_oFormattedOutput.appendln(oContextClass.getName() 
					+ " " + m_sObjectName + " = new "
					+ oContextClass.getName() + "();");
			}
		}
		
		// collect real parameters - and their sub attributes
		HashMap<TCGParameter, TransitionInstance> colRealParameter = new HashMap<TCGParameter, TransitionInstance>();
		
		// iterate through all collected parameter instances
		for(EventParameterInstance oParameter : in_colParameters.keySet()) {
			
			if(oParameter.isReturnParameter()) {
				continue;
			}
			
			TCGParameter oSuperParam = TCGParameterHelperClass.getSuperParameter(
					oParameter.getParameter());

			// idea: check if super parameters have to be declared:
			// the super parameter is not the original parameter and was not used yet
			// furthermore, both used parameters were used at the same transition instance
			if(!oSuperParam.equals(oParameter.getParameter())) {
				if(!(colRealParameter.get(oSuperParam) != null &&
						colRealParameter.get(oSuperParam).equals(oParameter.getTransitionInstance()))) {
					colRealParameter.put(oSuperParam, oParameter.getTransitionInstance());
					// print all complex parameters
					m_oFormattedOutput.append(getClassName(oSuperParam.getValueType()) + " ");
					m_oFormattedOutput.appendln(oSuperParam.getName() 
							+ oParameter.getTransitionInstance().getName() + " = new " + 
							getClassName(oSuperParam.getValueType()) + "();");
				}
				// print the referenced attribute properties
				printParameterValue(in_colParameters, oParameter);
			}
			else
			{
				m_oFormattedOutput.append(getClassName(oParameter.getParameter().getValueType()) + " ");
				printParameterValue(in_colParameters, oParameter);
			}
		}
	}

	
	public void createLocalEnd() {
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance)
	{
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"assertEquals(true, ", ");",
				m_oFormattedOutput);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition)
	{
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"assertEquals(true, ", ");",
				m_oFormattedOutput);
	}
}
