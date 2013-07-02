package net.sf.parteg.core.output;

import java.io.PrintStream;

public class FormattedOutputStream extends FormattedOutput {

	private PrintStream m_oPrintStream;
	private int sm_nFlushCounterLimit = 100;
	private int m_nFlushCounter;

	public FormattedOutputStream() {
		super();
		m_nFlushCounter = 0;
		m_oPrintStream = null;
	}
	
	public void setPrintStream(PrintStream in_oPrintStream) {
		m_oPrintStream = in_oPrintStream;
	}
	
	public PrintStream getPrintStream() {
		return m_oPrintStream;
	}

	public void append(String in_sString)
	{
		super.append(in_sString);
		handleFlushCounter();
	}
	
	public void appendln(String in_sString)
	{
		super.appendln(in_sString);
		handleFlushCounter();
	}

	private void handleFlushCounter() {
		++m_nFlushCounter;
		if(m_nFlushCounter > sm_nFlushCounterLimit) {
			m_nFlushCounter = 0;
			m_oPrintStream.print(toString());
			m_oPrintStream.flush();
			clear();
		}
	}
}
