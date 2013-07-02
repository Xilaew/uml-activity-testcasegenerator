package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant08_4 extends Elevator {

	public ElevatorMutant08_4()
	{
		super();
	}

	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight != minWeight;
	}
}
