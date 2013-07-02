package net.sf.parteg.base.testcasegraph.coveragecriteria;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;

public class ConditionCoverage extends ControlFlowOrientedCoverage {

	@Override
	public ArrayList<TCGDisjunctiveNormalForm> createDNFsForTestGoals(
			TCGDisjunctiveNormalForm in_oOriginalDNF) {

		// select all atomar boolean expressions from the DNF and 
		// create one positive and one negative DNF for each
		ArrayList<TCGDisjunctiveNormalForm> colResultValue = 
			new ArrayList<TCGDisjunctiveNormalForm>();
		for(TCGConjunction oConjunction : in_oOriginalDNF.getConjunctions())
		{
			for(TCGOCLExpression oExpression : oConjunction.getExpressions())
			{
				TCGOCLExpression oNegatedExpression = 
					net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oExpression);
				TCGDisjunctiveNormalForm oDNF = 
					TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(oNegatedExpression, false);
				colResultValue.add(oDNF);
			}
		}
		
		return colResultValue;
	}


}
