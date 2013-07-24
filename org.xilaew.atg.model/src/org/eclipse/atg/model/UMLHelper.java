package org.eclipse.atg.model;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;

import util.Output;

public class UMLHelper {
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
	public static Operation getContextOperation(Constraint localPostcondition) {
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

	public static Operation getContextOperation(ActivityEdge guardedEdge) {
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

}
