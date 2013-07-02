package net.sf.parteg.base.testcasetree;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.parteg.base.testcasetree.dialogs.ConfigurationSetter;
import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;

public class Configuration {

	public enum OUTPUTFORMAT
	{
		JUNIT_3_8,
		JUNIT_4_3
	};
	
	public enum TransitionBasedCoverageCriterion
	{
		STATE_COVERAGE,
		TRANSITION_COVERAGE,
		STOP_AFTER_ONE_LOOP_COVERAGE,
		ALL_ONE_LOOP_PATHS_COVERAGE
	};

	public enum BoundaryBasedCoverageCriterion
	{
		NONE,
		MULTI_DIMENSIONAL
	}

	// output format
	private static OUTPUTFORMAT sm_eOutputFormat = OUTPUTFORMAT.JUNIT_4_3;

	// transition-based coverage criterion
	private static TransitionBasedCoverageCriterion sm_eTransitionBasedCoverageCriterion = TransitionBasedCoverageCriterion.STATE_COVERAGE;
	
	// boundary-based coverage criterion
	private static BoundaryBasedCoverageCriterion sm_eBoundaryBasedCoverageCriterion = BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL;
	
	// transition names
	private static String sm_sDefaultTransitionName = "default";
	
	// naming configuration
	private static String sm_sWorkspacePath = "";
	private static String sm_sLocalSourceDirectory = "";
	private static String sm_sFileName = "";
	private static String sm_sMetamodelExtesion = ".ecore";
	private static String sm_sModelExtension = ".xmi";
	
	// test case graph configuration
	private static int sm_nMaximalTestGraphDepth = 2;
	private static int sm_nMaximalStatemachineDepth = 2;
	
	// OCL annotations
	private static String sm_sOCLOCL;
	private static String sm_sOCLGuard;
	private static String sm_sOCLPrecondition;
	private static String sm_sOCLPostcondition;
	private static String sm_sOCLInvariant;
	
	// file output
	private static String sm_sTestFileOutputName;
	private static String sm_sTestFileOutputFileType;
	private static HashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class> 
		sm_colStateMachineContextClass = new HashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class>();
	private static HashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>>
		sm_colStateMachineContextClasses = new HashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>>();
	private static String sm_sHandleEventFunctionName;
	
	// namespace settings
	private static String sm_sTestFilePackage;
	
	// coverage criteria
	private static HashMap<String, TransitionBasedCoverageCriterion> 
		m_colName2Coverage = new HashMap<String, TransitionBasedCoverageCriterion>(); 
	
	// test value domain setting
	private static Double sm_nDomainBorderDistance = 0.1;
	private static Integer sm_nNumberOfRandomNumbersPerDomain = 1;
	// generate values for partitions "between" (= filling the "gaps" of) the original partitions
	private static boolean sm_bCompletenessForGeneratedPartitions = true;
	
	private static boolean sm_bMaximumReduction = true;
	private static Double sm_nLowerDomainBoundary = Double.NEGATIVE_INFINITY;
	private static Double sm_nUpperDomainBoundary = Double.POSITIVE_INFINITY;

	private static HashMap<String, Configuration.OUTPUTFORMAT> sm_colOutputFormat = new HashMap<String, OUTPUTFORMAT>();

	
	public static void defaultConfig()
	{
		sm_colStateMachineContextClass.clear();
		
		sm_sFileName = "test";
		
		sm_sTestFileOutputName = "TestCases";
		sm_sTestFileOutputFileType = ".java";
		sm_sHandleEventFunctionName = "handleEvent";
		sm_sTestFilePackage = "";
	
		// graph configuration
		sm_nMaximalTestGraphDepth = 20;
		sm_nMaximalStatemachineDepth = 10;
		// graph configuration - needed
		GeneratedPackage.eINSTANCE.setNsURI("http://default");
		
		sm_sOCLOCL = "OCL";
		sm_sOCLGuard = "GUARD";
		sm_sOCLPrecondition = "PRE";
		sm_sOCLPostcondition = "POST";
		sm_sOCLInvariant = "INV";
		
		sm_nDomainBorderDistance = 0.1;
		
		// TODO JUnit 3.8 in config aufnehmen
		//sm_colOutputFormat.put("JUnit 3.8", Configuration.OUTPUTFORMAT.JUNIT_3_8);
		sm_colOutputFormat.put("JUnit 4.3", Configuration.OUTPUTFORMAT.JUNIT_4_3);
		
		m_colName2Coverage.put("State Coverage", Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE);
		m_colName2Coverage.put("Transition Coverage", Configuration.TransitionBasedCoverageCriterion.TRANSITION_COVERAGE);
		m_colName2Coverage.put("Stop-After-One-Loop-Paths Coverage", Configuration.TransitionBasedCoverageCriterion.STOP_AFTER_ONE_LOOP_COVERAGE);
		m_colName2Coverage.put("All-One-Loop-Paths Coverage", Configuration.TransitionBasedCoverageCriterion.ALL_ONE_LOOP_PATHS_COVERAGE);
	}
	


	public static void setValuesToConfigurationSetter(ConfigurationSetter io_oConfigurationSetter)
	{
		io_oConfigurationSetter.setOutputFileName(sm_sTestFileOutputName);
		io_oConfigurationSetter.setSMEventHandleFunction(sm_sHandleEventFunctionName);
		io_oConfigurationSetter.setStateMachineContextClasses(sm_colStateMachineContextClasses);
		io_oConfigurationSetter.setCoverageCriteria(m_colName2Coverage);
		io_oConfigurationSetter.setOutputFormat(sm_colOutputFormat);
	}
	
	public static void setOutputFormat(OUTPUTFORMAT in_eFormatEnum)
	{
		sm_eOutputFormat = in_eFormatEnum;
	}
	
	public static OUTPUTFORMAT getOutputFormat()
	{
		return sm_eOutputFormat;
	}
	
	public static void getValuesFromConfigurationSetter(ConfigurationSetter in_oConfigurationSetter)
	{
		sm_sTestFileOutputName = in_oConfigurationSetter.getOutputFileName();
		sm_sHandleEventFunctionName = in_oConfigurationSetter.getSMEventHandleFunction();
	}
	
	private static String getWorkspacePath()
	{
		return sm_sWorkspacePath;
	}
	
	public static void setWorkspacePath(String in_sWorkSpacePath)
	{
		sm_sWorkspacePath = in_sWorkSpacePath;
	}
	
	private static String getLocalSourceDirectory()
	{
		return sm_sLocalSourceDirectory;
	}

	public static void setLocalSourceDirectory(String in_sLocalSourceDirectory)
	{
		sm_sLocalSourceDirectory = in_sLocalSourceDirectory;
	}
	
	private static String getOutputPath()
	{
		return getWorkspacePath() + getLocalSourceDirectory();
	}
	
	public static String getEcoreOutput()
	{
		return getOutputPath() + sm_sFileName + sm_sMetamodelExtesion;
	}

	public static String getEcoreOutput(String in_sName)
	{
		return getOutputPath() + in_sName + sm_sMetamodelExtesion;
	}

	public static String getXMIOutput()
	{
		return getOutputPath() + sm_sFileName + sm_sModelExtension;
	}
	
	public static String getTestCaseOutputName()
	{
		return sm_sTestFileOutputName;
	}

	public static void setTestCaseOutputName(String in_sFileName)
	{
		sm_sTestFileOutputName = in_sFileName;
	}
	
	public static String getTestCaseOutput()
	{
		return getOutputPath() + sm_sTestFileOutputName + sm_sTestFileOutputFileType;
	}
	
	public static void setTestFilePackage(StateMachine in_oStateMachine)
	{
		sm_sTestFilePackage = SystemModelHelper.getNamespaceName(in_oStateMachine.getNearestPackage());
	}
	
	public static String getTestFilePackage()
	{
		return sm_sTestFilePackage;
	}
		
	public static int getMaximalTestGraphDepth()
	{
		return sm_nMaximalTestGraphDepth;
	}

	public static int getMaximalStatemachineDepth()
	{
		return sm_nMaximalStatemachineDepth;
	}
	
	public static String getOCLId()
	{
		return sm_sOCLOCL;
	}

	public static String getOCLGuardId()
	{
		return sm_sOCLGuard;
	}
	
	public static String getOCLPreId()
	{
		return sm_sOCLPrecondition;
	}

	public static String getOCLPostId()
	{
		return sm_sOCLPostcondition;
	}
	
	public static String getOCLInvId()
	{
		return sm_sOCLInvariant;
	}
	
	public static Double getDomainBorderDistance()
	{
		return sm_nDomainBorderDistance;
	}
	
	public static Integer getNumberOfRandomValuesPerDomain()
	{
		return sm_nNumberOfRandomNumbersPerDomain;
	}
	
	public static boolean isMaximumReduction()
	{
		return sm_bMaximumReduction;
	}

	public static Double getLowerDomainBoundary()
	{
		return sm_nLowerDomainBoundary;
	}
	
	public static Double getUpperDomainBoundary()
	{
		return sm_nUpperDomainBoundary;
	}
	
	public static String getHandleEventFunctionName()
	{
		return sm_sHandleEventFunctionName;
	}
	
	public static void putContextClass(StateMachine in_oStateMachine, org.eclipse.uml2.uml.Class in_oContextClass)
	{
		sm_colStateMachineContextClass.put(in_oStateMachine, in_oContextClass);
	}
	
	public static org.eclipse.uml2.uml.StateMachine getStateMachineOfVertex(Vertex in_oVertex)
	{
		if(in_oVertex.getContainer().getStateMachine() != null)
			return in_oVertex.getContainer().getStateMachine();
		if(in_oVertex.getContainer().getState() != null)
			return getStateMachineOfVertex(in_oVertex.getContainer().getState());
		return null;
	}
	
	public static org.eclipse.uml2.uml.Class getContextClass(StateMachine in_oStateMachine)
	{
		return sm_colStateMachineContextClass.get(in_oStateMachine);
	}
	
	public static org.eclipse.uml2.uml.Class getContextClassForVertex(Vertex in_oVertex)
	{
		return getContextClass(getStateMachineOfVertex(in_oVertex));
	}
	
	public static Set<org.eclipse.uml2.uml.Class> getPossibleContextClasses(Region in_oRegion)
	{
		return sm_colStateMachineContextClasses.get(in_oRegion);
	}
	
	public static HashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class> getStateMachineClassMap()
	{
		return sm_colStateMachineContextClass;
	}
	
	public static void initializeCollectionsOfContextClasses(StateMachine in_oStateMachine)
	{
		// find all classes in this package hierarchy
		Package oPackage = SystemModelHelper.getSuperPackage(in_oStateMachine);
		
		// remove all existing mappings
		sm_colStateMachineContextClasses.clear();
		
		// get all classes in this package
		Set<org.eclipse.uml2.uml.Class> colClasses = new LinkedHashSet<org.eclipse.uml2.uml.Class>();
		SystemModelHelper.getAllContainedClasses(oPackage, colClasses);
		
		org.eclipse.uml2.uml.Class oClass = SystemModelHelper.getClassForStateMachine(in_oStateMachine);
		
		sm_colStateMachineContextClasses.put(in_oStateMachine, 
			SystemModelHelper.getSubClasses(oClass, colClasses));
			
		// default: associated class
		sm_colStateMachineContextClass.put(in_oStateMachine, oClass);		
	}

	public static boolean isCompletenessForGeneratedPartitions() {
		return sm_bCompletenessForGeneratedPartitions;
	}

	public static void setCompletenessForGeneratedPartitions(
			boolean in_bCompletenessForGeneratedPartitions) {
		sm_bCompletenessForGeneratedPartitions = in_bCompletenessForGeneratedPartitions;
	}

	public static String getDefaultTransitionName() {
		return sm_sDefaultTransitionName;
	}

	public static TransitionBasedCoverageCriterion getTransitionBasedCoverageCriterion() {
		return sm_eTransitionBasedCoverageCriterion;
	}

	public static void setTransitionBasedCoverageCriterion(
			TransitionBasedCoverageCriterion sm_eTransitionBasedCoverageCriterion) {
		Configuration.sm_eTransitionBasedCoverageCriterion = sm_eTransitionBasedCoverageCriterion;
	}

	public static BoundaryBasedCoverageCriterion getBoundaryBasedCoverageCriterion() {
		return sm_eBoundaryBasedCoverageCriterion;
	}

	public static void setBoundaryBasedCoverageCriterion(
			BoundaryBasedCoverageCriterion sm_eBoundaryBasedCoverageCriterion) {
		Configuration.sm_eBoundaryBasedCoverageCriterion = sm_eBoundaryBasedCoverageCriterion;
	}
}
