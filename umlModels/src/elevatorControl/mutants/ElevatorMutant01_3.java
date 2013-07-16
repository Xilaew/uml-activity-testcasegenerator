package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant01_3 extends Elevator {

	public ElevatorMutant01_3()
	{
		super();
	}
	
	// here come the postconditions and guards that should be violated in mutants 
	// 01
	protected void addValueToActualWeight(Integer in_oValue)
	{
		actualWeight += 0;
	}
}
