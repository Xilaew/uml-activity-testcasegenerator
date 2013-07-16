package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant07_5 extends Elevator {

	public ElevatorMutant07_5()
	{
		super();
	}

	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight > minWeight;
	}
}
