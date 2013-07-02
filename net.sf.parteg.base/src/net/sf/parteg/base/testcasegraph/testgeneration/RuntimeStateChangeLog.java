package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGRegionHelperClass;
import net.sf.parteg.base.testcasegraph.systemstate.StateConfiguration;

public class RuntimeStateChangeLog {

	private TCGNode m_oNode;
	TestCaseGeneratorRunner m_oRunner;
	List<TCGNode> m_colRemovedNodes;
	
	public RuntimeStateChangeLog(TCGNode in_oNode, 
			TestCaseGeneratorRunner in_oRunner) {
		m_oNode = in_oNode;
		m_oRunner = in_oRunner;
	}
	
	public void executeRuntimeStateChange() {
		// remove all sub- or super regions of the new node's region from the current runtime state
		m_colRemovedNodes = new ArrayList<TCGNode>();
		TestCaseRegion oInRegion = TCGNodeHelperClass.getContainingRegion(m_oNode);
		for(TestCaseRegion oRegion : m_oRunner.getRuntimeState().getAllRegions()) {
			if(TCGRegionHelperClass.regionsAreInHierarchicalOrder(oRegion, oInRegion)) {
				m_colRemovedNodes.add(m_oRunner.getRuntimeState().getActiveNode(oRegion));
			}
		}
		for(TCGNode oNode : m_colRemovedNodes)
			m_oRunner.getRuntimeState().removeNodeFromState(oNode);

		m_oRunner.getRuntimeState().setActiveNode(m_oNode);

		// add stateconfiguration to history
		if(m_oNode instanceof TCGRealNode) {
			m_oRunner.getStateConfigurationHistory().add(
					new StateConfiguration(m_oRunner.getRuntimeState(), 
							m_oRunner.getConditionsToBeSatisfied()));
		}
	}
	
	public void undoRuntimeStateChange() {
		m_oRunner.getRuntimeState().removeNodeFromState(m_oNode);
		for(TCGNode oNode : m_colRemovedNodes) {
			m_oRunner.getRuntimeState().setActiveNode(oNode);
		}
		// remove last state configuration from history
		if(m_oNode instanceof TCGRealNode) {
			m_oRunner.getStateConfigurationHistory().remove(
					m_oRunner.getStateConfigurationHistory().size() - 1);
		}

	}
}
