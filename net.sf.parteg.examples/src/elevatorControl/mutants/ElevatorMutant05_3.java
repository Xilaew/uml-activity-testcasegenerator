package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant05_3 extends Elevator {

	public ElevatorMutant05_3()
	{
		super();
	}

	// 05
	protected boolean rankIsHigherThanMinRank(Integer in_nRank)
	{
		return in_nRank == minRank;
	}
}
