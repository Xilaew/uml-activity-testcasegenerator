package net.sf.parteg.base.testcasetree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.LiteralString;

public class SystemModelHelper {


	/**
	 * 
	 * @param in_colVertices
	 * @return all outgoing transitions from the incoming list of vertices
	 */
	public static ArrayList<Transition> getOutgoingTransitions(SystemModelState in_oSMState)
	{
		ArrayList<Transition> colTransitions = new ArrayList<Transition>();
		for(Vertex oVertex : in_oSMState.getSystemStatesAndSuperStates())
		{
			for(Transition oTransition : oVertex.getOutgoings())
			{
				colTransitions.add(oTransition);
			}
		}
		return colTransitions;
	}
	
	/**
	 * 
	 * @param in_colTransitions
	 * @return all releasing trigger of the incoming list of transitions
	 */
	public static ArrayList<Event> getEvents(ArrayList<Transition> in_colTransitions)
	{
		ArrayList<Event> colEvents = new ArrayList<Event>();
		for(Transition oTransition : in_colTransitions)
		{
			for(Trigger oTrigger : oTransition.getTriggers())
			{
				Event oEvent = oTrigger.getEvent();
				if(!colEvents.contains(oEvent))
					colEvents.add(oEvent);
			}
			// no trigger for this transition -> default trigger
			if(oTransition.getTriggers().isEmpty())
			{
				if(!colEvents.contains(null))
					colEvents.add(null);
			}
		}
		return colEvents;
	}

	public static ArrayList<Vertex> findInitState(StateMachine in_oStateMachine)
	{
		ArrayList<Vertex> colVertices = new ArrayList<Vertex>();
		ArrayList<Vertex> colPseudoStates = findInitPseudoState(in_oStateMachine);
		for(Vertex oVertex : colPseudoStates)
		{
			Transition oTransition = oVertex.getOutgoings().get(0);
			colVertices.add(oTransition.getTarget());
		}
		return colVertices;
	}

	
	private static ArrayList<Vertex> findInitPseudoState(StateMachine in_oStateMachine)
	{
		ArrayList<Vertex> colVertices = new ArrayList<Vertex>();
		// vorerst nur eine Region
		for(Region oRegion : in_oStateMachine.getRegions())
		{
			for(Vertex oVertex : oRegion.getSubvertices())
			{
				if(oVertex instanceof Pseudostate)
				{
					Pseudostate oPS = (Pseudostate)oVertex;
					if(oPS.getKind().getValue() == PseudostateKind.INITIAL)
						colVertices.add((Pseudostate)oVertex);
				}
			}
		}
		return colVertices;
	}
	
	public static boolean isEventTriggeringTransition(Event in_oEvent, Transition in_oTransition)
	{
		for(Trigger oTrigger : in_oTransition.getTriggers())
		{
			if(oTrigger.getEvent() == in_oEvent)
				return true;
		}
		if((in_oEvent == null) && (in_oTransition.getTriggers().isEmpty()))
			return true;
		return false;
	}

	public static String getTransitionGuard(Transition in_oTransition)
	{
		Constraint oConstraint = in_oTransition.getGuard();
		return getConstraintSpecification(oConstraint);
	}
	
	public static String getStateInvariant(Vertex in_oVertex)
	{
		if(in_oVertex instanceof State)
		{
			Constraint oConstraint = ((State)in_oVertex).getStateInvariant();
			return getConstraintSpecification(oConstraint);
		}
		return "";
	}
	
	public static String getConstraintSpecification(Constraint in_oConstraint)
	{
		if(in_oConstraint != null)
		{
			if(in_oConstraint.getSpecification() instanceof LiteralString)
			{
				LiteralString oString = (LiteralString)in_oConstraint.getSpecification();
				return oString.getValue();
			}
		}
		return "";		
	}
	
	public static String getMethodCondition(Transition in_oTransition, String in_sKindOfCondition)
	{
		Behavior oEffect = in_oTransition.getEffect();
		if(oEffect != null)
		{
			for(EAnnotation oEAnnotation : oEffect.getSpecification().getEAnnotations())
			{
				if(oEAnnotation.getSource().compareTo(Configuration.getOCLId()) == 0)
				{
					if(oEAnnotation.getDetails().containsKey(in_sKindOfCondition))
						return oEAnnotation.getDetails().get(in_sKindOfCondition);
				}
			}
		}
		return "";		
	}	

	public static String getMethodCondition(Operation in_oOperation, String in_sKindOfCondition)
	{
		for(EAnnotation oEAnnotation : in_oOperation.getEAnnotations())
		{
			if(oEAnnotation.getSource().compareTo(Configuration.getOCLId()) == 0)
			{
				if(oEAnnotation.getDetails().containsKey(in_sKindOfCondition))
					return oEAnnotation.getDetails().get(in_sKindOfCondition);
			}
		}
		return "";		
	}	

	public static String getMethodCondition(BehavioralFeature in_oBehavioralFeature, String in_sKindOfCondition)
	{
		for(EAnnotation oEAnnotation : in_oBehavioralFeature.getEAnnotations())
		{
			if(oEAnnotation.getSource().compareTo(Configuration.getOCLId()) == 0)
			{
				if(oEAnnotation.getDetails().containsKey(in_sKindOfCondition))
					return oEAnnotation.getDetails().get(in_sKindOfCondition);
			}
		}
		return "";		
	}	

	public static boolean isSystemModelValid(StateMachine in_oStateMachine) throws Exception
	{
		// die Zustandsmaschine muss benannt sein 
		if(in_oStateMachine.getName().equals(""))
		{
			throw new Exception("One state machine has no name"); 
		}
			
		
		for(Region oRegion : in_oStateMachine.getRegions())
		{
			for(Transition oTransition : oRegion.getTransitions())
			{
				// jede Transtion hat source und target
				if(oTransition.getSource() == null)
					throw new Exception("transition " + oTransition.getName() + " has no valid source vertex");
				if(oTransition.getTarget() == null)
					throw new Exception("transition " + oTransition.getName() + " has no valid target vertex");
				
				// jede Transition hat einen Trigger (mit Ausnahme von den init?)
//				if(oTransition.getTriggers().size() == 0)
//					throw new Exception("transition " + oTransition.getName() + " has no triggers");
				
//				for(Trigger oTrigger : oTransition.getTriggers())
//				{
//					if(oTrigger.getEvent() == null)
//						throw new Exception("trigger " + oTrigger.getName() + " of transition " + oTransition.getName()
//								+ " has no assigned event");
//				}
				
				// jeder Effect einer Transition referenziert in specification auch eine Operation
				Behavior oEffect = oTransition.getEffect();
				if(oEffect != null)
				{
					if(oEffect.getSpecification() == null)
					{
						throw new Exception("transition " + oTransition.getName() + " has an effect without an assigned operation");
					}
				}
			}
		
			// jeder init pseudo state hat genau eine ausgehende Transition
			for(Vertex oVertex : oRegion.getSubvertices())
			{
				if(oVertex instanceof Pseudostate)
				{
					Pseudostate oPS = (Pseudostate)oVertex;
					if(oPS.getKind().getValue() == PseudostateKind.INITIAL)
					{
						if(oPS.getOutgoings().size() != 1)
							throw new Exception("init state " + oPS.getName() + " has not exactly one outgoing transition");
					}
						
				}
			}
		}
		
		// jede Region hat eine ClientDependency, deren Supplier zu einer UML-Klasse zeigt
		
		return true;
	}

	/**
	 * (relative to the class generalization hierarchy)
	 * @param in_oOperationDefinition upper operation definition
	 * @param in_oClass actual class
	 * @return the actual operation for a class in a class generalization hierarchy
	 */
	public static Operation getActiveOperationForClass(Operation in_oOperationDefinition,
			org.eclipse.uml2.uml.Class in_oClass)
	{
		// try to find a matching operation in in_oClass
		for(Operation oOperation : in_oClass.getOperations())
		{
			boolean bRetTypeAndParameterMatching = true;
			if(oOperation.getType() == null)
			{
				if(in_oOperationDefinition.getType() != null)
					bRetTypeAndParameterMatching = false;
			}
			else if(!oOperation.getType().equals(in_oOperationDefinition.getType()))
			{
				bRetTypeAndParameterMatching = false;
			}
			if(oOperation.getOwnedParameters().size() != in_oOperationDefinition.getOwnedParameters().size())
			{
				bRetTypeAndParameterMatching = false;
			}
			
			if(bRetTypeAndParameterMatching == true)
			{
				boolean bFound = true;
				for(int i = 0; i < oOperation.getOwnedParameters().size(); ++i)
				{
					if(!oOperation.getOwnedParameters().get(i).getType().equals(
							in_oOperationDefinition.getOwnedParameters().get(i).getType()))
						bFound = false;
				}
				if(bFound == true)
					return oOperation;
			}
		}
		
		// else: search in the next-upper class
		org.eclipse.uml2.uml.Class oSuperClass = in_oClass.getSuperClasses().get(0);
		if(oSuperClass == null)
			return null;
		else
			return getActiveOperationForClass(in_oOperationDefinition, oSuperClass);
	}
	
	public static org.eclipse.uml2.uml.Package getSuperPackage(org.eclipse.uml2.uml.Element in_oElement)
	{
		org.eclipse.uml2.uml.Package oPackage = in_oElement.getNearestPackage().getNestingPackage();
		if(oPackage == null)
		{
			if(in_oElement instanceof org.eclipse.uml2.uml.Package)
			{
				return (org.eclipse.uml2.uml.Package)in_oElement;
			}
			return null;
		}
		else
		{
			return getSuperPackage(oPackage);
		}
		
	}
	
	public static void getAllContainedClasses(org.eclipse.uml2.uml.Package in_oPackage, 
			Set<org.eclipse.uml2.uml.Class> io_colClasses)
	{
		for(PackageableElement oElement : in_oPackage.getPackagedElements())
		{
			if(oElement instanceof org.eclipse.uml2.uml.StateMachine) 
			{} // Zustandsmaschinen sind Instanzen von Class?			
			else if(oElement instanceof org.eclipse.uml2.uml.Class)
			{
				io_colClasses.add((org.eclipse.uml2.uml.Class)oElement);
			}
			else if(oElement instanceof org.eclipse.uml2.uml.Package)
			{
				getAllContainedClasses((org.eclipse.uml2.uml.Package)oElement, io_colClasses);
			}
		}
	}
	
	/**
	 * finds all subclasses for in_oSuperClass
	 * problem: in current UML-plugin inheritance relationships are only known in subclasses
	 * solution: add the subclasses step-by-step
	 * @param in_oSuperClass
	 * @param in_colAllClasses
	 * @return
	 */
	public static Set<org.eclipse.uml2.uml.Class> getSubClasses(org.eclipse.uml2.uml.Class in_oSuperClass,
			Set<org.eclipse.uml2.uml.Class> in_colAllClasses)
	{
		Set<org.eclipse.uml2.uml.Class> oSubClasses = new LinkedHashSet<org.eclipse.uml2.uml.Class>();
		Set<org.eclipse.uml2.uml.Class> oSubClassesTmp = new LinkedHashSet<org.eclipse.uml2.uml.Class>();
		int nOldNumber = oSubClasses.size(); 
		oSubClasses.add(in_oSuperClass);
		oSubClassesTmp.add(in_oSuperClass);
		// collect subclasses
		while(nOldNumber != oSubClasses.size())
		{
			nOldNumber = oSubClasses.size();
			for(org.eclipse.uml2.uml.Class oClass : in_colAllClasses)
			{
				for(org.eclipse.uml2.uml.Class oSuperClass : oSubClasses)
				{
					if(oClass.getSuperClasses().contains(oSuperClass))
					{
						oSubClassesTmp.add(oClass);
					}
				}
			}
			oSubClasses.addAll(oSubClassesTmp);
		}
		
		// remove abstract classes
		ArrayList<org.eclipse.uml2.uml.Class> colRemoveClasses = new ArrayList<org.eclipse.uml2.uml.Class>(); 
		for(org.eclipse.uml2.uml.Class oClass : oSubClasses)
		{
			if(oClass.isAbstract())
				colRemoveClasses.add(oClass);
		}
		oSubClasses.removeAll(colRemoveClasses);
		
		return oSubClasses;
	}

	// @deprecated: classes are set specific to state machines and not specific to regions
	public static org.eclipse.uml2.uml.Class getClassForRegion(Region in_oRegion)
	{
		//checks
		if(in_oRegion.getClientDependencies().size() == 1)
		{
			Dependency oDep = in_oRegion.getClientDependencies().get(0); 
			if(oDep.getSuppliers().size() == 1)
			{
				NamedElement oElem = oDep.getSuppliers().get(0);
				if(oElem instanceof org.eclipse.uml2.uml.Class)
				{
					return (org.eclipse.uml2.uml.Class)oElem;
				}
			}
		}
		return null;
	}
	
	/**
	 * returns the context class of the given state machine
	 * @param in_oStateMachine
	 * @return
	 */
	public static org.eclipse.uml2.uml.Class getClassForStateMachine(StateMachine in_oStateMachine)
	{
		BehavioredClassifier oClassifier = in_oStateMachine.getContext();
		if(oClassifier instanceof org.eclipse.uml2.uml.Class)
			return (org.eclipse.uml2.uml.Class)oClassifier;
		return null;
	}
	
	public static String getNamespaceName(org.eclipse.uml2.uml.Package in_oPackage)
	{
		StringBuffer sRetValue = new StringBuffer("");
		if(in_oPackage != null && in_oPackage.getName() != null && !in_oPackage.getName().equals(""))
		{
			sRetValue = new StringBuffer(in_oPackage.getName()); 
			String sSuperName = getNamespaceName(in_oPackage.getNestingPackage());
			if(sSuperName != null && !sSuperName.equals(""))
			{
				sRetValue.insert(0, sSuperName + ".");
			}
		}
		return sRetValue.toString();
	}
	
	public static Namespace getNamespaceForEvent(Vertex in_oVertex, Event in_oEvent)
	{
		org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClassForVertex(in_oVertex);
		Namespace oNamespace = oContextClass;
		if(in_oEvent != null)
		{
			if(in_oEvent instanceof CallEvent)
			{
				CallEvent oCallEvent = (CallEvent)in_oEvent;
				oNamespace = oCallEvent.getOperation();
			}
			// TODO andere events auﬂer CallEvents einbauen
		}
		return oNamespace;
	}
}
