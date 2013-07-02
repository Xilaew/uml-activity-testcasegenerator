package sortingMachine.mutants;

import sortingMachine.SortingMachine;

public class SortingMachineMutant02_1 extends SortingMachine {

	// mutants 2
	protected boolean recognizedIsTrue()
	{
		return recognized != true;
	}
}
