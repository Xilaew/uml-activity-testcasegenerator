package net.sf.parteg.base.testcasetree.eventtree;

import net.sf.parteg.base.testcasetree.generated.TCGEvent;


public class EventArc {

	private TCGEvent m_oReferencedEvent;
	private EventNode m_oTargetNode;
	
	public EventArc(TCGEvent in_oEvent)
	{
		m_oReferencedEvent = in_oEvent;
		m_oTargetNode = null;
	}
	
	public EventNode getTargetNode()
	{
		return m_oTargetNode;
	}
	
	public void setTargetNode(EventNode in_oEventNode)
	{
		m_oTargetNode = in_oEventNode;
	}
	
	public TCGEvent getReferencedEvent()
	{
		return m_oReferencedEvent;
	}
}
