/**
 * common Interface control flow path search algorithms already checking the satisfiability of constraints during search.
 * The implementing Algorithms are quite similar to those implementing PathSearch. The only difference is that here not just Paths will be returned but also the a Witness of satisfiability of the Path will be given.
 */
package org.eclipse.atg.model.pathsearch;

import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

/**
 * @author th51e0
 * 
 */
public abstract class AbstractSolverIntegratedPathSearch implements
		SatisfiablePathSearch {

	private static final String DEFAULT_SOLVER = "couenne";

	JAMPL ampl = AmplFactory.createJAMPL();
	String solver = DEFAULT_SOLVER;
	int maxDepth = -1;
	int maxNoPaths = -1;
	
	

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
		try {
			solver = p.getProperty(PROPERTY_SOLVER);
		} catch (Exception e) {
			solver = DEFAULT_SOLVER;
		}
		if (solver == null)
			solver = DEFAULT_SOLVER;

	}

	public EList<Path> findAllPaths(AbstractTCGContainer atcg) {
		Set<Path> paths = findAllSatisfiablePaths(atcg).keySet();
		EList<Path> result = new BasicEList<Path>();
		result.addAll(paths);
		return result;
	}
	
	public EMap<Path, Witness> findAllSatisfiablePaths(AbstractTCGContainer atcg) {
		TCGActivity actTCG = (TCGActivity) atcg;
		return findAllSatisfiableActivityPaths(actTCG);
	}

	protected abstract EMap<Path, Witness> findAllSatisfiableActivityPaths(TCGActivity atcg) ;
}
