package net.sf.parteg.base.testcasegraph.coveragecriteria;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableExpressionValueSelection;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableFlat;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;

public class MultipleConditionCoverage extends ControlFlowOrientedCoverage {

	@Override
	public ArrayList<TCGDisjunctiveNormalForm> createDNFsForTestGoals(
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
			
			for(DecisionTableExpressionValueSelection oRow : oDecisionTable)
			{
				TCGDisjunctiveNormalForm oDNF = 
					TCGOCLExpressionHelperClass.
					createDNFForExpressionAndDecisionTableRow(oExpression, oRow);
				
				TCGConjunctionHelperClass.removeContradictingConjunctions(
						oDNF.getConjunctions());
				if(!oDNF.getConjunctions().isEmpty()) {
					colRetDNFs.addAll(TCGDisjunctiveNormalFormHelperClass.
						splitUpDNFsAccordingToInequationsAndConfiguration(oDNF));
				}
			}
		}		
		return colRetDNFs;
	}

}
