package org.xilaew.atg.unitTestOutput;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.atg.model.pathsearch.Witness;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.dialogs.InputDialog;
import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
import org.xilaew.amplCLI.JAMPL.SolveResult;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.tests.FunctionCall;
import org.xilaew.atg.model.tests.SUT;
import org.xilaew.atg.model.tests.TestCase;
import org.xilaew.atg.model.tests.TestSuite;
import org.xilaew.atg.model.tests.TestsFactory;
import org.xilaew.atg.model.tests.Value;
import org.xilaew.atg.transformations.actTCG2ampl.ActTCG2AMPLModel;
import org.xilaew.atg.transformations.actTCG2ampl.Path2AMPLData;

public class TestsGeneratorHelper {

	public static TestSuite generateTests(TCGActivity tcgActivity,
			Collection<Path> paths) {
		TestsFactory factory = TestsFactory.eINSTANCE;
		TestSuite result = factory.createTestSuite();
		SUT sut = factory.createSUT();
		sut.setName(tcgActivity.getClassName());
		sut.setPackageName(tcgActivity.getPackageName());
		result.getSut().add(sut);
		JAMPL ampl = AmplFactory.createJAMPL();
		String solver = null;

		// Transform Model to AMPL
		String amplModel = ActTCG2AMPLModel.transform(tcgActivity);
		ampl.getCli().sendCommand(amplModel);
		// Create one Testcase per Path
		for (Path p : paths) {
			// Generate AMPL Data for each Path
			String data = Path2AMPLData.transform(p);
			ampl.loadData(data);
			if (solver == null) {
				InputDialog d = new InputDialog(null, "Wählen sie den Solver",
						"Welchen Solver möchten sie verwenden", "couenne", null);
				d.create();
				d.open();
				solver = d.getValue();
				ampl.setSolver(solver);
			}
			// Solve the Model and Data to get Input data
			SolveResult solved;
			try {
				solved = ampl.solve();
			} catch (IOException e) {
				ampl = AmplFactory.createJAMPL();
				ampl.setSolver(solver);
				ampl.loadModel(ActTCG2AMPLModel.transform(tcgActivity));
				System.out.println("RESET!!!");
				ampl.loadData(Path2AMPLData.transform(p));
				try {
					solved = ampl.solve();
				} catch (IOException e1) {
					e1.printStackTrace();
					break;
				}
			}
			// Read Values from Solver and store in Model
			if (solved == SolveResult.Solved) {
				TestCase tc = factory.createTestCase();
				result.getTests().add(tc);
				FunctionCall func = factory.createFunctionCall();
				func.setName(tcgActivity.getName());
				func.setActivity(tcgActivity);
				tc.setFunction(func);
				for (TCGVariable var : tcgActivity.getVariables()) {
					Value v = factory.createValue();
					v.setName(var.getName());
					v.setVariable(var);
					if (var.isIsParameter()) {
						Double value = null;
						try {
							value = ampl.getParameter(var.getName());
						} catch (IOException e) {
							
							e.printStackTrace();
							continue;
						}
						v.setValue(value);
						switch (var.getUsage()) {
						case IN_PARAMETER:
							func.getParameters().add(v);
							break;
						case OUT_PARAMETER:
							tc.getTestForValue().add(v);
							break;
						case INOUT_PARAMETER:
							// XXX INOUT parameters currently can not be handled
							// since there is only one value. For in/out
							// Parameters a pre and a post Value would be
							// necessary.
							// func.getParameters().add(v); //@pre
							// tc.getTestForValue().add(v); //post
							break;
						case RETURN_PARAMETER:
							tc.getTestForValue().add(v);
							break;
						default:
							break;
						}
					} else {
						List<Double> trace = null;
						try {
							trace = ampl.getVariable(var.getName());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
						v.setValue(trace.get(0));
						tc.getInitValues().add(v);
						Value vout = factory.createValue();
						vout.setValue(trace.get(trace.size() - 1));
						vout.setName(var.getName());
						vout.setVariable(var);
						tc.getTestForValue().add(vout);
					}
				}
			}
		}
		return result;
	}

	public static TestSuite generateTests(TCGActivity tcgActivity,
			EMap<Path, Witness> paths) {
		TestsFactory factory = TestsFactory.eINSTANCE;
		TestSuite result = factory.createTestSuite();
		SUT sut = factory.createSUT();
		sut.setName(tcgActivity.getClassName());
		sut.setPackageName(tcgActivity.getPackageName());
		result.getSut().add(sut);

		// Create one Testcase per Path
		for (Entry<Path,Witness> p : paths.entrySet()) {
			// Read Values from Solver and store in Model
			TestCase tc = factory.createTestCase();
			result.getTests().add(tc);
			FunctionCall func = factory.createFunctionCall();
			func.setName(tcgActivity.getName());
			func.setActivity(tcgActivity);
			tc.setFunction(func);
			for (TCGVariable var : tcgActivity.getVariables()) {
				Value v = factory.createValue();
				v.setName(var.getName());
				v.setVariable(var);
				if (var.isIsParameter()) {
					Double value = p.getValue().get(var).get(0);
					v.setValue(value);
					switch (var.getUsage()) {
					case IN_PARAMETER:
						func.getParameters().add(v);
						break;
					case OUT_PARAMETER:
						tc.getTestForValue().add(v);
						break;
					case INOUT_PARAMETER:
						// XXX INOUT parameters currently can not be handled
						// since there is only one value. For in/out
						// Parameters a pre and a post Value would be
						// necessary.
						// func.getParameters().add(v); //@pre
						// tc.getTestForValue().add(v); //post
						break;
					case RETURN_PARAMETER:
						tc.getTestForValue().add(v);
						break;
					default:
						break;
					}
				} else {
					List<Double> trace = p.getValue().get(var);
					v.setValue(trace.get(0));
					tc.getInitValues().add(v);
					Value vout = factory.createValue();
					vout.setValue(trace.get(trace.size() - 1));
					vout.setName(var.getName());
					vout.setVariable(var);
					tc.getTestForValue().add(vout);
				}

			}
		}
		return result;
	}

}
