package experimental;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.internal.resource.XMI2UMLResourceImpl;
import org.eclipse.uml2.uml.resource.*;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class ResourceFactorys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		load(org.eclipse.emf.common.util.URI.createFileURI("./someActivitys.xmi"));
	}

	protected static EObject load(org.eclipse.emf.common.util.URI uri) {
		//ResourceSet resourceSet = new ResourceSetImpl();
		//UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = new XMIResourceImpl(uri);
		EPackage.Registry packageRegistry = EPackage.Registry.INSTANCE;

		try {
			System.out.println(resource);
			resource.load(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		System.out.println(resource.getContents().size());
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext()){
			EObject o = it.next();
			if (o instanceof Activity){
				System.out.println(o);
				Iterator<EObject> it2 = o.eAllContents();
				while (it2.hasNext()){
					EObject o2 = it2.next();
					System.out.println("\t"+o2);
				}
			}
		}
		return resource.getContents().get(0);
	}
}
