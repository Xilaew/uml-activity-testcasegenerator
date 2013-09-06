package tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphResourceFactoryImpl;
import org.xilaew.atg.transformations.actTCG2ampl.ActTCG2AMPLModel;

public class TCG2AMPLConverterTool extends AbstractTool{

	public static void main(String[] args) {
		readCmdArgs(args); 
		RESOURCE_SET.getPackageRegistry().put("http://org.xilaew.atg.model.activityTestCaseGraph", ActivityTestCaseGraphPackage.eINSTANCE );
		ActivityTestCaseGraphResourceFactoryImpl tcgResourceFactory = new ActivityTestCaseGraphResourceFactoryImpl();
		Resource res = tcgResourceFactory.createResource(URI.createFileURI(inFile));
		try {
			res.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TCGActivity tcgActivity = (TCGActivity) res.getContents().get(0);
		String amplModel = ActTCG2AMPLModel.transform(tcgActivity);
		out(amplModel);
		try {
			PrintWriter p = new PrintWriter(new FileOutputStream(outFile));
			p.print(amplModel);
			p.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
