package org.eclipse.atg.model.pathsearch;

import java.util.ArrayDeque;
import java.util.Date;
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
		int passedDecisions = 0;
		for (AbstractTCGEdge edge : atcg.getInitialNode().getOutgoing()) {
			stack.add(new Pair(edge, new Integer(0)));
		}
		AbstractTCGNode currentNode = atcg.getInitialNode();
		Pair currentEdge;
		Path currentPath = TestCaseGraphRuntimeFactory.eINSTANCE.createPath();
		while (!stack.isEmpty()
				&& (result.size() <= maxNoPaths || maxNoPaths == -1)) {
			currentEdge = stack.removeFirst();
			// backtrack
			while (currentEdge.getSecond() != currentPath.getEdges().size()) {
				// System.out.println("BACKTRACK");
				EList<AbstractTCGEdge> l = currentPath.getEdges();
				AbstractTCGEdge e = l.remove(l.size() - 1);
				currentNode = e.getSource();
				passedDecisions = 0;
			}
			currentNode = currentEdge.getFirst().getTarget();
			currentPath.getEdges().add(currentEdge.getFirst());

			if (currentPath.getEdges().size() <= maxDepth || maxDepth == -1) {
				// check every 3 or 4 decisions whether the path is still
				// feasible
				if (currentNode.getOutgoing().size() >= 2) {
					passedDecisions++;
					if (passedDecisions > uncheckedSteps) {
						passedDecisions = 0;
						ampl.loadData(Path2AMPLData.transform(currentPath));
						SolveResult solved = ampl.solve();
						totalSolves++;
						if (solved == SolveResult.Infeasible) {
							infeasibleSolves++;
							System.out.print(".");
							continue;
						}
						if (solved == SolveResult.Failure) {
							System.out.println("FAILURE!!!!!!!");
							break;
						}
					}
				} // System.out.println("Adding Next STEP");
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
					System.out.println("found test case "+new Date());
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
		totalSolves++;
		if (solved == SolveResult.Failure || solved == SolveResult.Infeasible) {
			infeasibleSolves++;
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
