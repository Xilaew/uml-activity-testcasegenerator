package net.sf.parteg.base.testcasetree.constraints;


public interface TestCaseGraphConstraint {
	
	/**
	 * grundlegendes Problem:
	 * Kriterien f�r die Erzeugung von B�umen sollen erf�llt sein.
	 * Man fragt diese Kriterien aber ab, um festzustellen, ob eine
	 * Aktion den Baum so ver�ndert, dass das Kriterium nicht mehr erf�llt ist.
	 * Variante1:
	 * potentiellen Baum erzeugen und bewerten lassen
	 * Variante2:
	 * existierenden Baum mit vorgeschlagener Ver�nderung bewerten lassen
	 * 
	 * Versuch mit Variante 1
	 */
	
	public boolean isFulfilled();
	
	
}
