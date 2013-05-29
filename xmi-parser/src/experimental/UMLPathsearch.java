package experimental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class UMLPathsearch {

	static String inFile;

	static final String ERROR_NO_INPUTFILE_SPECIFIED = "Please supply inputfile as command line argument";

	static Map<EObject, EList<Constraint>> constraintMap = new HashMap<EObject, EList<Constraint>>();

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		if (args.length < 1) {
			System.err.println(ERROR_NO_INPUTFILE_SPECIFIED);
			System.exit(-1);
		}
		inFile = args[0];

		Model model = load(URI.createFileURI(inFile));
		System.out.println("ModelName: " + model.getName());
		System.out.println("Packages:");
		Activity activity = selectActivity(model);
		System.out.println("you selected: " + activity.getLabel());
		for (NamedElement e : activity.getMembers()) {
			System.out.println(e);
			if (e instanceof Constraint) {
				System.out.println("\t"
						+ ((Constraint) e).getConstrainedElements());
				for (EObject constrainee : ((Constraint) e)
						.getConstrainedElements()) {
					if (constraintMap.containsKey(constrainee)) {
						constraintMap.get(constrainee).add((Constraint) e);
					} else {
						BasicEList<Constraint> l = new BasicEList<Constraint>();
						l.add((Constraint) e);
						constraintMap.put(constrainee, l);
					}
				}
				((NamedElement) ((Constraint) e).getConstrainedElements()
						.get(0)).createNameExpression(((Constraint) e)
						.getSpecification().stringValue(), null);
			}
		}
		findPath(activity);
	}

	protected static EList<Constraint> getAppliedConstraints(
			ActivityNode currentNode) {
		return constraintMap.get(currentNode);
	}

	protected static void findPath(Activity a) {
		EList<ActivityNode> nodes = a.getOwnedNodes();
		ActivityNode currentNode = null;
		System.out.println("there are " + nodes.size()
				+ " Nodes in the activity");
		for (ActivityNode n : nodes) {
			if (n instanceof InitialNode) {
				currentNode = (InitialNode) n;
				break;
			}
		}
		if (currentNode == null) {
			System.err.println("No Initial Node Found in Activity");
			System.exit(-1);
		}
		do {
			System.out.println("Node: " + currentNode.getLabel());
			// StringExpression it = currentNode.getNameExpression();
			if (getAppliedConstraints(currentNode) != null) {
				for (Constraint c : getAppliedConstraints(currentNode)) {
					System.out.println(c);
					for (EObject o : c.getOwnedElements()) {
						System.out.println("\t" + o);
						for (String s : ((OpaqueExpression) o).getBodies()) {
							System.out.print(s);
						}
						System.out.println();
					}
				}
			}
			// System.out.println(it);
			ActivityEdge edge = currentNode.getOutgoings().get(0);
			System.out.println("Edge: " + edge.getName());
			for (EObject e : edge.eContents()) {
				System.out.println(e.toString());
				for (String s : ((OpaqueExpression) e).getBodies()) {
					System.out.print(s);
				}
			}
			System.out.println();
			currentNode = edge.getTarget();
		} while (!(currentNode instanceof FinalNode));

	}

	protected static Activity selectActivity(Model model)
			throws NumberFormatException, IOException {
		EList<Activity> activitys = new BasicEList<Activity>();
		int i = 0;
		for (EObject e : model.allOwnedElements()) {
			if (e instanceof Package) {
				System.out.println("Package: " + ((Package) e).getName());
			}
			if (e instanceof Activity) {
				Activity a = (Activity) e;
				activitys.add(a);
				System.out.println((i++) + "\t" + a.getName());
			}
		}
		System.out.println("Pleas select an Activity!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return activitys.get(Integer.parseInt(br.readLine()));
	}

	protected static Model load(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resourceSet.createResource(uri);
		for (Entry<String, Object> entry : resourceSet
				.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		try {
			System.out.println(resource);
			resource.load(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		System.out.println(resource.getContents().size());
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof Activity) {
				System.out.println(o);
				Iterator<EObject> it2 = o.eAllContents();
				while (it2.hasNext()) {
					EObject o2 = it2.next();
					System.out.println("\t" + o2);
				}
			}
		}
		return (Model) resource.getContents().get(0);
	}

}
