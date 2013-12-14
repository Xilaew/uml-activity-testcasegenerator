package org.eclipse.atg.model.pathsearch;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

class SearchTree {

	protected SearchTree(AbstractTCGEdge edge, SearchTree predecessor, int depth) {
		super();
		this.edge = edge;
		this.predecessor = predecessor;
		this.depth = depth;
	}

	protected SearchTree(AbstractTCGEdge edge, SearchTree predecessor,
			int depth, int passedDecissions) {
		super();
		this.edge = edge;
		this.predecessor = predecessor;
		this.depth = depth;
		this.passedDecissions = passedDecissions;
	}

	AbstractTCGEdge edge;
	int depth;
	int passedDecissions;
	SearchTree predecessor;
}