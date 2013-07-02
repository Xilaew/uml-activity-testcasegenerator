package net.sf.parteg.base.testcasetree.helperclasses;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.ocl.DomainHelper;

import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Property;

public class TCGParameterHelperClass {

	private static ArrayList<TCGPrimitiveParameter> colPars;
	
	/**
	 * collects a list of all contained primitive parameters
	 * @param in_oParameter
	 * @return
	 */
	public static ArrayList<TCGPrimitiveParameter> collectContainedPrimitiveParameters(TCGParameter in_oParameter)
	{
		colPars = new ArrayList<TCGPrimitiveParameter>();
		collectContainedPrimitiveParametersHelper(in_oParameter);
		return colPars;
	}

	private static void collectContainedPrimitiveParametersHelper(TCGParameter in_oParameter)
	{
		if(in_oParameter instanceof TCGPrimitiveParameter)
			colPars.add((TCGPrimitiveParameter)in_oParameter);
		else if(in_oParameter instanceof TCGComplexParameter)
		{
			TCGComplexParameter oPar = (TCGComplexParameter)in_oParameter;
			for(TCGParameter oSubParam : oPar.getParameter())
			{
				collectContainedPrimitiveParametersHelper(oSubParam);
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
				// TODO entfernen?
//				oComplexTCGParameter.setType(in_oParameter.getType());
				// TODO bei rekursiven Strukturen sollten die Parameter erst "on demand" aufgebaut werden
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
		// TODO entfernen?
//		oPrimitiveTCGParameter.setType(in_oParameter.getType());
//		oPrimitiveTCGParameter.setEquivalenceClass(DomainHelper.createDefaultEquivalenceClass());
		return oPrimitiveTCGParameter;
	}

	public static void copyParameters(TCGNode in_oSource, TCGNode io_oTarget)
	{
		for(TCGParameter oOldParameter : in_oSource.getParameters())
		{
			TCGParameter oNewParameter = copyParameter(oOldParameter);
			io_oTarget.getParameters().add(oNewParameter);
		}
	}
	
	private static TCGParameter copyParameter(TCGParameter in_oParameter)
	{
		TCGParameter oNewParameter = null;
		if(in_oParameter instanceof TCGPrimitiveParameter)
		{
			oNewParameter = GeneratedFactory.eINSTANCE.createTCGPrimitiveParameter();
		}
		else if(in_oParameter instanceof TCGComplexParameter)
		{
			TCGComplexParameter oNewComplexParameter = GeneratedFactory.eINSTANCE.createTCGComplexParameter();
			for(TCGParameter oSubParam : ((TCGComplexParameter)in_oParameter).getParameter())
			{
				TCGParameter oNewSubParam = copyParameter(oSubParam);
				oNewComplexParameter.getParameter().add(oNewSubParam);
			}
			oNewParameter = oNewComplexParameter;
		}
		if(oNewParameter != null)
		{
			oNewParameter.setName(in_oParameter.getName());
			// TODO entfernen?
//			oNewParameter.setType(in_oParameter.getType());
			DomainHelper.copyEquivalenceClass(in_oParameter, oNewParameter);
			oNewParameter.setReference(in_oParameter.getReference());
			// TODO entfernen?
//			oNewParameter.setDefiningTransition(in_oParameter.getDefiningTransition());
		}
		return oNewParameter;
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
	
	/*
	 * returns the (part of the) parameter that is referencing the given element
	 */
	public static TCGParameter findParameterElementMatchingToReference(
			TCGParameter in_oParameter,
			Object in_oReference)
	{
		if(in_oParameter.getReference().equals(in_oReference))
			return in_oParameter;
		
		if(in_oParameter instanceof TCGComplexParameter)
		{
			TCGComplexParameter oComplexParameter = (TCGComplexParameter)in_oParameter;
			for(TCGParameter oSubParameter : oComplexParameter.getParameter())
			{
				TCGParameter oFoundParameter = findParameterElementMatchingToReference(
						oSubParameter, in_oReference);
				if(oFoundParameter != null)
					return oFoundParameter;
			}
		}
		return null;
	}
	
}
