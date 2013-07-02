package net.sf.parteg.base.testcasegraph.decisiontables;

import static net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.isBooleanOperation;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeAtomicExpressionFinderVisitor;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionIterator;

public class DecisionTableHierarchy extends ArrayList<DecisionRowAlternatives> {

	/**
	 * serial id
	 */
	private static final long serialVersionUID = -443723584572535307L;
	
	private TCGOCLExpression m_oExpression;
	
	public DecisionTableHierarchy(TCGOCLExpression in_oExpression)
	{
		super();
		m_oExpression = in_oExpression;
	}

	public void buildUpMaskingMCDCDecisionTable(
			boolean in_bCreateRowsForUnnecessaryValues)
	{
		// collect all atomic expressions ...
		OCLTreeAtomicExpressionFinderVisitor oVisitor = 
			new OCLTreeAtomicExpressionFinderVisitor(m_oExpression);
		OCLTreeExpressionIterator.run(m_oExpression, oVisitor);
		ArrayList<TCGOCLExpression> colAtomicExpressions = oVisitor.getExpressions();
		
		DecisionRowSelector oRowSelector = 
			getMCDCForExpression(m_oExpression, colAtomicExpressions, 
					in_bCreateRowsForUnnecessaryValues);
		addAll(oRowSelector.getNegativeNecessary());
		addAll(oRowSelector.getPositiveNecessary());
	}
	
	private DecisionRowSelector getMCDCForExpression(
			TCGOCLExpression in_oExpression,
			ArrayList<TCGOCLExpression> in_colAtomicExpressions,
			boolean in_bCreateRowsForUnnecessaryValues)
	{
		DecisionRowSelector oRows = new DecisionRowSelector();
		if(in_oExpression == null)
			return oRows;
		
		if(in_colAtomicExpressions.contains(in_oExpression))
		{
			// this expression must be atomic - return true and false as default values
			DecisionRowAlternatives oAlternatives = 
				new DecisionRowAlternatives();
			oAlternatives.add(new DecisionRowAtomic(in_oExpression, true));
			oRows.getPositiveNecessary().add(oAlternatives);
			
			oAlternatives = new DecisionRowAlternatives();
			oAlternatives.add(new DecisionRowAtomic(in_oExpression, false));
			oRows.getNegativeNecessary().add(oAlternatives);
		}
		else if(isBooleanOperation(in_oExpression))
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			
			DecisionRowSelector oLeftRows =
				getMCDCForExpression(oOperation.getLeft(), 
						in_colAtomicExpressions, in_bCreateRowsForUnnecessaryValues);
			DecisionRowSelector oRightRows =
				getMCDCForExpression(oOperation.getRight(), 
						in_colAtomicExpressions, in_bCreateRowsForUnnecessaryValues);
			
			if(oOperation.getOperationName().equals("and"))
			{
				return selectRowsForAnd(oLeftRows, oRightRows, in_bCreateRowsForUnnecessaryValues);
			} 
			else if(oOperation.getOperationName().equals("or"))
			{
				return selectRowsForOr(oLeftRows, oRightRows, in_bCreateRowsForUnnecessaryValues);
			} 
			else if(oOperation.getOperationName().equals("not"))
			{
				return selectRowsForNot(oLeftRows, oRightRows, in_bCreateRowsForUnnecessaryValues);
			}
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			DecisionRowSelector oIfRows =
				getMCDCForExpression(oIfThenElse.getCondition(), 
						in_colAtomicExpressions, in_bCreateRowsForUnnecessaryValues);
			DecisionRowSelector oNotIfRows = selectRowsForNot(oIfRows, new DecisionRowSelector(),
					in_bCreateRowsForUnnecessaryValues);
			DecisionRowSelector oThenRows =
				getMCDCForExpression(oIfThenElse.getThenExpression(), 
						in_colAtomicExpressions, in_bCreateRowsForUnnecessaryValues);
			DecisionRowSelector oElseRows =
				getMCDCForExpression(oIfThenElse.getElseExpression(), 
						in_colAtomicExpressions, in_bCreateRowsForUnnecessaryValues);

			// if A then B else C is the same as (A and B) or (not A and C)
			return selectRowsForOr(
					selectRowsForAnd(oIfRows, oThenRows, in_bCreateRowsForUnnecessaryValues),
					selectRowsForAnd(oNotIfRows, oElseRows, in_bCreateRowsForUnnecessaryValues),
					in_bCreateRowsForUnnecessaryValues);
		} 
		
		return oRows;
	}

	private DecisionRowSelector selectRowsForAnd(
			DecisionRowSelector in_oLeftRows,
			DecisionRowSelector in_oRightRows,
			boolean in_bCreateRowsForUnnecessaryValues) 
	{
		DecisionRowSelector oRetValue = new DecisionRowSelector();
		
		oRetValue.addAllPositiveNecessary(uniteDecisionRowAlternativeLists(
				in_oLeftRows.getPositiveNecessary(), in_oRightRows.getPositiveNecessary(),
				in_oLeftRows.getPositiveUnnecessary(), in_oRightRows.getPositiveUnnecessary(),
				true, true, in_bCreateRowsForUnnecessaryValues));
		oRetValue.addAllNegativeNecessary(uniteDecisionRowAlternativeLists(
				in_oLeftRows.getNegativeNecessary(), in_oRightRows.getPositiveNecessary(),
				null, in_oRightRows.getPositiveUnnecessary(), 
				false, true, in_bCreateRowsForUnnecessaryValues));
		oRetValue.addAllNegativeNecessary(uniteDecisionRowAlternativeLists(
				in_oRightRows.getNegativeNecessary(), in_oLeftRows.getPositiveNecessary(),
				null, in_oLeftRows.getPositiveUnnecessary(), 
				false, true, in_bCreateRowsForUnnecessaryValues));

		if(in_bCreateRowsForUnnecessaryValues) {
			oRetValue.addAllPositiveUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getPositiveUnnecessary(), in_oRightRows.getPositiveUnnecessary(), 
					null, null, true, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllNegativeUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getNegativeUnnecessary(), in_oRightRows.getPositives(), 
					null, null, false, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllNegativeUnnecessary(uniteDecisionRowAlternativeLists(
					in_oRightRows.getNegativeUnnecessary(), in_oLeftRows.getPositives(),  
					null, null, false, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllNegativeUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getNegativeNecessary(), in_oRightRows.getNegativeNecessary(),
					in_oLeftRows.getNegativeUnnecessary(), in_oRightRows.getNegativeUnnecessary(),
					false, false, in_bCreateRowsForUnnecessaryValues));
		}
		
		return oRetValue;
	}
	
	
	private DecisionRowSelector selectRowsForOr(
			DecisionRowSelector in_oLeftRows,
			DecisionRowSelector in_oRightRows,
			boolean in_bCreateRowsForUnnecessaryValues) 
	{
		DecisionRowSelector oRetValue = new DecisionRowSelector();
		oRetValue.addAllNegativeNecessary(uniteDecisionRowAlternativeLists(
				in_oLeftRows.getNegativeNecessary(), in_oRightRows.getNegativeNecessary(),
				in_oLeftRows.getNegativeUnnecessary(), in_oRightRows.getNegativeUnnecessary(),
				false, true, in_bCreateRowsForUnnecessaryValues));
		oRetValue.addAllPositiveNecessary(uniteDecisionRowAlternativeLists(
				in_oLeftRows.getPositiveNecessary(), in_oRightRows.getNegativeNecessary(),
				null, in_oRightRows.getNegativeUnnecessary(),
				true, true, in_bCreateRowsForUnnecessaryValues));
		oRetValue.addAllPositiveNecessary(uniteDecisionRowAlternativeLists(
				in_oRightRows.getPositiveNecessary(), in_oLeftRows.getNegativeNecessary(),
				null, in_oLeftRows.getNegativeUnnecessary(),
				true, true, in_bCreateRowsForUnnecessaryValues));
		
		if(in_bCreateRowsForUnnecessaryValues) {
			oRetValue.addAllNegativeUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getNegativeUnnecessary(), in_oRightRows.getNegativeUnnecessary(), 
					null, null, false, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllPositiveUnnecessary(uniteDecisionRowAlternativeLists(
					in_oRightRows.getPositiveUnnecessary(), in_oLeftRows.getNegatives(),  
					null, null, true, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllPositiveUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getPositiveUnnecessary(), in_oRightRows.getNegatives(), 
					null, null, true, false, in_bCreateRowsForUnnecessaryValues));
			oRetValue.addAllPositiveUnnecessary(uniteDecisionRowAlternativeLists(
					in_oLeftRows.getPositiveNecessary(), in_oRightRows.getPositiveNecessary(), 
					in_oLeftRows.getPositiveUnnecessary(), in_oRightRows.getPositiveUnnecessary(), 
					true, false, in_bCreateRowsForUnnecessaryValues));
		}		
		return oRetValue;
	}

	private DecisionRowSelector selectRowsForNot(
			DecisionRowSelector in_oLeftRows,
			DecisionRowSelector in_oRightRows,
			boolean in_bCreateRowsForUnnecessaryValues) 
	{
		DecisionRowSelector oRetValue = new DecisionRowSelector();
		oRetValue.addAllNegativeNecessary(
				changeRowValue(in_oLeftRows.getPositiveNecessary(), false));
		oRetValue.addAllNegativeNecessary(
				changeRowValue(in_oRightRows.getPositiveNecessary(), false));
		oRetValue.addAllPositiveNecessary(
				changeRowValue(in_oLeftRows.getNegativeNecessary(), true));
		oRetValue.addAllPositiveNecessary(
				changeRowValue(in_oRightRows.getNegativeNecessary(), true));
		
		if(in_bCreateRowsForUnnecessaryValues) {
			oRetValue.addAllNegativeUnnecessary(
					changeRowValue(in_oLeftRows.getPositiveUnnecessary(), false));
			oRetValue.addAllNegativeUnnecessary(
					changeRowValue(in_oRightRows.getPositiveUnnecessary(), false));
			oRetValue.addAllPositiveUnnecessary(
					changeRowValue(in_oLeftRows.getNegativeUnnecessary(), true));
			oRetValue.addAllPositiveUnnecessary(
					changeRowValue(in_oRightRows.getNegativeUnnecessary(), true));
		}	
		return oRetValue;
	}
	
	public static void getPositiveAndNegativeRows(
			ArrayList<DecisionRowAlternatives> in_colRows,
			ArrayList<DecisionRowAlternatives> io_colPositiveRows,
			ArrayList<DecisionRowAlternatives> io_colNegativeRows)
	{
		for(DecisionRowAlternatives oRow : in_colRows)
		{
			if(oRow.getTruthValue() == true)
				io_colPositiveRows.add(oRow);
			else
				io_colNegativeRows.add(oRow);
		}
	}

	
	public static ArrayList<DecisionRowAlternatives> uniteDecisionRowAlternativeLists(
			ArrayList<DecisionRowAlternatives> in_colFirstAlternatives,
			ArrayList<DecisionRowAlternatives> in_colSecondAlternatives,
			ArrayList<DecisionRowAlternatives> in_colFirstUnnecessaryAlternatives,
			ArrayList<DecisionRowAlternatives> in_colSecondUnnecessaryAlternatives,
			boolean in_bNewTruthValue,
			boolean in_bNewNecessaryValue, 
			boolean in_bCreateRowsForUnnecessaryValues)
	{
		ArrayList<DecisionRowAlternatives> colRetAlternatives = 
			new ArrayList<DecisionRowAlternatives>();

		if(in_colFirstAlternatives.isEmpty() && in_colSecondAlternatives.isEmpty())
			return colRetAlternatives;

//		for(DecisionRowAlternatives oFirstAlternatives : in_colFirstAlternatives)
//		{
//			colRetAlternatives.addAll(uniteAlternativesWithAlternativesList(
//					oFirstAlternatives, in_colSecondAlternatives, 
//					in_colSecondUnnecessaryAlternatives,
//					in_bNewTruthValue, in_bNewNecessaryValue));
//		}
		
		else if(in_colFirstAlternatives.size() > 1 || in_colSecondAlternatives.size() > 1) {
			// one complete alternative for each member of the first group 
			for(DecisionRowAlternatives oFirstAlternatives : in_colFirstAlternatives)
			{
				colRetAlternatives.add(uniteAlternativesWithAlternativesList(
						oFirstAlternatives, in_colSecondAlternatives, 
						null, in_colSecondUnnecessaryAlternatives,
						in_bNewTruthValue, in_bNewNecessaryValue));
			}
	
			// one complete alternative for each member of the second group 
			for(DecisionRowAlternatives oSecondAlternatives : in_colSecondAlternatives)
			{
				colRetAlternatives.add(uniteAlternativesWithAlternativesList(
						oSecondAlternatives, in_colFirstAlternatives, 
						null, in_colFirstUnnecessaryAlternatives, 
						in_bNewTruthValue, in_bNewNecessaryValue));
			}
		}
//		else if(in_colFirstAlternatives.size() > 1) {
//			// one complete alternative for each member of the first group 
//			for(DecisionRowAlternatives oFirstAlternatives : in_colFirstAlternatives)
//			{
//				colRetAlternatives.addAll(uniteAlternativesWithAlternativesList(
//						oFirstAlternatives, in_colSecondAlternatives, 
//						null, in_colSecondUnnecessaryAlternatives,
//						in_bNewTruthValue, in_bNewNecessaryValue));
//				if(in_colSecondAlternatives.size() == 1) {
//					colRetAlternatives.add(
//							uniteDecisionRowAlternativesPlusUnnecessary(
//									in_colSecondAlternatives.get(0),
//									in_colFirstAlternatives.get(0),
//									null,
//									in_colFirstUnnecessaryAlternatives,
//									in_bNewTruthValue,
//									in_bNewNecessaryValue));
//				}
//			}
//		}
//		else if(in_colSecondAlternatives.size() > 1) {
//			// one complete alternative for each member of the second group 
//			for(DecisionRowAlternatives oSecondAlternatives : in_colSecondAlternatives)
//			{
//				colRetAlternatives.addAll(uniteAlternativesWithAlternativesList(
//						oSecondAlternatives, in_colFirstAlternatives, 
//						null, in_colFirstUnnecessaryAlternatives, 
//						in_bNewTruthValue, in_bNewNecessaryValue));
//				if(in_colFirstAlternatives.size() == 1) {
//					colRetAlternatives.add(
//							uniteDecisionRowAlternativesPlusUnnecessary(
//									in_colFirstAlternatives.get(0),
//									in_colSecondAlternatives.get(0),
//									null,
//									in_colSecondUnnecessaryAlternatives,
//									in_bNewTruthValue,
//									in_bNewNecessaryValue));
//				}
//			}			
//		}
		else {
//			if(in_colSecondAlternatives.isEmpty()) {
//				int x = 42;
//				++x;
//			}
//			DecisionRowAlternatives oTmpAlternatives = 
//				uniteDecisionRowAlternatives(
//						in_colFirstAlternatives.get(0), in_colSecondAlternatives.get(0), 
//						in_bNewTruthValue, in_bNewNecessaryValue);
//			if(in_colSecondUnnecessaryAlternatives != null) {
//				for(DecisionRowAlternatives oRunningAlternatives : in_colSecondUnnecessaryAlternatives)
//				{
//					oTmpAlternatives.addAll( 
//						uniteDecisionRowAlternatives(
//								in_colFirstAlternatives.get(0), oRunningAlternatives, 
//								in_bNewTruthValue, in_bNewNecessaryValue));
//				}
//			}
			if(!in_colFirstAlternatives.isEmpty() && !in_colSecondAlternatives.isEmpty()) {
				colRetAlternatives.add(
					uniteDecisionRowAlternativesPlusUnnecessary(
						in_colFirstAlternatives.get(0),
						in_colSecondAlternatives.get(0),
						in_colFirstUnnecessaryAlternatives,
						in_colSecondUnnecessaryAlternatives,
						in_bNewTruthValue,
						in_bNewNecessaryValue));
			}

			
//			colRetAlternatives.add(uniteDecisionRowAlternatives(
//					in_colFirstAlternatives.get(0),
//					in_colSecondAlternatives.get(0),
//					in_bNewTruthValue, 
//					in_bNewNecessaryValue));
		}

		return colRetAlternatives;
	}
	
	private static DecisionRowAlternatives uniteAlternativesWithAlternativesList(
			DecisionRowAlternatives in_oFirstAlternatives,
			List<DecisionRowAlternatives> in_colSecondAlternatives,
			List<DecisionRowAlternatives> in_colFirstUnnecessaryAlternatives,
			List<DecisionRowAlternatives> in_colSecondUnnecessaryAlternatives,
			boolean in_bNewTruthValue,
			boolean in_bNewNecessaryValue)
	{
//		List<DecisionRowAlternatives> oNewAlternativesCollection = 
//			new ArrayList<DecisionRowAlternatives>();
		
		DecisionRowAlternatives oFinalDRA = new DecisionRowAlternatives();
		
		for(DecisionRowAlternatives oSecondAlternatives : in_colSecondAlternatives)
		{
//			oNewAlternativesCollection.add(
//					uniteDecisionRowAlternativesPlusUnnecessary(
//							in_oFirstAlternatives, oRunningAlternatives,
//							in_colFirstUnnecessaryAlternatives,
//							in_colSecondUnnecessaryAlternatives,
//							in_bNewTruthValue, in_bNewNecessaryValue));
			
			
			for(DecisionRowInterface oDRI : uniteDecisionRowAlternatives(
						in_oFirstAlternatives, oSecondAlternatives, 
						in_bNewTruthValue, in_bNewNecessaryValue)) {
				oFinalDRA.add(oDRI);
			}
		}
			
		// add all the unnecessary values -> create unnecesary ones
		if(in_colSecondUnnecessaryAlternatives != null) {
			for(DecisionRowAlternatives oRunningAlternatives2 : in_colSecondUnnecessaryAlternatives)
			{
				for(DecisionRowInterface oDRI : uniteDecisionRowAlternatives(
						in_oFirstAlternatives, oRunningAlternatives2, 
						in_bNewTruthValue, false)) {
					oFinalDRA.add(oDRI);
				}
			}
		}
		
		return oFinalDRA;
//			DecisionRowAlternatives oTmpAlternatives = 
//				uniteDecisionRowAlternatives(
//						in_oAlternatives, oRunningAlternatives, 
//						in_bNewTruthValue, in_bNewNecessaryValue);
//			if(in_colUnnecessaryAlternatives != null) {
//				for(DecisionRowAlternatives oRunningAlternatives2 : in_colUnnecessaryAlternatives)
//				{
//					oTmpAlternatives.addAll( 
//						uniteDecisionRowAlternatives(
//								in_oAlternatives, oRunningAlternatives2, 
//								in_bNewTruthValue, in_bNewNecessaryValue));
//				}
//			}
//			oNewAlternativesCollection.add(oTmpAlternatives);

			
//			oTmpAlternatives =
//				uniteDecisionRowAlternatives(
//						oRunningAlternatives, in_oAlternatives, 
//						in_bNewTruthValue, in_bNewNecessaryValue);
//			oNewAlternativesCollection.add(oTmpAlternatives);
//		}
		
		
//		return oNewAlternativesCollection;
	}
	
	private static DecisionRowAlternatives uniteDecisionRowAlternativesPlusUnnecessary(
			DecisionRowAlternatives in_oFirstAlternatives,
			DecisionRowAlternatives in_oSecondAlternatives,
			List<DecisionRowAlternatives> in_colFirstUnnecessaryAlternatives,
			List<DecisionRowAlternatives> in_colSecondUnnecessaryAlternatives,
			boolean in_bNewTruthValue,
			boolean in_bNewNecessaryValue)
	{
		// combine necessary values -> create a new necessary one
		DecisionRowAlternatives oTmpAlternatives = 
			uniteDecisionRowAlternatives(
					in_oFirstAlternatives, in_oSecondAlternatives, 
					in_bNewTruthValue, in_bNewNecessaryValue);
		// add all the unnecessary values -> create unnecesary ones
		if(in_colFirstUnnecessaryAlternatives != null) {
			for(DecisionRowAlternatives oRunningAlternatives1 : in_colFirstUnnecessaryAlternatives)
			{
				oTmpAlternatives.addAll( 
					uniteDecisionRowAlternatives(
							in_oSecondAlternatives, oRunningAlternatives1, 
							in_bNewTruthValue, false));
			}
		}
		if(in_colSecondUnnecessaryAlternatives != null) {
			for(DecisionRowAlternatives oRunningAlternatives2 : in_colSecondUnnecessaryAlternatives)
			{
				oTmpAlternatives.addAll( 
					uniteDecisionRowAlternatives(
							in_oFirstAlternatives, oRunningAlternatives2, 
							in_bNewTruthValue, false));
			}
		}
		return oTmpAlternatives;
	}
	
	private static DecisionRowAlternatives uniteDecisionRowAlternatives(
			DecisionRowAlternatives in_oFirstAlternatives,
			DecisionRowAlternatives in_oSecondAlternatives,
			boolean in_bNewTruthValue,
			boolean in_bNewNecessaryValue) {
		
		DecisionRowAlternatives oRetAlternatives = new DecisionRowAlternatives();
		DecisionRowContainer oSuperContainer = 
			new DecisionRowContainer(in_bNewNecessaryValue);
		oSuperContainer.setTruthValue(in_bNewTruthValue);
		
		for(DecisionRowInterface oFirstRow : in_oFirstAlternatives)
		{
			// only connect the necessary rows to the other alternatives
			if(!in_bNewNecessaryValue || oFirstRow.getIsNecessary()) {
				for(DecisionRowInterface oSecondRow : in_oSecondAlternatives)
				{
					// decision row container is necessary if both children are necessary and the new one
					// should be necessary at all
					DecisionRowContainer oContainer = 
						new DecisionRowContainer(
								in_bNewNecessaryValue && oFirstRow.getIsNecessary() && oSecondRow.getIsNecessary());
					oContainer.getChildren().add(oFirstRow);
					oContainer.getChildren().add(oSecondRow);
					oContainer.setTruthValue(in_bNewTruthValue);
					oSuperContainer.getChildren().add(oContainer);
				}
			}
		}
		oRetAlternatives.add(oSuperContainer);
		
		return oRetAlternatives;
	}

//	public static ArrayList<DecisionRowAlternatives> keepFirstRowsAndAddAnyElementsOfSecond(
//		ArrayList<DecisionRowAlternatives> in_colFirstRows,
//		ArrayList<DecisionRowAlternatives> in_colSecondRows,
//		boolean in_bNewValue)
//	{
//		ArrayList<DecisionTableExpressionValueSelection> colRetRows = 
//			new ArrayList<DecisionTableExpressionValueSelection>();
//		int nFirstSize = in_colFirstRows.size();
//		int nSecondSize = in_colSecondRows.size();
//		for(int i = 0; i < nFirstSize; ++i)
//		{
//			DecisionTableExpressionValueSelection oSelection = 
//				new DecisionTableExpressionValueSelection();
//			oSelection.putAll(in_colFirstRows.get(i));
//			oSelection.putAll(in_colSecondRows.get(Math.min(i, nSecondSize - 1)));
//			oSelection.setValue(in_bNewValue);
//			colRetRows.add(oSelection);
//		}
//		return colRetRows;
//	}
	
	public static ArrayList<DecisionRowAlternatives> changeRowValue(
		ArrayList<DecisionRowAlternatives> io_colAlternatives,
		boolean in_bNewValue)
	{
		for(DecisionRowAlternatives oSelection : io_colAlternatives)
		{
			for(DecisionRowInterface oRow : oSelection)
			{
				oRow.setTruthValue(in_bNewValue);
			}
		}
		
		return io_colAlternatives;
	}
	
//	public void removeUnnecessaryDecisionRows()
//	{
//		for(DecisionRowAlternatives oAlternatives : this) {
//			ArrayList<DecisionRowInterface> colDeletedRows = 
//				new ArrayList<DecisionRowInterface>();
//			for(DecisionRowInterface oRow : oAlternatives) {
//				if(oRow.getSufficientForTestGoal() == false)
//					colDeletedRows.add(oRow);
//			}
//			oAlternatives.removeAll(colDeletedRows);
//		}
//	}
}
