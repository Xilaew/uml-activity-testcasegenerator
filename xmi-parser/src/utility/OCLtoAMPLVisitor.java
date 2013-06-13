/**
 * 
 */
package utility;

import java.util.Collections;
import java.util.List;

import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @author TH51E0
 * 
 */
public class OCLtoAMPLVisitor<C, EL, PM, S, COA, SSA>
		extends
		AbstractVisitor<String, C, Operation, Property, EL, PM, S, COA, SSA, Constraint> {
	int variableIndex;

	public int getVariableIndex() {
		return variableIndex;
	}

	public void setVariableIndex(int variableIndex) {
		this.variableIndex = variableIndex;
	}

	@Override
	protected String handleOperationCallExp(
			OperationCallExp<C, Operation> callExp, String sourceResult,
			List<String> argumentResults) {
		System.out.println("handleOperationCallExp");
		System.out.println(callExp.toString());
		System.out.println(callExp.getReferredOperation().getQualifiedName());
		return sourceResult + callExp.getReferredOperation().getName()
				+ argumentResults.get(0);
	}

    /**
     * Simply returns {@link #result}.
     */
	public String visitVariableExp(VariableExp<C, PM> v) {
		return v.getReferredVariable().getName();
	}
	
	@Override
	protected String handlePropertyCallExp(
			PropertyCallExp<C, Property> callExp, String sourceResult,
			List<String> qualifierResults) {
		System.out.println("handlePropertyCallExp");
		int localVarIndex = callExp.isMarkedPre()? (variableIndex-1) : variableIndex;
		System.out.println(callExp.isMarkedPre());
		return "self_" + callExp.getReferredProperty().getName() + "[" + localVarIndex
				+ "]";
	}

    /**
     * Visits the specified constraint with the results of visiting
     * its specification.
     * 
     * @param constraint the constraint
     * @param specificationResult the result of visiting the constraint's
     *     specification, or <code>null</code> if either it has none or the
     *     {@link #getSpecification(Object)} method is not overridden
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * #see {@link #getSpecification(Object)}
     * @see #visitConstraint(Object)
     */
	//XXX visitConstraint returns always null
    protected String handleConstraint(Constraint constraint, String specificationResult) {
    	System.out.println("handleConstraint");
        return specificationResult;
    }
    
	@Override
	protected String handleExpressionInOCL(ExpressionInOCL<C, PM> expression,
			String contextResult, String resultResult,
			List<String> parameterResults, String bodyResult) {
		System.out.println("handleExpressionInOCL");
		return bodyResult;
	}

	// /**
	// * Simply returns {@link #result}.
	// */
	// public String visitVariableExp(VariableExp<C, PM> v) {
	// return v.getName()+v.getReferredVariable().getName();
	// }

	@Override
	public String visitIntegerLiteralExp(IntegerLiteralExp<C> literalExp) {
		return literalExp.getIntegerSymbol().toString();
	}

	@Override
	public String visitBooleanLiteralExp(BooleanLiteralExp<C> literalExp) {
		return literalExp.getBooleanSymbol() ? "1" : "0";
	}
	
    /**
     * Overridden by subclasses interested in visiting constraints, to get the
     * constraint's specification.
     * 
     * @param constraint a constraint
     * @return its specification
     * 
     * @see #visitConstraint(Object)
     */
	@SuppressWarnings("unchecked")
	protected ExpressionInOCL<C, PM> getSpecification(Constraint constraint) {
		ValueSpecification spec = constraint.getSpecification();
		System.out.println(spec);
		if (spec instanceof ExpressionInOCL<?, ?>){
			return ((ExpressionInOCL<C, PM>) spec);
		}
		return null ;
	}

}
