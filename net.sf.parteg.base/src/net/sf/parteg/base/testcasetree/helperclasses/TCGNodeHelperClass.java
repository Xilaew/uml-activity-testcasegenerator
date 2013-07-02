package net.sf.parteg.base.testcasetree.helperclasses;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.SystemModelHelper;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.ocl.parser.OCLParser;
import net.sf.parteg.base.testcasetree.ocl.transformation.TransformOCLToTCGOCL;

import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.uml2.uml.Vertex;

public class TCGNodeHelperClass {

	public static void setInvariantForTCGNode(
			Vertex in_oVertex,
			org.eclipse.uml2.uml.Class in_oContextClass,
			TCGNode in_oTCGNode) throws Exception
	{
		OCLExpression oExpression = OCLParser.parseCondition(
				SystemModelHelper.getStateInvariant(in_oVertex), 
				in_oContextClass, Configuration.getOCLGuardId());
		TCGOCLExpression oTCGOCLExp = TransformOCLToTCGOCL.transformExpression(
				oExpression, Configuration.getOCLGuardId(), in_oContextClass);
		in_oTCGNode.setInvariant(oTCGOCLExp);
	}
}
