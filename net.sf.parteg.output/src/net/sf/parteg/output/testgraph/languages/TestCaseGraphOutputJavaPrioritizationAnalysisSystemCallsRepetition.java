package net.sf.parteg.output.testgraph.languages;

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
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseGraphOutputJavaPrioritizationAnalysisSystemCallsRepetition extends TestCaseGraphOutputJava {

	public TestCaseGraphOutputJavaPrioritizationAnalysisSystemCallsRepetition(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
	}
	
	@Override
	public void createGlobalStart(TestSuite in_oTestSuite) {
		m_nTestMethodCounter = 0;
		
		// namespace
		String sPackage = Configuration.getTestFilePackage();
		if(sPackage.length() > 0)
		{
			m_oFormattedOutput.appendln("package " + sPackage + ";");
			m_oFormattedOutput.newline();
		}
		
		m_oFormattedOutput.appendln("import java.util.ArrayList;");
		m_oFormattedOutput.appendln("import java.util.List;");
		m_oFormattedOutput.newline();
		
		// test class
		m_oFormattedOutput.appendln("public class " 
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()));
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln("private static int m_nSystemCallCounter = 0;");

	}

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		
		// method signature
		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("public static List<Double> main()");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln("m_nSystemCallCounter = 0;");
		m_oFormattedOutput.appendln("List<Double> colRetValue = new ArrayList<Double>();");

		// create object factory
		String sClassName = "";
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			sClassName = oContextClass.getName();
		}
		m_oFormattedOutput.appendln("ArrayList<Integer> m_colTestCaseToFirstMutantKills = new ArrayList<Integer>();");
		m_oFormattedOutput.appendln("ArrayList<Integer> m_colTestCaseToAbsoluteMutantKills = new ArrayList<Integer>();");
		m_oFormattedOutput.appendln("int nDetectedFaultCounter = 0;");
		m_oFormattedOutput.appendln("int nMutantCounter = 0;");
		m_oFormattedOutput.appendln("int nCurrentSystemCallCounter = 0;");
		m_oFormattedOutput.appendln("double nSystemCallCounterPerMutant = 0.0;");
		m_oFormattedOutput.appendln("double nSystemCallCounterPerDetectedMutant = 0.0;");
//		m_oFormattedOutput.appendln("StringBuffer sNotFoundMutants = new StringBuffer();");

		m_oFormattedOutput.appendln(sClassName + "MutantFactory oMutantFactory = new " +
				sClassName + "MutantFactory();");
		m_oFormattedOutput.appendln("for(int i = 0; i < " + m_nTestMethodCounter + "; ++i)");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln("m_colTestCaseToFirstMutantKills.add(0);");
		m_oFormattedOutput.append("m_colTestCaseToAbsoluteMutantKills.add(0);");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();

		m_oFormattedOutput.appendln("for(" + sClassName +
				" " + m_sObjectName + "Global : oMutantFactory.getMutants())");
		m_oFormattedOutput.openContext();
		
		// search for errors
		m_oFormattedOutput.appendln("boolean bFound = false;");
		m_oFormattedOutput.appendln("++nMutantCounter;");
		m_oFormattedOutput.appendln("m_nSystemCallCounter = 0;");
		m_oFormattedOutput.appendln("nCurrentSystemCallCounter = 0;");
		m_oFormattedOutput.newline();
		
		for(int i = 0; i < m_nTestMethodCounter; ++i) {
			m_oFormattedOutput.appendln("if(runTest" + (i+1) + "(" + m_sObjectName + "Global)) ");
			m_oFormattedOutput.openContext();
			m_oFormattedOutput.appendln("if(bFound == false)");
			m_oFormattedOutput.openContext();
			m_oFormattedOutput.appendln("m_colTestCaseToFirstMutantKills.set(" + (i) + ", "
					+ "m_colTestCaseToFirstMutantKills.get(" + (i) + ") + 1);");
			m_oFormattedOutput.appendln("++nDetectedFaultCounter;");
			m_oFormattedOutput.append("nCurrentSystemCallCounter = m_nSystemCallCounter;");
			m_oFormattedOutput.closeContext();
			m_oFormattedOutput.newline();
			m_oFormattedOutput.appendln("bFound = true;");
			m_oFormattedOutput.append("m_colTestCaseToAbsoluteMutantKills.set(" + (i) + ", "
					+ "m_colTestCaseToAbsoluteMutantKills.get(" + (i) + ") + 1);");
			m_oFormattedOutput.closeContext();
			m_oFormattedOutput.newline();
		}
		
		// found errors?
		m_oFormattedOutput.appendln("nSystemCallCounterPerDetectedMutant += (double)nCurrentSystemCallCounter;");
//		m_oFormattedOutput.appendln("if(bFound == false)");
//		m_oFormattedOutput.openContext();
//		m_oFormattedOutput.appendln("sNotFoundMutants.append(" + 
//				m_sObjectName + "Global.getClass().getName() + ");
//		m_oFormattedOutput.append("System.getProperty(\"line.separator\"));");
//		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
		
//		m_oFormattedOutput.appendln("System.out.println(\"### number of mutants detected by which test case (first -- absolute):\");");
		m_oFormattedOutput.appendln("double nTestRunsToFirstDetection = 0.0;"); 
		m_oFormattedOutput.appendln("for(Integer i = 0; i < " + m_nTestMethodCounter + "; ++i)");
		m_oFormattedOutput.openContext();
//		m_oFormattedOutput.appendln("System.out.println(\"mutants of test case \" + (i+1) + \": \""
//				+ " + m_colTestCaseToFirstMutantKills.get(i) + \" -- \" + m_colTestCaseToAbsoluteMutantKills.get(i)"
//				+ ");");
		m_oFormattedOutput.append("nTestRunsToFirstDetection += (double)m_colTestCaseToFirstMutantKills.get(i) * (i+1);");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("double nTestRunsPerMutant = nTestRunsToFirstDetection;"); 
		m_oFormattedOutput.appendln("nTestRunsPerMutant += (nMutantCounter - nDetectedFaultCounter) * " + m_nTestMethodCounter + ";");
		m_oFormattedOutput.appendln("nTestRunsPerMutant /= (double)nMutantCounter;");
		m_oFormattedOutput.appendln("nTestRunsToFirstDetection /= (double)nDetectedFaultCounter;");
		// average test runs to first detection
		m_oFormattedOutput.appendln("colRetValue.add(nTestRunsToFirstDetection);");
//		m_oFormattedOutput.appendln("System.out.println(\"average test runs until first detection: \" + nTestRunsToFirstDetection);");
		// average test runs per mutant
		m_oFormattedOutput.appendln("colRetValue.add(nTestRunsPerMutant);");
//		m_oFormattedOutput.appendln("System.out.println(\"average test runs per mutant: \" + nTestRunsPerMutant);");
		m_oFormattedOutput.appendln("nSystemCallCounterPerMutant = nSystemCallCounterPerDetectedMutant;");
		m_oFormattedOutput.appendln("nSystemCallCounterPerMutant += (nMutantCounter - nDetectedFaultCounter) * m_nSystemCallCounter;");
		m_oFormattedOutput.appendln("nSystemCallCounterPerMutant /= (double)nMutantCounter;");
		m_oFormattedOutput.appendln("nSystemCallCounterPerDetectedMutant /= (double)nDetectedFaultCounter;");
		// average system calls until first detection
		m_oFormattedOutput.appendln("colRetValue.add(nSystemCallCounterPerDetectedMutant);");
//		m_oFormattedOutput.appendln("System.out.println(\"average system calls until first detection: \" + nSystemCallCounterPerDetectedMutant);");
		// average system calls per mutant
		m_oFormattedOutput.appendln("colRetValue.add(nSystemCallCounterPerMutant);");
//		m_oFormattedOutput.appendln("System.out.println(\"average system calls per mutant: \" + nSystemCallCounterPerMutant);");
		m_oFormattedOutput.newline();
		
		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("colRetValue.add((double)nDetectedFaultCounter);");
		m_oFormattedOutput.appendln("return colRetValue;");
//		m_oFormattedOutput.appendln("System.out.println(" +
//				"\"found \" + nDetectedFaultCounter + \" of \" + nMutantCounter + \" mutants\");");
//		m_oFormattedOutput.append("System.out.println(" +
//				"\"undetected mutants: \" + " + 
//				"System.getProperty(\"line.separator\") + sNotFoundMutants.toString());");
				
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
		m_oFormattedOutput.closeContext();
	}

	@Override
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters) 
	{
		++m_nTestMethodCounter;
		String sClassName = "";
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			sClassName = oContextClass.getName();
		}

		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("// test number " + m_nTestMethodCounter);
		m_oFormattedOutput.appendln("public static boolean runTest"
				+ m_nTestMethodCounter + "(" + sClassName 
				+ " in_oMutant)");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln(sClassName + " " + m_sObjectName + " = " +
				"in_oMutant.clone();");
		
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

	@Override
	public void createLocalEnd() {
		m_oFormattedOutput.appendln("return false;");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance)
	{
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"if(!(", ")) return true;",
				m_oFormattedOutput);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition)
	{
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"if(!(", ")) return true;",
				m_oFormattedOutput);

	}

	protected void createOutput(
			TransitionInstance in_oTransitionInstance,
			FormattedOutput in_oFormattedOutput)
	{
		// write expressions for the used preconditions of this test case
		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPreConditions()) {
			if(oExpression != null)
				getOutputForConditionInTransitionInstance(
						in_oTransitionInstance, oExpression);			
		}
		
		// handle methods event
		TCGEvent oEvent = in_oTransitionInstance.getCalledEvent();
		if(oEvent != null && isEventPrintingAllowed(oEvent))
		{
			String sEvent = oEvent.getName(); 
			if(sEvent.length() > 0)
			{
				in_oFormattedOutput.append(m_sObjectName + "." + m_sEventCallName +
						"(\"" + sEvent + "\"");
				List<TCGParameter> oParamList = 
					TCGParameterHelperClass.copyAllButReturnValues(oEvent.getParameters());

				String sNameSuffix = TCGParameterHelperClass.findTransitionInstanceDefiningTheCurrentEvent(
						in_oTransitionInstance).getName();
				for(TCGParameter oParameter : oParamList)
				{
					in_oFormattedOutput.append(", " + oParameter.getName() + sNameSuffix);
				}
				in_oFormattedOutput.appendln(");");
				in_oFormattedOutput.appendln("++m_nSystemCallCounter;");
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
	
}
