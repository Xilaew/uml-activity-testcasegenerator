package org.eclipse.atg.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow;
import org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;

import util.Output;

/**
 * this class defines how each UML Element is mapped to one corresponding
 * TestCaseGraph element. Elements that have already been converted will be
 * remembered. two subsequent calls of doSwitch for the same object will give
 * the same result.
 * 
 * @author th51e0
 * 
 */
public class UMLActivity2TCGActivityConverter {

	/**
	 * A map remembering, which elements of the original model have been
	 * transformed already.
	 */
	Map<Element, AbstractTCGElement> uml2tcgmap = new HashMap<Element, AbstractTCGElement>();
	ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;
	OCL ocl;

	public UMLActivity2TCGActivityConverter(
			org.eclipse.emf.ecore.resource.Resource resource) {
		ocl = OCL.newInstance(
				new UMLEnvironmentFactory(resource.getResourceSet()), resource);
	}

	public UMLActivity2TCGActivityConverter() {
		ocl = OCL.newInstance();
	}

	protected org.eclipse.ocl.uml.util.UMLSwitch<AbstractTCGElement> oclSwitch = new org.eclipse.ocl.uml.util.UMLSwitch<AbstractTCGElement>() {

	};

	protected OCLtoTCGVisitor oclVisitor = new OCLtoTCGVisitor();

	protected UMLSwitch<AbstractTCGElement> umlSwitch = new UMLSwitch<AbstractTCGElement>() {
		ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;

		@Override
		public AbstractTCGElement caseAction(Action object) {
			TCGAction tcgAction = factory.createTCGAction();
			return handleAction(object, tcgAction);
		}

		@Override
		public AbstractTCGElement caseControlNode(ControlNode object) {
			TCGControlNode tcgControlNode = factory.createTCGControlNode();
			tcgControlNode.setName(object.getName());
			return tcgControlNode;
		}

		public AbstractTCGElement caseControlFlow(ControlFlow object) {
			TCGControlFlow tcgControlFlow = factory.createTCGControlFlow();
			return handleControlFlow(object, tcgControlFlow);
		}

		public AbstractTCGElement caseActivity(Activity object) {
			TCGActivity tcgActivity = factory.createTCGActivity();
			return handleActivity(object, tcgActivity);
		}

		public AbstractTCGElement caseLiteralString(LiteralString object) {
			Output.debug("literalString found trying to parse it as ocl: "
					+ object.getValue(), this);
			return parseLiteralStringAsOCL(object);
		}

		public AbstractTCGElement caseOpaqueExpression(OpaqueExpression object) {
			Output.debug("OpaqueExpression Found", this);
			return parseOpaqueExpressionAsOCL(object);
		}

		public AbstractTCGElement caseConstraint(Constraint object) {
			Output.debug("ConstraintFound", this);
			return handleConstraint(object);
		}

	};

	/*
	 * this method checks weather the given UML Model element has already a
	 * correspondence within the TestCaseGraph model. If yes it will return the
	 * corresponding element from the TestCaseGraph model otherwise it will
	 * delegate to the a Switch, which will create an appropriate Test Case
	 * Graph Model Element to represent the given UML Element
	 */
	protected AbstractTCGElement transformElement(Element umlElement) {
		if (umlElement == null)
			return null;
		if (!uml2tcgmap.containsKey(umlElement)) {
			AbstractTCGElement tcgObject = umlSwitch.doSwitch(umlElement);
			uml2tcgmap.put(umlElement, tcgObject);
			return tcgObject;
		} else
			return uml2tcgmap.get(umlElement);
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
		Helper helper = ocl.createOCLHelper();
		switch (kind) {
		case INVARIANT:
			helper.setContext(contextClass);
			break;
		case POSTCONDITION:
			helper.setOperationContext(contextClass, contextOperation);
			break;
		default:
			break;
		}
		;
		Constraint oclConstraint = null;
		try {
			oclConstraint = helper.createConstraint(kind, oclExpr);
		} catch (ParserException e) {
			Output.warn("COULD_NOT_PARSE_INVARIANT");
			Output.debug(e.getDiagnostic().getSource(), this);
			e.printStackTrace();
		}
		return oclConstraint;
	}

	private AbstractTCGElement parseLiteralStringAsOCL(LiteralString object) {
		Output.debug("namespace is: " + UMLHelper.getNamespace(object), this);
		Constraint oclConstraint = null;

		if (object.eContainingFeature().getFeatureID() == UMLPackage.CONTROL_FLOW__GUARD) {
			Output.debug("this is a GuardCondition!", object);
			oclConstraint = parseOCL(object.getValue(),
					(Classifier) UMLHelper.getNamespace(object), null,
					ConstraintKind.INVARIANT);
		}
		if (object.eContainingFeature().getFeatureID() == UMLPackage.CONSTRAINT__SPECIFICATION) {
			if (object.getOwner().eContainmentFeature().getFeatureID() == UMLPackage.ACTION__LOCAL_POSTCONDITION) {
				Output.debug("this is a local Postcondition", object);
			}
			if (object.getOwner().eContainingFeature().getFeatureID() == UMLPackage.ACCEPT_CALL_ACTION__LOCAL_POSTCONDITION) {
				Output.debug("does not work", this);
			}
		}
		if (oclConstraint != null) {
			return oclVisitor.visitConstraint(oclConstraint);
		}
		return null;
	}

	private AbstractTCGElement parseOpaqueExpressionAsOCL(
			OpaqueExpression umlOpaqueExp) {
		String oclExp = null;
		int index;
		if ((index = umlOpaqueExp.getLanguages().indexOf("OCL")) != -1) {
			oclExp = umlOpaqueExp.getBodies().get(index);
		} else if (umlOpaqueExp.getLanguages().isEmpty()) {
			Output.debug(
					"obviously no languagespecification in opaque expression will join all bodys",
					this);
		}
		;

		return null;

	}

	public TCGActivity transform(Activity umlActivity) {
		Output.debug("transform called", this);
		return (TCGActivity) transformElement(umlActivity);
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
		tcgActivity.setName(umlActivity.getQualifiedName());

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
		return tcgActivity;

	}

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
		tcgAction.setName(umlAction.getQualifiedName());
		for (Constraint umlConstraint : umlAction.getLocalPostconditions()) {
			TCGOCLExpression tcgOCLExp = (TCGOCLExpression) transformElement(umlConstraint);
			if (tcgOCLExp != null) {
				tcgAction.getLocalPostconditions().add(tcgOCLExp);
			}
		}
		return tcgAction;
	}

	protected AbstractTCGEdge handleControlFlow(ControlFlow umlControlFlow,
			AbstractTCGEdge tcgEdge) {
		tcgEdge.setName(umlControlFlow.getQualifiedName());
		tcgEdge.setSource((AbstractTCGNode) transformElement(umlControlFlow
				.getSource()));
		tcgEdge.setTarget((AbstractTCGNode) transformElement(umlControlFlow
				.getTarget()));
		tcgEdge.setGuard((AbstractTCGConstraint) transformElement(umlControlFlow
				.getGuard()));
		return tcgEdge;
	}

	protected AbstractTCGElement handleConstraint(Constraint umlConstraint) {
		return transformElement(umlConstraint.getSpecification());
	}

}
