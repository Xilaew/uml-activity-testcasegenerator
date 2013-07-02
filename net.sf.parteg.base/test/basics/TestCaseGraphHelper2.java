package basics;

import java.io.IOException;
import java.util.HashMap;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class TestCaseGraphHelper2 {

	private ResourceSet m_oResourceSet;
	private Resource m_oResourceEcoreOut;
	private Resource m_oResourceXMIOut;
	private HashMap<String, Boolean> m_oOptions;
	
	public TestCaseGraphHelper2()
	{
		Configuration.defaultConfig();
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

	}
	
	public void loadSourceEcore()
	{
		/*try {
			m_oResourceEcoreIn.load(m_oOptions);
		}
		catch(IOException e)
		{}*/
	}

	public void createMetamodel()
	{
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;

		// create TCGNode
		EClass oNodeClass = ecoreFactory.createEClass();
		oNodeClass.setName("TCGNode");
		
		// attribute name of TCGNode
		EAttribute oNodeName = ecoreFactory.createEAttribute();
		oNodeName.setName("name");
		oNodeName.setEType(ecorePackage.getEString());
		oNodeClass.getEStructuralFeatures().add(oNodeName);
		
		// reference incoming arc of node
		//EReference o
		
		// create TCGArc
		EClass oArcClass = ecoreFactory.createEClass();
		oArcClass.setName("TCGArc");
		
		// attribute name of TCGArc
		EAttribute oArcName = ecoreFactory.createEAttribute();
		oArcName.setName("name");
		oArcName.setEType(ecorePackage.getEString());
		oArcClass.getEStructuralFeatures().add(oArcName);
		
		// reference source of TCGArc
		EReference oArcSource = ecoreFactory.createEReference();
		oArcSource.setName("source");
		oArcSource.setEType(oNodeClass);
		oArcSource.setLowerBound(1);
		oArcSource.setUpperBound(1);
		
		// reference target of TCGArc
		EReference oArcTarget = ecoreFactory.createEReference();
		oArcTarget.setName("target");
		oArcTarget.setEType(oNodeClass);
		oArcTarget.setLowerBound(1);
		oArcTarget.setUpperBound(1);
		
		// create TestCaseGraph
		EClass oTCGClass = ecoreFactory.createEClass();
		oTCGClass.setName("TestCaseGraph");
		
		// a test case graph refrences the root node
		EReference oRootReference = ecoreFactory.createEReference();
		oRootReference.setName("root");
		oRootReference.setEType(oNodeClass);
		oRootReference.setLowerBound(1);
		oRootReference.setUpperBound(1);

	
		m_oResourceEcoreOut.getContents().add(oNodeClass);
		m_oResourceEcoreOut.getContents().add(oArcClass);
		m_oResourceEcoreOut.getContents().add(oTCGClass);
		try {
			m_oResourceEcoreOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

		
		
		EPackage companyPackage = ecoreFactory.createEPackage();
		companyPackage.setName("company");
		companyPackage.setNsPrefix("company");
		companyPackage.setNsURI("http:///com.example.company.ecore");
		companyPackage.getEClassifiers().add(oNodeClass);
		companyPackage.getEClassifiers().add(oArcClass);
		companyPackage.getEClassifiers().add(oTCGClass);

		// get company factory
		EFactory companyFactory = companyPackage.getEFactoryInstance();
		//companyFactory.
		
		// using the factory create instance of company class and 
		// set company name
		EObject company = companyFactory.create(oNodeClass);
		company.eSet(oNodeName, "MyCompany");

		// create an instance of employee class
		EObject employee = companyFactory.create(oArcClass);
		//using reflective API initialize name of employee
		employee.eSet(oArcName, "John");

		// create an instance of department class
		
		m_oResourceXMIOut.getContents().add(company);
		m_oResourceXMIOut.getContents().add(employee);
		try {
			m_oResourceXMIOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

	}
	
	public void createTargetEcore()
	{
		//m_oResourceEcoreOut.getContents().addAll(m_oResourceEcoreIn.getContents());
		m_oResourceEcoreOut.getContents().addAll(GeneratedPackage.eINSTANCE.eContents());
		
		try {
			m_oResourceEcoreOut.save(m_oOptions);
		}
		catch(IOException e)
		{}
	}
	
	public void createTestTargetXMI()
	{
		
		//EPackage oPackage = (EPackage)m_oResourceEcoreOut.getContents().get(0).eContents().get(0).eContents().get(0).eContents().get(0);
		/*
		Iterator<EObject> oClassIter = oPackage.eContents().iterator();
		while(oClassIter.hasNext())
		{
			EClass 
		}
		*/
		/*
		EClass oNodeClass = (EClass)oPackage.eContents().get(0);
		EClass oTestCaseGraphClass = (EClass)oPackage.eContents().get(1);
		EClass oTransitionClass = (EClass)oPackage.eContents().get(2);
		
		EReference oTCGNodes = oTestCaseGraphClass.getEAllReferences().get(0);
		
		
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

		EFactory packageFactory = oPackage.getEFactoryInstance();

		EObject oTestCaseGraph = packageFactory.create(oTestCaseGraphClass);
		
		EObject oNode = packageFactory.create(oNodeClass);
		((List)oTestCaseGraph.eGet(oTCGNodes)).add(oNode);
		
		//m_oResourceXMIOut.getContents().add(oTestCaseGraph);
		*/
		
		EFactory companyFactory = GeneratedPackage.eINSTANCE.getGeneratedFactory();
		
		EObject oNode = companyFactory.create(GeneratedPackage.eINSTANCE.getTCGNode());
		oNode.eSet(GeneratedPackage.eINSTANCE.getTCGNode_Name(), "testname");
		
		m_oResourceXMIOut.getContents().add(oNode);
		//EObject oTCG = companyFactory.create(GeneratedPackage.eINSTANCE.getTestCaseGraph());
		//oTCG.eSet(GeneratedPackage.eINSTANCE.g, newValue)
		/*
		TCGNode oTCGNode = GeneratedFactory.eINSTANCE.createTCGNode();
		oTCG.setRoot(oTCGNode);
		TestCaseGraphHelper.addNode(oTCG, oTCGNode);
		TCGTransition oTCGTransition = GeneratedFactory.eINSTANCE.createTCGTransition();
		TestCaseGraphHelper.addTransition(oTCGNode, oTCGNode, oTCGTransition);
		
		m_oResourceXMIOut.getContents().add(oTCG);
		m_oResourceXMIOut.getContents().add(oTCGNode);
		m_oResourceXMIOut.getContents().add(oTCGNode);
		m_oResourceXMIOut.getContents().add(oTCGNode);
		m_oResourceXMIOut.getContents().add(oTCGTransition);
		*/
		//m_oResourceXMIOut.
		//m_oResourceXMIOut.getContents().addAll(m_oResourceEcoreOut.getContents());
		// save
		try {
			m_oResourceXMIOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

	}
	
}
