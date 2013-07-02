package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.ArrayList;
import java.util.List;


public class DecisionRowContainer implements DecisionRowInterface {

	private boolean m_bTruthValue;
	private boolean m_bIsNecessary;
	private List<DecisionRowInterface> m_colChildren;
	
	public DecisionRowContainer(boolean in_bIsNecessary)
	{
		m_colChildren = new ArrayList<DecisionRowInterface>();
		m_bIsNecessary = in_bIsNecessary;
	}
	
	@Override
	public boolean getTruthValue() {
		return m_bTruthValue;
	}

	@Override
	public ArrayList<DecisionTableExpressionValueSelection> getValues() {
		ArrayList<DecisionTableExpressionValueSelection> colRetValues =
			new ArrayList<DecisionTableExpressionValueSelection>();
		for(DecisionRowInterface oRow : getChildren())
		{
			colRetValues.addAll(oRow.getValues());
		}
		return colRetValues;
	}

	@Override
	public void setTruthValue(boolean in_bValue) {
		m_bTruthValue = in_bValue;
	}

	public List<DecisionRowInterface> getChildren()
	{
		return m_colChildren;
	}

	@Override
	public void fillValueSelection(
			DecisionTableExpressionValueSelection io_oSelection) {
		for(DecisionRowInterface oRow : getChildren())
		{
			oRow.fillValueSelection(io_oSelection);
		}
	}

	@Override
	public boolean getIsNecessary() {
		return m_bIsNecessary;
	}

	@Override
	public void setIsNecessary(boolean in_bValue) {
		m_bIsNecessary = in_bValue;
	}	
}
