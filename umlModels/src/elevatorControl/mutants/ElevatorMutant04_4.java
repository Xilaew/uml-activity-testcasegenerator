package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant04_4 extends Elevator {

	public ElevatorMutant04_4()
	{
		super();
	}

	// 04
	protected boolean buttonIsHigherThanBasement(Integer in_nButton)
	{
		return in_nButton >= basement;
	}
}
