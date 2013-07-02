package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public class DecisionRowAtomic implements DecisionRowInterface {

	private DecisionTableExpressionValueSelection m_oSelection;
	
	public DecisionRowAtomic(DecisionTableExpressionValueSelection in_oSelection) {
		m_oSelection = in_oSelection;
	}

	public DecisionRowAtomic(TCGOCLExpression in_oExpression, boolean in_bTruthValue) {
		m_oSelection = new DecisionTableExpressionValueSelection();
		m_oSelection.put(in_oExpression, in_bTruthValue);
	}
	
	@Override
	public boolean getTruthValue() {
		return m_oSelection.getTruthValue();
	}

	@Override
	public ArrayList<DecisionTableExpressionValueSelection> getValues() {
		ArrayList<DecisionTableExpressionValueSelection> colRetValues =
			new ArrayList<DecisionTableExpressionValueSelection>();
		colRetValues.add(m_oSelection);
		return colRetValues;
	}

	@Override
	public void setTruthValue(boolean in_bValue) {
		m_oSelection.setTruthValue(in_bValue);
	}

	@Override
	public void fillValueSelection(
			DecisionTableExpressionValueSelection io_oSelection) {
		io_oSelection.put(m_oSelection.keySet().iterator().next(), 
				getTruthValue());
	}

	@Override
	public boolean getIsNecessary() {
		return true;
	}

	@Override
	public void setIsNecessary(boolean in_bValue) {
		// nothing - atoms are always necessary
	}
}
