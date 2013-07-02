package net.sf.parteg.base.testcasegraph.ocl.parser;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public class OCLTreeTCGOCLAtomCollectorVisitor implements
		OCLTreeExpressionVisitor {

	private ArrayList<TCGOCLAtom> m_colExpressions;
	
	public OCLTreeTCGOCLAtomCollectorVisitor() {
		m_colExpressions = new ArrayList<TCGOCLAtom>();
	}
	
	public ArrayList<TCGOCLAtom> getExpressions()
	{
		return m_colExpressions;
	}
	
	@Override
	public void check(TCGOCLExpression in_oExpression) {
		if(in_oExpression == null)
			return;
		
		if(in_oExpression instanceof TCGOCLAtom) {
			m_colExpressions.add((TCGOCLAtom)in_oExpression);
		}
	}

}
