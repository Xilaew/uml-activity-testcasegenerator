/**
 * @author th51e0
 * contains control flow path searching algorithms. 
 * All available path search algorithms can be accessed via the Interface PathSearch or its Extension SatisfiablePathSearch. Path searching algorithms are used to find control flow paths potentially satisfying a specific Coverage Criterion. The difference between PatSearch and SatisfiablePathSearch algorithms is, that the Algorithms implementing SatisfiablePathSearch do also return a Witness for the satisfiablility of the constraints on the found path. The primitive PathSearch might also return Paths that are not satisfiable.
 */
package org.eclipse.atg.model.pathsearch;