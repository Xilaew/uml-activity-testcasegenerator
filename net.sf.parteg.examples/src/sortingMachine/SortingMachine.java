package sortingMachine;


public class SortingMachine extends java.lang.Object implements java.lang.Cloneable {

	
	public SortingMachine()
	{
		minCompare = 20;
		maxCompare = 30;
		state = State.idle;
	}
	
	public SortingMachine clone()
	{
		try {
			return (SortingMachine)super.clone();
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
			if((state == State.idle) && (sEventName.compareTo("detectItemEvent") == 0))
			{
				Item oItem = (Item)in_colObject[1];
				m_width = (oItem.width + 2) * 2;
				m_height = (oItem.height * 2) + 2;
				if(actualHeightIsLowerThanMinCompare()) {
					recognized = true;
				}
				else {
					recognized = false;
				}
				if(recognizedIsTrue()) {
					state = State.object_recognized;
					if(widthIsLessThanMinCompare())
					{
						state = State.object_is_too_small;
					}
					else if(widthIsGreaterThanMaxCompare())
					{
						state = State.object_is_too_big;
					}
					else if(widthIsBetweenMinCompareAndMaxCompare())
					{
						state = State.object_is_fitting;
					}
				}
				else {
					state = State.object_not_recognized;
				}
			}
			if(sEventName.compareTo("resetEvent") == 0)
			{
				// object not recognized
				if(state == State.object_not_recognized ||
						state == State.object_is_fitting ||
						state == State.object_is_too_big ||
						state == State.object_is_too_small)
				{
					state = State.idle;
				}
			}
		}
	}
	
	// mutants 1
	protected boolean actualHeightIsLowerThanMinCompare()
	{
		return m_height < minCompare;
	}
	
	// mutants 2
	protected boolean recognizedIsTrue()
	{
		return recognized == true;
	}
	
	// mutants 3
	protected boolean widthIsLessThanMinCompare()
	{
		return m_width < minCompare;
	}
	
	// mutants 4
	protected boolean widthIsGreaterThanMaxCompare()
	{
		return m_width > maxCompare;
	}
	
	// mutants 5
	protected boolean widthIsBetweenMinCompareAndMaxCompare()
	{
		return m_width >= minCompare && m_width <= maxCompare;
	}
	
	public Integer minCompare;
	public Integer maxCompare;
	
	public Integer m_width;
	public Integer m_height;
	public State state;
	
	public Boolean recognized;
}
