package net.sf.parteg.base.testcasetree.ocl.parser;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.uml2.uml.Namespace;

public class OCLParser {

	/**
	 * just parse the string in the given context
	 */
	public static OCLExpression parseCondition(
			String in_sExpression,
			Namespace in_oContext,
			String in_sExpressionType) throws Exception
	{
		// empty expression -> return null pointer
		if(in_sExpression.length() == 0)
			return null;
		
		try{
			OCLExpression oExpression = null;
			OCL oOcl = org.eclipse.ocl.uml.OCL.newInstance(
					new UMLEnvironmentFactory(
							new ResourceSetImpl())); 
			OCL.Helper helper = oOcl.createOCLHelper();
			//if(in_sExpressionType.compareTo(Configuration.getOCLInvId()) == 0) 
			if(in_oContext instanceof org.eclipse.uml2.uml.Class)
			{
				org.eclipse.uml2.uml.Class oClass = (org.eclipse.uml2.uml.Class)in_oContext;
				helper.setContext(oClass);
				helper.setValidating(false);
				oExpression = helper.createQuery(in_sExpression);
			}
			else
			{
				org.eclipse.uml2.uml.Operation oOperation = (org.eclipse.uml2.uml.Operation)in_oContext;
				org.eclipse.uml2.uml.Class oClass = oOperation.getClass_();
				
				//oOperation = TestCaseGraphHelper.getContextEffectSpecificationHelper(oOperation, oClass);
				
				helper.setOperationContext(oClass, oOperation);
				helper.setValidating(false);
				oExpression = helper.createQuery(in_sExpression);
			}
			if(oExpression == null)
			{
				throw new Exception("constraint could not be assigned correctly");
			}
			
			return oExpression;
		}
		catch(Exception e)
		{
			throw new Exception("condition " + in_sExpression 
					+ " was not parsed correctly" 
					+ System.getProperty("line.separator") + 
					"reason: " + e.getMessage());
		}		
	}
}
