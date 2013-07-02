package net.sf.parteg.base.testcasegraph.config;

/*
 * This class contains temporal configurations.
 * Such a configuration might be the current name of a class
 * for an output file with an adapted name (e.g. because of
 * output file splitting).
 */
public class TemporalConfiguration {

	private static String sm_sClassNameAdaptation = "";
	
	public static void setClassNameAdaptation(String in_sName) {
		sm_sClassNameAdaptation = in_sName;
	}
	
	public static String getClassNameAdaptation() {
		return sm_sClassNameAdaptation;
	}
	
	public static String getClassNameAdaptation(String in_sOriginalClassName) {
		return in_sOriginalClassName + sm_sClassNameAdaptation;
	}
	
}
