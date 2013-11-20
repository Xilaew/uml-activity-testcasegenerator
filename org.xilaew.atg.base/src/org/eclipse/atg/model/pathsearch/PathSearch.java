/**
 * gives Access to path search algorithms, that are just relying basic Graph search algorithms
 *  */
package org.eclipse.atg.model.pathsearch;

import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

/**
 * @author th51e0
 *
 */
public interface PathSearch {
	public static final PathSearch BFS = new BFS();
	public static final PathSearch DFS = new DFS();
	public static final PathSearch BOUNDED_DFS = new BoundedDFS();
	public static final PathSearch BOUNDED_BFS = new BoundedBFS();
	
	public static final String PROPERTY_MAX_PATHLENGTH = "PATHSEARCH_MAX_PATHLENGTH";
	public static final String PROPERTY_MAX_NO_PATHS = "PATHSEARCH_MAX_NO_PATHS";
	
	public void setProperties(Properties p);
	public Properties getProperties();
	public EList<Path> findAllPaths(AbstractTCGContainer atcg);

}
