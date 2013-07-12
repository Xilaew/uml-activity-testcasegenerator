package org.eclipse.atg.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.Element;
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

	protected UMLSwitch<EObject> umlSwitch = new UMLSwitch<EObject>() {
		ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;

		@Override
		public EObject caseAction(Action object) {
			TCGAction tcgAction = factory.createTCGAction();
			return tcgAction;
		}

		@Override
		public EObject caseControlNode(ControlNode object) {
			TCGControlNode tcgControlNode = factory.createTCGControlNode();
			return tcgControlNode;
		}
		
		public EObject caseControlFlow(ControlFlow object){
			TCGControlFlow tcgControlFlow = factory.createTCGControlFlow();
			return tcgControlFlow;
		}

	};

	protected EObject convert(EObject eObject) {
		if (!uml2tcgmap.containsKey(eObject)) {
			return umlSwitch.doSwitch(eObject);
		} else
			return uml2tcgmap.get(eObject);
	}

	public TCGActivity convert(org.eclipse.uml2.uml.Activity umlActivity) {
		ActivityTestCaseGraphFactory tcgFactory = ActivityTestCaseGraphFactory.eINSTANCE;
		TCGActivity tcgActivity = tcgFactory.createTCGActivity();

		// Convert (UML)ActivityNodes to TCGActivityNodes
		for (ActivityNode umlActivityNode : umlActivity
				.getNodes()) {
			AbstractTCGNode tcgNode = (AbstractTCGNode) convert(umlActivityNode);
			if (tcgNode != null) {
				tcgActivity.getNodes().add(tcgNode);
			}
		}
		
		// convert (UML) ActivityEdges to TCGEdges
		for (ActivityEdge umlEdge : umlActivity.getEdges()){
			AbstractTCGEdge tcgEdge = (AbstractTCGEdge) convert(umlEdge);
			tcgEdge.setSource((AbstractTCGNode) convert(umlEdge.getSource()));
			tcgEdge.setTarget((AbstractTCGNode) convert(umlEdge.getTarget()));
		}
		
		return tcgActivity;
	}
}
