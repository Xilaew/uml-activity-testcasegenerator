package org.eclipse.atg.model;

import java.util.List;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.ValueSpecification;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;

import util.Output;

//XXX this class is not used any more. Development was continued as anonymus subclass of UMLActivity2TCGActivityConverter
public class OCLtoTCGVisitor extends
		AbstractVisitor<org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> {

	@Override
	protected TCGOCLExpression handleConstraint(Constraint constraint,
			TCGOCLExpression specificationResult) {
		return specificationResult;
	}

	@Override
	protected TCGOCLExpression handleExpressionInOCL(
			ExpressionInOCL<Classifier, Parameter> expression,
			TCGOCLExpression contextResult, TCGOCLExpression resultResult,
			List<TCGOCLExpression> parameterResults, TCGOCLExpression bodyResult) {
		return bodyResult;
	}

	ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;
	
	@Override
	protected TCGOCLExpression handleOperationCallExp(
			OperationCallExp<Classifier, Operation> callExp,
			TCGOCLExpression sourceResult,
			List<TCGOCLExpression> argumentResults) {
		TCGOCLOperationCallExp tcgOpCall = factory.createTCGOCLOperationCallExp();
		tcgOpCall.setName(callExp.getReferredOperation().getName());
		tcgOpCall.setSource(sourceResult);
		tcgOpCall.setOperation(TCGOCLOperationType.get(callExp.getReferredOperation().getName()));
		if (argumentResults!=null){
			tcgOpCall.getArguments().addAll(argumentResults);
		}
		return tcgOpCall;
	}

	@Override
	protected TCGOCLExpression handlePropertyCallExp(
			PropertyCallExp<Classifier, Property> callExp,
			TCGOCLExpression sourceResult,
			List<TCGOCLExpression> qualifierResults) {
		TCGOCLVariableCallExp tcgVar = factory.createTCGOCLVariableCallExp();
		callExp.getReferredProperty()
		return tcgVar;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ExpressionInOCL<Classifier, Parameter> getSpecification(
			Constraint constraint) {
		// TODO Auto-generated method stub
		ValueSpecification spec = constraint.getSpecification();
		if (spec instanceof ExpressionInOCL<?, ?>){
			return (ExpressionInOCL<Classifier, Parameter>)spec ;
		}
		return null;
	}

}
