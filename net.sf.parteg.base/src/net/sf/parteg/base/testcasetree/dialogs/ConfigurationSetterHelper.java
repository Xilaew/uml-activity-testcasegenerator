package net.sf.parteg.base.testcasetree.dialogs;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.uml2.uml.StateMachine;

public class ConfigurationSetterHelper {

	public static void setStateMachineContextClasses(HashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>> in_colContexts,
			ConfigurationSetter io_oConfigurationSetter) {
		for(StateMachine oStateMachine : in_colContexts.keySet())
		{
			io_oConfigurationSetter.getName2StateMachine().put(oStateMachine.getName(), oStateMachine);
			HashMap<String, org.eclipse.uml2.uml.Class> oName2Class = new HashMap<String, org.eclipse.uml2.uml.Class>();
			io_oConfigurationSetter.getStateMachine2Name2Class().put(oStateMachine, oName2Class);
			for(org.eclipse.uml2.uml.Class oClass : in_colContexts.get(oStateMachine))
			{
				oName2Class.put(oClass.getName(), oClass);
			}
		}
	}

}
