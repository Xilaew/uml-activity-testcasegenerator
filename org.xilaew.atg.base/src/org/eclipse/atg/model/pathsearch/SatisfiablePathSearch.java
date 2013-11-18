package org.eclipse.atg.model.pathsearch;

import org.eclipse.emf.common.util.EMap;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

/**
 * @author th51e0
 * gives Access to Algorithms relying on basic Graph search and Constraint solvers to check early whether the found paths are indeed satisfiable. Those Algorithms can in addition to the Path also return a Witness.
 */
public interface SatisfiablePathSearch extends PathSearch {

	public static final SatisfiablePathSearch SOLVER_DFS = new SolverDFS();
	public static final String PROPERTY_SOLVER = "PATHSEARCH_SOLVER";
	public static final String PROPERTY_UNCHECKED_STEPS = "PATHSEARCH_UNCHECKED_STEPS";

	public EMap<Path, Witness> findAllSatisfiablePaths(
			AbstractTCGContainer atcg);

}
