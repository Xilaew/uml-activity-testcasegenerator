package net.sf.parteg.output.testgraph.languages;

import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionIterator;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeTCGOCLAtomCollectorVisitor;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public abstract class TestCaseGraphOutputJava extends TestCaseGraphOutputOO {


	public TestCaseGraphOutputJava(TestCaseGraphHelper in_oTCGHelper)
	{
		super(in_oTCGHelper);
		m_oConverter = new OCLExpressionConverterJava();
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
			}
			else
				sValue = "new " + getClassName(in_oParameter.getParameter().getValueType()) + " ()";
			
			m_oFormattedOutput.appendln(
					TCGParameterHelperClass.getFullParameterInstanceAttributeName(in_oParameter)
					 + " = " + sValue + ";");	
		}
	}
	
	@Override
	public void createOutput(TransitionInstance in_oTransitionInstance)
	{
		createOutput(in_oTransitionInstance, m_oFormattedOutput);
	}

	
	protected void createOutput(
			TransitionInstance in_oTransitionInstance,
			FormattedOutput in_oFormattedOutput)
	{
		// write expressions for the used preconditions of this test case
		for(TCGOCLExpression oExpression : in_oTransitionInstance.getUsedPreConditions())
		{
			if(oExpression != null) {
				// only write non-complex guard conditions - complex ones can be violated
				OCLTreeTCGOCLAtomCollectorVisitor oAtomCollector =
					new OCLTreeTCGOCLAtomCollectorVisitor();
				OCLTreeExpressionIterator.run(oExpression, oAtomCollector);
				int nActiveAtomCounter = 0;
				for(TCGOCLAtom oExpAtom : oAtomCollector.getExpressions()) {
					if(!oExpAtom.getClassification().equals(VariableClassification.INDEPENDENT)) {
						++nActiveAtomCounter;
					}
				}

				if(nActiveAtomCounter < 2) {
					getOutputForConditionInTransitionInstance(
						in_oTransitionInstance, oExpression);
				}
				else { // tmp - to check the violated conditions
					getOutputForConditionInTransitionInstance(
							in_oTransitionInstance, oExpression,
							"//assertEquals(true, ", ");",
							m_oFormattedOutput);
				}
			}
		}
		
		// handle methods event
		TCGEvent oEvent = in_oTransitionInstance.getCalledEvent();
		if(oEvent != null && isEventPrintingAllowed(oEvent))
		{
			String sEvent = oEvent.getName();
			// no default call
			if(sEvent.length() > 0) {
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
	protected String getTypeNameAccessFunction(
			String in_oTypeString) {
		
		if(in_oTypeString.equals("Integer"))
			return ".intValue()";
		if(in_oTypeString.equals("Boolean"))
			return ".booleanValue()";
		return "";
	}	

	@Override
	public String getFileType() {
		return ".java";
	}

//	@Override
//	public String getValueString(LiteralExp in_oLiteralExp)
//	{
//		if(in_oLiteralExp instanceof EnumLiteralExp){
//			EnumLiteralExp oExp = (EnumLiteralExp)in_oLiteralExp;
//			return TestCaseGraphHelper.getFullEnumerationLiteralName(oExp.getReferredEnumLiteral());
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
