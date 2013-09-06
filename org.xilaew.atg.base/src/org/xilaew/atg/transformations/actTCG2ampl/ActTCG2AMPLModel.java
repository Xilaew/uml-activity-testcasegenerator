package org.xilaew.atg.transformations.actTCG2ampl;

import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;

public class ActTCG2AMPLModel {
	public static String transform(TCGActivity act) {
		TCG2AMPLVisitor visitor = new TCG2AMPLVisitor();
		return visitor.doSwitch(act);
	}
}
