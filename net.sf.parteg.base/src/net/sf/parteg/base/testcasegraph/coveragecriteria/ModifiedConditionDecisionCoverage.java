package net.sf.parteg.base.testcasegraph.coveragecriteria;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.decisiontables.DecisionRowAlternatives;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionRowInterface;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableExpressionValueSelection;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableHierarchy;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;

public class ModifiedConditionDecisionCoverage extends
		ControlFlowOrientedCoverage {

	@Override
	public ArrayList<TCGDisjunctiveNormalForm> createDNFsForTestGoals(
			TCGDisjunctiveNormalForm in_oOriginalDNF) 
	{
		if(in_oOriginalDNF.getConjunctions().isEmpty())
		{
			ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
			colRetDNFs.add(GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm());
			return colRetDNFs;
		}
		else
		{
//			return createDNFsWithDNF(in_oOriginalDNF);
//			return createDNFsWithTruthTable(in_oOriginalDNF);
//			return createDNFsWithMCDCAndTruthTableApproach(in_oOriginalDNF);
//			return createDNFsForMaskingMCDCWithIncrementalApproach(
//					in_oOriginalDNF, true);
			return choice(in_oOriginalDNF);
		}
	}
	
	private ArrayList<TCGDisjunctiveNormalForm> choice(
			TCGDisjunctiveNormalForm in_oOriginalDNF)
	{
//		if(keine Variable doppelt referenziert)
//		{
//			return createDNFsWithMCDCAndTruthTableApproach(in_oOriginalDNF);
//		} else {
//			hier müsste evtl. eine weitere Auslese stattfinden???
//			Plan: diese Variante nochmal checken
//			überflüssige und gebrauchte, positive und negative Elemente
//			miteinander verknüpfen
					
			return createDNFsForMaskingMCDCWithIncrementalApproach(
					in_oOriginalDNF, true);
//		}
	}
	
	/*
	 * MC/DC approach:
	 * - for each subexpression just select the necessary value assignments
	 * - combine different value selections just by using each feasible combination 
	 */
	private ArrayList<TCGDisjunctiveNormalForm> createDNFsForMaskingMCDCWithIncrementalApproach(
			TCGDisjunctiveNormalForm in_oOriginalDNF,
			boolean in_bCreateRowsForUnnecessaryValues)
	{
		ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
		
		TCGOCLExpression oExpression = in_oOriginalDNF.getOriginalExpression();
		oExpression = TCGOCLExpressionHelperClass.pushDownNots(oExpression);
		DecisionTableHierarchy oDecisionTable = new DecisionTableHierarchy(oExpression);
		oDecisionTable.buildUpMaskingMCDCDecisionTable(in_bCreateRowsForUnnecessaryValues);
		
		for(DecisionRowAlternatives oAlternatives : oDecisionTable)
		{
			TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
			for(DecisionRowInterface oRow : oAlternatives)
			{
				DecisionTableExpressionValueSelection oResultingSelection =
					new DecisionTableExpressionValueSelection();
				oRow.fillValueSelection(oResultingSelection);
				oResultingSelection.setTruthValue(oRow.getTruthValue());
				// TODO: Performanz erhöhen:
				// Hier werden in oRow schon hierarchisch alle Wahrheitswerte
				// der Altenativen vorgehalten - sie müssen im folgenden
				// Aufruf nicht erst erneut bestimmt werden!
				TCGDisjunctiveNormalForm oTmpDNF = 
					TCGOCLExpressionHelperClass.
					createDNFForExpressionAndDecisionTableRow(oExpression, oResultingSelection);

				TCGConjunctionHelperClass.removeContradictingConjunctions(
						oTmpDNF.getConjunctions());
				if(!oTmpDNF.getConjunctions().isEmpty()) {
					oDNF.getConjunctions().addAll(oTmpDNF.getConjunctions());
				}
			}
			if(!oDNF.getConjunctions().isEmpty()) {
				colRetDNFs.addAll(TCGDisjunctiveNormalFormHelperClass.
					splitUpDNFsAccordingToInequationsAndConfiguration(oDNF));
			}
		}
		return colRetDNFs;		
	}
	
	/*
	 * MC/DC approach:
	 * - for each subexpression just select the necessary value assignments
	 * - combine different value selections just by using each combination at least once
	 */
//	private ArrayList<TCGDisjunctiveNormalForm> createDNFsWithMCDCAndTruthTableApproach(
//			TCGDisjunctiveNormalForm in_oOriginalDNF) {
//	
//		ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
//		
//		TCGOCLExpression oExpression = in_oOriginalDNF.getOriginalExpression();
//		DecisionTableFlat oDecisionTable = new DecisionTableFlat(oExpression);
//		oDecisionTable.buildUpMCDCDecisionTable();
//
//		for(DecisionTableExpressionValueSelection oRow : oDecisionTable)
//		{
//			TCGDisjunctiveNormalForm oDNF = 
//				TCGOCLExpressionHelperClass.
//				createDNFForExpressionAndDecisionTableRow(oExpression, oRow);
//			// TODO ### einige der Ziele können in sich widersprüchlich
//			// oder nicht erreichbar sein - dann müssen Alternativziele definiert werden!
//			// Das kann teilweise aber erst zur Testzeit festgestellt werden
//			// Ansätze: nach "erster Testerzeugungsrunde" evtl. noch weitere
//			// hinterherschieben
//			
//			colRetDNFs.addAll(ExpressionConverter.
//				splitUpDNFsAccordingToInequationsAndConfiguration(oDNF));
//		}
//		return colRetDNFs;		
//	}
	
//	private ArrayList<TCGDisjunctiveNormalForm> createDNFsWithTruthTable(
//			TCGDisjunctiveNormalForm in_oOriginalDNF) {
//		
//		ArrayList<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
//		
//		TCGOCLExpression oExpression = in_oOriginalDNF.getOriginalExpression();
//		DecisionTable oDecisionTable = new DecisionTable(oExpression);
//		
//		
//		for(DecisionTableRow oRow : oDecisionTable)
//		{
//			TCGDisjunctiveNormalForm oDNF = 
//				TCGOCLExpressionHelperClass.createDNFForExpressionAndDecisionTableRow(oExpression, oRow);
//			
//			if(DecisionTableRowEvaluator.evaluateExpressionWithValueAssignment(oExpression, oRow))
//			{
//				colRetDNFs.add(oDNF);
//			}
//			else
//			{
//				colRetDNFs.add(oDNF);
//			}
//		}
//
//		hier weitermachen:
//			2 Dinge zu tun:
//				- Check für MCDC, ob leichte Veränderung in DecisionTableRow anderes Ergebnis bringt
//				- Auflösung von Ungleichungen in TCGOCLExpressions
//		return colRetDNFs;
//	}
	
//	private ArrayList<TCGDisjunctiveNormalForm> createDNFsWithDNF (
//			TCGDisjunctiveNormalForm in_oOriginalDNF) {
//		
//		ArrayList<TCGDisjunctiveNormalForm> colCopyDNF = new ArrayList<TCGDisjunctiveNormalForm>();
//		
//		// find all elements whose result can be changed by changing one predicate
////			colCopyDNF.addAll(ExpressionConverter.
////					getAllDNFsWhoseResultIsChangedByOnePredicateChange(in_oOriginalDNF, 
////							Configuration.getSplitInequationsBeforeTestGoalDefinition()));
//		
//		for(TCGDisjunctiveNormalForm oDNF : ExpressionConverter.
//				getAllDNFsWhoseResultIsChangedByOnePredicateChange(
//						ExpressionConverter.createDisjunctiveNormalForm(
//						in_oOriginalDNF.getOriginalExpression(), false), 
//						Configuration.getSplitInequationsBeforeTestGoalDefinition()))
//		{
//			colCopyDNF.addAll(ExpressionConverter.splitUpWholeDNFsAccordingToInequations(oDNF));
//		}
//		
//		return colCopyDNF;
//	}

}
