package net.sf.parteg.base.testcasegraph.coveragecriteria;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableExpressionValueSelection;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableFlat;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableRowEvaluator;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;

public class DecisionCoverage extends ControlFlowOrientedCoverage {

	@Override
	public ArrayList<TCGDisjunctiveNormalForm> createDNFsForTestGoals(
			TCGDisjunctiveNormalForm in_oOriginalDNF) {
		
//		return createDNFsWithDNF(in_oOriginalDNF);
		return createDNFsWithTruthTable(in_oOriginalDNF);
	}
	
	private ArrayList<TCGDisjunctiveNormalForm> createDNFsWithTruthTable(
				TCGDisjunctiveNormalForm in_oOriginalDNF) {

		ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = 
			new ArrayList<TCGDisjunctiveNormalForm>();
		
		if(in_oOriginalDNF.getConjunctions().isEmpty())
			colRetDNFs.add(GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm());
		else
		{
			TCGOCLExpression oExpression = in_oOriginalDNF.getOriginalExpression();
			oExpression = TCGOCLExpressionHelperClass.pushDownNots(oExpression);
			DecisionTableFlat oDecisionTable = new DecisionTableFlat(oExpression);
			oDecisionTable.buildUpCompleteDecisionTable();
			
			TCGDisjunctiveNormalForm oPositiveDNF = 
				GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
			TCGDisjunctiveNormalForm oNegativeDNF = 
				GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
			
			for(DecisionTableExpressionValueSelection oRow : oDecisionTable)
			{
				TCGDisjunctiveNormalForm oDNF = 
					TCGOCLExpressionHelperClass.
					createDNFForExpressionAndDecisionTableRow(oExpression, oRow);
				
				TCGConjunctionHelperClass.removeContradictingConjunctions(
						oDNF.getConjunctions());
				if(!oDNF.getConjunctions().isEmpty()) {
					
					if(DecisionTableRowEvaluator.evaluateExpressionWithValueAssignment(
							oExpression, oRow))
					{
//						System.out.println("### positive: " + 
//								TCGDisjunctiveNormalFormHelperClass.toString(oDNF));
						oPositiveDNF.getConjunctions().addAll(oDNF.getConjunctions());
					}
					else
					{
//						System.out.println("### negative: " +
//								TCGDisjunctiveNormalFormHelperClass.toString(oDNF));
						oNegativeDNF.getConjunctions().addAll(oDNF.getConjunctions());
					}
				}
			}
			
			colRetDNFs.addAll(TCGDisjunctiveNormalFormHelperClass.
					splitUpDNFsAccordingToInequationsAndConfiguration(oPositiveDNF));
			colRetDNFs.addAll(TCGDisjunctiveNormalFormHelperClass.
					splitUpDNFsAccordingToInequationsAndConfiguration(oNegativeDNF));

		}
		return colRetDNFs;
	}
	
	
//	private ArrayList<TCGDisjunctiveNormalForm> createDNFsWithDNF (
//				TCGDisjunctiveNormalForm in_oOriginalDNF) {
//
//		ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
//		if(Configuration.getSplitInequationsBeforeTestGoalDefinition())
//		{
//			colRetDNFs.addAll(ExpressionConverter.
//					splitUpWholeDNFsAccordingToInequations(
//							ExpressionConverter.createDisjunctiveNormalForm(
//									in_oOriginalDNF.getOriginalExpression(), false)));
//			
////			TCGDisjunctiveNormalForm oDNF = 
////				ExpressionConverter.createDisjunctiveNormalForm(
////					in_oOriginalDNF.getOriginalExpression(), false);
////			
////			System.out.println("### original ###");
////			System.out.println(TCGDisjunctiveNormalFormHelperClass.toString(oDNF));
////			
////			ArrayList<TCGDisjunctiveNormalForm> colDNF = 
////				ExpressionConverter.splitUpWholeDNFsAccordingToInequations(oDNF);
////
////			System.out.println("### transformed ###");
////			for(TCGDisjunctiveNormalForm oTmpDNF : colDNF)
////			{
////				System.out.println(TCGDisjunctiveNormalFormHelperClass.toString(oTmpDNF));
////			}
////			
////			colRetDNFs.addAll(colDNF);
//			
//			
//		} else {
//			colRetDNFs.add(in_oOriginalDNF);
//		}
//
////		System.out.println("### positive ###");
//		for(TCGDisjunctiveNormalForm oDNF : colRetDNFs)
//		{
//			System.out.println(TCGDisjunctiveNormalFormHelperClass.toString(oDNF));
//		}
//		
//		
//		if(in_oOriginalDNF.getConjunctions() != null &&
//				!in_oOriginalDNF.getConjunctions().isEmpty())
//		{
//			TCGDisjunctiveNormalForm oNegatedDNF = ExpressionConverter.negateDNF(in_oOriginalDNF, false);
//			if(Configuration.getSplitInequationsBeforeTestGoalDefinition())
//			{
////				System.out.println("### negative ###");
//
//				for(TCGDisjunctiveNormalForm oTmpNegatedDNF : ExpressionConverter.splitUpWholeDNFsAccordingToInequations(oNegatedDNF))
//				{
//					System.out.println(TCGDisjunctiveNormalFormHelperClass.toString(oTmpNegatedDNF));
//					TCGDisjunctiveNormalFormHelperClass.removeDoubleNots(oTmpNegatedDNF);
//					TCGConjunctionHelperClass.removeContradictingConjunctions(
//							oTmpNegatedDNF.getConjunctions());
//					TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
//							oTmpNegatedDNF.getConjunctions());
//					TCGConjunctionHelperClass.removeRedundantConjunctions(
//							oTmpNegatedDNF.getConjunctions());
//					colRetDNFs.add(oTmpNegatedDNF);
//				}
//			} else {
//				TCGDisjunctiveNormalFormHelperClass.removeDoubleNots(oNegatedDNF);
//				TCGConjunctionHelperClass.removeContradictingConjunctions(
//						oNegatedDNF.getConjunctions());
//				TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
//						oNegatedDNF.getConjunctions());
//				TCGConjunctionHelperClass.removeRedundantConjunctions(
//						oNegatedDNF.getConjunctions());
//				colRetDNFs.add(oNegatedDNF);
//			}
//		}
//		return colRetDNFs;
//	}
}
