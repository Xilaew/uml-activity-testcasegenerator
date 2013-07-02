package net.sf.parteg.output.testgraph.languages;

import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutputStream;
import net.sf.parteg.core.testcase.TestCaseValidValue;

import org.eclipse.ocl.uml.LiteralExp;


public interface TestCaseGraphOutputConfigurator {

	/**
	 * initializes output
	 * @param in_oTestCaseGraph
	 * @return the first part of the final code
	 */
	public void createGlobalStart(TestSuite in_oTestSuite);
	
	/**
	 * finalizes output
	 * @param in_oTestCaseGraph
	 * @return the last part of the final code
	 */
	public void createGlobalEnd(TestSuite in_oTestSuite);

	/**
	 * initializes output locally
	 * @param in_oTestCaseGraph
	 * @return the locally first part of the final code
	 */
	public void createLocalStart(
			Map<EventParameterInstance, TestCaseValidValue> in_colParameters);
	
	/**
	 * finalizes output locally
	 * @param in_oTestCaseGraph
	 * @return the locally last part of the final code
	 */
	public void createLocalEnd();

	/**
	 * creates transformed output for transition
	 * @param in_oTransition
	 * @param in_oFormattedOutput
	 * @return string for TCGTransition
	 */
	public void createOutput(TransitionInstance in_oTransitionInstance);
	
	/**
	 * @return the whole string
	 */
	public String getString();

	/*
	 * clears the used internal string
	 */
	public void clearString();
	
	/**
	 * 
	 * @param in_oValueType
	 * @return configurator-specific string representation of the value type
	 */
	public String getValueString(LiteralExp in_oLiteralExp);
	
	/**
	 * 
	 * @return the file type (e.g. ".java", ".h", or ".cpp")
	 */
	public String getFileType();
	
	public List<FormattedOutputStream> getFormattedOutputStreams();
	
	/**
	 * creates and initializes print streams or other output formats
	 */
	public void startPrintStreams();
	
	/**
	 * flushes and closes print streams or other output formats
	 */
	public void endPrintStreams();
}
