package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant06_5 extends Elevator {

	public ElevatorMutant06_5()
	{
		super();
	}

	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight >= maxWeight;
	}
}
