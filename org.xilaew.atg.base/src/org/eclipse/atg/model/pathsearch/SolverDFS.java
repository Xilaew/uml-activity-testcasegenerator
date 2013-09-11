package org.eclipse.atg.model.pathsearch;

import java.util.ArrayDeque;
import java.util.Deque;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.xilaew.amplCLI.JAMPL.SolveResult;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimeFactory;
import org.xilaew.atg.transformations.actTCG2ampl.Path2AMPLData;
import org.xilaew.atg.transformations.actTCG2ampl.ActTCG2AMPLModel;

public class SolverDFS extends AbstractSolverIntegratedPathSearch {

	@Override
	public EMap<Path, Witness> findAllSatisfiableActivityPaths(TCGActivity atcg) {
		EMap<Path, Witness> result = new BasicEMap<Path, Witness>();
		Deque<Pair> stack = new ArrayDeque<Pair>();
		ampl.setSolver(solver);
		ampl.loadModel(ActTCG2AMPLModel.transform(atcg));
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
			currentNode = currentEdge.getFirst().getTarget();
			currentPath.getEdges().add(currentEdge.getFirst());
			if (currentPath.getEdges().size() % 3 == 0) {
				ampl.loadData(Path2AMPLData.transform(currentPath));
				SolveResult solved = ampl.solve();
				if (solved == SolveResult.Failure
						|| solved == SolveResult.Infeasable) {
					continue;
				}
			}
			if (currentPath.getEdges().size() <= maxDepth) {
				// add child nodes to Stack
				for (AbstractTCGEdge outgoing : currentNode.getOutgoing()) {
					stack.addFirst(new Pair(outgoing, new Integer(currentPath
							.getEdges().size())));
				}
			}
			if (currentNode.getOutgoing().size() == 0) {
				// found final node -> Add path to result
				// fill witness with data.
				Witness witness = generateWitness(currentPath, atcg);
				if (witness != null) {
					result.put(currentPath, witness);
					Path newCurrentPath = TestCaseGraphRuntimeFactory.eINSTANCE
							.createPath();
					for (AbstractTCGEdge e : currentPath.getEdges()) {
						newCurrentPath.getEdges().add(e);
					}
					currentPath = newCurrentPath;
				}
			}
		}
		return result;
	}

	/**
	 * solves the constraint system for a given Path and returns a Witness
	 * containing a complete execution trace for the given Path. The returned
	 * Witness can directly be used as test data.
	 * 
	 * @param currentPath
	 * @return Witness of the satisfiability of the given Path
	 */
	private Witness generateWitness(Path currentPath, TCGActivity atcg) {
		ampl.loadData(Path2AMPLData.transform(currentPath));
		Witness result = new Witness();
		SolveResult solved = ampl.solve();
		if (solved == SolveResult.Failure || solved == SolveResult.Infeasable) {
			return null;
		}
		for (TCGVariable var : atcg.getVariables()) {
			if (var instanceof TCGBasicVariable) {
				TCGBasicVariable basicVar = (TCGBasicVariable) var;
				if (basicVar.isIsParameter()) {
					EList<Double> par = new BasicEList<Double>();
					par.add(ampl.getParameter(basicVar.getName()));
					result.put(basicVar, par);
				} else {
					result.put(basicVar, ampl.getVariable(basicVar.getName()));
				}
			}
		}
		return result;
	}

}
