package net.sf.parteg.base.testcasetree.ocl;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;

public class DomainHelper {

	public static void copyEquivalenceClass(TCGParameter in_oSource, TCGParameter in_oTarget)
	{
		if(in_oSource instanceof TCGPrimitiveParameter)
		{
			copyEquivalenceClass((TCGPrimitiveParameter)in_oSource, (TCGPrimitiveParameter)in_oTarget);
		} 
		else if(in_oSource instanceof TCGComplexParameter)
		{
			for(TCGParameter oSourceParameter : ((TCGComplexParameter)in_oSource).getParameter())
			{
				for(TCGParameter oTargetParameter : ((TCGComplexParameter)in_oTarget).getParameter())
				{
					//if(oSourceParameter.getReference().equals(oTargetParameter.getReference()))
					if(oSourceParameter.getReference().equals(oTargetParameter.getReference()))
					{
						copyEquivalenceClass(oSourceParameter, oTargetParameter);
					}
					break;
				}
			}
		}
		
	}
	
	private static void copyEquivalenceClass(TCGPrimitiveParameter in_oSource, TCGPrimitiveParameter in_oTarget)
	{
		TCGEquivalenceClass oSourceEquivalenceClass = in_oSource.getEquivalenceClass();
		if(oSourceEquivalenceClass != null)
		{
			TCGEquivalenceClass oTargetEquivalenceClass = GeneratedFactory.eINSTANCE.createTCGEquivalenceClass();
			oTargetEquivalenceClass.setMinBorder(oSourceEquivalenceClass.getMinBorder().doubleValue());
			oTargetEquivalenceClass.setMinIncluded(oSourceEquivalenceClass.getMinIncluded());
			oTargetEquivalenceClass.setMaxBorder(oSourceEquivalenceClass.getMaxBorder().doubleValue());
			oTargetEquivalenceClass.setMaxIncluded(oSourceEquivalenceClass.getMaxIncluded());
			in_oTarget.setEquivalenceClass(oTargetEquivalenceClass);
		}
	}

	/**
	 * adapts all parameter domains to the precondition of the transition leading to the given node 
	 * @param io_oTCGNode is the actual node of the test case graph 
	 * @param in_oPrecondition is the given precondition
	 */
	public static void adaptDomains(TCGNode io_oTCGNode, TCGOCLExpression in_oPrecondition)
	{
		try {
			if(in_oPrecondition instanceof TCGOCLOperation)
			{
				adaptDomains(io_oTCGNode, (TCGOCLOperation)in_oPrecondition);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void adaptDomain(TCGEquivalenceClass io_oBaseEquivalenceClass, 
			Double in_dValue, String in_sOperation, boolean in_bValueOnLeftSide)
	{
		if(in_sOperation.compareTo("<") == 0)
		{
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, !in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, false, !in_bValueOnLeftSide);
		}
		else if(in_sOperation.compareTo("<=") == 0)
		{
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, !in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, true, !in_bValueOnLeftSide);
		}
		else if(in_sOperation.compareTo("=") == 0)
		{
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, !in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, true, !in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, true, in_bValueOnLeftSide);
		}
		else if(in_sOperation.compareTo(">") == 0)
		{
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, false, in_bValueOnLeftSide);
		}
		else if(in_sOperation.compareTo(">=") == 0)
		{
			DomainHelper.setEquivalenceClassBorder(io_oBaseEquivalenceClass, in_dValue, in_bValueOnLeftSide);
			DomainHelper.setEquivalenceClassIncluded(io_oBaseEquivalenceClass, true, in_bValueOnLeftSide);
		}	
	}
	
	public static boolean adaptDomain(TCGParameter io_oParameter,
			TCGEquivalenceClass in_oRestrictingEquivalenceClass)
	{
		if(io_oParameter instanceof TCGPrimitiveParameter)
		{
			return adaptDomain(((TCGPrimitiveParameter)io_oParameter).getEquivalenceClass(), 
					in_oRestrictingEquivalenceClass);
		}
		return false;
	}
	
	public static boolean adaptDomain(TCGEquivalenceClass io_oBaseEquivalenceClass, 
			TCGEquivalenceClass in_oRestrictingEquivalenceClass)
	{
		// change only if new value is more restricting
		if(io_oBaseEquivalenceClass.getMinBorder().compareTo(in_oRestrictingEquivalenceClass.getMinBorder()) < 0)
		{
			io_oBaseEquivalenceClass.setMinBorder(in_oRestrictingEquivalenceClass.getMinBorder().doubleValue());
			io_oBaseEquivalenceClass.setMinIncluded(in_oRestrictingEquivalenceClass.getMinIncluded());
		}
		else if(io_oBaseEquivalenceClass.getMinBorder().compareTo(in_oRestrictingEquivalenceClass.getMinBorder()) == 0)
		{
			io_oBaseEquivalenceClass.setMinIncluded(io_oBaseEquivalenceClass.getMinIncluded() && in_oRestrictingEquivalenceClass.getMinIncluded());
		}
		
		if(io_oBaseEquivalenceClass.getMaxBorder().compareTo(in_oRestrictingEquivalenceClass.getMaxBorder().doubleValue()) > 0)
		{
			io_oBaseEquivalenceClass.setMaxBorder(in_oRestrictingEquivalenceClass.getMaxBorder().doubleValue());
			io_oBaseEquivalenceClass.setMaxIncluded(in_oRestrictingEquivalenceClass.getMaxIncluded());
		}
		else if(io_oBaseEquivalenceClass.getMaxBorder().compareTo(in_oRestrictingEquivalenceClass.getMaxBorder().doubleValue()) == 0)
		{
			io_oBaseEquivalenceClass.setMaxIncluded(io_oBaseEquivalenceClass.getMaxIncluded() && in_oRestrictingEquivalenceClass.getMaxIncluded());
		}
		return domainIsPossible(io_oBaseEquivalenceClass);
	}

	public static void setEquivalenceClassBorder(TCGEquivalenceClass io_oBaseEquivalenceClass, Double in_dValue, boolean in_bValueIsMax)
	{
		if(in_bValueIsMax)
			io_oBaseEquivalenceClass.setMaxBorder(in_dValue);
		else
			io_oBaseEquivalenceClass.setMinBorder(in_dValue);
	}

	static void setEquivalenceClassIncluded(TCGEquivalenceClass io_oBaseEquivalenceClass, boolean in_bIncluded, boolean in_bValueIsMax)
	{
		if(in_bValueIsMax)
			io_oBaseEquivalenceClass.setMaxIncluded(in_bIncluded);
		else
			io_oBaseEquivalenceClass.setMinIncluded(in_bIncluded);
	}

	public static TCGTransition getPrecedingTransition(TCGTransition in_oTransition)
	{
		TCGNode oNode = in_oTransition.getSourceNode();
		if(oNode.getIncomingTransitions().isEmpty())
			return null;
		else
			return oNode.getIncomingTransitions().get(0);
	}

	static String negateOCLRelationString(String in_sRelation)
	{
		if(in_sRelation.compareTo("<") == 0)
			return ">=";
		if(in_sRelation.compareTo("<=") == 0)
			return ">";
		if(in_sRelation.compareTo("=") == 0)
			return "<>";
		if(in_sRelation.compareTo(">=") == 0)
			return "<";
		if(in_sRelation.compareTo(">") == 0)
			return "<=";
		if(in_sRelation.compareTo("<>") == 0)
			return "=";
		if(in_sRelation.compareTo("and") == 0)
			return "or";
		if(in_sRelation.compareTo("or") == 0)
			return "and";
		return "?no negation available?";
	}

	/**
	 * create default equivalence class
	 * @return default equivalence class
	 */
	public static TCGEquivalenceClass createDefaultEquivalenceClass()
	{
		TCGEquivalenceClass oEqClass = GeneratedFactory.eINSTANCE.createTCGEquivalenceClass();
		oEqClass.setMinBorder(Configuration.getLowerDomainBoundary());
		oEqClass.setMinIncluded(true);
		oEqClass.setMaxBorder(Configuration.getUpperDomainBoundary());
		oEqClass.setMaxIncluded(true);
		
		return oEqClass;
	}

	/**
	 * @return domain can be realized with concrete test inputs?
	 */
	public static boolean domainIsPossible(TCGEquivalenceClass in_oEqClass)
	{
		if(in_oEqClass.getMaxBorder().compareTo(in_oEqClass.getMinBorder()) < 0)
			return false;
		if((in_oEqClass.getMaxBorder().compareTo(in_oEqClass.getMinBorder()) == 0) && 
			((in_oEqClass.getMaxIncluded() == false) || (in_oEqClass.getMinIncluded() == false)))
			return false;
		if((in_oEqClass.getMaxBorder().compareTo(in_oEqClass.getMinBorder() + Configuration.getDomainBorderDistance()) == 0) &&
			((in_oEqClass.getMaxIncluded() == false) && (in_oEqClass.getMinIncluded() == false)))
			return false;
		return true;
	}
}
