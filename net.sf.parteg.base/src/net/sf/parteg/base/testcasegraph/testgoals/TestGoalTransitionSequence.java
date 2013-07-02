package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.structures.Pair;

public class TestGoalTransitionSequence extends TestGoalBase {

	// *********************************************
	// warning: class not ready for use as test goal
	// *********************************************
	
	private List<Pair<TCGNode, TCGTransition>> m_colTransitions;
	
	public TestGoalTransitionSequence() {
		super();
		m_colTransitions = new ArrayList<Pair<TCGNode, TCGTransition>>();
	}
	
	@Override
	public boolean checkSatisfactionByTestCase(TestCase in_oTestCase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSatisfactionByTransitionInstance(
			TransitionInstance in_oTransitionInstance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsNoCondition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TestCase createTestCase(TestCaseGraphHelper in_oTCGHelper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TCGElement getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean testCaseGenerationAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Pair<TCGNode, TCGTransition>> getTransitionSequence() {
		return m_colTransitions;
	}

	public Pair<TCGNode, TCGTransition> getEndNodeTransitionPair() {
		if(!getTransitionSequence().isEmpty()) {
			return getTransitionSequence().get(getTransitionSequence().size() - 1);
		}
		return null;
	}

	
	public TCGTransition getEndTransition() {
		if(!getTransitionSequence().isEmpty()) {
			TCGTransition oLastTransition =
				getTransitionSequence().get(getTransitionSequence().size() - 1).getSecond();
			return oLastTransition;
		}
		return null;
	}
	
	public TCGNode getEndNode() {
		TCGTransition oEndTransition = getEndTransition();
		if(oEndTransition != null) {
			return oEndTransition.getTargetNode();
		}
		return null;
	}
	
}
