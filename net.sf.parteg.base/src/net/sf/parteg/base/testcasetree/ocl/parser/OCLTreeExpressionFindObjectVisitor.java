package net.sf.parteg.base.testcasetree.ocl.parser;

import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;

public class OCLTreeExpressionFindObjectVisitor implements OCLTreeExpressionVisitor {

	private TCGOCLExpression m_oExpression;
	private boolean m_bFound;
	
	public OCLTreeExpressionFindObjectVisitor(TCGOCLExpression in_oExpression)
	{
		m_oExpression = in_oExpression;
		m_bFound = false;
	}
	
	@Override
	public void check(TCGOCLExpression in_oExpression) {
		if(in_oExpression.equals(m_oExpression))
			m_bFound = true;
	}
	
	public boolean isFound()
	{
		return m_bFound;
	}

}
