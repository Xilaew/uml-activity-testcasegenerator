package org.xilaew.atg.transformations.actTCG2ampl;

import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;

public class ActTCG2AMPLModel {
	static TCGActivity lastAct;
	static String lastAMPL;
	
	public static String transform(TCGActivity act) {
		if (act==lastAct)return lastAMPL;
		TCG2AMPLVisitor visitor = new TCG2AMPLVisitor();
		lastAct =act;
		lastAMPL=visitor.doSwitch(act);
		return lastAMPL;
	}
}
