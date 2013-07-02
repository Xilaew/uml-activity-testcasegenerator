package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.core.structures.ObjectComparator;

import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

public class TCGEventHelperClass {

	// map
	// each transition can reference several events 
	//   -> target = List<TCGParameter>
	// each effect can be referenced by several transitions
	//   -> source = Pair<Parameter, Transition>

	// Geht das?
	// alternative: create separate parameters for each pair of transition and parameter?
	// Was passiert mit guard conditions? -> sind schon korrekt zugeordnet (wenn Kontext korrekt)
	private static Map<Parameter, Map<TCGTransition, List<Parameter>>>
		colParamTransitionMapToEventParameterList = 
			new HashMap<Parameter, Map<TCGTransition, List<Parameter>>>();

	public static Map<Parameter, Map<TCGTransition, List<Parameter>>>
		getMapParamTransitionMapToEventParameterList() {
		return colParamTransitionMapToEventParameterList;
	}
	
	public static List<Parameter> getEventParameters(
			Parameter in_oParameter, 
			TCGTransition in_oTransition) {
		Map<TCGTransition, List<Parameter>> colTransitionToParameters =
			getMapParamTransitionMapToEventParameterList().get(in_oParameter);
		if(colTransitionToParameters != null) {
			List<Parameter> colParameters =
				colTransitionToParameters.get(in_oTransition);
			if(colParameters != null)
				return colParameters;
		}
		return new ArrayList<Parameter>();
	}

	public static Event getEventOfTCGEvent(TCGEvent in_oTCGEvent)
	{
		if(in_oTCGEvent == null)
			return null;
		else if(in_oTCGEvent.getEvent() == null)
			return null;
		else
			return (Event)(in_oTCGEvent.getEvent());
	}
	
	public static boolean eventsAreEqual(
			TCGEvent in_oEvent1, TCGEvent in_oEvent2)
	{
		// both events are null
		if(in_oEvent1 == null && in_oEvent2 == null)
			return true;
		if(in_oEvent1 == null || in_oEvent2 == null)
			return false;
		
		// both events reference the same original event object
		if(ObjectComparator.equals(in_oEvent1.getEvent(), in_oEvent2.getEvent())) {
			return true;
		}
		
		// both events have the same name and the same parameters
		if((in_oEvent1.getParameters().size() == in_oEvent2.getParameters().size()) &&
			ObjectComparator.equals(in_oEvent1.getName(), in_oEvent2.getName())) {
			for(int i = 0; i < in_oEvent1.getParameters().size(); ++i) {
				TCGParameter oParam1 = in_oEvent1.getParameters().get(i);
				TCGParameter oParam2 = in_oEvent2.getParameters().get(i);
				if(!(ObjectComparator.equals(oParam1.getName(),
						oParam2.getName()) && 
					ObjectComparator.equals(oParam1.getValueType(),
							oParam2.getValueType()))) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}

	/**
	 * creates a TCGEvent for an event of a state machine
	 * @param in_oSMEvent
	 * @return
	 */
	public static TCGEvent createTCGEvent(
			Event in_oSMEvent, 
			boolean in_bCreateTCGEventIfEventIsNull) {
		
		TCGEvent oTCGEvent = GeneratedFactory.eINSTANCE.createTCGEvent();
		if(in_oSMEvent != null){
			oTCGEvent.setName(in_oSMEvent.getName());
			oTCGEvent.setEvent(in_oSMEvent);
			oTCGEvent.setDefaultEvent(false);
			if(in_oSMEvent instanceof CallEvent)
			{
				CallEvent oCallEvent = (CallEvent)in_oSMEvent;
				for(Parameter oParameter : oCallEvent.getOperation().getOwnedParameters())
				{
					oTCGEvent.getParameters().add(
							TCGParameterHelperClass.createTCGParameter(oParameter));
				}
			}
		}
		else if(in_bCreateTCGEventIfEventIsNull)
		{
			oTCGEvent.setName(Configuration.getDefaultTransitionName());
			oTCGEvent.setEvent(null);
			oTCGEvent.setDefaultEvent(true);
		}
		else
			oTCGEvent = null;
		return oTCGEvent;
	}
	
	private static Parameter getMatchingParameter(
			TCGParameter in_oParameter,
			Operation in_oOperation) {
		for(Parameter oParameter : in_oOperation.getOwnedParameters()) {
			if(oParameter.getName().equals(in_oParameter.getName()) &&
					oParameter.getType().equals(in_oParameter.getValueType())) {
				return oParameter;
			}
		}
		return null;
	}
	
	public static void createMatchingForAllParameters(
			Operation in_oOperation,
			TCGEvent in_oEvent,
			TCGTransition in_oTransition) {
		
		if(in_oOperation != null) {
			for(TCGParameter oEventParameter : in_oEvent.getParameters()) {
				Parameter oEffectParameter =
					getMatchingParameter(oEventParameter, in_oOperation);
				// get map from transitions to event parameters 
				Map<TCGTransition, List<Parameter>> colTransitionToParameterMap =
					getMapParamTransitionMapToEventParameterList().get(oEffectParameter);
				if(colTransitionToParameterMap == null) {
					colTransitionToParameterMap = new HashMap<TCGTransition, List<Parameter>>();
					getMapParamTransitionMapToEventParameterList().put(
							oEffectParameter, colTransitionToParameterMap);
				}
				// list of event parameters
				List<Parameter> colParameters =
					colTransitionToParameterMap.get(in_oTransition);
				if(colParameters == null) {
					colParameters = new ArrayList<Parameter>();
					colTransitionToParameterMap.put(in_oTransition, colParameters);
				}
				Parameter oReferencedParameter = (Parameter)oEventParameter.getReference();
				colParameters.add(oReferencedParameter);
//				getMapExprParamToEventParam().put(oEffectParameter, oEventParameter);
			}
		}
	}
}
