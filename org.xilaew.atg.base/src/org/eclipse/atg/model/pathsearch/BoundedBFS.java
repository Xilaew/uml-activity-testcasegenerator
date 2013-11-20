package org.eclipse.atg.model.pathsearch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Properties;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimeFactory;

public class BoundedBFS extends AbstractPathSearch implements PathSearch {

	int maxDepth = -1;
	int maxNoPaths = -1;

	public EList<Path> findAllPaths(AbstractTCGContainer atcg) {
		EList<Path> result = new BasicEList<Path>();
		Deque<SearchTree> stack = new ArrayDeque<SearchTree>();
		for (AbstractTCGEdge e : atcg.getInitialNode().getOutgoing()) {
			stack.addLast(new SearchTree(e, null, 0));
		}
		AbstractTCGNode currentNode = atcg.getInitialNode();
		AbstractTCGEdge currentEdge;
		SearchTree currentElement;
		while (!stack.isEmpty() && (result.size() <= maxNoPaths || maxNoPaths==-1)) {
			currentElement = stack.removeFirst();
			currentEdge = currentElement.edge;
			currentNode = currentEdge.getTarget();

			if (currentElement.depth < maxDepth || maxDepth==-1) {
				for (AbstractTCGEdge outgoing : currentNode.getOutgoing()) {
					stack.addLast(new SearchTree(outgoing, currentElement,
							currentElement.depth + 1));
				}
			}
			if (currentNode.getOutgoing().size() == 0) {
				// found final node -> Add path to result
				Path resultPath = TestCaseGraphRuntimeFactory.eINSTANCE
						.createPath();
				do {
					resultPath.getEdges().add(0, currentElement.edge);
					currentElement = currentElement.predecessor;
				} while (currentElement != null);
				result.add(resultPath);
			}
		}
		return result;
	}

	@Override
	public void setProperties(Properties p) {
		try {
			maxDepth = Integer.parseInt(p.getProperty(PROPERTY_MAX_PATHLENGTH));
		} catch (NumberFormatException e) {
			maxDepth=-1;
		}
		try {
			maxNoPaths = Integer.parseInt(p.getProperty(PROPERTY_MAX_NO_PATHS));
		} catch (NumberFormatException e) {
			maxNoPaths=-1;
		}
	}
}
