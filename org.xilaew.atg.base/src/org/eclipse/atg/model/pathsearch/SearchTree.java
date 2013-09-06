package org.eclipse.atg.model.pathsearch;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

class SearchTree {

	protected SearchTree(AbstractTCGEdge edge, SearchTree predecessor,
			int depth) {
		super();
		this.edge = edge;
		this.predecessor = predecessor;
		this.depth = depth;
	}

	AbstractTCGEdge edge;
	int depth;
	SearchTree predecessor;
}