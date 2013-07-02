package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant02_3 extends Elevator {

	public ElevatorMutant02_3()
	{
		super();
	}

	// 02
	protected void removeValueFromActualWeight(Integer in_oValue)
	{
		actualWeight -= 0;
	}
}
