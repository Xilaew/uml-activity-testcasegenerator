package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;

public class TCGConjunctionHelperClass {

	public static TCGConjunction copyConjunction(TCGConjunction in_oConjunction)
	{
		TCGConjunction oConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		oConjunction.getExpressions().addAll(in_oConjunction.getExpressions());
		oConjunction.setPositiveSubExpressionOfOriginal(in_oConjunction.isPositiveSubExpressionOfOriginal());
		return oConjunction;
	}
	
	public static TCGConjunction copyConjunctionDeep(TCGConjunction in_oConjunction)
	{
		TCGConjunction oConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		for(TCGOCLExpression oExpression : in_oConjunction.getExpressions())
		{
			oConjunction.getExpressions().add(TCGOCLExpressionHelperClass.copyExpression(oExpression));			
		}
		oConjunction.setPositiveSubExpressionOfOriginal(in_oConjunction.isPositiveSubExpressionOfOriginal());
		return oConjunction;
	}

	public static List<TCGConjunction> copyConjunctionListDeep(List<TCGConjunction> in_oConjunctions)
	{
		List<TCGConjunction> colRetValue = new ArrayList<TCGConjunction>();
		for(TCGConjunction oConjunction : in_oConjunctions) {
			colRetValue.add(copyConjunctionDeep(oConjunction));
		}
		return colRetValue;
	}

	public static void removeRedundantExpressions(TCGConjunction in_oConjunction)
	{
		ArrayList<TCGOCLExpression> colRemovedExpressions = new ArrayList<TCGOCLExpression>();
		OUTERLOOP : for(TCGOCLExpression oFirstExpression : in_oConjunction.getExpressions())
		{
			for(TCGOCLExpression oSecondExpression : in_oConjunction.getExpressions())
			{
				if((oFirstExpression != oSecondExpression) &&
						(!colRemovedExpressions.contains(oSecondExpression)) &&
						TCGOCLExpressionHelperClass.firstExpressionIsSatisfiedBySecondExpression(
								oFirstExpression, oSecondExpression, false))
				{
					colRemovedExpressions.add(oFirstExpression);
					continue OUTERLOOP;
				}
			}			
		}
		in_oConjunction.getExpressions().removeAll(colRemovedExpressions);
	}
	
	public static String toString(TCGConjunction in_oConjunction)
	{
		StringBuffer sRetValue = new StringBuffer();
		sRetValue.append("(");
		if(!in_oConjunction.getExpressions().isEmpty())
		{
			sRetValue.append(
					TCGOCLExpressionHelperClass.toString(
							in_oConjunction.getExpressions().get(0)));
			for(int i = 1; i < in_oConjunction.getExpressions().size(); ++i)
			{
				sRetValue.append(" and " +
						TCGOCLExpressionHelperClass.toString(
								in_oConjunction.getExpressions().get(i)));				
			}
		}
		sRetValue.append(")");
		return sRetValue.toString();
	}
	
	public static void removeDoubleNots(TCGConjunction in_oConjunction)
	{
		List<TCGOCLExpression> colRemoveExps = new ArrayList<TCGOCLExpression>();
		List<TCGOCLExpression> colAddExps = new ArrayList<TCGOCLExpression>();
		for(TCGOCLExpression oExp : in_oConjunction.getExpressions()) {
			TCGOCLExpression oNewExp = TCGOCLExpressionHelperClass.removeDoubleNots(oExp);
			if(oNewExp != oExp) {
				colRemoveExps.add(oExp);
				colAddExps.add(oNewExp);
			}
		}
		in_oConjunction.getExpressions().removeAll(colRemoveExps);
		in_oConjunction.getExpressions().addAll(colAddExps);
	}

	public static void removeContradictingConjunctions(
			List<TCGConjunction> in_colConjunctions)
	{
		ArrayList<TCGConjunction> colConjunctionsToDelete = new ArrayList<TCGConjunction>();
		for(TCGConjunction oConjunction : in_colConjunctions)
		{
			if(!TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(oConjunction).isEmpty())
				colConjunctionsToDelete.add(oConjunction);
		}
		in_colConjunctions.removeAll(colConjunctionsToDelete);
	}

	public static void removeRedundantExpressionsInConjunctions(
			List<TCGConjunction> in_colConjunctions)
	{
		for(TCGConjunction oConjunction : in_colConjunctions)
		{
			removeRedundantExpressions(oConjunction);
		}
	}

	public static void removeRedundantConjunctions(
			List<TCGConjunction> io_colConjunctions)
	{
		ArrayList<TCGConjunction> colRemovedConjunctions = new ArrayList<TCGConjunction>();
		
		for(int i = 0; i < io_colConjunctions.size(); ++i) {
			if(colRemovedConjunctions.contains(io_colConjunctions.get(i)))
				continue;
			
			for(int j = i + 1; j < io_colConjunctions.size(); ++j) {
				if(colRemovedConjunctions.contains(io_colConjunctions.get(j)))
					continue;
				
				if(TCGOCLExpressionHelperClass.expressionListsAreRedundant(io_colConjunctions.get(i).getExpressions(), 
						io_colConjunctions.get(j).getExpressions())) {
					colRemovedConjunctions.add(io_colConjunctions.get(j));
				}
			}
		}
		io_colConjunctions.removeAll(colRemovedConjunctions);
	}

	/*
	 * examines the conditions in the conjunction and searches for contradictions
	 */
	public static List<TCGOCLExpression>
		conditionsInConjunctionAreContradicting(TCGConjunction in_oConjunction)
	{
		return TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(
				in_oConjunction.getExpressions());
	}

	/*
	 * examines the conditions in the conjunction and searches for contradictions
	 */
	public static List<TCGOCLExpression>
		conditionsInConjunctionAreContradicting(List<TCGOCLExpression> in_colExpressions)
	{
		HashMap<EObject, ValueTypeRange> colElementToValueRange = 
			new LinkedHashMap<EObject, ValueTypeRange>();
		HashMap<EObject, ArrayList<TCGOCLExpression>> colElementToExpressions =
			new LinkedHashMap<EObject, ArrayList<TCGOCLExpression>>();
		List<TCGOCLExpression> colContradictingExpressions = 
			new ArrayList<TCGOCLExpression>();
		
		List<TCGOCLExpression> colDynamicExpressions = new ArrayList<TCGOCLExpression>();
		// simple contradiction in just one condition
		for(TCGOCLExpression oExpression : in_colExpressions)
		{
			if(TCGOCLExpressionHelperClass.
					getPassiveDependentVariablesAndInputParameters(oExpression).size() > 1) {
				colDynamicExpressions.add(oExpression);
			}
			else {
				colContradictingExpressions = 
					TCGOCLExpressionHelperClass.conditionsAreContradicting(
							oExpression, colElementToValueRange, colElementToExpressions);
				if(!colContradictingExpressions.isEmpty())
					return colContradictingExpressions;				
			}
		}
		// check dynamic expressions (more than one variable or dependent parameter)
		colContradictingExpressions.addAll(
				TCGOCLExpressionHelperClass.getContradictingDynamicExpressions(colDynamicExpressions));
		return colContradictingExpressions;
	}

	public static TCGOCLExpression convertConjunctionToExpression(
			TCGConjunction in_oConjunction) {
		if (!in_oConjunction.getExpressions().isEmpty()) {
			TCGOCLExpression oExpression = TCGOCLExpressionHelperClass
					.copyExpression(in_oConjunction.getExpressions().get(0));
			for (int i = 1; i < in_oConjunction.getExpressions().size(); ++i) {
				TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE
						.createTCGOCLOperation();
				oNewOperation.setLeft(oExpression);
				oNewOperation.setOperationName("and");
				oNewOperation
						.setRight(TCGOCLExpressionHelperClass
								.copyExpression(in_oConjunction
										.getExpressions().get(i)));
				oExpression = oNewOperation;
			}
			return oExpression;
		}
		return null;
	}

	public static ArrayList<TCGDisjunctiveNormalForm> createDNFsFromConjunctionLists(
				HashMap<TCGConjunction, ArrayList<TCGConjunction>> in_colMapFromOriginalToChangedConjunctions,
				ArrayList<TCGConjunction> in_colCurrentlyChangedConjunctions,
				boolean in_bSplitInequations)
		{
			ArrayList<TCGDisjunctiveNormalForm> colRetValue =
				new ArrayList<TCGDisjunctiveNormalForm>();
			ArrayList<TCGConjunction> colCollectedConjunctions = 
				new ArrayList<TCGConjunction>();
	
			colCollectedConjunctions.addAll(
					combineAllListsOfConjunctions(
							in_colMapFromOriginalToChangedConjunctions, 
							in_colCurrentlyChangedConjunctions, in_bSplitInequations));
			
			if(in_bSplitInequations == true)
			{
				TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInConjunctionList(
						colCollectedConjunctions);
				removeContradictionsFromConjunctionList(colCollectedConjunctions,
						in_colCurrentlyChangedConjunctions);
			}
			// for each conjunction: create a disjunctive normal form
			for(TCGConjunction oConjunction : colCollectedConjunctions)
			{
				TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
				oDNF.getConjunctions().add(oConjunction);
				if(in_bSplitInequations == false)
				{
					TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInConjunctionList(
						oDNF.getConjunctions());
					removeContradictionsFromConjunctionList(oDNF.getConjunctions(),
						in_colCurrentlyChangedConjunctions);
				}
				colRetValue.add(oDNF);
				// remove weaker expressions in conjunction
				for(TCGConjunction oTmpConjunction : oDNF.getConjunctions())
				{
					removeRedundantExpressions(oTmpConjunction);
				}
	//			System.out.println(TCGDisjunctiveNormalFormHelperClass.toString(oDNF));
	
			}
	
			return colRetValue;
		}

	public static ArrayList<TCGConjunction> negatedDisjunctionByNegatingEachExpressionOnce(TCGConjunction in_oConjunction)
	{
		ArrayList<TCGConjunction> colResultValues = new ArrayList<TCGConjunction>();
		for(int i = 0; i < in_oConjunction.getExpressions().size(); ++i)
		{
			TCGOCLExpression oExpression = in_oConjunction.getExpressions().get(i);
			TCGOCLExpression oExpressionCopy = TCGOCLExpressionHelperClass.copyExpression(oExpression);
			oExpressionCopy = net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oExpressionCopy);
			for(TCGConjunction oNewConjunction : TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(oExpressionCopy, false).getConjunctions())
			{
				for(int j = 0; j < in_oConjunction.getExpressions().size(); ++j)
				{
					if(j != i)
					{
						oNewConjunction.getExpressions().add(
								TCGOCLExpressionHelperClass.copyExpression(
										in_oConjunction.getExpressions().get(j)));					
					}
				}
				if(conditionsInConjunctionAreContradicting(oNewConjunction).isEmpty()) {
					colResultValues.add(oNewConjunction);
				}
			}
		}
		return colResultValues;
	}

	private static ArrayList<TCGConjunction> combineAllListsOfConjunctions(
			HashMap<TCGConjunction, ArrayList<TCGConjunction>> in_colConjunctionToDNFs,
			ArrayList<TCGConjunction> in_colSetOfCurrentlyChangedConjunctions,
			boolean in_bRemoveContradictions) 
	{
		ArrayList<TCGConjunction> colConjunctions = 
			new ArrayList<TCGConjunction>();
		ArrayList<ArrayList<TCGConjunction>> colConjunctionLists = 
			new ArrayList<ArrayList<TCGConjunction>>();
		colConjunctionLists.addAll(in_colConjunctionToDNFs.values());
		
		combineAllListsOfConjunctionHelper(colConjunctionLists, colConjunctions, 0,
				in_colSetOfCurrentlyChangedConjunctions, in_bRemoveContradictions);
		return colConjunctions;
	}

	public static void combineAllListsOfConjunctionHelper(
			ArrayList<ArrayList<TCGConjunction>> in_colConjunctionLists,
			ArrayList<TCGConjunction> io_colConjunctions,
			int in_nCurrentConjunctionIndex,
			ArrayList<TCGConjunction> in_colSetOfCurrentlyChangedConjunctions,
			boolean in_bRemoveContradictions) {
		
		if(in_nCurrentConjunctionIndex < in_colConjunctionLists.size())
		{
			ArrayList<TCGConjunction> colConjunctions = new ArrayList<TCGConjunction>();
			if(io_colConjunctions.isEmpty())
			{
				colConjunctions.addAll(in_colConjunctionLists.get(in_nCurrentConjunctionIndex));
			}
			else
			{
				for(TCGConjunction oRunningConjunction : in_colConjunctionLists.get(in_nCurrentConjunctionIndex))
				{
					for(TCGConjunction oExistingConjunction : io_colConjunctions)
					{
						TCGConjunction oNewDNF = copyConjunction(oExistingConjunction);
						oNewDNF.getExpressions().addAll(oRunningConjunction.getExpressions());
						colConjunctions.add(oNewDNF);
					}
				}
			}
			io_colConjunctions.clear();
			io_colConjunctions.addAll(colConjunctions);
			combineAllListsOfConjunctionHelper(in_colConjunctionLists, 
					io_colConjunctions, in_nCurrentConjunctionIndex + 1,
					in_colSetOfCurrentlyChangedConjunctions, in_bRemoveContradictions);
		}
		else if(in_bRemoveContradictions == true)
		{
			removeContradictionsFromConjunctionList(io_colConjunctions,
					in_colSetOfCurrentlyChangedConjunctions);
		}
	}

	public static void removeContradictionsFromConjunctionList(
				List<TCGConjunction> io_colConjunctions,
				ArrayList<TCGConjunction> in_colSetOfCurrentlyChangedConjunctions)
	{
		int x = 0;
		boolean bFoundConflicts = true;
		while(bFoundConflicts == true)
		{
			if(++x > 10)
				return; // Notausstieg
			
			bFoundConflicts = false;
//			ArrayList<TCGConjunction> colAddedConjunction = new ArrayList<TCGConjunction>();
//			ArrayList<TCGConjunction> colRemovedConjunction = new ArrayList<TCGConjunction>();
			// check for resulting conjunctions for inconsistencies
			for(TCGConjunction oConjunction : io_colConjunctions)
			{
				List<TCGOCLExpression> colContradictingExpressions =
						conditionsInConjunctionAreContradicting(oConjunction);
				if(!colContradictingExpressions.isEmpty()) {
					bFoundConflicts = true;
					for(TCGOCLExpression oExpression : colContradictingExpressions)
					{
						boolean bExpressionIsCurrentlyChanged = false;
						for(TCGConjunction oCurrentlyChangedConjunction : in_colSetOfCurrentlyChangedConjunctions) {
							if(oCurrentlyChangedConjunction.getExpressions().contains(oExpression)) {
								bExpressionIsCurrentlyChanged = true;
							}
						}
						// only remove expression if it is not subject to change
						// (e.g., while changing expressions for MC/DC)
						if(bExpressionIsCurrentlyChanged == false) {
							// oExpression is causing a contradiction -> remove it
							oConjunction.getExpressions().remove(oExpression);
							break;
						}
					}
				}
			}
		}
	}

	public static ArrayList<TCGConjunction> getAllNegatedConjunctions(
			TCGConjunction in_oOriginalConjunction,
			boolean in_bSplitInequations) {
		
		ArrayList<TCGConjunction> colRetValue = new ArrayList<TCGConjunction>();
	
		getNegativeConjunctionPermutationsForConjunction(colRetValue,
				in_oOriginalConjunction,
				new ArrayList<TCGDisjunctiveNormalForm>(), 0, 0, in_bSplitInequations);
	
		return colRetValue;
	}

	public static void getNegativeConjunctionPermutationsForConjunction(
			ArrayList<TCGConjunction> io_colNewConjunctions,
			TCGConjunction in_oOriginalConjunction,
			ArrayList<TCGDisjunctiveNormalForm> io_colTemporarilyCollectedDNFs,
			int in_nCurrentExpressionIndex, 
			int in_nNegativeExpressionCounter,
			boolean in_bSplitInequations) 
	{
		// all DNFs collected -> assemble the conjunction
		if (in_nCurrentExpressionIndex >= in_oOriginalConjunction
				.getExpressions().size()) 
		{
			if (in_nNegativeExpressionCounter != 0) {
				// combine the current selection of conjunctions in one new conjunction -> save it
				io_colNewConjunctions.addAll(
						TCGDisjunctiveNormalFormHelperClass.combineAllConjunctionsOfDNFs(io_colTemporarilyCollectedDNFs,
								in_bSplitInequations));
			}
		} else // collect all expression permutations
		{
			// recursion for positive expressions
			TCGOCLExpression oExpression = TCGOCLExpressionHelperClass
					.copyExpression(in_oOriginalConjunction.getExpressions()
							.get(in_nCurrentExpressionIndex));
			TCGDisjunctiveNormalForm oDNF = TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(oExpression, in_bSplitInequations);
			io_colTemporarilyCollectedDNFs.add(oDNF);
	
			getNegativeConjunctionPermutationsForConjunction(io_colNewConjunctions,
					in_oOriginalConjunction, io_colTemporarilyCollectedDNFs,
					in_nCurrentExpressionIndex + 1,
					in_nNegativeExpressionCounter,
					in_bSplitInequations);
			io_colTemporarilyCollectedDNFs.remove(oDNF);
	
			// recursion for negative expressions
			TCGOCLExpression oNegativeExpression = TCGOCLExpressionHelperClass
					.copyExpression(oExpression);
			oNegativeExpression = net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oNegativeExpression);
			oDNF = TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(oNegativeExpression, in_bSplitInequations);
			io_colTemporarilyCollectedDNFs.add(oDNF);
			getNegativeConjunctionPermutationsForConjunction(io_colNewConjunctions,
					in_oOriginalConjunction, io_colTemporarilyCollectedDNFs,
					in_nCurrentExpressionIndex + 1,
					in_nNegativeExpressionCounter + 1,
					in_bSplitInequations);
			io_colTemporarilyCollectedDNFs.remove(oDNF);
		}
	}
	
	public static boolean conjunctionIsEmpty(TCGConjunction in_oConjunction) {
		if(in_oConjunction == null ||
				in_oConjunction.getExpressions().isEmpty())
			return true;
		return false;
	}
	
	public static boolean conjunctionContainsAnInfeasibleExpression(
			TCGConjunction in_oConjunction) {
		
		for(TCGOCLExpression oGuardExpression : in_oConjunction.getExpressions()) {
			List<TCGOCLAtom> colAtoms = TCGOCLExpressionHelperClass.
				getDependentVariableOrInputParameter(oGuardExpression);
			if(colAtoms.size() == 0) {
				try {
					if(!TCGOCLExpressionHelperClass.getBooleanValueIfNegative(oGuardExpression)) {
						return true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}