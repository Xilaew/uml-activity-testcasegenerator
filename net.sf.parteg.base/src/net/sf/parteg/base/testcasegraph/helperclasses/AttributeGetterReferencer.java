package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.HashMap;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLParser;

import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * This class identifies functions as a getter for a certain
 * attribute if their name starts with "get" or "is"
 * The corresponding attribute is inside the postcondition 
 * of the function.
 * @author Stephan
 *
 */
public class AttributeGetterReferencer extends HashMap<Property, Operation> {

	private static final long serialVersionUID = -1098208178144281261L;

	public AttributeGetterReferencer()
	{
		super();
	}
	
	public void createAttributeGetterReferences(StateMachine in_oStateMachine) throws Exception
	{
		// get context class of the state machine
		org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClass(in_oStateMachine);
		
		// get all operations of the state machine
		for(Operation oOperation : oContextClass.getOperations()) {
		
			// check all postconditions for "result = xyz"
			if(!oOperation.getPostconditions().isEmpty() &&
					(oOperation.getName().startsWith("is") ||
					oOperation.getName().startsWith("get") ||
					oOperation.getName().startsWith("_get")) &&
					oOperation.getVisibility().equals(VisibilityKind.PUBLIC_LITERAL))
			{
				Constraint oPostConstraint = oOperation.getPostconditions().get(0);
				String sPostExpression = 
					SystemModelHelper.getConstraintSpecification(oPostConstraint);
				OCLExpression oExpression = OCLParser.parseCondition(
						sPostExpression, oOperation, Configuration.getOCLPostId());
				
				// resolve variables and build up map from variable to operation
				if(oExpression instanceof PropertyCallExp) {
					PropertyCallExp oPropCallExp = (PropertyCallExp)oExpression;
					put(oPropCallExp.getReferredProperty(), oOperation);
				}
			}
		}
	}
}
