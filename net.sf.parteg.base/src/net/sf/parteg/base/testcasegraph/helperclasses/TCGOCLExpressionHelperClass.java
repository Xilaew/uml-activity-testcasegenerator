package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableExpressionValueSelection;
import net.sf.parteg.base.testcasegraph.decisiontables.DecisionTableRowEvaluator;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionFindAtomReferenceVisitor;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionFindObjectVisitor;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionIterator;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeTCGOCLAtomCollectorVisitor;
import net.sf.parteg.base.testcasegraph.ocl.parser.TCGOCLVariableClassificator;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.valuetyperanges.IndefinableValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.OCLExpressionValueTypeRangeFactory;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRangeFactory;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRangeHelper;
import net.sf.parteg.base.testcasegraph.valuetypes.IntegerValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.structures.ObjectComparator;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.ocl.uml.BooleanLiteralExp;
import org.eclipse.ocl.uml.IntegerLiteralExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.RealLiteralExp;
import org.eclipse.ocl.uml.Variable;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

public class TCGOCLExpressionHelperClass {

	private static HashMap<String, String> sm_colNameMatching = createNameMatching();
	private static HashMap<String, String> sm_colCorrespondingRelations = initializeRelations();
	private static HashMap<String, String> sm_colCorrespondingOperations = initializeOperations();
	private static boolean sm_bLastIntegerComputationWasIncorrect = false;
	
	private static HashMap<String, String> initializeRelations()
	{
		HashMap<String, String> colCorrespondingRelations = new LinkedHashMap<String, String>();
		colCorrespondingRelations.put("<", ">");
		colCorrespondingRelations.put("<=", ">=");
		colCorrespondingRelations.put("=", "=");
		colCorrespondingRelations.put("<>", "<>");
		colCorrespondingRelations.put(">=", "<=");
		colCorrespondingRelations.put(">", "<");
		colCorrespondingRelations.put("not", "not");
		return colCorrespondingRelations;
	}

	private static HashMap<String, String> initializeOperations()
	{
		HashMap<String, String> colCorrespondingOperations = new LinkedHashMap<String, String>();
		colCorrespondingOperations.put("+", "-");
		colCorrespondingOperations.put("-", "+");
		colCorrespondingOperations.put("*", "/");
		colCorrespondingOperations.put("/", "*");
		return colCorrespondingOperations;
	}
	
	public static boolean isLastIntegerComputationWasIncorrect() {
		return sm_bLastIntegerComputationWasIncorrect;
	}

	public static void setLastIntegerComputationWasIncorrect(
			boolean sm_bLastIntegerComputationWasIncorrect) {
		TCGOCLExpressionHelperClass.sm_bLastIntegerComputationWasIncorrect = sm_bLastIntegerComputationWasIncorrect;
	}
	

	private static HashMap<String, String> createNameMatching() {
		// TODO string - Konstanten für alle Schlüsselworte definieren
		HashMap<String, String> colNameMap = new LinkedHashMap<String, String>();
		colNameMap.put("<", ">=");
		colNameMap.put("<=", ">");
		colNameMap.put("=", "<>"); // TODO Unterstützung dieses Operators
									// überprüfen
		colNameMap.put("<>", "=");
		colNameMap.put(">=", "<");
		colNameMap.put(">", "<=");
		colNameMap.put("not", "not removed");
		colNameMap.put("and", "or");
		colNameMap.put("or", "and");
		return colNameMap;
	}
	
	public static boolean conditionContainsReferenceToObject(
			TCGOCLExpression in_oOCLExpression,
			EObject in_oReferencedObject)
	{
		if(in_oOCLExpression instanceof TCGOCLAtom)
		{
			return ((TCGOCLAtom)in_oOCLExpression).getElement().equals(in_oReferencedObject);
		}
		else if(in_oOCLExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oOCLExpression;
			return conditionContainsReferenceToObject(oOpExp.getLeft(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oOpExp.getRight(), in_oReferencedObject);
		}
		else if(in_oOCLExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElseExp = (TCGOCLIfThenElse)in_oOCLExpression;
			return conditionContainsReferenceToObject(oIfThenElseExp.getCondition(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oIfThenElseExp.getThenExpression(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oIfThenElseExp.getElseExpression(), in_oReferencedObject);
		}
		return false;
	}
	
	public static List<TCGOCLExpression> getContainedExpressionsWithPassiveVariables(
			List<TCGOCLExpression> in_colExpressions)
	{
		List<TCGOCLExpression> oRetValues = new ArrayList<TCGOCLExpression>();
		for(TCGOCLExpression oExp : in_colExpressions)
		{
			if(expressionContainsPassiveDependentVariables(oExp))
				oRetValues.add(oExp);
		}
		return oRetValues;
	}

	public static boolean expressionContainsPassiveDependentVariables(
			TCGOCLExpression in_oExpression)
	{
		return !getVariablesOfType(
				in_oExpression, VariableClassification.PASSIVE_DEPENDENT).isEmpty();
	}


	public static List<Object> getInputParametersFromExpression(
			TCGOCLExpression in_oExpression) {
		List<Object> colInputParameterObjects = new ArrayList<Object>();
		for(TCGOCLExpression oInputParameterExpression : getVariablesOfType(
				in_oExpression, VariableClassification.INPUT_PARAMETER)) {
			
			TCGOCLAtom oAtom = (TCGOCLAtom)oInputParameterExpression;
			if(oAtom != null) {
				
				if(oAtom.getOclReference() instanceof PropertyCallExp) {
					colInputParameterObjects.add(
							((PropertyCallExp)oAtom.getOclReference()).
							getReferredProperty());
				}
				else if(oAtom.getOclReference() instanceof VariableExp) {
					colInputParameterObjects.add(
							((VariableExp)oAtom.getOclReference()).
							getReferredVariable().getRepresentedParameter());
				}					
			}	
		}
		return colInputParameterObjects;
	}
	
	public static List<TCGOCLAtom> getVariablesOfType(
			TCGOCLExpression in_oExpression,
			VariableClassification in_oClassification)
	{
		TCGOCLVariableClassificator oClassificator = 
			new TCGOCLVariableClassificator(in_oExpression);
		return oClassificator.getClassifiedElementsInExpression(
				in_oClassification);		
	}

	public static boolean firstExpressionIsSatisfiedBySecondExpression(
				TCGOCLExpression in_oCheckedExpression,
				TCGOCLExpression in_oWarrantedExpression,
				boolean in_bBoundariesMatchExactly)
	{
		TCGOCLAtom oCheckedElement = null;
		TCGOCLAtom oWarrantedElement = null;
		
		int nCheckedAtoms = getPassiveDependentVariablesAndInputParameters(in_oCheckedExpression).size(); 
		int nWarrantedAtoms = getPassiveDependentVariablesAndInputParameters(in_oWarrantedExpression).size(); 
		
		if((nCheckedAtoms == 1) && (nWarrantedAtoms == 1)) {
			// both expressions are operations
			if(in_oCheckedExpression instanceof TCGOCLOperation) {
				TCGOCLVariableClassificator oCheckedClassificator = 
					new TCGOCLVariableClassificator(in_oCheckedExpression);
				oCheckedElement =
					TCGOCLExpressionHelperClass.
					getDependentVariablesAndInputParameters(oCheckedClassificator).get(0);
				oCheckedClassificator.shiftSubexpressionToTheLeft(oCheckedElement);
			}
			else {
				oCheckedElement = (TCGOCLAtom)in_oCheckedExpression;
			}
			
			if(in_oWarrantedExpression instanceof TCGOCLOperation) {
				TCGOCLVariableClassificator oWarrantedClassificator = 
					new TCGOCLVariableClassificator(in_oWarrantedExpression);
				oWarrantedElement =
					TCGOCLExpressionHelperClass.
					getDependentVariablesAndInputParameters(oWarrantedClassificator).get(0);
				oWarrantedClassificator.shiftSubexpressionToTheLeft(oWarrantedElement);
			}
			else {
				oWarrantedElement = (TCGOCLAtom)in_oWarrantedExpression;
			}
				
			// the referenced elements must be the same
			if((oWarrantedElement != null) && (oCheckedElement != null) &&
					expressionsContainReferenceToTheSameObject(oWarrantedElement, oCheckedElement))
			{
				// next condition: the warranted value range must be included in the checked
				ValueTypeRange oCheckedRange =
					OCLExpressionValueTypeRangeFactory.
					getValueTypeRangeForRightSideOfExpression(
							in_oCheckedExpression);
				ValueTypeRange oWarrantedRange =
					OCLExpressionValueTypeRangeFactory.
					getValueTypeRangeForRightSideOfExpression(
							in_oWarrantedExpression);
				if(ValueTypeRangeHelper.outerVTRangeContainsInnerVTRange(
						oCheckedRange, oWarrantedRange, in_bBoundariesMatchExactly))
					return true;
			}
		}
		else if((nCheckedAtoms > 1) && (nWarrantedAtoms > 1)) {
			if(expressionsAreEqual(in_oCheckedExpression, in_oWarrantedExpression))
				return true;
		}
		
		return false;
	}
	
	
	public static boolean expressionsContainReferenceToTheSameObject(
			TCGOCLAtom in_oFirstAtom, TCGOCLAtom in_oSecondAtom) {
		
		// TODO : AAA Hier unbedingt checken! (15.3.2009)
		
		if((in_oFirstAtom.getElement() instanceof Variable) &&
				(in_oSecondAtom.getElement() instanceof Variable))
		{
			EObject oFirstObject = in_oFirstAtom.getElement();
			EObject oSecondObject = in_oSecondAtom.getElement();
			if (oFirstObject.equals(oSecondObject))
				return true;
			if(oFirstObject instanceof Variable &&
					oSecondObject instanceof Variable) {
				Variable oFirstVariable = (Variable)oFirstObject;
				Variable oSecondVariable = (Variable)oSecondObject;
				if(oFirstVariable.getRepresentedParameter().equals(
						oSecondVariable.getRepresentedParameter())) {
					return true;
				}
			}
		}
//		else if ((in_oFirstAtom.getElement() instanceof PropertyCallExp) &&
//				(in_oSecondAtom.getElement() instanceof PropertyCallExp))
//		{
//			return ((PropertyCallExp)(in_oFirstAtom.getElement())).getReferredProperty()
//				.equals(((PropertyCallExp)(in_oSecondAtom.getElement())).getReferredProperty());
//		}
		else if ((in_oFirstAtom.getElement() instanceof Property) &&
				(in_oSecondAtom.getElement() instanceof Property))
		{
			return (in_oFirstAtom.getElement())
				.equals(in_oSecondAtom.getElement());
		}
		// why an error? if both referenced elements are of different type, then they are not the same
//		System.err.println("Error in TCGOCLExpressionHelperClass.expressionsContainReferenceToTheSameObject()");
		return false;
	}
	
	public static EObject getReferencedElement(TCGOCLAtom in_oAtom)
	{
		if(in_oAtom.getElement() instanceof Variable) {
			Variable oVariable = (Variable)in_oAtom.getElement();
			if(oVariable.getRepresentedParameter() != null)
				return oVariable.getRepresentedParameter();
			return in_oAtom.getElement();
		}
		else if (in_oAtom.getElement() instanceof Property) {
			return in_oAtom.getElement();
		}
		else if (in_oAtom.getElement() instanceof BooleanLiteralExp) {
			return null;
		}
		System.err.println("Error in TCGOCLExpressionHelperClass.getReferencedElement()");
		return null;
	}
	
	public static String toString(TCGOCLExpression in_oExpression)
	{
		StringBuffer sRetValue = new StringBuffer("");
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOp = (TCGOCLOperation)in_oExpression;
			if(oOp.getOperationName().equals("not")) {
				TCGOCLExpression oNonNullExp = oOp.getLeft();
				if(oNonNullExp == null)
					oNonNullExp = oOp.getRight();
				sRetValue.append("(not " + toString(oNonNullExp));
			}
			else
				sRetValue.append("(" + toString(oOp.getLeft()) + 
					" " + oOp.getOperationName() + " " +
					toString(oOp.getRight()) + ")");
		}
		else if(in_oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			if(oAtom.getElement() instanceof BooleanLiteralExp) {
				sRetValue.append(((BooleanLiteralExp)oAtom.getElement()).toString());
			}
			else if(oAtom.getElement() instanceof IntegerLiteralExp) {
				sRetValue.append(((IntegerLiteralExp)oAtom.getElement()).toString());
			}
			else { 
				sRetValue.append(((NamedElement)oAtom.getElement()).getName());
			}
		}
		return sRetValue.toString();
	}

	/*
	 * builds a hashmap from referenced objects to value ranges for all 
	 * expressions contained in the parameter list
	 */
	public static HashMap<Object, ValueTypeRange> 
		buildParameterValueTypeRangeHashMap(List<TCGOCLExpression> in_colExpressions)
	{
		HashMap<Object, ValueTypeRange> colObjectToRange = new LinkedHashMap<Object, ValueTypeRange>();
		for(TCGOCLExpression oOCLExp : in_colExpressions)
		{
			for(TCGOCLAtom oAtom : TCGOCLExpressionHelperClass.getDependentVariableOrInputParameter(oOCLExp)) {
				Object oReferencedObject = oAtom.getElement();
				ValueTypeRange oNewRange = 
					OCLExpressionValueTypeRangeFactory.getValueTypeRangeForRightSideOfExpression(
						oOCLExp);
				ValueTypeRange oExistingRange = colObjectToRange.get(oReferencedObject);
				if(oExistingRange == null)
				{
					colObjectToRange.put(oReferencedObject, oNewRange);
				} else {
					oExistingRange.adaptRange(oNewRange);
				}				
			}
		}
		return colObjectToRange;
	}
	
	/*
	 * builds a hashmap from referenced objects to value ranges for all 
	 * expressions contained in the parameter list
	 */
	public static HashMap<Object, ArrayList<TCGOCLExpression>> 
		buildParameterExpressionHashMap(List<TCGOCLExpression> in_colExpressions)
	{
		HashMap<Object, ArrayList<TCGOCLExpression>> colObjectToExpressions = 
			new LinkedHashMap<Object, ArrayList<TCGOCLExpression>>();
		for(TCGOCLExpression oOCLExp : in_colExpressions) {
			for(TCGOCLAtom oAtom : TCGOCLExpressionHelperClass.getDependentVariableOrInputParameter(oOCLExp)) {
				Object oReferencedObject = oAtom.getElement();
				ArrayList<TCGOCLExpression> colExpressions =
					colObjectToExpressions.get(oReferencedObject);
				if(colExpressions == null)
				{
					colExpressions = new ArrayList<TCGOCLExpression>();
					colObjectToExpressions.put(oReferencedObject, colExpressions);
				}
				colExpressions.add(oOCLExp);
			}
		}
		return colObjectToExpressions;
	}
	
	public static boolean isBooleanExpression(TCGOCLExpression in_oExpression)
	{
		if(isBooleanOperation(in_oExpression) || isBooleanAtom(in_oExpression))
			return true;
		return false;
	}
	
	public static boolean isBooleanAtom(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLAtom) {
			if(((TCGOCLAtom)in_oExpression).getElement() instanceof BooleanLiteralExp)
				return true;
			List<Object> colObjects = getInputParametersFromExpression(in_oExpression);
			Object oObject = null;
			
			if(colObjects.isEmpty())
				oObject = ((TCGOCLAtom)in_oExpression).getElement();
			else
				oObject = colObjects.get(0);
			
			if(oObject instanceof Property) {
				Property oProperty = (Property)oObject;
				if(TypeNameHelperClass.isBooleanTypeName(oProperty.getType().getName()))
					return true;
			}
			else if(oObject instanceof Parameter) {
				Parameter oParam = (Parameter)oObject;
				if(TypeNameHelperClass.isBooleanTypeName(oParam.getType().getName()))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isBooleanOperation(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			return oOperation.getOperationName().equals("and") ||
				oOperation.getOperationName().equals("or") ||
				oOperation.getOperationName().equals("not");
		}
		return false;
	}
	
	public static boolean isComparisonOperation(TCGOCLExpression in_oExpression) 
	{
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			return oOperation.getOperationName().equals("<") ||
				oOperation.getOperationName().equals("<=") ||
				oOperation.getOperationName().equals(">") ||
				oOperation.getOperationName().equals(">=") ||
				oOperation.getOperationName().equals("=") ||
				oOperation.getOperationName().equals("<>");
		}
		return false;		
	}

	
	public static TCGDisjunctiveNormalForm createDNFForExpressionAndDecisionTableRow(
			TCGOCLExpression in_oExpression, 
			DecisionTableExpressionValueSelection in_oRow)
	{
		// create an expression copy 
		DecisionTableExpressionValueSelection oNewRow = new DecisionTableExpressionValueSelection();
		// change the expression according to the value selection row (e.g. negated -> add "not")
		TCGOCLExpression oNewExpression = changeExpressionAccordingToDecisionTableRow(
				in_oExpression, in_oRow, oNewRow);

		// complete the value selection row in oNewRow for composite expressions
		boolean bTruthValue = DecisionTableRowEvaluator.evaluateExpressionWithValueAssignment(
				oNewExpression, oNewRow);
		
		// create new dummy DNF with one conjunction
		TCGDisjunctiveNormalForm oDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
		TCGConjunction oConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		oConjunction.setPositiveSubExpressionOfOriginal(bTruthValue);
		oDNF.getConjunctions().add(oConjunction);
		// now create a "resricted" DNF that has (almost) no disjunctions
		// the "restricted" DNF is more or less just a conjunction of expressions
		// matching the current value selection row
		TCGDisjunctiveNormalFormHelperClass.createRestrictedDisjunctiveNormalForm(
				oNewExpression, oNewRow, false, oDNF);
		return oDNF;
	}

	public static TCGOCLExpression changeExpressionAccordingToDecisionTableRow(
			TCGOCLExpression in_oExpression, 
			DecisionTableExpressionValueSelection in_oRow,
			DecisionTableExpressionValueSelection out_oRow)
	{
		TCGOCLExpression oTCGOCLExpression = null;
		if(in_oExpression != null)
		{
			if(in_oExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oOldAtom = (TCGOCLAtom)in_oExpression;
				TCGOCLAtom oNewAtom = GeneratedFactory.eINSTANCE.createTCGOCLAtom();
				oNewAtom.setElement(oOldAtom.getElement());
				oNewAtom.setTcgParameter(oOldAtom.getTcgParameter());
				oTCGOCLExpression = oNewAtom;
			}
			else if(in_oExpression instanceof TCGOCLOperation)
			{
				in_oExpression = TCGOCLExpressionHelperClass.removeDoubleNots(in_oExpression);
				
				TCGOCLOperation oOldOperation = (TCGOCLOperation)in_oExpression;
				TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oNewOperation.setOperation(oOldOperation.getOperation());
				oNewOperation.setOperationName(oOldOperation.getOperationName());
				oNewOperation.setLeft(changeExpressionAccordingToDecisionTableRow(
						oOldOperation.getLeft(), in_oRow, out_oRow));
				oNewOperation.setRight(changeExpressionAccordingToDecisionTableRow(
						oOldOperation.getRight(), in_oRow, out_oRow));
				oTCGOCLExpression = oNewOperation;
			}
			else if(in_oExpression instanceof TCGOCLIfThenElse)
			{
				TCGOCLIfThenElse oOldIfThenElse = (TCGOCLIfThenElse)in_oExpression;
				TCGOCLIfThenElse oNewIfThenElse = GeneratedFactory.eINSTANCE.createTCGOCLIfThenElse();
				oNewIfThenElse.setClassification(oOldIfThenElse.getClassification());
				oNewIfThenElse.setCondition(changeExpressionAccordingToDecisionTableRow(
						oOldIfThenElse.getCondition(), in_oRow, out_oRow));
				oNewIfThenElse.setThenExpression(changeExpressionAccordingToDecisionTableRow(
						oOldIfThenElse.getThenExpression(), in_oRow, out_oRow));
				oNewIfThenElse.setElseExpression(changeExpressionAccordingToDecisionTableRow(
						oOldIfThenElse.getElseExpression(), in_oRow, out_oRow));
				oTCGOCLExpression = oNewIfThenElse;
			}
			oTCGOCLExpression.setClassification(in_oExpression.getClassification());
			oTCGOCLExpression.setPositiveAssignmentOfOriginal(in_oExpression.isPositiveAssignmentOfOriginal());
			oTCGOCLExpression.setOclReference(in_oExpression.getOclReference());
		}
		
		if(in_oRow.get(in_oExpression) != null)
		{
			if(in_oRow.get(in_oExpression).equals(false))
			{
				oTCGOCLExpression = TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(oTCGOCLExpression);
				out_oRow.put(oTCGOCLExpression, false);
			}
			else
			{
				oTCGOCLExpression = TCGOCLExpressionHelperClass.copyExpression(oTCGOCLExpression);
				out_oRow.put(oTCGOCLExpression, true);
			}
		}
		
		return oTCGOCLExpression;
	}
	
	public static TCGOCLExpression removeDoubleNots(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation) { 
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;
			if(oOpExp.getOperationName().equals("not")) {
				TCGOCLExpression oNegatedOp = oOpExp.getLeft();
				if(oNegatedOp == null)
					oNegatedOp = oOpExp.getRight();
				
				if(oNegatedOp instanceof TCGOCLOperation) {
					TCGOCLOperation oPositiveOp = (TCGOCLOperation)oNegatedOp;
					if(oPositiveOp.getOperationName().equals("not")) {
						TCGOCLExpression oFinalExp = oPositiveOp.getLeft();
						if(oFinalExp == null)
							oFinalExp = oPositiveOp.getRight();
						
						return removeDoubleNots(oFinalExp);
					}
				}
			}
		}
		return in_oExpression;
	}
	
	public static TCGOCLExpression getNonNullLeftOrRight(TCGOCLOperation in_oOperation) 
	{
		if(in_oOperation.getLeft() != null)
			return in_oOperation.getLeft();
		return in_oOperation.getRight();
	}
	
	public static TCGOCLExpression pushDownNots(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;
			TCGOCLExpression oLeftOrRightExp = 
				TCGOCLExpressionHelperClass.getNonNullLeftOrRight(oOpExp);
			if(oOpExp.getOperationName().equals("not") &&
					!TCGOCLExpressionHelperClass.isBooleanAtom(oLeftOrRightExp)) {
				return TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(
						oLeftOrRightExp);
			}
			oOpExp.setLeft(pushDownNots(oOpExp.getLeft()));
			oOpExp.setRight(pushDownNots(oOpExp.getRight()));
		}
		return in_oExpression;
	}

	
	public static boolean expressionListsAreRedundant(
			EList<TCGOCLExpression> in_colExpressions1,
			EList<TCGOCLExpression> in_colExpressions2)
	{
		
		for(TCGOCLExpression oExpression1 : in_colExpressions1)
		{
			boolean bFound = false;
			for(TCGOCLExpression oExpression2 : in_colExpressions2)
			{
				if((oExpression1 == oExpression2) ||
					firstExpressionIsSatisfiedBySecondExpression(
						oExpression1, oExpression2, true))
				{
					bFound = true;
					break;
				}
			}
			if(bFound == false)
				return false;
		}
		return true;
	}

	/*
	 * checks if one expression is contradicting in terms
	 */
	public static boolean expressionIsContradicting(TCGOCLOperation in_oExpression)
	{
		// TODO: implement a checker operation to return the type of an expression (boolean, int, double)
		try { // double?
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			double nLeftValue = TCGOCLExpressionHelperClass.getDoubleValue(oOperation.getLeft());
			double nRightValue = TCGOCLExpressionHelperClass.getDoubleValue(oOperation.getRight());
			if((oOperation.getOperationName().compareTo("<") == 0) && (nLeftValue >= nRightValue))
				return true;
			if((oOperation.getOperationName().compareTo("<=") == 0) && (nLeftValue > nRightValue))
				return true;
			if((oOperation.getOperationName().compareTo("=") == 0) && (nLeftValue != nRightValue))
				return true;
			if((oOperation.getOperationName().compareTo(">=") == 0) && (nLeftValue < nRightValue))
				return true;
			if((oOperation.getOperationName().compareTo(">") == 0) && (nLeftValue <= nRightValue))
				return true;
			if((oOperation.getOperationName().compareTo("<>") == 0) && (nLeftValue == nRightValue))
				return true;
		}
		catch(Exception e)
		{
			// nothing ...
			try { // int?
				TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
				int nLeftValue = TCGOCLExpressionHelperClass.getIntegerValue(oOperation.getLeft());
				int nRightValue = TCGOCLExpressionHelperClass.getIntegerValue(oOperation.getRight());
				if((oOperation.getOperationName().compareTo("<") == 0) && (nLeftValue >= nRightValue))
					return true;
				if((oOperation.getOperationName().compareTo("<=") == 0) && (nLeftValue > nRightValue))
					return true;
				if((oOperation.getOperationName().compareTo("=") == 0) && (nLeftValue != nRightValue))
					return true;
				if((oOperation.getOperationName().compareTo(">=") == 0) && (nLeftValue < nRightValue))
					return true;
				if((oOperation.getOperationName().compareTo(">") == 0) && (nLeftValue <= nRightValue))
					return true;
				if((oOperation.getOperationName().compareTo("<>") == 0) && (nLeftValue == nRightValue))
					return true;
			}
			catch(Exception e1) {
				// nothing ...
				try { // boolean?
					TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
					boolean nLeftValue = TCGOCLExpressionHelperClass.getBooleanValueIfNegative(oOperation.getLeft());
					boolean nRightValue = TCGOCLExpressionHelperClass.getBooleanValueIfNegative(oOperation.getRight());
					if((oOperation.getOperationName().compareTo("=") == 0) && (nLeftValue != nRightValue))
						return true;
					if((oOperation.getOperationName().compareTo("<>") == 0) && (nLeftValue == nRightValue))
						return true;
				}
				catch(Exception e2) {
					
					// nothing ... but an error message
					System.err.println("error in operation TCGOCLExpressionHelperClass::expressionIsContradicting");
				}				
			}
		}
		return false;
	}

	
	public static TCGOCLExpression negateArithmeticalTCGOCLExpression(
			TCGOCLExpression in_oTCGOCLExpression) {

		if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if(isUnaryMinus(oOpExp)) {
				in_oTCGOCLExpression = getNonNullLeftOrRight(oOpExp);
			}
			else {
				if(oOpExp.getOperationName().equals("*") ||
						oOpExp.getOperationName().equals("/")) {
					// just negate one of the sides
					// first look if one of the sides is a unary minus
					if(isUnaryMinus(oOpExp.getRight())) {
						oOpExp.setRight(negateArithmeticalTCGOCLExpression(oOpExp.getRight()));
					}
					else {
						oOpExp.setLeft(negateArithmeticalTCGOCLExpression(oOpExp.getLeft()));
					}
				}
				else if(oOpExp.getOperationName().equals("+") ||
						oOpExp.getOperationName().equals("-")) {
					oOpExp.setLeft(negateArithmeticalTCGOCLExpression(oOpExp.getLeft()));
					oOpExp.setOperationName(
							sm_colCorrespondingOperations.get(oOpExp.getOperationName()));
				}
				else { // ???
					oOpExp.setLeft(negateArithmeticalTCGOCLExpression(oOpExp.getLeft()));
					oOpExp.setRight(negateArithmeticalTCGOCLExpression(oOpExp.getRight()));
				}
			}
		}
		else if(in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLOperation oOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
			oOperation.setLeft(null);
			oOperation.setRight(in_oTCGOCLExpression);
			oOperation.setPositiveAssignmentOfOriginal(!in_oTCGOCLExpression.isPositiveAssignmentOfOriginal());
			oOperation.setOperationName("-");
			return oOperation;					
		}
		return in_oTCGOCLExpression;
	}
	
	public static TCGOCLExpression negateLogicalTCGOCLExpression(
				TCGOCLExpression in_oTCGOCLExpression) {
	
		// TODO die Funktionalität in den einzelnen ValueTypes implementieren ... ?
		
		if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			// if operation name is not in list -> do not change it (e.g.
			// addition, subtraction, ...) -> this is no negation
			String sNewName = sm_colNameMatching.get(oOpExp.getOperationName());
			if (sNewName != null) {
				TCGOCLOperation oNewOp = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				
				if(sNewName.equals("not removed")) {
					if(oOpExp.getLeft() != null)
						return oOpExp.getLeft();
					return oOpExp.getRight();
				}
				else
					oNewOp.setOperationName(sNewName);
				
				if (oOpExp.getLeft() != null)
				{
					if(TCGOCLExpressionHelperClass.isBooleanOperation(oOpExp))
						oNewOp.setLeft(negateLogicalTCGOCLExpression(
								oOpExp.getLeft()));
					else
						oNewOp.setLeft(oOpExp.getLeft());
				}
				if (oOpExp.getRight() != null)
				{
					if(TCGOCLExpressionHelperClass.isBooleanOperation(oOpExp))
						oNewOp.setRight(negateLogicalTCGOCLExpression(
								oOpExp.getRight()));
					else
						oNewOp.setRight(oOpExp.getRight());
				}
				oNewOp.setClassification(oOpExp.getClassification());
				oNewOp.setOclReference(oOpExp.getOclReference());
				oNewOp.setOperation(oOpExp.getOperation());
				oNewOp.setPositiveAssignmentOfOriginal(!oOpExp.isPositiveAssignmentOfOriginal());
				return oNewOp;
			}
		} 
		else if(in_oTCGOCLExpression instanceof TCGOCLAtom) {
			if(TCGOCLExpressionHelperClass.isBooleanAtom(in_oTCGOCLExpression)) {
				TCGOCLOperation oOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oOperation.setLeft(null);
				oOperation.setRight(in_oTCGOCLExpression);
				oOperation.setPositiveAssignmentOfOriginal(!in_oTCGOCLExpression.isPositiveAssignmentOfOriginal());
				oOperation.setOperationName("not");
				return oOperation;					
			}
		}
		return in_oTCGOCLExpression;
	}

	public static boolean needsToBeConverted(TCGOCLExpression in_oExpression) {
		try {
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(
					in_oExpression);
	
			// there is at least one dependent variable -> convert the
			// expression!
			if (oClassificator.getNumberOfDependentVariables() > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			Configuration.handleException(e);
		}
		return true;
	}

	/*
	 * normalizes the ocl expression This operation looks first for input
	 * parameters and (if not found) for passive dependent elements. The found
	 * element is then shifted to the left.
	 */
	public static void normalizeExpression(TCGOCLExpression in_oCondition) {
		if (in_oCondition != null) {
			// find input parameter in condition
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(
					in_oCondition);
			TCGOCLExpression oToBeIsolatedOnLeft = null;
			List<TCGOCLAtom> colExpression = oClassificator
					.getClassifiedElementsInExpression(VariableClassification.ACTIVE_DEPENDENT);
			if (colExpression.isEmpty()) {
				colExpression = oClassificator
					.getClassifiedElementsInExpression(VariableClassification.INPUT_PARAMETER);
				if (colExpression.isEmpty()) {
					colExpression = oClassificator
						.getClassifiedElementsInExpression(VariableClassification.PASSIVE_DEPENDENT);
					if(!colExpression.isEmpty())
						oToBeIsolatedOnLeft = colExpression.get(0); 
				}
				else {
					oToBeIsolatedOnLeft = colExpression.get(0);
				}
			}
			else {
				oToBeIsolatedOnLeft = colExpression.get(0);
			}
	
			if (oToBeIsolatedOnLeft != null) {
				// if not isolated on left side - then isolate!
				if (!oClassificator
						.expressionIsIsolatedOnLeftSide(oToBeIsolatedOnLeft)) {
					oClassificator
							.shiftSubexpressionToTheLeft(oToBeIsolatedOnLeft);
				}
			}
		}
	}

	/*
	 * return an interpretation as a double value
	 */  
	public static double getDoubleValue(TCGOCLExpression in_oTCGOCLExpression)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
	
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					throw new Exception("error in getValue() for property "
							+ oProp.getName());
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return Double.valueOf(sValue).doubleValue();
				}
			}
			if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return Double.valueOf(oRef.getDefaultValueLiteral());
			}
			if (oPropExp.getElement() instanceof RealLiteralExp) {
				RealLiteralExp oRealExp = (RealLiteralExp) oPropExp.getElement();
				return oRealExp.getRealSymbol();
			}
		} else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().compareTo("+") == 0) {
				return getDoubleValue(oOpExp.getLeft()) + getDoubleValue(oOpExp.getRight());
			} else if (oOpExp.getOperationName().compareTo("-") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return -getDoubleValue(oOpExp.getRight());
				if (oOpExp.getRight() == null)
					return -getDoubleValue(oOpExp.getLeft());
				return getDoubleValue(oOpExp.getLeft()) - getDoubleValue(oOpExp.getRight());
			} else if (oOpExp.getOperationName().compareTo("*") == 0) {
				return getDoubleValue(oOpExp.getLeft()) * getDoubleValue(oOpExp.getRight());
			} else if (oOpExp.getOperationName().compareTo("/") == 0) {
				return getDoubleValue(oOpExp.getLeft()) / getDoubleValue(oOpExp.getRight());
			}
			// TODO weitere Operationen einfügen
		}
		return 0;
	}

	/*
	 * return an interpretation as a double value
	 */  
	public static Double getDoubleValue(
			TCGOCLExpression in_oTCGOCLExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colValueAssignments)
			throws Exception {
		
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			if(in_colValueAssignments.keySet().contains(oPropExp)) {
				return Double.valueOf(in_colValueAssignments.get(oPropExp).getValue());
			}
			
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
	
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					throw new Exception("error in getValue() for property "
							+ oProp.getName());
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return Double.valueOf(sValue).doubleValue();
				}
			}
			if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return Double.valueOf(oRef.getDefaultValueLiteral());
			}
			if (oPropExp.getElement() instanceof RealLiteralExp) {
				RealLiteralExp oRealExp = (RealLiteralExp) oPropExp.getElement();
				return oRealExp.getRealSymbol();
			}
		} else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().compareTo("+") == 0) {
				return getDoubleValue(oOpExp.getLeft(), in_colValueAssignments) + 
				getDoubleValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("-") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return -getDoubleValue(oOpExp.getRight(), in_colValueAssignments);
				if (oOpExp.getRight() == null)
					return -getDoubleValue(oOpExp.getLeft(), in_colValueAssignments);
				return getDoubleValue(oOpExp.getLeft(), in_colValueAssignments) - 
				getDoubleValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("*") == 0) {
				return getDoubleValue(oOpExp.getLeft(), in_colValueAssignments) * 
				getDoubleValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("/") == 0) {
				return getDoubleValue(oOpExp.getLeft(), in_colValueAssignments) / 
				getDoubleValue(oOpExp.getRight(), in_colValueAssignments);
			}
			// TODO weitere Operationen einfügen
		}
		return null;
	}
	
	
	/*
	 * return an interpretation as a integer value
	 */  
	public static Integer getIntegerValue(TCGOCLExpression in_oTCGOCLExpression)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
	
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					// nothing ... system attributes do not have to have fixed values, too
//					throw new Exception("error in getValue() for property "
//							+ oProp.getName());
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return Integer.valueOf(sValue).intValue();
				}
			}
			if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return Integer.valueOf(oRef.getDefaultValueLiteral());
			}
			if (oPropExp.getElement() instanceof IntegerLiteralExp) {
				IntegerLiteralExp oIntExp = (IntegerLiteralExp) oPropExp.getElement();
				return oIntExp.getIntegerSymbol();
			}			
		} else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().compareTo("+") == 0) {
				return getIntegerValue(oOpExp.getLeft()) + getIntegerValue(oOpExp.getRight());
//				Integer i1 = getIntegerValue(oOpExp.getLeft());
//				Integer i2 = getIntegerValue(oOpExp.getRight());
//				if(i1 == null || i2 == null)
//					return null;
//				return i1 + i2;
			} else if (oOpExp.getOperationName().compareTo("-") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return -getIntegerValue(oOpExp.getRight());
				if (oOpExp.getRight() == null)
					return -getIntegerValue(oOpExp.getLeft());
				return getIntegerValue(oOpExp.getLeft()) - getIntegerValue(oOpExp.getRight());
			} else if (oOpExp.getOperationName().compareTo("*") == 0) {
				return getIntegerValue(oOpExp.getLeft()) * getIntegerValue(oOpExp.getRight());
			} else if (oOpExp.getOperationName().compareTo("/") == 0) {
				int left = getIntegerValue(oOpExp.getLeft());
				int right = getIntegerValue(oOpExp.getRight());
				if (left % right != 0) {
					setLastIntegerComputationWasIncorrect(true);
				}
				return left / right;
//				return getIntegerValue(oOpExp.getLeft()) / getIntegerValue(oOpExp.getRight());
			}
			// TODO weitere Operationen einfügen
		}
		return null;
	}

	/*
	 * return an interpretation as a integer value
	 */  
	public static Integer getIntegerValue(
			TCGOCLExpression in_oTCGOCLExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colValueAssignments)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			if(in_colValueAssignments.keySet().contains(oPropExp)) {
				return Integer.valueOf(in_colValueAssignments.get(oPropExp).getValue());
			}

			return getIntegerValue(in_oTCGOCLExpression);
	
		} else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().compareTo("+") == 0) {
				return getIntegerValue(oOpExp.getLeft(), in_colValueAssignments) + 
				getIntegerValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("-") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return -getIntegerValue(oOpExp.getRight(), in_colValueAssignments);
				if (oOpExp.getRight() == null)
					return -getIntegerValue(oOpExp.getLeft(), in_colValueAssignments);
				return getIntegerValue(oOpExp.getLeft(), in_colValueAssignments) - 
				getIntegerValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("*") == 0) {
				return getIntegerValue(oOpExp.getLeft(), in_colValueAssignments) * 
				getIntegerValue(oOpExp.getRight(), in_colValueAssignments);
			} else if (oOpExp.getOperationName().compareTo("/") == 0) {
				return getIntegerValue(oOpExp.getLeft(), in_colValueAssignments) / 
				getIntegerValue(oOpExp.getRight(), in_colValueAssignments);
			}
			// TODO weitere Operationen einfügen
		}
		return null;
	}

	
	/*
	 * it is assumed that all values are inclusive
	 */
	public static Pair<Integer, Integer> getIntegerValuePair(
			TCGOCLExpression in_oTCGOCLExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, Pair<ValueType, ValueType>> in_colCurrentValueRanges) throws Exception {
		
		Pair<Integer, Integer> oRetValuePair = null;
		if(in_oTCGOCLExpression == null) {
			// nothing
		}
		else if(in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oTCGOCLExpression;
			// TODO: eindeutige Referenz zwischen zwei Atoms, die das gleiche Objekt referenzieren
			// schaffen -> sonst Probleme bei mehreren gleichen Parameterverwendungen in einer group
			//if(in_colCurrentValueRanges.keySet().contains(in_oTCGOCLExpression)) {
			boolean bFound = false;
			for(TCGOCLAtom oFixedAtom : in_colCurrentValueRanges.keySet()) {
				if(oFixedAtom.getElement().equals(oAtom.getElement())) {
					oRetValuePair = new Pair<Integer, Integer>(
							((IntegerValueType)(in_colCurrentValueRanges.get(oFixedAtom).getFirst())).getValue(),
							((IntegerValueType)(in_colCurrentValueRanges.get(oFixedAtom).getSecond())).getValue()
							);		
					bFound = true;
				}
			}
			if(bFound == false) {
				Integer oValue = getIntegerValue(in_oTCGOCLExpression, in_colCurrentValueAssignment);
				if(oValue != null)
					oRetValuePair = new Pair<Integer, Integer>(oValue, oValue);
			}
		}
		else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			Pair<Integer, Integer> oFirstPair = getIntegerValuePair(
					oOpExp.getLeft(), in_colCurrentValueAssignment, in_colCurrentValueRanges);
			Pair<Integer, Integer> oSecondPair = getIntegerValuePair(
					oOpExp.getRight(), in_colCurrentValueAssignment, in_colCurrentValueRanges); 

			if (oOpExp.getOperationName().compareTo("+") == 0) {
				if(oFirstPair != null && oSecondPair != null)
					oRetValuePair = new Pair<Integer, Integer>(
						oFirstPair.getFirst().intValue() + oSecondPair.getFirst().intValue(),
						oFirstPair.getSecond().intValue() + oSecondPair.getSecond().intValue());
			} else if (oOpExp.getOperationName().compareTo("-") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oFirstPair == null) { 
					if(oSecondPair != null)
						oRetValuePair = new Pair<Integer, Integer>(
							-oSecondPair.getSecond().intValue(), 
							-oSecondPair.getFirst().intValue());
				}
				else if (oSecondPair == null) {
					if(oFirstPair != null)
						oRetValuePair = new Pair<Integer, Integer>(
							-oFirstPair.getSecond().intValue(), 
							-oFirstPair.getFirst().intValue());
				}
				else {
					oRetValuePair = new Pair<Integer, Integer>(
							oFirstPair.getFirst().intValue() - oSecondPair.getSecond().intValue(), 
							oFirstPair.getSecond().intValue() - oSecondPair.getFirst().intValue());
				}
			} else if (oOpExp.getOperationName().compareTo("*") == 0) {
				if(oFirstPair != null && oSecondPair != null) {
					int nMaxValue = Math.max(oFirstPair.getFirst().intValue() * oSecondPair.getFirst().intValue(), 
							oFirstPair.getSecond().intValue() * oSecondPair.getSecond().intValue());
					int nMinValue = Math.min(
							oFirstPair.getFirst().intValue() * oSecondPair.getFirst().intValue(),
							Math.min(
									oFirstPair.getFirst().intValue() * oSecondPair.getSecond().intValue(),
									oFirstPair.getSecond().intValue() * oSecondPair.getFirst().intValue()));
	
					oRetValuePair = new Pair<Integer, Integer>(nMinValue, nMaxValue);
				}
			} else if (oOpExp.getOperationName().compareTo("/") == 0) {
				if(oFirstPair != null && oSecondPair != null) {
					int nMaxValue = Integer.MAX_VALUE;
					if(!(oSecondPair.getFirst().intValue() <= 0 &&
							oSecondPair.getSecond().intValue() >= 0) ||
							oFirstPair.getSecond() <= 0) {
						// maximum value is not infinite
						nMaxValue = Math.max(oFirstPair.getSecond().intValue() / oSecondPair.getFirst().intValue(),
								oFirstPair.getFirst().intValue() / oSecondPair.getSecond().intValue());
					}
					int nMinValue = Integer.MIN_VALUE;
					if(!(oSecondPair.getFirst().intValue() <= 0 &&
							oSecondPair.getSecond().intValue() >= 0) ||
							oFirstPair.getFirst() >= 0) {
						// maximum value is not infinite
						nMinValue = Math.min(oFirstPair.getSecond().intValue() / oSecondPair.getFirst().intValue(),
								oFirstPair.getFirst().intValue() / oSecondPair.getSecond().intValue());
					}
					oRetValuePair = new Pair<Integer, Integer>(nMinValue, nMaxValue);
				}
			}
		}
		return oRetValuePair;
	}

	
	/*
	 * return an interpretation as a boolean value
	 */
	public static boolean getBooleanValueIfNegative(TCGOCLExpression in_oTCGOCLExpression)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
		
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
//					throw new Exception("error in getValue() for property "
//							+ oProp.getName());
					// if only a boolean element is referenced, then the meaning is "= true"
					return true;
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return Boolean.parseBoolean(sValue);
				}
			}
			if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return Boolean.parseBoolean(oRef.getDefaultValueLiteral());
			}
			if (oPropExp.getElement() instanceof BooleanLiteralExp) {
				BooleanLiteralExp oBLExp = (BooleanLiteralExp) oPropExp.getElement();
				return oBLExp.getBooleanSymbol();
			}
		}
		else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().equals("and")) {
				return getBooleanValueIfNegative(oOpExp.getLeft()) && getBooleanValueIfNegative(oOpExp.getRight());
			} else if (oOpExp.getOperationName().equals("or")) {
				return getBooleanValueIfNegative(oOpExp.getLeft()) || getBooleanValueIfNegative(oOpExp.getRight());
			} else if (oOpExp.getOperationName().equals("not")) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return !getBooleanValueIfNegative(oOpExp.getRight());
				if (oOpExp.getRight() == null)
					return !getBooleanValueIfNegative(oOpExp.getLeft());
				throw new Exception("\"not\" was not interpreted correctly in getBooleanValue()");
				//return false;
			}
			// check if this is a constant expression:
			List<TCGOCLAtom> colAtoms = TCGOCLExpressionHelperClass.
				getDependentVariableOrInputParameter(in_oTCGOCLExpression);
			if(colAtoms.size() == 0) {
				return (expressionIsContradicting(oOpExp)) ? false : true;
			}
		}
		return true;
	}

	
	/*
	 * return an interpretation as a boolean value
	 */
	public static boolean getBooleanValue(
			TCGOCLExpression in_oTCGOCLExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment)
			throws Exception {
		
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			// look if there is an externally predefined value
			if(in_colCurrentValueAssignment.keySet().contains(oPropExp)) {
				return !(in_colCurrentValueAssignment.get("oPropExp").getValue()
						.equals("false"));					
			}

			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
		
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					// if only a boolean element is referenced, then the meaning is "= true"
					return true;
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return Boolean.parseBoolean(sValue);
				}
			}
			if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return Boolean.parseBoolean(oRef.getDefaultValueLiteral());
			}
			if (oPropExp.getElement() instanceof BooleanLiteralExp) {
				BooleanLiteralExp oBLExp = (BooleanLiteralExp) oPropExp.getElement();
				return oBLExp.getBooleanSymbol();
			}
		}
		else if (in_oTCGOCLExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation) in_oTCGOCLExpression;
			if (oOpExp.getOperationName().compareTo("and") == 0) {
				return getBooleanValue(oOpExp.getLeft(), in_colCurrentValueAssignment) && 
				getBooleanValue(oOpExp.getRight(), in_colCurrentValueAssignment);
			} else if (oOpExp.getOperationName().compareTo("or") == 0) {
				return getBooleanValue(oOpExp.getLeft(), in_colCurrentValueAssignment) || 
				getBooleanValue(oOpExp.getRight(), in_colCurrentValueAssignment);
			} else if (oOpExp.getOperationName().compareTo("not") == 0) {
				// TODO für unäre Operationen neuen Typ einführen
				if (oOpExp.getLeft() == null)
					return !getBooleanValue(oOpExp.getRight(), in_colCurrentValueAssignment);
				if (oOpExp.getRight() == null)
					return !getBooleanValue(oOpExp.getLeft(), in_colCurrentValueAssignment);
				throw new Exception("\"not\" was not interpreted correctly in getBooleanValue()");
				//return false;
			} 
			// TODO weitere Operationen einfügen
		}
		return true;
	}
	
	/*
	 * return an interpretation as a boolean value
	 */
	public static String getEnumStringValue(TCGOCLExpression in_oTCGOCLExpression)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
		
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} 
			else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					throw new Exception("error in getValue() for property "
							+ oProp.getName());
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return sValue;
				}
			}
			else if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return oRef.getDefaultValueLiteral();
			}
			else if (oPropExp.getElement() instanceof EnumerationLiteral) {
				EnumerationLiteral oEnum = (EnumerationLiteral)oPropExp.getElement();
				return oEnum.getName();
			}
	
		}
		return null;
	}
	
	
	/*
	 * return an interpretation as a boolean value
	 */
	public static String getEnumStringValue(
			TCGOCLExpression in_oTCGOCLExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colValueAssignments)
			throws Exception {
		if (in_oTCGOCLExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oPropExp = (TCGOCLAtom) in_oTCGOCLExpression;
			if(in_colValueAssignments.keySet().contains(oPropExp)) {
				return in_colValueAssignments.get(oPropExp).getValue();
			}
			
			Variable oVar = null;
			if (oPropExp.getElement() instanceof Variable) {
				oVar = (Variable)oPropExp.getElement();
			}
		
			if (oVar != null) {
				// nothing - variables do not have fixed values
			} 
			else if (oPropExp.getElement() instanceof Property) {
				Property oProp = (Property) oPropExp.getElement();
				if (oProp.getDefaultValue() == null) {
					throw new Exception("error in getValue() for property "
							+ oProp.getName());
				} else {
					String sValue = oProp.getDefaultValue().stringValue();
					return sValue;
				}
			}
			else if (oPropExp.getElement() instanceof EReferenceImpl) {
				EReferenceImpl oRef = (EReferenceImpl) oPropExp.getElement();
				return oRef.getDefaultValueLiteral();
			}
			else if (oPropExp.getElement() instanceof EnumerationLiteral) {
				EnumerationLiteral oEnum = (EnumerationLiteral)oPropExp.getElement();
				return oEnum.getName();
			}
	
		}
		return null;
	}
	

	public static TCGDisjunctiveNormalForm splitUpInequationToDNF(TCGOCLOperation in_oTCGOCLOperation)
	{
		ArrayList<TCGOCLExpression> colExpressions = 
			splitUpInequationToExpressionList(in_oTCGOCLOperation);
	
		if(!colExpressions.isEmpty())
		{
			TCGDisjunctiveNormalForm oNewDNF = GeneratedFactory.eINSTANCE
				.createTCGDisjunctiveNormalForm();
			
			for(TCGOCLExpression oExpression : colExpressions)
			{
				TCGConjunction oConjunction = GeneratedFactory.eINSTANCE
					.createTCGConjunction();
				oConjunction.getExpressions().add(oExpression);
				oNewDNF.getConjunctions().add(oConjunction);
			}
			return oNewDNF;
		}
		return null;
	}

	public static ArrayList<TCGOCLExpression> splitUpInequationToExpressionList(TCGOCLOperation in_oTCGOCLOperation)
	{
		ArrayList<TCGOCLExpression> colRetValues = new ArrayList<TCGOCLExpression>();
		
		if (in_oTCGOCLOperation.getOperationName().compareTo("<>") == 0) {
			// check if the used types are linear ordered types (else the splitting is useless)
			if(expressionContainsLinearOrderedTypes(in_oTCGOCLOperation)) {
	
				// split up "<>" in two alternatives: "<" or ">"
				
				TCGOCLOperation oFirstExp = (TCGOCLOperation) TCGOCLExpressionHelperClass
						.copyExpression(in_oTCGOCLOperation);
				oFirstExp.setOperationName("<");
				colRetValues.add(oFirstExp);
	
				TCGOCLOperation oSecondExp = (TCGOCLOperation) TCGOCLExpressionHelperClass
						.copyExpression(in_oTCGOCLOperation);
				oSecondExp.setOperationName(">");
				colRetValues.add(oSecondExp);
			}
		}
		return colRetValues;		
	}

	public static boolean expressionContainsLinearOrderedTypes(TCGOCLExpression in_oExpression) {
		if(in_oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			// adding the reference from the atom to the containing transition
			if(oAtom.getElement() instanceof TypedElement) {
				TypedElement oTypedElement = (TypedElement)oAtom.getElement();
				Type oType = oTypedElement.getType();
				List<String> colBasicUnorderedTypeNames = new ArrayList<String>();
				colBasicUnorderedTypeNames.add("int");
				colBasicUnorderedTypeNames.add("integer");
				colBasicUnorderedTypeNames.add("double");
				for(String sTypeName : colBasicUnorderedTypeNames) {
					if(oType.getName().compareToIgnoreCase(sTypeName) == 0)
						return true;
				}
			}
		}
		else if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			if((expressionContainsLinearOrderedTypes(oOperation.getLeft()) == true) ||
				expressionContainsLinearOrderedTypes(oOperation.getRight()) == true)
					return true;
			}
		return false;
	}

	public static void combineExpressions(
			HashMap<TCGOCLExpression, ArrayList<TCGOCLExpression>> io_colNewExpressions,
			ArrayList<TCGConjunction> io_colCombinedConjunctions,
			ArrayList<TCGOCLExpression> io_colNewExpressionKeyList,
			int in_nCurrentIndex,
			ArrayList<TCGOCLExpression> io_colCurrentCombinedExpressions) {
		
		if (in_nCurrentIndex >= io_colNewExpressions.size()) {
			// assemble the conjunctions of io_colCurrentCombinedConjunction
			TCGConjunction oNewConjunction = GeneratedFactory.eINSTANCE
					.createTCGConjunction();
			for (TCGOCLExpression oExpression : io_colCurrentCombinedExpressions) {
				oNewConjunction.getExpressions().add(oExpression);
			}
			// just assembled conjunction
			io_colCombinedConjunctions.add(oNewConjunction);
		} else {
			for (TCGOCLExpression oCurrentExpression : io_colNewExpressions
					.get(io_colNewExpressionKeyList.get(in_nCurrentIndex))) {
				io_colCurrentCombinedExpressions.add(oCurrentExpression);
				combineExpressions(io_colNewExpressions,
						io_colCombinedConjunctions,
						io_colNewExpressionKeyList, in_nCurrentIndex + 1,
						io_colCurrentCombinedExpressions);
				io_colCurrentCombinedExpressions.remove(oCurrentExpression);
			}
		}
	}

	/**
	 * matches pre- and postcondition
	 * it is sure that both conditions have the reference to the same variable
	 * 
	 * @param in_oPrecondition
	 * @param in_oPostcondition
	 * @return
	 */
	public static TCGOCLExpression connectPreconditionAndPostcondition(
			TCGOCLExpression in_oPrecondition, 
			TCGOCLExpression in_oPostcondition)
	{
		TCGOCLExpression oExpression = null;
		if(in_oPrecondition instanceof TCGOCLOperation &&
				in_oPostcondition instanceof TCGOCLOperation)
		{
			TCGOCLOperation oPrecondition = (TCGOCLOperation)in_oPrecondition;
			TCGOCLOperation oPostcondition = (TCGOCLOperation)in_oPostcondition;
			// both conditions have the dependent property on the left side
	
//			// all missing combinations of relations cannot be evaluated
//			if((oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("<")) ||
//					(oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("<=")) ||
//					(oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("=")) ||
//					(oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("<")) ||
//					(oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals("<"))) {
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName("<");
//			}
//			else if((oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("<=")) ||
//					(oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("=")) ||
//					(oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals("<="))) {
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName("<=");
//			}
//			else if((oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals("=")) ||
//					(oPrecondition.getOperationName().equals("<>") && oPostcondition.getOperationName().equals("<>"))){
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName("=");
//			}
//			else if((oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals(">=")) ||
//					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals("=")) ||
//					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals(">="))) {
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName(">=");
//			}
//			else if((oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals(">")) ||
//					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals(">")) ||
//					(oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals("=")) ||
//					(oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals(">=")) ||
//					(oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals(">"))) {
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName(">");
//			}
//			else if((oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals("<>")) ||
//					(oPrecondition.getOperationName().equals("<>") && oPostcondition.getOperationName().equals("="))) {
//				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
//				((TCGOCLOperation)oExpression).setOperationName("<>");				
//			}
//			
			// all missing combinations of relations cannot be evaluated
			if((oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("<=")) ||
					(oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("="))) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName("<");
			}
			else if((oPrecondition.getOperationName().equals("<") && oPostcondition.getOperationName().equals("<")) ||
					(oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("<=")) ||
					(oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("=")) ||
					(oPrecondition.getOperationName().equals("<=") && oPostcondition.getOperationName().equals("<"))) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName("<=");
			}
			else if((oPrecondition.getOperationName().equals("=") && oPostcondition.getOperationName().equals("=")) ||
					(oPrecondition.getOperationName().equals("<>") && oPostcondition.getOperationName().equals("<>"))){
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName("=");
			}
			else if((oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals(">")) ||
					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals(">=")) ||
					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals("=")) ||
					(oPrecondition.getOperationName().equals(">=") && oPostcondition.getOperationName().equals(">"))) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName(">=");
			}
			else if((oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals(">=")) ||
					(oPrecondition.getOperationName().equals(">") && oPostcondition.getOperationName().equals("="))) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName(">");
			}
			else if((oPrecondition.getOperationName().equals("<>") && oPostcondition.getOperationName().equals("="))) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				((TCGOCLOperation)oExpression).setOperationName("<>");				
			}
			
			// got new expression -> also add copies of the left and the right part
			if(oExpression != null)
			{
				// just referencing the used sides of the original conditions is error-prone
				// -> in the following these sides are altered -> this would affect also the original conditions!
				((TCGOCLOperation)oExpression).setLeft(copyExpression(oPostcondition.getRight()));
				((TCGOCLOperation)oExpression).setRight(copyExpression(oPrecondition.getRight()));
				normalizeExpression(oExpression);
			}
			else if(oPrecondition.getOperationName().equals("not")) {
				TCGOCLExpression oNegatedExpression = null;
				if(oPrecondition.getLeft() != null)
					oNegatedExpression = oPrecondition.getLeft(); 
				if(oPrecondition.getRight() != null)
					oNegatedExpression = oPrecondition.getRight(); 
				oExpression = connectPreconditionAndPostcondition(oNegatedExpression, in_oPostcondition);
				oExpression = negateLogicalTCGOCLExpression(oExpression);
			}
			else if(oPostcondition.getOperationName().equals("not")) {
				TCGOCLExpression oNegatedExpression = null;
				if(oPostcondition.getLeft() != null)
					oNegatedExpression = oPostcondition.getLeft(); 
				if(oPostcondition.getRight() != null)
					oNegatedExpression = oPostcondition.getRight(); 
				oExpression = connectPreconditionAndPostcondition(in_oPrecondition, oNegatedExpression);
				oExpression = negateLogicalTCGOCLExpression(oExpression);				
			}
			else {
				System.err.println("no new expression created");
			}
		}
		else {
			// only possible for boolean variables
			if(in_oPrecondition instanceof TCGOCLAtom &&
				in_oPostcondition instanceof TCGOCLOperation) {
				TCGOCLOperation oPostOp = (TCGOCLOperation)in_oPostcondition;
				if(oPostOp.getOperationName().equals("="))
					oExpression = oPostOp.getRight();
				else {
					oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
					((TCGOCLOperation)oExpression).setOperationName("not");
					((TCGOCLOperation)oExpression).setRight(oPostOp.getRight());
				}
			}
			else if(in_oPrecondition instanceof TCGOCLOperation &&
				in_oPostcondition instanceof TCGOCLAtom) {
				
			}
			else if(in_oPrecondition instanceof TCGOCLAtom &&
					in_oPostcondition instanceof TCGOCLAtom) {
				// nothing - there is no new expression to satisfy
			}				
		}
		return oExpression;
	}

	/**
	 * copies the TCGOCLExpression
	 */
	public static TCGOCLExpression copyExpression(TCGOCLExpression in_oExpression)
	{
		TCGOCLExpression oTCGOCLExpression = null;
		if(in_oExpression != null)
		{
			if(in_oExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oOldAtom = (TCGOCLAtom)in_oExpression;
				oTCGOCLExpression = copyAtom(oOldAtom);
			}
			else if(in_oExpression instanceof TCGOCLOperation)
			{
				TCGOCLOperation oOldOperation = (TCGOCLOperation)in_oExpression;
				oTCGOCLExpression = copyOperation(oOldOperation);
			}
			else if(in_oExpression instanceof TCGOCLIfThenElse)
			{
				TCGOCLIfThenElse oOldIfThenElse = (TCGOCLIfThenElse)in_oExpression;
				oTCGOCLExpression = copyIfThenElse(oOldIfThenElse);
			}
			oTCGOCLExpression.setClassification(in_oExpression.getClassification());
			oTCGOCLExpression.setOclReference(in_oExpression.getOclReference());
			oTCGOCLExpression.setPositiveAssignmentOfOriginal(in_oExpression.isPositiveAssignmentOfOriginal());
			oTCGOCLExpression.setTransitionContext(in_oExpression.getTransitionContext());
		}
		return oTCGOCLExpression;		
	}
	
	/**
	 * copies the TCGOCLExpression and updates a list of references
	 */
	public static Pair<TCGOCLExpression, List<TCGOCLAtom>> copyExpression(
			TCGOCLExpression in_oExpression,
			List<TCGOCLAtom> in_colReferences)
	{
		Pair<TCGOCLExpression, List<TCGOCLAtom>> oRetValue =
			new Pair<TCGOCLExpression, List<TCGOCLAtom>>(
					null, new ArrayList<TCGOCLAtom>());
		if(in_oExpression != null)
		{
			if(in_oExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oOldAtom = (TCGOCLAtom)in_oExpression;
				TCGOCLAtom oNewAtom = copyAtom(oOldAtom); 
				// update references
				if(in_colReferences.contains(in_oExpression)) {
					oRetValue.getSecond().add(oNewAtom);
				}
				oRetValue.setFirst(oNewAtom); 
			}
			else if(in_oExpression instanceof TCGOCLOperation)
			{
				TCGOCLOperation oOldOperation = (TCGOCLOperation)in_oExpression;
				TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oNewOperation.setOperation(oOldOperation.getOperation());
				oNewOperation.setOperationName(oOldOperation.getOperationName());
				oNewOperation.setTransitionContext(oOldOperation.getTransitionContext());
				Pair<TCGOCLExpression, List<TCGOCLAtom>> oFirstValue =
					copyExpression(oOldOperation.getLeft(), in_colReferences);
				oNewOperation.setLeft(oFirstValue.getFirst());
				Pair<TCGOCLExpression, List<TCGOCLAtom>> oSecondValue =
					copyExpression(oOldOperation.getRight(), in_colReferences);
				oNewOperation.setRight(oSecondValue.getFirst());

				oRetValue.setFirst(oNewOperation);
				oRetValue.getSecond().addAll(oFirstValue.getSecond());
				oRetValue.getSecond().addAll(oSecondValue.getSecond());
			}
			else if(in_oExpression instanceof TCGOCLIfThenElse)
			{
				TCGOCLIfThenElse oOldIfThenElse = (TCGOCLIfThenElse)in_oExpression;
				TCGOCLIfThenElse oNewIfThenElse = GeneratedFactory.eINSTANCE.createTCGOCLIfThenElse();
				oNewIfThenElse.setClassification(oOldIfThenElse.getClassification());
				oNewIfThenElse.setTransitionContext(oOldIfThenElse.getTransitionContext());
				Pair<TCGOCLExpression, List<TCGOCLAtom>> oFirstValue =
					copyExpression(oOldIfThenElse.getCondition(), in_colReferences);
				oNewIfThenElse.setCondition(oFirstValue.getFirst());
				Pair<TCGOCLExpression, List<TCGOCLAtom>> oSecondValue =
					copyExpression(oOldIfThenElse.getThenExpression(), in_colReferences);
				oNewIfThenElse.setThenExpression(oSecondValue.getFirst());
				Pair<TCGOCLExpression, List<TCGOCLAtom>> oThirdValue =
					copyExpression(oOldIfThenElse.getElseExpression(), in_colReferences);
				oNewIfThenElse.setElseExpression(oThirdValue.getFirst());
				
				oRetValue.setFirst(oNewIfThenElse);
				oRetValue.getSecond().addAll(oFirstValue.getSecond());
				oRetValue.getSecond().addAll(oSecondValue.getSecond());
				oRetValue.getSecond().addAll(oThirdValue.getSecond());
			}
			oRetValue.getFirst().setClassification(in_oExpression.getClassification());
			oRetValue.getFirst().setOclReference(in_oExpression.getOclReference());
			oRetValue.getFirst().setPositiveAssignmentOfOriginal(in_oExpression.isPositiveAssignmentOfOriginal());
			oRetValue.getFirst().setTransitionContext(in_oExpression.getTransitionContext());
		}
		

		return oRetValue;		
	}

	public static TCGOCLAtom copyAtom(TCGOCLAtom in_oAtom) {
		TCGOCLAtom oNewAtom = GeneratedFactory.eINSTANCE.createTCGOCLAtom();
		oNewAtom.setElement(in_oAtom.getElement());
		oNewAtom.setTcgParameter(in_oAtom.getTcgParameter());
		oNewAtom.setTransitionContext(in_oAtom.getTransitionContext());
		return oNewAtom;
	}
	
	public static TCGOCLOperation copyOperation(TCGOCLOperation in_oOperation) {
		TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
		oNewOperation.setOperation(in_oOperation.getOperation());
		oNewOperation.setOperationName(in_oOperation.getOperationName());
		oNewOperation.setTransitionContext(in_oOperation.getTransitionContext());
		oNewOperation.setLeft(copyExpression(in_oOperation.getLeft()));
		oNewOperation.setRight(copyExpression(in_oOperation.getRight()));
		return oNewOperation;
	}	

	public static TCGOCLIfThenElse copyIfThenElse(TCGOCLIfThenElse in_oIfThenElse) {
		TCGOCLIfThenElse oNewIfThenElse = GeneratedFactory.eINSTANCE.createTCGOCLIfThenElse();
		oNewIfThenElse.setClassification(in_oIfThenElse.getClassification());
		oNewIfThenElse.setTransitionContext(in_oIfThenElse.getTransitionContext());
		oNewIfThenElse.setCondition(copyExpression(in_oIfThenElse.getCondition()));
		oNewIfThenElse.setThenExpression(copyExpression(in_oIfThenElse.getThenExpression()));
		oNewIfThenElse.setElseExpression(copyExpression(in_oIfThenElse.getElseExpression()));
		return oNewIfThenElse;
	}
	
	/*
	 * examines the conditions in the conjunction and searches for contradictions
	 */
	public static ArrayList<TCGOCLExpression> 
	conditionsAreContradicting(TCGOCLExpression in_oExpression,
			HashMap<EObject, ValueTypeRange> io_colElementToValueRange,
			HashMap<EObject, ArrayList<TCGOCLExpression>> io_colElementToExpressions)
	{
		ArrayList<TCGOCLExpression> colContradictingExpressions = 
			new ArrayList<TCGOCLExpression>();
		TCGOCLVariableClassificator oClassificator = 
			new TCGOCLVariableClassificator(in_oExpression);
		TCGOCLAtom oInterestingElement = null;
		EObject oReferredObject = null;
		ValueTypeRange oActualValueRange = null;
		
		// current expression is an operation
		if(in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOperationExp = (TCGOCLOperation)in_oExpression;
			// first check that the expression has no dependent elements
			if((oClassificator.getNumberOfDependentVariables() == 0) && 
					(oClassificator.getNumberOfInputParameter() == 0)) {
				ValueTypeRange oExpressionRange =
					OCLExpressionValueTypeRangeFactory.
					getValueTypeRangeForRightSideOfExpression(
							oOperationExp);
				if(oExpressionRange == null) {
					TCGOCLExpressionHelperClass.
						getDependentVariableOrInputParameter(in_oExpression);
				}
				else if(oExpressionRange.isEmpty())
				{
					colContradictingExpressions.add(oOperationExp);
					return colContradictingExpressions;
				}
			}
			else {
				// TODO #### Widersprüche auch für Eingabeparameter aufdecken
				// step 1: hashmap von Variablen auf ValueRanges bauen -> immer erweitern bis zum Widerspruch
				if((oClassificator.getNumberOfDependentVariables() + 
						oClassificator.getNumberOfInputParameter() == 1)) {
					oInterestingElement =
						getDependentVariablesAndInputParameters(oClassificator).get(0);
					oReferredObject = 
						getReferencedElement(oInterestingElement);
					oClassificator.shiftSubexpressionToTheLeft(oInterestingElement);
					oActualValueRange = 
						OCLExpressionValueTypeRangeFactory.
						getValueTypeRangeForRightSideOfExpression(
								oOperationExp);
				}
				else {
					// Widersprüce für mehr als einen Eingabeparameter?
				}
			}
		}
		else { // in_oExpression instanceof TCGOCLAtom
			oInterestingElement = (TCGOCLAtom)in_oExpression;
			oReferredObject = 
				getReferencedElement(oInterestingElement);
			oActualValueRange = 
				OCLExpressionValueTypeRangeFactory.
				getValueTypeRangeForRightSideOfExpression(
						in_oExpression);
		}
		
		// now compare to the already saved value ranges from last elements 
		if(oInterestingElement != null) {
			ValueTypeRange oSavedValueRange = io_colElementToValueRange
				.get(oReferredObject);
			ArrayList<TCGOCLExpression> colAssociatedExpressions = 
				io_colElementToExpressions.get(oReferredObject);
//			Parameter oReferencedParameter = null;
//			if(oReferredObject instanceof Variable) {
//				oReferencedParameter = ((Variable)oReferredObject).getRepresentedParameter();
//			}
//			List<Parameter> colParameter = TCGEventHelperClass.
//				getEventParameters(oReferencedParameter, 
//					oInterestingElement.getTransitionContext());
			// TODO : ### hier Transition in conditionsAreContradicting
//			Verdammt - Woher bekomme ich die Transition?
//					Was jetzt noch fehlt:
//						1) Hier die korrekte Zuordnung der Parameter
//						2) die Zuweisung der Transition an die Expression bei deren Erzeugung
//					Sind Expressions nur noch transitionsabhängig vergleichbar?
//					Sollte jede Expression jetzt eine Referenz auf die originale Transition
//					speichern?
			if(colAssociatedExpressions == null)
			{
				colAssociatedExpressions = new ArrayList<TCGOCLExpression>();
				io_colElementToExpressions.put(oReferredObject,
						colAssociatedExpressions);
			}
			colAssociatedExpressions.add(in_oExpression);
			
			if(oSavedValueRange == null)
				io_colElementToValueRange.put(oReferredObject, oActualValueRange);
			else
			{
				if(!oSavedValueRange.adaptRange(oActualValueRange))
				{
					// return the list of all expressions that are conflicting
					return io_colElementToExpressions.get(oReferredObject);
				}
			}
		}
		return colContradictingExpressions;
	}

	/*
	 * returns the one parameter that could be the "target" of an expression: dependent variable or input parameter
	 */
	public static List<TCGOCLAtom> getDependentVariablesAndInputParameters(
			TCGOCLVariableClassificator in_oClassificator) {
		List<TCGOCLAtom> colInterestingElements = new ArrayList<TCGOCLAtom>(); 
		colInterestingElements.addAll(in_oClassificator.
			getClassifiedElementsInExpression(VariableClassification.ACTIVE_DEPENDENT));
		colInterestingElements.addAll(in_oClassificator.
			getClassifiedElementsInExpression(VariableClassification.PASSIVE_DEPENDENT));
		colInterestingElements.addAll(in_oClassificator.
			getClassifiedElementsInExpression(VariableClassification.INPUT_PARAMETER));
		return colInterestingElements;
	}

	/*
	 * returns the one parameter that could be the "target" of an expression: dependent variable or input parameter
	 */
	public static List<TCGOCLAtom> getDependentVariableOrInputParameter(
			TCGOCLExpression in_oExpression) {
		TCGOCLVariableClassificator oClassificator = 
			new TCGOCLVariableClassificator(in_oExpression);
		return getDependentVariablesAndInputParameters(oClassificator);
	}
	
	public static List<TCGOCLAtom> getPassiveDependentVariablesAndInputParameters(
			TCGOCLExpression in_oExpression) {
		List<TCGOCLAtom> colRetValues = new ArrayList<TCGOCLAtom>();
		
		TCGOCLVariableClassificator oClassificator = 
			new TCGOCLVariableClassificator(in_oExpression);
		
		colRetValues.addAll(oClassificator.
				getClassifiedElementsInExpression(VariableClassification.PASSIVE_DEPENDENT));
		colRetValues.addAll(oClassificator.
				getClassifiedElementsInExpression(VariableClassification.INPUT_PARAMETER));
		return colRetValues;
	}

//	public static List<TCGOCLAtom> getDependentVariablesAndInputParameters(
//			TCGOCLExpression in_oExpression) {
//		List<TCGOCLAtom> colRetValues = new ArrayList<TCGOCLAtom>();
//		
//		TCGOCLVariableClassificator oClassificator = 
//			new TCGOCLVariableClassificator(in_oExpression);
//		
//		colRetValues.addAll(oClassificator.
//			getClassifiedElementsInExpression(VariableClassification.ACTIVE_DEPENDENT));
//		colRetValues.addAll(oClassificator.
//				getClassifiedElementsInExpression(VariableClassification.PASSIVE_DEPENDENT));
//		colRetValues.addAll(oClassificator.
//				getClassifiedElementsInExpression(VariableClassification.INPUT_PARAMETER));
//		return colRetValues;
//	}
	
	public static boolean expressionIsIsolatedOnLeftSide(
			TCGOCLExpression in_oOCLExp,
			TCGOCLExpression in_oSurroundingExp)
	{
		// TODO bisher ohne boolesche Ausdrücke betrachtet
		TCGOCLExpression oSurroundingExp = in_oSurroundingExp;
		
		// ignore all "not"s
		while(oSurroundingExp instanceof TCGOCLOperation && 
				((TCGOCLOperation)oSurroundingExp).getOperationName() != null &&
				((TCGOCLOperation)oSurroundingExp).getOperationName().equals("not")) {
			if(((TCGOCLOperation)oSurroundingExp).getLeft() == null)
				oSurroundingExp = ((TCGOCLOperation)oSurroundingExp).getRight();
			else
				oSurroundingExp = ((TCGOCLOperation)oSurroundingExp).getLeft();
		}
		
		if(oSurroundingExp instanceof TCGOCLOperation)
		{
			if(((TCGOCLOperation)oSurroundingExp).getLeft() == null)
				return false;
			//else if(((TCGOCLOperation)oSurroundingExp).getLeft().equals(in_oOCLExp))
			if(expressionsAreEqual(((TCGOCLOperation)oSurroundingExp).getLeft(), in_oOCLExp)) {
				return true;
			}
			else
				return false;
		}
		else if(oSurroundingExp instanceof TCGOCLAtom)
			return true;
		
		return false;
	}	
	
	

	
	public static boolean exchangeSidesOfExpression(TCGOCLOperation in_oOpExp)
	{
		// relational operation
		if(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()) != null) {
			TCGOCLExpression o1 = in_oOpExp.getLeft();
			in_oOpExp.setLeft(in_oOpExp.getRight());
			in_oOpExp.setRight(o1);
			in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()));
			return true;
		}
		else if(in_oOpExp.getOperationName().equals("*") ||
				in_oOpExp.getOperationName().equals("+") ||
				in_oOpExp.getOperationName().equals("-")) {
			TCGOCLExpression o1 = in_oOpExp.getLeft();
			in_oOpExp.setLeft(in_oOpExp.getRight());
			in_oOpExp.setRight(o1);
			if(in_oOpExp.getOperationName().equals("-")) {
				in_oOpExp.setOperationName(sm_colCorrespondingOperations.get(in_oOpExp.getOperationName()));
				in_oOpExp.setLeft(negateArithmeticalTCGOCLExpression(
						in_oOpExp.getLeft()));
			}
			return true;
		}
		// TODO what about "/" ?
		// cannot change the expression sides
		return false;
	}
	
	
	public static TCGOCLExpression removeUnaryMinus(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;
			// unary minus
			if(isUnaryMinus(oOpExp)) {
				TCGOCLExpression oLeftOrRightExp = 
					TCGOCLExpressionHelperClass.getNonNullLeftOrRight(oOpExp);
				if(!(oLeftOrRightExp instanceof TCGOCLAtom)) {
					return TCGOCLExpressionHelperClass.
						negateArithmeticalTCGOCLExpression(oLeftOrRightExp);
				}
				// if it is an atom then leave it unchanged
			}
			else {
				// special case: operation is "-" and the right side 
				// is an unary minus (no matter if an atom is negated)
				if((oOpExp.getOperationName().equals("-") || 
						oOpExp.getOperationName().equals("+")) &&
						isUnaryMinus(oOpExp.getRight())) {
					oOpExp.setOperationName(sm_colCorrespondingOperations.get(oOpExp.getOperationName()));
					oOpExp.setRight(getNonNullLeftOrRight(
							(TCGOCLOperation)oOpExp.getRight()));
				}
				oOpExp.setLeft(removeUnaryMinus(oOpExp.getLeft()));
				oOpExp.setRight(removeUnaryMinus(oOpExp.getRight()));
			}
		}
		return in_oExpression;
	}
	
	public static boolean isUnaryMinus(TCGOCLExpression in_oExpression) {
		if(in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			return oOperation.getOperationName().equals("-") &&
				(oOperation.getLeft() == null || oOperation.getRight() == null);
		}
		return false;
	}
	
	public static void transferLeftNonVariableToRightSide(
			TCGOCLOperation in_oOpExp, 
			TCGOCLExpression in_oVariable)
	{
		// deal with "not": assign negated expression to left side
		if(in_oOpExp.getOperationName() != null &&
				in_oOpExp.getOperationName().equals("not")) {
			if(in_oOpExp.getLeft() == null) {
				in_oOpExp.setLeft(in_oOpExp.getRight());
				in_oOpExp.setRight(null);
			}
			return;
		}
		
		// remove unary minus in the expression
		removeUnaryMinus(in_oOpExp);
		
		if(in_oOpExp.getLeft() instanceof TCGOCLOperation) {
			// negierte Variable 
			if(isUnaryMinus(in_oOpExp.getLeft())) {
				in_oOpExp.setLeft(
						negateArithmeticalTCGOCLExpression(in_oOpExp.getLeft()));
				in_oOpExp.setOperationName(
						sm_colCorrespondingRelations.get(
								in_oOpExp.getOperationName()));
				in_oOpExp.setRight(
						negateArithmeticalTCGOCLExpression(in_oOpExp.getRight()));
			}
			else {
				TCGOCLOperation oOpLeftExp = (TCGOCLOperation)in_oOpExp.getLeft();
				OCLTreeExpressionFindObjectVisitor oVisitor = 
					new OCLTreeExpressionFindObjectVisitor(in_oVariable);
				OCLTreeExpressionIterator.run(oOpLeftExp.getLeft(), oVisitor);
				// try to shift the variable to the left side of the left expression
				// variable is on local right side of the left expression 
				// -> exchange on left hand side left and right
				if(!oVisitor.isFound()) {
					// exchange sides
					TCGOCLExpression oLeftSide = oOpLeftExp.getLeft();
					oOpLeftExp.setLeft(oOpLeftExp.getRight());
					oOpLeftExp.setRight(oLeftSide);
					
					// influence relation operator correspondingly
					if(oOpLeftExp.getOperationName().equals("+") || 
							oOpLeftExp.getOperationName().equals("*")) {
						// nothing - written just for completeness
					}
					else if(oOpLeftExp.getOperationName().equals("-")) {
						in_oOpExp.setOperationName(
								sm_colCorrespondingRelations.get(
										in_oOpExp.getOperationName()));
						in_oOpExp.setRight(
								TCGOCLExpressionHelperClass.negateArithmeticalTCGOCLExpression(
										in_oOpExp.getRight()));
					}
					else if(oOpLeftExp.getOperationName().equals("/"))
					{
						// TODO #### Fallunterscheidung einbauen und evtl. mehrere mögliche
						// Ausdrücke zurückgeben
					}
					// check again
					OCLTreeExpressionIterator.run(oOpLeftExp.getLeft(), oVisitor);
				}
				
				// not "else" -> value is computed again at the last statement
				
				// variable is on local left side of the left expression
				// -> transfer local right side of left expression to the right expression
				if(oVisitor.isFound()) {
					TCGOCLExpression oLeftSide = oOpLeftExp.getLeft();
					oOpLeftExp.setLeft(in_oOpExp.getRight());
					in_oOpExp.setRight(oOpLeftExp);
					in_oOpExp.setLeft(oLeftSide);
					// exclude the case that we work with an unary minus or a not
					if(!(oOpLeftExp.getRight() == null &&
						(oOpLeftExp.getOperationName().equals("-") ||
						oOpLeftExp.getOperationName().equals("not")))) {
						
						oOpLeftExp.setOperationName(sm_colCorrespondingOperations.get(
								oOpLeftExp.getOperationName()));
						// multiplication or division with a negative number?
						if((oOpLeftExp.getOperationName().compareTo("*") == 0) || 
							(oOpLeftExp.getOperationName().compareTo("/") == 0)) {
							// moved expression was negative
							if(expressionIsNegative(oOpLeftExp.getRight()))
							{
								// exchange relation symbol
								in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()));
							}
						}
					}
					else {
	//					in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(
	//							in_oOpExp.getOperationName()));
						negateLogicalTCGOCLExpression(in_oOpExp);
					}
				}
				// variable is on right side
				else
				{
					// TODO #### Problem: Wenn durch Variable geteilt wird, dann wird Fallunterscheidung notwendig
					// (aus 1/x<5 folgt (x > 1/5 oder x < 0))
				}
			}
		}
		else {
			exchangeSidesOfExpression(in_oOpExp);
		}
		// clean up -> remove unnecessary minus
		removeUnaryMinus(in_oOpExp);
	}
	
	
	public static void shiftSubexpressionToTheLeft(
			TCGOCLExpression in_oShiftedExpression,
			TCGOCLExpression in_oSurroundingExpression)
	{
		if(in_oShiftedExpression != null) {
			// TODO boolesche Verknüpfungen noch beachten
			TCGOCLExpression oExp = in_oSurroundingExpression;
			while(oExp instanceof TCGOCLOperation && ((TCGOCLOperation)oExp).getOperationName().equals("not")) {
				if(((TCGOCLOperation)oExp).getLeft() == null)
					oExp = ((TCGOCLOperation)oExp).getRight();
				else
					oExp = ((TCGOCLOperation)oExp).getLeft();
			}
	
			if(oExp instanceof TCGOCLOperation)
			{
				TCGOCLOperation oOpExp = (TCGOCLOperation)oExp;
				if(oOpExp.getLeft() != null)
				{
					// first step: get variable on the left side
					OCLTreeExpressionFindObjectVisitor oVisitor = 
						new OCLTreeExpressionFindObjectVisitor(in_oShiftedExpression);
					OCLTreeExpressionIterator.run(oOpExp.getLeft(), oVisitor);
					// variable was not found on the left-hand side -> exchange both sides of the expression
					if(!oVisitor.isFound())
					{
						exchangeSidesOfExpression(oOpExp);
					}
					
					// variable is now on the left side -> now handle all mathematical expressions to isolate variable
					while(!expressionIsIsolatedOnLeftSide(
							in_oShiftedExpression, in_oSurroundingExpression))
					{
						transferLeftNonVariableToRightSide(oOpExp, in_oShiftedExpression);
					}
				}
			}
		}
	}
	
	
	private static boolean expressionIsNegative(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;
			if((oOpExp.getLeft() == null || oOpExp.getRight() == null) && 
					(((Operation)oOpExp.getOperation()).getName().compareTo("-") == 0))
			{
				return true;
			}
		}
		// TODO ausrechnen ob in_oExpression einen negativen Wert darstellt
		return false;
	}

	public static boolean expressionsAreEqual(
			TCGOCLExpression in_oCheckedExpression,
			TCGOCLExpression in_oWarrantedExpression) {

		if(in_oCheckedExpression == null && in_oWarrantedExpression == null) {
			return true;
		}
		
		if (in_oCheckedExpression instanceof TCGOCLAtom &&
				in_oWarrantedExpression instanceof TCGOCLAtom) {
			if(expressionsContainReferenceToTheSameObject(
					(TCGOCLAtom)in_oCheckedExpression, (TCGOCLAtom)in_oWarrantedExpression)) {
//			if(((TCGOCLAtom)in_oCheckedExpression).getElement().equals(
//				((TCGOCLAtom)in_oWarrantedExpression).getElement())) {
					return true;
			}
			else {
				return false;
			}
		}
		else if (in_oCheckedExpression instanceof TCGOCLOperation &&
				in_oWarrantedExpression instanceof TCGOCLOperation) {
			
			TCGOCLOperation oCheckedOperation = (TCGOCLOperation)in_oCheckedExpression;
			TCGOCLOperation oWarrantedOperation = (TCGOCLOperation)in_oWarrantedExpression;
			
			if(!oCheckedOperation.getOperationName().equals(
					oWarrantedOperation.getOperationName())) {
				return false;
			}
			if(!expressionsAreEqual(oCheckedOperation.getLeft(), oWarrantedOperation.getLeft())) {
				return false;
			}
			if(!expressionsAreEqual(oCheckedOperation.getRight(), oWarrantedOperation.getRight())) {
				return false;
			}
			return true;
		}
		return false;
	}

	
	public static Collection<TCGOCLExpression> getContradictingDynamicExpressions(
			List<TCGOCLExpression> colDynamicExpressions) {
		// assume that expressions are condensed so that the comparison
		// of wo expressions is enough to get all contradictions
		Collection<TCGOCLExpression> colRetValues = 
			new ArrayList<TCGOCLExpression>();
		
		for(int i = 0; i < colDynamicExpressions.size(); ++i) {
			for(int j = i+1; j < colDynamicExpressions.size(); ++j) {
				TCGOCLExpression oFirstExpression = colDynamicExpressions.get(i);
				TCGOCLExpression oSecondExpression = colDynamicExpressions.get(j);
				
				List<TCGOCLAtom> colFirstAtoms =
					getPassiveDependentVariablesAndInputParameters(oFirstExpression);
				List<TCGOCLAtom> colSecondAtoms =
					getPassiveDependentVariablesAndInputParameters(oSecondExpression);
				
				// only consider the intersection of both atom lists
				for(TCGOCLAtom oFirstAtom : colFirstAtoms) {
					for(TCGOCLAtom oSecondAtom : colSecondAtoms) {
						if(oFirstAtom.getElement().equals(oSecondAtom.getElement())) {
							shiftSubexpressionToTheLeft(oFirstAtom, oFirstExpression);
							shiftSubexpressionToTheLeft(oSecondAtom, oSecondExpression);
							if(rightSidesOfExpressionsAreContradicting(
									oFirstExpression, oSecondExpression)) {
								colRetValues.add(oFirstExpression);
								colRetValues.add(oSecondExpression);
								return colRetValues;
							}
						}
					}
				}
			}			
		}
		
		return colRetValues;
	}

	private static boolean rightSidesOfExpressionsAreContradicting(
			TCGOCLExpression in_oFirstExpression, 
			TCGOCLExpression in_oSecondExpression) {
		
		// TODO ganz schön schwer ...
		
		// einfachster Fall: beide Seiten sind gleich, aber die Relationszeichen
		// sind widersprüchlich - reicht für Testziele
		if(in_oFirstExpression instanceof TCGOCLOperation &&
				in_oSecondExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oFirstOp = (TCGOCLOperation)in_oFirstExpression; 
			TCGOCLOperation oSecondOp = (TCGOCLOperation)in_oSecondExpression;
			
			if(expressionsAreEqual(oFirstOp.getRight(), oSecondOp.getRight()) &&
					operationNamesAreContradicting(oFirstOp.getOperationName(),
							oSecondOp.getOperationName())) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean operationNamesAreContradicting(
			String operationName,
			String operationName2) {
		if((operationName.equals("<") && operationName2.equals("=")) ||
			(operationName.equals("<") && operationName2.equals(">=")) ||
			(operationName.equals("<") && operationName2.equals(">")) ||
			(operationName.equals("<=") && operationName2.equals(">")) ||
			(operationName.equals("=") && operationName2.equals("<")) ||
			(operationName.equals("=") && operationName2.equals(">")) ||
			(operationName.equals(">=") && operationName2.equals("<")) ||
			(operationName.equals(">") && operationName2.equals("<")) ||
			(operationName.equals(">") && operationName2.equals("<=")) ||
			(operationName.equals(">") && operationName2.equals("="))) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * returns a valid value type range for the given event parameter instance
	 * @param in_oEPInstance: event parameter instance to find a value type range for
	 * @param in_colExpressions: all expressions to use for value derivation
	 * @param in_colEPIToAtom: ### Reicht das aus?
	 * @param in_colCurrentValueAssignment: already assigned values
	 * @return
	 */
	public static ValueTypeRange getValueTypeRangeForEventParameterInstance(
			List<TCGOCLAtom> in_oAtom,
			List<TCGOCLExpression> in_colExpressions,
			Map<TCGOCLAtom, ValueTypeRange> in_colAtomToVTR,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			List<TCGOCLExpression> in_colAlreadyEvaluatedExpressions) {
		
		ValueTypeRange oGlobalVTR = null;
		boolean bResult = true;
		
		//ATOM: for(TCGOCLAtom oAtom : in_oAtom) {
		if(!in_oAtom.isEmpty()) {
			TCGOCLAtom oAtom = in_oAtom.get(0);
			
			if(oGlobalVTR == null) {
				oGlobalVTR = ValueTypeRangeFactory.createValueTypeRangeForObject(oAtom);
			}
			//hier statt eines übergebenen atoms eine Liste "gleicher" Atome überprüfen???
			
			// get value type range
			ValueTypeRange oVTR = in_colAtomToVTR.get(oAtom);
			if(oVTR != null) 
				oVTR = oVTR.clone();
			else 
				oVTR = ValueTypeRangeFactory.createValueTypeRangeForObject(oAtom);
			
			
			// TODO Typ von in_colCurrentValueAssignment ändern auf Map<EObject,TestCaseValidValue>
			// if there is a value assignment for the given atom
			for(TCGOCLAtom oAtomWithAssignedValue : in_colCurrentValueAssignment.keySet()) {
				if(oAtomWithAssignedValue.getElement().equals(oAtom.getElement())) {
					// adapt value type range
					bResult = bResult &&
						oVTR.adaptRange(in_colCurrentValueAssignment.get(oAtomWithAssignedValue).getValue());
					bResult = bResult &&
						oGlobalVTR.adaptRange(oVTR);
					if(!bResult)
						return new IndefinableValueTypeRange();
//						break ATOM;

//					continue ATOM;
				}
			}
			
			// keep track of all the expressions still to evaluate ...
			List<TCGOCLExpression> colTmpExpressionsCopy = new ArrayList<TCGOCLExpression>();
			colTmpExpressionsCopy.addAll(in_colExpressions);
			
			for(TCGOCLExpression oExpression : in_colExpressions) {
				
				OCLTreeExpressionFindAtomReferenceVisitor oVisitor =
					//new OCLTreeExpressionFindAtomReferenceVisitor(in_oAtom);
					new OCLTreeExpressionFindAtomReferenceVisitor(oAtom);
				OCLTreeExpressionIterator.run(oExpression, oVisitor);
				// oExpression contains oAtom
				if(oVisitor.isFound()) {
					for(TCGOCLAtom oInterestingAtom : oVisitor.getFoundAtoms()) {
						if(oExpression instanceof TCGOCLAtom) {
							ValueTypeRange oTmpVTR = OCLExpressionValueTypeRangeFactory.
								getValueTypeRangeForRightSideOfExpression(
									oInterestingAtom, oExpression);
							if(oVTR == null)
								oVTR = oTmpVTR;
							else {
								if(!oVTR.adaptRange(oTmpVTR)) {
//									bResult = false;
									return new IndefinableValueTypeRange();
//									break ATOM;
								}
							}
						}
						else if(oExpression instanceof TCGOCLOperation) {
							TCGOCLOperation oOperation = (TCGOCLOperation)oExpression;
							// shift atom to the left
							shiftSubexpressionToTheLeft(oInterestingAtom, oOperation);
							// now investigate the right side of the expression
							// combine with other expressions of the list
							colTmpExpressionsCopy.remove(oOperation);
							
							Map<TCGOCLAtom, ValueTypeRange> colTemporaryAtomToVTR
								= new LinkedHashMap<TCGOCLAtom, ValueTypeRange>();
							colTemporaryAtomToVTR.putAll(in_colAtomToVTR);
							colTemporaryAtomToVTR.remove(oAtom);
							//colTemporaryAtomToVTR.remove(in_oAtom);
							// colTemporaryEPIToAtoms contains all remaining epi to atoms
		
							Map<TCGOCLAtom, ValueTypeRange> colAtomToVTR =
								new LinkedHashMap<TCGOCLAtom, ValueTypeRange>();
							// restart the evaluation for each ATOM of the right side
							OCLTreeTCGOCLAtomCollectorVisitor oAtomCollector =
								new OCLTreeTCGOCLAtomCollectorVisitor();
							OCLTreeExpressionIterator.run(oOperation.getRight(), oAtomCollector);
							for(TCGOCLAtom oExpAtom : oAtomCollector.getExpressions()) {
								// check only atoms that reference variables or properties
								if(oExpAtom.getElement() instanceof Variable ||
										oExpAtom.getElement() instanceof Property) {
									List<TCGOCLAtom> colExpAtoms = new ArrayList<TCGOCLAtom>();
									colExpAtoms.add(oExpAtom);
									ValueTypeRange oTmpVTR = 
										getValueTypeRangeForEventParameterInstance(
												colExpAtoms, colTmpExpressionsCopy, colTemporaryAtomToVTR,
												in_colCurrentValueAssignment, in_colAlreadyEvaluatedExpressions);
									if(oTmpVTR instanceof IndefinableValueTypeRange) {
										return new IndefinableValueTypeRange();
		//									bResult = false;
		//									break ATOM;
									}
									colAtomToVTR.put(oExpAtom, oTmpVTR);
								}
							}
							
							// evaluate expressions with the help of value type ranges
							ValueTypeRange oTmpVTR = ValueTypeRangeFactory.createValueTypeRangeForObject(oInterestingAtom);
		
							oTmpVTR = OCLExpressionValueTypeRangeFactory.
								getValueTypeRangeForRightSideOfExpression(
									oTmpVTR, oOperation, 
									in_colCurrentValueAssignment, colAtomToVTR);
							if(oVTR == null)
								oVTR = oTmpVTR;
							else {
								if(!oVTR.adaptRange(oTmpVTR)) {
									return new IndefinableValueTypeRange();
//									bResult = false;
//									break ATOM;
								}
							}
							
							oVTR.adaptRangeToStaticConstraints();
							
							// combine other expressions with this expression?
							// no -> because of the differences between elements
							// instead: find value type ranges for other elements
							// - evaluate the expression using value type ranges
								
							
							// derive value type ranges
							// adapt the returned value type ranges depending
							// on the relational symbol
							
							colTmpExpressionsCopy.add(oOperation);
						}
					}
				}
			}
			
			// for each expression:
			//if(expression contains atom in_colEPIToAtom.get(in_oEPI)
			// expression: atom auf linke Seite holen
			// für alle dependent elemente auf der rechten Seite: 
			// Wertebestimmung ohne die bereits genutzten Ausdrücke
			// in Abhängigkeit von dem Relationszeichen die
			
			//return oVTR;
			if(!oGlobalVTR.adaptRange(oVTR)) {
				return new IndefinableValueTypeRange();
//				bResult = false;
//				break ATOM;
			}
		}
		
		if(!bResult) {
			oGlobalVTR = new IndefinableValueTypeRange();
		}
		
		return oGlobalVTR;
	}
	
//	/**
//	 * returns a valid value type range for the given event parameter instance
//	 * @param in_oEPInstance: event parameter instance to find a value type range for
//	 * @param in_colExpressions: all expressions to use for value derivation
//	 * @param in_colEPIToAtom: ### Reicht das aus?
//	 * @param in_colCurrentValueAssignment: already assigned values
//	 * @return
//	 */
//	public static ValueTypeRange getValueTypeRangeForEventParameterInstance(
//			EventParameterInstance in_oEPI,
//			List<TCGOCLExpression> in_colExpressions,
//			Map<EventParameterInstance, TCGOCLAtom> in_colEPIToAtom,
//			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) {
//		
//		
//		ValueTypeRange oVTR = in_oEPI.getValueRange().clone();
//		TCGOCLAtom oInterestingAtom = in_colEPIToAtom.get(in_oEPI);
//		TestCaseValidValue oTestValue = in_colCurrentValueAssignment.get(oInterestingAtom);
//		if(oTestValue != null) {
//			// adapt value type range
//			oVTR.adaptRange(oTestValue.getValue());
//			return oVTR;
//		}
//		
//		List<TCGOCLExpression> colTmpExpressionsCopy =
//			new ArrayList<TCGOCLExpression>();
//		colTmpExpressionsCopy.addAll(in_colExpressions);
//		
//		int nMaxRepetition = in_colExpressions.size();
//		boolean bFoundExpressionForValidation = true;
//		while(bFoundExpressionForValidation && nMaxRepetition > 0) {
//			bFoundExpressionForValidation = false;
//			--nMaxRepetition;
//			
//			for(TCGOCLExpression oExpression : in_colExpressions) {
//				OCLTreeExpressionFindAtomReferenceVisitor oVisitor =
//					new OCLTreeExpressionFindAtomReferenceVisitor(oInterestingAtom);
//				OCLTreeExpressionIterator.run(oExpression, oVisitor);
//				// oExpression contains oAtom
//				if(oVisitor.isFound()) {
//					oInterestingAtom = oVisitor.getFoundAtom();
//					bFoundExpressionForValidation = true;
//					if(oExpression instanceof TCGOCLAtom) {
//						ValueTypeRange oTmpVTR = OCLExpressionValueTypeRangeFactory.
//							getValueTypeRangeForRightSideOfExpression(
//								oInterestingAtom, oExpression);
//						if(oVTR == null)
//							oVTR = oTmpVTR;
//						else
//							oVTR.adaptRange(oTmpVTR);
//					}
//					else {
//						// shift atom to the left
//						shiftSubexpressionToTheLeft(oInterestingAtom, oExpression);
//						// now investigate the right side of the expression
//						// combine with other expressions of the list
//						colTmpExpressionsCopy.remove(oExpression);
//						
////						Map<EventParameterInstance, TCGOCLAtom> colTemporaryEPIToAtoms
////							= getParameterInstancesReferencingAtomsFromExpression(
////									oExpression, in_colEPIToAtom);
//						Map<EventParameterInstance, TCGOCLAtom> colTemporaryEPIToAtoms
//							= new LinkedHashMap<EventParameterInstance, TCGOCLAtom>();
//						colTemporaryEPIToAtoms.putAll(in_colEPIToAtom);
//						colTemporaryEPIToAtoms.remove(in_oEPI);
//						// colTemporaryEPIToAtoms contains all remaining epi to atoms
//	
//						Map<TCGOCLAtom, ValueTypeRange> colAtomToVTR =
//							new LinkedHashMap<TCGOCLAtom, ValueTypeRange>();
//						// restart the evaluation for each remaining EPI and all remaining expressions
//						for(EventParameterInstance oEPI : colTemporaryEPIToAtoms.keySet()) {
//							ValueTypeRange oTmpVTR = 
//								getValueTypeRangeForEventParameterInstance(
//										oEPI, colTmpExpressionsCopy, colTemporaryEPIToAtoms,
//										in_colCurrentValueAssignment);
//							colAtomToVTR.put(in_colEPIToAtom.get(oEPI), oTmpVTR);
//						}
//						
//						// evaluate expressions with the help of value type ranges
//						ValueTypeRange oTmpVTR = ValueTypeRangeFactory.createValueTypeRangeForObject(oInterestingAtom);
//	
//						oTmpVTR = OCLExpressionValueTypeRangeFactory.
//							getValueTypeRangeForRightSideOfExpression(
//								oTmpVTR, oExpression, 
//								in_colCurrentValueAssignment, colAtomToVTR);
//						if(oVTR == null)
//							oVTR = oTmpVTR;
//						else
//							oVTR.adaptRange(oTmpVTR);
//						
//						oVTR.adaptRangeToStaticConstraints();
//						
//						// combine other expressions with this expression?
//						// no -> because of the differences between elements
//						// instead: find value type ranges for other elements
//						// - evaluate the expression using value type ranges
//							
//						
//						// derive value type ranges
//						// adapt the returned value type ranges depending
//						// on the relational symbol
//						
//						colTmpExpressionsCopy.add(oExpression);
//					}
//				}
//			}
//		}
//		
//		// for each expression:
//		//if(expression contains atom in_colEPIToAtom.get(in_oEPI)
//		// expression: atom auf linke Seite holen
//		// für alle dependent elemente auf der rechten Seite: 
//		// Wertebestimmung ohne die bereits genutzten Ausdrücke
//		// in Abhängigkeit von dem Relationszeichen die
//		
//		return oVTR;
//	}


	private static Map<EventParameterInstance, TCGOCLAtom> 
		getParameterInstancesReferencingAtomsFromExpression(
			TCGOCLExpression in_oExpression,
			Map<EventParameterInstance, TCGOCLAtom> in_colEPIToAtom) {
		
		Map<EventParameterInstance, TCGOCLAtom> colRetValues =
			new LinkedHashMap<EventParameterInstance, TCGOCLAtom>();
		
		OCLTreeTCGOCLAtomCollectorVisitor oVisitor =
			new OCLTreeTCGOCLAtomCollectorVisitor();
		OCLTreeExpressionIterator.run(in_oExpression, oVisitor);
		
		for(Entry<EventParameterInstance, TCGOCLAtom> oEntry : in_colEPIToAtom.entrySet()) {
			// TODO: explizite Referenzen zwischen Atoms zueinander zugehöriger
			// Expressions aufbauen oder DIESELBEN Atoms verwenden
			// sonst gibt es Probleme, wenn derselbe Parameter mehrfach verwendet wird
			//if(oVisitor.getExpressions().contains(oEntry.getValue())) {
			
			for(TCGOCLAtom oAtom : oVisitor.getExpressions()) {
				if(oAtom.getElement().equals(oEntry.getValue().getElement())) {
					colRetValues.put(oEntry.getKey(), oEntry.getValue());
				}
			}
		}
		
		return colRetValues;
	}

	public static boolean expressionsContainTheSameAtoms(
			TCGOCLExpression in_oCheckedExpression,
			TCGOCLExpression in_oWarrantedExpression) {
		OCLTreeTCGOCLAtomCollectorVisitor oFirstCollector =
			new OCLTreeTCGOCLAtomCollectorVisitor();
		OCLTreeTCGOCLAtomCollectorVisitor oSecondCollector =
			new OCLTreeTCGOCLAtomCollectorVisitor();
		OCLTreeExpressionIterator.run(in_oCheckedExpression, oFirstCollector);
		OCLTreeExpressionIterator.run(in_oWarrantedExpression, oSecondCollector);
		if(oFirstCollector.getExpressions().size() != oSecondCollector.getExpressions().size()) {
			return false;
		}
		List<TCGOCLAtom> colAlreadyMatchedSecondAtoms = 
			new ArrayList<TCGOCLAtom>();
		for(TCGOCLAtom oFirstAtom : oFirstCollector.getExpressions()) {
			boolean bFound = false;
			for(TCGOCLAtom oSecondAtom : oSecondCollector.getExpressions()) {
				if(expressionsContainReferenceToTheSameObject(
						oFirstAtom, oSecondAtom) &&
//				if(oFirstAtom.getElement().equals(oSecondAtom.getElement()) &&
						!colAlreadyMatchedSecondAtoms.contains(oSecondAtom)) {
					bFound = true;
					colAlreadyMatchedSecondAtoms.add(oSecondAtom);
					break;
				}
			}
			if(bFound == false)
				return false;
		}
		return true;
	}

	public static boolean expressionsCanBeTransformedIntoEachOther(
			TCGOCLExpression in_oCheckedExpression,
			TCGOCLExpression in_oWarrantedExpression) {
		// compare atoms
		if(in_oCheckedExpression instanceof TCGOCLAtom &&
				in_oWarrantedExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oCheckedAtom = (TCGOCLAtom)in_oCheckedExpression;
			TCGOCLAtom oWarrantedAtom = (TCGOCLAtom)in_oWarrantedExpression;
			return oCheckedAtom.getElement().equals(oWarrantedAtom.getElement());
		}
		// compare operations
		else if(in_oCheckedExpression instanceof TCGOCLOperation &&
				in_oWarrantedExpression instanceof TCGOCLOperation) {
			OCLTreeTCGOCLAtomCollectorVisitor oFirstCollector =
				new OCLTreeTCGOCLAtomCollectorVisitor();
			OCLTreeTCGOCLAtomCollectorVisitor oSecondCollector =
				new OCLTreeTCGOCLAtomCollectorVisitor();
			OCLTreeExpressionIterator.run(in_oCheckedExpression, oFirstCollector);
			OCLTreeExpressionIterator.run(in_oWarrantedExpression, oSecondCollector);
	
			// try to adapt both sides to each other
			TCGOCLAtom oFirstAtom = oFirstCollector.getExpressions().get(0);
			TCGOCLAtom oSecondAtom = null;
			for(TCGOCLAtom oTmpAtom : oSecondCollector.getExpressions()) {
				if(expressionsContainReferenceToTheSameObject(
						oFirstAtom, oTmpAtom)) {
//				if(oFirstAtom.getElement().equals(oTmpAtom.getElement())) {
					oSecondAtom = oTmpAtom;
					break;
				}
			}
			if(oSecondAtom != null) {
				TCGOCLOperation oCheckedOperation = 
					(TCGOCLOperation)in_oCheckedExpression;
				TCGOCLOperation oWarrantedOperation = 
					(TCGOCLOperation)in_oWarrantedExpression;

				shiftSubexpressionToTheLeft(oFirstAtom, oCheckedOperation);
				shiftSubexpressionToTheLeft(oSecondAtom, oWarrantedOperation);
				// compare right side of expressions
				TCGOCLExpression oCheckedExpression = oCheckedOperation.getRight();
				TCGOCLExpression oWarrantedExpression = oWarrantedOperation.getRight();
				removeUnaryMinus(oCheckedExpression);
				removeUnaryMinus(oWarrantedExpression);
				// expressions equal? -> compare the exact syntax of both
				if(oCheckedOperation.getOperationName().equals(oWarrantedOperation.getOperationName()) &&
						expressionsAreEqual(oCheckedExpression, oWarrantedExpression)) {
					return true;
				}
//				expressionsContainTheSameAtoms
				
				if(oWarrantedExpression instanceof TCGOCLOperation &&
						oCheckedExpression instanceof TCGOCLOperation) {
					// TODO: how to compare arbitrary expressions?
					exchangeSidesOfExpression(
						(TCGOCLOperation)oWarrantedExpression);
					removeUnaryMinus(oWarrantedExpression);
					if(oCheckedOperation.getOperationName().equals(oWarrantedOperation.getOperationName()) &&
							expressionsAreEqual(oCheckedExpression, oWarrantedExpression)) {
						return true;
					}
				}
				else {
					return oCheckedOperation.getOperationName().equals(
							oWarrantedOperation.getOperationName()) &&
						expressionsCanBeTransformedIntoEachOther(
							oWarrantedExpression, oCheckedExpression);
				}
			}
		}
		return false;
	}
	
	public static boolean containsElementWithSameOCLReference(
			Collection<? extends TCGOCLExpression> in_colExpressions,
			TCGOCLExpression in_oExpression) {
		if(in_oExpression.isPositiveAssignmentOfOriginal()) {
			for(TCGOCLExpression oExpression : in_colExpressions) {
				if(oExpression.isPositiveAssignmentOfOriginal() &&
						ObjectComparator.equals(
								in_oExpression.getOclReference(), 
								oExpression.getOclReference())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsTransformableExpression(
			Collection<? extends TCGOCLExpression> in_colExpressions,
			TCGOCLExpression in_oExpression) {
		for(TCGOCLExpression oExpression : in_colExpressions) {
			if(expressionsCanBeTransformedIntoEachOther(in_oExpression, oExpression)) {
				return true;
			}
		}
		return false;
	}

	
}
