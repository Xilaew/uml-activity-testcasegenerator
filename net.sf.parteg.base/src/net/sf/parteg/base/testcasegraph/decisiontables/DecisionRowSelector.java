package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.ArrayList;

public class DecisionRowSelector {

	ArrayList<DecisionRowAlternatives> m_colPositiveNecessary;
	ArrayList<DecisionRowAlternatives> m_colPositiveUnnecessary;
	ArrayList<DecisionRowAlternatives> m_colNegativeNecessary;
	ArrayList<DecisionRowAlternatives> m_colNegativeUnnecessary;
	
	public DecisionRowSelector() {
		m_colPositiveNecessary = new ArrayList<DecisionRowAlternatives>();
		m_colPositiveUnnecessary = new ArrayList<DecisionRowAlternatives>();
		m_colNegativeNecessary = new ArrayList<DecisionRowAlternatives>();
		m_colNegativeUnnecessary = new ArrayList<DecisionRowAlternatives>();
	}

	public ArrayList<DecisionRowAlternatives> getPositives()
	{
		ArrayList<DecisionRowAlternatives> colResPositive = 
			new ArrayList<DecisionRowAlternatives>();
		colResPositive.addAll(getPositiveNecessary());
		colResPositive.addAll(getPositiveUnnecessary());
		return colResPositive;
	}

	public ArrayList<DecisionRowAlternatives> getNegatives()
	{
		ArrayList<DecisionRowAlternatives> colResNegative = 
			new ArrayList<DecisionRowAlternatives>();
		colResNegative.addAll(getNegativeNecessary());
		colResNegative.addAll(getNegativeUnnecessary());
		return colResNegative;
	}
	
	public ArrayList<DecisionRowAlternatives> getAllButPositiveNecessary()
	{
		ArrayList<DecisionRowAlternatives> colResNegative = 
			new ArrayList<DecisionRowAlternatives>();
		colResNegative.addAll(getPositiveUnnecessary());
		colResNegative.addAll(getNegativeNecessary());
		colResNegative.addAll(getNegativeUnnecessary());
		return colResNegative;
	}
	
	public ArrayList<DecisionRowAlternatives> getAllButNegativeNecessary()
	{
		ArrayList<DecisionRowAlternatives> colResNegative = 
			new ArrayList<DecisionRowAlternatives>();
		colResNegative.addAll(getPositiveNecessary());
		colResNegative.addAll(getPositiveUnnecessary());
		colResNegative.addAll(getNegativeUnnecessary());
		return colResNegative;
	}
	
	public ArrayList<DecisionRowAlternatives> getPositiveNecessary() {
		return m_colPositiveNecessary;
	}
	
	public void addAllPositiveNecessary(ArrayList<DecisionRowAlternatives> in_oAlternativeRows)
	{
		m_colPositiveNecessary.addAll(in_oAlternativeRows);
	}
	
	public ArrayList<DecisionRowAlternatives> getPositiveUnnecessary() {
		return m_colPositiveUnnecessary;
	}
	
	public void addAllPositiveUnnecessary(ArrayList<DecisionRowAlternatives> in_oAlternativeRows)
	{
		m_colPositiveUnnecessary.addAll(in_oAlternativeRows);
	}
	
	public ArrayList<DecisionRowAlternatives> getNegativeNecessary() {
		return m_colNegativeNecessary;
	}
	
	public void addAllNegativeNecessary(ArrayList<DecisionRowAlternatives> in_oAlternativeRows)
	{
		m_colNegativeNecessary.addAll(in_oAlternativeRows);
	}
	
	public ArrayList<DecisionRowAlternatives> getNegativeUnnecessary() {
		return m_colNegativeUnnecessary;
	}

	public void addAllNegativeUnnecessary(ArrayList<DecisionRowAlternatives> in_oAlternativeRows)
	{
		m_colNegativeUnnecessary.addAll(in_oAlternativeRows);
	}

}
