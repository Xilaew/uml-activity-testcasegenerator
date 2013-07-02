package net.sf.parteg.base.testcasegraph.decisiontables;

import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public class DecisionTableExpressionValueSelection extends LinkedHashMap<TCGOCLExpression, Boolean> {

	private static final long serialVersionUID = 1L;
	
	private boolean m_bTruthValue;

	public void setTruthValue(boolean in_bValue) {
		this.m_bTruthValue = in_bValue;
	}

	public boolean getTruthValue() {
		if(values().size() == 1)
			return values().iterator().next();
		return m_bTruthValue;
	}
}
