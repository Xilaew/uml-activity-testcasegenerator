package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant06_4 extends Elevator {

	public ElevatorMutant06_4()
	{
		super();
	}

	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight != maxWeight;
	}
}
