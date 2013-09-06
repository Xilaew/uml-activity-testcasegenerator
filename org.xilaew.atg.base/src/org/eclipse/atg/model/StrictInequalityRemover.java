package org.eclipse.atg.model;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;

public class StrictInequalityRemover {
	
	public static void replaceStrictEqualities(TCGActivity tcgActivity){
		for (AbstractTCGNode node:tcgActivity.getNodes()){
			if(node instanceof TCGAction){
				for (AbstractTCGConstraint spec: ((TCGAction) node).getLocalPostconditions()){
					if (spec instanceof TCGOCLExpression);
				}
			}
		}
		
	}

}
