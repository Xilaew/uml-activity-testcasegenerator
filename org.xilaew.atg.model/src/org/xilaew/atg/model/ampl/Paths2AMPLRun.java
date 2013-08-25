package org.xilaew.atg.model.ampl;

import java.util.Collection;
import java.util.Iterator;

import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

public class Paths2AMPLRun {

	public static String getAMPLCommands(Collection<Path> paths,
			TCGActivity tcgActivity, String filename) {
		StringBuilder sb = new StringBuilder();
		sb.append("option solver minos;\n");
		sb.append("model " + filename + ".mod;\n");
		for (int i = 0; i < paths.size(); i++) {
			sb.append("reset data;\n");
			sb.append("data " + filename + i + ".dat;\n");
			sb.append("solve;\n");
			sb.append("display ");
			Iterator<TCGVariable> it = tcgActivity.getVariables().iterator();
			TCGVariable var;
			while (it.hasNext()) {
				var = it.next();
				sb.append(var.getName() + (it.hasNext() ? ", " : ";\n"));
			}
		}
		return sb.toString();
	}

}
