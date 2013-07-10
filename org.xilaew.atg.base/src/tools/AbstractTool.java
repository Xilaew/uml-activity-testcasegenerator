package tools;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import util.Messages;

/**
 * Base Class for all stand alone UML Tools providing some Basic functionality
 * like saving and loading Models and management of Debug output.
 * 
 * @author Felix Kurth
 * 
 */
public abstract class AbstractTool {

	/**
	 * When this flag is set to true debug output will be printed to the console
	 * otherwise not
	 */
	public static boolean DEBUG = true;

	/**
	 * after {@link #readCmdArgs(String[])} has been called this field is considered to hold the filename of the input file
	 */
	protected static String inFile;

	/**
	 *  after {@link #readCmdArgs(String[])} has been called this field is considered to hold the filename of the output file
	 */	
	protected static String outFile;

	/**
	 * Use this resource set to access resources (xmi or uml files)
	 */
	protected static final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	/**
	 * Prints out error messages to the error console
	 * 
	 * @param error
	 *            the error message to be displayed
	 */
	protected static void err(String error) {
		System.err.println(error);
	}

	/**
	 * Loads a model from an XMI file into the memory
	 * 
	 * @param filename
	 *            an XMI file containing a Model
	 * @return List of the root objects in the model
	 */
	protected static EList<? extends EObject> load(String fileName) {
		URI uri = URI
				.createFileURI(fileName);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", UMLResource.Factory.INSTANCE);
		UMLResourcesUtil.init(RESOURCE_SET); // MDT/UML2 4.0.0 (Juno)
		Resource resource = RESOURCE_SET.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException ioe) {
			err(ioe.getMessage());
		}
		out("successfully loaded \'" + uri + "\' :\t" + resource.getContents().size() + " toplevel EObjects found"); //$NON-NLS-1$
		return (EList<? extends EObject>) resource.getContents();
	}

	/**
	 * Prints arbitrary output to the screen if the DEBUG flag is set
	 * 
	 * @see #DEBUG
	 * @param error
	 *            debug output to be printed
	 */
	protected static void out(String output) {
		if (DEBUG) {
			System.out.println(output);
		}
	}

	/**
	 * interprets command line input and sets fields accordingly. this might be the first function you want to call in your program.
	 * Currently commanline arguments can have the following format
	 * inputFilename [outputFilename [OPTIONS]]
	 * available Options: -noDebug (disable Debug output)
	 * @param args siply pass on the args from the main
	 */
	protected static void readCmdArgs(String[] args) {
		if (args.length < 1) {
			err(Messages.getString("ErrorMessage.NO_INPUT_FILE_SPECIFIED"));
			System.exit(-1);
		}
		inFile = args[0];
		outFile = args.length > 1 ? args[1] : "out.uml"; 
		for(String s : args){
			if(s.equals("-noDebug"))DEBUG=false;
		}
	}

	/**
	 * Writes a Model from Memory to an XMI file
	 * 
	 * @param model
	 *            list containing toplevel model elements to be saved as XMI file
	 * @param filename
	 *            file to write the Model to
	 */
	protected static void save(EList<? extends EObject> model, String fileName) {
		UMLResourcesUtil.init(RESOURCE_SET); // MDT/UML2 4.0.0 (Juno)
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		Resource resource = RESOURCE_SET.createResource(URI
				.createFileURI(fileName));
		resource.getContents().addAll(model);

		try {
			resource.save(null);
		} catch (IOException ioe) {
			err(ioe.getMessage());
		}
	}

}
