package net.sf.parteg.base.testcasetree.ocl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.parteg.base.testcasegraph.testgoals.TestGoalManager;
import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.ConversionController;
import net.sf.parteg.base.testcasetree.SystemModelStateHistory;
import net.sf.parteg.base.testcasetree.actions.TestCaseGraphAddNodeAction;
import net.sf.parteg.base.testcasetree.constraints.TestCaseGraphDepthConstraint;
import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGConjunction;
import net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasetree.generated.TCGEvent;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;
import net.sf.parteg.base.testcasetree.generated.TestCaseGraph;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;
import net.sf.parteg.base.testcasetree.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasetree.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasetree.ocl.parser.TCGOCLVariableClassificator;
import net.sf.parteg.base.testcasetree.ocl.transformation.TransformOCLToTCGOCL;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;

public class TestCaseGraphHelper {

	private TestCaseGraph m_oTCG;

	private ResourceSet m_oResourceSet;
	private Resource m_oResourceEcoreOut;
	private Resource m_oResourceXMIOut;
	private HashMap<String, Boolean> m_oOptions;
	private int m_nActualStateMachineDepth;
	private SystemModelStateHistory m_oHistory;

	private TestGoalManager m_oTestGoalMgr;

	public TestCaseGraphHelper()
	{
		m_oTestGoalMgr = new TestGoalManager();
		
		m_oResourceSet = new ResourceSetImpl();
		m_oResourceEcoreOut= m_oResourceSet.createResource(
				URI.createFileURI(
						Configuration.getEcoreOutput()));
		m_oResourceXMIOut= m_oResourceSet.createResource(
				URI.createFileURI(
						Configuration.getXMIOutput()));
		m_oOptions = new HashMap<String, Boolean>();
		m_oOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		m_oOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		// create TestCaseGraphTree
		m_oTCG = GeneratedFactory.eINSTANCE.createTestCaseGraph();
		// insert initial root node
		TCGNode oRootNode = GeneratedFactory.eINSTANCE.createTCGNode();
		oRootNode.setDistanceToRoot(0);
		m_oTCG.getNodes().add(oRootNode);
		m_oTCG.setRoot(oRootNode);

		m_nActualStateMachineDepth = 0;
		m_oHistory = new SystemModelStateHistory();
	}
	
	public SystemModelStateHistory getHistory()
	{
		return m_oHistory;
	}
	
	/**
	 * finds corresponding parameters in a node
	 * @param in_oParameter a known parameter referenced by another node
	 * @param in_oNode the node in which we are looking for a corresponding parameter
	 */
	public TCGParameter getCorrespondingParameterCopyInNode(TCGParameter in_oParameter, TCGNode in_oNode)
	{
		for(TCGParameter oParam : in_oNode.getParameters())
		{
			//if(oParam.getReference().equals(in_oParameter.getReference()))
			TCGParameter oMatchingParam = TCGParameterHelperClass.findParameterElementMatchingToReference(
					oParam, in_oParameter.getReference());
			if (oMatchingParam != null) 
			{
				// properties von Parametern haben keine Namen ... warum eigentlich nicht?
				//if(oMatchingParam.getName().compareTo(in_oParameter.getName()) == 0)
				//{
				return oMatchingParam;
				//}
			}
		}
		return null;
	}
	
	public TestCaseGraph getTestCaseGraph()
	{
		return m_oTCG;
	}
	
	public TCGNode getRoot()
	{
		return m_oTCG.getRoot();
	}
	
	public TCGNode addNode()
	{
		TCGNode oNode = GeneratedFactory.eINSTANCE.createTCGNode();
		m_oTCG.getNodes().add(oNode);
		return oNode;
	}
	
	public TCGTransition addTransition(TCGNode in_oSourceNode,
			TCGNode in_oTargetNode)
	{
		TCGTransition oTransition = GeneratedFactory.eINSTANCE.createTCGTransition();
		m_oTCG.getTransitions().add(oTransition);
		
		oTransition.setSourceNode(in_oSourceNode);
		in_oSourceNode.getOutgoingTransitions().add(oTransition);

		oTransition.setTargetNode(in_oTargetNode);
		in_oTargetNode.getIncomingTransitions().add(oTransition);
		
		return oTransition;
	}

	/**
	 * creates a TCGEvent for an event of a state machine
	 * @param in_oSMEvent
	 * @return
	 */
	public static TCGEvent createTCGEvent(Event in_oSMEvent, boolean in_bCreateTCGEventIfEventIsNull)
	{
		TCGEvent oTCGEvent = GeneratedFactory.eINSTANCE.createTCGEvent();
		if(in_oSMEvent != null){
			oTCGEvent.setName(in_oSMEvent.getName());
			oTCGEvent.setEvent(in_oSMEvent);
			oTCGEvent.setDefaultEvent(false);
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
	
	
	/**
	 * adds the event to the transition and creates TCGParameter
	 * @param in_oExpression
	 * @param io_oTransition
	 * @param in_oSMEvent
	 * @return
	 */
	public void addEvent(
			TCGOCLExpression in_oExpression, 
			TCGTransition io_oTransition, 
			TCGEvent io_oTCGEvent,
			org.eclipse.uml2.uml.Class in_oContextClass)
	{
		if(!io_oTCGEvent.isDefaultEvent())
		{
			Event oSMEvent = (Event)io_oTCGEvent.getEvent();
			// identify all parameters of the event
			if(oSMEvent instanceof CallEvent)
			{
				CallEvent oCallEvent = (CallEvent)oSMEvent;
				Operation oOperation = TestCaseGraphHelper.getContextEffectSpecificationHelper(oCallEvent.getOperation(), 
						in_oContextClass);
				// default-trigger has no operation
				if(oOperation != null)
				{
					for(Parameter oParameter : oOperation.getOwnedParameters())
					{
						TCGParameter oTCGParameter = addTCGParameter(io_oTransition, oParameter);
						io_oTCGEvent.getParameters().add(oTCGParameter);
					}
				}
			}
		}
		referToEvent(io_oTCGEvent, in_oExpression);
		io_oTransition.setEvent(io_oTCGEvent);
	}
	
	/**
	 * just refers elements of the expression to existing TCGParameters
	 * @param in_oTCGEvent
	 * @param in_oExpression
	 */
	private void referToEvent(TCGEvent in_oTCGEvent, TCGOCLExpression in_oExpression)
	{
		if(in_oExpression != null)
		{
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(in_oExpression);
			TCGOCLExpression oExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.INPUT_PARAMETER);
			TCGOCLAtom oAtom = (TCGOCLAtom)oExpression;
			if(oAtom != null)
			{
				for(TCGParameter oParameter : in_oTCGEvent.getParameters())
				{
					// reference of parameter needs to be equal to
					// the represented parameter of the variable of the ocl reference of the atom
					VariableExp oVarExp = TestCaseGraphHelper.getVariableExp((OCLExpression)oAtom.getOclReference());
					if(oParameter.getReference().equals(oVarExp.getReferredVariable().getRepresentedParameter()))
					{
						if(oAtom.getOclReference() instanceof PropertyCallExp)
						{
							// find sub-parameter corresponding to the referenced property
							TCGParameter oParam = TCGParameterHelperClass.findParameterElementMatchingToReference(
									oParameter, ((PropertyCallExp)oAtom.getOclReference()).getReferredProperty());
							if(oParam != null)
								oAtom.setTcgParameter(oParam);
							else
								oAtom.setTcgParameter(oParameter);
						}
						else
							oAtom.setTcgParameter(oParameter);
					}
				}
			}
		}
	}

	
	private static TCGParameter addTCGParameter(TCGTransition in_oTransition, Parameter in_oParameter)
	{
		// TODO TCGPrimitiveParamter erzeugen!
		TCGParameter oTCGParameter = TCGParameterHelperClass.createTCGParameter(in_oParameter);
		// name of the externally used parameter (needs to be unique)
		oTCGParameter.setName(in_oParameter.getName() + "_" + in_oTransition.getTargetNode().getParameters().size());

		oTCGParameter.setDefiningTransition(in_oTransition);
		in_oTransition.getTargetNode().getParameters().add(oTCGParameter);
		
		return oTCGParameter;
	}
	
	
	
	public void removeNode(TCGNode in_oNode)
	{
		if(m_oTCG.getNodes().contains(in_oNode))
		{
			m_oTCG.getNodes().remove(in_oNode);
			// remove dependent elements
			for(TCGTransition oTransition : in_oNode.getIncomingTransitions())
			{
				oTransition.setTargetNode(null);
				removeTransition(oTransition);				
			}
			in_oNode.getIncomingTransitions().clear();
			
			for(TCGTransition oTransition : in_oNode.getOutgoingTransitions())
			{
				oTransition.setSourceNode(null);
				removeTransition(oTransition);
			}
			in_oNode.getOutgoingTransitions().clear();
		}
	}
	
	public void removeTransition(TCGTransition in_oTransition)
	{
		TCGNode oNode = in_oTransition.getTargetNode();
		if(oNode != null)
		{
			removeNode(oNode);
		}
		
		oNode = in_oTransition.getSourceNode();
		if(oNode != null)
		{
			oNode.getOutgoingTransitions().remove(in_oTransition);
			in_oTransition.setSourceNode(null);
		}

		if(m_oTCG.getTransitions().contains(in_oTransition))
			m_oTCG.getTransitions().remove(in_oTransition);
	}
	
	
	public void saveTreeToFiles()
	{
		// create ecore file
		createTargetEcore();
		
		// save instance
		m_oResourceXMIOut.getContents().add(m_oTCG);
		try {
			m_oOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			m_oResourceXMIOut.save(m_oOptions);
		}
		catch(IOException e)
		{}
	}
	
	private void createTargetEcore()
	{
		m_oResourceEcoreOut.getContents().add(GeneratedPackage.eINSTANCE);
		
		try {
			m_oResourceEcoreOut.save(m_oOptions);
		}
		catch(IOException e)
		{}
	}
	

	public boolean isGivenNameAlreadyUsedForMethod(String in_sName, EClass in_oClass)
	{
		for(EOperation oOperation : in_oClass.getEOperations())
		{
			if(oOperation.getName().compareTo(in_sName) == 0)
				return true;
		}
		return false;
	}

	public String getNewUnusedName(String in_sNameBase, EClass in_oClass)
	{
		for(Integer i = 1; true; ++i)
		{
			if(isGivenNameAlreadyUsedForMethod(in_sNameBase + i.toString(), in_oClass))
				continue;
			return in_sNameBase + i.toString();
		}
	}
	
	/**
	 * This method creates a part of the TestCaseTree from an anchor node of the TestCaseTree
	 * and an OCL expression of one outgoing transition (statemachine).
	 * This depends on the ingoing call event - so it can only be used for guard conditions
	 */
	public ArrayList<TCGNode> createTCGPartFromExpressionForCallEvent(
			OCLExpression in_oExpression,
			TCGNode in_oTCGNode,
			Event in_oEvent,
			org.eclipse.uml2.uml.Class in_oContextClass,
			boolean in_bCreateTCGEventIfEventIsNull)
	{
		ArrayList<TCGNode> colNodes = new ArrayList<TCGNode>();
		boolean bReachingTransitionBearsConflicts = false;
		
		if(in_oExpression != null)
		{
			// transform OCL to TCGOCL 
			TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
					in_oExpression, Configuration.getOCLGuardId(), in_oContextClass);
			// transform to DNF
			TCGDisjunctiveNormalForm oDNF = ExpressionConverter.createDisjunctiveNormalForm(oTCGOCLExp);
			// add expressions for coverage criterion
			ExpressionConverter.addConjunctionsForCoverageCriterion(oDNF);
			
			// work on each conjunction
			for(TCGConjunction oConjunction : oDNF.getConjunctions())
			{
				if(conditionsInConjunctionAreContradicting(oConjunction))
				{
					bReachingTransitionBearsConflicts = true;
				}
				else
				{
					TCGEvent oTCGEvent = createTCGEvent(in_oEvent, in_bCreateTCGEventIfEventIsNull);						
					TCGTransition oTransition = createTCGPart(in_oTCGNode, 
							(oTCGEvent != null ? oTCGEvent.getName() : Configuration.getDefaultTransitionName()));
					// remember original expression
					oTransition.getTargetNode().setOriginalExpression(in_oExpression);
					
					if(oTransition != null)
					{
						boolean bResult = true;
						// adapt all parameters of all expressions of the conjunction
						for(TCGOCLExpression oExpression : oConjunction.getExpressions())
						{
							adaptTCGOCLExpression(oExpression, oTransition, oTCGEvent, in_oContextClass);
							if(oTransition.getPrecondition().getConjunctions().isEmpty())
								oTransition.getPrecondition().getConjunctions().add(
										GeneratedFactory.eINSTANCE.createTCGConjunction());
							oTransition.getPrecondition().getConjunctions().get(0).getExpressions().add(oExpression);
							bResult = bResult && adaptDomainForNonPostcondition(oExpression, oTransition.getTargetNode(), oTransition.getTargetNode());
						}
		
						if(bResult == false)
						{
							removeTransition(oTransition);
							bReachingTransitionBearsConflicts = true;
						}
						else
						{
							// mark node as its purpose is just to negate an expression  
							if(!oConjunction.isPositiveSubExpressionOfOriginal())
								oTransition.getTargetNode().setCorrespondsNegativeExpression(true); 
							colNodes.add(oTransition.getTargetNode());
						}
					}
				}
			}
		}
		
		// expression results in no new nodes and no conflicts found? -> add default node
		if(colNodes.isEmpty() && !bReachingTransitionBearsConflicts)
		{
			TCGEvent oTCGEvent = createTCGEvent(in_oEvent, true);						
			TCGTransition oTransition = createTCGPart(in_oTCGNode, oTCGEvent.getName());
			if(oTransition != null)
			{
				addEvent(null, oTransition, oTCGEvent, in_oContextClass);
				colNodes.add(oTransition.getTargetNode());
			}
		}
		
		return colNodes;
	}	

	public static TCGDisjunctiveNormalForm createDNFForOCLExpression(
			OCLExpression in_oOCLExpression,
			Namespace in_oNamespace,
			String in_sOCLKind)
	{
		TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
				in_oOCLExpression, in_sOCLKind, in_oNamespace);
		// transform to DNF
		TCGDisjunctiveNormalForm oDNF = ExpressionConverter.createDisjunctiveNormalForm(oTCGOCLExp);
		return oDNF;
	}
	
	/**
	 * the same like createTCGPartFromExpressionForCallEvent but for preconditions
	 */
	public ArrayList<TCGNode> createTCGPartFromExpressionForPrecondition(
			OCLExpression in_oExpression, 
			TCGNode in_oTCGNode,
			Operation in_oOperation,
			org.eclipse.uml2.uml.Class in_oContextClass)
	{
		ArrayList<TCGNode> colNodes = new ArrayList<TCGNode>();
		// transform OCL to TCGOCL 
		TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
				in_oExpression, Configuration.getOCLPreId(), in_oContextClass);
		// transform to DNF
		TCGDisjunctiveNormalForm oDNF = ExpressionConverter.createDisjunctiveNormalForm(oTCGOCLExp);
		// add expressions for coverage criterion
		ExpressionConverter.addConjunctionsForCoverageCriterion(oDNF);

		for(TCGConjunction oConjunction : oDNF.getConjunctions())
		{
			TCGTransition oTransition = createTCGPart(in_oTCGNode, in_oOperation.getName());

			if(oTransition != null)
			{
				// remember original expression
				oTransition.getTargetNode().setOriginalExpression(in_oExpression);

				boolean bResult = true; 
				for(TCGOCLExpression oExpression : oConjunction.getExpressions())
				{
					adaptTCGOCLExpression(oExpression, oTransition, null, in_oContextClass);
					if(oTransition.getPrecondition().getConjunctions().isEmpty())
						oTransition.getPrecondition().getConjunctions().add(
								GeneratedFactory.eINSTANCE.createTCGConjunction());
					oTransition.getPrecondition().getConjunctions().get(0).getExpressions().add(oExpression);
					bResult = bResult && adaptDomainForNonPostcondition(oExpression, oTransition.getTargetNode(), oTransition.getTargetNode());
				}

				if(bResult == false)
				{
					removeTransition(oTransition);
				}
				else
				{
					// further handle only nodes with correct expressions  
					if(oConjunction.isPositiveSubExpressionOfOriginal())
						colNodes.add(oTransition.getTargetNode());
					else
						oTransition.getTargetNode().setCorrespondsNegativeExpression(true); // mark node as its purpose is just to negate an expression
				}				
			}
		}
		return colNodes;
	}

	/**
	 * the same like createTCGPartFromExpressionForCallEvent but for postconditions
	 */
	public ArrayList<TCGNode> createTCGPartFromExpressionForPostcondition(
			OCLExpression in_oExpression, 
			TCGNode in_oTCGNode,
			Operation in_oOperation,
			org.eclipse.uml2.uml.Class in_oContextClass)
	{
		ArrayList<TCGNode> colNodes = new ArrayList<TCGNode>();
		TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
				in_oExpression, Configuration.getOCLPostId(), in_oContextClass);
		TCGDisjunctiveNormalForm oDNF = ExpressionConverter.createDisjunctiveNormalForm(oTCGOCLExp);
		for(TCGConjunction oConjunction : oDNF.getConjunctions())
		{
			TCGTransition oTransition = createTCGPart(in_oTCGNode, in_oOperation.getName());
			if(oTransition != null)
			{
				// remember original expression
				oTransition.getTargetNode().setOriginalExpression(in_oExpression);
				
				TCGEvent oTCGEvent = findTriggeringEvent(oTransition);
				boolean bResult = true; 
				
				for(TCGOCLExpression oExpression : oConjunction.getExpressions())
				{
					adaptTCGOCLExpression(oExpression, oTransition, null, in_oContextClass);
					referToEvent(oTCGEvent, oExpression);
					if(oTransition.getPostcondition().getConjunctions().isEmpty())
						oTransition.getPostcondition().getConjunctions().add(
								GeneratedFactory.eINSTANCE.createTCGConjunction());
					oTransition.getPostcondition().getConjunctions().get(0).getExpressions().add(oExpression);
					
					// if this postcondition contains no dependent elements -> then adapt the domain!
					TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(oExpression);
					TCGOCLExpression oActiveDependentExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);
//					TCGOCLExpression oPassiveDependentExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.PASSIVE_DEPENDENT);
					if(oActiveDependentExpression == null)
					{
//						if(oPassiveDependentExpression == null) // just constants and input parameters
//						{
							bResult = bResult && adaptDomainForNonPostcondition(oExpression, oTransition.getTargetNode(), oTransition.getTargetNode());
//						} 
//						else // no active dependent variables -> restrict value domain (act like for precondition)
//						{
//							bResult = bResult && adaptDomainForNonPostcondition(oExpression, oTransition.getTargetNode(), oTransition.getTargetNode());
//						}
					}
				}
				// add transition only if resulting domain is not empty!
				if(bResult == false)
				{
					removeTransition(oTransition);
				}
				else
				{
					colNodes.add(oTransition.getTargetNode());
				}
			}
		}
		return colNodes;
	}
	
	// finds the event that (indirectly) triggers this transition 
	private static TCGEvent findTriggeringEvent(TCGTransition in_oTransition)
	{
		if(in_oTransition.getEvent() != null)
			return in_oTransition.getEvent();
		else if(in_oTransition.getSourceNode().getIncomingTransitions().size() > 0)
			return findTriggeringEvent(in_oTransition.getSourceNode().getIncomingTransitions().get(0));
		return null;
	}

//	/**
//	 * normalizes the expression and converts it into a TCGOCLExpression (necessary for classification)
//	 */
//	private TCGOCLExpression transformExpressionToTCGOCLExpression(
//			TCGTransition in_oTransition,
//			Event in_oEvent,
//			OCLExpression in_oOCLExpression, 
//			String in_sOCLTypeId)
//	{
//		// TODO normalizeExpression darf nur mit TCGOCLExpression arbeiten, da sonst
//		// die referenzierten Operationen verändert werden -> nach jeder Veränderung sind
//		// SÄMTLICHE betroffenen Ausdrücke verändert !
//		TCGOCLExpression oTCGExpression = TransformOCLToTCGOCL.
//			transformExpression(in_oOCLExpression, in_sOCLTypeId);
//		adaptTCGOCLExpression(oTCGExpression, in_oTransition, in_oEvent);
//		return oTCGExpression;
//	}
	
	/**
	 * adapts TCGOCLExpression to event and normalizes it
	 * @param in_oExpression
	 * @param in_oTransition
	 * @param in_oEvent
	 */
	private void adaptTCGOCLExpression(
			TCGOCLExpression in_oExpression, 
			TCGTransition in_oTransition, 
			TCGEvent in_oEvent,
			org.eclipse.uml2.uml.Class in_oContextClass)
	{
		// inserted event is null -> use the one that (indirectly) triggered this transition
		if(in_oEvent == null)
		{
			referToEvent(findTriggeringEvent(in_oTransition), in_oExpression);
		}
		else
		{
			// create new event or refer to existing
			if(in_oTransition.getEvent() == null)
				addEvent(in_oExpression, in_oTransition, in_oEvent, in_oContextClass);
			else
				referToEvent(in_oTransition.getEvent(), in_oExpression);
		}
		ExpressionConverter.normalizeExpression(in_oExpression);		
	}
	
	/**
	 * creates a TCGTransition and a corresponding target TCGNode 
	 */
	private TCGTransition createTCGPart(
			TCGNode in_oTCGNode,
			String in_sTransitionNamePrefix)
	{
		// create new node in TestCaseGraph
		TestCaseGraphAddNodeAction oAction = 
			new TestCaseGraphAddNodeAction(this, in_oTCGNode);
		oAction.execute();
		
		// constraints checken
		if(checkCoverageCriteria() == false)
		{
			oAction.reverse();
			return null;
		}
		else
		{
			// new node - set name
			TCGNode oNewTCGNode = oAction.getNode();
			oNewTCGNode.setName("tmp " + String.valueOf(getTestCaseGraph().getNodes().size()));
			oNewTCGNode.setInvariant(null);
			
			// copy all parameters of the predecessor
			TCGParameterHelperClass.copyParameters(in_oTCGNode, oNewTCGNode);
			
			// set name of the new connecting transition
			TCGTransition oTCGTransition = oNewTCGNode.getIncomingTransitions().get(0);
			oTCGTransition.setName(in_sTransitionNamePrefix + "_" 
					+ getTestCaseGraph().getTransitions().size());
			return oTCGTransition;
		}
	}
	
	/**
	 * Adapts the domain for the parameters of the target node of the used transition
	 */
	private boolean adaptDomainForNonPostcondition(TCGOCLExpression in_oExpression, TCGNode in_oBackTrackStartNode, TCGNode in_oCurrentBackTrackNode)
	{
		if(in_oExpression != null)
		{
			// get equivalence class for right side of expression (left side is the Parameter)
			TCGEquivalenceClass oEqClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(in_oExpression);
			if(oEqClass != null && in_oExpression instanceof TCGOCLOperation)
			{
				if(((TCGOCLOperation)in_oExpression).getLeft() instanceof TCGOCLAtom)
				{
					TCGOCLAtom oAtom = (TCGOCLAtom)((TCGOCLOperation)in_oExpression).getLeft();
					// interesting element is a variable - get all the necessary values
					if(getVariable(oAtom.getElement()) != null)
					{
						TCGParameter oCorrespondingParam = getCorrespondingParameterCopyInNode((TCGParameter)oAtom.getTcgParameter(), in_oBackTrackStartNode);
						if(!DomainHelper.adaptDomain(oCorrespondingParam, oEqClass))
							return false;
					}
					// interesting value is passive dependent -> find matching active dependent and go on ...
					else if(oAtom.getElement() instanceof Property)
					{
						if(in_oBackTrackStartNode.getIncomingTransitions().size() == 1)
						{
							Property oProperty = (Property)oAtom.getElement();
							TCGTransition oTransition = findNextPrecedingTransition(in_oCurrentBackTrackNode.getIncomingTransitions().get(0), oProperty);
							if(oTransition != null) // is there a next preceding transition ?
							{
								// TODO ### future work: sort elements in expressions only if needed?
								ArrayList<TCGOCLExpression> colNewExpressions = new ArrayList<TCGOCLExpression>();
								boolean bConditionsAreConflicting = connectPreconditionAndASetOfPostconditions(
										in_oExpression, oProperty, oTransition.getPostcondition(), colNewExpressions);
								if(bConditionsAreConflicting)
									return false;
								
								// TODO ### hier bei einfacher Wahrheit der Aussage auch anderen Bestandteile der Konjunktion prüfen
								for(TCGOCLExpression oNewExpression : colNewExpressions)
								{
									return adaptDomainForNonPostcondition(oNewExpression, in_oBackTrackStartNode, oTransition.getSourceNode());
								}
							}
							else
								return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * This method connects two expressions under consideration of a given property.
	 * The left sides of both parameters are references to the same property.
	 * The right sides of both conditions are put into a new expression.
	 * @param in_oPrecondition
	 * @param in_oPostcondition
	 * @param in_oProperty the active dependend variable has to reference this property
	 * @return defines if the evaluation shows that pre- and postconditions are conflicting! 
	 */
	public static boolean connectPreconditionAndASetOfPostconditions(
			TCGOCLExpression in_oPrecondition, 
			Property in_oProperty,
			TCGDisjunctiveNormalForm in_colPostcondition,
			ArrayList<TCGOCLExpression> in_colNewExpressions)
	{
		/** TODO TODO TODO Vergleich OCL Vor- und Nachbedingungen!
		 * Wie wird eine Vorbedingung mit mehreren ver-UND-eten Nachbedingungen verknüpft?
		 * 1) Alle Nachbedingungen suchen, die den Parameter enthalten, der bei der Vorbedingung aktiv ist
		 * 2) Vergleich anstellen
		 * 2.1) wenn Nachbedingung weitere passive abhängige Elemente enthält: rekursiver Funktionsruf ohne 
		 *      gerade bearbeitete Nachbedingung + Aufnahme 
		 * 2.2) wenn Nachbedingung Eingabeparameter enthält: in die Liste der neuen Ausdrücke aufnehmen
		 * 2.3) wenn Nachbedingung sonst nur Konstanten enthält: ...
		 * 
		 * ganz spezieller Fall:
		 * 1) Postcondition enthält weitere abhängige -> weitersuchen: 
		 *    ohne @pre -> in eigener Postcondition; mit @pre -> in vorhergehenden Postconditions
		 * 2) Postcondition enthält keine weitere abhängige -> Vor- und Nachbedingung vergleichen:
		 *    wenn aus Postcondition die Precondition folgt, dann alle weiteren Nachbedingungen als wahr annehmen
		 *    -> wenn passive Abhängige in Bezug zu Konstante gesetzt werden -> in vorherigen Postconditions suchen 
		 */
		for(TCGConjunction oConjunction : in_colPostcondition.getConjunctions())
		for(TCGOCLExpression oPostCondition : oConjunction.getExpressions())
		{
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(oPostCondition);
			TCGOCLExpression oActiveExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);
			if(oActiveExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oAtomExp = (TCGOCLAtom)oActiveExpression;
				if(oAtomExp.getElement().equals(in_oProperty))
				{
					oClassificator.shiftSubexpressionToTheLeft(oActiveExpression);
					if(oClassificator.getExpression() instanceof TCGOCLOperation)
					{
						TCGOCLOperation oOperation = (TCGOCLOperation)oClassificator.getExpression();
						TCGOCLVariableClassificator oRightSubClassificator = new TCGOCLVariableClassificator(oOperation.getRight());
						
						// does the right side contain an active dependent element? -> schwierig -> dafür oActiveExpression und
						// oActiveSubExpression auseinanderhalten !
						//TCGOCLExpression oActiveSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);

						// does the right side contain a passive dependent element?
						TCGOCLExpression oPassiveDependentSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.PASSIVE_DEPENDENT);
						TCGOCLExpression oInputParameterSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.INPUT_PARAMETER);
						if((oPassiveDependentSubExpression != null) || (oInputParameterSubExpression != null))
						{
							in_colNewExpressions.add(connectPreconditionAndPostcondition(in_oPrecondition, oPostCondition));
						}
						else { // does the right side contain just independent elements?
							// compare the expressions of both elements!
							TCGEquivalenceClass oEqPostconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(oOperation);
							TCGEquivalenceClass oEqPreconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(in_oPrecondition);
							if(oEqPostconditionClass != null && oEqPreconditionClass != null)
							{
								// postcondition 
								if(ConversionController.outerEquivalenceClassContainsInnerClass(oEqPreconditionClass, oEqPostconditionClass, false))
								{
									// alle Elemente der Konjunktion durchsuchen
									for(TCGConjunction oIndependentConjunction : in_colPostcondition.getConjunctions())
									for(TCGOCLExpression oIndependentPostCondition : oIndependentConjunction.getExpressions())
									{
										// außer der gerade behandelten Nachbedingung
										if(oIndependentPostCondition != oPostCondition)
										{
											TCGOCLVariableClassificator oIndependentClassificator = new TCGOCLVariableClassificator(oIndependentPostCondition);
											if(oIndependentClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT) == null)
											{
												// die Elemente ohne aktive Variablen weiter in früheren Postconditions checken
												in_colNewExpressions.add(oIndependentPostCondition);
											}
										}
									}
									return false;
								}
								else
									return true; // conflict!
							}
							return false;
						}						
					}
				}
			}
		}
		return false;
	}

	/**
	 * This method connects two expressions.
	 * The left sides of both parameters are references to the same property.
	 * The right sides of both conditions are put into a new expression.
	 * @param in_oPrecondition
	 * @param in_oPostcondition
	 * @return defines if the evaluation shows that pre- and postconditions are conflicting! 
	 */
	public static boolean connectPreconditionAndASetOfPostconditions(
			TCGOCLExpression in_oPrecondition, 
			TCGDisjunctiveNormalForm in_colPostcondition,
			ArrayList<TCGOCLExpression> in_colNewExpressions)
	{
		for(TCGConjunction oConjunction : in_colPostcondition.getConjunctions())
		for(TCGOCLExpression oPostCondition : oConjunction.getExpressions())
		{
			TCGOCLVariableClassificator oClassificator = 
				new TCGOCLVariableClassificator(oPostCondition);
			TCGOCLExpression oActivePostExpression = 
				oClassificator.getClassifiedElementInExpression(
						VariableClassification.ACTIVE_DEPENDENT);
			if(oActivePostExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oAtomPostExp = (TCGOCLAtom)oActivePostExpression;
				if(TCGOCLExpressionHelperClass.conditionContainsReferenceToObject(
						in_oPrecondition, oAtomPostExp.getElement()))
				{
					oClassificator.shiftSubexpressionToTheLeft(oActivePostExpression);
					if(oClassificator.getExpression() instanceof TCGOCLOperation)
					{
						TCGOCLOperation oOperation = 
							(TCGOCLOperation)oClassificator.getExpression();
						TCGOCLVariableClassificator oRightSubClassificator = 
							new TCGOCLVariableClassificator(oOperation.getRight());
						
						// does the right side contain a passive dependent element?
						TCGOCLExpression oPassiveDependentSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.PASSIVE_DEPENDENT);
						TCGOCLExpression oInputParameterSubExpression = oRightSubClassificator.getClassifiedElementInExpression(VariableClassification.INPUT_PARAMETER);
						if((oPassiveDependentSubExpression != null) || (oInputParameterSubExpression != null))
						{
							in_colNewExpressions.add(connectPreconditionAndPostcondition(in_oPrecondition, oPostCondition));
						}
						else { // does the right side contain just independent elements?
							// compare the expressions of both elements!
							TCGEquivalenceClass oEqPostconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(oOperation);
							TCGEquivalenceClass oEqPreconditionClass = ExpressionConverter.getEquivalenceClassForRightSideOfExpression(in_oPrecondition);
							if(oEqPostconditionClass != null && oEqPreconditionClass != null)
							{
								// postcondition 
								if(ConversionController.outerEquivalenceClassContainsInnerClass(oEqPreconditionClass, oEqPostconditionClass, false))
								{
									// alle Elemente der Konjunktion durchsuchen
									for(TCGConjunction oIndependentConjunction : in_colPostcondition.getConjunctions())
									for(TCGOCLExpression oIndependentPostCondition : oIndependentConjunction.getExpressions())
									{
										// außer der gerade behandelten Nachbedingung
										if(oIndependentPostCondition != oPostCondition)
										{
											TCGOCLVariableClassificator oIndependentClassificator = new TCGOCLVariableClassificator(oIndependentPostCondition);
											if(oIndependentClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT) == null)
											{
												// die Elemente ohne aktive Variablen weiter in früheren Postconditions checken
												in_colNewExpressions.add(oIndependentPostCondition);
											}
										}
									}
									return false;
								}
								else
									return true; // conflict!
							}
							return false;
						}						
					}
				}
			}
		}
		return false;
	}

	
	private static TCGOCLExpression connectPreconditionAndPostcondition(
			TCGOCLExpression in_oPrecondition, 
			TCGOCLExpression in_oPostcondition)
	{
		TCGOCLOperation oExpression = null;
		if(in_oPrecondition instanceof TCGOCLOperation &&
				in_oPostcondition instanceof TCGOCLOperation)
		{
			TCGOCLOperation oPrecondition = (TCGOCLOperation)in_oPrecondition;
			TCGOCLOperation oPostcondition = (TCGOCLOperation)in_oPostcondition;
			// both conditions have the dependent property on the left side

			// all missing combinations of relations cannot be evaluated
			if((oPrecondition.getOperationName().compareTo("<") == 0 && oPostcondition.getOperationName().compareTo("<") == 0) ||
					(oPrecondition.getOperationName().compareTo("<") == 0 && oPostcondition.getOperationName().compareTo("<=") == 0) ||
					(oPrecondition.getOperationName().compareTo("<") == 0 && oPostcondition.getOperationName().compareTo("=") == 0) ||
					(oPrecondition.getOperationName().compareTo("<=") == 0 && oPostcondition.getOperationName().compareTo("<") == 0) ||
					(oPrecondition.getOperationName().compareTo("=") == 0 && oPostcondition.getOperationName().compareTo("<") == 0)) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oExpression.setOperationName("<");
			}
			else if((oPrecondition.getOperationName().compareTo("<=") == 0 && oPostcondition.getOperationName().compareTo("<=") == 0) ||
					(oPrecondition.getOperationName().compareTo("<=") == 0 && oPostcondition.getOperationName().compareTo("=") == 0) ||
					(oPrecondition.getOperationName().compareTo("=") == 0 && oPostcondition.getOperationName().compareTo("<=") == 0)) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oExpression.setOperationName("<=");
			}
			else if(oPrecondition.getOperationName().compareTo("=") == 0 && oPostcondition.getOperationName().compareTo("=") == 0) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oExpression.setOperationName("=");
			}
			else if((oPrecondition.getOperationName().compareTo("=") == 0 && oPostcondition.getOperationName().compareTo(">=") == 0) ||
					(oPrecondition.getOperationName().compareTo(">=") == 0 && oPostcondition.getOperationName().compareTo("=") == 0) ||
					(oPrecondition.getOperationName().compareTo(">=") == 0 && oPostcondition.getOperationName().compareTo(">=") == 0)) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oExpression.setOperationName(">=");
			}
			else if((oPrecondition.getOperationName().compareTo("=") == 0 && oPostcondition.getOperationName().compareTo(">") == 0) ||
					(oPrecondition.getOperationName().compareTo(">=") == 0 && oPostcondition.getOperationName().compareTo(">") == 0) ||
					(oPrecondition.getOperationName().compareTo(">") == 0 && oPostcondition.getOperationName().compareTo("=") == 0) ||
					(oPrecondition.getOperationName().compareTo(">") == 0 && oPostcondition.getOperationName().compareTo(">=") == 0) ||
					(oPrecondition.getOperationName().compareTo(">") == 0 && oPostcondition.getOperationName().compareTo(">") == 0)) {
				oExpression = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oExpression.setOperationName(">");
			}

			// got new expression -> also add copies of the left and the right part
			if(oExpression != null)
			{
				// just referencing the used sides of the original conditions is error-prone
				// -> in the following these sides are altered -> this would affect also the original conditions!
				oExpression.setLeft(copyExpression(oPostcondition.getRight()));
				oExpression.setRight(copyExpression(oPrecondition.getRight()));
				ExpressionConverter.normalizeExpression(oExpression);
			}
		}		
		return oExpression;
	}	
	
	/**
	 * copies the TCGOCLExpression
	 */
	public static TCGOCLExpression copyExpression(TCGOCLExpression in_oExpression)
	{
		TCGOCLExpression oTCGOCLExpression = null;
		if(in_oExpression != null)
		{
			if(in_oExpression instanceof TCGOCLAtom)
			{
				TCGOCLAtom oOldAtom = (TCGOCLAtom)in_oExpression;
				TCGOCLAtom oNewAtom = GeneratedFactory.eINSTANCE.createTCGOCLAtom();
				oNewAtom.setElement(oOldAtom.getElement());
				oNewAtom.setTcgParameter(oOldAtom.getTcgParameter());
				oTCGOCLExpression = oNewAtom;
			}
			else if(in_oExpression instanceof TCGOCLOperation)
			{
				TCGOCLOperation oOldOperation = (TCGOCLOperation)in_oExpression;
				TCGOCLOperation oNewOperation = GeneratedFactory.eINSTANCE.createTCGOCLOperation();
				oNewOperation.setOperation(oOldOperation.getOperation());
				oNewOperation.setOperationName(oOldOperation.getOperationName());
				oNewOperation.setLeft(copyExpression(oOldOperation.getLeft()));
				oNewOperation.setRight(copyExpression(oOldOperation.getRight()));
				oTCGOCLExpression = oNewOperation;
			}
			oTCGOCLExpression.setClassification(in_oExpression.getClassification());
			oTCGOCLExpression.setOclReference(in_oExpression.getOclReference());
		}
		return oTCGOCLExpression;		
	}
	
	private TCGTransition findNextPrecedingTransition(TCGTransition in_oTransition, Property in_oSearchedProperty)
	{
		if(transitionContainsActiveProperty(in_oTransition, in_oSearchedProperty))
		{
			return in_oTransition;
		}
		else if(in_oTransition.getSourceNode().getIncomingTransitions().size() > 0)
		{
			return findNextPrecedingTransition(in_oTransition.getSourceNode().getIncomingTransitions().get(0), in_oSearchedProperty);
		}
		return null;
	}
	
	private boolean transitionContainsActiveProperty(TCGTransition in_oTransition, Property in_oSearchedProperty)
	{
		if(in_oTransition.getPostcondition() != null)
		{
			for(TCGConjunction oConjunction : in_oTransition.getPostcondition().getConjunctions())
			{
				for(TCGOCLExpression oExp : oConjunction.getExpressions())
				{
					if(expressionContainsActiveProperty(oExp, in_oSearchedProperty))
						return true;
				}
			}
		}
		return false;
	}
	
	
	private boolean expressionContainsActiveProperty(TCGOCLExpression in_oExpression, Property in_oSearchedProperty)
	{
		TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(in_oExpression);
		TCGOCLExpression oExpression = oClassificator.getClassifiedElementInExpression(VariableClassification.ACTIVE_DEPENDENT);
		if(oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtomExp = (TCGOCLAtom)oExpression;
			if(oAtomExp.getElement().equals(in_oSearchedProperty))
				return true;
		}
		return false;
	}
	
	/**
	 * checks if coverage criteria are satisfied
	 * @return
	 */
	private boolean checkCoverageCriteria()
	{
		if(getTestCaseGraph() == null)
			return true;
		
		// check actual depth of state machine
		if(m_nActualStateMachineDepth > Configuration.getMaximalStatemachineDepth())
			return false;
		
		// check TestCaseGraph
		TestCaseGraphDepthConstraint m_oDepthConstraint = 
			new TestCaseGraphDepthConstraint(
					Configuration.getMaximalTestGraphDepth(), getTestCaseGraph());
		if(!m_oDepthConstraint.isFulfilled())
			return false;
		
		return true;
	}
	
	public void incActualStateMachineDepth()
	{
		++m_nActualStateMachineDepth;
	}
	
	public void decActualStateMachineDepth()
	{
		--m_nActualStateMachineDepth;
	}

	public static boolean isEquivalenceClassEmpty(TCGParameter in_oParameter)
	{
		ArrayList<TCGPrimitiveParameter> colPars = TCGParameterHelperClass.collectContainedPrimitiveParameters(in_oParameter);
		for(TCGPrimitiveParameter oPar : colPars)
		{
			if(!isEquivalenceClassEmpty(oPar.getEquivalenceClass()))
				return false;
		}
		return true;
	}
	
	public static boolean isEquivalenceClassEmpty(TCGEquivalenceClass in_oEqClass)
	{
		// min > max
		if(in_oEqClass.getMinBorder().compareTo(in_oEqClass.getMaxBorder()) > 0)
			return true;
		
		// min == max; one boundary excluded
		if((in_oEqClass.getMinBorder().compareTo(in_oEqClass.getMaxBorder()) == 0) &&
				(!in_oEqClass.getMinIncluded() || !in_oEqClass.getMaxIncluded()))
		{
			return true;
		}
		
		// min + min_dist == max; both boundaries excluded
		if((in_oEqClass.getMinBorder().doubleValue() + Configuration.getDomainBorderDistance().doubleValue() == in_oEqClass.getMaxBorder().doubleValue()) &&
				!in_oEqClass.getMinIncluded() && !in_oEqClass.getMaxIncluded())
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * returns the effect of a transition corresponding to the current context (selected class)
	 * @param in_oTransition
	 * @return
	 */
	public static Operation getContextEffectSpecification(Transition in_oTransition)
	{
		Behavior oEffect = in_oTransition.getEffect();
		if(oEffect != null)
		{
			if(oEffect.getSpecification() instanceof Operation)
				return getContextEffectSpecificationHelper((Operation)oEffect.getSpecification(), 
						Configuration.getContextClassForVertex(in_oTransition.getSource()));
		}
		return null;
	}

	public static Operation getContextEffectSpecificationHelper(Operation in_oOperation, org.eclipse.uml2.uml.Class in_oContextClass)
	{
		EList<String> colParameterNames = new BasicEList<String>();
		EList<Type> colParameterTypes = new BasicEList<Type>();
		for(Parameter oParameter : in_oOperation.getOwnedParameters())
		{
			colParameterNames.add(oParameter.getName());
			colParameterTypes.add(oParameter.getType());
		}
		org.eclipse.uml2.uml.Operation oOperation = in_oContextClass.getOperation(in_oOperation.getName(), 
				colParameterNames, colParameterTypes);
		if(oOperation != null)
			return oOperation;
		
		for(Generalization oGeneralization : in_oContextClass.getGeneralizations())
		{
			if(oGeneralization.getGeneral() != null)
			{
				Classifier oClassifier = oGeneralization.getGeneral();
				if(oClassifier instanceof org.eclipse.uml2.uml.Class)
				{
					// TODO Mehrvererbung muss noch einbeziehen von welcher Superklasse aus die Zustandsmaschine defineirt wurde
					return getContextEffectSpecificationHelper(in_oOperation, (org.eclipse.uml2.uml.Class)oClassifier);
				}
			}
		}
		
		return null;
	}
	
	/*
	 * examines the conditions in the conjunction and searches for contradictions
	 */
	public static boolean conditionsInConjunctionAreContradicting(TCGConjunction in_oConjunction)
	{
		// simple contradiction in just one condition
		for(TCGOCLExpression oExpression : in_oConjunction.getExpressions())
		{
			// first check that the expression has no dependent elements
			TCGOCLVariableClassificator oClassificator = new TCGOCLVariableClassificator(oExpression);
			
			// TODO #### Widersprüche auch für Eingabeparameter aufdecken
			
			if((oClassificator.getNumberOfDependentVariables() == 0) && 
					(oClassificator.getNumberOfInputParameter() == 0))
			{
				try {
					if(oExpression instanceof TCGOCLOperation)
					{
						TCGOCLOperation oOperation = (TCGOCLOperation)oExpression;
						double nLeftValue = ExpressionConverter.getValue(oOperation.getLeft());
						double nRightValue = ExpressionConverter.getValue(oOperation.getRight());
						if((oOperation.getOperationName().compareTo("<") == 0) && (nLeftValue >= nRightValue))
							return true;
						if((oOperation.getOperationName().compareTo("<=") == 0) && (nLeftValue > nRightValue))
							return true;
						if((oOperation.getOperationName().compareTo("=") == 0) && (nLeftValue != nRightValue))
							return true;
						if((oOperation.getOperationName().compareTo(">=") == 0) && (nLeftValue < nRightValue))
							return true;
						if((oOperation.getOperationName().compareTo(">") == 0) && (nLeftValue <= nRightValue))
							return true;
					}
				}
				catch(Exception e)
				{
					// nothing ...
				}
			}
		}
		
		return false;
	}
	

	
	/**
	 * returns a matching property in context in_oContext
	 * @param in_oSuperProperty the pattern property
	 * @param in_oContext
	 * @return
	 */
	public static Property findMatchingPropertyInContext(
			Property in_oSuperProperty, 
			org.eclipse.uml2.uml.Class in_oContext)
	{
		Property oProperty = in_oContext.getAttribute(in_oSuperProperty.getName(), in_oSuperProperty.getType());
		if(oProperty == null)
		{
			for(Generalization oGeneralization : in_oContext.getGeneralizations())
			{
				if(oGeneralization.getGeneral() instanceof org.eclipse.uml2.uml.Class)
				{
					return findMatchingPropertyInContext(in_oSuperProperty, (org.eclipse.uml2.uml.Class)oGeneralization.getGeneral());
				}
			}
			return in_oSuperProperty;
		}
		else
			return oProperty;
	}	
	
	/*
	 * if in_oExpression is part of a parameter
	 * -> then the variable expression that references the parameter is returned
	 */
	public static VariableExp getVariableExp(
			org.eclipse.ocl.expressions.OCLExpression<?> in_oExpression)
	{
		// parameter is a variable
		if(in_oExpression instanceof VariableExp)
		{
			VariableExp oVarExp = (VariableExp)in_oExpression;
			if(oVarExp.getReferredVariable() != null)
				if(oVarExp.getReferredVariable().getRepresentedParameter() != null)
					return (VariableExp)in_oExpression;
		}
		// parameter is an abstract data type - in expression only an attribute is referenced
		else if(in_oExpression instanceof PropertyCallExp)
		{
			PropertyCallExp oPropExp = (PropertyCallExp)in_oExpression;
			return getVariableExp(oPropExp.getSource());
		}
		return null;
	}
	
	public static VariableExp getVariable(EObject in_oEObject)
	{
		if(in_oEObject instanceof OCLExpression)
			return getVariableExp((OCLExpression)in_oEObject);
		return null;
	}
	
	/*
	 * returns the full name of the element referenced by the expression
	 */
	public static String getFullPropertyName(Property in_oProperty, Type in_oType)
	{
		if(in_oProperty.getType().equals(in_oType))
			return "";
		else
		{
			if(in_oProperty.getOwner() instanceof Property)
			{
				Property oProp = (Property)in_oProperty.getOwner();
				return in_oProperty.getName() + "." + getFullPropertyName(oProp, in_oType);
			}
			else
				return in_oProperty.getName();
		}
	}

	public TestGoalManager getTestGoalMgr() {
		return m_oTestGoalMgr;
	}

	public void setTestGoalMgr(TestGoalManager testGoalMgr) {
		m_oTestGoalMgr = testGoalMgr;
	}
}
