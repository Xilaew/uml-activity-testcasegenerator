package net.sf.parteg.base.testcasetree;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

public class SystemModelStateHistory {

	private ArrayList<SystemModelState> m_colVisitedSystemModelStates;
	private ArrayList<Vertex> m_colEverVisitedStates;
	private ArrayList<State> m_colDoubleVisitedStates;
	private ArrayList<Transition> m_colTransitionsMarkedAsAlreadyUsed;
	private ArrayList<Transition> m_colEverVisitedTransitions;

	public SystemModelStateHistory()
	{
		m_colVisitedSystemModelStates = new ArrayList<SystemModelState>();
		m_colEverVisitedStates = new ArrayList<Vertex>();
		m_colDoubleVisitedStates = new ArrayList<State>();
		m_colTransitionsMarkedAsAlreadyUsed = new ArrayList<Transition>();
		m_colEverVisitedTransitions = new ArrayList<Transition>();
	}
	
	public boolean isSystemStateVisited(SystemModelState in_oSMState)
	{
		for(SystemModelState oSystemState : m_colVisitedSystemModelStates)
		{
			boolean bFound = true;
			for(Vertex oVertex : oSystemState.getSystemVertices())
			{
				if(!in_oSMState.getSystemVertices().contains(oVertex))
					bFound = false;
			}
			if(bFound == true)
				return true;
		}
		return false;
	}

	public void addVisitedState(SystemModelState in_oState)
	{
		//SystemModelState oSystemState = new SystemModelState();
		//oSystemState.getSystemVertices().addAll(in_oState.getSystemVertices());
		//m_colVisitedSystemModelStates.add(oSystemState);
		m_colVisitedSystemModelStates.add(in_oState);
		for(Vertex oVertex : in_oState.getSystemVertices())
		{
			m_colEverVisitedStates.add(oVertex);
		}
		//updateVisitedStateList();
	}

	public void removeVisitedState(SystemModelState in_oState)
	{
		for(SystemModelState oSystemState : m_colVisitedSystemModelStates)
		{
			boolean bFound = true;
			for(Vertex oVertex : oSystemState.getSystemVertices())
			{
				if(!in_oState.getSystemVertices().contains(oVertex))
					bFound = false;
			}
			if(bFound == true)
			{
				m_colVisitedSystemModelStates.remove(oSystemState);
				//updateVisitedStateList();
				return;
			}
		}
	}

	public SystemModelState getCurrentSystemModelState()
	{
		return m_colVisitedSystemModelStates.get(m_colVisitedSystemModelStates.size() - 1);
	}

	public boolean transitionsSourceWasVisitedTwice(Transition in_oTransition)
	{
		if(m_colDoubleVisitedStates.contains(in_oTransition.getSource()))
			return true;
		return false;
	}

	/*
	 * TODO viel zu aufwändig, die Methode jedes Mal erneut aufzurufen -> lieber Veränderungen mitloggen
	 */
//	private void updateVisitedStateList()
//	{
//		m_colDoubleVisitedStates.clear();
//		// initialize tracker
//		HashMap<State, Integer> colStateTrack = new HashMap<State, Integer>();
//		for(SystemModelState oSMState : m_colVisitedSystemModelStates)
//		{
//			for(Vertex oVertex : oSMState.getSystemVertices())
//			{
//				if(oVertex instanceof State)
//				{
//					colStateTrack.put((State)oVertex, 0);
//				}
//			}
//		}
//		
//		// search
//		for(SystemModelState oSMState : m_colVisitedSystemModelStates)
//		{
//			for(State oState : colStateTrack.keySet())
//			{
//				if(colStateTrack.get(oState).equals(0) && oSMState.getSystemVertices().contains(oState))
//					colStateTrack.put(oState, 1);
//				else if(colStateTrack.get(oState).equals(1) && !oSMState.getSystemVertices().contains(oState))
//					colStateTrack.put(oState, 2);
//				else if(colStateTrack.get(oState).equals(2) && oSMState.getSystemVertices().contains(oState))
//					colStateTrack.put(oState, 3);
//			}
//		}
//		
//		// get all those states that were visited already (value = 3)
//		for(State oState : colStateTrack.keySet())
//		{
//			if(colStateTrack.get(oState).equals(3))
//				m_colDoubleVisitedStates.add(oState);
//		}
//	}
	
	
	public Vertex findTheLastUsedOf(EList<Vertex> in_colVertices)
	{
		for(int i = m_colVisitedSystemModelStates.size() - 1; i >= 0; --i)
		{
			SystemModelState oSMState = m_colVisitedSystemModelStates.get(i);
			for(Vertex oVertex : in_colVertices)
			{
				if(oSMState.getSystemVertices().contains(oVertex))
					return oVertex;
			}
		}
		return null;
	}
	
	public boolean transitionIsMarkedAsAlreadyUsed(Transition in_oTransition)
	{
		return m_colTransitionsMarkedAsAlreadyUsed.contains(in_oTransition);
	}

	public boolean sourceOfTransitionBelongsToTransitionWhichIsMarkedAsAlreadyUsed(Transition in_oTransition)
	{
		for(Transition oTransition : m_colTransitionsMarkedAsAlreadyUsed)
		{
			if(oTransition.getSource().equals(in_oTransition.getSource()))
				return true;
		}
		return false;
	}

	public boolean vertexHasEverBeenVisited(Vertex in_oVertex)
	{
		return m_colEverVisitedStates.contains(in_oVertex);
	}

	public boolean transitionHasEverBeenVisited(Transition in_oTransition)
	{
		return m_colEverVisitedTransitions.contains(in_oTransition);
	}	
	
	public void markTransitionAsAlreadyUsed(Transition in_oTransition)
	{
		m_colTransitionsMarkedAsAlreadyUsed.add(in_oTransition);
		m_colEverVisitedTransitions.add(in_oTransition);
	}

	public void unmarkTransitionAsAlreadyUsed(Transition in_oTransition)
	{
		m_colTransitionsMarkedAsAlreadyUsed.remove(in_oTransition);
	}
}
