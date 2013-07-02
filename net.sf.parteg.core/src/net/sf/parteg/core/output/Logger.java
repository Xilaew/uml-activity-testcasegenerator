package net.sf.parteg.core.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Logger {

	private PrintStream m_oPrintStream;
	private FormattedOutput m_oFormattedOutput; 
	
	public Logger()
	{
		m_oFormattedOutput = new FormattedOutput();
		getFormattedOutput().appendln("### Test Case Generation Statistics");
		m_oPrintStream = null;
	}
	
	public void print(String in_sFileName)
	{
		try {
//			m_oPrintStream = new PrintStream(new FileOutputStream());

			m_oPrintStream = new PrintStream(new FileOutputStream(in_sFileName));
			
			m_oPrintStream.print(getFormattedOutput().toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FormattedOutput getFormattedOutput()
	{
		return m_oFormattedOutput;
	}
}
