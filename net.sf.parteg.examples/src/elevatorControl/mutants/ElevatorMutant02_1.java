package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant02_1 extends Elevator {

	public ElevatorMutant02_1()
	{
		super();
	}
	
	// here come the postconditions and guards that should be violated in mutants 
	// 02
	protected void removeValueFromActualWeight(Integer in_oValue)
	{
		actualWeight -= in_oValue + 1;
	}
}
