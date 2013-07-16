package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant08_1 extends Elevator {

	public ElevatorMutant08_1()
	{
		super();
	}

	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight < minWeight;
	}
}
