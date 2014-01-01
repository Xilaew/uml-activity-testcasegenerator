/**
 * common Interface control flow path search algorithms already checking the satisfiability of constraints during search.
 * The implementing Algorithms are quite similar to those implementing PathSearch. The only difference is that here not just Paths will be returned but also the a Witness of satisfiability of the Path will be given.
 */
package org.eclipse.atg.model.pathsearch;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.xilaew.amplCLI.AmplFactory;
import org.xilaew.amplCLI.JAMPL;
import org.xilaew.amplCLI.JAMPL.SolveResult;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.transformations.actTCG2ampl.ActTCG2AMPLModel;
import org.xilaew.atg.transformations.actTCG2ampl.Path2AMPLData;

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
	int uncheckedSteps = 1;
	int totalSolves = 0;
	int infeasibleSolves = 0;
	Properties p;

	/**
	 * The Properties object should contain a set of properties as name value
	 * pairs. setProperties will try to configure the algorithm accordingly. If
	 * invalid values are given it will set default values.
	 */
	public void setProperties(Properties p) {
		this.p = p;
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
		try {
			uncheckedSteps = Integer.parseInt(p
					.getProperty(PROPERTY_UNCHECKED_STEPS));
		} catch (Exception e) {
			uncheckedSteps = 1;
		}
		if (solver == null)
			solver = DEFAULT_SOLVER;
	}

	/**
	 * Returns those properties that have in fact been used for the execution of
	 * the algorithm. Aditionally after execution the Properties will also
	 * contain some statistical values.
	 * 
	 * @param p
	 *            Properties actually used for the last run.
	 */
	public Properties getProperties() {
		p.setProperty(PROPERTY_MAX_PATHLENGTH, Integer.toString(maxDepth));
		p.setProperty(PROPERTY_MAX_NO_PATHS, Integer.toString(maxNoPaths));
		p.setProperty(PROPERTY_SOLVER, solver);
		p.setProperty(PROPERTY_UNCHECKED_STEPS,
				Integer.toString(uncheckedSteps));
		p.setProperty(STAT_INFEASIBLE_PATHS_ELIMINATED, Integer.toString(infeasibleSolves));
		p.setProperty(STAT_TOTAL_SOLVER_RUNS, Integer.toString(totalSolves));
		return p;
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

	protected abstract EMap<Path, Witness> findAllSatisfiableActivityPaths(
			TCGActivity atcg);

	/**
	 * solves the constraint system for a given Path and returns a Witness
	 * containing a complete execution trace for the given Path. The returned
	 * Witness can directly be used as test data.
	 * 
	 * @param currentPath
	 * @return Witness of the satisfiability of the given Path
	 */
	protected Witness generateWitness(Path currentPath, TCGActivity atcg) {
		ampl.loadData(Path2AMPLData.transform(currentPath));
//		ampl.getCli().sendCommand("minimize x: pIndicRequest_areaCode[0] + pIndicRequest_areaType[0] + isIndicOn + iSeat[0] + iLoc[0] + isValidSeatInfo[0] + paxSeatInfo_deckArea[0] + paxSeatInfo_deckPart[0] + pSeatGroup_numberOfSeats[0] + pIndicRequest_srCounter[0];");
		Witness result = new Witness();
		SolveResult solved;
		try {
			solved = ampl.solve();
		} catch (IOException e) {
			ampl = AmplFactory.createJAMPL();
			ampl.setSolver(solver);
			ampl.loadModel(ActTCG2AMPLModel.transform(atcg));
			System.out.println("RESET!!!");
			ampl.loadData(Path2AMPLData.transform(currentPath));
			try {
				solved = ampl.solve();
			} catch (IOException e1) {
				e1.printStackTrace();
				return null;
			}
		}
//		ampl.getCli().sendCommand("delete x;");
		System.out.println(solved);
		if (solved == SolveResult.Failure || solved == SolveResult.Infeasible) {
			infeasibleSolves++;
			return null;
		}
		for (TCGVariable var : atcg.getVariables()) {
			if (var instanceof TCGBasicVariable) {
				TCGBasicVariable basicVar = (TCGBasicVariable) var;
				if (basicVar.isIsParameter()) {
					EList<Double> par = new BasicEList<Double>();
					try {
						par.add(ampl.getParameter(basicVar.getName()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					result.put(basicVar, par);
				} else {
					try {
						result.put(basicVar, ampl.getVariable(basicVar.getName()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
}
