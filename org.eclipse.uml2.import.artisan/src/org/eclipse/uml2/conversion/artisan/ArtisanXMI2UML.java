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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xml.type.impl.AnyTypeImpl;
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

	public static void convert(InputStream in, OutputStream out)
			throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", UMLResource.Factory.INSTANCE);
		UMLResourcesUtil.init(RESOURCE_SET); // MDT/UML2 4.0.0 (Juno)
		Resource inResource = RESOURCE_SET.createResource(URI
				.createURI("org.xilaew.test.xmi"));
		Resource outResource = RESOURCE_SET.createResource(URI
				.createURI("org.xilaew.test.uml"));
		try {
			inResource.load(in, null);
		} catch (IOException ioe) {
			err(ioe.getMessage());
		}
		AnyTypeImpl model = (AnyTypeImpl) inResource.getContents().get(1);
		out(model.toString());
		outResource.getContents().add(model);
		
		// Add all contents from model to outputResource
		// Do not import Profiles from Artisan Studio, since they are Buggy
		// as Hell
		for (Entry topLevelPackage : model.getAny()) {
			if (topLevelPackage.getValue() instanceof AnyTypeImpl) {
				AnyTypeImpl topLevelPackageAny = (AnyTypeImpl) topLevelPackage.getValue();
				FeatureMap f = topLevelPackageAny.getAnyAttribute();
				boolean profilesFound = false;
				for (Entry e : f) {
					out(e.getEStructuralFeature().getName()
							+ " = " + e.getValue());
					out(e.getEStructuralFeature().toString());
					if (e.getEStructuralFeature().getName().equals("name")) {
						if (e.getValue().equals("Profiles")) {
							profilesFound = true;
							break;
						}
					}
				}
				if (profilesFound) {
					model.getAny().remove(model.getAny().indexOf(topLevelPackage));
					break;
				}
			}
		}

		ByteArrayOutputStream out1 = new ByteArrayOutputStream();
		outResource.save(out1, null);
		out1.close();
		
		// Fix external References Line by Line
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(out1.toByteArray()), "UTF-8"));
			String s1;
			while ((s1 = r.readLine()) != null) {
				lines.add(s1);
			}
			PrintWriter pw;
			pw = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
			for (String s : lines) {
				// Primitive Datatype references
				s = s.replace("http://www.omg.org/spec/UML/20090901/UML.xmi",
						"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml");
				// References to UML Profile
				s = s.replace(
						"http://www.omg.org/spec/UML/20090901/StandardProfileL2.xmi",
						"pathmap://UML_PROFILES/StandardL2.profile.uml");
				// References to SysML profile
				s = s.replace(
						"http://www.omg.org/spec/SysML/20100301/SysML-profile.uml#_0",
						"pathmap://SysML_PROFILES/SysML.profile.uml#_TZ_nULU5EduiKqCzJMWbGw");
				// stupid Artisan Typos
				s = s.replace(
						"(<ownedLiteral xmi:type=\"uml:EnumerationLiteral\".*?)classifier=\".*?\"(>)",
						"$1$2");
				s = s.replace("visibility=\"Private\"",
						"visibility=\"private\"");				
				s = s.replace("xmi:type=\"uml:DatastoreNode\"",
								"xmi:type=\"uml:DataStoreNode\"");
				// fix UML Namespace
				s = s.replace(
						"http://www.omg.org/spec/UML/20090901",
						"http://www.eclipse.org/uml2/4.0.0/UML");
				// fix XMI Namespace
				s = s.replace(
						"http://schema.omg.org/spec/XMI/2.1",
						"http://www.omg.org/spec/XMI/20110701");
				pw.println(s);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		readCmdArgs(args);
		convert(new FileInputStream(inFile), new FileOutputStream(outFile));
	}

}
