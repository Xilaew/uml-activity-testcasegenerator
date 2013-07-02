package net.sf.parteg.output.testgraph.languages;

import java.util.HashSet;
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

public class TestCaseGraphOutputJavaMutantAnalysis extends TestCaseGraphOutputJava {

	public TestCaseGraphOutputJavaMutantAnalysis(TestCaseGraphHelper in_oTCGHelper)
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
		
		// test class
		m_oFormattedOutput.appendln("public class " 
				+ TemporalConfiguration.getClassNameAdaptation(
						Configuration.getTestCaseOutputName()));
		m_oFormattedOutput.openContext();
		
	}

	@Override
	public void createGlobalEnd(TestSuite in_oTestSuite) {
		
		// method signature
		m_oFormattedOutput.newline();
		m_oFormattedOutput.appendln("public static void main(String[] args)");
		m_oFormattedOutput.openContext();
		
		// create object factory
		String sClassName = "";
		for(org.eclipse.uml2.uml.Class oContextClass : Configuration.getStateMachineClassMap().values())
		{
			sClassName = oContextClass.getName();
		}
		m_oFormattedOutput.appendln("int nDetectedFaultCounter = 0;");
		m_oFormattedOutput.appendln("int nMutantCounter = 0;");
		m_oFormattedOutput.appendln("StringBuffer sNotFoundMutants = new StringBuffer();");

		m_oFormattedOutput.appendln(sClassName + "MutantFactory oMutantFactory = new " +
				sClassName + "MutantFactory();");
		m_oFormattedOutput.appendln("for(" + sClassName +
				" " + m_sObjectName + "Global : oMutantFactory.getMutants())");
		m_oFormattedOutput.openContext();
		
		// search for errors
		m_oFormattedOutput.appendln("boolean bFound = false;");
		m_oFormattedOutput.appendln("++nMutantCounter;");
		m_oFormattedOutput.newline();
		
		for(int i = 0; i < m_nTestMethodCounter; ++i) {
			m_oFormattedOutput.appendln("bFound |= runTest"
					+ (i+1) + "(" + m_sObjectName + "Global);");
		}
		
		// found errors?
		m_oFormattedOutput.appendln("if(bFound == true)");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln("++nDetectedFaultCounter;");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.appendln("else");
		m_oFormattedOutput.openContext();
		m_oFormattedOutput.appendln("sNotFoundMutants.append(" + 
				m_sObjectName + "Global.getClass().getName() + ");
		m_oFormattedOutput.appendln("java.lang.System.getProperty(\"line.separator\"));");
		m_oFormattedOutput.closeContext();
		
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
		m_oFormattedOutput.append("java.lang.System.out.println(" +
				"\"found \" + nDetectedFaultCounter + \" of \" + nMutantCounter + \" mutants\");");
		m_oFormattedOutput.append("java.lang.System.out.println(" +
				"\"undetected mutants: \" + " + 
				"java.lang.System.getProperty(\"line.separator\") + sNotFoundMutants.toString());");
				
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
		m_oFormattedOutput.appendln("boolean bFound = false;");
		
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
		m_oFormattedOutput.appendln("return bFound;");
		m_oFormattedOutput.closeContext();
		m_oFormattedOutput.newline();
	}

	@Override
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance)
	{
		getOutputForDNFInTargetNodeOfTransitionInstance(
				in_oTransitionInstance,
				"if(!(", ")) bFound = true;",
				m_oFormattedOutput);
	}
	
	@Override
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition)
	{
		getOutputForConditionInTransitionInstance(
				in_oTransitionInstance, in_oCondition,
				"if(!(", ")) bFound = true;",
				m_oFormattedOutput);

	}

}
