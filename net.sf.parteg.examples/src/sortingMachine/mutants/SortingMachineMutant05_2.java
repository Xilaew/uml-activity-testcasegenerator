package sortingMachine.mutants;

import sortingMachine.SortingMachine;

public class SortingMachineMutant05_2 extends SortingMachine {

	// mutants 5
	protected boolean widthIsBetweenMinCompareAndMaxCompare()
	{
		return m_width <= minCompare && m_width <= maxCompare;
	}
}
