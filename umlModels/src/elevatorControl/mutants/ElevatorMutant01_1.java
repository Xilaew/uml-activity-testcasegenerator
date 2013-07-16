package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant01_1 extends Elevator {

	public ElevatorMutant01_1()
	{
		super();
	}
	
	// here come the postconditions and guards that should be violated in mutants 
	// 01
	protected void addValueToActualWeight(Integer in_oValue)
	{
		actualWeight += in_oValue + 1;
	}

}
