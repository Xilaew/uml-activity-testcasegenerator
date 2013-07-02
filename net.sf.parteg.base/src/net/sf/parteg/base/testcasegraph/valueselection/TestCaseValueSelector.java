package net.sf.parteg.base.testcasegraph.valueselection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.testgeneration.LateEvaluationGroup;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.valuetyperanges.EnumerableValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.OrderedValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetypes.OrderedValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public abstract class TestCaseValueSelector {

	// only at boundaries: no random values 
	private boolean m_bSelectValuesOnlyAtBoundaries;
	// at absolute values: select values at the absolute minima and maxima
	private boolean m_bSelectValuesAlsoAtAbsoluteBoundaries;
	
	public TestCaseValueSelector(
			boolean in_bSelectValuesOnlyAtBoundaries,
			boolean in_bSelectValuesAlsoAtAbsoluteBoundaries)
	{
		m_bSelectValuesOnlyAtBoundaries = 
			in_bSelectValuesOnlyAtBoundaries;
		m_bSelectValuesAlsoAtAbsoluteBoundaries =
			in_bSelectValuesAlsoAtAbsoluteBoundaries;
	}
	
	public boolean getSelectValuesOnlyAtBoundaries() {
		return m_bSelectValuesOnlyAtBoundaries;
	}

	public boolean getSelectValuesAlsoAtAbsoluteBoundaries() {
		return m_bSelectValuesAlsoAtAbsoluteBoundaries;
	}

	public ArrayList<TestCaseValidValue> selectValues(
			ValueTypeRange in_oValueRange)
	{
		ArrayList<TestCaseValidValue> out_colValues = new ArrayList<TestCaseValidValue>();
		
		if(in_oValueRange instanceof OrderedValueTypeRange)
		{
			OrderedValueTypeRange<?> oValueRange = (OrderedValueTypeRange<?>)in_oValueRange;
			// TODO Refactoring: introduce complex value types or "NoValueType"
			// no value range defined: define at least a null value
			if(oValueRange == null)
			{
				out_colValues.add(null);
			}
			// minimum boundary is less or equal the maximum boundary
			else if(oValueRange.getMinValue().compareTo(oValueRange.getMaxValue()) <= 0)
			{
				// both values equal -> only one value possible?
				if(oValueRange.getMinValue().compareTo(oValueRange.getMaxValue()) == 0)
				{
					// both values must include the value -> else no concrete value is possible  
					if((oValueRange.isMinIncluded() == true) && 
						(oValueRange.isMaxIncluded() == true)) {
						out_colValues.add(new TestCaseValidValue(oValueRange.getMinValue().toString()));
					}
				}
				// distance between boundaries too small?
				else if(oValueRange.getMinValue().getUpperValueMinDistance().equals(oValueRange.getMaxValue()))
				{
					if(oValueRange.isMinIncluded()) {
						out_colValues.add(new TestCaseValidValue(oValueRange.getMinValue().toString()));
					}
					if(oValueRange.isMaxIncluded()) {
						out_colValues.add(new TestCaseValidValue(oValueRange.getMaxValue().toString()));
					}
				}
				// distance between boundaries too small?
				else if(oValueRange.getMinValue().getUpperValueMinDistance().equals(
						oValueRange.getMaxValue().getLowerValueMinDistance()))
				{
					if(oValueRange.isMinIncluded()) {
						out_colValues.add(new TestCaseValidValue(oValueRange.getMinValue().toString()));
					}
					if(oValueRange.isMaxIncluded()) {
						out_colValues.add(new TestCaseValidValue(oValueRange.getMaxValue().toString()));
					}
					if(!oValueRange.isMinIncluded() && !oValueRange.isMaxIncluded()) {
						out_colValues.add(new TestCaseValidValue(
								oValueRange.getMaxValue().getLowerValueMinDistance().toString()));
					}
				}
				// standard behavior
				else
				{
					selectValuesForValidDomain(out_colValues, oValueRange);
				}
			}
		}
		else if(in_oValueRange instanceof EnumerableValueTypeRange) {
			EnumerableValueTypeRange<?> oEnumerableVTR = (EnumerableValueTypeRange<?>)in_oValueRange;
			out_colValues.add(new TestCaseValidValue(
					oEnumerableVTR.getValidRandomValue().toString()));
		}
		return out_colValues;
	}
	
	protected abstract void selectValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oValueRange);
	
	
	public static void addRandomValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oValueRange)
	{
		ValueType oValue = in_oValueRange.getValidRandomValue();
		io_colValues.add(new TestCaseValidValue(oValue.toString()));		
	}
	
	public void addBoundaryValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oVTRange)
	{
		if(in_oVTRange instanceof OrderedValueTypeRange)
		{
			OrderedValueTypeRange<?> oVTRange = (OrderedValueTypeRange<?>) in_oVTRange;
			
			// if only boundary values are of interest but there are no boundaries -> one random value
			if(m_bSelectValuesOnlyAtBoundaries &&
					(oVTRange.getMinValue().isMinimum() && oVTRange.isMinIncluded() &&
					(oVTRange.getMaxValue().isMaximum() && oVTRange.isMaxIncluded()))) {
				ValueType oRndValue = oVTRange.getValidRandomValue();				
				io_colValues.add(new TestCaseValidValue(oRndValue.toString()));				
			}
			// random values: only if random values are allowed or no boundary exists
			else if(!m_bSelectValuesOnlyAtBoundaries ||
					(oVTRange.getMinValue().isMinimum() && oVTRange.isMinIncluded() &&
							(oVTRange.getMaxValue().isMaximum() && oVTRange.isMaxIncluded()))) {
				for(int i = 0; i < Configuration.getNumberOfRandomElementsPerDomain(); ++i) {
					ValueType oRndValue = oVTRange.getValidRandomValue();				
					io_colValues.add(new TestCaseValidValue(oRndValue.toString()));
				}
			}
			
			if(!(oVTRange.getMinValue().isMinimum() && oVTRange.isMinIncluded() &&
					(oVTRange.getMaxValue().isMaximum() && oVTRange.isMaxIncluded()))) {
				// add value for lower boundary (only if it is not the absolute minimum)
				if(m_bSelectValuesAlsoAtAbsoluteBoundaries ||
						!(oVTRange.getMinValue().isMinimum() && oVTRange.isMinIncluded())) {
					if(oVTRange.isMinIncluded())
					{
						io_colValues.add(
							new TestCaseValidValue(
								oVTRange.getMinValue().toString()));
					}
					else
					{
						OrderedValueType oTmp = oVTRange.getMinValue().getUpperValueMinDistance();
						io_colValues.add(new TestCaseValidValue(oTmp.toString()));
					}
//					if(!m_bSelectValuesOnlyAtBoundaries &&
//							oVTRange.getMaxValue().isMaximum()) {
//						ValueType oTmp = oVTRange.getValidRandomValue();				
//						io_colValues.add(new TestCaseValidValue(oTmp.toString()));
//					}
				}				
				
				// add value for upper boundary (only if it is not the absolute maximum)
				if(m_bSelectValuesAlsoAtAbsoluteBoundaries ||
						!(oVTRange.getMaxValue().isMaximum() && oVTRange.isMaxIncluded())) {
					if(oVTRange.isMaxIncluded())
					{
						io_colValues.add(new TestCaseValidValue(oVTRange.getMaxValue().toString()));
					}
					else
					{
						OrderedValueType oTmp = oVTRange.getMaxValue().getLowerValueMinDistance();
						io_colValues.add(new TestCaseValidValue(oTmp.toString()));
					}
//					if(!m_bSelectValuesOnlyAtBoundaries &&
//							oVTRange.getMinValue().isMinimum()) {
//						ValueType oTmp = oVTRange.getValidRandomValue();				
//						io_colValues.add(new TestCaseValidValue(oTmp.toString()));
//					}
				}
			}
		}
	}
	
	public static List<Map<EventParameterInstance, TestCaseValidValue>> 
	createDynamicValuesForLateParameterInstanceValues(
		LateEvaluationGroup in_oGroup,
		List<EventParameterInstance> in_colEPIs,
		Map<EventParameterInstance, TestCaseValidValue> in_colCurrentValueAssignment,
		TestCaseValueSelector in_oValueSelector) {
	
		List<Map<EventParameterInstance, TestCaseValidValue>> colRetValues =
			new ArrayList<Map<EventParameterInstance,TestCaseValidValue>>();
		
		if(in_colEPIs.isEmpty()) {
			return colRetValues;
		}
		
		// optimize, etc.
		
		// select one of the remaining parameter instances
		// just select the first one -> does not work always -> algorithm for value selection is not mature 
		// -> y>z && y+z>x if only x is known -> ??? may lead to wrong results
		// first work-around: try any sequence of parameters until values are found
		for(int i = 0; i < in_colEPIs.size(); ++i) {
			EventParameterInstance oEPI = in_colEPIs.get(i);
			in_colEPIs.remove(oEPI);
			
			// build up map from atoms to concrete test values
			Map<TCGOCLAtom, TestCaseValidValue> colAtomValues = 
				new LinkedHashMap<TCGOCLAtom, TestCaseValidValue>();
			for(EventParameterInstance oTmpEPI : in_colCurrentValueAssignment.keySet()) {
				for(TCGOCLAtom oAtom : in_oGroup.getParameterToAtoms().get(oTmpEPI)) {
					colAtomValues.put(oAtom, 
						in_colCurrentValueAssignment.get(oTmpEPI));
				}
			}
			// prepare map from atoms to value type ranges
			Map<TCGOCLAtom, ValueTypeRange> colAtomToValuetypeRange =
				new LinkedHashMap<TCGOCLAtom, ValueTypeRange>();
			for(EventParameterInstance oKeyEPI : in_oGroup.getParameterToAtoms().keySet()) {
				for(TCGOCLAtom oAtom : in_oGroup.getParameterToAtoms().get(oKeyEPI)) {
					colAtomToValuetypeRange.put(oAtom, oKeyEPI.getValueRange());
				}
			}
			// adapt value ranges by evaluating all dynamic expressions of the group
			List<TCGOCLExpression> colAlreadyEvaluatedExpressions =
				new ArrayList<TCGOCLExpression>();
			ValueTypeRange oVTR = 
				TCGOCLExpressionHelperClass.getValueTypeRangeForEventParameterInstance(
						in_oGroup.getParameterToAtoms().get(oEPI), 
						in_oGroup.getLateSatisfiedConditions(),
						colAtomToValuetypeRange, colAtomValues,
						colAlreadyEvaluatedExpressions);
		
			
			// ### specify one parameter value ###
			// first: get the static value range
			//ValueTypeRange oTmpRange = oEPI.getValueRange().clone();
			// second: add the results from dynamic evaluation
			// adapt value type range to other expressions within the group
		//	adaptValueTypeRangeToGroupExpressions(
		//			oVTR, oEPI, in_oGroup,
		//			colAtomValues);
			
			
			// select values from the range - depending on the coverage criterion
			TestCaseValueSelector oTmpSelector = in_oValueSelector;
			// only difference: for mutually dependend variables: do not restrict to boundaries
			if(in_oValueSelector instanceof TestCaseValueDomainBorderSelector) {
				oTmpSelector = new TestCaseValueDomainBorderSelector(
						in_oValueSelector.getSelectValuesOnlyAtBoundaries(), true);
			}	    
			for(TestCaseValidValue oValue : oTmpSelector.selectValues(oVTR)) {
				
				Map<EventParameterInstance, TestCaseValidValue> colNewMap =
					new LinkedHashMap<EventParameterInstance, TestCaseValidValue>();
				colNewMap.putAll(in_colCurrentValueAssignment);
				colNewMap.put(oEPI, oValue);
				
				int y = Integer.parseInt(oValue.getValue());
				if(y < -10 || y > 10) {
					in_oValueSelector.selectValues(oVTR);
				}
				
				// recursion  
				if(in_colEPIs.isEmpty()) {
					colRetValues.add(colNewMap);
				}
				else {
					colRetValues.addAll(
							createDynamicValuesForLateParameterInstanceValues(
									in_oGroup, in_colEPIs, colNewMap, in_oValueSelector));
				}			
			}
			
			// insert event parameter instance to the position from where it was removed
			in_colEPIs.add(i, oEPI);
			
			// found some values -> break
			if(!colRetValues.isEmpty()) {
				break;
			}
		}
		return colRetValues;
	}
}
