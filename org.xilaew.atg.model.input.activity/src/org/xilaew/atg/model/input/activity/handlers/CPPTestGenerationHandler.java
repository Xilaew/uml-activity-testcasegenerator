package org.xilaew.atg.model.input.activity.handlers;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.eclipse.atg.model.pathsearch.PathSearch;
import org.eclipse.atg.model.pathsearch.SatisfiablePathSearch;
import org.eclipse.atg.model.pathsearch.Witness;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.uml2.uml.Activity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.tests.TestSuite;
import org.xilaew.atg.transformations.uml2actTCG.ActTCGContinuityHelper;
import org.xilaew.atg.transformations.uml2actTCG.UML2TCGActivity;
import org.xilaew.atg.unitTestOutput.Tests2BoostUnitTest;
import org.xilaew.atg.unitTestOutput.TestsGeneratorHelper;

import data.YouShallNotDoThisException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CPPTestGenerationHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CPPTestGenerationHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Properties properties = new Properties();
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		// The original UML File
		IFile umlFile = ResourceUtil.getFile(editor.getEditorInput());
		IProject project = umlFile.getProject();
		// The Input Activity
		Activity activity = prepareTestGeneration();
		// Boost UnitTest
		IFile boostfile = project.getFile("PluginOutput.cpp");

		// convert (UML) Activity to ActivityTestCaseGraph
		TCGActivity tcgActivity = null;
		try {
			tcgActivity = UML2TCGActivity.transform(activity);
		} catch (YouShallNotDoThisException e1) {
			e1.printStackTrace();
		}
		// Perform Transformations on Activity Test Case Graph
		ActTCGContinuityHelper.addContinuityConstraints(tcgActivity);

		// Ask user for parameters
		InputDialog dialogPathDepth = new InputDialog(null,
				"Geben sie die Maximale Pfadtiefe an",
				"Geben sie die Maximale Pfadtiefe an", "100", null);
		dialogPathDepth.create();
		dialogPathDepth.open();
		InputDialog dialogNoPaths = new InputDialog(null,
				"Wie viele Testfälle sollen es maximal sein?",
				"Geben sie die Maximale Anzahl an Testfällen an", "20", null);
		dialogNoPaths.create();
		dialogNoPaths.open();
		InputDialog dialogSolver = new InputDialog(null,
				"Welcher Solver soll verwendet werden?",
				"Welcher Solver soll verwendet werden?", "couenne", null);
		dialogSolver.create();
		dialogSolver.open();
		SatisfiablePathSearch search = SatisfiablePathSearch.SOLVER_DFS;
		properties.setProperty(PathSearch.PROPERTY_MAX_PATHLENGTH, dialogPathDepth.getValue());
		properties.setProperty(PathSearch.PROPERTY_MAX_NO_PATHS, dialogNoPaths.getValue());
		properties.setProperty(SatisfiablePathSearch.PROPERTY_SOLVER, dialogSolver.getValue());
		search.setProperties( properties );
		EMap<Path,Witness> paths = search.findAllSatisfiablePaths(tcgActivity);

		// create UnitTests Model with specific data
		TestSuite suite = TestsGeneratorHelper
				.generateTests(tcgActivity, paths);
		// create Boost Test sourceCode
		String unitTest = Tests2BoostUnitTest.generateUnitTest(suite);

		// Output everything into the Files
		try {
			boostfile.create(new ByteArrayInputStream(unitTest.getBytes()), false, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Activity prepareTestGeneration() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		ISelection sel = page.getSelection();

		Activity oActivity = null;
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection oSelection = (IStructuredSelection) sel;

			// Get Activity selected from UML Treevwiew
			if (oSelection.getFirstElement() instanceof Activity) {
				oActivity = (Activity) (oSelection.getFirstElement());
			} else {
				System.err.println("Context: "
						+ oSelection.getFirstElement().getClass().getPackage()
						+ oSelection.getFirstElement().getClass().getName());
			}
		}
		return oActivity;
	}
}
