package basics;
//package modelcoupling.uml.statesclasses.tests;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import modelcoupling.uml.statesclasses.parser.DynamicParserContext;
//import modelcoupling.uml.statesclasses.parser.OCLParser;
//
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EFactory;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.EcoreFactory;
//import org.eclipse.emf.ecore.EcorePackage;
//import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
//import org.eclipse.ocl.ecore.Constraint;
//import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
//import org.eclipse.ocl.ecore.OCL;
//import org.eclipse.ocl.expressions.OCLExpression;
//
//import org.eclipse.uml2.uml.Class;
//import org.eclipse.uml2.uml.Operation;
//import org.eclipse.uml2.uml.Property;
//import org.eclipse.uml2.uml.Type;
//import org.eclipse.uml2.uml.UMLFactory;
//
//public class DynamicParserTest {
//
//	public static void runParseTest()
//	{
//		try{
//			EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
//			EcorePackage ecorePackage = EcorePackage.eINSTANCE;
//
//			// create TCGNode
//			EClass oNodeClass = ecoreFactory.createEClass();
//			oNodeClass.setName("TCGNode");
//			
//			// attribute name of TCGNode
//			EAttribute oNodeName = ecoreFactory.createEAttribute();
//			oNodeName.setName("name");
//			oNodeName.setEType(ecorePackage.getEString());
//			oNodeClass.getEStructuralFeatures().add(oNodeName);
//			
//			// create TCGArc
//			EClass oArcClass = ecoreFactory.createEClass();
//			oArcClass.setName("TCGArc");
//			
//			// attribute name of TCGArc
//			EAttribute oArcName = ecoreFactory.createEAttribute();
//			oArcName.setName("name");
//			oArcName.setEType(ecorePackage.getEString());
//			oArcClass.getEStructuralFeatures().add(oArcName);
//			
//			// reference source of TCGArc
//			EReference oArcSource = ecoreFactory.createEReference();
//			oArcSource.setName("source");
//			oArcSource.setEType(oNodeClass);
//			oArcSource.setLowerBound(1);
//			oArcSource.setUpperBound(1);
//			oArcClass.getEStructuralFeatures().add(oArcSource);
//			
//			// reference target of TCGArc
//			EReference oArcTarget = ecoreFactory.createEReference();
//			oArcTarget.setName("target");
//			oArcTarget.setEType(oNodeClass);
//			oArcTarget.setLowerBound(1);
//			oArcTarget.setUpperBound(1);
//			oArcClass.getEStructuralFeatures().add(oArcTarget);
//			
//			// create TestCaseGraph
//			EClass oTCGClass = ecoreFactory.createEClass();
//			oTCGClass.setName("TestCaseGraph");
//			
//			// a test case graph refrences the root node
//			EReference oRootReference = ecoreFactory.createEReference();
//			oRootReference.setName("root");
//			oRootReference.setEType(oNodeClass);
//			oRootReference.setLowerBound(1);
//			oRootReference.setUpperBound(1);
//
//			EPackage graphPackage = ecoreFactory.createEPackage();
//			graphPackage.setName("graph");
//			graphPackage.setNsPrefix("graph");
//			graphPackage.setNsURI("http:///com.example.graph.ecore");
//			graphPackage.getEClassifiers().add(oNodeClass);
//			graphPackage.getEClassifiers().add(oArcClass);
//			graphPackage.getEClassifiers().add(oTCGClass);
//		
//			// get company factory
//			EFactory graphFactory = graphPackage.getEFactoryInstance();
//			
//			// using the factory create instance of company class and 
//			// set company name
//			EObject oNode = graphFactory.create(oNodeClass);
//			oNode.eSet(oNodeName, "MyNode");
//
//			// create an instance of employee class
//			EObject oArc = graphFactory.create(oArcClass);
//			//using reflective API initialize name of employee
//			oArc.eSet(oArcName, "MyArc");			
//			
//			// ##################################
//			EObject oContext = oArc;
//			String sExpression = "self.source = self.source";
//			
//		    OCL ocl = OCL.newInstance(new EcoreEnvironmentFactory(
//		    		new EPackageRegistryImpl(EPackage.Registry.INSTANCE)));
//		            /*new EPackageRegistryImpl(
//		                    context.eResource().getResourceSet().getPackageRegistry(),
//		                    EPackage.Registry.INSTANCE)));*/
//			OCL.Helper helper = ocl.createOCLHelper();
//			
//			// set our helper's context classifier to parse against it
//			helper.setContext(oContext.eClass());
//			OCLExpression<EClassifier> parsed = helper.createQuery(sExpression);
//			
//			int x = 42;
//		}
//		catch(Exception e)
//		{
//			System.out.print(e.getLocalizedMessage());
//		}
//	}
//	
//	public static boolean runMappingAttributeTest() throws Exception
//	{
//		Class oClassA = UMLFactory.eINSTANCE.createClass();
//		oClassA.setName("A");
//		Class oClassB = UMLFactory.eINSTANCE.createClass();
//		oClassB.setName("B");
//		Class oClassC = UMLFactory.eINSTANCE.createClass();
//		oClassC.setName("C");
//
//		oClassA.createOwnedAttribute("b", oClassB);
//		oClassA.createOwnedAttribute("c", oClassC);
//		oClassB.createOwnedAttribute("a", oClassA);
//		oClassB.createOwnedAttribute("c", oClassC);
//		oClassC.createOwnedAttribute("a", oClassA);
//		oClassC.createOwnedAttribute("b", oClassB);
//
//		DynamicParserContext oContext = new DynamicParserContext();
//		oContext.addContext(oClassA);
//		
//		if(oContext.getEClassForType(oClassA).getName() != oClassA.getName())
//			return false;
//		if(oContext.getEClassForType(oClassB).getName() != oClassB.getName())
//			return false;
//		if(oContext.getEClassForType(oClassC).getName() != oClassC.getName())
//			return false;
//		
//		Constraint oExp = OCLParser.parseClassExpression(oContext.getEClassForType(oClassA), "self.c.b.a = self");
//		// instance necessary -> class not sufficient
//		//OCLExpression<EClassifier> oExp = OCLParser.parseClassExpression(oContext.getContextForType(oClassA).eClass(), "self.c.b.a = self");
//
//		int x = 42;
//		
//		return true;
//	}
//
//	public static boolean runMappingMethodTest() throws Exception
//	{
//		Class oClassA = UMLFactory.eINSTANCE.createClass();
//		oClassA.setName("A");
//		Class oClassB = UMLFactory.eINSTANCE.createClass();
//		oClassB.setName("B");
//		Class oClassC = UMLFactory.eINSTANCE.createClass();
//		oClassC.setName("C");
//
//		oClassA.createOwnedAttribute("b", oClassB);
//		oClassA.createOwnedAttribute("c", oClassC);
//		oClassB.createOwnedAttribute("a", oClassA);
//		oClassB.createOwnedAttribute("c", oClassC);
//		oClassC.createOwnedAttribute("a", oClassA);
//		oClassC.createOwnedAttribute("b", oClassB);
//		
//		EList<String> colParameterNames = new BasicEList<String>(); 
//		colParameterNames.add("par1");
//		colParameterNames.add("par2");
//		EList<Type> colParameterTypes = new BasicEList<Type>();
//		colParameterTypes.add(oClassB);
//		colParameterTypes.add(oClassC);
//		
//		//Operation oOp = oClassA.createOwnedOperation("foo", colParameterNames, colParameterTypes);
//		Operation oOp = oClassA.createOwnedOperation("foo", colParameterNames, colParameterTypes, oClassB);
//		oOp.getName();
//
//		DynamicParserContext oContext = new DynamicParserContext();
//		oContext.addContext(oClassA);
//		
//		if(oContext.getEClassForType(oClassA).getName() != oClassA.getName())
//			return false;
//		if(oContext.getEClassForType(oClassB).getName() != oClassB.getName())
//			return false;
//		if(oContext.getEClassForType(oClassC).getName() != oClassC.getName())
//			return false;
//
//		//DynamicParserContext oParserContext = new DynamicParserContext();
//		//oParserContext.addContext(oClassA);
//		Constraint oExp = OCLParser.parseClassExpression(oContext.getEClassForType(oClassA), "self.foo(self.b, self.c) = self.b");
//		EClass oClass = oContext.getEClassForType(oClassA);
//		Constraint oConstraint = OCLParser.parseMethodExpression(oContext.getMethodContextForMethod(oOp), "self.b = par1");
//		//oInstance.getClass().
//		//oExp.getStartPosition();
//		
//		return true;
//	}
//
//	public static boolean runUMLAttributeTest() throws Exception
//	{
//		Class oClassA = UMLFactory.eINSTANCE.createClass();
//		oClassA.setName("A");
//		Class oClassB = UMLFactory.eINSTANCE.createClass();
//		oClassB.setName("B");
//		Class oClassC = UMLFactory.eINSTANCE.createClass();
//		oClassC.setName("C");
//
//		oClassA.createOwnedAttribute("b", oClassB);
//		oClassA.createOwnedAttribute("c", oClassC);
//		oClassB.createOwnedAttribute("a", oClassA);
//		oClassB.createOwnedAttribute("c", oClassC);
//		oClassC.createOwnedAttribute("a", oClassA);
//		oClassC.createOwnedAttribute("b", oClassB);
//
//		DynamicParserContext oContext = new DynamicParserContext();
//		oContext.addContext(oClassA);
//		
//		if(oContext.getEClassForType(oClassA).getName() != oClassA.getName())
//			return false;
//		if(oContext.getEClassForType(oClassB).getName() != oClassB.getName())
//			return false;
//		if(oContext.getEClassForType(oClassC).getName() != oClassC.getName())
//			return false;
//		
//		Constraint oExp = OCLParser.parseClassExpression(oContext.getEClassForType(oClassA), "self.c.b.a = self");
//		// instance necessary -> class not sufficient
//		//OCLExpression<EClassifier> oExp = OCLParser.parseClassExpression(oContext.getContextForType(oClassA).eClass(), "self.c.b.a = self");
//
//		int x = 42;
//		
//		return true;
//	}	
//
//	/**
//	 * runs on an instance of an ecore model
//	 * @return
//	 * @throws Exception
//	 */
//	public static boolean runEcoreInstanceAttributeTest() throws Exception
//	{
//		// structure
//		EClass oClassClass = EcoreFactory.eINSTANCE.createEClass();
//		oClassClass.setName("Class");
//		EClass oAttributeClass = EcoreFactory.eINSTANCE.createEClass(); 
//		oAttributeClass.setName("Attribute");
//
//		EReference oReference = EcoreFactory.eINSTANCE.createEReference();
//		oReference.setName("attribute");
//		oReference.setEType(oAttributeClass);
//		oReference.setLowerBound(0);
//		oReference.setUpperBound(-1);
//		oClassClass.getEStructuralFeatures().add(oReference);
//
//		// package
//		EPackage graphPackage = EcoreFactory.eINSTANCE.createEPackage();
//		graphPackage.setName("graph");
//		graphPackage.setNsPrefix("graph");
//		graphPackage.setNsURI("http:///com.example.graph.ecore");
//		graphPackage.getEClassifiers().add(oClassClass);
//		graphPackage.getEClassifiers().add(oAttributeClass);
//	
//		// get factory
//		EFactory oGraphFactory = graphPackage.getEFactoryInstance();
//		
//		// instance
//		EObject oClass = oGraphFactory.create(oClassClass); 
//		EObject oAttributeA = oGraphFactory.create(oAttributeClass);
//		EObject oAttributeB = oGraphFactory.create(oAttributeClass);
//		ArrayList<EObject> oList = new ArrayList<EObject>();
//		oList.add(oAttributeA);
//		oList.add(oAttributeB);
//		oClass.eSet(oReference, oList);
//		
//		// funktioniert nicht - man muss eine Metaebene höher sein ...
//		Constraint oExp = OCLParser.parseClassExpression(oClass.eClass(), "self.a = self.b");
//		// instance necessary -> class not sufficient
//		//OCLExpression<EClassifier> oExp = OCLParser.parseClassExpression(oContext.getContextForType(oClassA).eClass(), "self.c.b.a = self");
//
//		int x = 42;
//		
//		return true;
//	}	
//	
//}
