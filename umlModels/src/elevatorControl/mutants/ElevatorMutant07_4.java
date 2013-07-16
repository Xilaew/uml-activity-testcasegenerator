package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant07_4 extends Elevator {

	public ElevatorMutant07_4()
	{
		super();
	}

	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight >= minWeight;
	}
}
