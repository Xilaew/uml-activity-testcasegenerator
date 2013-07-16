package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant06_3 extends Elevator {

	public ElevatorMutant06_3()
	{
		super();
	}

	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight == maxWeight;
	}
}
