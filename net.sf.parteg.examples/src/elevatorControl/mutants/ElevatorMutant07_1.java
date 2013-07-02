package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant07_1 extends Elevator {

	public ElevatorMutant07_1()
	{
		super();
	}

	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight < minWeight;
	}
}
