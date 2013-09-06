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

import data.YouShallNotDoThisException;

public class BoundedDFS implements PathSearch {
	int maxDepth = -1;
	int maxNoPaths = -1;

	public EList<Path> findAllPaths(AbstractTCGContainer atcg) {
		EList<Path> result = new BasicEList<Path>();
		Deque<Pair> stack = new ArrayDeque<Pair>();

		for (AbstractTCGEdge edge : atcg.getInitialNode().getOutgoing()) {
			stack.add(new Pair(edge, new Integer(0)));
		}
		AbstractTCGNode currentNode = atcg.getInitialNode();
		Pair currentEdge;
		Path currentPath = TestCaseGraphRuntimeFactory.eINSTANCE.createPath();
		while (!stack.isEmpty()
				&& (result.size() <= maxNoPaths || maxNoPaths == -1)) {
			currentEdge = stack.removeFirst();
			while (currentEdge.getSecond() != currentPath.getEdges().size()) {
				EList<AbstractTCGEdge> l = currentPath.getEdges();
				AbstractTCGEdge e = l.remove(l.size() - 1);
				// retreat
				currentNode = e.getSource();
			}
			if (!currentNode.equals(currentEdge.getFirst().getSource())) {
				try {
					throw new YouShallNotDoThisException("bullshit");
				} catch (YouShallNotDoThisException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			;
			currentNode = currentEdge.getFirst().getTarget();
			currentPath.getEdges().add(currentEdge.getFirst());
			if (currentPath.getEdges().size() <= maxDepth) {
				for (AbstractTCGEdge outgoing : currentNode.getOutgoing()) {
					stack.addFirst(new Pair(outgoing, new Integer(currentPath
							.getEdges().size())));
				}
			}
			if (currentNode.getOutgoing().size() == 0) {
				// found final node -> Add path to result
				result.add(currentPath);
				currentPath = TestCaseGraphRuntimeFactory.eINSTANCE
						.createPath();
				for (AbstractTCGEdge e : result.get(result.size() - 1)
						.getEdges()) {
					currentPath.getEdges().add(e);
				}
			}
		}
		return result;
	}

	@Override
	public void setProperties(Properties p) {
		try {
			maxDepth = Integer.parseInt(p.getProperty(PROPERTY_MAX_PATHLENGTH));
		} catch (NumberFormatException e) {
			maxDepth = -1;
		}
		try {
			maxNoPaths = Integer.parseInt(p.getProperty(PROPERTY_MAX_NO_PATHS));
		} catch (NumberFormatException e) {
			maxNoPaths = -1;
		}
	}

}
