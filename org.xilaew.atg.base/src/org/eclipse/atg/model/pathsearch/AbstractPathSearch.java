package org.eclipse.atg.model.pathsearch;

import java.util.Properties;

public abstract class AbstractPathSearch implements PathSearch{


	protected int maxDepth = -1;
	protected int maxNoPaths = -1;
	Properties p = null;

	public AbstractPathSearch() {
		super();
	}

	@Override
	public Properties getProperties() {
		return p;
	}
	@Override
	public void setProperties(Properties p) {
		this.p=p;
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
	}

}