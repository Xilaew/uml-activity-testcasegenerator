package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableExpressionValueSelection;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLParser;
import net.sf.parteg.base.testcasegraph.ocl.parser.TCGOCLVariableClassificator;
import net.sf.parteg.base.testcasegraph.ocl.transformation.TransformOCLToTCGOCL;
import net.sf.parteg.base.testcasegraph.valuetyperanges.OCLExpressionValueTypeRangeFactory;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRangeHelper;

import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;

public class TCGDisjunctiveNormalFormHelperClass {

	public enum PrePostComparisonResult
	{
		FOUND_CONFLICT,
		NO_IMPACT_ON_CONDITION,
		RESOLVED_CONDITION
	}

	public static TCGDisjunctiveNormalForm copyDNF(TCGDisjunctiveNormalForm in_oDNF)
	{
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		oDNF.getConjunctions().addAll(in_oDNF.getConjunctions());
		oDNF.setOriginalExpression(in_oDNF.getOriginalExpression());
		return oDNF;
	}

	public static TCGDisjunctiveNormalForm copyDNFDeep(TCGDisjunctiveNormalForm in_oDNF)
	{
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		if(in_oDNF != null) {
			for(TCGConjunction oConjunction : in_oDNF.getConjunctions())
			{
				oDNF.getConjunctions().add(TCGConjunctionHelperClass.copyConjunctionDeep(oConjunction));			
			}
			oDNF.setOriginalExpression(TCGOCLExpressionHelperClass.copyExpression(in_oDNF.getOriginalExpression()));
		}
		return oDNF;
	}
	
	public static String toString(TCGDisjunctiveNormalForm in_oDNF)
	{
		StringBuffer sRetValue = new StringBuffer();
		if(!in_oDNF.getConjunctions().isEmpty())
		{
			sRetValue.append("truth: " +
					in_oDNF.getConjunctions().get(0).isPositiveSubExpressionOfOriginal() 
					+ System.getProperty("line.separator"));
			sRetValue.append(
					TCGConjunctionHelperClass.toString(
							in_oDNF.getConjunctions().get(0)));
			for(int i = 1; i < in_oDNF.getConjunctions().size(); ++i)
			{
				sRetValue.append(
						System.getProperty("line.separator") + " or " +
						TCGConjunctionHelperClass.toString(
								in_oDNF.getConjunctions().get(i)));				
			}
		}
		return sRetValue.toString();
	}

	public static void removeDoubleNots(
			TCGDisjunctiveNormalForm in_oDNF) {
		for(TCGConjunction oConjunction : in_oDNF.getConjunctions()) {
			TCGConjunctionHelperClass.removeDoubleNots(oConjunction);
		}
	}

	/*
	 * returns disjunctive normal form for a conditions represented as a string,
	 * information about its context and the expected kind of ocl expression
	 */
	public static TCGDisjunctiveNormalForm getDNFForCondition(
			String in_sOCLCondition,
			Namespace in_oNamespace,
			org.eclipse.uml2.uml.Class in_oContextClass,
			String in_sOCLKindId,
			boolean in_bSplitInequations)
	{
		try
		{
			// abstract syntax tree of guard: OCLExpression
			OCLExpression oExpression = OCLParser.parseCondition(
					in_sOCLCondition, in_oNamespace, in_sOCLKindId);
			// create corresponding DNF with TCGOCLExpressions
			TCGDisjunctiveNormalForm oDNF = 
				TCGDisjunctiveNormalFormHelperClass.createDNFForOCLExpression(
						oExpression, in_oNamespace, in_oContextClass,
						in_sOCLKindId, in_bSplitInequations);
			
			TCGDisjunctiveNormalFormHelperClass.removeDoubleNots(oDNF);
			TCGConjunctionHelperClass.removeContradictingConjunctions(
					oDNF.getConjunctions());
			// hier kann nicht mit "<>" umgegangen werden, 
			// "<>" darf hier aber noch nicht aufgelöst werden! (wegen TestGoals)
//			TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
//					oDNF.getConjunctions());
//			TCGConjunctionHelperClass.removeRedundantConjunctions(
//					oDNF.getConjunctions());

			return oDNF;
		}
		catch(Exception e)
		{
			Configuration.handleException(e);
			return GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
//			return null;
		}
	}

	/*
	 * replace all inequations "<>" by "<" and ">"
	 */
	public static void splitUpInequationsInDNF(TCGDisjunctiveNormalForm io_oDNF)
	{
		boolean bFoundInequation = true;
		while(bFoundInequation)
			bFoundInequation = TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInConjunctionList(io_oDNF.getConjunctions());
	}

	/*
	 * replace all inequations "<>" by "<" and ">"
	 */
	public static boolean splitUpInequationsInConjunctionList(List<TCGConjunction> io_colConjunctions)
	{
		boolean bFoundInequation = false;
		ArrayList<TCGConjunction> colNewConjunctions = new ArrayList<TCGConjunction>();
		for(TCGConjunction oConjunction : io_colConjunctions)
		{
			HashMap<TCGOCLExpression, ArrayList<TCGOCLExpression>> colNewExpressions =
				new LinkedHashMap<TCGOCLExpression, ArrayList<TCGOCLExpression>>();
			for(TCGOCLExpression oExpression : oConjunction.getExpressions())
			{
				boolean bIsInequation = false;
				ArrayList<TCGOCLExpression> colInequationExpressions = null;
				if(oExpression instanceof TCGOCLOperation)
				{
					colInequationExpressions =
						TCGOCLExpressionHelperClass.splitUpInequationToExpressionList((TCGOCLOperation)oExpression);
					if(!colInequationExpressions.isEmpty())
					{
						bIsInequation = true;
						bFoundInequation = true;
					}
				}
				if(bIsInequation == false)
				{
					colInequationExpressions = new ArrayList<TCGOCLExpression>();
					colInequationExpressions.add(oExpression);
				}
				colNewExpressions.put(oExpression, colInequationExpressions);
			}
			
			ArrayList<TCGConjunction> colConjunctions = new ArrayList<TCGConjunction>();
			ArrayList<TCGOCLExpression> colNewConjunctionKeyList = new ArrayList<TCGOCLExpression>(
					colNewExpressions.keySet());
			TCGOCLExpressionHelperClass.combineExpressions(colNewExpressions, colConjunctions,
					colNewConjunctionKeyList, 0,
					new ArrayList<TCGOCLExpression>());
			for(TCGConjunction oNewConjunction : colConjunctions)
			{
				oNewConjunction.setPositiveSubExpressionOfOriginal(
						oConjunction.isPositiveSubExpressionOfOriginal());
				colNewConjunctions.add(oNewConjunction);
			}
			
		}
		
		io_colConjunctions.clear();
		io_colConjunctions.addAll(colNewConjunctions);
		return bFoundInequation;
	}

	/*
	 * creates the conjunctive normal form of in_oExpression
	 */
	public static TCGDisjunctiveNormalForm createDisjunctiveNormalForm(
			TCGOCLExpression in_oExpression,
			boolean in_bSplitInequations) {
		
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE
				.createTCGDisjunctiveNormalForm();
		if (in_oExpression == null)
			return oDNF;

		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oExpression;

			// TODO für alle andere booleschen Operatoren erweitern
			if (oOpExp.getOperationName().compareTo("and") == 0) {
				TCGDisjunctiveNormalForm oLeftDNF = createDisjunctiveNormalForm(oOpExp
						.getLeft(), in_bSplitInequations);
				TCGDisjunctiveNormalForm oRightDNF = createDisjunctiveNormalForm(oOpExp
						.getRight(), in_bSplitInequations);
				return connectTwoDNFWithAnd(oLeftDNF, oRightDNF);
			}

			if (oOpExp.getOperationName().compareTo("or") == 0) {
//				TCGDisjunctiveNormalForm oLeftDNF = createDisjunctiveNormalForm(oOpExp
//						.getLeft(), in_bSplitInequations);
//				TCGDisjunctiveNormalForm oRightDNF = createDisjunctiveNormalForm(oOpExp
//						.getRight(), in_bSplitInequations);
//				return connectTwoDNFWithOr(oLeftDNF, oRightDNF);

				 TCGDisjunctiveNormalForm oFirstDNF = null;
				 {
					 TCGOCLExpression oFirstExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getLeft());
					 TCGOCLExpression oSecondExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getRight());
					 oFirstDNF = connectTwoDNFWithAnd(
							 createDisjunctiveNormalForm(oFirstExp, in_bSplitInequations),
							 createDisjunctiveNormalForm(oSecondExp, in_bSplitInequations));
				 }
				
				 TCGDisjunctiveNormalForm oSecondDNF = null;
				 {
					 TCGOCLExpression oFirstExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getLeft());
					 oFirstExp = net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oFirstExp);
					 TCGOCLExpression oSecondExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getRight());
					 oSecondDNF = connectTwoDNFWithAnd(
							 createDisjunctiveNormalForm(oFirstExp, in_bSplitInequations),
							 createDisjunctiveNormalForm(oSecondExp, in_bSplitInequations));
				 }
								
				 TCGDisjunctiveNormalForm oThirdDNF = null;
				 {
					 TCGOCLExpression oFirstExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getLeft());
					 TCGOCLExpression oSecondExp =
						 TCGOCLExpressionHelperClass.copyExpression(oOpExp.getRight());
					 oSecondExp = net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oSecondExp);
					 oThirdDNF = connectTwoDNFWithAnd(
							 createDisjunctiveNormalForm(oFirstExp, in_bSplitInequations),
							 createDisjunctiveNormalForm(oSecondExp, in_bSplitInequations));
				 }
								
				 return connectTwoDNFWithOr(oFirstDNF,
						 connectTwoDNFWithOr(oSecondDNF, oThirdDNF));
			}

			if (oOpExp.getOperationName().compareTo("not") == 0) {
				// negation has to be applicated to all sub-expressions
				// TODO: introduce unary operation - which side holds the
				// information?
				TCGOCLExpression oNegatedExpression = null; 
				if (oOpExp.getLeft() != null) {
					oNegatedExpression = oOpExp.getLeft();
				} else if (oOpExp.getRight() != null) {
					oNegatedExpression = oOpExp.getRight();
				}
				if(TCGOCLExpressionHelperClass.isBooleanAtom(oNegatedExpression)) {
					oDNF.getConjunctions().add(
							GeneratedFactory.eINSTANCE.createTCGConjunction());
					oDNF.getConjunctions().get(0).getExpressions().add(
							TCGOCLExpressionHelperClass.copyExpression(in_oExpression));
					return oDNF;
				}
				else {
//					oOpExp.setLeft(negateTCGOCLExpression(oNegatedExpression));
//					return createDisjunctiveNormalForm(oOpExp.getLeft(), in_bSplitInequations);
					oNegatedExpression = net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oNegatedExpression);
					return createDisjunctiveNormalForm(oNegatedExpression, in_bSplitInequations);
				}
			}

			// split equations only if necessary
			if(in_bSplitInequations == true)
			{
				// operation name = "<>"
				TCGDisjunctiveNormalForm oNewDNF = TCGOCLExpressionHelperClass.splitUpInequationToDNF(oOpExp);
				if(oNewDNF != null)
					return oNewDNF;
			}

			/*
			 * if(oOpExp.getOperationName().compareTo("not removed") == 0) {
			 * if(oOpExp.getLeft() != null) { return
			 * createDisjunctiveNormalForm(oOpExp.getLeft()); } else
			 * if(oOpExp.getRight() != null) { return
			 * createDisjunctiveNormalForm(oOpExp.getRight()); } }
			 */
		} else if (in_oExpression instanceof TCGOCLIfThenElse) {
			TCGOCLIfThenElse oTCGIfThenElse = (TCGOCLIfThenElse) in_oExpression;

			// condition satisfied
			TCGDisjunctiveNormalForm oConditionDNF = createDisjunctiveNormalForm(oTCGIfThenElse
					.getCondition(), in_bSplitInequations);
			TCGDisjunctiveNormalForm oThenDNF = createDisjunctiveNormalForm(oTCGIfThenElse
					.getThenExpression(), in_bSplitInequations);
			TCGDisjunctiveNormalForm oSatisfiedDNF = connectTwoDNFWithAnd(
					oConditionDNF, oThenDNF);

			// condition violated
			oTCGIfThenElse.setCondition(net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oTCGIfThenElse.getCondition()));
			TCGDisjunctiveNormalForm oNotConditionDNF = createDisjunctiveNormalForm(oTCGIfThenElse
					.getCondition(), in_bSplitInequations);
			TCGDisjunctiveNormalForm oElseDNF = createDisjunctiveNormalForm(oTCGIfThenElse
					.getElseExpression(), in_bSplitInequations);
			TCGDisjunctiveNormalForm oViolatedDNF = connectTwoDNFWithAnd(
					oNotConditionDNF, oElseDNF);

			return connectTwoDNFWithOr(oSatisfiedDNF, oViolatedDNF);
		}

		oDNF.getConjunctions().add(
				GeneratedFactory.eINSTANCE.createTCGConjunction());
		oDNF.getConjunctions().get(0).getExpressions().add(
				TCGOCLExpressionHelperClass.copyExpression(in_oExpression));
		return oDNF;
	}
	
	/*
	 * splits up inequations in DNFs - depending on the configuration
	 */
	public static List<TCGDisjunctiveNormalForm> splitUpDNFsAccordingToInequationsAndConfiguration(
			TCGDisjunctiveNormalForm in_oDNF)
	{
		List<TCGDisjunctiveNormalForm> colRetDNFs = new ArrayList<TCGDisjunctiveNormalForm>();
		if(Configuration.getSplitInequationsBeforeTestGoalDefinition() == true)
		{
			colRetDNFs.addAll(
					TCGDisjunctiveNormalFormHelperClass.splitUpWholeDNFsAccordingToInequations(in_oDNF));
		}
		else
		{
			splitUpInequationsInDNF(in_oDNF);
			colRetDNFs.add(in_oDNF);
		}
		return colRetDNFs;
	}
	
	/*
	 * returns a list of DNFs that were just splitted because of splitting up inequations
	 */
	public static ArrayList<TCGDisjunctiveNormalForm> splitUpWholeDNFsAccordingToInequations(
			TCGDisjunctiveNormalForm in_oDNF)
	{
		ArrayList<TCGDisjunctiveNormalForm> colRetValues = new ArrayList<TCGDisjunctiveNormalForm>();
		colRetValues.add(in_oDNF);
		boolean bFoundInequation = true;
		while(bFoundInequation == true)
		{
			bFoundInequation = false;
			for(TCGDisjunctiveNormalForm oDNF : colRetValues)
			{
				ArrayList<TCGConjunction> colAddedConjunctions = new ArrayList<TCGConjunction>();
				TCGConjunction oRemovedConjunctions = null;
				CONJUNCTION: for(TCGConjunction oConjunction : oDNF.getConjunctions())
				{
					for(TCGOCLExpression oExpression : oConjunction.getExpressions())
					{
						if(oExpression instanceof TCGOCLOperation)
						{
							ArrayList<TCGOCLExpression> colExpressions = 
								TCGOCLExpressionHelperClass.splitUpInequationToExpressionList((TCGOCLOperation)oExpression);
							if(!colExpressions.isEmpty()) // replaced inequations
							{
								oConjunction.getExpressions().remove(oExpression);
								TCGConjunction oNewConjunction = 
									TCGConjunctionHelperClass.copyConjunctionDeep(oConjunction);
								
								oConjunction.getExpressions().add(colExpressions.get(0));
								oNewConjunction.getExpressions().add(colExpressions.get(1));
								oNewConjunction.setPositiveSubExpressionOfOriginal(
										oConjunction.isPositiveSubExpressionOfOriginal());
								colAddedConjunctions.add(oConjunction);
								colAddedConjunctions.add(oNewConjunction);
								oRemovedConjunctions = oConjunction;
								bFoundInequation = true;
								break CONJUNCTION;
							}
						}
					}
				}
				if(bFoundInequation == true)
				{
					oDNF.getConjunctions().remove(oRemovedConjunctions);
					TCGDisjunctiveNormalForm oNewDNF = copyDNFDeep(oDNF);
					oDNF.getConjunctions().add(colAddedConjunctions.get(0));
					oNewDNF.getConjunctions().add(colAddedConjunctions.get(1));
					
					colRetValues.add(oNewDNF);
					break;
				}
			}
		}
		return colRetValues;
	}
	
	public static TCGDisjunctiveNormalForm negateDNF(
			TCGDisjunctiveNormalForm in_oDNF,
			boolean in_bSplitInequations) {
	//		TCGOCLExpression oExpression = convertDNFToExpression(in_oDNF);
		TCGOCLExpression oExpression = 
			TCGOCLExpressionHelperClass.copyExpression(in_oDNF.getOriginalExpression());
	//		TCGOCLExpression oExpression = in_oDNF.getOriginalExpression();
		oExpression = TCGOCLExpressionHelperClass.
			negateLogicalTCGOCLExpression(oExpression);
	//		System.out.println("*** *** ***");
	//		System.out.println(TCGOCLExpressionHelperClass.toString(oExpression));
		TCGDisjunctiveNormalForm oRetValue = createDisjunctiveNormalForm(oExpression, in_bSplitInequations);
		// mark all contained conjunctions as negative elements
		for(TCGConjunction oConjunction : oRetValue.getConjunctions())
		{
			oConjunction.setPositiveSubExpressionOfOriginal(false);
		}
		return oRetValue;
	}
	
	public static TCGOCLExpression convertDNFToExpression(
			TCGDisjunctiveNormalForm in_oDNF) {
		if (!in_oDNF.getConjunctions().isEmpty()) {
			TCGOCLExpression oExpression = TCGConjunctionHelperClass.convertConjunctionToExpression(in_oDNF
					.getConjunctions().get(0));
			for (int i = 1; i < in_oDNF.getConjunctions().size(); ++i) {
				TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE
						.createTCGOCLOperation();
				oNewOperation.setLeft(oExpression);
				oNewOperation.setOperationName("or");
				TCGOCLExpression oCurrentExpression = TCGConjunctionHelperClass.convertConjunctionToExpression(in_oDNF
						.getConjunctions().get(i));
				oNewOperation.setRight(oCurrentExpression);
				oExpression = oNewOperation;
			}
			return oExpression;
		}
		return null;
	}
	
	public static TCGDisjunctiveNormalForm connectTwoDNFWithAnd(
			TCGDisjunctiveNormalForm in_oLeftDNF,
			TCGDisjunctiveNormalForm in_oRightDNF) {
		TCGDisjunctiveNormalForm oResultDNF = GeneratedFactory.eINSTANCE
				.createTCGDisjunctiveNormalForm();
		for (TCGConjunction oLeftConjunction : in_oLeftDNF.getConjunctions()) {
			for (TCGConjunction oRightConjunction : in_oRightDNF
					.getConjunctions()) {
				TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE
						.createTCGConjunction();
				oNewConjunction.getExpressions().addAll(
						oLeftConjunction.getExpressions());
				oNewConjunction.getExpressions().addAll(
						oRightConjunction.getExpressions());
				oResultDNF.getConjunctions().add(oNewConjunction);
			}
		}
		return oResultDNF;
	}
	
	public static TCGDisjunctiveNormalForm connectTwoDNFWithOr(
			TCGDisjunctiveNormalForm in_oLeftDNF,
			TCGDisjunctiveNormalForm in_oRightDNF) {
		TCGDisjunctiveNormalForm oResultDNF = GeneratedFactory.eINSTANCE
				.createTCGDisjunctiveNormalForm();
		for (TCGConjunction oLeftConjunction : in_oLeftDNF.getConjunctions()) {
			oResultDNF.getConjunctions().add(oLeftConjunction);
		}
		for (TCGConjunction oRightConjunction : in_oRightDNF.getConjunctions()) {
			oResultDNF.getConjunctions().add(oRightConjunction);
		}
		return oResultDNF;
	}
	
	public static ArrayList<TCGDisjunctiveNormalForm> getAllDNFsWhoseResultIsChangedByOnePredicateChange(
				TCGDisjunctiveNormalForm in_oOriginalDNF,
				boolean in_bSplitInequations) 
		{
			// result
			ArrayList<TCGDisjunctiveNormalForm> colRetValue = new ArrayList<TCGDisjunctiveNormalForm>();
	
			/*
			 * create all instances (as conjunctions) whose result is changed if
			 * a certain predicate value is changed.
			 * strategy: for each conjunction Ci create all positive conjunctions for
			 *   Ci and all negative conjunctions that can be changed by changing one predicate
			 *   -> all other conjunctions are negative (do not have any influence on the result)
			 */
			for (int i = 0; i < in_oOriginalDNF.getConjunctions().size(); ++i) {
	
				// mapping from original Conjunction to a list of DNFs representing possible variances
				// build up two maps: one for the positive expressions that can be changed
				// and one for the negative expressions that can be changed
				HashMap<TCGConjunction, ArrayList<TCGConjunction>> colPositiveMapFromOriginalToChangedConjunctions = 
					new LinkedHashMap<TCGConjunction, ArrayList<TCGConjunction>>();
				HashMap<TCGConjunction, ArrayList<TCGConjunction>> colNegativeMapFromOriginalToChangedConjunctions = 
					new LinkedHashMap<TCGConjunction, ArrayList<TCGConjunction>>();
	
				// this is the only positive and unchanged conjunction - all others are changed in every possible way
				TCGConjunction oCurrentConjunction = in_oOriginalDNF.getConjunctions().get(i);
				
				ArrayList<TCGConjunction> colPositiveConjunctions = 
					new ArrayList<TCGConjunction>();
				colPositiveConjunctions.add(oCurrentConjunction);
				
				ArrayList<TCGConjunction> colNegativeConjunctions = 
					new ArrayList<TCGConjunction>();
				colNegativeConjunctions.addAll(
						TCGConjunctionHelperClass.negatedDisjunctionByNegatingEachExpressionOnce(oCurrentConjunction));
	
				// start mappings
				colPositiveMapFromOriginalToChangedConjunctions.put(
						oCurrentConjunction, colPositiveConjunctions);
				colNegativeMapFromOriginalToChangedConjunctions.put(
						oCurrentConjunction, colNegativeConjunctions);
				
				// for each remaining conjunction of the DNF: add their negatives
				for (int j = 0; j < in_oOriginalDNF.getConjunctions().size(); ++j) {
					if (j != i) {
						ArrayList<TCGConjunction> colChangedConjunctions = 
							TCGConjunctionHelperClass.getAllNegatedConjunctions(in_oOriginalDNF.getConjunctions().get(j), in_bSplitInequations);
						
						colPositiveMapFromOriginalToChangedConjunctions.put(in_oOriginalDNF
								.getConjunctions().get(j), colChangedConjunctions);
						colNegativeMapFromOriginalToChangedConjunctions.put(in_oOriginalDNF
								.getConjunctions().get(j), colChangedConjunctions);
					}
				}
				// collected all DNFs for each original conjunction - now combine them
	//			System.out.println("### positive DNFs");
				colRetValue.addAll(TCGConjunctionHelperClass.createDNFsFromConjunctionLists(
						colPositiveMapFromOriginalToChangedConjunctions,
						colPositiveConjunctions, in_bSplitInequations));
				
	//			System.out.println("### negative DNFs");
				ArrayList<TCGDisjunctiveNormalForm> colNegativeRetValues = 
					new ArrayList<TCGDisjunctiveNormalForm>();
				colNegativeRetValues.addAll(TCGConjunctionHelperClass.createDNFsFromConjunctionLists(
						colNegativeMapFromOriginalToChangedConjunctions,
						colNegativeConjunctions, in_bSplitInequations));
				// mark all negative return values as "negative"
				for(TCGDisjunctiveNormalForm oNegativeDNF : colNegativeRetValues)
				{
					for(TCGConjunction oNegativeConjunction : oNegativeDNF.getConjunctions())
					{
						oNegativeConjunction.setPositiveSubExpressionOfOriginal(false);
					}
				}
				colRetValue.addAll(colNegativeRetValues);
				
				// remove redundant disjunctions
				ArrayList<TCGDisjunctiveNormalForm> colRemovedDisjunctions = 
					new ArrayList<TCGDisjunctiveNormalForm>();
				for(TCGDisjunctiveNormalForm oFirstDNF : colRetValue)
				{
					for(TCGDisjunctiveNormalForm oSecondDNF : colRetValue)
					{
						if((oFirstDNF != oSecondDNF) &&
							!colRemovedDisjunctions.contains(oSecondDNF) &&
							TCGDisjunctiveNormalFormHelperClass.firstDNFIsSatisfiedBySecondDNF(
									oFirstDNF, oSecondDNF, true))
						{
							colRemovedDisjunctions.add(oFirstDNF);
							break;
						}
					}
				}
				colRetValue.removeAll(colRemovedDisjunctions);
			}
	
			return colRetValue;
		}
	
	/*
	 * combines all combinations of conjunctions of the DNFs to a list of conjunctions 
	 */
	public static ArrayList<TCGConjunction> combineAllConjunctionsOfDNFs(
			ArrayList<TCGDisjunctiveNormalForm> in_colDNFs,
			boolean in_bRemoveContradictions) 
	{
		ArrayList<TCGConjunction> colConjunctions = 
			new ArrayList<TCGConjunction>();
		ArrayList<ArrayList<TCGConjunction>> colConjunctionLists = 
			new ArrayList<ArrayList<TCGConjunction>>();
		for(TCGDisjunctiveNormalForm oDNF : in_colDNFs)
		{
			ArrayList<TCGConjunction> colTmpConjunctions = new ArrayList<TCGConjunction>();
			for(TCGConjunction oConjunction : oDNF.getConjunctions())
			{
				colTmpConjunctions.add(oConjunction);
			}
			colConjunctionLists.add(colTmpConjunctions);
		}
		TCGConjunctionHelperClass.combineAllListsOfConjunctionHelper(colConjunctionLists, colConjunctions, 0,
				new ArrayList<TCGConjunction>(), in_bRemoveContradictions);
		return colConjunctions;
	}
	
	/*
	 * creates the conjunctive normal form of in_oExpression
	 */
	public static void createRestrictedDisjunctiveNormalForm(
			TCGOCLExpression in_oExpression,
			DecisionTableExpressionValueSelection in_oRow,
			boolean in_bSplitInequations,
			TCGDisjunctiveNormalForm out_oDNF) {
		
		if (in_oExpression == null)
			return;

		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oExpression;

			// TODO für alle anderen booleschen Operatoren erweitern
			if (oOpExp.getOperationName().equals("and") ||
					oOpExp.getOperationName().equals("or"))
			{
				createRestrictedDisjunctiveNormalForm(
						oOpExp.getLeft(), in_oRow, in_bSplitInequations, out_oDNF);
				createRestrictedDisjunctiveNormalForm(
						oOpExp.getRight(), in_oRow, in_bSplitInequations, out_oDNF);
				return;
			}
			else if(oOpExp.getOperationName().equals("not")) {
				TCGOCLExpression oTmpExp = TCGOCLExpressionHelperClass.removeDoubleNots(oOpExp);
				if(oTmpExp instanceof TCGOCLOperation) {
					oOpExp = (TCGOCLOperation)oTmpExp;

					// removed double nots - still not?
					if(oOpExp.getOperationName().equals("not") &&
							!TCGOCLExpressionHelperClass.isBooleanAtom(
									TCGOCLExpressionHelperClass.getNonNullLeftOrRight(oOpExp))) {
						createRestrictedDisjunctiveNormalForm(
								TCGOCLExpressionHelperClass.getNonNullLeftOrRight(oOpExp),
								in_oRow, in_bSplitInequations, out_oDNF);
						return;
					}
				}
			}
			
			// split equations only if necessary
			if(in_bSplitInequations == true)
			{
				// operation name = "<>"
				TCGDisjunctiveNormalForm oNewDNF = TCGOCLExpressionHelperClass.splitUpInequationToDNF(oOpExp);
				connectTwoDNFWithAnd(out_oDNF, oNewDNF);
//				in_oRow.get(oOpExp);
				return;
			}
		}
		
		// If-Then-Else
		else if (in_oExpression instanceof TCGOCLIfThenElse) {
			TCGOCLIfThenElse oTCGIfThenElse = (TCGOCLIfThenElse) in_oExpression;

			// condition satisfied
			if(in_oRow.get(oTCGIfThenElse.getCondition()) == true)
			{
				createRestrictedDisjunctiveNormalForm(
						oTCGIfThenElse.getCondition(), 
						in_oRow, in_bSplitInequations, out_oDNF);
				createRestrictedDisjunctiveNormalForm(
						oTCGIfThenElse.getThenExpression(), 
						in_oRow, in_bSplitInequations, out_oDNF);
				return;
			}
			else
			{
				// condition violated
				oTCGIfThenElse.setCondition(
						net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oTCGIfThenElse.getCondition()));
				createRestrictedDisjunctiveNormalForm(oTCGIfThenElse.getCondition(), 
						in_oRow, in_bSplitInequations, out_oDNF);
				createRestrictedDisjunctiveNormalForm(oTCGIfThenElse.getElseExpression(), 
							in_oRow, in_bSplitInequations, out_oDNF);
				return;
			}
		} 

		for(TCGConjunction oConjunction : out_oDNF.getConjunctions()) {
			oConjunction.getExpressions().add(
				TCGOCLExpressionHelperClass.copyExpression(in_oExpression));
		}
	}

	public static TCGDisjunctiveNormalForm createDNFForOCLExpression(
			OCLExpression in_oOCLExpression,
			Namespace in_oNamespace,
			org.eclipse.uml2.uml.Class in_oContextClass,
			String in_sOCLKind,
			boolean in_bSplitInequations)
	{
		TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
				in_oOCLExpression, in_sOCLKind, in_oNamespace, in_oContextClass);
		// transform to DNF
		TCGDisjunctiveNormalForm oDNF = 
			createDisjunctiveNormalForm(oTCGOCLExp, in_bSplitInequations);
		oTCGOCLExp = TCGOCLExpressionHelperClass.pushDownNots(oTCGOCLExp);
		oDNF.setOriginalExpression(oTCGOCLExp);
		return oDNF;
	}

	/**
		 * This method connects two expressions under consideration of a given property.
		 * The left sides of both parameters are references to the same property.
		 * The right sides of both conditions are put into a new expression.
		 * @param in_oPrecondition
		 * @param in_oPostcondition
		 * @param in_oProperty the active dependend variable has to reference this property
		 * @return defines if the evaluation shows that pre- and postconditions are conflicting! 
		 */
		public static boolean connectPreconditionAndASetOfPostconditions(
				TCGOCLExpression in_oPrecondition, 
				Property in_oProperty,
				TCGDisjunctiveNormalForm in_colPostcondition,
				ArrayList<TCGOCLExpression> in_colNewExpressions)
		{
			/** TODO TODO TODO Vergleich OCL Vor- und Nachbedingungen!
			 * Wie wird eine Vorbedingung mit mehreren ver-UND-eten Nachbedingungen verknüpft?
			 * 1) Alle Nachbedingungen suchen, die den Parameter enthalten, der bei der Vorbedingung aktiv ist
			 * 2) Vergleich anstellen
			 * 2.1) wenn Nachbedingung weitere passive abhängige Elemente enthält: rekursiver Funktionsruf ohne 
			 *      gerade bearbeitete Nachbedingung + Aufnahme 
			 * 2.2) wenn Nachbedingung Eingabeparameter enthält: in die Liste der neuen Ausdrücke aufnehmen
			 * 2.3) wenn Nachbedingung sonst nur Konstanten enthält: ...
			 * 
			 * ganz spezieller Fall:
			 * 1) Postcondition enthält weitere abhängige -> weitersuchen: 
			 *    ohne @pre -> in eigener Postcondition; mit @pre -> in vorhergehenden Postconditions
			 * 2) Postcondition enthält keine weitere abhängige -> Vor- und Nachbedingung vergleichen:
			 *    wenn aus Postcondition die Precondition folgt, dann alle weiteren Nachbedingungen als wahr annehmen
			 *    -> wenn passive Abhängige in Bezug zu Konstante gesetzt werden -> in vorherigen Postconditions suchen 
			 */
			for(TCGConjunction oConjunction : in_colPostcondition.getConjunctions())
			for(TCGOCLExpression oPostCondition : oConjunction.getExpressions())
			{
				TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(oPostCondition);
				// for all active dependent atoms ...
				for(TCGOCLAtom oActiveExpression : 
					oClassificator.getClassifiedElementsInExpression(
							VariableClassification.ACTIVE_DEPENDENT)) {
					
					TCGOCLAtom oAtomExp = (TCGOCLAtom)oActiveExpression;
					if(oAtomExp.getElement().equals(in_oProperty))
					{
						oClassificator.shiftSubexpressionToTheLeft(oActiveExpression);
						if(oClassificator.getExpression() instanceof TCGOCLOperation)
						{
							TCGOCLOperation oOperation = (TCGOCLOperation)oClassificator.getExpression();
							TCGOCLVariableClassificator oRightSubClassificator = new TCGOCLVariableClassificator(oOperation.getRight());
							
							// does the right side contain an active dependent element? -> schwierig -> dafür oActiveExpression und
							// oActiveSubExpression auseinanderhalten !
							//TCGOCLExpression oActiveSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);
	
							// does the right side contain a passive dependent element?
							List<TCGOCLAtom> colPassiveDependentSubExpression = 
								oRightSubClassificator.getClassifiedElementsInExpression(
										VariableClassification.PASSIVE_DEPENDENT);
							List<TCGOCLAtom> colInputParameterSubExpression = 
								oRightSubClassificator.getClassifiedElementsInExpression(
										VariableClassification.INPUT_PARAMETER);
							
							if((!colPassiveDependentSubExpression.isEmpty()) || 
									(!colInputParameterSubExpression.isEmpty())) {
								TCGOCLExpression oNewExp = TCGOCLExpressionHelperClass.connectPreconditionAndPostcondition(in_oPrecondition, oPostCondition);
								if(oNewExp != null)
									in_colNewExpressions.add(oNewExp);
							} else { // does the right side contain just independent elements?
								// compare the expressions of both elements!
								ValueTypeRange oPostConditionRange =
									OCLExpressionValueTypeRangeFactory.
									getValueTypeRangeForRightSideOfExpression(
											oOperation);
								ValueTypeRange oPreConditionRange =
									OCLExpressionValueTypeRangeFactory.
									getValueTypeRangeForRightSideOfExpression(
											in_oPrecondition);
								
								
	//							TCGEquivalenceClass oEqPostconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(oOperation);
	//							TCGEquivalenceClass oEqPreconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(in_oPrecondition);
	//							if(oEqPostconditionClass != null && oEqPreconditionClass != null)
								if(oPostConditionRange != null && oPreConditionRange != null)
								{
									// postcondition 
									if(ValueTypeRangeHelper.outerVTRangeContainsInnerVTRange(oPreConditionRange, oPostConditionRange, false))
									//if(ConversionController.outerEquivalenceClassContainsInnerClass(oEqPreconditionClass, oEqPostconditionClass, false))
									{
										// alle Elemente der Konjunktion durchsuchen
										for(TCGConjunction oIndependentConjunction : in_colPostcondition.getConjunctions())
										for(TCGOCLExpression oIndependentPostCondition : oIndependentConjunction.getExpressions())
										{
											// außer der gerade behandelten Nachbedingung
											if(oIndependentPostCondition != oPostCondition)
											{
												TCGOCLVariableClassificator oIndependentClassificator = new TCGOCLVariableClassificator(oIndependentPostCondition);
												if(oIndependentClassificator.getClassifiedElementsInExpression(VariableClassification.ACTIVE_DEPENDENT).isEmpty())
												{
													// die Elemente ohne aktive Variablen weiter in früheren Postconditions checken
													in_colNewExpressions.add(oIndependentPostCondition);
												}
											}
										}
										return false;
									}
									else
										return true; // conflict!
								}
								return false;
							}						
						}
					}
					else {
						System.err.println("something is missing");
					}
				}
			}
			return false;
		}

	/**
		 * This method connects two expressions.
		 * The left sides of both parameters are references to the same property.
		 * The right sides of both conditions are put into a new expression.
		 * @param in_oPrecondition
		 * @param in_oPostcondition
		 * @return defines if the evaluation shows that pre- and postconditions are conflicting! 
		 */
		public static PrePostComparisonResult connectPreconditionAndASetOfPostconditions(
				TCGOCLExpression in_oPrecondition, 
				TCGDisjunctiveNormalForm in_colPostcondition,
				ArrayList<TCGOCLExpression> in_colNewExpressions,
				TCGConjunction io_oPostConjunction)
		{
			// return value that describes the result of the operation
			PrePostComparisonResult eRetValue = 
				PrePostComparisonResult.NO_IMPACT_ON_CONDITION;
			// value range for precondition
			ValueTypeRange oPreValueRange = 
				OCLExpressionValueTypeRangeFactory.getValueTypeRangeForRightSideOfExpression(
						in_oPrecondition);
	
			// iterate over all expressions of all postcondition conjunctions
			for(TCGConjunction oPostConjunction : in_colPostcondition.getConjunctions()) {
				EXPRESSIONLOOP: for(TCGOCLExpression oPostCondition : oPostConjunction.getExpressions()) {
					
					TCGOCLVariableClassificator oClassificator = 
						new TCGOCLVariableClassificator(oPostCondition);
					for(TCGOCLAtom oActivePostExpression : 
						oClassificator.getClassifiedElementsInExpression(
								VariableClassification.ACTIVE_DEPENDENT)) {
						
						oClassificator.shiftSubexpressionToTheLeft(oActivePostExpression);
						TCGOCLAtom oAtomPostExp = (TCGOCLAtom)oActivePostExpression;
						
						// 1) precondition references the same active object as postcondition
						// 2) expression is an operation (else a transformation is not possible)
						if((TCGOCLExpressionHelperClass.conditionContainsReferenceToObject(
							in_oPrecondition, oAtomPostExp.getElement()))) //  &&
							//oClassificator.getExpression() instanceof TCGOCLOperation)
						{
							
							TCGOCLVariableClassificator oRightSubClassificator = 
								new TCGOCLVariableClassificator(oClassificator.getExpression());
							
							// does the right side contain a passive dependent element?
							List<TCGOCLAtom> colPassiveDependentSubExpression = 
								oRightSubClassificator.getClassifiedElementsInExpression(
										VariableClassification.PASSIVE_DEPENDENT);
							List<TCGOCLAtom> colInputParameterSubExpression = 
								oRightSubClassificator.getClassifiedElementsInExpression(
										VariableClassification.INPUT_PARAMETER);
							
							if((!colPassiveDependentSubExpression.isEmpty()) || 
									(!colInputParameterSubExpression.isEmpty()))
							{
								TCGOCLExpression oNewExpression = TCGOCLExpressionHelperClass.connectPreconditionAndPostcondition(
										in_oPrecondition, oPostCondition); 
								if(oNewExpression != null) {
									in_colNewExpressions.add(oNewExpression);
								}
								io_oPostConjunction.getExpressions().addAll(
										oPostConjunction.getExpressions());
								eRetValue = PrePostComparisonResult.RESOLVED_CONDITION;
							}
							else { // does the right side contain just independent elements?

//								Hier ansetzen - Postcondition kann auch LateEvaluationGroups erzeugen
								// TODO : AA hier Abhängigkeiten bei postconditions einbauen
//								List<TCGOCLAtom> colChangeableParameters = 
//									TCGOCLExpressionHelperClass.getPassiveDependentVariablesAndInputParameters(oPostCondition);

								ValueTypeRange oPostValueRange = 
									OCLExpressionValueTypeRangeFactory.
									getValueTypeRangeForRightSideOfExpression(
											oPostCondition);

								// compare the expressions of both elements!
								
								if(oPreValueRange != null && oPostValueRange != null)
								{
									// postcondition 
									if(ValueTypeRangeHelper.outerVTRangeContainsInnerVTRange(
											oPreValueRange, oPostValueRange, false))
									{
										// alle Elemente der Konjunktion durchsuchen
										for(TCGOCLExpression oIndependentPostCondition : oPostConjunction.getExpressions())
										{
											// außer der gerade behandelten Nachbedingung
											if(oIndependentPostCondition != oPostCondition)
											{
												TCGOCLVariableClassificator oIndependentClassificator = new TCGOCLVariableClassificator(oIndependentPostCondition);
												if(oIndependentClassificator.getClassifiedElementsInExpression(VariableClassification.ACTIVE_DEPENDENT).isEmpty())
												{
													// die Elemente ohne aktive Variablen weiter in früheren Postconditions checken
													if(oIndependentPostCondition == null) {
														System.out.println("new expression is zero!");
													}
													in_colNewExpressions.add(oIndependentPostCondition);
													io_oPostConjunction.getExpressions().addAll(oPostConjunction.getExpressions());
												}
											}
										}
										return PrePostComparisonResult.RESOLVED_CONDITION;
									}
									else
									{
										eRetValue = PrePostComparisonResult.FOUND_CONFLICT;
										continue EXPRESSIONLOOP; // conflict! continue at expression loop
									}
								}
								return PrePostComparisonResult.NO_IMPACT_ON_CONDITION;
							}						
						}
					}
				}
			}
			// return impact on preconditions
			return eRetValue;
		}

	public static boolean firstDNFIsSatisfiedBySecondDNF(
			TCGDisjunctiveNormalForm in_oFirstDNF,
			TCGDisjunctiveNormalForm in_oSecondDNF,
			boolean in_bBoundariesMatchExactly)
	{
		if(DNFIsEmpty(in_oFirstDNF))
			return true;
		
		for(TCGConjunction oConjunction : in_oFirstDNF.getConjunctions())
		{
			// it is enough that one of the alternatives is satisfied
			if(firstConjunctionIsSatisfiedByDNF(oConjunction, in_oSecondDNF, in_bBoundariesMatchExactly))
				return true;
		}
		return false;
	}

	/*
	 * checks if the first conjunction is satisfied by one of the conjunctions of the DNF
	 */
	public static boolean firstConjunctionIsSatisfiedByDNF(
			TCGConjunction in_oCheckedConjunction,
			TCGDisjunctiveNormalForm in_oWarrantedDNF,
			boolean in_bBoundariesMatchExactly)
	{
		// there are conditions to be checked
		if((in_oCheckedConjunction != null) && 
				(in_oCheckedConjunction.getExpressions() != null) &&
				(!in_oCheckedConjunction.getExpressions().isEmpty()))
		{
			if(in_oWarrantedDNF != null) {
				// TODO eingehende Bedingung kann auch durch die Gesamtheit der Warranted-Bedingungen erfüllt werden
				for(TCGConjunction oWarrantedConjunction : in_oWarrantedDNF.getConjunctions()) {
					// first approach: check if the first conjunction is fulfilled by any of the
					// conjunctions of the DNF
					if(firstConjunctionIsSatisfiedBySecondConjunction(in_oCheckedConjunction, 
							oWarrantedConjunction, in_bBoundariesMatchExactly))
						return true;
					
					// stronger approach: check if the first conjunction is satisfied by a combination of
					// the expressions of the DNF
					
				}
			}
		}
		else
			return true;
	
		return false;	
	}

	public static boolean firstConjunctionIsSatisfiedBySecondConjunction(
			TCGConjunction in_oCheckedConjunction,
			TCGConjunction in_oWarrantedConjunction,
			boolean in_bBoundariesMatchExactly)
	{
		// TODO: Also enable complex comparisons involving several expressions at once
		// each expression of the conjunction must be satisfied by the warranted expressions 
		for(TCGOCLExpression oCheckedExpression : in_oCheckedConjunction.getExpressions()) {
			int nCheckedLength = TCGOCLExpressionHelperClass.
					getPassiveDependentVariablesAndInputParameters(oCheckedExpression).size();
			// is the current checked expression satisfied by a warranted expression?
			boolean bExpressionSatisfied = false;
			for(TCGOCLExpression oWarrantedExpression : in_oWarrantedConjunction.getExpressions()) {

				int nWarrantedLength = TCGOCLExpressionHelperClass.
					getPassiveDependentVariablesAndInputParameters(oWarrantedExpression).size();
				// added to deal with constant expressions
				// TODO check if there are problems with constants in guards
				if(nCheckedLength == 0 && nWarrantedLength == 0) {
					try {
						if(TCGOCLExpressionHelperClass.getBooleanValueIfNegative(oCheckedExpression) == 
								TCGOCLExpressionHelperClass.getBooleanValueIfNegative(oWarrantedExpression)) {
							bExpressionSatisfied = true;
							break;
						}
					} catch (Exception e) { /* nothing ... */ }
				}
				else if(nCheckedLength == 1 && nWarrantedLength == 1) {
					// is first checked expression satisfied by the warranted expression?
					if(TCGOCLExpressionHelperClass.firstExpressionIsSatisfiedBySecondExpression(
							oCheckedExpression, oWarrantedExpression, in_bBoundariesMatchExactly)) {
						bExpressionSatisfied = true;
						break;
					}
				}
				else if(nCheckedLength > 1 && nWarrantedLength > 1) {
					// TODO compare both conditions by transforming them until a contradiction
					// can be found
					
					// first solution: (sufficient) compare the exact syntax of both expressions
					if(TCGOCLExpressionHelperClass.expressionsAreEqual(
							oCheckedExpression, oWarrantedExpression)) {
						bExpressionSatisfied = true;
						break;
					}

					// second approach: (necessary) both expressions contain the same atoms
					if(TCGOCLExpressionHelperClass.expressionsContainTheSameAtoms(
							oCheckedExpression, oWarrantedExpression)) {
						// third approach: (sufficient) try to transform one expression into the other
						if(TCGOCLExpressionHelperClass.expressionsCanBeTransformedIntoEachOther(
								oCheckedExpression, oWarrantedExpression)) {
							bExpressionSatisfied = true;
							break;
						}
					}
				}
			}
			if(bExpressionSatisfied == false)
				return false;
		}
		return true;
	}
	
	public static boolean DNFIsEmpty(TCGDisjunctiveNormalForm in_oDNF) {
		if(in_oDNF == null ||
				in_oDNF.getConjunctions().isEmpty()) {
			return true;
		}
		else {
			for(TCGConjunction oConjunction : in_oDNF.getConjunctions()) {
				if(!TCGConjunctionHelperClass.conjunctionIsEmpty(oConjunction))
					return false;
			}
			return true;
		}
	}
	
	public static void removeContradictingConjunctions(
			TCGDisjunctiveNormalForm in_oDNF) {
		List<TCGConjunction> colConjunctions = new ArrayList<TCGConjunction>();
		for(TCGConjunction oConjunction : in_oDNF.getConjunctions()) {
			if(!TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(oConjunction).isEmpty()) {
				colConjunctions.add(oConjunction);
			}
		}
		in_oDNF.getConjunctions().removeAll(colConjunctions);
	}
	
	public static boolean allConjunctionsRemovedBecauseOfInfeasibility(
			TCGDisjunctiveNormalForm in_oDNF) {
		// DNF is already empty
		if(in_oDNF.getConjunctions().isEmpty())
			return false;
		
		ArrayList<TCGConjunction> colConjunctions = new ArrayList<TCGConjunction>();
		for(TCGConjunction oConjunction : in_oDNF.getConjunctions()) {
			if(TCGConjunctionHelperClass.conjunctionContainsAnInfeasibleExpression(
					oConjunction)) {
				colConjunctions.add(oConjunction);
			}
		}
		
		in_oDNF.getConjunctions().removeAll(colConjunctions);
		if(in_oDNF.getConjunctions().isEmpty())
			return true;
		return false;
	}
}

