package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant06_2 extends Elevator {

	public ElevatorMutant06_2()
	{
		super();
	}

	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight <= maxWeight;
	}
}
