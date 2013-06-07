package experimental;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

import tools.UMLPathsearch;

public class AMPLVarGen extends UMLPathsearch {

	static int pathlength;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		readCmdArgs(args);
		PrintWriter outputFile = new PrintWriter(new FileWriter(
				AMPLVarGen.outFile));
		Model model = (Model) load(inFile).get(0);
		Activity activity = selectActivity(model);

		// set arbitrary Pathlengt (should be the exact count of Action nodes on
		// one controllflowpath)
		pathlength = 3;
		Map<Type, String> typeMap = new HashMap<Type, String>();
		// typeMap.put(key, value);
		// RESOURCE_SET;

		// write Variable declarations to AMPL file
		for (Parameter param : activity.getOwnedParameters()) {
			String typeSpec = null;
			if (param.getType().toString().contains("Integer"))
				typeSpec = ": integer";
			if (param.getType().toString().contains("Boolean"))
				typeSpec = "in 0..1";
			if (param.getType().toString().contains("Real"))
				typeSpec = "";
			if (param.getType().toString().contains("UnlimitedNatural"))
				typeSpec = "";
			if (typeSpec != null)
				outputFile.println("var " + param.getName() + "{0.."
						+ (pathlength - 1) + "} " + typeSpec + ";");
		}
		outputFile.close();
	}

}
