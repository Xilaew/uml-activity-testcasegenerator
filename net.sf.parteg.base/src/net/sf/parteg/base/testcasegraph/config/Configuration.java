package net.sf.parteg.base.testcasegraph.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.helperclasses.SystemModelHelper;
import net.sf.parteg.base.testcasegraph.helperclasses.UMLStateMachineHelperClass;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Vertex;

public class Configuration {

	public static String getProgramVersion() {
		return "1.4";
	}
	
	public enum OUTPUTFORMAT
	{
		JUNIT_3_8,
		JUNIT_4_3,
		JAVA_MUTATION_ANALYSIS,
		JAVA_PRIORITIZAION_ANALYSIS,
		JAVA_PRIORITIZAION_ANALYSIS_ALL,
		JAVA_PRIORITIZAION_ANALYSIS_ALL_REPETITION,
		CPP_UNIT_1_12
	};
	
	public enum LoggerLevel
	{
		NONE,
		MINIMUM,
		MAXIMUM
	}
	
	public enum ExceptionTarget
	{
		CONSOLE,
		MESSAGEBOX
	}
	
	private static ExceptionTarget sm_eExceptionTarget = ExceptionTarget.CONSOLE;
	private static List<Exception> sm_colExceptionList = new ArrayList<Exception>();
	
	private static StateMachine sm_oActiveStateMachine = null;
	
	// how many random values should be selected per domain?
	private static int sm_nNumberOfRandomElementsPerDomain = 1;
	
	// include the search for mutual dependent input parameters
	// TODO remove this flag: only used temporarily
	private static boolean sm_bSearchForMutualDependentInputParameters = true;
	
	// priority of transitions
	private static boolean sm_bInnerTransitionHasPriorityOverOuterTransition = true;
	
	// control flow-based coverage criteria: also consider events at states
	// where they do not cause a state change? 
	private static boolean sm_bCreateTestGoalsForUncalledEvents = false;
	
	// deal with guard conditions: enforce that guards are unambiguous
	private static boolean sm_bEnforceUnambiguousGuardsAndEvents = true;

	// deal with guard conditions: enforce that guards are unambiguous
	private static boolean sm_bEnforceUnambiguousTestGoals = true;

	// add test goal conditions for a unique target state?
	private static boolean sm_bAddConditionsForUniqueTargetState = true;
	
	// create test goals: split inequations before test goal generation?
	private static boolean sm_bSplitInequationsBeforeTestGoalDefinition = false;
	
	// flat state machine or hierarchical?
	private static boolean sm_bFlattenStateMachineWithStateComposition = false;
	
	// duplicate test goals for contained nodes 
	private static boolean sm_bDuplicateTestGoalsForContainedNodes = false;
	
	// split up transitions so that each transitions has at most one event?
	private static boolean sm_bSplitUpTransitionsToOneEventLimit = false;
	
	// simulate offline testing (no post-optimization)?
	private static boolean sm_bEnablePostOptimization = true;
	
	// transition names
	private static String sm_sDefaultTransitionName = "default";
	
	// naming configuration
	private static String sm_sWorkspacePath = "";
	private static String sm_sLocalSourceDirectory = "";
	private static String sm_sFileName = "test";
	private static String sm_sMetamodelExtesion = ".ecore";
	private static String sm_sModelExtension = ".xmi";
	
	// OCL annotations
	private static String sm_sOCLOCL = "OCL";
	private static String sm_sOCLGuard = "GUARD";
	private static String sm_sOCLPrecondition = "PRE";
	private static String sm_sOCLPostcondition = "POST";
	private static String sm_sOCLInvariant = "INV";
	
	private static boolean sm_bPrintDefaultEvents = false;
	
	private static String sm_sTestFileOutputName = "TestCases";
	private static int sm_nNumberOfFilesToSplitOutputTo = 1;
	
	private static String sm_sLoggerOutputFile = "Log.txt";
	
	private static String sm_sHandleEventFunctionName = "handleEvent";
	private static HashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class> 
		sm_colStateMachineContextClass = new LinkedHashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class>();
	private static HashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>>
		sm_colStateMachineContextClasses = new LinkedHashMap<org.eclipse.uml2.uml.StateMachine, Set<org.eclipse.uml2.uml.Class>>();
	
	private static LoggerLevel m_oTestLoggerLevel = LoggerLevel.NONE;
	
	// namespace settings
	private static String sm_sTestFilePackage = "";
	
	// test value domain setting
	private static Double sm_nLowerDomainBoundary = Double.NEGATIVE_INFINITY;
	private static Double sm_nUpperDomainBoundary = Double.POSITIVE_INFINITY;

	// optimistic optimization switch for test path finding
	private static boolean sm_bOptimisticSearch = true;
	
	// also use extended else conditions for test goals? 
	private static boolean sm_bUseElseForTestGoals = false;
	
	// split up decision nodes corresponding to their incoming transitions?
	private static boolean sm_bSplitUpDecisionNodes = false;
	
	// transform initial and final nodes to connectionpoints 
	private static boolean sm_bTransformInitialAndFinalStates = false;
	
	// output format
	private static OUTPUTFORMAT sm_eOutputFormat = OUTPUTFORMAT.JUNIT_4_3;
	private static HashMap<String, Configuration.OUTPUTFORMAT> 
			sm_colOutputFormat = getDefaultOutputFormat(); 

	private static HashMap<String, Configuration.OUTPUTFORMAT> getDefaultOutputFormat()
	{
		HashMap<String, Configuration.OUTPUTFORMAT> colResultValue =
			new LinkedHashMap<String, Configuration.OUTPUTFORMAT>();
		colResultValue.put("JUnit 3.8", 
				Configuration.OUTPUTFORMAT.JUNIT_3_8);
		colResultValue.put("JUnit 4.3", 
				Configuration.OUTPUTFORMAT.JUNIT_4_3);
		colResultValue.put("Java Mutation Analysis", 
				Configuration.OUTPUTFORMAT.JAVA_PRIORITIZAION_ANALYSIS_ALL);
		return colResultValue;
	}
	
	
	public static void defaultConfig(org.eclipse.uml2.uml.Package in_oPackage)
	{
		sm_colStateMachineContextClass.clear();
		sm_colStateMachineContextClasses.clear();
		
		List<StateMachine> colStateMachines = new ArrayList<StateMachine>();
		getAllStateMachinesFromNamespace(in_oPackage, colStateMachines);
		initializeCollectionsOfContextClasses(colStateMachines, in_oPackage);
		
		// graph configuration - needed
		GeneratedPackage.eINSTANCE.setNsURI("http://default");
	}

	public static void defaultConfig(StateMachine in_oStateMachine) 
	{
		defaultConfig(UMLStateMachineHelperClass.getPackageOfStateMachine(in_oStateMachine));
		
		setActiveStateMachine(in_oStateMachine);
		setTestFilePackage(in_oStateMachine);
	}
	
	private static void getAllStateMachinesFromNamespace(
			Namespace in_oPackage, 
			List<StateMachine> io_colStateMachines) {

		ArrayList<org.eclipse.uml2.uml.Namespace> colNamespaceList = new ArrayList<org.eclipse.uml2.uml.Namespace>();
		for(NamedElement oPackElem : in_oPackage.getOwnedMembers())
		{
			if(oPackElem instanceof StateMachine)
			{
				io_colStateMachines.add((StateMachine)oPackElem);
			}
			else if(oPackElem instanceof org.eclipse.uml2.uml.Package)
			{
				colNamespaceList.add((org.eclipse.uml2.uml.Package)oPackElem);
			}
			else if(oPackElem instanceof org.eclipse.uml2.uml.Class)
			{
				colNamespaceList.add((org.eclipse.uml2.uml.Class)oPackElem);				
			}
		}
		
		for(org.eclipse.uml2.uml.Namespace oNamespace : colNamespaceList)
		{
			getAllStateMachinesFromNamespace(oNamespace, io_colStateMachines);
		}
	}

	public static HashMap<String, Configuration.OUTPUTFORMAT> getOutputFormatCollection() {
		return sm_colOutputFormat;
	}
	
	public static StateMachine getActiveStateMachine() {
		return sm_oActiveStateMachine;
	}
	
	public static void setActiveStateMachine(StateMachine in_oStateMachine) {
		sm_oActiveStateMachine = in_oStateMachine;
	}
	
	public static void setOutputFormat(OUTPUTFORMAT in_eFormatEnum)
	{
		sm_eOutputFormat = in_eFormatEnum;
	}
	
	public static OUTPUTFORMAT getOutputFormat()
	{
		return sm_eOutputFormat;
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
	
	public static String getOutputPath()
	{
		return getWorkspacePath() + getLocalSourceDirectory();
	}
	
	public static String getEcoreOutput()
	{
		return getOutputPath() + sm_sFileName + sm_sMetamodelExtesion;
	}

	public static String getXMIOutput()
	{
		return getOutputPath() + sm_sFileName + sm_sModelExtension;
	}
	
	public static boolean getPrintDefaultEvents()
	{
		return sm_bPrintDefaultEvents;
	}

	public static void setPrintDefaultEvents(boolean in_bPrintDefaultEvents)
	{
		sm_bPrintDefaultEvents = in_bPrintDefaultEvents;
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
		return getOutputPath() + getTestCaseOutputName();
	}

	public static String getLoggerOutput()
	{
		return getOutputPath() + getTestCaseOutputName() + sm_sLoggerOutputFile;
	}
	
	public static void setTestFilePackage(StateMachine in_oStateMachine)
	{
		sm_sTestFilePackage = SystemModelHelper.getNamespaceName(in_oStateMachine.getNearestPackage());
	}

	public static void setTestFilePackage(String in_sPackageName)
	{
		sm_sTestFilePackage = in_sPackageName;
	}	
	
	public static String getTestFilePackage()
	{
		return sm_sTestFilePackage;
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
	
	public static Double getLowerDomainBoundary() {
		return sm_nLowerDomainBoundary;
	}
	
	public static Double getUpperDomainBoundary() {
		return sm_nUpperDomainBoundary;
	}
	
	public static String getHandleEventFunctionName()
	{
		return sm_sHandleEventFunctionName;
	}

	public static void setHandleEventFunctionName(String in_sName)
	{
		sm_sHandleEventFunctionName = in_sName;
	}

	public static void putContextClass(StateMachine in_oStateMachine, org.eclipse.uml2.uml.Class in_oContextClass)
	{
		sm_colStateMachineContextClass.put(in_oStateMachine, in_oContextClass);
	}
	
	public static org.eclipse.uml2.uml.StateMachine getStateMachineOfVertex(Vertex in_oVertex)
	{
		if(in_oVertex instanceof Pseudostate)
		{
			if(((Pseudostate)in_oVertex).getState() != null) {
				return getStateMachineOfVertex(((Pseudostate)in_oVertex).getState());
			}
			else if(((Pseudostate)in_oVertex).getStateMachine() != null) {
				return (((Pseudostate)in_oVertex).getStateMachine());
			}
		}
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
	
	public static Set<org.eclipse.uml2.uml.Class> getPossibleContextClasses(StateMachine in_oStateMachine)
	{
		return sm_colStateMachineContextClasses.get(in_oStateMachine);
	}
	
	public static HashMap<org.eclipse.uml2.uml.StateMachine, org.eclipse.uml2.uml.Class> getStateMachineClassMap()
	{
		return sm_colStateMachineContextClass;
	}
	
	private static void initializeCollectionsOfContextClasses(
			List<StateMachine> in_colStateMachine,
			org.eclipse.uml2.uml.Package in_oPackage)
	{
		//
		sm_colExceptionList.clear();
		
		// remove all existing mappings
		sm_colStateMachineContextClasses.clear();

		// find all classes in this package hierarchy
		Set<org.eclipse.uml2.uml.Class> colClasses = new LinkedHashSet<org.eclipse.uml2.uml.Class>();
		SystemModelHelper.getAllContainedClasses(in_oPackage, colClasses);

		for(StateMachine oStateMachine : in_colStateMachine) {
			
			org.eclipse.uml2.uml.Class oClass = SystemModelHelper.getClassForStateMachine(oStateMachine);
			
			sm_colStateMachineContextClasses.put(oStateMachine, 
				SystemModelHelper.getSubClasses(oClass, colClasses));
				
			// default: associated class
			sm_colStateMachineContextClass.put(oStateMachine, oClass);		
		}
	}

	public static String getDefaultTransitionName() {
		return sm_sDefaultTransitionName;
	}

	public static boolean getSplitInequationsBeforeTestGoalDefinition()
	{
		return sm_bSplitInequationsBeforeTestGoalDefinition;
	}
	
	public static void setSplitInequationsBeforeTestGoalDefinition(
			boolean in_bSplitInequationsBeforeTestGoalDefinition)
	{
		sm_bSplitInequationsBeforeTestGoalDefinition =
			in_bSplitInequationsBeforeTestGoalDefinition;
	}
	
	public static boolean getDuplicateTestGoalsForContainedNodes() {
		return sm_bDuplicateTestGoalsForContainedNodes;
	}
	
	public static void setDuplicateTestGoalsForContainedNodes(boolean in_bValue) {
		sm_bDuplicateTestGoalsForContainedNodes = in_bValue;
	}
	
	public static boolean getFlattenStateMachineWithStateComposition() {
		return sm_bFlattenStateMachineWithStateComposition;
	}
	
	public static void setFlattenStateMachineWithStateComposition(boolean in_bFlatten)
	{
		sm_bFlattenStateMachineWithStateComposition = in_bFlatten;
	}
	
	public static void setUseElseForTestGoals(boolean in_bValue)
	{
		sm_bUseElseForTestGoals = in_bValue;
	}
	
	public static boolean getUseElseForTestGoals()
	{
		return sm_bUseElseForTestGoals;
	}
	
	public static void setSplitUpDecisionNodes(boolean in_bValue)
	{
		sm_bSplitUpDecisionNodes = in_bValue;
	}
	
	public static boolean getSplitUpDecisionNodes()
	{
		return sm_bSplitUpDecisionNodes;
	}
	
	public static void setTransformInitialAndFinalStates(boolean in_bValue)
	{
		sm_bTransformInitialAndFinalStates = in_bValue;
	}
	
	public static boolean getTransformInitialAndFinalStates()
	{
		return sm_bTransformInitialAndFinalStates;
	}
		
	public static void setLoggerLevel(LoggerLevel in_oLoggerLevel)
	{
		m_oTestLoggerLevel = in_oLoggerLevel;
	}
	
	public static LoggerLevel getLoggerlevel()
	{
		return m_oTestLoggerLevel;
	}
	
	public static boolean getOptimisticSearch()
	{
		return sm_bOptimisticSearch;
	}
	
	public static void setOptimisticSearch(boolean in_bValue)
	{
		sm_bOptimisticSearch = in_bValue;
	}
	
	public static boolean isPostOptimizationEnabled()
	{
		return sm_bEnablePostOptimization;
	}
	
	public static void setPostOptimizationEnabled(boolean in_bValue)
	{
		sm_bEnablePostOptimization = in_bValue;
	}
	
	public static void setSplitUpTransitionsToOneEventLimit(boolean in_bValue) {
		sm_bSplitUpTransitionsToOneEventLimit = in_bValue;
	}
	public static boolean getSplitUpTransitionsToOneEventLimit() {
		return sm_bSplitUpTransitionsToOneEventLimit;
	}
	
	public static boolean getEnforceUnambiguousGuardsAndEvents() {
		return sm_bEnforceUnambiguousGuardsAndEvents;
	}
	public static void setEnforceUnambiguousGuardsAndEvents(boolean in_bValue) {
		sm_bEnforceUnambiguousGuardsAndEvents = in_bValue;
	}
	
	public static boolean getEnforceUnambiguousTestGoals() {
		return sm_bEnforceUnambiguousTestGoals;
	}
	public static void setEnforceUnambiguousTestGoals(boolean in_bValue) {
		sm_bEnforceUnambiguousTestGoals = in_bValue;
	}
	
	public static boolean getAddConditionsForUniqueTargetState() {
		return sm_bAddConditionsForUniqueTargetState;
	}
	public static void setAddConditionsForUniqueTargetState(boolean in_bValue) {
		sm_bAddConditionsForUniqueTargetState = in_bValue;
	}

	public static boolean isCreateTestGoalsForUncalledEvents() {
		return sm_bCreateTestGoalsForUncalledEvents;
	}
	public static void setCreateTestGoalsForUncalledEvents(
			boolean in_bCreateTestGoalsForUnnamedEvents) {
		sm_bCreateTestGoalsForUncalledEvents = in_bCreateTestGoalsForUnnamedEvents;
	}

	public static boolean isSearchForMutualDependentInputParameters() {
		return sm_bSearchForMutualDependentInputParameters;
	}
	public static void setSearchForMutualDependentInputParameters(
			boolean sm_bSearchForMutualDependentInputParameters) {
		Configuration.sm_bSearchForMutualDependentInputParameters = sm_bSearchForMutualDependentInputParameters;
	}


	public static int getNumberOfFilesToSplitOutputTo() {
		return sm_nNumberOfFilesToSplitOutputTo;
	}
	public static void setNumberOfFilesToSplitOutputTo(
			int in_nNumberOfFilesToSplitOutputTo) {
		sm_nNumberOfFilesToSplitOutputTo = in_nNumberOfFilesToSplitOutputTo;
	}


	public static boolean isInnerTransitionHasPriorityOverOuterTransition() {
		return sm_bInnerTransitionHasPriorityOverOuterTransition;
	}
	public static void setInnerTransitionHasPriorityOverOuterTransition(
			boolean in_bInnerTransitionHasPriorityOverOuterTransition) {
		sm_bInnerTransitionHasPriorityOverOuterTransition = 
			in_bInnerTransitionHasPriorityOverOuterTransition;
	}


	public static ExceptionTarget getExceptionTarget() {
		return sm_eExceptionTarget;
	}


	public static void setExceptionTarget(ExceptionTarget sm_eExceptionTarget) {
		Configuration.sm_eExceptionTarget = sm_eExceptionTarget;
	}
	
	public static void handleException(Exception e) {
		
		// TODO Error Log einbauen!
		if(getExceptionTarget().equals(ExceptionTarget.CONSOLE)) {
			e.printStackTrace(System.err);
		}
		else if(getExceptionTarget().equals(ExceptionTarget.MESSAGEBOX)) {
			sm_colExceptionList.add(e);
//			Shell shell = new Shell();
//			MessageDialog.openInformation(
//				shell,
//				"ParTeG Plug-in",
//				"ERROR: " + e.getLocalizedMessage());
		}
	}
	
	public static List<Exception> getExceptionList() {
		return sm_colExceptionList;
	}
	
	public static void printExceptionList() {
		if(!sm_colExceptionList.isEmpty()) {
			
			StringBuffer sMessages = new StringBuffer();
			int nCounter = 1;
			for(Exception e : sm_colExceptionList) {
				sMessages.append(
						System.getProperty("line.separator")
						+ nCounter + ") "
						+ e.getLocalizedMessage());
				++nCounter;
			}
			
			Shell shell = new Shell();
			MessageDialog.openInformation(
				shell,
				"ParTeG Plug-in",
				"ERROR: " + sMessages.toString());
		}
	}

	public static int getNumberOfRandomElementsPerDomain() {
		return sm_nNumberOfRandomElementsPerDomain;
	}

	public static void setNumberOfRandomElementsPerDomain(
			int in_nNumberOfRandomElementsPerDomain) {
		sm_nNumberOfRandomElementsPerDomain = in_nNumberOfRandomElementsPerDomain;
	}
	
}
