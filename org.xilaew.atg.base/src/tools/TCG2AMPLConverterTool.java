package tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.xilaew.atg.mode.ampl.TCG2AMPLVisitor;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphResourceFactoryImpl;

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
		TCG2AMPLVisitor tcg2AMPL = new TCG2AMPLVisitor();
		String amplModel = tcg2AMPL.doSwitch(tcgActivity);
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
