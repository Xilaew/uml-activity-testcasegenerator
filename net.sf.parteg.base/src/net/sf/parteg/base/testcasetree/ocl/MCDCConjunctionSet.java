package net.sf.parteg.base.testcasetree.ocl;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.TCGConjunction;


public class MCDCConjunctionSet {

	private TCGConjunction m_oPositiveConjunction;
	private ArrayList<TCGConjunction> m_colNegativeButChangeableConjunctions;
	private ArrayList<TCGConjunction> m_colNegativeAndUnchangeableConjunctions;
	
	
	public TCGConjunction getPositiveConjunction() {
		return m_oPositiveConjunction;
	}
	
	public void setPositiveConjunction(TCGConjunction positiveConjunction) {
		m_oPositiveConjunction = positiveConjunction;
	}
	
	public ArrayList<TCGConjunction> getNegativeButChangeableConjunctions() {
		if(m_colNegativeButChangeableConjunctions == null)
			m_colNegativeButChangeableConjunctions = new ArrayList<TCGConjunction>();
		return m_colNegativeButChangeableConjunctions;
	}
	
	public ArrayList<TCGConjunction> getNegativeAndUnchangeableConjunctions() {
		if(m_colNegativeAndUnchangeableConjunctions == null)
			m_colNegativeAndUnchangeableConjunctions = new ArrayList<TCGConjunction>();
		return m_colNegativeAndUnchangeableConjunctions;
	}
	
}
