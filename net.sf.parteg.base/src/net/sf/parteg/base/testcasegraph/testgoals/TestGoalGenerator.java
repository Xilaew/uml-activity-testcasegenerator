package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.coveragecriteria.ControlFlowOrientedCoverage;
import net.sf.parteg.base.testcasegraph.coveragecriteria.CoverageCriterionFactory;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.HierarchicalPrioritizationCombination;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.TestGoalPrioritizator;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.TestGoalPrioritizatorCombinator;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.TestGoalPrioritizatorFactory;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.TestGoalPrioritizatorRandom;
import net.sf.parteg.core.structures.ObjectComparator;

public class TestGoalGenerator {

	private TestCaseGraphHelper m_oTCGHelper;
	
	public TestGoalGenerator(TestCaseGraphHelper in_oTCGHelper)
	{
		m_oTCGHelper = in_oTCGHelper;
	}
	
	public void defineTestGoalsForTCG() 
	{
		createRawTestGoals();

		// if there are ambiguous test goals - add conditions to reach a unique target state
		if(Configuration.getAddConditionsForUniqueTargetState()) {
			adaptTestGoalsForUniqueTargetNode();
			// test goal extension is done when creating test cases
//			extendTestGoalsForDefaultFollowUpTransitions();
		}
		
		// prioritize test goals
//		long start = System.nanoTime();
		prioritizeTestGoals();
//		long elapsed = System.nanoTime() - start;
//		System.out.println("prioritization time: " + elapsed);
		
	}
	
	private void createRawTestGoals() {
		// is a control flow-based coverage criterion
		if(ControlFlowOrientedCoverage.isControlFlowOrientedCoverage(
				ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriterion()))
		{	
			// for each control flow-based criterion: mark all transitions as test goals
			defineTransitionCoverage();
			// selection of concrete coverage criterion
			ControlFlowOrientedCoverage oControlFlowCoverageCriterion = 
				CoverageCriterionFactory.createCoverageCriterion(
						ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriterion());
			// furthermore, define assignments for the guard conditions
			if(oControlFlowCoverageCriterion != null) {
				defineControlFlowBasedCoverageCriterion(oControlFlowCoverageCriterion);
			}
		}
		else // TODO: eigentlich sollte das "else" weg - alle goals einbeziehen
		{
			// define goals for state coverage
			defineTestGoalsForStateCoverage();
		}
		
		// after defining all test goals: resolve all inequations in the test case graph
		for(TCGTransition oTransition : m_oTCGHelper.getAllTransitions())
		{
			if(oTransition.getPrecondition() != null)
				TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInDNF(oTransition.getPrecondition());
			if(oTransition.getPostcondition() != null)
				TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInDNF(oTransition.getPostcondition());
		}
		
//		// check all test goals for contradicting constant elements (and remove the goals if detected)
//		ArrayList<TestGoalBase> colGoalsToRemove = new ArrayList<TestGoalBase>();
//		GOAL: for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals()) {
//			if(oTestGoal instanceof TestGoalGuardConditions) {
//				TestGoalGuardConditions oTestGoalGuard = (TestGoalGuardConditions)oTestGoal;
//				if(oTestGoalGuard.getDNFToBeSatisfied() != null && 
//						!oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
//					ArrayList<TCGConjunction> colConToRemove = new ArrayList<TCGConjunction>();
//					CON: for(TCGConjunction oConjunction : oTestGoalGuard.getDNFToBeSatisfied().getConjunctions()) {
//						for(TCGOCLExpression oExp : oConjunction.getExpressions()) {
//							try {
//								if(!TCGOCLExpressionHelperClass.getBooleanValue(oExp)) {
//									colConToRemove.add(oConjunction);
//									continue CON;
//								}
//							}
//							catch(Exception e) {
//								// nothing ...
//							}
//						}
//					}
//					// remove all invalid conjunctions 
//					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().removeAll(colConToRemove);
//					// if list of conjunctions is empty now (all are wrong) -> remove test goal!
//					if(oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
//						colGoalsToRemove.add(oTestGoal);
//						continue GOAL;
//					}
//				}
//			}
//		}
//		m_oTCGHelper.getTestGoalMgr().getTestGoals().removeAll(colGoalsToRemove);
	}

	private void defineTransitionCoverage()
	{
		// iterate through all nodes to find conditions at outgoing transitions
		for(TCGNode oTCGNode : m_oTCGHelper.getAllNodes())
		{
			// the current node is not temporarily inserted
			if(!((oTCGNode instanceof TCGIntermediateNode) && 
					((TCGIntermediateNode)oTCGNode).getNodeType().equals(TCGNodeType.TEMPORARY)))
			{
				// create correspondingly a test goal for each outgoing transition 
				for(TCGTransition oOutgoingTransition : oTCGNode.getOutgoingTransitions())
				{
					TCGEvent oEvent = null;
					// select just one of the assigned events TODO what about other events?
					if(!oOutgoingTransition.getEvents().isEmpty())
						oEvent = oOutgoingTransition.getEvents().get(0);
					
					Map<TCGNode, List<TestGoalBase>> colTestGoals =
						new LinkedHashMap<TCGNode, List<TestGoalBase>>();
//					ArrayList<TestGoalBase> colTestGoals = new ArrayList<TestGoalBase>();
					TCGDisjunctiveNormalForm oTestGoalDNF = 
						TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oOutgoingTransition.getPrecondition());
					// remove inequations and double nots (not not X)
					TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInDNF(oTestGoalDNF);
					TCGDisjunctiveNormalFormHelperClass.removeDoubleNots(oTestGoalDNF);
					// clean up conjunctions
					TCGConjunctionHelperClass.removeContradictingConjunctions(
						oTestGoalDNF.getConjunctions());
					TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
						oTestGoalDNF.getConjunctions());
					TCGConjunctionHelperClass.removeRedundantConjunctions(
						oTestGoalDNF.getConjunctions());
					
					if(Configuration.getDuplicateTestGoalsForContainedNodes()) {
						for(TCGNode oSubNode : TCGNodeHelperClass.getAllSubNodes(oTCGNode)) {
							if(oSubNode instanceof TCGRealNode &&
									TCGNodeHelperClass.getAllTransitionsWithoutTrigger(oSubNode).isEmpty()) {
								List<TestGoalBase> colGoals = getDefaultCreatedListFromMap(colTestGoals, oSubNode);
								createNewTestGoalAndAddToCollection(
									oSubNode, oEvent, 
									TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oTestGoalDNF), 
									oOutgoingTransition, colGoals);
							}
						}
					}
					
					List<TestGoalBase> colGoals = getDefaultCreatedListFromMap(colTestGoals, oTCGNode);
					createNewTestGoalAndAddToCollection(
							oTCGNode, oEvent, 
							TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oTestGoalDNF), 
							oOutgoingTransition, colGoals);
					
					// after generating all test goals for the current node and the current event: 
					// search for overlapping test goals and add only the results
					for(List<TestGoalBase> colTmpGoals : colTestGoals.values()) {
						if(Configuration.getEnforceUnambiguousTestGoals()) {
							dealWithOverlappingTestGoalsFromTheSameSourceNode(colTmpGoals);
						}
						removeAllContradictingConjunctionsInTheGoalCollection(colTmpGoals);
//						removeAllEmptyGoalsWithoutClearingTheGoalCollection(colTmpGoals);
						m_oTCGHelper.getTestGoalMgr().addAllTestGoals(colTmpGoals);
					}
				}
			}
		}
	}
	
	private void createNewTestGoalAndAddToCollection(
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGDisjunctiveNormalForm in_oDNF,
			TCGTransition in_oOutgoingTransition,
			List<TestGoalBase> io_colGoals) {
		
		TestGoalGuardConditions oTestGoal =
			new TestGoalGuardConditions(
					in_oNode, in_oEvent, in_oDNF, in_oOutgoingTransition);
		
		// if new test goal is not redundant
		if(!oTestGoal.isContradictory()) {
			io_colGoals.add(oTestGoal);
		}
	}
	
	private void defineControlFlowBasedCoverageCriterion(
			ControlFlowOrientedCoverage in_oCoverageCriterion)
	{
		// why? what is the motivation for this method?
		List<TCGEvent> colAllCalledEvents = new ArrayList<TCGEvent>();
		if(Configuration.isCreateTestGoalsForUncalledEvents()) {
			colAllCalledEvents.addAll(m_oTCGHelper.getAllEvents());
		}
		
		// iterate through all nodes to find conditions at outgoing transitions
		for(TCGNode oTCGNode : m_oTCGHelper.getAllNodes())
		{
			// the current node is not temporarily inserted
			if(!((oTCGNode instanceof TCGIntermediateNode) && 
					((TCGIntermediateNode)oTCGNode).getNodeType().equals(
							TCGNodeType.TEMPORARY)))
			{
				// collect all test goals and separate them for this node ...
//				ArrayList<TestGoalBase> colTestGoals = new ArrayList<TestGoalBase>();
				Map<TCGNode, List<TestGoalBase>> colTestGoals =
					new LinkedHashMap<TCGNode, List<TestGoalBase>>();
				
				// create corresponding test goals: for each event and each collected condition set 
				for(TCGTransition oOutgoingTransition : oTCGNode.getOutgoingTransitions()) {
					TCGEvent oEvent = null;
					if(!oOutgoingTransition.getEvents().isEmpty())
						oEvent = oOutgoingTransition.getEvents().get(0);
					
					TCGDisjunctiveNormalForm oDNF = oOutgoingTransition.getPrecondition();
					{
						if(oDNF == null)
							continue;
						
						// only proceed if the current DNF is intended for test goal creation
						if(!oDNF.isUseForTestGoals())
							continue;
						
						// create test goals for each generated DNF
						for(TCGDisjunctiveNormalForm oTestGoalDNF : in_oCoverageCriterion.createDNFsForTestGoals(oDNF))
						{
							// after creating the test goals: resolve DNF
//							System.out.println("before: " + 
//									TCGDisjunctiveNormalFormHelperClass.toString(
//											oTestGoalDNF));
							if(TCGDisjunctiveNormalFormHelperClass.allConjunctionsRemovedBecauseOfInfeasibility(
									oTestGoalDNF)) {
								// invalid test goal
								continue;
							}
							TCGDisjunctiveNormalFormHelperClass.splitUpInequationsInDNF(oTestGoalDNF);
							TCGDisjunctiveNormalFormHelperClass.removeDoubleNots(oTestGoalDNF);
							TCGConjunctionHelperClass.removeContradictingConjunctions(
								oTestGoalDNF.getConjunctions());
							TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
								oTestGoalDNF.getConjunctions());
							TCGConjunctionHelperClass.removeRedundantConjunctions(
								oTestGoalDNF.getConjunctions());
							
							List<TestGoalBase> colGoals = getDefaultCreatedListFromMap(
									colTestGoals, oTCGNode);
							boolean bTestGoalAdded = createNewTestGoalAndAddToCollection(
									oTCGNode, oEvent, 
									TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oTestGoalDNF),
									in_oCoverageCriterion, colGoals, true);
							if(bTestGoalAdded && 
									Configuration.getDuplicateTestGoalsForContainedNodes()) {
								for(TCGNode oSubNode : TCGNodeHelperClass.getAllSubNodes(oTCGNode)) {
									if(oSubNode instanceof TCGRealNode &&
											TCGNodeHelperClass.getAllTransitionsWithoutTrigger(oSubNode).isEmpty()) {
										colGoals = getDefaultCreatedListFromMap(colTestGoals, oSubNode);
										createNewTestGoalAndAddToCollection(
												oSubNode, oEvent, 
												TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oTestGoalDNF),
												in_oCoverageCriterion, colGoals, false);
									}
								}
							}
						}
					}
				}
				
				// Add test goals for events that are not called from state oTCGNode.
				// There must be at least one outgoing transition with a non-default trigger.
				if(Configuration.isCreateTestGoalsForUncalledEvents()) {
					List<TCGEvent> colTriggeredEvents = 
						TCGNodeHelperClass.getTriggeringEventsForNode(oTCGNode);
					boolean bOnlyDefaultTriggers = true;
					for(TCGEvent oEvent : colTriggeredEvents) {
						if(oEvent != null && !oEvent.isDefaultEvent()) {
							bOnlyDefaultTriggers = false;
						}
					}
					if(bOnlyDefaultTriggers == false) {
						for(TCGEvent oEvent : colAllCalledEvents) {
							if(!(oEvent == null || oEvent.isDefaultEvent() ||
									//colTriggeredEvents.contains(oEvent))) {
									ObjectComparator.contains(colTriggeredEvents, oEvent))) {
								TestGoalGuardConditions oTestGoal =
									new TestGoalGuardConditions(oTCGNode, oEvent, 
											TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(null, false));
								List<TestGoalBase> colTmpGoals = getDefaultCreatedListFromMap(colTestGoals, oTCGNode);
								colTmpGoals.add(oTestGoal);
							}
						}
					}
				}
				
				// after generating all test goals for the current node and the current event: 
				// search for overlapping test goals and add only the results
				for(List<TestGoalBase> colTmpGoals : colTestGoals.values()) {
					if(Configuration.getEnforceUnambiguousTestGoals()) {
						dealWithOverlappingTestGoalsFromTheSameSourceNode(colTmpGoals);
					}
					removeAllContradictingConjunctionsInTheGoalCollection(colTmpGoals);
//					removeAllEmptyGoalsWithoutClearingTheGoalCollection(colTestGoals);
					m_oTCGHelper.getTestGoalMgr().addAllTestGoals(colTmpGoals);
				}
			}
		}
	}

	private List<TestGoalBase> getDefaultCreatedListFromMap(
			Map<TCGNode, List<TestGoalBase>> in_colMap,
			TCGNode in_oNode) {
		List<TestGoalBase> colGoals = in_colMap.get(in_oNode);
		if(colGoals == null) {
			colGoals = new ArrayList<TestGoalBase>();
			in_colMap.put(in_oNode, colGoals);
		}
		return colGoals;
	}

	
	private boolean createNewTestGoalAndAddToCollection(
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGDisjunctiveNormalForm in_oDNF,
			ControlFlowOrientedCoverage in_oCoverageCriterion,
			List<TestGoalBase> io_colGoals,
			boolean in_bCheckForSatisfaction) {
		
		TestGoalGuardConditions oTestGoal =
			new TestGoalGuardConditions(in_oNode, in_oEvent, in_oDNF);
		
//		System.out.println("after: " + 
//				TCGDisjunctiveNormalFormHelperClass.toString(
//				((TestGoalGuardConditions)oTestGoal).getDNFToBeSatisfied()));
		// if new test goal is not redundant
		if(!oTestGoal.isContradictory() && (!in_bCheckForSatisfaction ||
				!in_oCoverageCriterion.testGoalIsAlreadySatisfiedInSetOfGoals(
				oTestGoal, io_colGoals, true)))
		{
			io_colGoals.add(oTestGoal);
			return true;
		}
		return false;
	}

	
	private void defineTestGoalsForStateCoverage()
	{
		boolean bIsPseudoStateCoverage = 
			ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriterion().equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.PSEUDOSTATE_COVERAGE);

		// state coverage
		if(ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriterion().equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.STATE_COVERAGE) ||
				bIsPseudoStateCoverage)
		{
			// iterate through all nodes to find conditions at outgoing transitions
			for(TCGNode oTCGNode : m_oTCGHelper.getAllNodes())
			{
				if(bIsPseudoStateCoverage || oTCGNode instanceof TCGRealNode)
				{
					TestGoalElements oTestGoal = new TestGoalElements(oTCGNode);
					m_oTCGHelper.getTestGoalMgr().addTestGoal(oTestGoal);
				}
			}
		}
	}
	
	private void dealWithOverlappingTestGoalsFromTheSameSourceNode(
			List<TestGoalBase> in_colTestGoals)
	{
		// compare all test goals: indizes i and j
		for(int i = 0; i < in_colTestGoals.size(); ++i) {
			for(int j = i+1; j < in_colTestGoals.size(); ++j) {
				if(in_colTestGoals.get(i) instanceof TestGoalGuardConditions &&
						in_colTestGoals.get(j) instanceof TestGoalGuardConditions) {
					TestGoalGuardConditions oFirstTestGoal = 
						(TestGoalGuardConditions)in_colTestGoals.get(i);
					TestGoalGuardConditions oSecondTestGoal = 
						(TestGoalGuardConditions)in_colTestGoals.get(j);
					
					// both goals have the same triggering event and the same source node
					boolean bTestGoalsHaveSameEventAndSourceNode = false;
					if(oFirstTestGoal.getElement().equals(oSecondTestGoal.getElement())) {
						if(oFirstTestGoal.getEventToBeCalled() == null) {
							bTestGoalsHaveSameEventAndSourceNode = 
								(oSecondTestGoal.getEventToBeCalled() == null);
						}
						else {
							bTestGoalsHaveSameEventAndSourceNode =
								oFirstTestGoal.getEventToBeCalled().equals(oSecondTestGoal.getEventToBeCalled());
						}
					}

					if(bTestGoalsHaveSameEventAndSourceNode) {
						if((oFirstTestGoal.getDNFToBeSatisfied() != null) &&
								(oFirstTestGoal.getDNFToBeSatisfied().getConjunctions().size() > 0) &&
								(oSecondTestGoal.getDNFToBeSatisfied() != null) &&
								(oSecondTestGoal.getDNFToBeSatisfied().getConjunctions().size() > 0))
						{
							List<TCGTransition> colFirstTransitions = TCGTransitionHelperClass.findResultingTransitions(
									(TCGNode)oFirstTestGoal.getElement(), oFirstTestGoal.getEventToBeCalled(),
									oFirstTestGoal.getDNFToBeSatisfied().getConjunctions().get(0));
							List<TCGTransition> colSecondTransitions = TCGTransitionHelperClass.findResultingTransitions(
									(TCGNode)oSecondTestGoal.getElement(), oSecondTestGoal.getEventToBeCalled(),
									oSecondTestGoal.getDNFToBeSatisfied().getConjunctions().get(0));
							
							// found transitions are unequal
							// TODO : AA separate conjunctions
//							if(!(((colFirstTransitions.isEmpty()) && (colSecondTransitions.isEmpty())) ||
//									((!colFirstTransitions.isEmpty()) && (!colSecondTransitions.isEmpty()) &&
//											colFirstTransitions.get(0).equals(colSecondTransitions.get(0)))))
//							{
							if(!(colFirstTransitions.isEmpty() && colSecondTransitions.isEmpty())) {
								boolean bFoundMatchingTransitions = false;
								OUTERTRANSITION: for(TCGTransition oFirstTransition : colFirstTransitions) {
									for(TCGTransition oSecondTransition : colSecondTransitions) {
										if(oFirstTransition.equals(oSecondTransition)) {
											bFoundMatchingTransitions = true;
											break OUTERTRANSITION;
										}
									}
								}
								if(bFoundMatchingTransitions) {
									oFirstTestGoal.separateOverlappingConjunctions(oSecondTestGoal);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void removeAllContradictingConjunctionsInTheGoalCollection(
			List<TestGoalBase> in_colTestGoals)
	{
		for(TestGoalBase oTestGoal : in_colTestGoals)
		{
			if(oTestGoal instanceof TestGoalGuardConditions)
			{
				TCGConjunctionHelperClass.removeContradictingConjunctions(
						((TestGoalGuardConditions)oTestGoal).getDNFToBeSatisfied().getConjunctions());
			}
		}
	}
	
	private void removeAllEmptyGoalsWithoutClearingTheGoalCollection(
			List<TestGoalBase> in_colTestGoals)
	{
		ArrayList<TestGoalBase> colEmptyGoals = new ArrayList<TestGoalBase>();
		for(TestGoalBase oTestGoal : in_colTestGoals)
		{
			if(oTestGoal.containsNoCondition())
				colEmptyGoals.add(oTestGoal);
		}
		if(in_colTestGoals.size() > colEmptyGoals.size())
		{
			in_colTestGoals.removeAll(colEmptyGoals);
		}
		else
		{
			for(int i = 1; i < colEmptyGoals.size(); ++i)
				in_colTestGoals.remove(colEmptyGoals.get(i));
		}
	}
	
	public void prioritizeTestGoals()
	{
		List<TestGoalBase> colGoals = m_oTCGHelper.getTestGoalMgr().getTestGoals();
		
		TestGoalPrioritization oPrioritization = ConfigurationTestGoalPrioritization.getTestGoalPrioritization();
		if(oPrioritization != null) {
			TestGoalPrioritizatorRandom oRandomizer = new TestGoalPrioritizatorRandom();
			
			// RANDOM
			if(oPrioritization.equals(TestGoalPrioritization.RANDOM)) {
				oRandomizer.sort(colGoals);
			}
			// HIERARCHICAL COMBINATION
			else if(oPrioritization.equals(TestGoalPrioritization.HIERARCHICAL_COMBINATION)) {
				HierarchicalPrioritizationCombination oCombo = ConfigurationTestGoalPrioritization.getHierarchicalPrioritizationCombination();
				TestGoalPrioritizatorCombinator oCombinator = 
					new TestGoalPrioritizatorCombinator(
							TestGoalPrioritizatorFactory.getPrioritizator(
									oCombo.getPrimaryPrioritization()), 
							TestGoalPrioritizatorFactory.getPrioritizator(
									oCombo.getSecondaryPrioritization()));
				oCombinator.sort(colGoals);			
			}
			// WEIGHTED COMBINATION
			
			else {
				// FAR_ELEMENTS_FIRST
				// HIGH BRANCHING FIRST/LAST
				// MANY ATOMS FIRST/LAST
				// HIGH POSITIVE ATOMS RATIO FIRST / LAST
				TestGoalPrioritizator oPrioritizator =
					TestGoalPrioritizatorFactory.getPrioritizator(oPrioritization);
				TestGoalPrioritizatorCombinator oCombinator = 
					new TestGoalPrioritizatorCombinator(oPrioritizator, oRandomizer);
				oCombinator.sort(colGoals);
			}			
		}
	}	

	/**
	 * search for ambiguous test goals
	 * adapt them by adding some expressions
	 * move added conjunctions to the front, the ambiguous ones to the end 
	 * effect: if more than one transition is satisfied for a condition,
	 *         then no assumption about the target state is used ...
	 */
	public void adaptTestGoalsForUniqueTargetNode()
	{
		int m = 0;
		for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals()) {
			++m;
			if(m == 20) {
			}
			if(oTestGoal instanceof TestGoalGuardConditions) {
				TestGoalGuardConditions oTestGoalGuard =
					(TestGoalGuardConditions)oTestGoal;
				TCGNode oNode = (TCGNode)oTestGoalGuard.getElement();
				TCGEvent oEvent = oTestGoalGuard.getEventToBeCalled();
				TCGDisjunctiveNormalForm oDNF = oTestGoalGuard.getDNFToBeSatisfied();

				ArrayList<TCGConjunction> colConjunctionsToTheFront =
					new ArrayList<TCGConjunction>();
				ArrayList<TCGConjunction> colConjunctionsToTheEnd =
					new ArrayList<TCGConjunction>();
				
				// conjunction list is empty -> add a default conjunction to allow to add conditions
				TCGConjunction oTemporalConjunction = null;
				if(oDNF.getConjunctions().isEmpty()) {
					oTemporalConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
					oDNF.getConjunctions().add(oTemporalConjunction);
				}
				
				// check all conjunctions if they determine exactly one target state
				for(TCGConjunction oConjunction : oDNF.getConjunctions()) {
//					List<TCGTransition> colTransitions = 
//						TCGTransitionHelperClass.findResultingTransitions(
//							oNode, oEvent, oConjunction);
//					abc: überprüfen, ob es mehrere mögliche Kandidaten für die resultierende Transition gibt
//					Gibt es dafür nicht schon ein Beispiel? Siehe FreightElevator!
//					if(colTransitions.size() != 1) { // TODO : AAA: ok?
					// no unique match found - get non-contradicting guards
					List<TCGConjunction> colNonContradictingTransitionGuards =
						TCGTransitionHelperClass.findNonContradictingTransitionGuards(
							oNode, oEvent, oConjunction);
					
					// is empty? -> do nothing -> all outgoing transitions are contradicting
					// is not empty: create alternative conjunctions and add them before
					// the original, ambiguous conjunction 
					if(!colNonContradictingTransitionGuards.isEmpty()) {
						colConjunctionsToTheEnd.add(oConjunction);
						for(TCGConjunction oNonConConjunction : colNonContradictingTransitionGuards) {
							boolean bAddNewConjunctionToFront = false;
							TCGConjunction oNewConjunction =
								TCGConjunctionHelperClass.copyConjunctionDeep(oNonConConjunction);

							// old expression values should be added to new conjunction?
							// -> check if the old expression contains values that are not in the new conjunction
							for(TCGOCLExpression oExp : oConjunction.getExpressions()) {
								// add new expression only if it is not already contained
								// or references the same original OCL expression
								// or can be transformed into each other
								if(!ObjectComparator.contains(oNonConConjunction.getExpressions(), oExp) &&
										!TCGOCLExpressionHelperClass.containsElementWithSameOCLReference(
												oNonConConjunction.getExpressions(), oExp) &&
												!TCGOCLExpressionHelperClass.containsTransformableExpression(
														oNonConConjunction.getExpressions(), oExp)) {
									oNewConjunction.getExpressions().add(
										TCGOCLExpressionHelperClass.copyExpression(oExp));
								}
							}

							// new conjunction should be added to conjunctionsToTheFront?
							// -> check if it contains values that are not included in the given old conjunction
							for(TCGOCLExpression oExp : oNonConConjunction.getExpressions()) {
								if(!ObjectComparator.contains(oConjunction.getExpressions(), oExp) &&
										!TCGOCLExpressionHelperClass.containsElementWithSameOCLReference(
												oConjunction.getExpressions(), oExp) &&
												!TCGOCLExpressionHelperClass.containsTransformableExpression(
														oConjunction.getExpressions(), oExp)) {
									bAddNewConjunctionToFront = true;
								}
							}
							if(bAddNewConjunctionToFront) {
								colConjunctionsToTheFront.add(oNewConjunction);
							}
						}
					}
//					} else {
//						if(colTransitions.size() > 1) {
//							int x = 42;
//							++x;
//						}
//					}
				}
				// sort ambiguous conjunctions to the end
				for(TCGConjunction oConjunction : colConjunctionsToTheEnd) {
					int n = oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().size();
					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().move(n-1, oConjunction);
				}
				// insert new conjunctions to the front
				for(TCGConjunction oConjunction : colConjunctionsToTheFront) {
					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().add(0, oConjunction);
				}
				
				// remove temporal conjunction
				if(oTemporalConjunction != null) {
					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().remove(oTemporalConjunction);
				}
			}
		}
	}
	
	
	/**
	 * if the target state of a triggered transition has several
	 * default-triggered transitions with conditions, then the test
	 * goals are extended so that these conditions can also be decided.
	 * For the case of infeasible test cases, the old test goals
	 * are just moved to the end of the list.
	 */
	public void extendTestGoalsForDefaultFollowUpTransitions() {
		for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals()) {
			//			if(((TCGNode)oTestGoal.getElement()).getName() != null &&
//					(((TCGNode)oTestGoal.getElement()).getName().endsWith("WAITING_FOR_ACK_OF_UNREACHABLE_LTO") &&
//					((TestGoalGuardConditions)oTestGoal).getEventToBeCalled().getName().endsWith("NoAck"))) {
//
////			if(nCounter == 613  279) {
//				int x = 42;
//				++x;
//			}
			if(oTestGoal instanceof TestGoalGuardConditions) {
				TestGoalGuardConditions oTestGoalGuard =
					(TestGoalGuardConditions)oTestGoal;
				TCGNode oNode = (TCGNode)oTestGoalGuard.getElement();
				TCGEvent oEvent = oTestGoalGuard.getEventToBeCalled();
				TCGDisjunctiveNormalForm oDNF = oTestGoalGuard.getDNFToBeSatisfied();

				ArrayList<TCGConjunction> colConjunctionsToTheFront =
					new ArrayList<TCGConjunction>();
				ArrayList<TCGConjunction> colConjunctionsToTheEnd =
					new ArrayList<TCGConjunction>();
				
				// check all conjunctions if they determine exactly one target state
				for(TCGConjunction oConjunction : oDNF.getConjunctions()) {
					getAdditionalConjunctions(
							colConjunctionsToTheFront, colConjunctionsToTheEnd,
							oNode, oEvent, oConjunction);
				}
				if(oDNF.getConjunctions().isEmpty()) {
					getAdditionalConjunctions(
							colConjunctionsToTheFront, colConjunctionsToTheEnd,
							oNode, oEvent, null);					
				}
				// sort ambiguous conjunctions to the end
				for(TCGConjunction oConjunction : colConjunctionsToTheEnd) {
					int n = oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().size();
					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().move(n-1, oConjunction);
				}
				// insert new conjunctions to the front
				for(TCGConjunction oConjunction : colConjunctionsToTheFront) {
					oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().add(0, oConjunction);
				}
			}
		}					
	}

	private void getAdditionalConjunctions(
			ArrayList<TCGConjunction> io_colConjunctionsToTheFront,
			ArrayList<TCGConjunction> io_colConjunctionsToTheEnd,
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGConjunction in_oConjunction) {
		List<TCGTransition> colTransitions = 
			TCGTransitionHelperClass.findResultingTransitions(
				in_oNode, in_oEvent, in_oConjunction);
		TCGNode oTargetState = null;
		if(colTransitions.size() != 1) {
			oTargetState = in_oNode;
		}
		else {
			oTargetState = colTransitions.get(0).getTargetNode();
		}
		List<TCGConjunction> colNewConjunctions = 
			getListsOfPossibleSuccessorConjunctionLists(
					in_oNode, oTargetState, new ArrayList<TCGNode>());
		
		if(!colNewConjunctions.isEmpty()) {
			if(in_oConjunction != null) {
				io_colConjunctionsToTheEnd.add(in_oConjunction);
			}
			for(TCGConjunction oNewConjunction : colNewConjunctions) {
				if(in_oConjunction != null) {
					for(TCGOCLExpression oExp : in_oConjunction.getExpressions()) {
						oNewConjunction.getExpressions().add(
								TCGOCLExpressionHelperClass.copyExpression(oExp));
					}
				}
			}
			TCGConjunctionHelperClass.removeContradictingConjunctions(
					colNewConjunctions);
			TCGConjunctionHelperClass.removeRedundantExpressionsInConjunctions(
					colNewConjunctions);
			TCGConjunctionHelperClass.removeRedundantConjunctions(
					colNewConjunctions);

			io_colConjunctionsToTheFront.addAll(colNewConjunctions);
		}
	}
	
	private List<TCGConjunction> getListsOfPossibleSuccessorConjunctionLists(
			TCGNode in_oSourceState,
			TCGNode in_oTargetState,
			List<TCGNode> in_colAlreadyVisitedStates) {
		
		List<TCGConjunction> colRetValues = new ArrayList<TCGConjunction>();
		in_colAlreadyVisitedStates.add(in_oTargetState);
		
		for(TCGTransition oAdditionalTransition : 
			TCGNodeHelperClass.getAllTransitionsWithoutTrigger(in_oTargetState)) {
			
			if(oAdditionalTransition.getPostcondition() == null ||
					oAdditionalTransition.getPostcondition().getConjunctions().isEmpty()) {
				// for each transition: add the conjunctions
				List<TCGConjunction> colConjunctions = new ArrayList<TCGConjunction>();
				if(oAdditionalTransition.getPrecondition() != null)
					colConjunctions.addAll(oAdditionalTransition.getPrecondition().getConjunctions());
	
				// recursion to include also the conditions of subsequent transitions without triggers
				List<TCGNode> colTargetStates = TCGTransitionHelperClass.getTargetNodes(oAdditionalTransition);
				for(TCGNode oNewTargetState : colTargetStates) {
	//				TCGNode oNewTargetState = oAdditionalTransition.getTargetNode();
					// if event-fire-source node is equal to this node, then the satisfaction
					// and the violation of the transition guard could not be distinguished
					if(oNewTargetState.equals(in_oSourceState)) {
						// TODO: Hier Verbesserung möglich: target state determination
						// "continue" bedeutet, dass die erweiterten Pfade, die zum Ausgangspunkt des
						// Event-Triggers führen, nicht berücksichtigt werden sollten.
						// Besser wäre es, wenn diese Beispiele bloß weiter an das Ende sortiert werden.
						continue;
					}
					
					// prevent endless recursion
					if(!in_colAlreadyVisitedStates.contains(oNewTargetState)) {
						List<TCGConjunction> colNewConjunctions = 
							getListsOfPossibleSuccessorConjunctionLists(
									in_oSourceState, oNewTargetState, in_colAlreadyVisitedStates);
						if(colNewConjunctions.isEmpty()) {
							colRetValues.addAll(TCGConjunctionHelperClass.copyConjunctionListDeep(colConjunctions));
						}
						else if(colConjunctions.isEmpty()) {
							colRetValues.addAll(TCGConjunctionHelperClass.copyConjunctionListDeep(colNewConjunctions));
						}
						else {
							for(TCGConjunction oNewConjunction : colNewConjunctions) {
								for(TCGConjunction oOldConjunction : colConjunctions) {
									TCGConjunction oCombinedConjunction =
										TCGConjunctionHelperClass.copyConjunctionDeep(oNewConjunction);
									for(TCGOCLExpression oExp : oOldConjunction.getExpressions()) {
										oCombinedConjunction.getExpressions().add(
												TCGOCLExpressionHelperClass.copyExpression(oExp));
									}
									colRetValues.add(oCombinedConjunction);
								}
							}
						}
					}
					else {
						colRetValues.addAll(TCGConjunctionHelperClass.copyConjunctionListDeep(colConjunctions));
					}
				}
			}
		}
		in_colAlreadyVisitedStates.remove(in_oTargetState);
		return colRetValues;
	}
}
