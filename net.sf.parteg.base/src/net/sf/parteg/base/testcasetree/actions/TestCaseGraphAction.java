package net.sf.parteg.base.testcasetree.actions;


public interface TestCaseGraphAction {

	/**
	 * executes the action
	 */
	public void execute();
	
	/**
	 * undo the effect of the action
	 */
	public void reverse();
}
