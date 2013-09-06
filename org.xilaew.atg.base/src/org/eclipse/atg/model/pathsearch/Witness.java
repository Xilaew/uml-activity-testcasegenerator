package org.eclipse.atg.model.pathsearch;

import java.util.HashMap;
import java.util.List;

import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;

/**
 * @author th51e0
 * stores the complete execution Trace associated with a path
 */
public class Witness extends HashMap<TCGBasicVariable,List<Double>>{
	
	void setAssociatedPath(Path associatedPath) {
		this.associatedPath = associatedPath;
	}

	public Path getAssociatedPath() {
		return associatedPath;
	}

	Path associatedPath;

	private static final long serialVersionUID = 1L;

}
