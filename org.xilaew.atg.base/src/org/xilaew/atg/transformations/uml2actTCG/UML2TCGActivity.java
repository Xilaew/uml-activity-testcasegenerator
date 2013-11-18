package org.xilaew.atg.transformations.uml2actTCG;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow;
import org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;

import util.Output;
import data.YouShallNotDoThisException;

/**
 * this class defines how each UML Element is mapped to one corresponding
 * TestCaseGraph element. Elements that have already been converted will be
 * remembered. two subsequent calls of doSwitch for the same object will give
 * the same result.
 * 
 * @author th51e0
 * 
 */
public class UML2TCGActivity {

	Activity umlActivity = null;
	TCGActivity tcgActivity = null;
	/**
	 * A map remembering, which elements of the original model have been
	 * transformed already.
	 */
	Map<Element, AbstractTCGElement> uml2tcgmap = new HashMap<Element, AbstractTCGElement>();
	Map<Variable<Classifier, Parameter>, TCGOCLVariableCallExp> oclVar2tcgVarmap = new HashMap<Variable<Classifier, Parameter>, TCGOCLVariableCallExp>();
	ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;
	OCL<?, Classifier, Operation, ?, ?, ?, ?, ?, ?, ?, ?, ?> ocl;

	protected SecureRandom random = new SecureRandom();

	protected String randomString() {
		return new BigInteger(64, random).toString(32);
	}

	protected Visitor<org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> oclVisitor = new AbstractVisitor<org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint>() {
		@Override
		public TCGOCLExpression visitVariableExp(
				VariableExp<Classifier, Parameter> v) {
			TCGOCLVariableCallExp tcgVar = factory
					.createTCGOCLVariableCallExp();
			Output.debug(
					"visitVariableExp" + tcgVar + ":" + v.getReferredVariable(),
					v);
			tcgVar.setName(v.getName());
			if (v.getReferredVariable().getRepresentedParameter() != null) {
				tcgVar.setVariable((TCGVariable) transformElement(v
						.getReferredVariable().getRepresentedParameter()));
			}
			// tcgVar.setIsPre(v.);
			return tcgVar;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected ExpressionInOCL<Classifier, Parameter> getSpecification(
				Constraint constraint) {
			Output.debug("getSpecification", constraint);
			ValueSpecification spec = constraint.getSpecification();
			if (spec instanceof ExpressionInOCL<?, ?>) {
				return (ExpressionInOCL<Classifier, Parameter>) spec;
			}
			return null;
		}

		@Override
		protected TCGOCLExpression handleConstraint(Constraint constraint,
				TCGOCLExpression specificationResult) {
			Output.debug("handleConstraint", specificationResult);
			return specificationResult;
		}

		@Override
		protected TCGOCLExpression handleExpressionInOCL(
				ExpressionInOCL<Classifier, Parameter> expression,
				TCGOCLExpression contextResult, TCGOCLExpression resultResult,
				List<TCGOCLExpression> parameterResults,
				TCGOCLExpression bodyResult) {
			Output.debug("handleBodyResult", expression);
			return bodyResult;
		}

		@Override
		protected TCGOCLExpression handleOperationCallExp(
				OperationCallExp<Classifier, Operation> callExp,
				TCGOCLExpression sourceResult,
				List<TCGOCLExpression> argumentResults) {
			Output.debug("handleOperation", callExp);

			Output.debug(callExp.getReferredOperation().getName(), callExp);
			// Output.debug(callExp.getSource().toString(),
			// callExp.getSource());
			// Output.debug(callExp.getArgument().get(0).toString(), callExp
			// .getArgument().get(0));
			TCGOCLOperationCallExp tcgOpCall = factory
					.createTCGOCLOperationCallExp();
			tcgOpCall.setName(callExp.getReferredOperation().getName());
			tcgOpCall.setSource(sourceResult);
			tcgOpCall.setOperation(TCGOCLOperationType.get(callExp
					.getReferredOperation().getName()));
			if (argumentResults != null) {
				Output.debug(argumentResults.toString(), this);
				tcgOpCall.getArguments().addAll(argumentResults);
			}
			return tcgOpCall;
		}

		@Override
		protected TCGOCLExpression handlePropertyCallExp(
				PropertyCallExp<Classifier, Property> callExp,
				TCGOCLExpression sourceResult,
				List<TCGOCLExpression> qualifierResults) {
			TCGOCLVariableCallExp tcgVar = factory
					.createTCGOCLVariableCallExp();
			Output.debug("visitVariableExp" + tcgVar, callExp);
			tcgVar.setVariable((TCGVariable) transformElement(callExp
					.getReferredProperty()));
			tcgVar.setIsPre(callExp.isMarkedPre());
			Output.debug("Prop CallExp source: " + callExp.getSource(), this);
			return tcgVar;
		}

		@Override
		protected TCGOCLExpression handleVariable(
				Variable<Classifier, Parameter> variable,
				TCGOCLExpression initResult) {
			transformElement(variable.getRepresentedParameter());
			// TCGOCLVariableCallExp tcgVar = factory
			// .createTCGOCLVariableCallExp();
			// Output.debug("visitVariable"+tcgVar +":"+ variable, variable);
			//
			// tcgVar.setName(variable.getName());
			// if (variable.getRepresentedParameter() != null) {
			// tcgVar.setVariable((TCGVariable) transformElement(variable
			// .getRepresentedParameter()));
			// }
			return null;
		}

		@Override
		public TCGOCLExpression visitBooleanLiteralExp(
				BooleanLiteralExp<Classifier> literalExp) {
			TCGOCLLiteralExp tcgLiteral = factory.createTCGOCLLiteralExp();
			tcgLiteral.setName(literalExp.getName());
			tcgLiteral.setType(TCGBasicVariableType.BOOLEAN);
			tcgLiteral.setValue(literalExp.getBooleanSymbol() ? 1 : 0);
			return tcgLiteral;
		}

		// ActivityTestCaseGraphFactory factory =
		// ActivityTestCaseGraphFactory.eINSTANCE;

		@Override
		public TCGOCLExpression visitIntegerLiteralExp(
				IntegerLiteralExp<Classifier> literalExp) {
			TCGOCLLiteralExp tcgLiteral = factory.createTCGOCLLiteralExp();
			tcgLiteral.setName(literalExp.getName());
			tcgLiteral.setType(TCGBasicVariableType.INTEGER);
			tcgLiteral.setValue(literalExp.getIntegerSymbol().floatValue());
			return tcgLiteral;
		}

		@Override
		public TCGOCLExpression visitRealLiteralExp(
				RealLiteralExp<Classifier> literalExp) {
			TCGOCLLiteralExp tcgLiteral = factory.createTCGOCLLiteralExp();
			tcgLiteral.setName(literalExp.getName());
			tcgLiteral.setType(TCGBasicVariableType.REAL);
			tcgLiteral.setValue(literalExp.getRealSymbol().floatValue());
			return tcgLiteral;
		}

		@Override
		public TCGOCLExpression visitUnlimitedNaturalLiteralExp(
				UnlimitedNaturalLiteralExp<Classifier> literalExp) {
			TCGOCLLiteralExp tcgLiteral = factory.createTCGOCLLiteralExp();
			tcgLiteral.setName(literalExp.getName());
			tcgLiteral.setType(TCGBasicVariableType.INTEGER);
			tcgLiteral.setValue(literalExp.getIntegerSymbol().floatValue());
			return tcgLiteral;
		}

	};

	protected UMLSwitch<AbstractTCGElement> umlSwitch = new UMLSwitch<AbstractTCGElement>() {
		// ActivityTestCaseGraphFactory factory =
		// ActivityTestCaseGraphFactory.eINSTANCE;

		@Override
		public AbstractTCGElement caseAction(Action object) {
			TCGAction tcgAction = factory.createTCGAction();
			return handleAction(object, tcgAction);
		}

		public AbstractTCGElement caseActivity(Activity object) {
			TCGActivity tcgActivity = factory.createTCGActivity();
			return handleActivity(object, tcgActivity);
		}

		public AbstractTCGElement caseConstraint(Constraint object) {
			Output.debug("ConstraintFound", this);
			return handleConstraint(object);
		}

		public AbstractTCGElement caseControlFlow(ControlFlow object) {
			TCGControlFlow tcgControlFlow = factory.createTCGControlFlow();
			return handleControlFlow(object, tcgControlFlow);
		}

		@Override
		public AbstractTCGElement caseControlNode(ControlNode object) {
			TCGControlNode tcgControlNode = factory.createTCGControlNode();
			tcgControlNode.setName(object.getName());
			return tcgControlNode;
		}

		public AbstractTCGElement caseInitialNode(InitialNode object) {
			TCGControlNode tcgControlNode = factory.createTCGControlNode();
			tcgControlNode.setName(object.getQualifiedName());
			tcgActivity.setInitialNode(tcgControlNode);
			return tcgControlNode;
		}

		public AbstractTCGElement caseLiteralString(LiteralString object) {
			Output.debug("literalString found" + object.getValue(), this);
			return parseLiteralStringAsOCL(object);
		}

		public AbstractTCGElement caseOpaqueExpression(OpaqueExpression object) {
			Output.debug("OpaqueExpression Found" + object, this);
			return parseOpaqueExpressionAsOCL(object);
		}

		@Override
		public AbstractTCGElement caseParameter(Parameter object) {
			return handleParameter(object);
		}

		@Override
		public AbstractTCGElement caseProperty(Property object) {
			return handleProperty(object);
		}

	};

	public UML2TCGActivity() {
		UMLEnvironmentFactory envFactory = new UMLEnvironmentFactory() {

			@Override
			public Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> createOperationContext(
					Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent,
					Operation operation) {
				Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> result;
				result = super.createOperationContext(parent, operation);
				OCLFactory oclFactory = parent.getOCLFactory();
				UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> uml = parent
						.getUMLReflection();
				Variable<Classifier, Parameter> var = oclFactory
						.createVariable();
				Parameter next = operation.getReturnResult();
				uml.setName(var, uml.getName(next));
				uml.setType(var,
						TypeUtil.resolveType(result, uml.getOCLType(next)));
				var.setRepresentedParameter((Parameter) next);

				result.addElement(var.getName(), var, true);
				return result;
			}

		};
		ocl = OCL.newInstance(envFactory);
		// ocl = org.eclipse.ocl.uml.OCL.newInstance();
	}

	// public UML2TCGActivity(
	// org.eclipse.emf.ecore.resource.Resource resource) {
	// ocl = OCL.newInstance(
	// new UMLEnvironmentFactory(resource.getResourceSet()), resource);
	// }

	/**
	 * Delegates the conversion of relevant child Elements of an Action.
	 * Relevant for the Test Case Graph are the local Postconditions and the
	 * qualified Name
	 * 
	 * @param umlAction
	 * @param tcgAction
	 * @return
	 */
	protected AbstractTCGNode handleAction(Action umlAction, TCGAction tcgAction) {
		String name = umlAction.getQualifiedName().replace("\\s", "_").trim().concat(randomString());
		if (name == null) {
			name = randomString() + "Action";
		}
		tcgAction.setName(name);
		for (Constraint umlConstraint : umlAction.getLocalPostconditions()) {
			TCGOCLExpression tcgOCLExp = (TCGOCLExpression) transformElement(umlConstraint);
			if (tcgOCLExp != null) {
				tcgAction.getLocalPostconditions().add(tcgOCLExp);
			}
		}
		return tcgAction;
	}

	/**
	 * This Method handles the conversion from an (UML) Activity to a
	 * TCGActivity. It converts the (UML) Activity to a TCGActivity and
	 * delegates the conversion of all its containments to the appropriate
	 * handlers.
	 * 
	 * @param umlActivity
	 *            the (UML) Activity to be converted into a TestCaseGraph
	 * @return an TestCaseGraph Activity representing every important detail of
	 *         the original model
	 */
	protected TCGActivity handleActivity(Activity umlActivity,
			TCGActivity tcgActivity) {
		tcgActivity.setName(umlActivity.getName());
		this.tcgActivity = tcgActivity;
		// Convert (UML)ActivityNodes to TCGActivityNodes
		for (ActivityNode umlActivityNode : umlActivity.getOwnedNodes()) {
			AbstractTCGNode tcgNode = (AbstractTCGNode) transformElement(umlActivityNode);
			if (tcgNode != null) {
				tcgActivity.getNodes().add(tcgNode);
			}
		}
		// convert (UML) ActivityEdges to TCGEdges
		for (ActivityEdge umlEdge : umlActivity.getEdges()) {
			AbstractTCGEdge tcgEdge = (AbstractTCGEdge) transformElement(umlEdge);
			if (tcgEdge != null) {
				tcgActivity.getEdges().add(tcgEdge);
			}
		}
		tcgActivity.setClassName(UMLHelper.getNamespace(umlActivity).getName());
		tcgActivity.setPackageName(umlActivity.getNearestPackage()
				.getQualifiedName());
		return tcgActivity;

	}

	protected AbstractTCGElement handleConstraint(Constraint umlConstraint) {
		return transformElement(umlConstraint.getSpecification());
	}

	protected AbstractTCGEdge handleControlFlow(ControlFlow umlControlFlow,
			AbstractTCGEdge tcgEdge) {
		String name = umlControlFlow.getQualifiedName();
		if (name == null) {
			name = randomString() + "ControlFlow";
		}
		Output.debug(
				"Handle ControlFlow: Name := "
						+ umlControlFlow.getQualifiedName() + " -> " + name,
				this);
		tcgEdge.setName(name);
		tcgEdge.setSource((AbstractTCGNode) transformElement(umlControlFlow
				.getSource()));
		tcgEdge.setTarget((AbstractTCGNode) transformElement(umlControlFlow
				.getTarget()));
		tcgEdge.setGuard((AbstractTCGConstraint) transformElement(umlControlFlow
				.getGuard()));
		return tcgEdge;
	}

	protected AbstractTCGElement handleParameter(Parameter umlParameter) {
		// XXX maybe one could make a difference between Variables and
		// Parameters, since OCL semantic says Parameters are Immutable within
		// an activity.
		Type umlType = umlParameter.getType();
		TCGVariable tcgVar = null;
		TCGBasicVariableType tcgType = null;
		tcgType = TCGBasicVariableType.getByName(umlType.getName());
		if (tcgType != null) {
			tcgVar = factory.createTCGBasicVariable();
			((TCGBasicVariable) tcgVar).setVariableType(tcgType);
		} else {
			tcgVar = factory.createTCGVariable();
			// TODO recurse into object type Variables.
		}
		tcgVar.setUsage(UMLHelper.getUsage(umlParameter));
		tcgVar.setIsParameter(true);
		tcgVar.setName(umlParameter.getName());
		tcgActivity.getVariables().add(tcgVar);
		return tcgVar;
	}

	protected AbstractTCGElement handleProperty(Property umlProperty) {
		Type umlType = umlProperty.getType();
		TCGVariable tcgVar = null;
		TCGBasicVariableType tcgType = null;
		tcgType = TCGBasicVariableType.getByName(umlType.getName());
		if (tcgType != null) {
			tcgVar = factory.createTCGBasicVariable();
			((TCGBasicVariable) tcgVar).setVariableType(tcgType);
		} else {
			tcgVar = factory.createTCGVariable();
			// TODO recurse into object type Variables.
		}
		tcgVar.setName(umlProperty.getName());
		tcgVar.setIsParameter(false);
		tcgActivity.getVariables().add(tcgVar);
		return tcgVar;
	}

	private AbstractTCGElement parseLiteralStringAsOCL(LiteralString object) {
		Output.debug("namespace is: " + UMLHelper.getNamespace(object), this);
		Constraint oclConstraint = null;
		if (object.eContainmentFeature().equals(
				UMLPackage.Literals.ACTIVITY_EDGE__GUARD)) {
			// Parse Guardconditions like invariants
			Output.debug("this is a GuardCondition!", this);
			oclConstraint = parseOCL(object.getValue(),
					(Classifier) UMLHelper.getNamespace(object),
					UMLHelper.getContextOperation((ActivityEdge) object
							.getOwner()), ConstraintKind.INVARIANT);
		} else if (object.getOwner().eContainmentFeature()
				.equals(UMLPackage.Literals.ACTION__LOCAL_POSTCONDITION)) {
			// Parse Local Postconditions like Postconditions with an Operation
			// Context
			Output.debug("this is a local Postcondition!", this);
			oclConstraint = parseOCL(object.getValue(),
					(Classifier) UMLHelper.getNamespace(object),
					UMLHelper.getContextOperation((Constraint) object
							.getOwner()), ConstraintKind.POSTCONDITION);
		} else if (object.getOwner().eContainmentFeature()
				.equals(UMLPackage.Literals.NAMESPACE__OWNED_RULE)) {
			// TODO Parse an invariant as invariant!
			Output.debug("this is a Class invariant", this);
		}
		if (oclConstraint != null) {
			return oclVisitor.visitConstraint(oclConstraint);
		}
		return null;
	}

	/**
	 * parses invariants and postconditions. Guard conditions shall be parsed
	 * like invariants and localPostconditions will be parsed as Postconditions
	 * with some given operation context. If you want to pars a
	 * localPostcondition you found in an Activity it is necessary to provide
	 * some dummy operation within the contextClass having the same Parameters
	 * as the Activity we are converting
	 */
	private Constraint parseOCL(String oclExpr, Classifier contextClass,
			Operation contextOperation, ConstraintKind kind) {
		OCLHelper<Classifier, Operation, ?, ?> helper = ocl.createOCLHelper();
		if (contextOperation != null) {
			// contextOperation.getOwnedParameters().add(contextOperation.getReturnResult());
			helper.setOperationContext(contextClass, contextOperation);
			// Variable<Classifier, Parameter> var =
			// helper.getEnvironment().getOCLFactory().createVariable();
			// UMLReflection<?, Classifier, Operation, Property, ?, ?, ?, ?, ?,
			// Constraint> uml = helper.getEnvironment().getUMLReflection();
			// uml.setName(var,
			// uml.getName(contextOperation.getReturnResult()));
			// uml.setType(var, TypeUtil.resolveType(helper.getEnvironment(),
			// uml.getOCLType(contextOperation.getReturnResult())));
			// var.setRepresentedParameter(uml.getReturnResult(contextOperation));
			// helper.getEnvironment().addElement(var.getName(),
			// (Variable<Classifier, ? extends PM>) var, true);
		} else {
		}
		Object oclConstraint = null;
		try {
			Output.debug("trying to parse: " + oclExpr, this);
			oclConstraint = helper.createConstraint(kind, oclExpr);
		} catch (ParserException e) {
			Output.warn("COULD_NOT_PARSE_INVARIANT");
			Output.debug(e.getDiagnostic().getSource(), this);
			e.printStackTrace();
		}
		return (Constraint) oclConstraint;
	}

	private AbstractTCGElement parseOpaqueExpressionAsOCL(
			OpaqueExpression umlOpaqueExp) {
		String oclExp = null;
		Constraint oclConstraint = null;
		int index;
		if ((index = umlOpaqueExp.getLanguages().indexOf("OCL")) != -1) {
			oclExp = umlOpaqueExp.getBodies().get(index);
		} else if (umlOpaqueExp.getLanguages().isEmpty()) {
			Output.debug(
					"obviously no languagespecification in opaque expression will join all bodys",
					this);
			oclExp = "";
			for (String s : umlOpaqueExp.getBodies()) {
				oclExp = oclExp.concat(s);
			}
		}
		;
		if (umlOpaqueExp.eContainmentFeature().equals(
				UMLPackage.Literals.ACTIVITY_EDGE__GUARD)) {
			// Parse Guardconditions like invariants
			Output.debug("this is a GuardCondition!", this);
			oclConstraint = parseOCL(oclExp,
					(Classifier) UMLHelper.getNamespace(umlOpaqueExp),
					UMLHelper.getContextOperation((ActivityEdge) umlOpaqueExp
							.getOwner()), ConstraintKind.INVARIANT);
		} else if (umlOpaqueExp.getOwner().eContainmentFeature()
				.equals(UMLPackage.Literals.ACTION__LOCAL_POSTCONDITION)) {
			// Parse Local Postconditions like Postconditions with an Operation
			// Context
			oclConstraint = parseOCL(oclExp,
					(Classifier) UMLHelper.getNamespace(umlOpaqueExp),
					UMLHelper.getContextOperation((Constraint) umlOpaqueExp
							.getOwner()), ConstraintKind.POSTCONDITION);
			Output.debug("this is a local Postcondition!", this);
		} else if (umlOpaqueExp.getOwner().eContainmentFeature()
				.equals(UMLPackage.Literals.NAMESPACE__OWNED_RULE)) {
			// TODO Parse an invariant as invariant!
			Output.debug("this is a Class invariant", this);
		}
		if (oclConstraint != null) {
			return oclVisitor.visitConstraint(oclConstraint);
		}
		return null;
	}

	/**
	 * Transforms an UML Activity into a TCGActivity. This transformation is
	 * necessary to normalize the Model.
	 * 
	 * @param umlActivity
	 *            a reference to any UML Activity containing OCL expressions in
	 *            local Postconditions as well as guards
	 * @return a Normalized Testcasegraph to be used with Testgenerating
	 *         Algorithms
	 * @throws YouShallNotDoThisException
	 *             When some Design Rules for Activitys are violated
	 */
	public static TCGActivity transform(Activity umlActivity)
			throws YouShallNotDoThisException {
		UML2TCGActivity converter = new UML2TCGActivity();
		return converter.transform_internal(umlActivity);
	}

	TCGActivity transform_internal(Activity umlActivity)
			throws YouShallNotDoThisException {
		Output.debug("transform called", this);
		if (this.umlActivity != null) {
			throw new YouShallNotDoThisException(
					"One UML2TCGActivity per Activity");
		}
		this.umlActivity = umlActivity;
		return (TCGActivity) transformElement(umlActivity);
	}

	/*
	 * this method checks weather the given UML Model element has already a
	 * correspondence within the TestCaseGraph model. If yes it will return the
	 * corresponding element from the TestCaseGraph model otherwise it will
	 * delegate to the a Switch, which will create an appropriate Test Case
	 * Graph Model Element to represent the given UML Element
	 */
	AbstractTCGElement transformElement(Element umlElement) {
		if (umlElement == null)
			return null;
		if (!uml2tcgmap.containsKey(umlElement)) {
			AbstractTCGElement tcgObject = umlSwitch.doSwitch(umlElement);
			uml2tcgmap.put(umlElement, tcgObject);
			return tcgObject;
		} else
			return uml2tcgmap.get(umlElement);
	}

}
