package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant08_5 extends Elevator {

	public ElevatorMutant08_5()
	{
		super();
	}

	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight >= minWeight;
	}
}
