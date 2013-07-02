package net.sf.parteg.base.testcasetree.constraints;


public interface TestCaseGraphConstraint {
	
	/**
	 * grundlegendes Problem:
	 * Kriterien für die Erzeugung von Bäumen sollen erfüllt sein.
	 * Man fragt diese Kriterien aber ab, um festzustellen, ob eine
	 * Aktion den Baum so verändert, dass das Kriterium nicht mehr erfüllt ist.
	 * Variante1:
	 * potentiellen Baum erzeugen und bewerten lassen
	 * Variante2:
	 * existierenden Baum mit vorgeschlagener Veränderung bewerten lassen
	 * 
	 * Versuch mit Variante 1
	 */
	
	public boolean isFulfilled();
	
	
}
