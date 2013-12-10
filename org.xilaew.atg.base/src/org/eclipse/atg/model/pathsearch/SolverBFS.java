package org.eclipse.atg.model.pathsearch;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
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

public class SolverBFS extends AbstractSolverIntegratedPathSearch {

	@Override
	public EMap<Path, Witness> findAllSatisfiableActivityPaths(TCGActivity atcg) {
		EMap<Path, Witness> result = new BasicEMap<Path, Witness>();
		Deque<SearchTree> stack = new ArrayDeque<SearchTree>();
		ampl.setSolver(solver);
		ampl.loadModel(ActTCG2AMPLModel.transform(atcg));
		int resetCounter = 0;
		int passedDecisions = 0;
		for (AbstractTCGEdge e : atcg.getInitialNode().getOutgoing()) {
			stack.addLast(new SearchTree(e, null, 0));
		}
		AbstractTCGNode currentNode = atcg.getInitialNode();
		AbstractTCGEdge currentEdge;
		SearchTree currentElement;
		while (!stack.isEmpty()
				&& (result.size() < maxNoPaths || maxNoPaths == -1)) {
			currentElement = stack.removeFirst();
			currentEdge = currentElement.edge;
			currentNode = currentEdge.getTarget();

			if (currentElement.depth <= maxDepth || maxDepth == -1) {
				// check every 3 or 4 decisions whether the path is still
				// feasible
				if (currentNode.getOutgoing().size() >= 2) {
					passedDecisions++;
					if (passedDecisions > uncheckedSteps) {
						passedDecisions = 0;
						ampl.loadData(Path2AMPLData.transform(SearchTree2Path
								.searchTree2Path(currentElement)));
						SolveResult solved = SolveResult.Solved;
						try {
							solved = ampl.solve();
						} catch (IOException e) {
							ampl = AmplFactory.createJAMPL();
							ampl.setSolver(solver);
							ampl.loadModel(ActTCG2AMPLModel.transform(atcg));
							resetCounter++;
							System.out.println("RESET!!!");
							ampl.loadData(Path2AMPLData
									.transform(SearchTree2Path
											.searchTree2Path(currentElement)));
							try {
								solved = ampl.solve();
							} catch (IOException e1) {
								e1.printStackTrace();
								break;
							}
						}
						totalSolves++;
						if (solved == SolveResult.Solved) {
							System.out.print(",");
						}
						if (solved == SolveResult.Infeasible) {
							infeasibleSolves++;
							System.out.print(".");
							continue;
						}
						if (solved == SolveResult.Failure) {
							System.out.println("FAILURE!!!!!!!");
							infeasibleSolves++;
							continue;
						}
					}
				} // System.out.println("Adding Next STEP");
					// add child nodes to Stack

				for (AbstractTCGEdge outgoing : currentNode.getOutgoing()) {
					stack.addLast(new SearchTree(outgoing, currentElement,
							currentElement.depth + 1));
				}
			}
			if (currentNode.getOutgoing().size() == 0) {
				// found final node -> Add path to result
				// fill witness with data.
				Path currentPath=SearchTree2Path.searchTree2Path(currentElement);
				Witness witness = generateWitness(currentPath, atcg);
				if (witness != null) {
					result.put(currentPath, witness);
					System.out.println("found test case " + new Date());
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

	// @Override
	// public void setProperties(Properties p) {
	// try {
	// maxDepth = Integer.parseInt(p.getProperty(PROPERTY_MAX_PATHLENGTH));
	// } catch (NumberFormatException e) {
	// maxDepth=-1;
	// }
	// try {
	// maxNoPaths = Integer.parseInt(p.getProperty(PROPERTY_MAX_NO_PATHS));
	// } catch (NumberFormatException e) {
	// maxNoPaths=-1;
	// }
	// }

}
