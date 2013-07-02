package net.sf.parteg.core.structures;

public class Pair<T, U> {

	private T m_oFirst;
	private U m_oSecond;
	
	public Pair(T in_oFirst, U in_oSecond)
	{
		m_oFirst = in_oFirst;
		m_oSecond = in_oSecond;
	}
	
	public T getFirst()
	{
		return m_oFirst;
	}
	
	public U getSecond()
	{
		return m_oSecond;
	}

	public void setFirst(T in_oValue)
	{
		m_oFirst = in_oValue;
	}
	
	public void setSecond(U in_oValue)
	{
		m_oSecond = in_oValue;
	}

}
