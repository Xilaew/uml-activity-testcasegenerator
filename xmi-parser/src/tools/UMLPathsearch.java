package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import util.Messages;
import data.ActivityPath;
import data.ConstraintMap;
import data.ConstraintMapImpl;
import data.YouShallNotDoThisException;

public class UMLPathsearch extends AbstractTool {

	static ConstraintMap constraintMap = new ConstraintMapImpl();

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws Exception {
		readCmdArgs(args);

		// read Model
		Model model = (Model) load(inFile).get(0);
		out("ModelName: " + model.getName()); //$NON-NLS-1$

		// select one activity
		Activity activity = selectActivity(model);
		System.out.println("you selected: " + activity.getLabel()); //$NON-NLS-1$

		for (NamedElement e : activity.getMembers()) {
			System.out.println(e);
			if (e instanceof Constraint) {
				out("\t" //$NON-NLS-1$
						+ ((Constraint) e).getConstrainedElements());
				for (Element constrainee : ((Constraint) e)
						.getConstrainedElements()) {
					constraintMap.put(constrainee, (Constraint) e);
				}
			}
		}
		findPath(activity);
		
	}


	protected static ActivityPath findPath(Activity a) {
		EList<ActivityNode> nodes = a.getOwnedNodes();
		ActivityNode currentNode = null;
		ActivityPath path = new ActivityPath();
		out("there are " + nodes.size() //$NON-NLS-1$
				+ " Nodes in the activity"); //$NON-NLS-1$
		try {
			// find an initial Node in the activity
			for (ActivityNode n : nodes) {
				if (n instanceof InitialNode) {
					currentNode = (InitialNode) n;
					path.setInitialNode((InitialNode) n);
				}
				break;
			}
			if (currentNode == null) {
				err(Messages.getString("Error.INITIAL_NODE_NOT_FOUND")); //$NON-NLS-1$
				System.exit(-1);
			}

			do {
				out("Node: " + currentNode.getLabel()); //$NON-NLS-1$
				// StringExpression it = currentNode.getNameExpression();
				if (constraintMap.get(currentNode) != null) {
					for (Constraint c : constraintMap.get(currentNode)) {
						System.out.println(c);
						for (EObject o : c.getOwnedElements()) {
							System.out.println("\t" + o); //$NON-NLS-1$
							for (String s : ((OpaqueExpression) o).getBodies()) {
								System.out.print(s);
							}
							System.out.println();
						}
					}
				}
				// System.out.println(it);

				for (ActivityEdge edge : currentNode.getOutgoings()) {
					if (edge instanceof ControlFlow) {
						path.add((ControlFlow) edge);
						out("Edge: " + edge.getName()); //$NON-NLS-1$
						for (EObject e : edge.eContents()) {
							out(e.toString());
							for (String s : ((OpaqueExpression) e).getBodies()) {
								out(s);
							}
						}
						out("");
						currentNode = edge.getTarget();
						break;
					}
				}

			} while (!(currentNode instanceof FinalNode));
		} catch (YouShallNotDoThisException e) {
			e.printStackTrace();
		}
		return path;
	}

	protected static Activity selectActivity(Model model)
			throws NumberFormatException, IOException {
		EList<Activity> activitys = new BasicEList<Activity>();
		int i = 0;
		for (EObject e : model.allOwnedElements()) {
			if (e instanceof Package) {
				System.out.println("Package: " + ((Package) e).getName()); //$NON-NLS-1$
			}
			if (e instanceof Activity) {
				Activity a = (Activity) e;
				activitys.add(a);
				System.out.println((i++) + "\t" + a.getName()); //$NON-NLS-1$
			}
		}
		System.out.println(Messages.getString("Message.SELECT_ACTIVITY")); //$NON-NLS-1$
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
			System.out.println(entry.getKey() + ": " + entry.getValue()); //$NON-NLS-1$
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
					System.out.println("\t" + o2); //$NON-NLS-1$
				}
			}
		}
		return (Model) resource.getContents().get(0);
	}

}
