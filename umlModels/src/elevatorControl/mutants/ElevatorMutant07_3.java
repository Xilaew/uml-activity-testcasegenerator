package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant07_3 extends Elevator {

	public ElevatorMutant07_3()
	{
		super();
	}

	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight != minWeight;
	}
}
