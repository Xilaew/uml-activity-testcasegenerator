package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import util.Messages;
import data.ActivityPath;
import data.ConstraintMap;
import data.YouShallNotDoThisException;

public class UMLPathsearch extends AbstractTool {

	static ConstraintMap constraintMap = ConstraintMap.INSTANCE;

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

		out("The following Members were found within the selected Activity");
		for (NamedElement e : activity.getMembers()) {
			out(e.toString());
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

	/**
	 * finds a control flow path from an initial node to a FinalNode within an
	 * activity
	 * 
	 * @param activity
	 *            an activity in which a path should be found
	 * @return an inmodifiable ActivityPath instance representing the found path
	 * @see ActivityPath
	 */
	protected static ActivityPath findPath(Activity activity) {
		EList<ActivityNode> nodes = activity.getOwnedNodes();
		ActivityNode currentNode = null;
		ActivityPath path = new ActivityPath();
		out("there are " + nodes.size() //$NON-NLS-1$
				+ " Nodes in the activity"); //$NON-NLS-1$
		try {
			// find an initial Node in the activity
			for (ActivityNode n : nodes) {
				if (n instanceof InitialNode) {
					currentNode = (InitialNode) n;
					path.setStartNode((InitialNode) n);
				}
				break;
			}
			// initial node found?
			if (currentNode == null) {
				err(Messages.getString("Error.INITIAL_NODE_NOT_FOUND")); //$NON-NLS-1$
				System.exit(-1);
			}
			// print Path
			out("A valid path through the activity is:");
			do {
				// node and its linked constraints
				out("Node: " + currentNode.getLabel()); //$NON-NLS-1$
				if (constraintMap.get(currentNode) != null) {
					for (Constraint c : constraintMap.get(currentNode)) {
						out(c.toString());
						for (EObject o : c.getOwnedElements()) {
							out("\t" + o); //$NON-NLS-1$
							String expression = new String();
							for (String s : ((OpaqueExpression) o).getBodies()) {
								expression = expression.concat(s);
							}
							out(expression);
						}
					}
				}

				// edge and its guard conditions
				for (ActivityEdge edge : currentNode.getOutgoings()) {
					if (edge instanceof ControlFlow) {
						path.add((ControlFlow) edge);
						out("Edge: " + edge.getName()); //$NON-NLS-1$
						for (EObject e : edge.eContents()) {
							out(e.toString());
							String expression = new String();
							for (String s : ((OpaqueExpression) e).getBodies()) {
								expression = expression.concat(s);
							}
							out(expression);
						}
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

	protected static Activity selectActivity(Model model) {
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
		Activity ret = null;
		for (int i1 = 3; i1 > 0; i1--) {
			try {
				ret = activitys.get(Integer.parseInt(br.readLine()));
				break;
			} catch (NumberFormatException e1) {
				out(Messages.getString("Message.SELECT_ACTIVITY"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return ret;
	}

	protected static void fillConstraintMap(Activity activity){
		for (NamedElement e : activity.getMembers()) {
			out(e.toString());
			if (e instanceof Constraint) {
				out("\t" //$NON-NLS-1$
						+ ((Constraint) e).getConstrainedElements());
				for (Element constrainee : ((Constraint) e)
						.getConstrainedElements()) {
					constraintMap.put(constrainee, (Constraint) e);
				}
			}
		}
	}
}
