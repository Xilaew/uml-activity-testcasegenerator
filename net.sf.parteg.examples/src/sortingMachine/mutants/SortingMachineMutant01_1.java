package sortingMachine.mutants;

import sortingMachine.SortingMachine;

public class SortingMachineMutant01_1 extends SortingMachine {

	// mutants 1
	protected boolean actualHeightIsLowerThanMinCompare()
	{
		return m_height <= minCompare;
	}
}
