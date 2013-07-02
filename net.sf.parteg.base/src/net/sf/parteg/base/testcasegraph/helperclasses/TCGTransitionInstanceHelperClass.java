package net.sf.parteg.base.testcasegraph.helperclasses;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

public class TCGTransitionInstanceHelperClass {

	public static boolean checkSatisfactionOfCondition(
			TransitionInstance in_oTransitionInstance,
			TCGDisjunctiveNormalForm in_oDNF)
	{
		// TODO Refactoring: TransitionInstances halten eine Conjunction und nicht eine Menge von Expressions!
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		TCGConjunction oConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		oDNF.getConjunctions().add(oConjunction);
		// 1) collect all used preconditions backwards in the line of transition instances
		// until an event was called
		// 2) the guard condition of the test goal must be satisfied by the
		// guard conditions of the transition instances
		TransitionInstance oTransitionInstance = in_oTransitionInstance;
		// add all conditions of the very transition
		oConjunction.getExpressions().addAll(oTransitionInstance.getUsedPreConditions());

		// if no explicit trigger is given: collect guard conditions until explicit trigger
		while((oTransitionInstance.getCalledEvent() == null ||
				oTransitionInstance.getCalledEvent().isDefaultEvent())) {
			
			oTransitionInstance = oTransitionInstance.getPrecedingTransitionInstance();
			if(oTransitionInstance == null)
				break;
			
			oConjunction.getExpressions().addAll(oTransitionInstance.getUsedPreConditions());
		}
		
		return TCGDisjunctiveNormalFormHelperClass.firstDNFIsSatisfiedBySecondDNF(
				in_oDNF, oDNF, false);
	}
}
