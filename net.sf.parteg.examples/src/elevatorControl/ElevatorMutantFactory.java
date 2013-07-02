package elevatorControl;
import java.util.ArrayList;

import elevatorControl.mutants.*;


public class ElevatorMutantFactory {

	static private ArrayList<Elevator> sm_colElevatorList = getElevatorObjects();
		
	static ArrayList<Elevator> getElevatorObjects()
	{
		ArrayList<Elevator> colElevators = new ArrayList<Elevator>();
		colElevators.add(new ElevatorMutant01_1());
		colElevators.add(new ElevatorMutant01_2());
		colElevators.add(new ElevatorMutant01_3());
		colElevators.add(new ElevatorMutant02_1());
		colElevators.add(new ElevatorMutant02_2());
		colElevators.add(new ElevatorMutant02_3());
		colElevators.add(new ElevatorMutant03_1());
		colElevators.add(new ElevatorMutant03_2());
		colElevators.add(new ElevatorMutant03_3());
		colElevators.add(new ElevatorMutant03_4());
		colElevators.add(new ElevatorMutant03_5());
		colElevators.add(new ElevatorMutant04_1());
		colElevators.add(new ElevatorMutant04_2());
		colElevators.add(new ElevatorMutant04_3());
		colElevators.add(new ElevatorMutant04_4());
		colElevators.add(new ElevatorMutant04_5());
		colElevators.add(new ElevatorMutant05_1());
		colElevators.add(new ElevatorMutant05_2());
		colElevators.add(new ElevatorMutant05_3());
		colElevators.add(new ElevatorMutant05_4());
		colElevators.add(new ElevatorMutant05_5());
		colElevators.add(new ElevatorMutant06_1());
		colElevators.add(new ElevatorMutant06_2());
		colElevators.add(new ElevatorMutant06_3());
		colElevators.add(new ElevatorMutant06_4());
		colElevators.add(new ElevatorMutant06_5());
		colElevators.add(new ElevatorMutant07_1());
		colElevators.add(new ElevatorMutant07_2());
		colElevators.add(new ElevatorMutant07_3());
		colElevators.add(new ElevatorMutant07_4());
		colElevators.add(new ElevatorMutant07_5());
		colElevators.add(new ElevatorMutant08_1());
		colElevators.add(new ElevatorMutant08_2());
		colElevators.add(new ElevatorMutant08_3());
		colElevators.add(new ElevatorMutant08_4());
		colElevators.add(new ElevatorMutant08_5());
		colElevators.add(new ElevatorMutant09_1());
		colElevators.add(new ElevatorMutant09_2());
		colElevators.add(new ElevatorMutant10_1());
		colElevators.add(new ElevatorMutant10_2());
		colElevators.add(new ElevatorMutant11_1());
		colElevators.add(new ElevatorMutant11_2());
		
		return colElevators;
	}
	
	public ArrayList<Elevator> getMutants()
	{
		return sm_colElevatorList;
	}
}
