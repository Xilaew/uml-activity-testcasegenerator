package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant05_4 extends Elevator {

	public ElevatorMutant05_4()
	{
		super();
	}

	// 05
	protected boolean rankIsHigherThanMinRank(Integer in_nRank)
	{
		return in_nRank != minRank;
	}
}
