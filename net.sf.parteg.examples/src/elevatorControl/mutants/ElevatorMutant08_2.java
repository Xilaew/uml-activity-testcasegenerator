package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant08_2 extends Elevator {

	public ElevatorMutant08_2()
	{
		super();
	}

	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight <= minWeight;
	}
}
