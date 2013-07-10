package com.airbus.artisanuml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import tools.AbstractTool;

/**
 * Tool to convert xmi files exportet by Artisan Studio into .uml files suitable
 * for the eclipse UML Framework
 * 
 * @author Felix Kurth
 * 
 */
public class ArtisanXMI2UML extends AbstractTool {

	static final String tmpFile = "./tmp.uml";

	public static void convert(String inFile, String outFile) {
		EList<? extends EObject> model = load(inFile);
//		AnyType xmlModel = (AnyType) model.get(1);
//		out(xmlModel.eClass().getEAllStructuralFeatures().toString());
//		
//		Iterator<EObject> it = model.get(1).eAllContents();
//		EStructuralFeature ownedRule ;
//		while(it.hasNext()){
//			EObject o = it.next();
//			//out(o.toString());
//			if (o.eContainmentFeature().getName().equals("ownedRule")){
//				EcoreFactory factory = EcoreFactory.eINSTANCE;
//				EStructuralFeature  f = factory.eContainmentFeature();
//				//f.setName("localPostcondition");
//				ownedRule = o.eContainmentFeature();
//				if (ownedRule!=null)out(o.eContainer().eGet(ownedRule).toString());
//				org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList<?> xml = (org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList<?>) o.eContainer().eGet(ownedRule);
////				xml.getAny().add(Entry)
//				ownedRule = o.eContainingFeature();
//				if (ownedRule!=null)out(o.eContainer().eGet(ownedRule).toString());
//
//			out("." + o.eClass().toString() /*.getInstanceTypeName()+": "+o.eClass().getInstanceClassName()*/);
//				out(o.eContainingFeature().toString());
//				out(o.eContainmentFeature().toString());
//			}
////			o.eClass().eContainingFeature()
////			o.eContainmentFeature().setName("localPostcondition");
////			o.eContainmentFeature().setDefaultValueLiteral("localPostcondition");
//			//out(o.eClass().getEAllContainments().size()+"");
////			out(out);
////			EStructuralFeature feature = UMLEnvironmentFactory.
////			o.eContainer().eSet(feature, newValue)
//		}
		out(model.get(0).toString());
		out("-----------------------");
		out(model.get(1).toString());
		model.remove(0);

		save(model, tmpFile);
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(tmpFile),
					Charset.forName("UTF-8"));
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter(outFile));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		readCmdArgs(args);

		convert(inFile, outFile);
		
		//TODO this conversion should be possible in the first go
		EList<? extends EObject> model = load(outFile);
		Constraint2LocalPostconditionHelper.convert((org.eclipse.uml2.uml.Package)model.get(0));
		save(model, outFile);
	}

}
