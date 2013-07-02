package net.sf.parteg.base.testcasegraph.ocl.parser;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;

public class OCLTreeFindOperationVisitor implements OCLTreeExpressionVisitor {

	private String m_sName;
	private boolean m_bFound;
	
	public OCLTreeFindOperationVisitor(String in_sName)
	{
		m_sName = in_sName;
		m_bFound = false;
	}

	public boolean foundOperation()
	{
		return m_bFound;
	}
	
	@Override
	public void check(TCGOCLExpression in_oExpression) {
		// TODO Auto-generated method stub
		if(in_oExpression instanceof TCGOCLOperation)
		{
			if(((TCGOCLOperation)in_oExpression).getOperationName().equals(m_sName))
				m_bFound = true;
		}
	}

}
