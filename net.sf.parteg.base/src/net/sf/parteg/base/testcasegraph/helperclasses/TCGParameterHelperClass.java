package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

public class TCGParameterHelperClass {

	
	
	/**
	 * collects a list of all contained primitive parameters
	 * @param in_oParameter
	 * @return
	 */
	public static ArrayList<TCGPrimitiveParameter> collectContainedPrimitiveParameters(TCGParameter in_oParameter)
	{
		ArrayList<TCGPrimitiveParameter> colPars = new ArrayList<TCGPrimitiveParameter>();
		collectContainedPrimitiveParametersHelper(in_oParameter, colPars);
		return colPars;
	}

	private static void collectContainedPrimitiveParametersHelper(
			TCGParameter in_oParameter,
			ArrayList<TCGPrimitiveParameter> io_colPars)
	{
		if(in_oParameter instanceof TCGPrimitiveParameter)
			io_colPars.add((TCGPrimitiveParameter)in_oParameter);
		else if(in_oParameter instanceof TCGComplexParameter)
		{
			TCGComplexParameter oPar = (TCGComplexParameter)in_oParameter;
			for(TCGParameter oSubParam : oPar.getParameter())
			{
				collectContainedPrimitiveParametersHelper(oSubParam, io_colPars);
			}
		}
	}
	
	public static TCGParameter createTCGParameter(ConnectableElement in_oParameter)
	{
		TCGParameter oRetParam = null;
		if(in_oParameter.getType() instanceof org.eclipse.uml2.uml.Class)
		{
			// create complex parameter
			org.eclipse.uml2.uml.Class oParameterClass = (org.eclipse.uml2.uml.Class)in_oParameter.getType();
			if(oParameterClass.getAllAttributes().size() > 0)
			{
				TCGComplexParameter oComplexTCGParameter = GeneratedFactory.eINSTANCE.createTCGComplexParameter();
				oComplexTCGParameter.setReference(in_oParameter);
				oComplexTCGParameter.setValueType(in_oParameter.getType());
				oComplexTCGParameter.setName(in_oParameter.getName());
				for(Property oProperty : oParameterClass.getAllAttributes())
				{
					TCGParameter oParam = createTCGParameter(oProperty);
					oComplexTCGParameter.getParameter().add(oParam);
				}
				oRetParam = oComplexTCGParameter;
			} else {
				oRetParam = createPrimitiveTCGParameter(in_oParameter);
			}
		} 
		else 
		{
			oRetParam = createPrimitiveTCGParameter(in_oParameter);
		}
		return oRetParam;
	}
	
	private static TCGParameter createPrimitiveTCGParameter(ConnectableElement in_oParameter)
	{
		// TODO Typ-Mapping? Hier müssten verschiedene Typen vordefiniert werden - danach sollte auch die Auswertung angepasst werden 
		// create primitive parameter
		TCGPrimitiveParameter oPrimitiveTCGParameter = GeneratedFactory.eINSTANCE.createTCGPrimitiveParameter();
		// name of the internally used parameter (used in constraints, etc.)
		oPrimitiveTCGParameter.setReference(in_oParameter);
		oPrimitiveTCGParameter.setValueType(in_oParameter.getType());
		oPrimitiveTCGParameter.setName(in_oParameter.getName());
		return oPrimitiveTCGParameter;
	}

	
	public static TCGParameter getSuperParameter(TCGParameter in_oParameter)
	{
		if(in_oParameter.getContainer() != null)
			return getSuperParameter(in_oParameter.getContainer());
		return in_oParameter;
	}
	
	public static String getFullParameterAttributeName(TCGParameter in_oParameter)
	{
		if(in_oParameter.getContainer() == null)
			return in_oParameter.getName();
		return getFullParameterAttributeName(in_oParameter.getContainer()) 
			+ "." + ((Property)in_oParameter.getReference()).getName();
	}
	
	public static String getFullParameterInstanceAttributeName(
			EventParameterInstance in_oParameterInstance)
	{
		StringBuffer sRetValue = new StringBuffer();
		TCGParameter oParameter = in_oParameterInstance.getParameter();
		TCGParameter oParameterContainer = oParameter.getContainer();
		while(oParameterContainer != null)
		{
			sRetValue.insert(0, "." + oParameter.getName());
			oParameter = oParameterContainer; 
			oParameterContainer = oParameter.getContainer();
		}
		sRetValue.insert(0, oParameter.getName() + 
				in_oParameterInstance.getTransitionInstance().getName());
		return sRetValue.toString();
	}
	
	/*
	 * returns the (part of the) parameter that is referencing the given element
	 */
	public static TCGParameter findParameterElementMatchingToReference(
			TCGParameter in_oParameter,
			TransitionInstance in_oTransitionInstance,
			Object in_oReference)
	{
//		if(in_oParameter.getReference().equals(in_oReference))
//			return in_oParameter;
		if(in_oReference instanceof TCGOCLAtom) {
			TCGOCLAtom oReferenceAtom = (TCGOCLAtom)in_oReference;
			EObject oReferenceAtomReference = oReferenceAtom.getElement();
			Parameter oReferencedParameter = null;
			if(oReferenceAtomReference instanceof org.eclipse.ocl.uml.Variable) {
				oReferencedParameter = ((org.eclipse.ocl.uml.Variable)oReferenceAtomReference).getRepresentedParameter();
			}
			if(oReferenceAtomReference instanceof org.eclipse.uml2.uml.Property) {
				// nothing
			}
			TCGTransition oTraversedTransition = in_oTransitionInstance.getTransition();
			List<Parameter> colMatchedEventParameters = new ArrayList<Parameter>();
			colMatchedEventParameters.add(oReferencedParameter);
			if(oTraversedTransition != null) { 
				colMatchedEventParameters.addAll( 
					TCGEventHelperClass.getEventParameters(oReferencedParameter, oTraversedTransition));
			}				
			if(colMatchedEventParameters.contains(in_oParameter.getReference()))
				return in_oParameter;
//				TCGEventHelperClass.getMapExprParamToEventParam().get(oReferencedParameter);
//			if((oMatchedEventParameter != null &&
//					in_oParameter.getReference().equals(oMatchedEventParameter)) ||
//					(oReferencedParameter != null &&
//					in_oParameter.getReference().equals(oReferencedParameter)))
//				return in_oParameter;
		}
		else if(in_oParameter instanceof TCGComplexParameter) {
			TCGComplexParameter oComplexParameter = (TCGComplexParameter)in_oParameter;
			for(TCGParameter oSubParameter : oComplexParameter.getParameter())
			{
				TCGParameter oFoundParameter = findParameterElementMatchingToReference(
						oSubParameter, in_oTransitionInstance, in_oReference);
				if(oFoundParameter != null)
					return oFoundParameter;
			}
		}
		else {
			if(in_oReference instanceof Parameter) {
				Parameter oReferencedParameter = (Parameter)in_oReference;
				TCGTransition oTraversedTransition = in_oTransitionInstance.getTransition(); 
				List<Parameter> colMatchedEventParameters = new ArrayList<Parameter>();
				colMatchedEventParameters.add(oReferencedParameter);
				if(oTraversedTransition != null) { 
					colMatchedEventParameters.addAll( 
						TCGEventHelperClass.getEventParameters(oReferencedParameter, oTraversedTransition));
				}				
				if(colMatchedEventParameters.contains(in_oParameter.getReference()))
					return in_oParameter;

//				TCGParameter oMatchedEventParameter = 
//					TCGEventHelperClass.getMapExprParamToEventParam().get(in_oReference);
//				if(in_oParameter.getReference().equals(oMatchedEventParameter))
//					return in_oParameter;
				
			} else if(in_oReference instanceof Property) {
				if(in_oParameter.getReference().equals(in_oReference)) {
					return in_oParameter;
				}
			}
		}

		return null;
	}
	
	/*
	 * finds the transition instance at which the current event is defined
	 */
	public static TransitionInstance findTransitionInstanceDefiningTheCurrentEvent(
			TransitionInstance in_oTransitionInstance)
	{
		TransitionInstance oRunningTransitionInstance = in_oTransitionInstance;
		if(oRunningTransitionInstance.getCalledEvent() != null)
			return oRunningTransitionInstance;
		// source node of the transition instance is no UML State
		while((oRunningTransitionInstance.getSourceNode().getOriginalNode() == null) &&
				(oRunningTransitionInstance.getPrecedingTransitionInstance() != null))
		{
			oRunningTransitionInstance = oRunningTransitionInstance.getPrecedingTransitionInstance();
			if(oRunningTransitionInstance.getCalledEvent() != null)
				return oRunningTransitionInstance;
		}
		return null;
		
//		TransitionInstance oRunningTransitionInstance = in_oTransitionInstance;
//		if(!oRunningTransitionInstance.getParameterInstances().isEmpty())
//			return oRunningTransitionInstance;
//		while(oRunningTransitionInstance.getTransition().getSourceNode().getOriginalNode() == null)
//		{
//			oRunningTransitionInstance = oRunningTransitionInstance.getPrecedingTransitionInstance();
//			if(!oRunningTransitionInstance.getParameterInstances().isEmpty())
//				return oRunningTransitionInstance;
//		}
//		return null;
	}
	
	public static boolean parameterIsReturnParameter(TCGParameter in_oParameter) {
		return in_oParameter.getName() == null ||
				in_oParameter.getName().isEmpty();
	}
	
	public static void removeReturnParameter(List<TCGParameter> in_colParameters) {
		for(TCGParameter oParam : in_colParameters) {
			if(TCGParameterHelperClass.parameterIsReturnParameter(oParam)) {
				in_colParameters.remove(oParam);
				break;
			}
		}
	}
	
	public static List<TCGParameter> copyAllButReturnValues(List<TCGParameter> in_colParameters) {
		List<TCGParameter> colRetValues = new ArrayList<TCGParameter>();
		for(TCGParameter oParam : in_colParameters) {
			if(!TCGParameterHelperClass.parameterIsReturnParameter(oParam)) {
				colRetValues.add(oParam);
			}
		}
		return colRetValues;
	}
}
