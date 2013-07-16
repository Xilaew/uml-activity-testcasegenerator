package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant04_5 extends Elevator {

	public ElevatorMutant04_5()
	{
		super();
	}

	// 04
	protected boolean buttonIsHigherThanBasement(Integer in_nButton)
	{
		return in_nButton != basement;
	}
}
