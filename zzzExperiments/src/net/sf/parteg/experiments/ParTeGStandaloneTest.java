package net.sf.parteg.experiments;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.dialogs.CreateTestCasesDialogSWT;
import net.sf.parteg.base.testcasegraph.helperclasses.LoggerHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgeneration.TestCaseGenerator;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGenerator;
import net.sf.parteg.base.testcasegraph.valuetypes.DoubleValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.IntegerValueType;
import net.sf.parteg.core.output.Logger;
import net.sf.parteg.input.statemachine.TestCaseGraphGenerator;
import net.sf.parteg.output.testgraph.TestCaseExporter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.StateMachine;

public class ParTeGStandaloneTest extends tools.AbstractTool{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readCmdArgs(args);
		Model model = (Model) load(inFile).get(0);
		StateMachine oStateMachine = null;
				for (EObject object : model.allOwnedElements()){
					if (object instanceof StateMachine){
						oStateMachine = (StateMachine) object;
					}
				}

		try {
			Configuration.setLoggerLevel(Configuration.LoggerLevel.MINIMUM);
			Configuration
					.setExceptionTarget(Configuration.ExceptionTarget.MESSAGEBOX);
			//StateMachine oStateMachine = prepareTestGeneration(action);

			IntegerValueType.setMinimum(-1000);
			IntegerValueType.setMaximum(1000);
			DoubleValueType.setMinimum(-1000.0);
			DoubleValueType.setMaximum(1000.0);
			Configuration.setNumberOfRandomElementsPerDomain(3);

			// dialog
			CreateTestCasesDialogSWT oDialog = new CreateTestCasesDialogSWT();
			if (oDialog.getOkPressed()) {
				// create process bar
				// ... cancel + Erfolgsnachricht am Ende

				// generate test case graph
				TestCaseGraphGenerator oGenerator = new TestCaseGraphGenerator(
						oStateMachine);
				TestCaseGraphHelper oTCGHelper = oGenerator
						.createTestCaseGraph();

				// create test goals from coverage criteria
				TestGoalGenerator oTestGoalGenerator = new TestGoalGenerator(
						oTCGHelper);
				oTestGoalGenerator.defineTestGoalsForTCG();

				// create test suite
				TestCaseGenerator oTCGGenerator = new TestCaseGenerator(
						oTCGHelper);
				oTCGGenerator.createTestCases();

				// print test suite according to the selected output format
				TestCaseExporter oTestCaseExporter = new TestCaseExporter(
						oTCGHelper);
				oTestCaseExporter.print(oTCGGenerator.getTestSuite());

				// print log file
				Logger oLogger = oTCGHelper.getLogger();
				LoggerHelperClass.logTestGoalSatisfactionComplete(oLogger,
						oTCGHelper);
				oLogger.print(Configuration.getLoggerOutput());

				// Display display = Display.getDefault();
//				if (Configuration.getExceptionList().isEmpty()) {
//					Shell sShell = new Shell(SWT.APPLICATION_MODAL
//							| SWT.SHELL_TRIM | SWT.ON_TOP | SWT.BORDER);
//					MessageBox mb = new MessageBox(sShell, SWT.OK);
//					mb.setText("ParTeG Message");
//					mb.setMessage("Test Suite Generation Finished");
//					mb.open();
//				}
			}
		} catch (Exception e) {
			Configuration.handleException(e);
		}

		Configuration.printExceptionList();
		Configuration.getExceptionList().clear();

		// TODO Auto-generated method stub

	}

}
