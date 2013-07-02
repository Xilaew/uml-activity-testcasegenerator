package net.sf.parteg.output.testgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria;
import net.sf.parteg.base.testcasegraph.config.TemporalConfiguration;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionInstanceHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgeneration.LateEvaluationGroup;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.base.testcasegraph.valueselection.TestCaseValueDomainBorderSelector;
import net.sf.parteg.base.testcasegraph.valueselection.TestCaseValueRandomSelector;
import net.sf.parteg.base.testcasegraph.valueselection.TestCaseValueSelector;
import net.sf.parteg.base.testcasegraph.valuetyperanges.OCLExpressionValueTypeRangeFactory;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.testcase.TestCaseValidValue;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputConfigurator;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputCppUnit_1_12;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJUnit_3_8;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJUnit_4_3;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJavaMutantAnalysis;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJavaPrioritizationAnalysis;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJavaPrioritizationAnalysisSystemCalls;
import net.sf.parteg.output.testgraph.languages.TestCaseGraphOutputJavaPrioritizationAnalysisSystemCallsRepetition;

public class TestCaseExporter {

	private ArrayList<TestCaseGraphOutputConfigurator> m_colOutputConfigurators;
	private TestCaseValueSelector m_oValueSelector;
	
	public TestCaseExporter(TestCaseGraphHelper in_oTCGHelper) throws Exception
	{
		m_colOutputConfigurators = new ArrayList<TestCaseGraphOutputConfigurator>();
		
		if(ConfigurationCoverageCriteria.getBoundaryBasedCoverageCriterion() == 
			ConfigurationCoverageCriteria.BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL)
		{
			m_oValueSelector = new TestCaseValueDomainBorderSelector(false, false);
		}
		else if(ConfigurationCoverageCriteria.getBoundaryBasedCoverageCriterion() == 
			ConfigurationCoverageCriteria.BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL_AT_BOUNDARIES)
		{
			m_oValueSelector = new TestCaseValueDomainBorderSelector(true, false);
		}
		else if(ConfigurationCoverageCriteria.getBoundaryBasedCoverageCriterion() == 
			ConfigurationCoverageCriteria.BoundaryBasedCoverageCriterion.RANDOM)
		{
			m_oValueSelector = new TestCaseValueRandomSelector(false);
		}

		if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JUNIT_4_3) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJUnit_4_3(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JUNIT_3_8) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJUnit_3_8(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JAVA_MUTATION_ANALYSIS) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJavaMutantAnalysis(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JAVA_PRIORITIZAION_ANALYSIS) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJavaPrioritizationAnalysis(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JAVA_PRIORITIZAION_ANALYSIS_ALL) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJavaPrioritizationAnalysisSystemCalls(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.JAVA_PRIORITIZAION_ANALYSIS_ALL_REPETITION) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputJavaPrioritizationAnalysisSystemCallsRepetition(in_oTCGHelper));
		}
		else if(Configuration.getOutputFormat() == Configuration.OUTPUTFORMAT.CPP_UNIT_1_12) {
			m_colOutputConfigurators.add(new TestCaseGraphOutputCppUnit_1_12(in_oTCGHelper));
		}
		else
			throw new Exception("no output format selected");
	}
	
	/*
	 * creates output for the whole generated test suite + concrete test value selection
	 */
	public void print(TestSuite in_oTestSuite) throws Exception
	{
		// split up the whole test suite according to the number of generated files
		List<TestSuite> colTestSuites =
			splitTestSuiteAccordingToConfiguration(in_oTestSuite);
		for(int i = 0; i < colTestSuites.size(); ++i) {
			TestSuite oTestSuite = colTestSuites.get(i);
			if(i > 0) {
				// set global prefix for class names of generated files
				TemporalConfiguration.setClassNameAdaptation(String.valueOf(i));
			}
		
			for(TestCaseGraphOutputConfigurator oConfigurator : m_colOutputConfigurators) {
				
//				// initializes output file
//				m_oPrintStream = new PrintStream(
//						new FileOutputStream(
//								TemporalConfiguration.getClassNameAdaptation(
//										Configuration.getTestCaseOutput()) 
//								+ oConfigurator.getFileType()));
//				
//				for(FormattedOutput oFormattedOutput : oConfigurator.getFormattedOutput()) {
//					oFormattedOutput.setPrintStream(m_oPrintStream);
//				}
				
				// start print streams (create + initialize)
				oConfigurator.startPrintStreams();
				
				// write global start
				oConfigurator.createGlobalStart(oTestSuite);
		
				// write all test cases
				writeAllTestCases(oTestSuite, oConfigurator);
				
				// write global end
				oConfigurator.createGlobalEnd(oTestSuite);
				
				// end print streams (flush + close)
				oConfigurator.endPrintStreams();
			}
		}
	}
	
	private List<TestSuite> splitTestSuiteAccordingToConfiguration(
			TestSuite in_oTestSuite) {
		List<TestSuite> colRetValue = new ArrayList<TestSuite>();
		
		double nNumberOfTestCasesPerFile =
				(double)in_oTestSuite.getTestCases().size() /
				(double)Configuration.getNumberOfFilesToSplitOutputTo();
		double nCountRest = 0.0;
		Iterator<TestCase> oTestCaseIterator = in_oTestSuite.getTestCases().iterator();
		// create new test suites until the original test suite is completely copied
//		while(oTestCaseIterator.hasNext()) {
		for(int i = 0; i < Configuration.getNumberOfFilesToSplitOutputTo(); ++i) {
			int nTestCaseCounter = 1;
			TestSuite oNewTestSuite = new TestSuite();
			while((nTestCaseCounter <= nNumberOfTestCasesPerFile + nCountRest) ||
					i == Configuration.getNumberOfFilesToSplitOutputTo() - 1) {
				++nTestCaseCounter;
				if(oTestCaseIterator.hasNext()) {
					oNewTestSuite.getTestCases().add(
							oTestCaseIterator.next());
				}
				else {
					break;
				}
			}
			nCountRest = (nNumberOfTestCasesPerFile + nCountRest + 1 - nTestCaseCounter);
			if(!oNewTestSuite.getTestCases().isEmpty())
				colRetValue.add(oNewTestSuite);
		}
		
		return colRetValue;
	}

	/*
	 * calls the output configurator to write all test cases
	 */
	private void writeAllTestCases(
			TestSuite in_oTestSuite,
			TestCaseGraphOutputConfigurator in_oConfigurator)
	{
		// TODO Testausgabe und Grenzwertanalyse trennen?
		
		// write all test cases
		for(TestCase oTestCase : in_oTestSuite.getTestCases()) {
			// collect all used parameter instances
			ArrayList<EventParameterInstance> colEventParameterInstances = 
				new ArrayList<EventParameterInstance>();
			Map<EventParameterInstance, ArrayList<TestCaseValidValue>> colParameterValues = 
				new LinkedHashMap<EventParameterInstance, ArrayList<TestCaseValidValue>>();
			// default init
			colEventParameterInstances = oTestCase.getAllParameterInstances();
			for(EventParameterInstance oEPInstance : colEventParameterInstances) {
				colParameterValues.put(oEPInstance, new ArrayList<TestCaseValidValue>());
			}
			List<EventParameterInstance> colDynamicEPIs =
				new ArrayList<EventParameterInstance>();
			
			// TODO for each group: Wie wird mit überlappenden Ausdrücken umgegangen?
			// Gruppen evtl. vorher kombinieren? .. anhand gleicher EventParameterInstances 
			
			// gegenseitiges Umformen der Ausdrücke, um evtl. auf fixe Grenzen zu stoßen
			
			// schrittweises Belegen von Werten -> Orientierung der anderen Parameterwerte daran
			// Map von Parametern auf Expressions: 
			// Auswertung der beeinflussenden Faktoren
			// den Wert mit den meisten Faktoren zuerst festlegen
			// Varianten für Initialwertbelegung falls keine fixen
			// Grenzen existieren? (-1, 0, 1, ...)?
			// danach die Grenzen der anderen Werte anpassen ... wie genau?
			// Idee1: die Ausdrücke nochmals auswerten, diesmal aber explizit für
			// zuvor festgelegten Werte benutzen (dazwischen-"mappen")
			// Idee2: für EventParameterInstances auch variable Grenzen definieren???
			
			
			/*
			 * Algorithmus für Auswertung:
			 * 1) alle Bedingungen einer Gruppe so oft es geht miteinander kombinieren
			 * 2) Wenn dabei welche mit nur einem InputParameter/Dependent herauskommen, dann
			 *    die entsprechenden EventInputParameter anpassen
			 * 3) Die Expressions nutzen, um die ValuePartitions aneinander anzupassen
			 *    (entsprechende Check-funktion schon beim Suchen einbauen!!!)
			 * 4) von den existierenden EPI den mit dem kleinsten Wertebereich auswählen
			 *    und mit einem konkreten Wert versehen
			 * 5) jetzt erneut alle Abhängigkeiten checken
			 *    -> daraufhin Wertebereiche aber nur temporär anpassen
			 *    -> schrittweise weitere EPI's mit Werten versehen
			 * 6) auf diesem Weg mehrere Kombinationen von Maps von EPIs auf Werte erzeugen
			 */
			// select values for parameter instances with variable boundaries
			for(LateEvaluationGroup oGroup : oTestCase.getLateEvaluationGroups()) {

				// hier alle Ausdrücke ohne input parameter auflösen ? -> Effekte sind etwas unklar
				List<EventParameterInstance> colEPIs = new ArrayList<EventParameterInstance>();
				colEPIs.addAll(oGroup.getParameterToAtoms().keySet());
				
				// ***
				// create combinations of testcasevalues for dynamic variables
				List<Map<EventParameterInstance, TestCaseValidValue>> colEPI2Values = 
					TestCaseValueSelector.createDynamicValuesForLateParameterInstanceValues(
							oGroup, colEPIs,
							new LinkedHashMap<EventParameterInstance, TestCaseValidValue>(),
							m_oValueSelector);
				
				for(Map<EventParameterInstance, TestCaseValidValue> oValue : colEPI2Values) {
					for(EventParameterInstance oEPI : oValue.keySet()) {
						colParameterValues.get(oEPI).add(oValue.get(oEPI));
						if(!colDynamicEPIs.contains(oEPI)) {
							colDynamicEPIs.add(oEPI);
						}
					}					
				}
			}
			
			// select values for all parameter instances with fixed boundaries
			colEventParameterInstances.removeAll(colDynamicEPIs);
			// check if elements of colEventParameterInstances are contained in late evaluation groups
			boolean bCreateValuesForFixedBoundaries = true;
			for(EventParameterInstance oEPInstance : colEventParameterInstances) {
				for(LateEvaluationGroup oGroup : oTestCase.getLateEvaluationGroups()) {
					if(oGroup.getParameterToAtoms().keySet().contains(oEPInstance)) {
						bCreateValuesForFixedBoundaries = false;
					}
				}
			}
			if(bCreateValuesForFixedBoundaries) {
				for(EventParameterInstance oEPInstance : colEventParameterInstances) {
					colParameterValues.put(oEPInstance, 
							m_oValueSelector.selectValues(
									oEPInstance.getValueRange()));
				}
			}
			// Idee: erst die Werte zusammen mit fixen Grenzen bestimmen, danach zuweisen
			

			HashMap<EventParameterInstance, TestCaseValidValue> colParameterValue = 
				new LinkedHashMap<EventParameterInstance, TestCaseValidValue>();
			
			if(Configuration.getPrintDefaultEvents() == false) {
				// if there is only one additional outgoing default trigger, then add the state invariant of its target state
//				addConditionsAfterLastDefaultCall(oTestCase);
				// only retain elements that can be checked before an event call
				// also remove default event calls
				removeConditionsForDefaultCalls(oTestCase);
			}
			
			writeTestCase(oTestCase, colParameterValue, 
					0, colParameterValues, in_oConfigurator);
		}
	}
	

	private void adaptValueTypeRangeToGroupExpressions(
			ValueTypeRange in_oTmpRange,
			EventParameterInstance in_oEPI,
			LateEvaluationGroup in_oGroup,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) {

		// easy expression evaluation: just consider one expression at a time
		for(TCGOCLExpression oExpression : in_oGroup.getLateSatisfiedConditions()) {
			
			List<TCGOCLAtom> colRemainingAtoms = new ArrayList<TCGOCLAtom>();
			// get the number of input parameters and dependent elements
			List<TCGOCLAtom> colAtoms = TCGOCLExpressionHelperClass.
				getPassiveDependentVariablesAndInputParameters(oExpression);
			// reduce the number by the event parameter instances
			for(TCGOCLAtom oTmpAtom : colAtoms) {
				boolean bValueForAtomIsAlreadyFixed = false;
				for(TCGOCLAtom oAtom : in_colCurrentValueAssignment.keySet()) {
					if(oTmpAtom.getElement().equals(oAtom.getElement())) {
						bValueForAtomIsAlreadyFixed = true;
						break;
					}
				}
				if(bValueForAtomIsAlreadyFixed == false) {
					colRemainingAtoms.add(oTmpAtom);
				}
			}
			
			// first: for each of the remaining unfixed values: 
			// try to find more restrictions caused by other attributes
			
			for(TCGOCLAtom oRemainingAtom : colRemainingAtoms) {
				// first: expression nach remaining atom umstellen
				TCGOCLExpressionHelperClass.shiftSubexpressionToTheLeft(
						oRemainingAtom, oExpression);
				// second: valuetyperange ermitteln
				ValueTypeRange oValueTypeRange = in_oTmpRange.clone();
				OCLExpressionValueTypeRangeFactory.
					getValueTypeRangeForRightSideOfExpression(
							oValueTypeRange, oExpression,
							in_colCurrentValueAssignment);
				// third: adapt range
				in_oTmpRange.adaptRange(oValueTypeRange);
			}
		}
	}

	
	private void removeConditionsForDefaultCalls(TestCase in_oTestCase)
	{
		for(int n = 0; n < in_oTestCase.getTransitionInstances().size(); ++n)
		{
			TransitionInstance oTransitionInstance = in_oTestCase.getTransitionInstances().get(n);
			
			// last event call is default
			if(previousEventCallIsDefault(in_oTestCase, n))
			{
				// remove guard condition and operation's precondition
				oTransitionInstance.getUsedPreConditions().clear();
			}

			// next event call is default
			if(nextEventCallIsDefaultOrNullAndTheGuardIsSatisfied(in_oTestCase, n, false))
			{
				// remove operations postcondition and following state invariant
				oTransitionInstance.getUsedPostConditions().clear();
			}
			if(nextEventCallIsDefaultOrNullAndTheGuardIsSatisfied(in_oTestCase, n, true))
			{
				oTransitionInstance.useNextStateInvariant(false);				
			}
		}
	}
	
	private void addConditionsAfterLastDefaultCall(TestCase in_oTestCase)
	{
		int n = in_oTestCase.getTransitionInstances().size() - 1;
		TransitionInstance oTransitionInstance = in_oTestCase.getTransitionInstances().get(n);
		List<TCGTransition> colAddedTransitions = new ArrayList<TCGTransition>(); // do not add the same transition twice!
		List<TransitionInstance> colTransitionInstances = new ArrayList<TransitionInstance>();
		colTransitionInstances.add(oTransitionInstance); // TODO why use only the last one? there can be more (parallelism) ...
		
		boolean bFoundAdditionalTransitions = true;
		while(bFoundAdditionalTransitions) {
			bFoundAdditionalTransitions = false;
			List<TransitionInstance> colTmpTransInst = new ArrayList<TransitionInstance>();
			
			for(TransitionInstance oTransInst : colTransitionInstances) {
//				if(TCGTransitionHelperClass.transitionHasNoEventTrigger(oTransInst.getTransition())) {
//				if(nextEventCallIsDefaultOrNull(in_oTestCase, n, false)) {
					// enlarge test case by the next few states
				if(oTransInst.getTransition() == null)
					continue;
				
				for(TCGNode oNode : TCGTransitionHelperClass.getTargetNodes(oTransInst.getTransition())) {
					List<TCGTransition> colOutgoingTransitions = TCGNodeHelperClass.getOutgoingTransitions(oNode);
					if(colOutgoingTransitions.size() == 1) { // TODO watch for parallelism
						TCGTransition oTransition = colOutgoingTransitions.get(0);
						if(TCGTransitionHelperClass.transitionHasNoEventTrigger(oTransition)) {
							if(colAddedTransitions.contains(oTransition))
								continue;
								
							if(TCGTransitionHelperClass.transitionHasNoEventTrigger(oTransition)) {
								TransitionInstance oNewTransitionInstance = new TransitionInstance(oTransition);
								in_oTestCase.getTransitionInstances().add(oNewTransitionInstance);
								colTmpTransInst.add(oNewTransitionInstance);
								colAddedTransitions.add(oTransition);
								bFoundAdditionalTransitions = true;
							}
							else
								continue;
						}
					}
				}
			}
			colTransitionInstances = colTmpTransInst;
		}
	}

	private boolean previousEventCallIsDefault(
		TestCase in_oTestCase, 
		int in_nCurrentTransitionIndex)
	{
		for(int n = in_nCurrentTransitionIndex; n >= 0; --n)
		{
			TransitionInstance oTransitionInstance = in_oTestCase.getTransitionInstances().get(n);
			TCGEvent oEvent = oTransitionInstance.getCalledEvent();
			if(oEvent != null)
			{
				return oEvent.isDefaultEvent(); 
			}
		}
		return false;
	}
	
	private boolean nextEventCallIsDefaultOrNullAndTheGuardIsSatisfied(
		TestCase in_oTestCase, 
		int in_nCurrentTransitionIndex,
		boolean in_bAlsoIncludeNullEvents)
	{
		TransitionInstance oPreviousTransitionInstance = 
			in_oTestCase.getTransitionInstances().get(in_nCurrentTransitionIndex);
		for(int n = in_nCurrentTransitionIndex + 1; n < in_oTestCase.getTransitionInstances().size(); ++n)
		{
			TransitionInstance oCurrentTransitionInstance = 
				in_oTestCase.getTransitionInstances().get(n);
			// source and target nodes must be in the same region -> one is substate of the other
			if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
					oPreviousTransitionInstance.getTargetNode(), oCurrentTransitionInstance.getSourceNode()) ||
					TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
					oCurrentTransitionInstance.getSourceNode(), oPreviousTransitionInstance.getTargetNode())) {
				TCGEvent oEvent = oCurrentTransitionInstance.getCalledEvent();
				
				if(oEvent != null) {
					return oEvent.isDefaultEvent(); 
				}
				else if(in_bAlsoIncludeNullEvents)
					return true;
			}
		}
		
		// last transition instance and still no event found -> check the outgoing transitions of the test case's last node
		TransitionInstance oTransitionInstance = in_oTestCase.getTransitionInstances().get(
				in_oTestCase.getTransitionInstances().size() - 1);
		TCGNode oLastNode = oTransitionInstance.getTargetNode();
		for(TCGTransition oOutgoingTransition : TCGNodeHelperClass.getOutgoingTransitions(oLastNode)) {
			if(oOutgoingTransition.isCanBeProcessed()) {
				for(TCGEvent oEvent : oOutgoingTransition.getEvents()) {
					if (oEvent.isDefaultEvent() && 
						TCGTransitionInstanceHelperClass.checkSatisfactionOfCondition(
								oTransitionInstance, oOutgoingTransition.getPrecondition()))
						return true; 
				}
			}
		}

		return false;
	}
	
	/*
	 * creates output for one single test case
	 */
	private void writeTestCase(
		TestCase in_oTestCase,
		Map<EventParameterInstance, TestCaseValidValue> in_colParameterValue, 
		int in_nActualParameterIndex,
		Map<EventParameterInstance, ArrayList<TestCaseValidValue>> in_colParameterValues,
		TestCaseGraphOutputConfigurator in_oConfigurator)
	{
		// there are parameter instances but no values for them
		for(ArrayList<TestCaseValidValue> colTestCase : in_colParameterValues.values()) {
			if(colTestCase.size() == 0)
				return;
		}
		
		// get maximum numbers per parameter
		int nMaxInputParameterNumber = 0;
		for(ArrayList<TestCaseValidValue> colTestCase : in_colParameterValues.values()) {
			int nActualNumber = colTestCase.size();
			if(nMaxInputParameterNumber < nActualNumber)
				nMaxInputParameterNumber = nActualNumber;
		}

		if(!in_colParameterValues.keySet().isEmpty() && nMaxInputParameterNumber == 0)
			nMaxInputParameterNumber = 1;
		
		// initialize the parameter set
		for(EventParameterInstance oEPInstance : in_colParameterValues.keySet()) {
			in_colParameterValue.put(oEPInstance, null);
		}
		
		
		// create test cases for concrete representatives of the value ranges
		for(int nRun = 0; nRun < nMaxInputParameterNumber; ++nRun) {
			// the aim is to select concrete test values
			// each parameter value has to be selected at least once
			// after that (nRun < ...): just select the last value
			for(EventParameterInstance oEPInstance : in_colParameterValues.keySet()) {
				if(nRun < in_colParameterValues.get(oEPInstance).size())
					in_colParameterValue.put(oEPInstance, in_colParameterValues.get(oEPInstance).get(nRun));
			}
			writeCompleteTestCase(in_oTestCase, in_colParameterValue, in_oConfigurator);
		}
		
		// also write a test case if no parameters are involved
		if(nMaxInputParameterNumber == 0) {
			writeCompleteTestCase(in_oTestCase, in_colParameterValue, in_oConfigurator);
		}
	}
	
	
	private void writeCompleteTestCase(
			TestCase in_oTestCase,
			Map<EventParameterInstance, TestCaseValidValue> in_colParameterValue,
			TestCaseGraphOutputConfigurator in_oConfigurator)
	{
		// write local start
		in_oConfigurator.createLocalStart(in_colParameterValue);
	
		// writes all test information for a special leave node
		for(TransitionInstance oInstance : in_oTestCase.getTransitionInstances())
		{
			in_oConfigurator.createOutput(oInstance);
		}
	
		// write local end
		in_oConfigurator.createLocalEnd();		
	}
}
