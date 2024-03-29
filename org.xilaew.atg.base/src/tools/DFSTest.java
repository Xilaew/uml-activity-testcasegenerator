package tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.atg.model.pathsearch.PathSearch;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphResourceFactoryImpl;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.transformations.actTCG2ampl.Path2AMPLData;

public class DFSTest extends AbstractTool {

	public static void main(String[] args) {
		readCmdArgs(args);
		RESOURCE_SET.getPackageRegistry().put(
				"http://org.xilaew.atg.model.activityTestCaseGraph",
				ActivityTestCaseGraphPackage.eINSTANCE);
		ActivityTestCaseGraphResourceFactoryImpl tcgResourceFactory = new ActivityTestCaseGraphResourceFactoryImpl();
		Resource res = tcgResourceFactory.createResource(URI
				.createFileURI(inFile));
		try {
			res.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TCGActivity tcgActivity = (TCGActivity) res.getContents().get(0);
		EList<Path> paths = PathSearch.BFS.findAllPaths(tcgActivity);
		int pathnum = 0;
		for (Path p : paths) {
			String data = Path2AMPLData.transform(p);
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(outFile
						+ pathnum++ + ".dat"));
				pw.print(data.toString());
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
