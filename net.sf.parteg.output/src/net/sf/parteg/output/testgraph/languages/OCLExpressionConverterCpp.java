package net.sf.parteg.output.testgraph.languages;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OCLExpressionConverterCpp extends OCLExpressionConverter {
	
	private static HashMap<String, String> m_colConvertMapForFullText = initHashMapFullText();
	private static HashMap<String, String> m_colConvertMapForOperators = initHashMapOperators();

	private static HashMap<String, String> initHashMapFullText()
	{
		HashMap<String, String> colHashMap = new LinkedHashMap<String, String>();
		colHashMap.put(" and ", " && ");
		colHashMap.put(" or ", " || ");
		colHashMap.put(" not ", " ! ");
		colHashMap.put(" = ", " == ");
		colHashMap.put(" <> ", " != ");
		return colHashMap;
	}

	private static HashMap<String, String> initHashMapOperators()
	{
		HashMap<String, String> colHashMap = new LinkedHashMap<String, String>();
		colHashMap.put("and", "&&");
		colHashMap.put("or", "||");
		colHashMap.put("not", "!");
		colHashMap.put("=", "==");
		colHashMap.put("<>", "!=");
		return colHashMap;
	}

	@Override
	protected HashMap<String, String> getMapForFullText() {
		return m_colConvertMapForFullText;
	}

	@Override
	protected HashMap<String, String> getMapForOperators() {
		return m_colConvertMapForOperators;
	}
}
