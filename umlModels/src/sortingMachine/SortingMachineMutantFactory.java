package sortingMachine;

import java.util.ArrayList;

import sortingMachine.mutants.*;



public class SortingMachineMutantFactory {

	static private ArrayList<SortingMachine> sm_colSortingMachineList = getSortingMachineObjects();
	
	static ArrayList<SortingMachine> getSortingMachineObjects()
	{
		ArrayList<SortingMachine> colSortingMachines = new ArrayList<SortingMachine>();
		colSortingMachines.add(new SortingMachineMutant01_1());
		colSortingMachines.add(new SortingMachineMutant01_2());
		colSortingMachines.add(new SortingMachineMutant01_3());
		colSortingMachines.add(new SortingMachineMutant01_4());
		colSortingMachines.add(new SortingMachineMutant01_5());
		colSortingMachines.add(new SortingMachineMutant02_1());
		colSortingMachines.add(new SortingMachineMutant03_1());
		colSortingMachines.add(new SortingMachineMutant03_2());
		colSortingMachines.add(new SortingMachineMutant03_3());
		colSortingMachines.add(new SortingMachineMutant03_4());
		colSortingMachines.add(new SortingMachineMutant03_5());
		colSortingMachines.add(new SortingMachineMutant04_1());
		colSortingMachines.add(new SortingMachineMutant04_2());
		colSortingMachines.add(new SortingMachineMutant04_3());
		colSortingMachines.add(new SortingMachineMutant04_4());
		colSortingMachines.add(new SortingMachineMutant04_5());
		colSortingMachines.add(new SortingMachineMutant05_1());
		colSortingMachines.add(new SortingMachineMutant05_2());
		colSortingMachines.add(new SortingMachineMutant05_3());
		colSortingMachines.add(new SortingMachineMutant05_4());
		colSortingMachines.add(new SortingMachineMutant05_5());
		colSortingMachines.add(new SortingMachineMutant05_6());
		colSortingMachines.add(new SortingMachineMutant05_7());
		colSortingMachines.add(new SortingMachineMutant05_8());
		colSortingMachines.add(new SortingMachineMutant05_9());
		colSortingMachines.add(new SortingMachineMutant05_10());
		colSortingMachines.add(new SortingMachineMutant06_1());
		colSortingMachines.add(new SortingMachineMutant06_2());
		colSortingMachines.add(new SortingMachineMutant06_3());
		colSortingMachines.add(new SortingMachineMutant06_4());
		
		return colSortingMachines;
	}
	
	public ArrayList<SortingMachine> getMutants()
	{
		return sm_colSortingMachineList;
	}

}
