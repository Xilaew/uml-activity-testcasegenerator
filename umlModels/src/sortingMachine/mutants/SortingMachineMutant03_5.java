package sortingMachine.mutants;

import sortingMachine.SortingMachine;

public class SortingMachineMutant03_5 extends SortingMachine {

	// mutants 3
	protected boolean widthIsLessThanMinCompare()
	{
		return m_width > minCompare;
	}
}
