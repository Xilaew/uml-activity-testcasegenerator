package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * Tool to convert xmi files exportet by Artisan Studio into .uml files suitable for the eclipse UML Framework
 * @author Felix Kurth
 *
 */
public class ArtisanXMI2UML extends AbstractTool {

	static final String tmpFile = "./tmp.uml";
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		readCmdArgs(args);
		
		EList<? extends EObject> model = load(inFile);
		out(model.get(0).toString());
		out("-----------------------");
		out(model.get(1).toString());
		model.remove(0);
		save(model, tmpFile);

		List<String> lines = Files.readAllLines(Paths.get(tmpFile),
				Charset.defaultCharset());
		PrintWriter pw = new PrintWriter(new FileWriter(outFile));
		for (String s : lines) {
			//UML Namespace
			s = s.replace("xmlns:uml=\"http://www.omg.org/spec/UML/20090901\"",
					"xmlns:uml = \"http://www.eclipse.org/uml2/4.0.0/UML\"");
			//Primitive Datatype references
			s = s.replace("http://www.omg.org/spec/UML/20090901/UML.xmi",
					"http://www.omg.org/spec/UML/20110701/PrimitiveTypes.xmi");
			//References to UML Profile
			s = s.replace(
					"http://www.omg.org/spec/UML/20090901/StandardProfileL2.xmi",
					"http://www.omg.org/spec/UML/20110701/StandardProfileL2.xmi");

			pw.println(s);
		}

		// BufferedReader br = new BufferedReader(new
		// FileReader(tmpFile));
		// PrintWriter pw = new PrintWriter(new
		// FileWriter(outFile));
		// String line;
		// while((line = br.readLine())!= null){
		// System.out.println(line);
		// pw.println(line.replace("http://www.omg.org/spec/UML/20090901",
		// "http://www.eclipse.org/uml2/4.0.0/UML"));
		// }
		// br.close();
		pw.close();
	}

}
