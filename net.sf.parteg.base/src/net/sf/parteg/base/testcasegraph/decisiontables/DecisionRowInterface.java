package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.ArrayList;


public interface DecisionRowInterface {

	public void setTruthValue(boolean in_bValue);
	
	public boolean getTruthValue();
	
	public ArrayList<DecisionTableExpressionValueSelection> getValues();
	
	public void fillValueSelection(DecisionTableExpressionValueSelection io_oSelection);
	
	public void setIsNecessary(boolean in_bValue);
	
	public boolean getIsNecessary();
}
