package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant05_1 extends Elevator {

	public ElevatorMutant05_1()
	{
		super();
	}

	// 05
	protected boolean rankIsHigherThanMinRank(Integer in_nRank)
	{
		return in_nRank < minRank;
	}
}
