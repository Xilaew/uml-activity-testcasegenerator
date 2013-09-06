package org.xilaew.atg.transformations.uml2actTCG;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphSwitch;

public class ActTCGContinuityHelper {

	// Implements Visitor pattern to search Abstract Syntax Tree for all
	// depended Variables within an Expression.
	// Dependent variables are those Variables, that are not fixed by either
	// being Parameter, or @Pre. I.e. those are
	// the variables getting assigned a new Value by this Expression.
	static ActivityTestCaseGraphSwitch<EList<TCGBasicVariable>> searchHelper = new ActivityTestCaseGraphSwitch<EList<TCGBasicVariable>>() {


		@Override
		public EList<TCGBasicVariable> caseTCGOCLExpression(
				TCGOCLExpression object) {
			return new BasicEList<TCGBasicVariable>();
		}

		@Override
		public EList<TCGBasicVariable> caseTCGOCLOperationCallExp(
				TCGOCLOperationCallExp object) {
			EList<TCGBasicVariable> result = new BasicEList<TCGBasicVariable>();
			result.addAll(doSwitch(object.getSource()));
			for (TCGOCLExpression exp : object.getArguments()) {
				result.addAll(doSwitch(exp));
			}
			return result;
		}

		@Override
		public EList<TCGBasicVariable> caseTCGOCLVariableCallExp(
				TCGOCLVariableCallExp object) {
			EList<TCGBasicVariable> result = new BasicEList<TCGBasicVariable>();
			TCGVariable var = object.getVariable();
			// check add only dependent basic variables.
			if (!var.isIsParameter() && !object.isIsPre()
					&& var instanceof TCGBasicVariable) {
				result.add((TCGBasicVariable) var);
			}
			;
			return result;
		}

	};

	public static void addContinuityConstraints(TCGActivity tcgActivity) {
		ActivityTestCaseGraphFactory factory = ActivityTestCaseGraphFactory.eINSTANCE;
		for (AbstractTCGNode n : tcgActivity.getNodes()) {
			TCGAction tcgAct;
			EList<TCGBasicVariable> referencedBasicVars = new BasicEList<TCGBasicVariable>();
			if (n instanceof TCGAction) {
				tcgAct = (TCGAction) n;
				// get all Basic Variables, that are already dependent on the
				// Postconditions
				for (AbstractTCGConstraint c : tcgAct.getLocalPostconditions()) {
					referencedBasicVars.addAll(searchHelper.doSwitch(c));
				}
				// Add Postconditions explicitly stating, that Variables without
				// assignment stay the same.
				for (TCGVariable var : tcgActivity.getVariables()) {
					if (var instanceof TCGBasicVariable && !var.isIsParameter()
							&& !referencedBasicVars.contains(var)) {
						TCGOCLVariableCallExp pre = factory.createTCGOCLVariableCallExp();
						pre.setIsPre(true);
						pre.setVariable(var);
						pre.setName(var.getName()+"@Pre");
						TCGOCLVariableCallExp post = factory.createTCGOCLVariableCallExp();
						post.setIsPre(false);
						post.setVariable(var);
						post.setName(var.getName());
						TCGOCLOperationCallExp continuityExp = factory.createTCGOCLOperationCallExp();
						continuityExp.setName("continuity");
						continuityExp.setOperation(TCGOCLOperationType.EQUALS);
						continuityExp.setSource(post);
						continuityExp.getArguments().add(pre);
						tcgAct.getLocalPostconditions().add(continuityExp);
					}
				}
			}
		}
	}

}
