package data;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;

import util.Messages;

/**
 * A data structure that can be used to represent one control flow in an
 * Activity. A control flow path is uniquely defined by an initial node and an
 * ordered list of consecutive control flow edges. The last control flow edge
 * needs to end in a Final Node.
 * 
 * @author Felix Kurth
 */
public class ActivityPath {
	// TODO implement function to return read only iterator through nodes and
	// edges.

	EList<ControlFlow> edges = new BasicEList<ControlFlow>();
	FinalNode finalNode;
	InitialNode startNode;
	ActivityNode currentNode;

	public boolean add(ControlFlow o) throws YouShallNotDoThisException {
		// final Node is already set. ->ActivityPath is unmodifiable
		if (finalNode != null) {
			throw new YouShallNotDoThisException(
					Messages.getString("ErrorMessage.FINAL_NODE_ALREADY_SET")); //$NON-NLS-1$
		}
		// check for adjacency
		if (!(edges.size() == 0 && o.getSource().equals(startNode))
				&& !(o.getSource().equals(edges.get(edges.size() - 1)
						.getTarget()))) {
			throw new YouShallNotDoThisException(
					Messages.getString("ErrorMessage.EDGES_NOT_ADJACENT")); //$NON-NLS-1$
		}
		// Path ends here
		if (o.getTarget() instanceof FinalNode) {
			finalNode = (FinalNode) o.getTarget();
		}
		return edges.add(o);
	}

	public FinalNode getFinalNode() {
		return finalNode;
	}

	public InitialNode getInitialNode() {
		return startNode;
	}

	public void setInitialNode(InitialNode start)
			throws YouShallNotDoThisException {
		if (startNode != null) {
			throw new YouShallNotDoThisException(
					Messages.getString("ErrorMessages.INITIAL_NODE_ALREADY_SET")); //$NON-NLS-1$
		}
		this.startNode = start;
	}
}
