package net.sf.parteg.base.testcasegraph.helperclasses;

import net.sf.parteg.base.testcasegraph.config.Configuration;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Classifier;

public class UMLActivityHelperClass {
	
	public static String getFullName(Activity in_oActivity)
	{
		if(in_oActivity.getNamespace() instanceof Activity)
			return UMLActivityHelperClass.getFullName((Activity) in_oActivity.getNamespace()) + "::" + in_oActivity.getName();
		if(in_oActivity.getNamespace() instanceof Classifier)
			return in_oActivity.getNamespace().getName() + "::" + in_oActivity.getName();
		return "";
	}

	public static org.eclipse.uml2.uml.Package getPackageOfActivity(Activity in_oActivity) {
		org.eclipse.uml2.uml.Package oActivityContext = in_oActivity.getNearestPackage();
		if(oActivityContext == null) {
			oActivityContext = in_oActivity.getModel();
		} 
		if(oActivityContext == null) {
			Configuration.handleException(
					new Exception("context package of state machine cannot be identified"));
		}
		while(oActivityContext.getOwner() instanceof org.eclipse.uml2.uml.Package) {
			oActivityContext = (org.eclipse.uml2.uml.Package)(oActivityContext.getOwner());
		}

		return oActivityContext;
	}
	
}
