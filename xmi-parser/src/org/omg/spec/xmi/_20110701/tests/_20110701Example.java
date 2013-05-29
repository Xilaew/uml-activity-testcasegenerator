/**
 */
package org.omg.spec.xmi._20110701.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import org.omg.spec.xmi._20110701.Add;
import org.omg.spec.xmi._20110701.DocumentRoot;
import org.omg.spec.xmi._20110701._20110701Factory;
import org.omg.spec.xmi._20110701._20110701Package;

import org.omg.spec.xmi._20110701.util._20110701ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> A sample utility for the '<em><b>_20110701</b></em>'
 * package. <!-- end-user-doc -->
 * 
 * @generated
 */
public class _20110701Example {
	/**
	 * <!-- begin-user-doc --> Load all the argument file paths or URIs as
	 * instances of the model. <!-- end-user-doc -->
	 * 
	 * @param args
	 *            the file paths or URIs.
	 * @generated
	 */
	public static void main(String[] args) {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		//
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMLResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put(_20110701Package.eNS_URI,
				_20110701Package.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				"http://www.omg.org/spec/UML/20090901", UMLPackage.eINSTANCE);
		UMLResourcesUtil.init(resourceSet);

		// If there are no arguments, emit an appropriate usage message.
		//
		if (args.length == 0) {
			System.out
					.println("Enter a list of file paths or URIs that have content like this:");
			try {
				Resource resource = resourceSet.createResource(URI
						.createURI("http:///My._20110701"));
				DocumentRoot documentRoot = _20110701Factory.eINSTANCE
						.createDocumentRoot();
				Add root = _20110701Factory.eINSTANCE.createAdd();
				documentRoot.setAdd(root);
				resource.getContents().add(documentRoot);
				resource.save(System.out, null);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} else {
			// Iterate over all the arguments.
			//
			for (int i = 0; i < args.length; ++i) {
				// Construct the URI for the instance file.
				// The argument is treated as a file path only if it denotes an
				// existing file.
				// Otherwise, it's directly treated as a URL.
				//
				File file = new File(args[i]);
				URI uri = file.isFile() ? URI.createFileURI(file
						.getAbsolutePath()) : URI.createURI(args[i]);

				try {
					// Demand load resource for this file.
					//
					Resource resource = resourceSet.getResource(uri, true);
					System.out.println("Loaded " + uri);

					// Validate the contents of the loaded resource.
					//
					for (EObject eObject : resource.getContents()) {
						Diagnostic diagnostic = Diagnostician.INSTANCE
								.validate(eObject);
						if (diagnostic.getSeverity() != Diagnostic.OK) {
							printDiagnostic(diagnostic, "");
						}
					}
					DocumentRoot root = (DocumentRoot) resource.getContents().get(0);
					System.out.println(root.getDocumentation());
					System.out.println(root.getMixed().toArray());
					Iterator<EObject> it =resource.getAllContents();
					while (it.hasNext()){
						System.out.println(it.next());
					}
				} catch (RuntimeException exception) {
					System.out.println("Problem loading " + uri);
					exception.printStackTrace();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> Prints diagnostics with indentation. <!--
	 * end-user-doc -->
	 * 
	 * @param diagnostic
	 *            the diagnostic to print.
	 * @param indent
	 *            the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} // _20110701Example
