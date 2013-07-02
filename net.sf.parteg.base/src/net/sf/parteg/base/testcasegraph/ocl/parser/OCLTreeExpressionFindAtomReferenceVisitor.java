package net.sf.parteg.base.testcasegraph.ocl.parser;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public class OCLTreeExpressionFindAtomReferenceVisitor implements OCLTreeExpressionVisitor {

	private TCGOCLAtom m_oOriginalAtom;
	private List<TCGOCLAtom> m_colFoundAtoms;
	private boolean m_bFound;
	
	public OCLTreeExpressionFindAtomReferenceVisitor(TCGOCLAtom in_oExpression)
	{
		m_oOriginalAtom = in_oExpression;
		m_colFoundAtoms = new ArrayList<TCGOCLAtom>();
		m_bFound = false;
	}
	
	@Override
	public void check(TCGOCLExpression in_oExpression) {
		if(in_oExpression instanceof TCGOCLAtom) {
			if(((TCGOCLAtom)in_oExpression).getElement().equals(
					m_oOriginalAtom.getElement())) {
				m_bFound = true;
				m_colFoundAtoms.add((TCGOCLAtom)in_oExpression);
			}
		}
	}
	
	public boolean isFound() {
		return m_bFound;
	}

	public List<TCGOCLAtom> getFoundAtoms() {
		return m_colFoundAtoms;
	}
}
