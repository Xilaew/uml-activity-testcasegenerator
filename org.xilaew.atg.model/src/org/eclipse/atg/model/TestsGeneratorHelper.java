package org.eclipse.atg.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.dialogs.ListDialog;
import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.ampl.Path2AMPLData;
import org.xilaew.atg.model.ampl.TCG2AMPLVisitor;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.tests.FunctionCall;
import org.xilaew.atg.model.tests.TestCase;
import org.xilaew.atg.model.tests.TestSuite;
import org.xilaew.atg.model.tests.TestsFactory;
import org.xilaew.atg.model.tests.Value;

public class TestsGeneratorHelper {

	public static TestSuite generateTests(TCGActivity tcgActivity,
			EList<Path> paths) {
		TestsFactory factory = TestsFactory.eINSTANCE;
		TestSuite result = factory.createTestSuite();
		JAMPL ampl = AmplFactory.createJAMPL();

		// Transform Model to AMPL
		TCG2AMPLVisitor tcg2AMPL = new TCG2AMPLVisitor();
		String amplModel = tcg2AMPL.doSwitch(tcgActivity);
		ampl.getCli().sendCommand(amplModel);
		for (Path p : paths) {
			String data = Path2AMPLData.getAMPLData(p);
			TestCase tc = factory.createTestCase();
			result.getTests().add(tc);
			FunctionCall func = factory.createFunctionCall();
			func.setName(tcgActivity.getName());
			tc.setFunction(func);

			ampl.loadData(data);
			InputDialog d = new InputDialog(null, "Wählen sie den Solver",
					"Welchen Solver möchten sie verwenden", "couenne", null);
			d.create();
			d.open();
			ampl.setSolver(d.getValue());
			ampl.solve();

			for (TCGVariable var : tcgActivity.getVariables()) {
				Value v = factory.createValue();
				v.setName(var.getName());
				if (var.isIsParameter()) {
					v.setValue(ampl.getParameter(var.getName()));
					func.getParameters().add(v);
				} else {
					v.setValue(ampl.getVariable(var.getName()).get(0));
					tc.getInitValues().add(v);
				}
			}

		}
		return null;
	}

}
