package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public class ExpressionChangeLog {

	private List<TCGOCLExpression> colAddedExpressions;
	private List<TCGOCLExpression> colRemovedExpressions;
	
	public ExpressionChangeLog()
	{
		colAddedExpressions = new ArrayList<TCGOCLExpression>();
		colRemovedExpressions = new ArrayList<TCGOCLExpression>();
	}
	
	public List<TCGOCLExpression> getAddedExpressions()
	{
		return colAddedExpressions;
	}
	
	public List<TCGOCLExpression> getRemovedExpressions()
	{
		return colRemovedExpressions;
	}
	
	public void executeChanges(List<TCGOCLExpression> io_colExpressions)
	{
		int nBefore = io_colExpressions.size();
		int nDiff = colRemovedExpressions.size();
		io_colExpressions.removeAll(colRemovedExpressions);
		if(io_colExpressions.size() + nDiff != nBefore) {
		}
		io_colExpressions.addAll(colAddedExpressions);
	}
	
	public void undoChanges(List<TCGOCLExpression> io_colExpressions)
	{
		io_colExpressions.removeAll(colAddedExpressions);		
		io_colExpressions.addAll(colRemovedExpressions);
	}
}
