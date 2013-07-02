package basics;

import java.io.IOException;
import java.util.HashMap;

import net.sf.parteg.base.testcasetree.Configuration;

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

public class TestEcoreXMIGenerationWithHandwrittenCode {

	public static void action()
	{
		// member
		ResourceSet m_oResourceSet;
		Resource m_oResourceEcoreOut;
		//Resource m_oResourceEcoreOut2;
		Resource m_oResourceXMIOut;
		HashMap<String, Boolean> m_oOptions;
		
		// construction
		Configuration.defaultConfig();
		m_oResourceSet = new ResourceSetImpl();
		m_oResourceEcoreOut= m_oResourceSet.createResource(
				URI.createFileURI(
						Configuration.getEcoreOutput("ecore1")));
//		m_oResourceEcoreOut2= m_oResourceSet.createResource(
//				URI.createFileURI(
//						Configuration.getEcoreOutput("ecore2")));
		m_oResourceXMIOut= m_oResourceSet.createResource(
				URI.createFileURI(
						Configuration.getXMIOutput()));
		m_oOptions = new HashMap<String, Boolean>();
		m_oOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

		
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

		// erstes Package, das node, arc und tcg enthält
		EPackage graphPackage = ecoreFactory.createEPackage();
		graphPackage.setName("graph");
		graphPackage.setNsPrefix("graph");
		graphPackage.setNsURI("http:///com.example.graph.ecore");
		graphPackage.getEClassifiers().add(oNodeClass);
		graphPackage.getEClassifiers().add(oArcClass);
		graphPackage.getEClassifiers().add(oTCGClass);
	
		m_oResourceEcoreOut.getContents().add(graphPackage);
		try {
			m_oResourceEcoreOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

		/*
		// zweites Package, das nur node enthält
		EPackage graphPackage2 = ecoreFactory.createEPackage();
		graphPackage2.setName("graph2");
		graphPackage2.setNsPrefix("graph2");
		graphPackage2.setNsURI("http:///com.example.graph2.ecore");
		graphPackage2.getEClassifiers().add(oNodeClass);
	
		m_oResourceEcoreOut2.getContents().add(graphPackage2);
		try {
			m_oResourceEcoreOut2.save(m_oOptions);
		}
		catch(IOException e)
		{}
		 */
		
		

		// get company factory
		EFactory graphFactory = graphPackage.getEFactoryInstance();
		//EFactory graphFactory2 = graphPackage2.getEFactoryInstance();
		
		// using the factory create instance of company class and 
		// set company name
		//EObject company2 = graphFactory2.create(oNodeClass);
		//company2.eSet(oNodeName, "MyNode2");
		EObject company = graphFactory.create(oNodeClass);
		company.eSet(oNodeName, "MyNode");

		// create an instance of employee class
		EObject employee = graphFactory.create(oArcClass);
		//using reflective API initialize name of employee
		employee.eSet(oArcName, "MyArc");

		// create an instance of department class
		
		m_oResourceXMIOut.getContents().add(company);
		m_oResourceXMIOut.getContents().add(employee);
		//m_oResourceXMIOut.getContents().add(company2);
		try {
			m_oOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			m_oResourceXMIOut.save(m_oOptions);
		}
		catch(IOException e)
		{}
	}
}
