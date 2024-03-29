package org.xilaew.atg.model.input.activity.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.atg.model.pathsearch.PathSearch;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphResourceFactoryImpl;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.transformations.actTCG2ampl.ActTCG2AMPLModel;
import org.xilaew.atg.transformations.actTCG2ampl.Path2AMPLData;
import org.xilaew.atg.transformations.actTCG2ampl.Paths2AMPLRun;
import org.xilaew.atg.transformations.uml2actTCG.ActTCGContinuityHelper;
import org.xilaew.atg.transformations.uml2actTCG.UML2TCGActivity;

import data.YouShallNotDoThisException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class AMPLModelCreationHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public AMPLModelCreationHandler() {
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
		// TestCaseGraph OutputFile
		IFile actTCGFile = project
				.getFile("PluginOutput.activitytestcasegraph");
		// AMPL Model File
		IFile amplFile = project.getFile("PluginOutput.mod");
		// AMPL Command File
		IFile amplCommands = project.getFile("PluginOutput.run");

		// convert (UML) Activity to ActivityTestCaseGraph
		TCGActivity tcgActivity = null;
		try {
			tcgActivity = UML2TCGActivity.transform(activity);
		} catch (YouShallNotDoThisException e1) {
			e1.printStackTrace();
		}
		// Perform Transformations on Activity Test Case Graph
		ActTCGContinuityHelper.addContinuityConstraints(tcgActivity);

		// Transform Model to AMPL
		String amplModel = ActTCG2AMPLModel.transform(tcgActivity);

		// create PathData
		InputDialog dialogPathDepth = new InputDialog(null,
				"Geben sie die Maximale Pfadtiefe an",
				"Geben sie die Maximale Pfadtiefe an", "100", null);
		dialogPathDepth.create();
		dialogPathDepth.open();
		InputDialog dialogNoPaths = new InputDialog(null,
				"Geben sie die Maximale Pfadanzahl an",
				"Geben sie die Maximale Pfadanzahl an", "40", null);
		dialogNoPaths.create();
		dialogNoPaths.open();
		PathSearch search = PathSearch.BOUNDED_BFS;
		properties.setProperty(PathSearch.PROPERTY_MAX_PATHLENGTH, dialogPathDepth.getValue());
		properties.setProperty(PathSearch.PROPERTY_MAX_NO_PATHS, dialogNoPaths.getValue());
		search.setProperties( properties );
		EList<Path> paths = search.findAllPaths(tcgActivity);
		int pathnum = 0;
		for (Path p : paths) {
			String data = Path2AMPLData.transform(p);
			try {
				project.getFile("PluginOutput" + pathnum++ + ".dat").create(
						new ByteArrayInputStream(data.getBytes()), false, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		// create Run File
		String amplRun = Paths2AMPLRun.transform(paths, tcgActivity,
				"PluginOutput");

		// Output everything into the Files
		try {
			ActivityTestCaseGraphResourceFactoryImpl resFactory = new ActivityTestCaseGraphResourceFactoryImpl();
			Resource res = resFactory.createResource(URI.createFileURI(actTCGFile.getLocationURI().getPath()));
			res.getContents().add(tcgActivity);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			res.save(out, null);
			actTCGFile.create(new ByteArrayInputStream(out.toByteArray()),
					false, null);
			amplFile.create(new ByteArrayInputStream(amplModel.getBytes()),
					false, null);
			amplCommands.create(new ByteArrayInputStream(amplRun.getBytes()),
					false, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

			// derive state machine from 2 different sources ...

			// state machine itself in emf tree view
			if (oSelection.getFirstElement() instanceof Activity) {
				oActivity = (Activity) (oSelection.getFirstElement());
				// }
				// // state machine from a state machine diagram file
				// else if (oSelection.getFirstElement() instanceof IFile) {
				// IFile oFile = (IFile) oSelection.getFirstElement();
				// oActivity = getReferencedStateMachineFromDiagram(oFile);
			} else {
				System.err.println("Context: "
						+ oSelection.getFirstElement().getClass().getPackage()
						+ oSelection.getFirstElement().getClass().getName());
			}
		}
		return oActivity;
	}
}
