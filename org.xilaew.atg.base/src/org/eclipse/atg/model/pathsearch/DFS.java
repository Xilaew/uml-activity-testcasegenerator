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

public class DFS extends AbstractPathSearch implements PathSearch {
	
	public EList<Path> findAllPaths(AbstractTCGContainer atcg){
		EList<Path> result = new BasicEList<Path>();
		Deque<AbstractTCGEdge> stack = new ArrayDeque<AbstractTCGEdge>();
		
		stack.addAll(atcg.getInitialNode().getOutgoing());
		AbstractTCGNode currentNode = atcg.getInitialNode();
		AbstractTCGEdge currentEdge ;
		Path currentPath = TestCaseGraphRuntimeFactory.eINSTANCE.createPath();
		while(!stack.isEmpty()){
			currentEdge = stack.removeFirst();
			while(!currentEdge.getSource().equals(currentNode)){
				//retreat
				currentNode = currentPath.getEdges().remove(currentPath.getEdges().size()-1).getSource();
			}
			currentNode = currentEdge.getTarget();
			currentPath.getEdges().add(currentEdge);
			for(AbstractTCGEdge outgoing:currentNode.getOutgoing()){
				stack.addFirst(outgoing);
			}
			if(currentNode.getOutgoing().size()==0){
				//found final node -> Add path to result
				result.add(currentPath);
				currentPath = TestCaseGraphRuntimeFactory.eINSTANCE.createPath();
				for(AbstractTCGEdge e:result.get(result.size()-1).getEdges()){
					currentPath.getEdges().add(e);
				}
			}
		}
		return result;
	}

	@Override
	public void setProperties(Properties p) {
		
	}

}
