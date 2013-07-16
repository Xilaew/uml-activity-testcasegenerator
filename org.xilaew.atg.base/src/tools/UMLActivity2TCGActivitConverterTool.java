package tools;

import java.io.IOException;

import org.eclipse.atg.model.UMLActivity2TCGActivityConverter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Model;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphResourceFactoryImpl;

public class UMLActivity2TCGActivitConverterTool extends UMLPathsearch {

	public static void main(String[] args) {
		readCmdArgs(args);

		// read Model
		Model model = (Model) load(inFile).get(0);
		out("ModelName: " + model.getName()); //$NON-NLS-1$

		// select one activity
		Activity activity = selectActivity(model);

		UMLActivity2TCGActivityConverter converter = new UMLActivity2TCGActivityConverter();
		ActivityTestCaseGraphResourceFactoryImpl resFactory = new ActivityTestCaseGraphResourceFactoryImpl();
		Resource res = resFactory.createResource(URI.createFileURI(outFile));
		res.getContents().add(converter.transform(activity));
		try {
			res.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
