package net.sf.parteg.base.testcasetree.ocl.transformation;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;
import net.sf.parteg.base.testcasetree.ocl.TestCaseGraphHelper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.uml.IfExp;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.uml2.uml.Namespace;

public class TransformOCLToTCGOCL {

	public static TCGOCLExpression transformExpression(
			OCLExpression in_oExpression, 
			String in_sOCLTypeId,	
			Namespace in_oNamespace)
	{
		org.eclipse.uml2.uml.Class oContextClass = null;
		if(in_oNamespace instanceof org.eclipse.uml2.uml.Class)
			oContextClass = (org.eclipse.uml2.uml.Class)in_oNamespace;
		else if(in_oNamespace instanceof org.eclipse.uml2.uml.Operation)
			oContextClass = ((org.eclipse.uml2.uml.Operation)in_oNamespace).getClass_();
		
		TCGOCLExpression oTCGOCLExpression = null;
		if(in_oExpression != null)
		{
			VariableExp oVarExp = TestCaseGraphHelper.getVariableExp(in_oExpression);
			if(oVarExp != null)
			{
				TCGOCLAtom oAtom = GeneratedFactory.eINSTANCE.createTCGOCLAtom();
				//oAtom.setElement(oVarExp.getReferredVariable());
				oAtom.setElement(in_oExpression);
				oTCGOCLExpression = oAtom;
				oTCGOCLExpression.setClassification(classifyOCLExpression(oVarExp, in_sOCLTypeId));
			}
			else if(in_oExpression instanceof PropertyCallExp)
			{
				PropertyCallExp oPropExp = (PropertyCallExp)in_oExpression;
	
				TCGOCLAtom oAtom = GeneratedFactory.eINSTANCE.createTCGOCLAtom();
				// do not use the directly referenced property but the property closest to the given context
				oAtom.setElement((EObject)TestCaseGraphHelper.findMatchingPropertyInContext(
						oPropExp.getReferredProperty(), oContextClass));
				oTCGOCLExpression = oAtom;
				oTCGOCLExpression.setClassification(classifyOCLExpression(oPropExp, in_sOCLTypeId));
			}
			else if(in_oExpression instanceof OperationCallExp)
			{
				// TODO unäre Operationen einführen?
				OperationCallExp oOpExp = (OperationCallExp)in_oExpression;
			
				TCGOCLOperation oOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				OCLExpression oOCLLeftExpression = (OCLExpression)oOpExp.getSource();
				if(oOCLLeftExpression != null)
					oOperation.setLeft(
							transformExpression(oOCLLeftExpression, in_sOCLTypeId, oContextClass));
				if(oOpExp.getArgument().size() > 0)
					oOperation.setRight(
							transformExpression((OCLExpression)oOpExp.getArgument().get(0), in_sOCLTypeId, oContextClass));
				oOperation.setOperation((EObject)oOpExp.getReferredOperation());
				oOperation.setOperationName(oOpExp.getReferredOperation().getName());
				oTCGOCLExpression = oOperation;
			}
			else if(in_oExpression instanceof IfExp)
			{
				TCGOCLIfThenElse oTCGIfExp = GeneratedFactory.eINSTANCE.createTCGOCLIfThenElse();
				IfExp oIfExp = (IfExp)in_oExpression;
				oTCGIfExp.setCondition(transformExpression((OCLExpression)oIfExp.getCondition(), in_sOCLTypeId, oContextClass));
				oTCGIfExp.setThenExpression(transformExpression((OCLExpression)oIfExp.getThenExpression(), in_sOCLTypeId, oContextClass));
				oTCGIfExp.setElseExpression(transformExpression((OCLExpression)oIfExp.getElseExpression(), in_sOCLTypeId, oContextClass));
				oTCGOCLExpression = oTCGIfExp;
			}

			// Reference to original OCL expression
			oTCGOCLExpression.setOclReference(in_oExpression);
		}
		return oTCGOCLExpression;
	}
	
	
	private static VariableClassification classifyOCLExpression(VariableExp in_oVariableExp, String in_sOCLTypeId)
	{
		// activeDependent ... not here
		// passiveDependent ... not here
		// independent ... not here
		// inputParameter - every variable is an input parameter
		return VariableClassification.INPUT_PARAMETER;
	}

	private static VariableClassification classifyOCLExpression(PropertyCallExp in_oPropertyCallExp, String in_sOCLTypeId)
	{
		// activeDependent - in postcondition, not const and no @pre attached
		if((Configuration.getOCLPostId().compareTo(in_sOCLTypeId) == 0) &&
			!in_oPropertyCallExp.getReferredProperty().isReadOnly() &&
			!(in_oPropertyCallExp.isMarkedPre()))
			return VariableClassification.ACTIVE_DEPENDENT;
		
		// passiveDependent - not const and (not in postcondition or in postcondition with @pre)
		if((!in_oPropertyCallExp.getReferredProperty().isReadOnly()) &&
				(!(Configuration.getOCLPostId().compareTo(in_sOCLTypeId) == 0) ||
						in_oPropertyCallExp.isMarkedPre()))
				return VariableClassification.PASSIVE_DEPENDENT;

		// independent - condition type does not matter, value is const
		if(in_oPropertyCallExp.getReferredProperty().isReadOnly())
				return VariableClassification.INDEPENDENT;
		
		// inputParameter ... not here
		
		return VariableClassification.UNKNOWN;
	}
}
