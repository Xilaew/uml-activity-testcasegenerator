package net.sf.parteg.base.testcasetree.ocl;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.TCGConjunction;
import net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasetree.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;
import net.sf.parteg.base.testcasetree.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasetree.ocl.parser.TCGOCLVariableClassificator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.uml2.uml.Property;

public class ExpressionConverter {

	private static HashMap<String, String> sm_colNameMatching = createNameMatching();
	
	private static HashMap<String, String> createNameMatching()
	{
		HashMap<String, String> colNameMap = new HashMap<String, String>();
		colNameMap.put("<", ">=");
		colNameMap.put("<=", ">");
		colNameMap.put("=", "<>"); // TODO Unterstützung dieses Operators überprüfen
		colNameMap.put(">=", "<");
		colNameMap.put(">", "<=");
		colNameMap.put("not", "not removed");
		colNameMap.put("and", "or");
		colNameMap.put("or", "and");
		return colNameMap;
	}
	
	public static boolean needsToBeConverted(TCGOCLExpression in_oExpression)
	{
		try {
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(in_oExpression);
			
			// there is at least one dependent variable -> convert the expression!
			if(oClassificator.getNumberOfDependentVariables() > 0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		return true;
	}
	
	/*
	 * normalizes the ocl expression
	 * This operation looks first for input parameters and (if not found) for
	 * passive dependent elements. The found element is then shifted to the left.
	 */
	public static void normalizeExpression(TCGOCLExpression in_oCondition)
	{
		if(in_oCondition != null)
		{
			// find input parameter in condition
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(in_oCondition);
			TCGOCLExpression oToBeIsolatedOnLeft = null;
			TCGOCLExpression oExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);
			if(oExpression != null)
				oToBeIsolatedOnLeft = oExpression;
			else
			{
				oExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.INPUT_PARAMETER);
				if(oExpression != null)
					oToBeIsolatedOnLeft = oExpression;
				else
				{
					oToBeIsolatedOnLeft = oClassificator.getClassifiedElementInExpression(VariableClassification.PASSIVE_DEPENDENT);
				}
			}
			
			if(oToBeIsolatedOnLeft != null)
			{
				// if not isolated on left side - then isolate!
				if(!oClassificator.expressionIsIsolatedOnLeftSide(oToBeIsolatedOnLeft))
				{
					oClassificator.shiftSubexpressionToTheLeft(oToBeIsolatedOnLeft);
				}
			}
		}
	}
	
	public static TCGEquivalenceClass getEquivalenceClassForRightSideOfExpression(TCGOCLExpression in_oCondition)
	{
		try {
			TCGEquivalenceClass oEqClass = DomainHelper.createDefaultEquivalenceClass();
			
			if(in_oCondition instanceof TCGOCLOperation)
			{
				TCGOCLOperation oCallExp = (TCGOCLOperation)in_oCondition;
				double dValue = getValue((TCGOCLExpression)oCallExp.getRight());
				DomainHelper.adaptDomain(oEqClass, dValue, oCallExp.getOperationName(), false);
			}
			return oEqClass;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public static double getValue(TCGOCLExpression in_oTCGOCLExpression) throws Exception
	{
		if(in_oTCGOCLExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oPropExp = (TCGOCLAtom)in_oTCGOCLExpression;
			VariableExp oVarExp = null;
			if(oPropExp.getElement() instanceof OCLExpression)
			{
				oVarExp = TestCaseGraphHelper.getVariableExp((OCLExpression)oPropExp.getElement());
			}
			
			if(oVarExp != null)
			{
				// nothing - variables do not have fixed values
			}
			else if(oPropExp.getElement() instanceof Property)
			{
				Property oProp = (Property)oPropExp.getElement();
				if(oProp.getDefaultValue() == null)
				{
					//System.err.println("error in getValue() for property "
					//		+ oProp.getName());
					throw new Exception("error in getValue() for property "
							+ oProp.getName());
				}
				else
				{
					String sValue = oProp.getDefaultValue().stringValue();
					return Double.valueOf(sValue).doubleValue();
				}
			}
			if(oPropExp.getElement() instanceof EReferenceImpl)
			{
				EReferenceImpl oRef = (EReferenceImpl)oPropExp.getElement();
				return Double.valueOf(oRef.getDefaultValueLiteral());
			}
		}
		else if(in_oTCGOCLExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oTCGOCLExpression;
			if(oOpExp.getOperationName().compareTo("+") == 0)
			{
				return getValue(oOpExp.getLeft()) + 
				getValue(oOpExp.getRight());				
			}
			else if (oOpExp.getOperationName().compareTo("-") == 0)
			{
				// TODO für unäre Operationen neuen Typ einführen
				if(oOpExp.getLeft() == null)
					return - getValue(oOpExp.getRight());
				if(oOpExp.getRight() == null)
					return - getValue(oOpExp.getLeft());
				return getValue(oOpExp.getLeft()) - getValue(oOpExp.getRight());
			}
			else if(oOpExp.getOperationName().compareTo("*") == 0)
			{
				return getValue(oOpExp.getLeft()) * 
				getValue(oOpExp.getRight());				
			}
			else if (oOpExp.getOperationName().compareTo("/") == 0)
			{
				return getValue(oOpExp.getLeft()) / 
				getValue(oOpExp.getRight());				
			}
			// TODO weitere Operationen einfügen
		}
		return 0;
	}	

	/*
	 * creates the conjunctive normal form of in_oExpression
	 */
	public static TCGDisjunctiveNormalForm createDisjunctiveNormalForm(
			TCGOCLExpression in_oExpression)
	{
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();		
		if(in_oExpression == null)
			return oDNF;
		
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;

			// TODO für alle andere booleschen Operatoren erweitern
			if(oOpExp.getOperationName().compareTo("and") == 0)
			{
				TCGDisjunctiveNormalForm oLeftDNF = createDisjunctiveNormalForm(oOpExp.getLeft());
				TCGDisjunctiveNormalForm oRightDNF = createDisjunctiveNormalForm(oOpExp.getRight());
				return connectTwoDNFWithAnd(oLeftDNF, oRightDNF);
			}

			if(oOpExp.getOperationName().compareTo("or") == 0)
			{
				TCGDisjunctiveNormalForm oLeftDNF = createDisjunctiveNormalForm(oOpExp.getLeft());
				TCGDisjunctiveNormalForm oRightDNF = createDisjunctiveNormalForm(oOpExp.getRight());
				return connectTwoDNFWithOr(oLeftDNF, oRightDNF);

//				DisjunctiveNormalForm oFirstDNF = new DisjunctiveNormalForm();
//				{
//					TCGOCLExpression oFirstExp = TestCaseGraphHelper.copyExpression(oOpExp.getLeft());
//					TCGOCLExpression oSecondExp = TestCaseGraphHelper.copyExpression(oOpExp.getRight());
//					Conjunction oFirstConjunction = new Conjunction();
//					oFirstConjunction.getExpressions().add(oFirstExp);
//					oFirstConjunction.getExpressions().add(oSecondExp);
//					oFirstDNF.getConjunctions().add(oFirstConjunction);
//				}
//
//				DisjunctiveNormalForm oSecondDNF = new DisjunctiveNormalForm();
//				{
//					TCGOCLExpression oFirstExp = TestCaseGraphHelper.copyExpression(oOpExp.getLeft());
//					negateTCGOCLExpression(oFirstExp);
//					TCGOCLExpression oSecondExp = TestCaseGraphHelper.copyExpression(oOpExp.getRight());
//					Conjunction oFirstConjunction = new Conjunction();
//					oFirstConjunction.getExpressions().add(oFirstExp);
//					oFirstConjunction.getExpressions().add(oSecondExp);
//					oSecondDNF.getConjunctions().add(oFirstConjunction);
//				}
//				
//				DisjunctiveNormalForm oThirdDNF = new DisjunctiveNormalForm();
//				{
//					TCGOCLExpression oFirstExp = TestCaseGraphHelper.copyExpression(oOpExp.getLeft());
//					TCGOCLExpression oSecondExp = TestCaseGraphHelper.copyExpression(oOpExp.getRight());
//					negateTCGOCLExpression(oSecondExp);
//					Conjunction oFirstConjunction = new Conjunction();
//					oFirstConjunction.getExpressions().add(oFirstExp);
//					oFirstConjunction.getExpressions().add(oSecondExp);
//					oThirdDNF.getConjunctions().add(oFirstConjunction);
//				}
//				
//				return connectTwoDNFWithOr(oFirstDNF, connectTwoDNFWithOr(oSecondDNF, oThirdDNF));
			}

			if(oOpExp.getOperationName().compareTo("not") == 0)
			{
				// negation has to be applicated to all sub-expressions
				// TODO: introduce unary operation - which side holds the information?
				if(oOpExp.getLeft() != null)
				{
					oOpExp.setLeft(negateTCGOCLExpression(oOpExp.getLeft()));
					return createDisjunctiveNormalForm(oOpExp.getLeft());
				}
				else if(oOpExp.getRight() != null)
				{
					oOpExp.setRight(negateTCGOCLExpression(oOpExp.getRight()));
					return createDisjunctiveNormalForm(oOpExp.getRight());
				}
			}

			if(oOpExp.getOperationName().compareTo("<>") == 0)
			{
				// split up "<>" in two alternatives: "<" or ">"
				TCGOCLOperation oFirstExp = (TCGOCLOperation)TestCaseGraphHelper.copyExpression(oOpExp);
				oFirstExp.setOperationName("<");
				TCGConjunction oFirstConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
				oFirstConjunction.getExpressions().add(oFirstExp);

				TCGOCLOperation oSecondExp = (TCGOCLOperation)TestCaseGraphHelper.copyExpression(oOpExp);
				oSecondExp.setOperationName(">");
				TCGConjunction oSecondConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
				oSecondConjunction.getExpressions().add(oSecondExp);

				TCGDisjunctiveNormalForm oNewDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
				oNewDNF.getConjunctions().add(oFirstConjunction);
				oNewDNF.getConjunctions().add(oSecondConjunction);
				return oNewDNF;
			}

			/*if(oOpExp.getOperationName().compareTo("not removed") == 0)
			{
				if(oOpExp.getLeft() != null)
				{
					return createDisjunctiveNormalForm(oOpExp.getLeft());
				}
				else if(oOpExp.getRight() != null)
				{
					return createDisjunctiveNormalForm(oOpExp.getRight());
				}
			}	*/		
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oTCGIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			
			// condition satisfied
			TCGDisjunctiveNormalForm oConditionDNF = createDisjunctiveNormalForm(oTCGIfThenElse.getCondition());
			TCGDisjunctiveNormalForm oThenDNF = createDisjunctiveNormalForm(oTCGIfThenElse.getThenExpression());
			TCGDisjunctiveNormalForm oSatisfiedDNF = connectTwoDNFWithAnd(oConditionDNF, oThenDNF);
			
			// condition violated
			negateTCGOCLExpression(oTCGIfThenElse.getCondition());
			TCGDisjunctiveNormalForm oNotConditionDNF = createDisjunctiveNormalForm(oTCGIfThenElse.getCondition());
			TCGDisjunctiveNormalForm oElseDNF = createDisjunctiveNormalForm(oTCGIfThenElse.getElseExpression());
			TCGDisjunctiveNormalForm oViolatedDNF = connectTwoDNFWithAnd(oNotConditionDNF, oElseDNF);
			
			return connectTwoDNFWithOr(oSatisfiedDNF, oViolatedDNF); 
		}

		oDNF.getConjunctions().add(GeneratedFactory.eINSTANCE.createTCGConjunction());
		oDNF.getConjunctions().get(0).getExpressions().add(TestCaseGraphHelper.copyExpression(in_oExpression));
		return oDNF;
	}
	
	public static TCGOCLExpression negateTCGOCLExpression(TCGOCLExpression in_oTCGOCLExpression)
	{
		if(in_oTCGOCLExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oTCGOCLExpression;
			// if operation name is not in list -> do not change it (e.g. addition, substraction, ...)
			if(sm_colNameMatching.get(oOpExp.getOperationName()) != null)
			{
				oOpExp.setOperationName(sm_colNameMatching.get(oOpExp.getOperationName()));
				if(oOpExp.getLeft() != null)
					if(oOpExp.getLeft() instanceof TCGOCLOperation)
						oOpExp.setLeft(negateTCGOCLExpression(oOpExp.getLeft()));
				if(oOpExp.getRight() != null)
					if(oOpExp.getRight() instanceof TCGOCLOperation)
						oOpExp.setRight(negateTCGOCLExpression(oOpExp.getRight()));
				return oOpExp;
			}
		}
		else if(in_oTCGOCLExpression instanceof TCGOCLAtom)
		{
			TCGOCLOperation oOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
			oOperation.setLeft(null);
			oOperation.setRight(in_oTCGOCLExpression);
			oOperation.setOperationName("-");
			return oOperation;
		}
		return null;
	}
	
	private static TCGDisjunctiveNormalForm connectTwoDNFWithAnd(
			TCGDisjunctiveNormalForm in_oLeftDNF, TCGDisjunctiveNormalForm in_oRightDNF)
	{
		TCGDisjunctiveNormalForm oResultDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		for(TCGConjunction oLeftConjunction : in_oLeftDNF.getConjunctions())
		{
			for(TCGConjunction oRightConjunction : in_oRightDNF.getConjunctions())
			{
				TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
				oNewConjunction.getExpressions().addAll(oLeftConjunction.getExpressions());
				oNewConjunction.getExpressions().addAll(oRightConjunction.getExpressions());
				oResultDNF.getConjunctions().add(oNewConjunction);
			}
		}
		return oResultDNF;
	}
	
	private static TCGDisjunctiveNormalForm connectTwoDNFWithOr(
			TCGDisjunctiveNormalForm in_oLeftDNF, TCGDisjunctiveNormalForm in_oRightDNF)
	{
		TCGDisjunctiveNormalForm oResultDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		for(TCGConjunction oLeftConjunction : in_oLeftDNF.getConjunctions())
		{
			oResultDNF.getConjunctions().add(oLeftConjunction);
		}
		for(TCGConjunction oRightConjunction : in_oRightDNF.getConjunctions())
		{
			oResultDNF.getConjunctions().add(oRightConjunction);
		}
		return oResultDNF;
	}
	
	public static void addConjunctionsForCoverageCriterion(
			TCGDisjunctiveNormalForm io_oDNF)
	{
		switch(TCTConfiguration.getCoverage())
		{
		case StatementCoverage:
			break; // no additional conjunctions!
		case ConditionCoverage:
			addConjunctionsForConditionCoverage(io_oDNF);
			break;
		case DecisionCoverage:
			addConjunctionsForDecisionCoverage(io_oDNF);
			break;
		case MultipleConditionCoverage:
			addConjunctionsForMultipleConditionCoverage(io_oDNF);
			break;
		case ModifiedConditionDecisionCoverage:
			addConjunctionsForMCDC(io_oDNF);
			break;
		};
	}
	
	private static void addConjunctionsForConditionCoverage(
			TCGDisjunctiveNormalForm io_oDNF)
	{
		HashMap<EObject, TCGOCLExpression> colExpressions = new HashMap<EObject, TCGOCLExpression>(); 
		for(TCGConjunction oConjunction : io_oDNF.getConjunctions())
		{
			for(TCGOCLExpression oExpression : oConjunction.getExpressions())
			{
				// just enter one TCGOCLExpression per OCLExpression ...
				colExpressions.put(oExpression.getOclReference(), oExpression);
			}
		}
		// TODO: condition coverage? all sizes of combinations ?
		//for(int i = 1; i < colExpressions.values().size(); ++i)
		
		for(TCGOCLExpression oExpression : colExpressions.values())
		{
			TCGOCLExpression oNewExpression = TestCaseGraphHelper.copyExpression(oExpression);
			oNewExpression = negateTCGOCLExpression(oNewExpression);
			TCGDisjunctiveNormalForm oDNF =  createDisjunctiveNormalForm(oNewExpression);
			for(TCGConjunction oConjunction : oDNF.getConjunctions())
			{
				oConjunction.setPositiveSubExpressionOfOriginal(false);
				io_oDNF.getConjunctions().add(oConjunction);
			}
		}
	}

	private static void addConjunctionsForDecisionCoverage(
			TCGDisjunctiveNormalForm io_oDNF)
	{
		// combine the negated elements of different conjunctions pair-wise
		
		// first approach: just basic conditions that combine negated elements of each conjunction
		HashMap<TCGConjunction, ArrayList<TCGConjunction>> colNewConjunctions = new HashMap<TCGConjunction, ArrayList<TCGConjunction>>();
		addAdditionalConjunctions(io_oDNF, colNewConjunctions);
		
		ArrayList<TCGConjunction> colCombinedConjunctions = new ArrayList<TCGConjunction>();
		ArrayList<TCGConjunction> colNewConjunctionKeyList = new ArrayList<TCGConjunction>(colNewConjunctions.keySet()); 
		combineConjunctions(colNewConjunctions, colCombinedConjunctions, colNewConjunctionKeyList, 0, new ArrayList<TCGConjunction>());
		
		for(TCGConjunction oConjunction : colCombinedConjunctions)
		{
			io_oDNF.getConjunctions().add(oConjunction);
		}
	}
	
	private static void addConjunctionsForMultipleConditionCoverage(TCGDisjunctiveNormalForm io_oDNF)
	{
		HashMap<TCGConjunction, ArrayList<TCGConjunction>> colNewConjunctions = new HashMap<TCGConjunction, ArrayList<TCGConjunction>>();
		for(TCGConjunction oConjunction : io_oDNF.getConjunctions())
		{
			colNewConjunctions.put(oConjunction, new ArrayList<TCGConjunction>());
			addAllPossibleConjunctions(colNewConjunctions, oConjunction, new ArrayList<TCGOCLExpression>(), 0, false);
		}
		
		ArrayList<TCGConjunction> colCombinedConjunctions = null;
		if(colNewConjunctions.size() > 1)
		{
			colCombinedConjunctions = new ArrayList<TCGConjunction>();
			ArrayList<TCGConjunction> colNewConjunctionKeyList = new ArrayList<TCGConjunction>(colNewConjunctions.keySet()); 
			combineConjunctions(colNewConjunctions, colCombinedConjunctions, colNewConjunctionKeyList, 0, new ArrayList<TCGConjunction>());
		}
		else
			colCombinedConjunctions = new ArrayList<TCGConjunction>(colNewConjunctions.get(io_oDNF.getConjunctions().get(0)));
		
		// remove all original expressions for decision coverage
		io_oDNF.getConjunctions().clear();
		
		for(TCGConjunction oConjunction : colCombinedConjunctions)
		{
			io_oDNF.getConjunctions().add(oConjunction);
		}		
	}
	
	private static void addConjunctionsForMCDC(TCGDisjunctiveNormalForm io_oDNF)
	{
		/* MCDC just contains condition value combinations for which a change of a certain 
		 * condition value causes a change of the decision value.
		 * This means that we have to combine the atomic conditions of the conjunctions so 
		 * that just one conjunction is true or no conjunction is true but one would be 
		 * true if one condition value changed.
		 */
		
		/* first step: collect two types of conjunctions: 
		 * 1) those that can change their expression value if one atomic condition changes
		 * 1.a) that are positive
		 * 1.b) that are negative because of one condition value
		 * 2) those that cannot
		 */
		
		// first step: collect all interesting conjunctions
		HashMap<TCGConjunction, MCDCConjunctionSet> colNewConjunctions = new HashMap<TCGConjunction, MCDCConjunctionSet>();
		addMCDCConjunctionPermutations(io_oDNF, colNewConjunctions);
		
		removeUnnecessaryConjunctionParts(colNewConjunctions);

		// remove all original conjunctions - the new ones cover the same results
		io_oDNF.getConjunctions().clear();

		// second step: combine conjunctions so that at most one condition is of type 1.a) 
		// and at least one condition is of type 1)
		// - combine for each conjunction the positive with all negative from the other conjunctions
		// - combine all negative conjunctions but add them only if at least one condition of type 1) is included
		ArrayList<MCDCConjunctionSet> colConjunctions = new ArrayList<MCDCConjunctionSet>(colNewConjunctions.values());
		// nPositiveIndex is the index for the element to add its positive conjunction.
		// If it is -1, then all negative conjunctions are combined.
		for(int nPositiveIndex = -1; nPositiveIndex < colConjunctions.size(); ++nPositiveIndex)
		{
			combineMCDCConjunctions(io_oDNF, colConjunctions, new ArrayList<TCGConjunction>(), nPositiveIndex, 0, 0);
		}
	}

	/*
	 * remove unnecessary parts of each conjunction contained in the referenced MCDCConjunctionSets 
	 */
	private static void removeUnnecessaryConjunctionParts(HashMap<TCGConjunction, MCDCConjunctionSet> io_colConjunctions)
	{
		// ### TODO implement this function 
//		for(MCDCConjunctionSet oConjunctionSet : io_colConjunctions.values())
//		{
//			removeUnnecessaryConjunctionParts(oConjunctionSet.getPositiveConjunction());
//			for(Conjunction oConjunction : oConjunctionSet.getNegativeButChangeableConjunctions())
//			{
//				removeUnnecessaryConjunctionParts(oConjunction);
//			}
//			for(Conjunction oConjunction : oConjunctionSet.getNegativeAndUnchangeableConjunctions())
//			{
//				removeUnnecessaryConjunctionParts(oConjunction);
//			}
//		}
	}
	
//	private static void removeUnnecessaryConjunctionParts(Conjunction io_oConjunction)
//	{
//		TestCaseGraphHelper.conditionsInConjunctionAreContradicting()
//		for(TCGOCLExpression oExpression : io_oConjunction.getExpressions())
//		{
//			oExpression
//		}
//	}
	
	private static void combineMCDCConjunctions(
			TCGDisjunctiveNormalForm io_oDNF,
			ArrayList<MCDCConjunctionSet> in_colConjunctionSets,
			ArrayList<TCGConjunction> io_colNewConjunctions,
			int io_nCurrentPositiveIndex, // -1 ... in_colConjunctionSets.size
			int io_nCurrentConjunctionsSetIndex, // 0
			int io_nChangeableConjunctionCounter) // 0
	{
		// assemble new conjunctions - index of conjunction set is higher than the actual set
		if(io_nCurrentConjunctionsSetIndex >= in_colConjunctionSets.size())
		{
			// without any changeable conjunction, the assembled conjunctions would be no element of MCDC
			if(io_nChangeableConjunctionCounter >= 1)
			{
				TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
				oNewConjunction.setCanChangeValueIfOneExpressionChanges(true);
				if(io_nCurrentPositiveIndex >= 0)
					oNewConjunction.setPositiveSubExpressionOfOriginal(true);
				else
					oNewConjunction.setPositiveSubExpressionOfOriginal(false);
				
				for(TCGConjunction oConjunction : io_colNewConjunctions)
				{
					oNewConjunction.getExpressions().addAll(oConjunction.getExpressions());
				}
				// combine the expressions of all elements
				// TODO #### reduce number of expressions for MCDC 
				io_oDNF.getConjunctions().add(oNewConjunction);
			}
		}
		else // collect conjunctions
		{
			// io_nCurrentConjunctionsSetIndex is the index of the necessarily positive conjunction
			if(io_nCurrentConjunctionsSetIndex == io_nCurrentPositiveIndex)
			{
				io_colNewConjunctions.add(in_colConjunctionSets.get(io_nCurrentConjunctionsSetIndex).getPositiveConjunction());
				combineMCDCConjunctions(io_oDNF, in_colConjunctionSets, io_colNewConjunctions,
						io_nCurrentPositiveIndex, io_nCurrentConjunctionsSetIndex + 1, io_nChangeableConjunctionCounter + 1);
				io_colNewConjunctions.remove(in_colConjunctionSets.get(io_nCurrentConjunctionsSetIndex).getPositiveConjunction());
			}
			else // io_nCurrentConjunctionsSetIndex is the index of a necessarily negative conjunction
			{
				// recursion for negative but changeable conjunctions
				for(TCGConjunction oConjunction : in_colConjunctionSets.get(io_nCurrentConjunctionsSetIndex).getNegativeButChangeableConjunctions())
				{
					io_colNewConjunctions.add(oConjunction);
					combineMCDCConjunctions(io_oDNF, in_colConjunctionSets, io_colNewConjunctions,
							io_nCurrentPositiveIndex, io_nCurrentConjunctionsSetIndex + 1, io_nChangeableConjunctionCounter + 1);
					io_colNewConjunctions.remove(oConjunction);
				}
				// recursion for negative and unchangeable conjunctions
				for(TCGConjunction oConjunction : in_colConjunctionSets.get(io_nCurrentConjunctionsSetIndex).getNegativeAndUnchangeableConjunctions())
				{
					io_colNewConjunctions.add(oConjunction);
					combineMCDCConjunctions(io_oDNF, in_colConjunctionSets, io_colNewConjunctions,
							io_nCurrentPositiveIndex, io_nCurrentConjunctionsSetIndex + 1, io_nChangeableConjunctionCounter);
					io_colNewConjunctions.remove(oConjunction);
				}
			}
		}
	}
	
	
	/**
	 * adds combinations of negated sub-expressions for each conjunction  
	 * @param io_oDNF
	 * @param io_colNewConjunctions
	 */
	private static void addAdditionalConjunctions(
			TCGDisjunctiveNormalForm io_oDNF, 
			HashMap<TCGConjunction, ArrayList<TCGConjunction>> io_colNewConjunctions)
	{
		for(TCGConjunction oConjunction : io_oDNF.getConjunctions())
		{
			io_colNewConjunctions.put(oConjunction, new ArrayList<TCGConjunction>());
			for(TCGOCLExpression oExpression : oConjunction.getExpressions())
			{
				TCGOCLExpression oNewExpression = TestCaseGraphHelper.copyExpression(oExpression);
				oNewExpression = negateTCGOCLExpression(oNewExpression);
				TCGDisjunctiveNormalForm oDNF =  createDisjunctiveNormalForm(oNewExpression);
				for(TCGConjunction oNewConjunction : oDNF.getConjunctions())
				{
					oNewConjunction.setPositiveSubExpressionOfOriginal(false);
					io_colNewConjunctions.get(oConjunction).add(oNewConjunction);
				}
			}
		}
	}
	
	private static void addAllPossibleConjunctions(
			HashMap<TCGConjunction, ArrayList<TCGConjunction>> io_colNewConjunctions,
			TCGConjunction in_oOriginalConjunction,
			ArrayList<TCGOCLExpression> io_colExpressionsForNewConjunction,
			int in_nCurrentExpressionIndex,
			boolean in_bContainsNegativeExpressions)
	{
		if(in_nCurrentExpressionIndex >= in_oOriginalConjunction.getExpressions().size())
		{
			TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
			oNewConjunction.getExpressions().addAll(io_colExpressionsForNewConjunction);
			oNewConjunction.setPositiveSubExpressionOfOriginal(!in_bContainsNegativeExpressions);
			io_colNewConjunctions.get(in_oOriginalConjunction).add(oNewConjunction);
		}
		else
		{
			TCGOCLExpression oExpression = TestCaseGraphHelper.copyExpression(
					in_oOriginalConjunction.getExpressions().get(in_nCurrentExpressionIndex));
			io_colExpressionsForNewConjunction.add(oExpression);
			addAllPossibleConjunctions(io_colNewConjunctions, in_oOriginalConjunction, io_colExpressionsForNewConjunction,
					in_nCurrentExpressionIndex + 1, in_bContainsNegativeExpressions);
			io_colExpressionsForNewConjunction.remove(oExpression);
			
			TCGOCLExpression oNegatedExpression = TestCaseGraphHelper.copyExpression(oExpression);
			oNegatedExpression = negateTCGOCLExpression(oNegatedExpression);
			TCGDisjunctiveNormalForm oDNF =  createDisjunctiveNormalForm(oNegatedExpression);
			for(TCGConjunction oNewConjunction : oDNF.getConjunctions())
			{
				for(TCGOCLExpression oNewConjExp : oNewConjunction.getExpressions())
				{
					io_colExpressionsForNewConjunction.add(oNewConjExp);
					addAllPossibleConjunctions(io_colNewConjunctions, in_oOriginalConjunction, io_colExpressionsForNewConjunction,
							in_nCurrentExpressionIndex + 1, true);
					io_colExpressionsForNewConjunction.remove(oNewConjExp);
				}
			}
		}
	}
	
	/**
	 * calls getExpressionsPermutationsForConjunction for each conjunction
	 * @param io_oDNF
	 * @param io_colNewConjunctions
	 */
	private static void addMCDCConjunctionPermutations(
			TCGDisjunctiveNormalForm io_oDNF, 
			HashMap<TCGConjunction, MCDCConjunctionSet> io_colNewConjunctions)
	{
		for(TCGConjunction oConjunction : io_oDNF.getConjunctions())
		{
			MCDCConjunctionSet colNewConjunctions = new MCDCConjunctionSet();
			getExpressionsPermutationsForConjunction(colNewConjunctions, oConjunction, new ArrayList<TCGOCLExpression>(), 0, 0);
			io_colNewConjunctions.put(oConjunction, colNewConjunctions);
		}
	}
	
	/**
	 * gets all possible permutations of the expressions in the input conjunction 
	 * @param io_colNewConjunctions is the array for the new conjunctions
	 * @param in_oOriginalConjunction is the original conjunction
	 * @param io_colExpressionsForNewConjunction collects all expressions from which the new conjunctions are assembled
	 * @param in_nCurrentExpressionIndex internal index to select the current expression (to negate or not)
	 * @param in_nNegativeExpressionCounter counts the number of negative expressions in io_colExpressionsForNewConjunction
	 */
	private static void getExpressionsPermutationsForConjunction(
			MCDCConjunctionSet io_colNewConjunctions,
			TCGConjunction in_oOriginalConjunction,
			ArrayList<TCGOCLExpression> io_colExpressionsForNewConjunction,
			int in_nCurrentExpressionIndex,
			int in_nNegativeExpressionCounter)
	{
		// all expressions collected -> assemble the conjunction
		if(in_nCurrentExpressionIndex >= in_oOriginalConjunction.getExpressions().size())
		{
			if(in_nNegativeExpressionCounter == 0)
			{
				TCGConjunction oPositiveConjunction = TCGConjunctionHelperClass.copyConjunction(in_oOriginalConjunction);
				oPositiveConjunction.setPositiveSubExpressionOfOriginal(true);
				oPositiveConjunction.setCanChangeValueIfOneExpressionChanges(true);
				io_colNewConjunctions.setPositiveConjunction(oPositiveConjunction);
			}
			else 
			{
				TCGConjunction oNegativeConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
				oNegativeConjunction.getExpressions().addAll(io_colExpressionsForNewConjunction);
				oNegativeConjunction.setPositiveSubExpressionOfOriginal(false);
				if(in_nNegativeExpressionCounter == 1)
				{
					oNegativeConjunction.setCanChangeValueIfOneExpressionChanges(true);
					io_colNewConjunctions.getNegativeButChangeableConjunctions().add(oNegativeConjunction);
				}
				else
				{
					oNegativeConjunction.setCanChangeValueIfOneExpressionChanges(false);
					io_colNewConjunctions.getNegativeAndUnchangeableConjunctions().add(oNegativeConjunction);
				}
			}
		}
		else // collect all expression permutations
		{
			// recursion for positive expressions
			TCGOCLExpression oExpression = TestCaseGraphHelper.copyExpression(in_oOriginalConjunction.getExpressions().get(in_nCurrentExpressionIndex));
			io_colExpressionsForNewConjunction.add(oExpression);
			getExpressionsPermutationsForConjunction(io_colNewConjunctions, in_oOriginalConjunction, io_colExpressionsForNewConjunction,
					in_nCurrentExpressionIndex + 1, in_nNegativeExpressionCounter);
			io_colExpressionsForNewConjunction.remove(oExpression);
			
			// recursion for negative expressions
			TCGOCLExpression oNegativeExpression = TestCaseGraphHelper.copyExpression(oExpression);
			oNegativeExpression = negateTCGOCLExpression(oNegativeExpression);
			TCGDisjunctiveNormalForm oDNF =  createDisjunctiveNormalForm(oNegativeExpression);
			for(TCGConjunction oNewConjunction : oDNF.getConjunctions())
			{
				for(TCGOCLExpression oNewConjExp : oNewConjunction.getExpressions())
				{
					io_colExpressionsForNewConjunction.add(oNewConjExp);
					getExpressionsPermutationsForConjunction(io_colNewConjunctions, in_oOriginalConjunction, io_colExpressionsForNewConjunction,
							in_nCurrentExpressionIndex + 1, in_nNegativeExpressionCounter + 1);
					io_colExpressionsForNewConjunction.remove(oNewConjExp);
				}
			}	
		}
	}
	
	/**
	 * @param io_colNewConjunctions
	 * @param io_colCombinedConjunctions
	 * @param io_colNewConjunctionKeyList holds an arraylist of the keyset of in_colNewConjunctions
	 * @param in_nCurrentIndex is the current index of io_colNewConjunctionKeyList 
	 * @param io_colCurrentCombinedConjunction is the just assembled combination of conjunctions
	 */
	private static void combineConjunctions(
			HashMap<TCGConjunction, ArrayList<TCGConjunction>> io_colNewConjunctions, 
			ArrayList<TCGConjunction> io_colCombinedConjunctions,
			ArrayList<TCGConjunction> io_colNewConjunctionKeyList, 
			int in_nCurrentIndex, 
			ArrayList<TCGConjunction> io_colCurrentCombinedConjunction)
	{
		if(in_nCurrentIndex >= io_colNewConjunctions.size())
		{
			// assemble the conjunctions of io_colCurrentCombinedConjunction
			TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
			for(TCGConjunction oConjunction : io_colCurrentCombinedConjunction)
			{
				if(oConjunction.isPositiveSubExpressionOfOriginal() == false)
					oNewConjunction.setPositiveSubExpressionOfOriginal(false);
				
				for(TCGOCLExpression oExpression : oConjunction.getExpressions())
				{
					oNewConjunction.getExpressions().add(oExpression);
				}
			}
			// just assembled conjunction
			io_colCombinedConjunctions.add(oNewConjunction);
		}
		else
		{
			for(TCGConjunction oCurrentConjunction : io_colNewConjunctions.get(io_colNewConjunctionKeyList.get(in_nCurrentIndex)))
			{
				io_colCurrentCombinedConjunction.add(oCurrentConjunction);
				combineConjunctions(io_colNewConjunctions, io_colCombinedConjunctions, io_colNewConjunctionKeyList, in_nCurrentIndex + 1, io_colCurrentCombinedConjunction);
				io_colCurrentCombinedConjunction.remove(oCurrentConjunction);
			}			
		}
	}
}
