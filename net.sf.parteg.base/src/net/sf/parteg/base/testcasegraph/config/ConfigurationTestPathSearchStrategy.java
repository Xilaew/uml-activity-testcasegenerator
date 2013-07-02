package net.sf.parteg.base.testcasegraph.config;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ConfigurationTestPathSearchStrategy {

	public enum TestPathSearchStrategy
	{
		TRANSITIONS_TO_NEAR_NODES_FIRST,
		TRANSITIONS_TO_FAR_NODES_FIRST
	}

	private static TestPathSearchStrategy sm_oTestPathSearchStrategy = TestPathSearchStrategy.TRANSITIONS_TO_FAR_NODES_FIRST;
	private static HashMap<String, TestPathSearchStrategy> sm_colName2TestPathSearchStrategy = 
		getDefaultTestPathSearchStrategies();

	private static HashMap<String, TestPathSearchStrategy> getDefaultTestPathSearchStrategies() {
		HashMap<String, TestPathSearchStrategy> colResultValue = 
			new LinkedHashMap<String, TestPathSearchStrategy>();
		colResultValue.put("Transitions To Far Nodes First", 
				TestPathSearchStrategy.TRANSITIONS_TO_FAR_NODES_FIRST);
		colResultValue.put("Transitions To Near Nodes First", 
				TestPathSearchStrategy.TRANSITIONS_TO_NEAR_NODES_FIRST);
		
		return colResultValue;
	}

	public static void setTestPathSearchStrategy(TestPathSearchStrategy in_oStrategy)
	{
		sm_oTestPathSearchStrategy = in_oStrategy;
	}

	public static HashMap<String, TestPathSearchStrategy> getTestPathSearchStrategies() {
		return sm_colName2TestPathSearchStrategy;
	}

	public static TestPathSearchStrategy getTestPathSearchStrategy()
	{
		return sm_oTestPathSearchStrategy;
	}


}
