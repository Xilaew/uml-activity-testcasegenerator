package elevatorControl.mutants;

import elevatorControl.Elevator;

public class ElevatorMutant03_5 extends Elevator {

	public ElevatorMutant03_5()
	{
		super();
	}

	// 03
	protected boolean buttonIsNotCurrentFloor(Integer in_nButton)
	{
		return in_nButton > currentFloor;
	}
}
