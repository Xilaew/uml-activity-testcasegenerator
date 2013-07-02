package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGEventHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionInstanceHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgeneration.TestCaseGeneratorRunner;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.structures.ObjectComparator;

public class TestGoalGuardConditions extends TestGoalBase {

	// reference certain elements of the test case graph in the test goal
	TCGElement m_oElement;

	// reference events to be called and the conditions on its parameters 
	TCGEvent m_oEventToBeCalled;
	TCGDisjunctiveNormalForm m_oDNFToBeSatisfied;
	TCGTransition m_oNecessarilyTraversedTransition;

	public TestGoalGuardConditions(
			TCGElement in_oElement,
			TCGEvent in_oEvent,
			TCGDisjunctiveNormalForm in_oDNF)
	{
		super();
		m_oElement = in_oElement;
		m_oEventToBeCalled = in_oEvent;
		m_oDNFToBeSatisfied = in_oDNF;
	}
	
	public TestGoalGuardConditions(
			TCGElement in_oElement,
			TCGEvent in_oEvent,
			TCGDisjunctiveNormalForm in_oDNF,
			TCGTransition in_oTransition)
	{
		this(in_oElement, in_oEvent, in_oDNF);
		m_oNecessarilyTraversedTransition = in_oTransition;
	}
	
	public TCGEvent getEventToBeCalled()
	{
		return m_oEventToBeCalled;
	}
	
	public TCGDisjunctiveNormalForm getDNFToBeSatisfied()
	{
		return m_oDNFToBeSatisfied;
	}
	
	public TCGTransition getNecessaryTransitionToTraverse()
	{
		return m_oNecessarilyTraversedTransition;
	}
	
	@Override
	public TCGElement getElement() {
		return m_oElement;
	}

	@Override
	public boolean checkSatisfactionByTestCase(TestCase in_oTestCase) 
	{
		// checks nodes if test goal is a node
		if(getElement() instanceof TCGNode)
		{
			// since this test goal includes a subsequent execution of a transition
			// it is sufficient to check only the source states of all transitions
			for(TransitionInstance oTransitionInstance : in_oTestCase.getTransitionInstances())
			{
				TCGNode oNode = oTransitionInstance.getSourceNode(); 
				// oNode (source node of transition) has to be included in 
				// getElement() (source node of the test goal) or be equal
				// alternative: the state of the test goal is contained in the 
				// source node of the transition -> search for the last visited node
				// and compare!
				if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(oNode, (TCGNode)getElement()) ||
						getElement().equals(oTransitionInstance.findLastVisitedNodeContainedOrEqualToCurrentNode()))
				{
					if(getNecessaryTransitionToTraverse() != null) {
						if(checkSatisfactionOfNecessaryTransition(oTransitionInstance))
							return true;
					}
					else if(checkSatisfactionOfEventCall(oTransitionInstance) && 
							checkSatisfactionOfCondition(oTransitionInstance))
						return true;
				}
			}
		}
		return false;
	}

	
	@Override
	public boolean checkSatisfactionByTransitionInstance(
			TransitionInstance in_oTransitionInstance) {
		// checks nodes if test goal is a node
		if(getElement() instanceof TCGNode) {
			TCGNode oNode = in_oTransitionInstance.getSourceNode(); 
			// oNode (source node of transition) has to be included in 
			// getElement() (source node of the test goal) or be equal
			// alternative: the state of the test goal is contained in the 
			// source node of the transition -> search for the last visited node
			// and compare!
			if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(oNode, (TCGNode)getElement()) ||
					getElement().equals(in_oTransitionInstance.findLastVisitedNodeContainedOrEqualToCurrentNode()))
			{
				if(getNecessaryTransitionToTraverse() != null) {
					if(checkSatisfactionOfNecessaryTransition(in_oTransitionInstance))
						return true;
				}
				else if(checkSatisfactionOfEventCall(in_oTransitionInstance) && 
						checkSatisfactionOfCondition(in_oTransitionInstance))
					return true;
			}
		}
		return false;
	}
	

	private boolean checkSatisfactionOfEventCall(TransitionInstance in_oTransitionInstance)
	{
		// elements are equal
		if(m_oEventToBeCalled != null)
			//return in_oTransitionInstance.getCallableEvents().contains(m_oEventToBeCalled);
			return ObjectComparator.contains(in_oTransitionInstance.getCallableEvents(), m_oEventToBeCalled);
		// elements are both null
		else if(m_oEventToBeCalled == in_oTransitionInstance.getCalledEvent())
			return true;
		return false;
	}
	
	private boolean checkSatisfactionOfCondition(TransitionInstance in_oTransitionInstance)
	{
		return TCGTransitionInstanceHelperClass.checkSatisfactionOfCondition(
				in_oTransitionInstance, m_oDNFToBeSatisfied);
	}
	
	private boolean checkSatisfactionOfNecessaryTransition(TransitionInstance in_oTransitionInstance)
	{
		if(m_oNecessarilyTraversedTransition == null)
			return true;
		else
			return m_oNecessarilyTraversedTransition.equals(in_oTransitionInstance.getTransition());
	}
	
	public boolean isContradictory()
	{
		for(TCGConjunction oConjunction : m_oDNFToBeSatisfied.getConjunctions())
		{
			if(!TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(oConjunction).isEmpty())
				return true;
		}
		return false;
	}
	
	public void separateOverlappingConjunctions(
			TestGoalGuardConditions in_oOtherTestGoal)
	{
		// TODO implementieren -> jetzt temporär geblockt
		for(TCGConjunction oConjunction : getDNFToBeSatisfied().getConjunctions()) {
			for(TCGOCLExpression oExpression : oConjunction.getExpressions()) {
				if(TCGOCLExpressionHelperClass.
						getPassiveDependentVariablesAndInputParameters(
								oExpression).size() > 1) {
					return;
				}
			}
		}
		
		
		
		ArrayList<TCGConjunction> colConjunctionToBeRemovedFromFirstDNF =
			new ArrayList<TCGConjunction>();
		ArrayList<TCGConjunction> colConjunctionToBeRemovedFromSecondDNF =
			new ArrayList<TCGConjunction>();
		ArrayList<TCGConjunction> colConjunctionToBeAddedToFirstDNF =
			new ArrayList<TCGConjunction>();
		ArrayList<TCGConjunction> colConjunctionToBeAddedToSecondDNF =
			new ArrayList<TCGConjunction>();

		if(getElement().equals(in_oOtherTestGoal.getElement()) &&
				TCGEventHelperClass.eventsAreEqual(
						getEventToBeCalled(),
						in_oOtherTestGoal.getEventToBeCalled()))
		{
			for(TCGConjunction oFirstConjunction : getDNFToBeSatisfied().getConjunctions())
			{
				if(colConjunctionToBeRemovedFromFirstDNF.contains(oFirstConjunction))
					continue;
				
				for(TCGConjunction oSecondConjunction : in_oOtherTestGoal.getDNFToBeSatisfied().getConjunctions())
				{
					if(colConjunctionToBeRemovedFromSecondDNF.contains(oSecondConjunction))
						continue;
					
					identifyOverlappingsFromTwoConjunctions(
							oFirstConjunction, oSecondConjunction,
							colConjunctionToBeRemovedFromFirstDNF, colConjunctionToBeRemovedFromSecondDNF,
							colConjunctionToBeAddedToFirstDNF, colConjunctionToBeAddedToSecondDNF);
				}
			}
			getDNFToBeSatisfied().getConjunctions().removeAll(
				colConjunctionToBeRemovedFromFirstDNF);
			getDNFToBeSatisfied().getConjunctions().addAll(
				colConjunctionToBeAddedToFirstDNF);
			in_oOtherTestGoal.getDNFToBeSatisfied().getConjunctions().removeAll(
				colConjunctionToBeRemovedFromSecondDNF);
			in_oOtherTestGoal.getDNFToBeSatisfied().getConjunctions().addAll(
				colConjunctionToBeAddedToSecondDNF);
		}
	}

	/*
	 * identifies overlappings of two conjunctions and stores the conjunctions that have to be added and
	 * removed to both conjunctions in order to remove the overlapping
	 */
	private void identifyOverlappingsFromTwoConjunctions(
			TCGConjunction in_oFirstConjunction,
			TCGConjunction in_oSecondConjunction,
			ArrayList<TCGConjunction> io_colConjunctionToBeRemovedFromFirstDNF,
			ArrayList<TCGConjunction> io_colConjunctionToBeRemovedFromSecondDNF,
			ArrayList<TCGConjunction> io_colConjunctionToBeAddedToFirstDNF,
			ArrayList<TCGConjunction> io_colConjunctionToBeAddedToSecondDNF)
	{
		// if none of the conjunctions is positive: do not do anything
		if(in_oFirstConjunction.isPositiveSubExpressionOfOriginal() ||
				in_oSecondConjunction.isPositiveSubExpressionOfOriginal())
		{
			// if both conjunctions are positive: remove the overlapping range from both! (prevent non-determinism)
			// if only one of the conjunctions is positive: move overlapping range to positive
			
			HashMap<Object, ValueTypeRange> colFirstObjectToValueRange = 
				TCGOCLExpressionHelperClass.buildParameterValueTypeRangeHashMap(
						in_oFirstConjunction.getExpressions());
			HashMap<Object, ValueTypeRange> colSecondObjectToValueRange = 
				TCGOCLExpressionHelperClass.buildParameterValueTypeRangeHashMap(
						in_oSecondConjunction.getExpressions());
			
			// check for overlapping
			if(colFirstObjectToValueRange.size() == colSecondObjectToValueRange.size())
			{
				for(Object oSelectedObject : colFirstObjectToValueRange.keySet())
				{
					ValueTypeRange oFirstVTR = colFirstObjectToValueRange.get(oSelectedObject);
					ValueTypeRange oSecondVTR = colSecondObjectToValueRange.get(oSelectedObject);
					if((oSecondVTR == null) || !oFirstVTR.overlaps(oSecondVTR))
					{
						return;
					}
				}
				
				// if all value ranges of both conjunctions are overlapping
				HashMap<Object, ArrayList<TCGOCLExpression>> colFirstObjectToExpressions =
					TCGOCLExpressionHelperClass.buildParameterExpressionHashMap(
							in_oFirstConjunction.getExpressions());
				HashMap<Object, ArrayList<TCGOCLExpression>> colSecondObjectToExpressions =
					TCGOCLExpressionHelperClass.buildParameterExpressionHashMap(
							in_oSecondConjunction.getExpressions());
				
				// #####
				// exclude area of first conjunction from second
				excludeFirstConjunctionFromSecondConjunction(
						in_oFirstConjunction, in_oSecondConjunction,
						colFirstObjectToExpressions, colSecondObjectToExpressions,
						io_colConjunctionToBeAddedToSecondDNF, io_colConjunctionToBeRemovedFromSecondDNF);

				// #####
				// exclude area of second conjunction from first
				excludeFirstConjunctionFromSecondConjunction(
						in_oSecondConjunction, in_oFirstConjunction,
						colSecondObjectToExpressions, colFirstObjectToExpressions,
						io_colConjunctionToBeAddedToFirstDNF, io_colConjunctionToBeRemovedFromFirstDNF);
			}
		}
	}
	
	
	private void excludeFirstConjunctionFromSecondConjunction(
			TCGConjunction in_oFirstConjunction,
			TCGConjunction in_oSecondConjunction,
			HashMap<Object, ArrayList<TCGOCLExpression>> in_colFirstObjectToExpressions,
			HashMap<Object, ArrayList<TCGOCLExpression>> in_colSecondObjectToExpressions,
			ArrayList<TCGConjunction> io_colConjunctionsToBeAddedToSecondConjunction,
			ArrayList<TCGConjunction> io_colConjunctionsToBeRemovedFromSecondConjunction)
	{
		if(in_oFirstConjunction.isPositiveSubExpressionOfOriginal())
		{
			// element referenced by the first iterator
			Object oReferencedObject = in_colSecondObjectToExpressions.keySet().iterator().next();
			if(in_colFirstObjectToExpressions.get(oReferencedObject) == null) {
			}
			TCGDisjunctiveNormalForm oResultingDNF = GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
			
			// negate each expression for one referenced object
			for(TCGOCLExpression oExpression : in_colFirstObjectToExpressions.get(oReferencedObject))
			{
				TCGOCLExpression oNegativeExpression = TCGOCLExpressionHelperClass
					.copyExpression(oExpression);
				
				// create DNF from negated expressions	
				TCGDisjunctiveNormalForm oNegatedDNF =
					TCGDisjunctiveNormalFormHelperClass.createDisjunctiveNormalForm(
						net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.negateLogicalTCGOCLExpression(
								oNegativeExpression), true);
				oResultingDNF = TCGDisjunctiveNormalFormHelperClass.
					connectTwoDNFWithOr(oResultingDNF, oNegatedDNF);
			}
			// add negated first expressions to second conjunction
			// add a copy of the second conjunction to each conjunction of the new DNF
			for(TCGConjunction oConjunction : oResultingDNF.getConjunctions())
			{
				TCGConjunction oCopyOfFirstConjunction =
					TCGConjunctionHelperClass.copyConjunctionDeep(in_oSecondConjunction);
				oConjunction.getExpressions().
						addAll(oCopyOfFirstConjunction.getExpressions());
				oConjunction.setPositiveSubExpressionOfOriginal(
						in_oSecondConjunction.isPositiveSubExpressionOfOriginal());
				// add all resulting conjunctions to the second DNF 
				if(!TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(oConjunction).isEmpty())
					io_colConjunctionsToBeAddedToSecondConjunction.add(oConjunction);
			}
			// remove the original conjunction from the second DNF 
			io_colConjunctionsToBeRemovedFromSecondConjunction.add(in_oSecondConjunction);									
		}
	}
	
	
	@Override
	public boolean containsNoCondition() {
		if(getDNFToBeSatisfied() == null ||
				getDNFToBeSatisfied().getConjunctions() == null ||
				getDNFToBeSatisfied().getConjunctions().isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean testCaseGenerationAllowed() {
		return (getElement() instanceof TCGNode);
	}

	@Override
	public TestCase createTestCase(TestCaseGraphHelper in_oTCGHelper) 
	{
		TCGNode oNode = (TCGNode)getElement();

		TestCaseGeneratorRunner oRunner = new TestCaseGeneratorRunner(in_oTCGHelper);
		//oRunner.getRuntimeState().setActiveNode(oNode); // delayed until postfix determination 
		oRunner.searchBackwardsFromNodeWithEventConditionConjunction(
				oNode, getEventToBeCalled(), getDNFToBeSatisfied(), true);
		return oRunner.getCreatedTestCase();

//		if(TCGNodeHelperClass.nodeHasNoSubNodes(oNode)) {
//			TestCaseGeneratorRunner oRunner = new TestCaseGeneratorRunner(in_oTCGHelper);
//			//oRunner.getRuntimeState().setActiveNode(oNode); // delayed until postfix determination 
//			oRunner.searchBackwardsFromNodeWithEventConditionConjunction(
//					oNode, getEventToBeCalled(), getDNFToBeSatisfied(), true);
//			return oRunner.getCreatedTestCase();
//		} else {
//			List<TCGNode> colSubNodes = TCGNodeHelperClass.getAllSubNodes(oNode);
//			colSubNodes = TCGNodeHelperClass.prioritizeNodeList(colSubNodes, true);
//			for(TCGNode oSubNode : colSubNodes) {
//				TestCaseGeneratorRunner oRunner = new TestCaseGeneratorRunner(in_oTCGHelper);
//				//oRunner.getRuntimeState().setActiveNode(oSubNode); // delayed until postfix determination
//				oRunner.searchBackwardsFromNodeWithEventConditionConjunction(
//						oSubNode, getEventToBeCalled(), getDNFToBeSatisfied(), true);
//				if(oRunner.getCreatedTestCase() != null)
//					return oRunner.getCreatedTestCase();
//			}
//		}
//		return null;
	}
}
