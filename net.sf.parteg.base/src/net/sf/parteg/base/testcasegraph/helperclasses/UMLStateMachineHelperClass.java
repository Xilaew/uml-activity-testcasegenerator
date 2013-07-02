package net.sf.parteg.base.testcasegraph.helperclasses;

import net.sf.parteg.base.testcasegraph.config.Configuration;

import org.eclipse.uml2.uml.StateMachine;

public class UMLStateMachineHelperClass {

	public static org.eclipse.uml2.uml.Package getPackageOfStateMachine(StateMachine in_oStateMachine) {
		org.eclipse.uml2.uml.Package oStateMachineContext = in_oStateMachine.getNearestPackage();
		if(oStateMachineContext == null) {
			oStateMachineContext = in_oStateMachine.getModel();
		} 
		if(oStateMachineContext == null) {
			Configuration.handleException(
					new Exception("context package of state machine cannot be identified"));
		}
		while(oStateMachineContext.getOwner() instanceof org.eclipse.uml2.uml.Package) {
			oStateMachineContext = (org.eclipse.uml2.uml.Package)(oStateMachineContext.getOwner());
		}

		return oStateMachineContext;
	}
}
