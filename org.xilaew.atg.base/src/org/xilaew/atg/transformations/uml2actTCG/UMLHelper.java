package org.xilaew.atg.transformations.uml2actTCG;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariableUsage;

import util.Output;

class UMLHelper {
	public static Namespace getNamespace(NamedElement umlElement) {
		Namespace ns = umlElement.getNamespace();
		if (ns == null) {
			ns = getNamespace((NamedElement) umlElement.getOwner());
		}
		return ns;
	}

	/**
	 * To be able to parse localPostconditions as Proper Postconditions an
	 * operation context needs to be provided. this function searches the Model
	 * for the necessary operation or constructs it when necessary.
	 * 
	 * @param localPostcondition
	 * @return
	 */
	static Operation getContextOperation(Constraint localPostcondition) {
		// XXX you could perform a proper search in all places where an
		// Operation specifiing some activity could hide
		Action action = (Action) localPostcondition.getOwner();
		Activity activity = action.getActivity();
		Operation contextOp = null;
		if (activity.getSpecification() instanceof Operation) {
			contextOp = (Operation) activity.getSpecification();
		} else if (activity.getOwner() instanceof Class) {
			Class oClass = (Class) activity.getOwner();
			contextOp = oClass.getOperation(activity.getName(), null, null);
		}
		return contextOp;
	}

	static Operation getContextOperation(ActivityEdge guardedEdge) {
		// XXX you could perform a proper search in all places where an
		// Operation specifiing some activity could hide
		Activity activity = guardedEdge.getActivity();
		Output.debug(""+activity, guardedEdge);
		Operation contextOp = null;
		if (activity.getSpecification() instanceof Operation) {
			contextOp = (Operation) activity.getSpecification();
		} else if (activity.getOwner() instanceof Class) {
			Class oClass = (Class) activity.getOwner();
			contextOp = oClass.getOperation(activity.getName(), null, null);
		}
		return contextOp;
	}

	static TCGVariableUsage getUsage(Parameter umlParameter) {
		System.out.println("umlParameter "+umlParameter.getName()+" hat den usage Typen: "+umlParameter.getDirection().getLiteral());
		switch(umlParameter.getDirection()){
		case IN_LITERAL: return TCGVariableUsage.IN_PARAMETER;
		case OUT_LITERAL: return TCGVariableUsage.OUT_PARAMETER;
		case RETURN_LITERAL: return TCGVariableUsage.RETURN_PARAMETER;
		default: return null;
		}
	}

}
