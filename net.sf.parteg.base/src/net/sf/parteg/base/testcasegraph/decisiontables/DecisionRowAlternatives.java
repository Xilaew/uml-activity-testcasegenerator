package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.ArrayList;

public class DecisionRowAlternatives extends ArrayList<DecisionRowInterface> {

	/**
	 * serial id
	 */
	private static final long serialVersionUID = 3483263982691978218L;

	public DecisionRowAlternatives()
	{
		super();
	}
	
	public boolean getTruthValue() {
		if(!isEmpty())
			return iterator().next().getTruthValue();
		else
		{
//			throw new Exception("DecisionRowAlternatives without members!");
			System.out.println("DecisionRowAlternatives without members!");
			return false;
		}
	}
}
