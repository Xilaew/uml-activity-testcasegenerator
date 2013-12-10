package org.eclipse.atg.model.pathsearch;

import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimeFactory;

class SearchTree2Path {
	
	static Path searchTree2Path(SearchTree currentElement){
		Path resultPath = TestCaseGraphRuntimeFactory.eINSTANCE
				.createPath();
		do {
			resultPath.getEdges().add(0, currentElement.edge);
			currentElement = currentElement.predecessor;
		} while (currentElement != null);
		return resultPath;
	}

}
