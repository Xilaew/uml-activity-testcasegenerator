package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant06_1 extends Elevator {

	public ElevatorMutant06_1()
	{
		super();
	}

	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight < maxWeight;
	}
}
