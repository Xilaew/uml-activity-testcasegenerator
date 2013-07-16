package elevatorControl;

public class Elevator extends java.lang.Object implements java.lang.Cloneable {

	public Elevator()
	{
		actualWeight = 0;
		basement = 0;
		currentFloor = 5;
		state = State.idle;
		
		maxWeight = 30;
		minWeight = 0;
		minRank = 3;
	}
	
	public Elevator clone()
	{
		try {
			return (Elevator)super.clone();
		}
		catch(Exception e)
		{
			e.printStackTrace(java.lang.System.err);
		}
		return null;
	}
	
	public void handleEvent(Object... in_colObject)
	{
		if(in_colObject.length > 0)
		{
			String sEventName = (String)in_colObject[0];
			if((state == State.idle) && (sEventName.compareTo("removeWeight") == 0))
			{
				Integer oValue = (Integer)in_colObject[1];
				removeValueFromActualWeight(oValue.intValue());
			}
			else if((state == State.idle) && (sEventName.compareTo("insertWeight") == 0))
			{
				Integer oValue = (Integer)in_colObject[1];
				addValueToActualWeight(oValue.intValue());
			}
			else if((state == State.idle) && (sEventName.compareTo("pressButton") == 0))
			{
				Integer nButton = ((Integer)in_colObject[1]).intValue();
				Integer nRank = ((Integer)in_colObject[2]).intValue();
				if((buttonIsNotCurrentFloor(nButton)) && 
						(buttonIsHigherThanBasement(nButton) || 
								rankIsHigherThanMinRank(nRank)))
				{
					state = State.button_pressed;
					if(actualWeightIsHigherThanMaxWeight())
						state = State.idle;
					else {
						state = State.start_moving;
						if(actualWeightIsEqualToMinWeight())
							state = State.move_fast;
						else if(actualWeightIsHigherThanMinWeight())
							state = State.move_slow;
					}
				}
			}
			else if(((state == State.move_fast) || (state == State.move_slow)) &&
					(sEventName.compareTo("reachFloor") == 0))
			{
				state = State.idle;
			}
		}
	}
	
	// here come the postconditions and guards that should be violated in mutants 
	// 01
	protected void addValueToActualWeight(Integer in_oValue)
	{
		actualWeight += in_oValue;
	}
	// 02
	protected void removeValueFromActualWeight(Integer in_oValue)
	{
		actualWeight -= in_oValue;
	}
	// 03
	protected boolean buttonIsNotCurrentFloor(Integer in_nButton)
	{
		return in_nButton != currentFloor;
	}
	// 04
	protected boolean buttonIsHigherThanBasement(Integer in_nButton)
	{
		return in_nButton > basement;
	}
	// 05
	protected boolean rankIsHigherThanMinRank(Integer in_nRank)
	{
		return in_nRank > minRank;
	}
	// 06
	protected boolean actualWeightIsHigherThanMaxWeight()
	{
		return actualWeight > maxWeight;
	}
	// 07
	protected boolean actualWeightIsEqualToMinWeight()
	{
		return actualWeight == minWeight;
	}
	// 08
	protected boolean actualWeightIsHigherThanMinWeight()
	{
		return actualWeight > minWeight;
	}


	public Integer currentFloor;
	public Integer basement;
	public Integer actualWeight;
	public State state;
	public Integer maxWeight;
	public Integer minWeight;
	public Integer minRank;
}
