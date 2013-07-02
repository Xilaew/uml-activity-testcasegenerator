package net.sf.parteg.core.output;


public class FormattedOutput {

	private StringBuffer m_oStringBuffer;
	private int m_nIndent;
	private final String sm_sNewline = System.getProperty("line.separator");
	
	public FormattedOutput()
	{
		m_oStringBuffer = new StringBuffer("");
		m_nIndent = 0;
	}
	
	public void append(String in_sString)
	{
		m_oStringBuffer.append(in_sString);
	}
	
	public void appendln(String in_sString)
	{
		append(in_sString);
		newline();
	}
	
	public void newline()
	{
		m_oStringBuffer.append(sm_sNewline);
		int nMax = m_nIndent;// * sm_nIndentWidth;
		for(int i = 0; i < nMax; ++i)
		{
			m_oStringBuffer.append('\t');
		}
	}
	
	public void increaseIndent()
	{
		++m_nIndent;
	}
	
	public void decreaseIndent()
	{
		--m_nIndent;
	}
	
	public String toString()
	{
		return m_oStringBuffer.toString();
	}
	
	public void clear()
	{
		m_oStringBuffer.delete(0, m_oStringBuffer.length());
	}
	
	// comfort method to open a new context
	public void openContext()
	{
		append("{");
		increaseIndent();
		newline();
	}
	
	// comfort method to close a new context
	public void closeContext()
	{
		decreaseIndent();
		newline();
		append("}");
	}
	
	public int getIndent()
	{
		return m_nIndent;
	}
	
	public void setIndent(int in_nIndent)
	{
		m_nIndent = in_nIndent;
	}
	
	public StringBuffer getStringBuffer()
	{
		return m_oStringBuffer;
	}
	
	public void setStringBuffer(StringBuffer in_oStringBuffer)
	{
		m_oStringBuffer = in_oStringBuffer;
	}
}
