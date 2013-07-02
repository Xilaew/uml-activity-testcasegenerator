package net.sf.parteg.base.testcasetree.eventtree;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.TCGNode;



public class EventNode {

	private ArrayList<TCGNode> m_colNodes;
	private ArrayList<EventArc> m_colOutgoingArcs;

	public ArrayList<TCGNode> getLeafNodes() {
		if(m_colNodes == null)
			m_colNodes = new ArrayList<TCGNode>();
		return m_colNodes;
	}

	public ArrayList<EventArc> getOutgoingArcs()
	{
		if(m_colOutgoingArcs == null)
			m_colOutgoingArcs = new ArrayList<EventArc>();
		return m_colOutgoingArcs;
	}
}
