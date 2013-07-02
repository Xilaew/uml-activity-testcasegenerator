package net.sf.parteg.base.testcasegraph.ocl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.helperclasses.AttributeGetterReferencer;
import net.sf.parteg.base.testcasegraph.helperclasses.BasicDistanceSetter;
import net.sf.parteg.base.testcasegraph.helperclasses.DecisionNodeSplitter;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGRegionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TestCaseGraphFlattener;
import net.sf.parteg.base.testcasegraph.helperclasses.VariableReferencer;
import net.sf.parteg.base.testcasegraph.systemstate.SystemModelStateHistory;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalManager;
import net.sf.parteg.core.output.Logger;
import net.sf.parteg.core.structures.ObjectComparator;

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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;

public class TestCaseGraphHelper {

	private TestCaseGraph m_oTCG;

	private ResourceSet m_oResourceSet;
	private Resource m_oResourceEcoreOut;
	private Resource m_oResourceXMIOut;
	private HashMap<String, Boolean> m_oOptions;
	private SystemModelStateHistory m_oHistory;
	private VariableReferencer m_colOCLReferencingElements;
	private AttributeGetterReferencer m_colAttributeGetterReferencer;
	private Logger m_oLogger;

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
		m_oOptions = new LinkedHashMap<String, Boolean>();
		m_oOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		m_oOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		// create TestCaseGraphTree
		m_oTCG = GeneratedFactory.eINSTANCE.createTestCaseGraph();

		m_oHistory = new SystemModelStateHistory();
		m_colOCLReferencingElements = new VariableReferencer();
		m_colAttributeGetterReferencer = new AttributeGetterReferencer();
		m_oLogger = new Logger();
	}
	
	public SystemModelStateHistory getHistory()
	{
		return m_oHistory;
	}

	public TestCaseGraph getTestCaseGraph()
	{
		return m_oTCG;
	}
	
	public VariableReferencer getVariableReferencer()
	{
		return m_colOCLReferencingElements;
	}
	
	public List<TCGTransition> getAllTransitions()
	{
		ArrayList<TCGTransition> colTransitions = new ArrayList<TCGTransition>();
		for(TestCaseRegion oRegion : m_oTCG.getRegions())
			colTransitions.addAll(getAllTransitionsFromTestCaseRegion(oRegion));
		return colTransitions;		
	}
	
	public List<TCGTransition> getAllTransitionsFromTestCaseRegion(TestCaseRegion in_oRegion)
	{
		ArrayList<TCGTransition> colTransitions = new ArrayList<TCGTransition>();
		colTransitions.addAll(in_oRegion.getTransitions());
		for(TCGNode oNode : in_oRegion.getNodes())
		{
			if(oNode instanceof TCGRealNode && ((TCGRealNode)oNode).getSubGraph() != null)
				for(TestCaseRegion oRegion : ((TCGRealNode)oNode).getSubGraph().getRegions())
					colTransitions.addAll(getAllTransitionsFromTestCaseRegion(oRegion));
		}
		return colTransitions;		
	}
	
	public List<TCGNode> getAllNodes()
	{
		ArrayList<TCGNode> colNodes = new ArrayList<TCGNode>();
		for(TestCaseRegion oRegion : m_oTCG.getRegions())
			colNodes.addAll(getAllNodesFromTestCaseRegion(oRegion));
		return colNodes;
	}
	
	public List<TCGNode> getAllNodesFromTestCaseRegion(TestCaseRegion in_oRegion)
	{
		ArrayList<TCGNode> colNodes = new ArrayList<TCGNode>();
		colNodes.addAll(in_oRegion.getNodes());
		for(TCGNode oNode : in_oRegion.getNodes())
		{
			if(oNode instanceof TCGRealNode && ((TCGRealNode)oNode).getSubGraph() != null)
				for(TestCaseRegion oRegion : ((TCGRealNode)oNode).getSubGraph().getRegions())
					colNodes.addAll(getAllNodesFromTestCaseRegion(oRegion));
		}
		return colNodes;
	}
	
	public List<TCGEvent> getAllEvents() {
		List<TCGEvent> colNodes = new ArrayList<TCGEvent>();
		for(TestCaseRegion oRegion : m_oTCG.getRegions()) {
			colNodes.addAll(getAllEventsFromTestCaseRegion(oRegion));
		}		
		return colNodes;
	}
	
	public List<TCGEvent> getAllEventsFromTestCaseRegion(TestCaseRegion in_oRegion)
	{
		List<TCGEvent> colEvents = new ArrayList<TCGEvent>();
		colEvents.addAll(getAllEventsFromTransitionList(in_oRegion.getTransitions()));
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(oNode instanceof TCGRealNode && ((TCGRealNode)oNode).getSubGraph() != null)
				for(TestCaseRegion oRegion : ((TCGRealNode)oNode).getSubGraph().getRegions()) {
					for(TCGEvent oEvent : getAllEventsFromTestCaseRegion(oRegion)) {
						//if(!colEvents.contains(oEvent)) {
						if(!ObjectComparator.contains(colEvents, oEvent)) {
							colEvents.add(oEvent);
						}
					}
				}
		}
		return colEvents;
	}

	public List<TCGEvent> getAllEventsFromTransitionList(List<TCGTransition> in_colTransitions) {
		List<TCGEvent> colEvents = new ArrayList<TCGEvent>();
		for(TCGTransition oTransition : in_colTransitions) {
			for(TCGEvent oEvent : oTransition.getEvents()) {
				//if(!colEvents.contains(oEvent))
				if(!ObjectComparator.contains(colEvents, oEvent)) {
					colEvents.add(oEvent);
				}
			}
		}
		return colEvents;
	}
	
	public TCGRealNode addRealNode(TestCaseRegion in_oRegion)
	{
		TCGRealNode oNode = GeneratedFactory.eINSTANCE.createTCGRealNode();
		in_oRegion.getNodes().add(oNode);
		oNode.setContainer(in_oRegion);
		return oNode;
	}
	
	public void removeRealNode(TCGRealNode in_oRealNode) throws Exception
	{
		in_oRealNode.getContainer().getNodes().remove(in_oRealNode);
		removeNodeTransitions(in_oRealNode);
	}

	public TCGIntermediateNode addIntermediateNode(EObject in_oContainer, TCGNodeType in_eType)
	{
		TCGIntermediateNode oNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
		oNode.setNodeType(in_eType);
		oNode.setContainer(in_oContainer);
		if(in_oContainer instanceof TestCaseRegion) {
			((TestCaseRegion)in_oContainer).getNodes().add(oNode);
		}
		else if(in_oContainer instanceof TCGRealNode) {
			if(in_eType.equals(TCGNodeType.ENTRY) || in_eType.equals(TCGNodeType.EXIT)) {
				((TCGRealNode)in_oContainer).getContainedConnectionPoints().add(oNode);
			}
			else {
				System.err.println("error 1 in addIntermediateNode");
			}
		}
		else {
			System.err.println("error 2 in addIntermediateNode");
		}
		return oNode;
	}

	public void removeIntermediateNode(TCGIntermediateNode in_oIntNode) throws Exception
	{
		EObject oContainer = in_oIntNode.getContainer();
		if(oContainer instanceof TestCaseGraph) {
			((TestCaseGraph)oContainer).getContainedConnectionPoints().remove(in_oIntNode);
		}
		else if(oContainer instanceof TestCaseRegion) {
			((TestCaseRegion)oContainer).getNodes().remove(in_oIntNode);
		}
		else if(oContainer instanceof TCGRealNode) {
			((TCGRealNode)oContainer).getContainedConnectionPoints().remove(in_oIntNode);
			((TCGRealNode)oContainer).getContainedConnectionPointReferences().remove(in_oIntNode);
		}
		removeNodeTransitions(in_oIntNode);
	}
	
	private void removeNodeTransitions(TCGNode in_oNode) throws Exception 
	{
		while(!in_oNode.getIncomingTransitions().isEmpty()) {
			TCGTransition oTransition = in_oNode.getIncomingTransitions().get(0);
			removeTransition(oTransition);
		}
		while(!in_oNode.getOutgoingTransitions().isEmpty()) {
			TCGTransition oTransition = in_oNode.getOutgoingTransitions().get(0);
			removeTransition(oTransition);
		}
	}
	
	public void removeNode(TCGNode in_oNode) throws Exception
	{
		if(in_oNode instanceof TCGRealNode)
			removeRealNode((TCGRealNode)in_oNode);
		else if(in_oNode instanceof TCGIntermediateNode)
			removeIntermediateNode((TCGIntermediateNode)in_oNode);
	}
	
	public TCGTransition addTransition(
			TCGNode in_oSourceNode,
			TCGNode in_oTargetNode) throws Exception
	{
		
		TCGTransition oTransition = GeneratedFactory.eINSTANCE.createTCGTransition();
		TestCaseRegion oRegion = TCGNodeHelperClass.getContainingRegion(in_oSourceNode);
		if(oRegion == null)
			oRegion = TCGNodeHelperClass.getContainingRegion(in_oTargetNode);
		if(oRegion == null)
			throw new Exception("source and target node have no container");
		
		oRegion.getTransitions().add(oTransition);		
		
		oTransition.setSourceNode(in_oSourceNode);
		in_oSourceNode.getOutgoingTransitions().add(oTransition);

		oTransition.setTargetNode(in_oTargetNode);
		in_oTargetNode.getIncomingTransitions().add(oTransition);
		
		return oTransition;
	}

	public void removeTransition(TCGTransition in_oTransition) throws Exception
	{
		in_oTransition.getContainer().getTransitions().remove(in_oTransition);
		
		in_oTransition.getSourceNode().getOutgoingTransitions().remove(in_oTransition);
		in_oTransition.setSourceNode(null);

		in_oTransition.getTargetNode().getIncomingTransitions().remove(in_oTransition);
		in_oTransition.setTargetNode(null);
	}

	
	/*
	 * inserts a transition between an existing transition and the target
	 * node of this existing transition
	 */
	public TCGTransition insertTransitionBetweenTransitionAndTargetNode(
			TCGTransition in_oTransition) throws Exception
	{
		TCGIntermediateNode oNewNode = 
			addIntermediateNode(in_oTransition.getContainer(), TCGNodeType.UNKNOWN);
		oNewNode.setNodeType(TCGNodeType.TEMPORARY);
		
		TCGNode oTCGOldTarget = in_oTransition.getTargetNode();
		in_oTransition.setTargetNode(oNewNode);
		oTCGOldTarget.getIncomingTransitions().remove(in_oTransition);
		oNewNode.getIncomingTransitions().add(in_oTransition);
		return addTransition(oNewNode, oTCGOldTarget);
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
	
	public void incActualStateMachineDepth()
	{
	}
	
	public void decActualStateMachineDepth()
	{
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
		for(Parameter oParameter : in_oOperation.getOwnedParameters()) {
			// do not consider return types
			if(oParameter.getName() != null && !oParameter.getName().isEmpty()) {
				colParameterNames.add(oParameter.getName());
				colParameterTypes.add(oParameter.getType());
			}
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
			if(oVarExp.getReferredVariable() != null) {
				if(oVarExp.getReferredVariable().getRepresentedParameter() != null)
					return (VariableExp)in_oExpression;
			}
			else
				return oVarExp;
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

	public static String getFullEnumerationLiteralName(EnumerationLiteral in_oEnumerationLiteral) 
	{
		StringBuffer oOutBuffer = new StringBuffer();
		// get type namespace
		Namespace oNamespace = in_oEnumerationLiteral.getEnumeration().getNamespace();
		while(oNamespace instanceof org.eclipse.uml2.uml.Class) {
			if(oOutBuffer.length() > 0)
				oOutBuffer.insert(0, ".");
			oOutBuffer.insert(0, oNamespace.getName());
			oNamespace = oNamespace.getNamespace();
		}
		if(oOutBuffer.length() > 0)
			oOutBuffer.append(".");

		// add enumeration and literal
		oOutBuffer.append(in_oEnumerationLiteral.getEnumeration().getName() + "." + in_oEnumerationLiteral.getName());
		return oOutBuffer.toString();
	}
	
	
	public TestGoalManager getTestGoalMgr() {
		return m_oTestGoalMgr;
	}

	public void setTestGoalMgr(TestGoalManager testGoalMgr) {
		m_oTestGoalMgr = testGoalMgr;
	}
	
	public void createVariableReferences()
	{
		List<TestCaseGraph> colGraphs = new ArrayList<TestCaseGraph>();
		m_colOCLReferencingElements.createVariableReferences(getTestCaseGraph(), colGraphs);
	}
	
	public void setDistancesToInit()
	{
		// start at each initial node and set the distance to this node for each encountered node
		BasicDistanceSetter oSetter = new BasicDistanceSetter(m_oTCG);
		oSetter.act();
		oSetter.check();
	}
	
	public void flattenStateMachine(boolean in_bUseStateComposition) throws Exception
	{
		TestCaseGraphFlattener oFlattener = 
			new TestCaseGraphFlattener(in_bUseStateComposition, this);
		oFlattener.flattenTestCaseGraph();
	}
	
	public void splitUpDecisionNodes() throws Exception
	{
		DecisionNodeSplitter oDecisionNodeSplitter =
			new DecisionNodeSplitter(this);
		oDecisionNodeSplitter.splitNodes();
	}
	
	public void createAttributeToGetterReferences(StateMachine in_oStateMachine) throws Exception 
	{
		m_colAttributeGetterReferencer.createAttributeGetterReferences(in_oStateMachine);
	}
	
	public AttributeGetterReferencer getAttributeGetterReferencer()
	{
		return m_colAttributeGetterReferencer;
	}
	
	public Logger getLogger()
	{
		return m_oLogger;
	}

	public void replaceInitialNodesWithConnectionPoints() {
		// search for composite states with initial nodes
		for(TestCaseRegion oRegion : m_oTCG.getRegions()) {
			replaceInitialNodesWithConnectionPointsInRegion(oRegion);
		}
	}

	private void replaceInitialNodesWithConnectionPointsInRegion(TestCaseRegion in_oRegion) {
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(oNode instanceof TCGRealNode) {
				TCGRealNode oRealNode = (TCGRealNode)oNode;
				TestCaseGraph oSubGraph = oRealNode.getSubGraph(); 
				if(oSubGraph != null) {
					// check all sub-regions
					// TODO parallel sub-regions!!!
					if(!oSubGraph.getRegions().isEmpty()) {
						TestCaseRegion oSubRegion = oSubGraph.getRegions().get(0);
						List<TCGIntermediateNode> colInitialNodes = TCGRegionHelperClass.findInitialNodes(oSubRegion);
						if(!colInitialNodes.isEmpty()) {
							// each region is allowed to have at most one initial node
							TCGIntermediateNode oInitialNode = colInitialNodes.get(0);
							// convert initial node into connection point
							oInitialNode.setNodeType(TCGNodeType.ENTRY);
							oInitialNode.setContainer(oRealNode);
							oRealNode.getContainedConnectionPoints().add(oInitialNode);
							oInitialNode.setOriginalNode(null);
							oInitialNode.setUseAllTransitionsInParallel(true);
							// outgoing transitions are the same ...
							// change all incoming transitions of the composite state
							for(TCGTransition oTransition : oRealNode.getIncomingTransitions()) {
								oTransition.setTargetNode(oInitialNode);
								oInitialNode.getIncomingTransitions().add(oTransition);
							}
							oRealNode.getIncomingTransitions().clear();
						}
						// recursion
						replaceInitialNodesWithConnectionPointsInRegion(oSubRegion);
					}
				}
			}
		}
	}

	public void replaceFinalStatesWithConnectionPoints() {
		// search for composite states with final states
		for(TestCaseRegion oRegion : m_oTCG.getRegions()) {
			replaceFinalStatesWithConnectionPointsInRegion(oRegion);
		}
	}

	private void replaceFinalStatesWithConnectionPointsInRegion(
			TestCaseRegion in_oRegion) {
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(oNode instanceof TCGRealNode) {
				TCGRealNode oRealNode = (TCGRealNode)oNode;
				List<TCGTransition> colSuperTransitions = 
					TCGTransitionHelperClass.getDefaultTriggeredOutgoingTransitions(oNode);
				TestCaseGraph oSubGraph = oRealNode.getSubGraph(); 
				if(oSubGraph != null) {
					// check all sub-regions
					// TODO parallel sub-regions!!!
					if(!oSubGraph.getRegions().isEmpty()) {
						TestCaseRegion oSubRegion = oSubGraph.getRegions().get(0);
						if(!colSuperTransitions.isEmpty()) {
							List<TCGNode> colEndNodes = TCGRegionHelperClass.findNodesWithOutOutgoingTransitions(oSubRegion);
							// create outgoing connection point
							TCGIntermediateNode oOutNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
							oOutNode.setOriginalNode(null);
							oOutNode.setUseAllTransitionsInParallel(true);
							oRealNode.getContainedConnectionPoints().add(oOutNode);
							oOutNode.setContainer(oRealNode);
							// create additional connection to outgoing node
							for(TCGNode oEndNode : colEndNodes) {
								try {
									addTransition(oEndNode, oOutNode);
								} catch (Exception e) {
									Configuration.handleException(e);
								}
							}
							// redirect outgoing transitions of super node without triggers
							for(TCGTransition oSuperTransition : colSuperTransitions) {
								oSuperTransition.setSourceNode(oOutNode);
								oRealNode.getOutgoingTransitions().remove(oSuperTransition);
							}
						}
						// recursion
						replaceFinalStatesWithConnectionPointsInRegion(oSubRegion);
					}
				}
			}
		}
	}

	// check the graph for obvious faults
	public void doSanityCheck() throws Exception {
		
		// check for infinite loops of default triggered transitions
		if(hasDefaultTransitionLoop()) {
			throw new Exception("State machine contains an infinite loop of completion transitions.");
		}
	}
	
	private boolean hasDefaultTransitionLoop() {
		
		for(TestCaseRegion oTCR : m_oTCG.getRegions()) {
			for(TCGNode oNode : oTCR.getNodes()) {
				List<TCGNode> colNodes = new ArrayList<TCGNode>();
				if(hasDefaultTransitionLoopHelper(colNodes, oNode))
					return true;
			}
		}
		return false;
	}
	
	private boolean hasDefaultTransitionLoopHelper(
			List<TCGNode> nodesInTheCycle, TCGNode oCurrentNode) {
		
		// check if there is a loop
		if(nodesInTheCycle.contains(oCurrentNode))
			return true;
		
		// add current node to the loop
		nodesInTheCycle.add(oCurrentNode);
		
		for(TCGTransition oTransition : TCGTransitionHelperClass.getDefaultTriggeredOutgoingTransitions(oCurrentNode)) {
			if(hasDefaultTransitionLoopHelper(nodesInTheCycle, oTransition.getTargetNode())) 
				return true;
		}
		
		// remove current node again
		nodesInTheCycle.remove(oCurrentNode);
		
		return false;
	}
}
