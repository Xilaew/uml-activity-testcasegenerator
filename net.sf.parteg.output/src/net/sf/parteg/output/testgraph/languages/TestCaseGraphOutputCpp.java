package net.sf.parteg.output.testgraph.languages;

import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public abstract class TestCaseGraphOutputCpp extends TestCaseGraphOutputOO {

	public TestCaseGraphOutputCpp(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
		m_oConverter = new OCLExpressionConverterJava();
	}

	protected void printParameterValue(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters,
			EventParameterInstance in_oParameter,
			FormattedOutput in_oFormattedOutput)
	{
		if(!in_oParameter.isReturnParameter()) {
			TestCaseValidValue oValue = in_colParameters.get(in_oParameter);
			String sValue = null;
			if(oValue != null)
				sValue = oValue.getValue();
			else
				sValue = getClassName(in_oParameter.getParameter().getValueType()) + " ()";
			
			in_oFormattedOutput.appendln(
					TCGParameterHelperClass.getFullParameterInstanceAttributeName(in_oParameter)
					 + " = " + sValue + ";");			
		}
	}

	protected void createOutput(
			TransitionInstance in_oTransitionInstance,
			FormattedOutput in_oFormattedOutput)
	{
		// write expressions for the used preconditions of this test case
		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPreConditions())
		{
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
				in_oFormattedOutput.append(m_sObjectName + "." 
						+ sEvent + "(");
				List<TCGParameter> oParamList = 
					TCGParameterHelperClass.copyAllButReturnValues(oEvent.getParameters());
				String sNameSuffix = TCGParameterHelperClass.findTransitionInstanceDefiningTheCurrentEvent(
						in_oTransitionInstance).getName();
				boolean bIsNotFirstElement = false;
				for(TCGParameter oParameter : oParamList)
				{
					if(bIsNotFirstElement)
						in_oFormattedOutput.append(", ");
					in_oFormattedOutput.append(oParameter.getName() + sNameSuffix);
					bIsNotFirstElement = true;
				}
				in_oFormattedOutput.appendln(");");
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
	
	protected String getTestMethodName(int in_nCounter)
	{
		return "test" + in_nCounter;
	}

//	public String getValueString(LiteralExp in_oLiteralExp)
//	{
//		if(in_oLiteralExp instanceof EnumLiteralExp){
//			EnumLiteralExp oExp = (EnumLiteralExp)in_oLiteralExp;
//			return TestCaseGraphHelper.getFullEnumerationLiteralName(oExp.getReferredEnumLiteral());
//			//return oExp.getReferredEnumLiteral().getName();
//		}
//		else if(in_oLiteralExp instanceof IntegerLiteralExp) {
//			IntegerLiteralExp oExp = (IntegerLiteralExp)in_oLiteralExp;
//			return oExp.getIntegerSymbol().toString();			
//		}
//		else if(in_oLiteralExp instanceof BooleanLiteralExp) {
//			BooleanLiteralExp oExp = (BooleanLiteralExp)in_oLiteralExp;
//			return oExp.getBooleanSymbol().toString();			
//		}
//		return "";
//	}
}
