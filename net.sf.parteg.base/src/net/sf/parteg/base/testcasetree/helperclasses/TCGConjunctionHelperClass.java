package net.sf.parteg.base.testcasetree.helperclasses;

import net.sf.parteg.base.testcasetree.generated.GeneratedFactory;
import net.sf.parteg.base.testcasetree.generated.TCGConjunction;

public class TCGConjunctionHelperClass {

	public static TCGConjunction copyConjunction(TCGConjunction in_oConjunction)
	{
		TCGConjunction oConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		oConjunction.getExpressions().addAll(in_oConjunction.getExpressions());
		return oConjunction;
	}
}
