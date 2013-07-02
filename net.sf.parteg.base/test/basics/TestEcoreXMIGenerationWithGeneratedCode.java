package basics;

import java.io.IOException;
import java.util.HashMap;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGNode;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class TestEcoreXMIGenerationWithGeneratedCode {
	
	public static void action()
	{
		// member
		ResourceSet m_oResourceSet;
		Resource m_oResourceEcoreOut;
		Resource m_oResourceXMIOut;
		HashMap<String, Boolean> m_oOptions;

		// construction
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

		// save ecore
		//m_oResourceEcoreOut.getContents().addAll(GeneratedPackage.eINSTANCE.eContents());
		/*EPackage graphPackage = GeneratedPackage.eINSTANCE;
		graphPackage.setName("graph");
		graphPackage.setNsPrefix("graph");
		graphPackage.setNsURI("http:///com.example.graph.ecore");
		graphPackage.getEClassifiers().add(GeneratedPackage.eINSTANCE.getTCGNode());
		*/

		// notwendig !
		GeneratedPackage.eINSTANCE.setNsURI("http://irgendwas");
		m_oResourceEcoreOut.getContents().add(GeneratedPackage.eINSTANCE);
		//m_oResourceEcoreOut.getContents().add(graphPackage);
		try {
			m_oResourceEcoreOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

		// create instance
		/*EFactory companyFactory = GeneratedPackage.eINSTANCE.getGeneratedFactory();
		
		EObject oNode = companyFactory.create(GeneratedPackage.eINSTANCE.getTCGNode());
		oNode.eSet(GeneratedPackage.eINSTANCE.getTCGNode_Name(), "testname");
		*/
		
		TCGNode oNode = GeneratedFactory.eINSTANCE.createTCGNode();
		oNode.setName("testname2");
		
		// save instance
		m_oResourceXMIOut.getContents().add(oNode);
		try {
			m_oOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			m_oResourceXMIOut.save(m_oOptions);
		}
		catch(IOException e)
		{}

		
	}
}
