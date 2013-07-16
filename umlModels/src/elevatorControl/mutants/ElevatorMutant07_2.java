package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant07_2 extends Elevator {

	public ElevatorMutant07_2()
	{
		super();
	}

	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight <= minWeight;
	}
}
