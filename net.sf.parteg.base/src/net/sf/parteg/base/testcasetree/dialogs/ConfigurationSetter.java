package net.sf.parteg.base.testcasetree.dialogs;

import java.util.HashMap;
import java.util.Set;

import net.sf.parteg.base.testcasetree.Configuration;

import org.eclipse.uml2.uml.StateMachine;

public interface ConfigurationSetter {

	/*
	 * the next section is about SETTING initial values from Configuration
	 */
	
	public void setOutputFileName(String in_sFileName);
	public void setSMEventHandleFunction(String in_sEventHandleFunction);
	
	/*
	 * the next section is about GETTING initial values from Configuration
	 */
	
	public String getOutputFileName();
	public String getSMEventHandleFunction();
	
	// hashmap from regions to associated classes
	public void setStateMachineContextClasses(HashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>> in_colContexts);

	// hashmap from names to output format
	public void setOutputFormat(HashMap<String, Configuration.OUTPUTFORMAT> in_colOutputFormat);

	// hashmap for coverage criteria
	public void setCoverageCriteria(HashMap<String, Configuration.TransitionBasedCoverageCriterion> in_colName2Criteria);
	
	// dialog was closed with ok
	public boolean getOkPressed();

	// access internal containers
	public HashMap<String, StateMachine> getName2StateMachine();
	public HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>> getStateMachine2Name2Class();

}
