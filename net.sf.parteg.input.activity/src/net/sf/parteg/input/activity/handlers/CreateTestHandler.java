package net.sf.parteg.input.activity.handlers;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.dialogs.CreateTestCasesDialogSWT;
import net.sf.parteg.base.testcasegraph.helperclasses.LoggerHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.UMLActivityHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.UMLStateMachineHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgeneration.TestCaseGenerator;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGenerator;
import net.sf.parteg.base.testcasegraph.valuetypes.DoubleValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.IntegerValueType;
import net.sf.parteg.core.output.Logger;
import net.sf.parteg.input.activity.TestCaseGraphGenerator;
import net.sf.parteg.output.testgraph.TestCaseExporter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class CreateTestHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			Configuration.setLoggerLevel(Configuration.LoggerLevel.MINIMUM);
			Configuration
					.setExceptionTarget(Configuration.ExceptionTarget.MESSAGEBOX);
			// StateMachine oStateMachine = prepareTestGeneration();
			Activity oActivity = prepareTestGeneration();

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
						oActivity);
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
				if (Configuration.getExceptionList().isEmpty()) {
					Shell sShell = new Shell(SWT.APPLICATION_MODAL
							| SWT.SHELL_TRIM | SWT.ON_TOP | SWT.BORDER);
					MessageBox mb = new MessageBox(sShell, SWT.OK);
					mb.setText("ParTeG Message");
					mb.setMessage("Test Suite Generation Finished");
					mb.open();
				}
			}
		} catch (Exception e) {
			Configuration.handleException(e);
		}

		Configuration.printExceptionList();
		Configuration.getExceptionList().clear();
		return null;
	}

	private Activity prepareTestGeneration() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		ISelection sel = page.getSelection();

		// StateMachine oStateMachine = null;
		Activity oActivity = null;
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection oSelection = (IStructuredSelection) sel;

			// derive state machine from 2 different sources ...

			// state machine itself in emf tree view
			if (oSelection.getFirstElement() instanceof Activity) {
				oActivity = (Activity) (oSelection.getFirstElement());
			}
			// state machine from a state machine diagram file
			// else if (oSelection.getFirstElement() instanceof IFile) {
			// IFile oFile = (IFile) oSelection.getFirstElement();
			// oActivity = getReferencedStateMachineFromDiagram(oFile);
			// }
			else {
				System.err.println("Context: "
						+ oSelection.getFirstElement().getClass().getPackage()
						+ oSelection.getFirstElement().getClass().getName());
			}
		}
		;

		URI oFileURI = UMLActivityHelperClass
				.getPackageOfActivity(oActivity).eResource().getURI();

		// uri can be platform-specific or not ...
		if (oFileURI.isPlatform()) {
			// leaving out the first ("resource") and the last (the file name)
			StringBuffer sLocalDirectory = new StringBuffer();
			for (int i = 1; i < oFileURI.segmentCount() - 1; ++i) {
				sLocalDirectory.append(oFileURI.segment(i) + "/");
			}

			Configuration.setLocalSourceDirectory(sLocalDirectory.toString());
			Configuration.setWorkspacePath(ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toString()
					+ "/");
		} else {
			// leaving out the the file name
			StringBuffer sLocalDirectory = new StringBuffer();
			if (oFileURI.device() == null) {
				sLocalDirectory.append("/");
			} else {
				sLocalDirectory.append(oFileURI.device() + "/");
			}
			for (int i = 0; i < oFileURI.segmentCount() - 1; ++i) {
				sLocalDirectory.append(oFileURI.segment(i) + "/");
			}
			// replace placeholder with empty space
			while (true) {
				int i = sLocalDirectory.indexOf("%20");
				if (i != -1)
					sLocalDirectory.replace(i, i + 3, " ");
				else
					break;
			}
			Configuration.setLocalSourceDirectory(sLocalDirectory.toString());
			Configuration.setWorkspacePath("");
		}

		Configuration.defaultConfig(oStateMachine);

		IntegerValueType.setMinimum(-1000000);
		IntegerValueType.setMaximum(1000000);
		DoubleValueType.setMinimum(-1000000.0);
		DoubleValueType.setMaximum(1000000.0);

		return oActivity;
	}

	private StateMachine getReferencedStateMachineFromDiagram(IFile oFile) {

		// Open the selected file as UML
		URI uri = URI.createFileURI(oFile.getLocationURI().getPath());
		ResourceSet resSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resSet.getResource(uri, true);
		StateMachine oRetValue = null;

		// find the first instance of a StateMachine inside the UML file
		TreeIterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof StateMachine) {
				oRetValue = (StateMachine) o;
				break;
			}
		}
		return oRetValue;
	}

}
