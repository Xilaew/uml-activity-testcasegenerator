package net.sf.parteg.base.testcasegraph.systemstate;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.runtime.generated.GeneratedFactory;
import net.sf.parteg.base.runtime.generated.RuntimeState;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;

public class StateConfiguration {

	private RuntimeState m_oRuntimeState;
	private List<TCGOCLExpression> m_colConditionsToBeSatisfied;
	
	public StateConfiguration(
			RuntimeState in_oRuntimeState,
			List<TCGOCLExpression> in_colConditionsToBeSatisfied)
	{
		// create a copy of the currently active states 
		m_oRuntimeState = GeneratedFactory.eINSTANCE.createRuntimeState();
		for(TCGNode oNode : in_oRuntimeState.getAllActiveNodes()) {
			m_oRuntimeState.setActiveNode(oNode);
		}
		
		// create a copy of the conditions to be satisfied
		m_colConditionsToBeSatisfied = new ArrayList<TCGOCLExpression>();
		for(TCGOCLExpression oExpression : in_colConditionsToBeSatisfied) {
			m_colConditionsToBeSatisfied.add(TCGOCLExpressionHelperClass.copyExpression(oExpression));
		}
	}
	
	public RuntimeState getRuntimeState()
	{
		return m_oRuntimeState;
	}
	
	public List<TCGOCLExpression> getConditionsToBeSatisfied()
	{
		return m_colConditionsToBeSatisfied;
	}
	
	/*
	 * is true if the other's runtime states are equal and
	 * the other's conditions to be satisfied are a subset of the own's ...
	 */
	public boolean isSubConfigurationOf(StateConfiguration in_oOther)
	{
		if(!runtimeStateEquals(in_oOther))
			return false;
		
		if(!conditionsToBeSatisfiedIsSubSetOf(in_oOther))
			return false;
		
		return true;
	}
	
	public boolean equals(StateConfiguration in_oOther)
	{
		if(!runtimeStateEquals(in_oOther))
			return false;
		
		if(!conditionsToBeSatisfiedEquals(in_oOther))
			return false;
		
		return true;
	}
	
	private boolean runtimeStateEquals(StateConfiguration in_oOther)
	{
		// states from runtime state are equal
		if(getRuntimeState().getAllActiveNodes().size() !=
			in_oOther.getRuntimeState().getAllActiveNodes().size())
			return false;
		for(TCGNode oNode : getRuntimeState().getAllActiveNodes()) {
			if(!in_oOther.getRuntimeState().getAllActiveNodes().contains(oNode))
				return false;
		}
		return true;
	}
	
	private boolean conditionsToBeSatisfiedEquals(StateConfiguration in_oOther)
	{
		// conditions to satisfy are equal
		// check if the expression lists satisfy each other
		for(TCGOCLExpression oExpression : getConditionsToBeSatisfied()) {
			boolean bMatchingExpressionFound = false;
			for(TCGOCLExpression oOtherExpression : in_oOther.getConditionsToBeSatisfied()) {
				if(TCGOCLExpressionHelperClass.firstExpressionIsSatisfiedBySecondExpression(
						oExpression, oOtherExpression, true)) {
					bMatchingExpressionFound = true;
				}
			}
			if(bMatchingExpressionFound == false)
				return false;
		}
		for(TCGOCLExpression oExpression : in_oOther.getConditionsToBeSatisfied()) {
			boolean bMatchingExpressionFound = false;
			for(TCGOCLExpression oOtherExpression : getConditionsToBeSatisfied()) {
				if(TCGOCLExpressionHelperClass.firstExpressionIsSatisfiedBySecondExpression(
						oExpression, oOtherExpression, true)) {
					bMatchingExpressionFound = true;
				}
			}
			if(bMatchingExpressionFound == false)
				return false;
		}
		return true;
	}
	
	private boolean conditionsToBeSatisfiedIsSubSetOf(StateConfiguration in_oOther)
	{
		// conditions to satisfy are equal
		// check if the own's expression list is satisfied by the other ...
		for(TCGOCLExpression oExpression : getConditionsToBeSatisfied()) {
			boolean bMatchingExpressionFound = false;
			for(TCGOCLExpression oOtherExpression : in_oOther.getConditionsToBeSatisfied()) {
				if(TCGOCLExpressionHelperClass.firstExpressionIsSatisfiedBySecondExpression(
						oExpression, oOtherExpression, true)) {
					bMatchingExpressionFound = true;
				}
			}
			if(bMatchingExpressionFound == false)
				return false;
		}

		return true;
	}
}
