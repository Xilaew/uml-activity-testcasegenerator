package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.valuetypes.BooleanValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.DoubleValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.EnumerationValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.IntegerValueType;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.TypedElement;

public class ValueTypeRangeFactory {

	private static HashMap<String, ValueTypeRange> 
		sm_colTypeNameToValueTypeRange = createValueTypeRangeMapping();
	
	private static HashMap<String, ValueTypeRange> createValueTypeRangeMapping()
	{
		HashMap<String, ValueTypeRange> colTypeNameToValueTypeRange 
			= new LinkedHashMap<String, ValueTypeRange>();
		
		// double
		OrderedValueTypeRange<DoubleValueType> oDoubleValueTypeRange
			= new OrderedValueTypeRange<DoubleValueType>(
					DoubleValueType.getMinimumValue(), true,
					DoubleValueType.getMaximumValue(), true);
		colTypeNameToValueTypeRange.put("double", oDoubleValueTypeRange);
		colTypeNameToValueTypeRange.put("Double", oDoubleValueTypeRange);
		
		// integer
		OrderedValueTypeRange<IntegerValueType> oIntegerValueTypeRange
			= new OrderedValueTypeRange<IntegerValueType>(
					IntegerValueType.getMinimumValue(), true,
					IntegerValueType.getMaximumValue(), true);
		colTypeNameToValueTypeRange.put("int", oIntegerValueTypeRange);
		colTypeNameToValueTypeRange.put("integer", oIntegerValueTypeRange);
		colTypeNameToValueTypeRange.put("Integer", oIntegerValueTypeRange);
		
		// boolean
		EnumerableValueTypeRange<BooleanValueType> oBooleanValueTypeRange
			= new EnumerableValueTypeRange<BooleanValueType>(new BooleanValueType(true));
		colTypeNameToValueTypeRange.put("boolean", oBooleanValueTypeRange);
		colTypeNameToValueTypeRange.put("Boolean", oBooleanValueTypeRange);
		colTypeNameToValueTypeRange.put("bool", oBooleanValueTypeRange);
		
		return colTypeNameToValueTypeRange;
	}

	/*
	 * creates a value type range for an object - assuming that its type is a class
	 */
	public static ValueTypeRange createValueTypeRangeForObject(
			Object in_oObject)
	{
		Object oVTObject = in_oObject;
		if(in_oObject instanceof TCGOCLAtom) {
			EObject oObject = ((TCGOCLAtom)in_oObject).getElement();
			if(oObject instanceof TypedElement) {
				oVTObject = ((TypedElement)oObject).getType();
			}
		}
		// class, enumeration, primitive type, ... 
		if(oVTObject instanceof org.eclipse.uml2.uml.Classifier)
		{
			return createValueTypeRangeForType(
				(org.eclipse.uml2.uml.Classifier)oVTObject);
		}
		return null;
	}

	
	/*
	 * creates a value type range for a given parameter
	 */
	public static ValueTypeRange createValueTypeRangeForParameter(
			TCGParameter in_oParameter)
	{
		EObject oValueType = in_oParameter.getValueType();
		if(oValueType instanceof org.eclipse.uml2.uml.Classifier) {
			return createValueTypeRangeForType(
				(org.eclipse.uml2.uml.Classifier)oValueType);
		}
		return null;
	}
	
//	/*
//	 * creates a value type range for a given class
//	 */
//	public static ValueTypeRange createValueTypeRangeForType(
//			org.eclipse.uml2.uml.Class in_oType)
//	{
//		return createValueTypeRangeForTypeName(in_oType.getName());
//	}
//
//	/*
//	 * creates a value type range for a given class
//	 */
//	public static ValueTypeRange createValueTypeRangeForType(
//			org.eclipse.uml2.uml.Enumeration in_oType)
//	{
//		return createValueTypeRangeForTypeName(in_oType.getName());
//	}

	/*
	 * creates a value type range for a given class
	 */
	public static ValueTypeRange createValueTypeRangeForType(
			Classifier in_oType)
	{
		ValueTypeRange oVTR = sm_colTypeNameToValueTypeRange.get(in_oType.getName());
		if(oVTR == null) {
			// the referenced object is no basic type -> create a new entry
			// ... for enumerations
			List<String> colEnumLiterals = new ArrayList<String>();
			if(in_oType instanceof Enumeration) {
				Enumeration oEnumeration = (Enumeration)in_oType;
				for(EnumerationLiteral oLiteral : oEnumeration.getOwnedLiterals()) {
					colEnumLiterals.add(oLiteral.getName());
				}
				
				EnumerableValueTypeRange<EnumerationValueType> oEnumerationValueTypeRange
					= new EnumerableValueTypeRange<EnumerationValueType>(new EnumerationValueType(colEnumLiterals));
				oVTR = oEnumerationValueTypeRange;
				sm_colTypeNameToValueTypeRange.put(in_oType.getName(), oEnumerationValueTypeRange);
			}		
		}
		if(oVTR == null) {
			return new IndefinableValueTypeRange();
		}
		return oVTR.clone();
	}
	
	
	
	/*
	 * creates a value type range for a given class
	 */
	public static ValueTypeRange createValueTypeRangeForTypeName(
			String in_sTypeName)
	{
		ValueTypeRange oVTR = sm_colTypeNameToValueTypeRange.get(in_sTypeName);
		if(oVTR == null)
			return new IndefinableValueTypeRange();
		return oVTR.clone();
	}
	
}
