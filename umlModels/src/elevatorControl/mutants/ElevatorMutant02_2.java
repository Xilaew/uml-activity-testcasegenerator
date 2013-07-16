package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant02_2 extends Elevator {

	public ElevatorMutant02_2()
	{
		super();
	}

	// 02
	protected void removeValueFromActualWeight(Integer in_oValue)
	{
		actualWeight -= in_oValue - 1;
	}

}
