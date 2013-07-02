package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgeneration.TestCaseGeneratorRunner;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

/*
 * This class represents single test goals that have to be satisfied for a coverage criterion.
 * Each test goal references a number of elements of the test case graph.
 */
public class TestGoalElements extends TestGoalBase {

	// reference certain elements of the test case graph in the test goal
	TCGElement m_oElement;

	public TestGoalElements(TCGElement in_oElement)
	{
		super();
		m_oElement = in_oElement;
	}
	
	public TCGElement getElement()
	{
		return m_oElement;
	}

	@Override
	public boolean checkSatisfactionByTestCase(TestCase in_oTestCase) 
	{
		// checks transitions if test goal is a transition
		if(getElement() instanceof TCGTransition)
		{
			for(TransitionInstance oTransitionInstance : in_oTestCase.getTransitionInstances())
			{
				TCGTransition oTransition = oTransitionInstance.getTransition();
				{
					if(oTransition.equals(getElement()))
						return true;
				}
			}
		}
		// checks nodes if test goal is a node
		else if(getElement() instanceof TCGNode)
		{
			if(!in_oTestCase.getTransitionInstances().isEmpty())
			{
				if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
						in_oTestCase.getTransitionInstances().get(0).getSourceNode(),
						(TCGNode)getElement()))
					return true;
				
				for(TransitionInstance oTransitionInstance : in_oTestCase.getTransitionInstances())
				{
					if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
							oTransitionInstance.getTargetNode(),
							(TCGNode)getElement()))
						return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean checkSatisfactionByTransitionInstance(
			TransitionInstance in_oTransitionInstance) {
		// checks transitions if test goal is a transition
		if(getElement() instanceof TCGTransition)
		{
			TCGTransition oTransition = in_oTransitionInstance.getTransition();
			{
				if(oTransition.equals(getElement()))
					return true;
			}
		}
		// checks nodes if test goal is a node
		else if(getElement() instanceof TCGNode)
		{
			if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
				in_oTransitionInstance.getSourceNode(),
				(TCGNode)getElement()))
				return true;

			if(TCGNodeHelperClass.firstNodeIsSubStateOfOrEqualToSecondNode(
					in_oTransitionInstance.getTargetNode(),
					(TCGNode)getElement()))
					return true;
		}
		return false;
	}

	@Override
	public boolean containsNoCondition() {
		return true;
	}

	@Override
	public boolean testCaseGenerationAllowed() {
		return (getElement() instanceof TCGNode);
	}

	@Override
	public TestCase createTestCase(TestCaseGraphHelper in_oTCGHelper) 
	{
		TCGNode oNode = (TCGNode)getElement();
		// if composite state: try test generation for each sub state
		if(TCGNodeHelperClass.nodeHasNoSubNodes(oNode)) {
			TestCaseGeneratorRunner oRunner = new TestCaseGeneratorRunner(in_oTCGHelper);
			// initialize the runtime state
			oRunner.searchBackwardsFromNodeWithEventConditionConjunction(
					oNode, null, null, false);
//			oRunner.getRuntimeState().setActiveNode(oNode);
//			oRunner.searchBackwardsFromNode(oNode);
			return oRunner.getCreatedTestCase();
		} 
		else {
			List<TCGNode> colSubNodes = TCGNodeHelperClass.getAllSubNodes(oNode);
			colSubNodes = TCGNodeHelperClass.prioritizeNodeList(colSubNodes, true);
			for(TCGNode oSubNode : colSubNodes) {
				TestCaseGeneratorRunner oRunner = 
					new TestCaseGeneratorRunner(in_oTCGHelper);
				oRunner.searchBackwardsFromNodeWithEventConditionConjunction(
						oSubNode, null, null, false);
				// initialize the runtime state
//				oRunner.getRuntimeState().setActiveNode(oSubNode);
//				oRunner.searchBackwardsFromNode(oSubNode);
				if(oRunner.getCreatedTestCase() != null)
					return oRunner.getCreatedTestCase();				
			}
		}
		return null;
	}
}
