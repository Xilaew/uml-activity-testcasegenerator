package sortingMachine.mutants;

import sortingMachine.SortingMachine;

public class SortingMachineMutant04_3 extends SortingMachine {

	// mutants 4
	protected boolean widthIsGreaterThanMaxCompare()
	{
		return m_width == maxCompare;
	}
}
