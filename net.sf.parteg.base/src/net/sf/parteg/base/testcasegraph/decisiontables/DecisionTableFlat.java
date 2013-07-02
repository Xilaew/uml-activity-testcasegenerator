package net.sf.parteg.base.testcasegraph.decisiontables;

import static net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.isBooleanOperation;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeAtomicExpressionFinderVisitor;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionIterator;

public class DecisionTableFlat extends ArrayList<DecisionTableExpressionValueSelection> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private TCGOCLExpression m_oExpression;
	
	public DecisionTableFlat(TCGOCLExpression in_oExpression)
	{
		super();
		m_oExpression = in_oExpression;
	}

	public void buildUpCompleteDecisionTable()
	{
		// collect all atomic expressions ...
		OCLTreeAtomicExpressionFinderVisitor oVisitor = 
			new OCLTreeAtomicExpressionFinderVisitor(m_oExpression);
		OCLTreeExpressionIterator.run(m_oExpression, oVisitor);
		ArrayList<TCGOCLExpression> colAtomicExpressions = oVisitor.getExpressions();
		
		// create decision table
		for(TCGOCLExpression oExp : colAtomicExpressions)
		{
			ArrayList<DecisionTableExpressionValueSelection> colNewRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			if(this.size() == 0)
			{
				this.add(new DecisionTableExpressionValueSelection());
			}
			// clone the actual rows - this get a new positive value, the others a new negative value
			for(DecisionTableExpressionValueSelection oRow : this)
			{
				colNewRows.add((DecisionTableExpressionValueSelection)oRow.clone());
			}
			
			for(DecisionTableExpressionValueSelection oRow : this)
			{
				oRow.put(oExp, true);
			}
			for(DecisionTableExpressionValueSelection oRow : colNewRows)
			{
				oRow.put(oExp, false);
			}
			
			this.addAll(colNewRows);
		}
	}	
	
	public void buildUpMCDCDecisionTable()
	{
		// collect all atomic expressions ...
		OCLTreeAtomicExpressionFinderVisitor oVisitor = 
			new OCLTreeAtomicExpressionFinderVisitor(m_oExpression);
		OCLTreeExpressionIterator.run(m_oExpression, oVisitor);
		ArrayList<TCGOCLExpression> colAtomicExpressions = oVisitor.getExpressions();
		
		addAll(getMCDCForExpression(m_oExpression, colAtomicExpressions));
	}
	
	private ArrayList<DecisionTableExpressionValueSelection> getMCDCForExpression(
			TCGOCLExpression in_oExpression,
			ArrayList<TCGOCLExpression> in_colAtomicExpressions)
	{
		ArrayList<DecisionTableExpressionValueSelection> colRows = 
			new ArrayList<DecisionTableExpressionValueSelection>();
		if(in_oExpression == null)
			return colRows;
		
		if(isBooleanOperation(in_oExpression))
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			ArrayList<DecisionTableExpressionValueSelection> colLeftRows = 
				getMCDCForExpression(oOperation.getLeft(), in_colAtomicExpressions);
			ArrayList<DecisionTableExpressionValueSelection> colRightRows = 
				getMCDCForExpression(oOperation.getRight(), in_colAtomicExpressions);
			ArrayList<DecisionTableExpressionValueSelection> colLeftPositiveRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colLeftNegativeRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colRightPositiveRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colRightNegativeRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			getPositiveAndNegativeRows(
					colLeftRows, colLeftPositiveRows, colLeftNegativeRows);
			getPositiveAndNegativeRows(
					colRightRows, colRightPositiveRows, colRightNegativeRows);
			
			if(oOperation.getOperationName().equals("and"))
			{
				colRows.addAll(uniteRows(
						colLeftPositiveRows, colRightPositiveRows, true));
				colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
						colRightNegativeRows, colLeftPositiveRows, false));
				colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
						colLeftNegativeRows, colRightPositiveRows, false));
			} else if(oOperation.getOperationName().equals("or"))
			{
				colRows.addAll(uniteRows(
						colLeftNegativeRows, colRightNegativeRows, false));
				colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
						colLeftPositiveRows, colRightNegativeRows, true));				
				colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
						colRightPositiveRows, colLeftNegativeRows, true));
			} else if(oOperation.getOperationName().equals("not"))
			{
				colRows.addAll(changeRowValue(colLeftPositiveRows, false));
				colRows.addAll(changeRowValue(colLeftNegativeRows, true));
				colRows.addAll(changeRowValue(colRightPositiveRows, false));
				colRows.addAll(changeRowValue(colRightNegativeRows, true));
			}
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			ArrayList<DecisionTableExpressionValueSelection> colCondRows = 
				getMCDCForExpression(oIfThenElse.getCondition(), in_colAtomicExpressions);
			ArrayList<DecisionTableExpressionValueSelection> colThenRows = 
				getMCDCForExpression(oIfThenElse.getThenExpression(), in_colAtomicExpressions);
			ArrayList<DecisionTableExpressionValueSelection> colElseRows = 
				getMCDCForExpression(oIfThenElse.getElseExpression(), in_colAtomicExpressions);
			
			ArrayList<DecisionTableExpressionValueSelection> colCondPositiveRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colCondNegativeRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colThenPositiveRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colThenNegativeRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colElsePositiveRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			ArrayList<DecisionTableExpressionValueSelection> colElseNegativeRows = 
				new ArrayList<DecisionTableExpressionValueSelection>();
			
			getPositiveAndNegativeRows(
					colCondRows, colCondPositiveRows, colCondNegativeRows);
			getPositiveAndNegativeRows(
					colThenRows, colThenPositiveRows, colThenNegativeRows);
			getPositiveAndNegativeRows(
					colElseRows, colElsePositiveRows, colElseNegativeRows);

			// "and" between cond and then, and !cond and else
			colRows.addAll(uniteRows(
					colCondPositiveRows, colThenPositiveRows, true));
			colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
					colThenNegativeRows, colCondPositiveRows, false));

			colRows.addAll(uniteRows(
					colCondNegativeRows, colElsePositiveRows, true));
			colRows.addAll(keepFirstRowsAndAddAnyElementsOfSecond(
					colElseNegativeRows, colCondNegativeRows, false));
			
		} else if(in_colAtomicExpressions.contains(in_oExpression))
		{
			// this expression must be atomic - return true and false as default values
			DecisionTableExpressionValueSelection oSelection = 
				new DecisionTableExpressionValueSelection();
			oSelection.put(in_oExpression, true);
			colRows.add(oSelection);
			
			oSelection = new DecisionTableExpressionValueSelection();
			oSelection.put(in_oExpression, false);
			colRows.add(oSelection);			
		}
		
		return colRows;
	}

	
	public static void getPositiveAndNegativeRows(
			ArrayList<DecisionTableExpressionValueSelection> in_colRows,
			ArrayList<DecisionTableExpressionValueSelection> io_colPositiveRows,
			ArrayList<DecisionTableExpressionValueSelection> io_colNegativeRows)
	{
		for(DecisionTableExpressionValueSelection oRow : in_colRows)
		{
			if(oRow.getTruthValue() == true)
				io_colPositiveRows.add(oRow);
			else
				io_colNegativeRows.add(oRow);
		}
	}

	
	public static ArrayList<DecisionTableExpressionValueSelection> uniteRows(
			ArrayList<DecisionTableExpressionValueSelection> in_colFirstRows,
			ArrayList<DecisionTableExpressionValueSelection> in_colSecondRows,
			boolean in_bNewValue)
	{
		ArrayList<DecisionTableExpressionValueSelection> colRetRows = 
			new ArrayList<DecisionTableExpressionValueSelection>();
		int nFirstSize = in_colFirstRows.size();
		int nSecondSize = in_colSecondRows.size();
		int nMaxLength = Math.max(nFirstSize, nSecondSize);
		for(int i = 0; i < nMaxLength; ++i)
		{
			DecisionTableExpressionValueSelection oSelection = 
				new DecisionTableExpressionValueSelection();
			oSelection.putAll(in_colFirstRows.get(Math.min(i, nFirstSize - 1)));
			oSelection.putAll(in_colSecondRows.get(Math.min(i, nSecondSize - 1)));
			oSelection.setTruthValue(in_bNewValue);
			colRetRows.add(oSelection);
		}
		return colRetRows;
	}

	public static ArrayList<DecisionTableExpressionValueSelection> keepFirstRowsAndAddAnyElementsOfSecond(
		ArrayList<DecisionTableExpressionValueSelection> in_colFirstRows,
		ArrayList<DecisionTableExpressionValueSelection> in_colSecondRows,
		boolean in_bNewValue)
	{
		ArrayList<DecisionTableExpressionValueSelection> colRetRows = 
			new ArrayList<DecisionTableExpressionValueSelection>();
		int nFirstSize = in_colFirstRows.size();
		int nSecondSize = in_colSecondRows.size();
		for(int i = 0; i < nFirstSize; ++i)
		{
			DecisionTableExpressionValueSelection oSelection = 
				new DecisionTableExpressionValueSelection();
			oSelection.putAll(in_colFirstRows.get(i));
			oSelection.putAll(in_colSecondRows.get(Math.min(i, nSecondSize - 1)));
			oSelection.setTruthValue(in_bNewValue);
			colRetRows.add(oSelection);
		}
		return colRetRows;
	}
	
	public static ArrayList<DecisionTableExpressionValueSelection> changeRowValue(
		ArrayList<DecisionTableExpressionValueSelection> in_colRows,
		boolean in_bValue)
	{
		ArrayList<DecisionTableExpressionValueSelection> colRetRows = 
			new ArrayList<DecisionTableExpressionValueSelection>();

		for(DecisionTableExpressionValueSelection oSelection : in_colRows)
		{
			DecisionTableExpressionValueSelection oNewSelection =
				new DecisionTableExpressionValueSelection();
			oNewSelection.putAll(oSelection);
			oNewSelection.setTruthValue(in_bValue);
			colRetRows.add(oNewSelection);
		}
		
		return colRetRows;
	}
	
//	public static ArrayList<DecisionTableContent> uniteRows(
//			ArrayList<DecisionTableContent> in_colFirstRows,
//			ArrayList<DecisionTableContent> in_colSecondRows)
//	{
//		ArrayList<DecisionTableContent> colRetRows = 
//			new ArrayList<DecisionTableContent>();
//		int nFirstSize = in_colFirstRows.size();
//		int nSecondSize = in_colSecondRows.size();
//		int nMaxLength = Math.max(nFirstSize, nSecondSize);
//		for(int i = 0; i < nMaxLength; ++i)
//		{
//			DecisionTableContentContainer colContent = new DecisionTableContentContainer();
//			colContent.getContents().add(in_colFirstRows.get(
//					Math.max(i, nFirstSize)));
//			colContent.getContents().add(in_colSecondRows.get(
//					Math.max(i, nSecondSize)));
//			// Wahrheits-Wert des Containers setzen
//			colRetRows.add(colContent);
//		}
//	}
}
