package net.sf.parteg.base.testcasegraph.systemstate;

import java.util.ArrayList;

import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * 
 * @author Stephan
 * This class models a state of the system model, each of which
 * can consist of several states in different regions. 
 */
public class SystemModelState {

	private ArrayList<Vertex> m_colVertices;
	private SystemModelStateHistory m_oHistory;
	
	public SystemModelState(SystemModelStateHistory in_oHistory, SystemModelState in_oSystemModel)
	{
		m_colVertices = new ArrayList<Vertex>();
		m_colVertices.addAll(in_oSystemModel.getSystemVertices());
		m_oHistory = in_oHistory;
	}

	public SystemModelState(SystemModelStateHistory in_oHistory, ArrayList<Vertex> in_colVertices)
	{
		m_colVertices = new ArrayList<Vertex>();
		m_colVertices.addAll(in_colVertices);
		m_oHistory = in_oHistory;
	}

	public SystemModelState(SystemModelStateHistory in_oHistory)
	{
		m_colVertices = new ArrayList<Vertex>();
		m_oHistory = in_oHistory;
	}
	
	public ArrayList<Vertex> getSystemVertices()
	{
		return m_colVertices;
	}
	
	public ArrayList<Vertex> getSystemStatesAndSuperStates()
	{
		ArrayList<Vertex> colCompleteVertices = new ArrayList<Vertex>();
		for(Vertex oVertex : m_colVertices)
		{
			colCompleteVertices.add(oVertex);
			Vertex oSuperVertex = oVertex.getContainer().getState();
			while(oSuperVertex != null)
			{
				if(!colCompleteVertices.contains(oSuperVertex))
					colCompleteVertices.add(oSuperVertex);
				oSuperVertex = oSuperVertex.getContainer().getState();
			}
		}
		return colCompleteVertices;
	}
	
	public void exchangeVertices(Vertex in_oOldNode, Vertex in_oNewNode)
	{
		removeAllSubNodes(in_oOldNode);
		addAllSubNodes(in_oNewNode);
	}
	
	/*
	 * remove all sub nodes of the current node
	 */
	private void removeAllSubNodes(Vertex in_oVertex)
	{
		ArrayList<Vertex> colVerticesToDelete = new ArrayList<Vertex>();
		if(in_oVertex instanceof State)
		{
			// check for each state if it is contained in the super state
			for(Vertex oVertex : m_colVertices)
			{
				if(firstVertexIsSuperStateOfSecondVertex(in_oVertex, oVertex) == true)
					colVerticesToDelete.add(oVertex);
			}
		}
		for(Vertex oVertex : colVerticesToDelete)
			m_colVertices.remove(oVertex);
		
		m_colVertices.remove(in_oVertex);
	}
	
	/*
	 * add all sub nodes  
	 */
	private void addAllSubNodes(Vertex in_oVertex)
	{
		boolean bHasSubRegions = false;
		if(in_oVertex instanceof State)
		{
			State oState = (State)in_oVertex;
			if(!oState.getRegions().isEmpty())
				bHasSubRegions = true;
			
			if(bHasSubRegions == true)
				m_colVertices.addAll(getAtomicSubVertices(oState));
		}
		if(!bHasSubRegions)
			m_colVertices.add(in_oVertex);
	}
	
	/*
	 * returns all sub vertices of in_oVertex (and in_oVertex itself)
	 */
	private ArrayList<Vertex> getAtomicSubVertices(Vertex in_oVertex)
	{
		ArrayList<Vertex> colVertices = new ArrayList<Vertex>();
		if(in_oVertex instanceof State)
		{
			State oState = (State)in_oVertex;
			if(oState.getRegions().isEmpty())
				colVertices.add(in_oVertex);
			
			// find the target states of the outgoing transitions of all initial states of the subregions
			for(Region oRegion : oState.getRegions())
			{
				for(Vertex oRunVertex : oRegion.getSubvertices())
				{
					if(oRunVertex instanceof Pseudostate)
					{
						Pseudostate oPseudostate = (Pseudostate)oRunVertex;
						if(oPseudostate.getKind().equals(PseudostateKind.SHALLOW_HISTORY_LITERAL) ||
							oPseudostate.getKind().equals(PseudostateKind.DEEP_HISTORY_LITERAL))
						{
							Vertex oFirstVertex = m_oHistory.findTheLastUsedOf(oRegion.getSubvertices());
							if((oFirstVertex == null) || (oPseudostate.equals(oFirstVertex)))
							{
								oFirstVertex = oPseudostate.getOutgoings().get(0).getTarget();
							}
							// recursive search for sub regions
							colVertices.addAll(getAtomicSubVertices(oFirstVertex));
							
						}
						else if(oPseudostate.getKind().equals(PseudostateKind.INITIAL_LITERAL))
						{
							Vertex oFirstVertex = oPseudostate.getOutgoings().get(0).getTarget();
							// recursive search for sub regions
							colVertices.addAll(getAtomicSubVertices(oFirstVertex));
						}
					}
				}
			}
		}
		else
			colVertices.add(in_oVertex);
		return colVertices;
	}
	
	private boolean firstVertexIsSuperStateOfSecondVertex(Vertex in_oFirstVertex, Vertex in_oSecondVertex)
	{
		if(in_oFirstVertex == in_oSecondVertex)
			return false;
		Vertex oContainerVertex = in_oSecondVertex.getContainer().getState();
		while(oContainerVertex != null)
		{
			if(oContainerVertex == in_oFirstVertex)
			{
				return true;
			}
			oContainerVertex = oContainerVertex.getContainer().getState();
		}
		return false;
	}
	
	public String getName()
	{
		StringBuffer sName = new StringBuffer();
		for(Vertex oVertex : m_colVertices)
		{
			sName.append(oVertex.getName());
		}
		// remove white spaces
		int i = 0;
		while(-1 < (i = sName.indexOf(" ")))
		{
			sName.replace(i, i+1, "_");
		}
		return sName.toString();
	}
	
	public Pseudostate returnContainedPseudoState()
	{
		for(Vertex oVertex : m_colVertices)
		{
			if(oVertex instanceof Pseudostate)
				return (Pseudostate)oVertex;
		}
		return null;
	}
	
	/*
	 * if selected transition is outgoing transition of super state then all sub states are final
	 */
	public boolean ifSourceSuperStateThenAllSubFinal(Transition in_oTransition)
	{
		Vertex oVertex = in_oTransition.getSource();
		for(Vertex oCurrentVertex : m_colVertices)
		{
			if(firstVertexIsSuperStateOfSecondVertex(oVertex, oCurrentVertex))
			{
				if(!(oCurrentVertex instanceof FinalState))
					return false;
			}
		}
		return true;
	}

	
//	public State returnContainedCompositeState()
//	{
//		for(Vertex oVertex : m_colVertices)
//		{
//			if(oVertex instanceof Pseudostate)
//				return (State)oVertex;
//		}
//		return null;
//	}
	
}
