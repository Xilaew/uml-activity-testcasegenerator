package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant08_3 extends Elevator {

	public ElevatorMutant08_3()
	{
		super();
	}

	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight == minWeight;
	}
}
