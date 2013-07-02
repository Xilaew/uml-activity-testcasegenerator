package net.sf.parteg.base.testcasegraph.testsuite;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;

public class TransitionInstance {

	private TCGTransition m_oTransition;
	//private Event m_oCalledEvent;
	private ArrayList<EventParameterInstance> m_colParameterInstances;
	private String m_sName;
	// a reference to the preceding transition instance
	private TransitionInstance m_oPrecedingTransitionInstance;
	private TransitionInstance m_oSucceedingTransitionInstance;
	
	// references to the actually used expressions
	private ArrayList<TCGOCLExpression> m_colUsedPreConditions;
	private ArrayList<TCGOCLExpression> m_colUsedPostConditions;
	
	private TCGEvent m_oCalledEvent;
	private TCGNode m_oConnectedNode;
	private boolean m_bUseNextStateInvariant;
	
	public TransitionInstance(TCGTransition in_oTransition)
	{
		m_oConnectedNode = null;
		m_oTransition = in_oTransition;
		m_colParameterInstances = new ArrayList<EventParameterInstance>();
		m_sName = "default";
		m_oPrecedingTransitionInstance = null;
		m_oSucceedingTransitionInstance = null;
		m_colUsedPreConditions = new ArrayList<TCGOCLExpression>();
		m_colUsedPostConditions = new ArrayList<TCGOCLExpression>();
		m_oCalledEvent = null;
		m_bUseNextStateInvariant = true;
	}
	
	// creation of self-loop
	public TransitionInstance(TCGNode in_oNode)
	{
		// TODO Refactoring: create a new class "SelfLoopTransitionInstance"
		m_oConnectedNode = in_oNode;
		m_oTransition = null;
		m_colParameterInstances = new ArrayList<EventParameterInstance>();
		m_sName = "default";
		m_oPrecedingTransitionInstance = null;
		m_oSucceedingTransitionInstance = null;
		m_colUsedPreConditions = new ArrayList<TCGOCLExpression>();
		m_colUsedPostConditions = new ArrayList<TCGOCLExpression>();
		m_oCalledEvent = null;
		m_bUseNextStateInvariant = true;
	}
	
	public TCGTransition getTransition()
	{
		return m_oTransition;
	}
	
	public ArrayList<EventParameterInstance> getParameterInstances()
	{
		return m_colParameterInstances;
	}
	
	public void setName(String in_sName)
	{
		m_sName = in_sName;
	}
	
	public String getName()
	{
		return m_sName;
	}
	
	public EventParameterInstance getInstanceForTCGParameter(TCGParameter in_oTCGParameter)
	{
		for(EventParameterInstance oEPInstance : m_colParameterInstances)
		{
			if(oEPInstance.getParameter().equals(in_oTCGParameter))
			{
				return oEPInstance;
			}
		}
		return null;
	}
	
	public boolean adaptEventParameterValueRanges(TCGParameter in_oTCGParameter,
			ValueTypeRange in_oRange)
	{
		EventParameterInstance oEPInstance = getInstanceForTCGParameter(in_oTCGParameter);
		// found no event parameter instance - create a new one
		if(oEPInstance == null)
		{
			oEPInstance = new EventParameterInstance(in_oTCGParameter, this);
			m_colParameterInstances.add(oEPInstance);
		}
		if(oEPInstance.getValueRange() != null)
			return oEPInstance.getValueRange().adaptRange(in_oRange);
		else
			return true;
	}

	public TransitionInstance getPrecedingTransitionInstance() {
		return m_oPrecedingTransitionInstance;
	}

	public void setPrecedingTransitionInstance(
			TransitionInstance precedingTransitionInstance) {
		m_oPrecedingTransitionInstance = precedingTransitionInstance;
	}

	public TransitionInstance getSucceedingTransitionInstance() {
		return m_oSucceedingTransitionInstance;
	}

	public void setSucceedingTransitionInstance(
			TransitionInstance succeedingTransitionInstance) {
		m_oSucceedingTransitionInstance = succeedingTransitionInstance;
	}

	public ArrayList<TCGOCLExpression> getUsedPreConditions() {
		return m_colUsedPreConditions;
	}
	
	public ArrayList<TCGOCLExpression> getUsedPostConditions() {
		return m_colUsedPostConditions;
	}
	
	public TCGEvent getCalledEvent()
	{
		if(m_oCalledEvent != null)
			return m_oCalledEvent;
		else
			if(m_oTransition != null && !m_oTransition.getEvents().isEmpty())
				return m_oTransition.getEvents().get(0);
		return null;
	}
	
	public List<TCGEvent> getCallableEvents()
	{
		List<TCGEvent> colEvents = new ArrayList<TCGEvent>();

		if(m_oCalledEvent != null)
			colEvents.add(m_oCalledEvent);
		else
			if(m_oTransition != null) {
				colEvents.addAll(m_oTransition.getEvents());
			}
				
		return colEvents;
	}
	
	public void setCalledEvent(TCGEvent in_oEvent)
	{
		m_oCalledEvent = in_oEvent;
	}
	
	public TCGNode getSourceNode()
	{
		if(m_oTransition == null)
			return m_oConnectedNode;
		else
			return m_oTransition.getSourceNode();
	}

	public TCGNode getTargetNode()
	{
		if(m_oTransition == null)
			return findLastVisitedNodeContainedOrEqualToCurrentNode();
		else
			return m_oTransition.getTargetNode();
	}

	public void useNextStateInvariant(boolean in_bUseNextStateInvariant)
	{
		m_bUseNextStateInvariant = in_bUseNextStateInvariant;
	}
	
	public boolean getUseNextStateInvariant()
	{
		return m_bUseNextStateInvariant;
	}
	
	public TCGNode findLastVisitedNodeContainedOrEqualToCurrentNode()
	{
		if(getSourceNode() != null) {
			TransitionInstance oCurrentTransitionInstance = 
				getPrecedingTransitionInstance();
			while(oCurrentTransitionInstance != null) {
				if(oCurrentTransitionInstance.getTransition() != null) {
					TCGNode oLastNode = oCurrentTransitionInstance.getTransition().getTargetNode();
					if(TCGNodeHelperClass.getAllSuperStatesIncludingThis(oLastNode).contains(getSourceNode())) {
						return oLastNode;
					}
				}
				oCurrentTransitionInstance = 
					oCurrentTransitionInstance.getPrecedingTransitionInstance();
			}
		}
		return getSourceNode();
	}
}
