package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class OCLExpressionValueTypeRangeFactory {

//	public static ArrayList<ValueTypeRange> getValueTypeRangesForRightSideOfExpression(
//			TCGOCLExpression in_oExpression)
//	{
//		ArrayList<ValueTypeRange> colValueRanges = new ArrayList<ValueTypeRange>();
//		if((in_oExpression instanceof TCGOCLOperation) &&
//				(((TCGOCLOperation)in_oExpression).getOperationName().equals("<>")))
//		{
//			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
//			oOperation.setOperationName("<");
//			colValueRanges.add(getValueTypeRangeForRightSideOfExpression(oOperation));
//			oOperation.setOperationName(">");
//			colValueRanges.add(getValueTypeRangeForRightSideOfExpression(oOperation));
//			oOperation.setOperationName("<>");
//		}
//		else
//		{
//			colValueRanges.add(getValueTypeRangeForRightSideOfExpression(in_oExpression));			
//		}
//		return colValueRanges;
//	}
	
	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			TCGOCLExpression in_oExpression)
	{
		try {
			
			List<TCGOCLAtom> colAtoms = TCGOCLExpressionHelperClass.
				getDependentVariableOrInputParameter(in_oExpression);
			
			// exactly one dependent or input parameter
			if(colAtoms.size() == 1)
				return getValueTypeRangeForRightSideOfExpression(
					colAtoms.get(0), in_oExpression);
			
			// no dependent parameter -> this is a constant / independent expression!
			if(colAtoms.size() == 0) {
//				throw new Exception("value range computation for constants not supported yet");
			}
			else
				return null;
		}
		catch(Exception e) {
			Configuration.handleException(e);
		}
		return null;
	}
	
	
	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			TCGOCLAtom in_oAtom,
			TCGOCLExpression in_oExpression) {
		
		ValueTypeRange oVTR = ValueTypeRangeFactory.
		createValueTypeRangeForObject(in_oAtom);
	
		if(oVTR == null) {
//			oVTR = ValueTypeRangeFactory.createValueTypeRangeForObject(oObject);
			System.err.println("error in creating value type range");
		}
	
		return getValueTypeRangeForRightSideOfExpression(
			oVTR, in_oExpression);
	}
	
	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			TCGParameter in_oParameter,
			TCGOCLExpression in_oExpression) 
	{
		ValueTypeRange oVTR = ValueTypeRangeFactory.
			createValueTypeRangeForParameter(in_oParameter);
		oVTR = getValueTypeRangeForRightSideOfExpression(
				oVTR, in_oExpression);
		if(!oVTR.isEmpty())
			return oVTR;
		return null;
	}
	
	
	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			ValueTypeRange in_oValueTypeRange,
			TCGOCLExpression in_oExpression)
	{
		try {
			in_oValueTypeRange.setRangeAccordingToRightSideOfExpression(
					in_oExpression);
			return in_oValueTypeRange;
		}
		catch (Exception e) {
			Configuration.handleException(e);
		}
		return null;
	}

	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			ValueTypeRange in_oValueTypeRange,
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) {
		try {
			in_oValueTypeRange.setRangeAccordingToRightSideOfExpression(
					in_oExpression, in_colCurrentValueAssignment);
			return in_oValueTypeRange;
		}
		catch (Exception e) {
			Configuration.handleException(e);		
		}
		return null;
	}
	
	
	public static ValueTypeRange getValueTypeRangeForRightSideOfExpression(
			ValueTypeRange in_oValueTypeRange,
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentTypeRanges) {
		try {
			in_oValueTypeRange.setRangeAccordingToRightSideOfExpression(
					in_oExpression, in_colCurrentValueAssignment, in_colCurrentTypeRanges);
//			in_oValueTypeRange.setRangeAccordingToRightSideOfExpression(
//					in_oExpression);
			return in_oValueTypeRange;
		}
		catch (Exception e) {
			Configuration.handleException(e);
		}
		return null;
	}	
}
