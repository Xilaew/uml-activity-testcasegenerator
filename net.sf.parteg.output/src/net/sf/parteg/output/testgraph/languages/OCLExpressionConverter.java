package net.sf.parteg.output.testgraph.languages;

import java.util.HashMap;
import java.util.Iterator;

public abstract class OCLExpressionConverter {

	/**
	 * converts the ocl string to a target string 
	 * @param in_sOCLString
	 * @return string in a target language
	 */
	public String convert(String in_sOCLString)
	{
		String sOutput = in_sOCLString;
		Iterator<String> oKeyIter = getMapForFullText().keySet().iterator();
		while(oKeyIter.hasNext())
		{
			// search in full text
			String sKey = oKeyIter.next();
			sOutput = sOutput.replaceAll(sKey, getMapForFullText().get(sKey));
		}
																													
		oKeyIter = getMapForOperators().keySet().iterator();
		while(oKeyIter.hasNext())
		{
		// search for complete replacement
				String sKey = oKeyIter.next();
				if(sOutput.compareTo(sKey) == 0)
				{
					sOutput = getMapForOperators().get(sKey);
				}
			}
			
			return sOutput;
		}
		
		protected abstract HashMap<String, String> getMapForFullText();
		protected abstract HashMap<String, String> getMapForOperators();	
}
