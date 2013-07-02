package net.sf.parteg.output.testgraph.languages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.TemporalConfiguration;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.AttributeGetterReferencer;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGEventHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.core.output.FormattedOutput;
import net.sf.parteg.core.output.FormattedOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.uml.BooleanLiteralExp;
import org.eclipse.ocl.uml.EnumLiteralExp;
import org.eclipse.ocl.uml.IfExp;
import org.eclipse.ocl.uml.IntegerLiteralExp;
import org.eclipse.ocl.uml.LiteralExp;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.Variable;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TypedElement;

public abstract class TestCaseGraphOutputOO implements TestCaseGraphOutputConfigurator{

	protected FormattedOutputStream m_oFormattedOutput; 
	protected OCLExpressionConverter m_oConverter;
	protected String m_sObjectName;
	protected String m_sEventCallName;
	protected int m_nTestMethodCounter;
	private TestCaseGraphHelper m_oTCGHelper;
	private PrintStream m_oPrintStream;
	
	public TestCaseGraphOutputOO(TestCaseGraphHelper in_oTCGHelper)
	{
		m_sObjectName = "oTestObject";
		m_sEventCallName = Configuration.getHandleEventFunctionName();
		m_nTestMethodCounter = 0;
		m_oFormattedOutput = new FormattedOutputStream();
		m_oConverter = null;
		m_oTCGHelper = in_oTCGHelper;
	}

	public void startPrintStreams() {
		// initializes output file
		try {
			m_oPrintStream = new PrintStream(
					new FileOutputStream(
							TemporalConfiguration.getClassNameAdaptation(
									Configuration.getTestCaseOutput()) 
							+ getFileType()));
		
			for(FormattedOutputStream oFormattedOutput : getFormattedOutputStreams()) {
				oFormattedOutput.setPrintStream(m_oPrintStream);
			}
		} catch (FileNotFoundException e) {
			Configuration.handleException(e);
		}		
	}
	
	
	public void endPrintStreams() {
		// write to file
		m_oPrintStream.print(getString());
		clearString();
		// close file
		m_oPrintStream.close();	
	}
	
	public List<FormattedOutputStream> getFormattedOutputStreams() {
		List<FormattedOutputStream> colOutputs = new ArrayList<FormattedOutputStream>();
		colOutputs.add(m_oFormattedOutput);
		return colOutputs;
	}
	
	protected static String getClassName(EObject in_oEObject)
	{
		// class, enumeration, primitive type, ...
		if(in_oEObject instanceof org.eclipse.uml2.uml.Classifier) {
			org.eclipse.uml2.uml.Classifier oObject = (org.eclipse.uml2.uml.Classifier)in_oEObject;
			return oObject.getName();
		}
		else
		{
			return "<Unknown Type>";
		}
	}
	
	/**
	 * handles the evaluation of a ocl expression
	 * @param in_oTransition
	 * @param in_oExpression
	 */
	protected void handleOCLExpression(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oExpression,
			FormattedOutput in_oFormattedOutput)
	{
		if(in_oExpression instanceof TCGOCLAtom)
		{
			handleOCLAtomExpression(in_oTransitionInstance, 
					(TCGOCLAtom)in_oExpression,
					in_oFormattedOutput);
		}
		else if(in_oExpression instanceof TCGOCLOperation)
		{
			handleOCLOperationCallExpression(in_oTransitionInstance, 
					(TCGOCLOperation)in_oExpression,
					in_oFormattedOutput);
		}
	}

	protected void handleOCLOperationCallExpression(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLOperation in_oOperationExp,
			FormattedOutput in_oFormattedOutput)
	{
		in_oFormattedOutput.append("(");
		if(in_oOperationExp.getLeft() == null)
		{
			in_oFormattedOutput.append(" " + m_oConverter.convert(in_oOperationExp.getOperationName()) + " ");
			handleOCLExpression(in_oTransitionInstance, 
					in_oOperationExp.getRight(), in_oFormattedOutput);
		}
		else if(in_oOperationExp.getRight() == null)
		{
			in_oFormattedOutput.append(" " + m_oConverter.convert(in_oOperationExp.getOperationName()) + " ");
			handleOCLExpression(in_oTransitionInstance, 
					in_oOperationExp.getLeft(), in_oFormattedOutput);
		}
		else
		{
			handleOCLExpression(in_oTransitionInstance, 
					in_oOperationExp.getLeft(), in_oFormattedOutput);
			in_oFormattedOutput.append(" " + m_oConverter.convert(in_oOperationExp.getOperationName()) + " ");
			handleOCLExpression(in_oTransitionInstance, 
					in_oOperationExp.getRight(), in_oFormattedOutput);
		}
		in_oFormattedOutput.append(")");
	}
	
	
	/**
	 * handles the incoming property expression: just set the right context and print
	 * @param in_oPropertyCallExp
	 */
	protected void handleOCLAtomExpression(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLAtom in_oAtomExp,
			FormattedOutput in_oFormattedOutput)
	{
		// references from system attributes to the corresponding getter operations
		AttributeGetterReferencer oAttrOpRef = m_oTCGHelper.getAttributeGetterReferencer();
		
		if(in_oAtomExp.getOclReference() instanceof PropertyCallExp)
		{
			Property oPropReference = (Property)(((PropertyCallExp)in_oAtomExp.getOclReference()).getReferredProperty());
			VariableExp oVarExp = TestCaseGraphHelper.getVariable(in_oAtomExp.getOclReference());
			if(oVarExp != null)
			{
				boolean bFoundMatchingParameterInstance = false;
				for(EventParameterInstance oParameterInstance : TCGParameterHelperClass.
						findTransitionInstanceDefiningTheCurrentEvent(in_oTransitionInstance).getParameterInstances())
				{
					if(oParameterInstance.getParameter().getReference().equals(oPropReference))
					{
						in_oFormattedOutput.append(
								TCGParameterHelperClass.
								getFullParameterInstanceAttributeName(oParameterInstance));
						if(oParameterInstance.getParameter().getValueType() instanceof TypedElement) {
							TypedElement oVT = (TypedElement)oParameterInstance.getParameter().getValueType();
							in_oFormattedOutput.append(getTypeNameAccessFunction(oVT.getType().getName()));
						}
						bFoundMatchingParameterInstance = true;
					}
				}
				// found no actually used parameter instance for the property reference
				// -> search for parameter
				if(bFoundMatchingParameterInstance == false)
				{
					String sPropName = TestCaseGraphHelper.getFullPropertyName(oPropReference, oVarExp.getType());
					in_oFormattedOutput.append(oVarExp.getName() 
							+ TCGParameterHelperClass.findTransitionInstanceDefiningTheCurrentEvent(
									in_oTransitionInstance).getName() + "."
							+ sPropName);
					in_oFormattedOutput.append(getTypeNameAccessFunction(oVarExp.getType().getName()));
				}
			}
			else
			{
				// TODO unvollständige Ausgabebehandlung -> inwiefern?
				// get getter operation
				String sPropName = oPropReference.getName();
				Operation oOp = oAttrOpRef.get(oPropReference);
				if(oOp != null) {
					sPropName = oOp.getName() + "()";
				}
				in_oFormattedOutput.append(m_sObjectName + "." + sPropName);
				in_oFormattedOutput.append(getTypeNameAccessFunction(oPropReference.getType().getName()));
			}
		}		
		else if(in_oAtomExp.getOclReference() instanceof VariableExp)
		{
			for(EventParameterInstance oParameterInstance : TCGParameterHelperClass.
					findTransitionInstanceDefiningTheCurrentEvent(in_oTransitionInstance).getParameterInstances())
			{
				Variable oVar = (Variable)in_oAtomExp.getElement();
				// get matched event parameter
//				EObject oMatchedEventParameter = 
//					TCGEventHelperClass.getMapExprParamToEventParam().get(oVar.getRepresentedParameter());
//				if(oMatchedEventParameter == null)
//					oMatchedEventParameter = oVar.getRepresentedParameter();
//				if(oParameterInstance.getParameter().getReference().equals(oMatchedEventParameter)) {
				TCGTransition oTraversedTransition = in_oTransitionInstance.getTransition();
				List<Parameter> colMatchedEventParameters = new ArrayList<Parameter>();
				colMatchedEventParameters.add(oVar.getRepresentedParameter());
				if(oTraversedTransition != null) { 
					colMatchedEventParameters.addAll( 
						TCGEventHelperClass.getEventParameters(
								oVar.getRepresentedParameter(), oTraversedTransition));
				}
					
				if(colMatchedEventParameters.contains(oParameterInstance.getParameter().getReference())) {
					in_oFormattedOutput.append(
							TCGParameterHelperClass.
							getFullParameterInstanceAttributeName(oParameterInstance));
					if(oParameterInstance.getParameter().getValueType() instanceof NamedElement) {
						NamedElement oVTN = (NamedElement)oParameterInstance.getParameter().getValueType();
						in_oFormattedOutput.append(getTypeNameAccessFunction(oVTN.getName()));
					}
				}
			}
		}
		else if(in_oAtomExp.getOclReference() instanceof LiteralExp) {
			in_oFormattedOutput.append(getValueString((LiteralExp)in_oAtomExp.getOclReference()));
		}
		else {
			System.err.println("something is missing");
		}
	}
	
	public String getString() {
		return m_oFormattedOutput.toString();
	}	
	
	public void clearString() {
		m_oFormattedOutput.clear();
	}
	
	protected void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance,
			String in_sConditionPrefix,
			String in_sConditionPostfix,
			FormattedOutput in_oFormattedOutput)
	{
		// handle state invariants of the target state
		if(in_oTransitionInstance.getUseNextStateInvariant()) {
			List<TCGRealNode> colNodes = new ArrayList<TCGRealNode>();
			if(in_oTransitionInstance.getTargetNode() instanceof TCGRealNode) {
				colNodes.add((TCGRealNode)in_oTransitionInstance.getTargetNode());
				colNodes.addAll(TCGNodeHelperClass.getSuperStates(in_oTransitionInstance.getTargetNode()));
				
				for(TCGRealNode oTargetNode : colNodes) {
					TCGDisjunctiveNormalForm oDNF = ((TCGRealNode)oTargetNode).getCondition();
					if((oDNF != null) && (oDNF.getConjunctions().size() > 0))
					{
						boolean bMoreThanOneConjunction = (oDNF.getConjunctions().size() > 1); 
						in_oFormattedOutput.append(in_sConditionPrefix); 
						
						for(int nConjunctionCounter = 0; 
							nConjunctionCounter < oDNF.getConjunctions().size(); 
							++nConjunctionCounter)
						{
							TCGConjunction oConjunction = oDNF.getConjunctions().get(nConjunctionCounter);
							if(nConjunctionCounter != 0)
								in_oFormattedOutput.append(" || ");
							if(bMoreThanOneConjunction == true)
								in_oFormattedOutput.append("(");
							
							for(int nExpressionCounter = 0; 
								nExpressionCounter < oConjunction.getExpressions().size();
								++nExpressionCounter)
							{
								TCGOCLExpression oExpression = oConjunction.getExpressions().get(nExpressionCounter);
								if(nExpressionCounter != 0)
									in_oFormattedOutput.append(" && ");
								if(oExpression != null)
								{
									try {
										// handle the given expression
										handleOCLExpression(in_oTransitionInstance, 
												oExpression, in_oFormattedOutput);
									}
									catch(Exception e) {
										Configuration.handleException(e);
									}
								}
							}
							if(bMoreThanOneConjunction == true)
								in_oFormattedOutput.append(")");
						}
						in_oFormattedOutput.appendln(in_sConditionPostfix);
					}
				}
			}
		}
	}
	
	protected void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition,
			String in_sConditionPrefix,
			String in_sConditionPostfix,
			FormattedOutput in_oFormattedOutput)
	{
		if(in_oCondition != null)
		{
			try {
				OCLExpression oExp = (OCLExpression)in_oCondition.getOclReference(); 
				if(!(oExp instanceof IfExp))
				{
					in_oFormattedOutput.append(in_sConditionPrefix);
					
					// handle the given expression
					handleOCLExpression(in_oTransitionInstance, 
							in_oCondition, in_oFormattedOutput);
									
					in_oFormattedOutput.appendln(in_sConditionPostfix);
				}
			}
			catch(Exception e) {
				Configuration.handleException(e);
			}
		}
	}
	
	@Override
	public String getValueString(LiteralExp in_oLiteralExp)
	{
		if(in_oLiteralExp instanceof EnumLiteralExp){
			EnumLiteralExp oExp = (EnumLiteralExp)in_oLiteralExp;
			return TestCaseGraphHelper.getFullEnumerationLiteralName(oExp.getReferredEnumLiteral());
		}
		else if(in_oLiteralExp instanceof IntegerLiteralExp) {
			IntegerLiteralExp oExp = (IntegerLiteralExp)in_oLiteralExp;
			return oExp.getIntegerSymbol().toString();			
		}
		else if(in_oLiteralExp instanceof BooleanLiteralExp) {
			BooleanLiteralExp oExp = (BooleanLiteralExp)in_oLiteralExp;
			return oExp.getBooleanSymbol().toString();			
		}
		return "";
	}

	protected boolean isEventPrintingAllowed(TCGEvent in_oEvent)
	{
		return (!in_oEvent.isDefaultEvent() || (Configuration.getPrintDefaultEvents() == true));
	}	
	
	protected abstract void getOutputForDNFInTargetNodeOfTransitionInstance(
			TransitionInstance in_oTransitionInstance);
	
	
	protected abstract void getOutputForConditionInTransitionInstance(
			TransitionInstance in_oTransitionInstance, 
			TCGOCLExpression in_oCondition);
	
	protected abstract String getTypeNameAccessFunction(
			String in_oTypeString);
}
