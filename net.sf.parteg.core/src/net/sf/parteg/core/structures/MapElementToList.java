package net.sf.parteg.core.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapElementToList<KeyType, ValueType> {

	//private HashMap<TCGOCLExpression, ArrayList<TCGElement>> m_colOCL2Element;
	private HashMap<KeyType, ArrayList<ValueType>> m_colMap;
	
	public MapElementToList()
	{
		m_colMap = new HashMap<KeyType, ArrayList<ValueType>>();
	}
	
	public void add(KeyType in_oKey, ValueType in_oValue)
	{
		ArrayList<ValueType> colElements = m_colMap.get(in_oKey); 
		if(colElements == null)
		{
			colElements = new ArrayList<ValueType>();
		}
		colElements.add(in_oValue);
		m_colMap.put(in_oKey, colElements);
	}
	
	public List<ValueType> getValuesForKey(KeyType in_oKey)
	{
		return m_colMap.get(in_oKey);
	}
}
