package org.eclipse.uml2.conversion.artisan;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import tools.AbstractTool;

/**
 * Tool to convert xmi files exportet by Artisan Studio into .uml files suitable
 * for the eclipse UML Framework
 * 
 * @author Felix Kurth
 * 
 */
public class ArtisanXMI2UML extends AbstractTool {

	static final String tmpFile = "./umlconverter.tmp";

	public static void convert(InputStream in , OutputStream out) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", UMLResource.Factory.INSTANCE);
		UMLResourcesUtil.init(RESOURCE_SET); // MDT/UML2 4.0.0 (Juno)
		Resource resource = RESOURCE_SET.createResource(URI.createURI("org.xilaew.test.xmi"));
		try {
			resource.load(in,null);
		} catch (IOException ioe) {
			err(ioe.getMessage());
		}
		EList<EObject> model = resource.getContents();
		out(model.get(0).toString());
		out("-----------------------");
		out(model.get(1).toString());
		model.remove(0);
		ByteArrayOutputStream out1 = new ByteArrayOutputStream();
		//ByteArrayOutputStream out2 = new ByteArrayOutputStream();

		resource.save(out1,null);
		out1.close();
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(out1.toByteArray()),"UTF-8"));
			String s1;
			while((s1=r.readLine()) != null){
				lines.add(s1);
			}
			PrintWriter pw;
			pw = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
			for (String s : lines) {
				// UML Namespace
				s = s.replace(
						"xmlns:uml=\"http://www.omg.org/spec/UML/20090901\"",
						"xmlns:uml = \"http://www.eclipse.org/uml2/4.0.0/UML\"");
				// Primitive Datatype references
				s = s.replace("http://www.omg.org/spec/UML/20090901/UML.xmi",
						"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml");
				// References to UML Profile
				s = s.replace(
						"http://www.omg.org/spec/UML/20090901/StandardProfileL2.xmi",
						"pathmap://UML_PROFILES/StandardL2.profile.uml");

				pw.println(s);
			}
			pw.close();
			//Files.deleteIfExists(Paths.get(tmpFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		resource = RESOURCE_SET.createResource(URI.createURI("umlFile.uml"));
//		
//		resource.load(new ByteArrayInputStream(out2.toByteArray()), null);
//		model = resource.getContents();
//		Constraint2LocalPostconditionHelper
//				.convert((org.eclipse.uml2.uml.Package) model.get(0));
//		resource.save(out, null);
	}
	
	
	public static void main(String[] args) throws IOException {
		readCmdArgs(args);

		convert(new FileInputStream(inFile), new FileOutputStream(outFile));
		
	}

}
