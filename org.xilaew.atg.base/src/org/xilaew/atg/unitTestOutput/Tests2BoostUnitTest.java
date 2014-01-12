/**
 * 
 */
package org.xilaew.atg.unitTestOutput;

import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariableUsage;
import org.xilaew.atg.model.tests.SUT;
import org.xilaew.atg.model.tests.TestCase;
import org.xilaew.atg.model.tests.TestSuite;
import org.xilaew.atg.model.tests.Value;

/**
 * @author TH51E0
 * 
 */
public class Tests2BoostUnitTest {

	public static String generateUnitTest(TestSuite suite) {
		StringBuilder sb = new StringBuilder();
		sb.append(//"#define BOOST_TEST_MAIN MyTest\n" + 
				"#include <boost/test/unit_test.hpp>\n");
		for (SUT sut : suite.getSut()) {
			sb.append("#include \""
					+ sut.getPackageName().replaceAll(":+", "/") + "/"
					+ sut.getName() + ".c\"\n");
		}
		int i = 0;
		for (TestCase t : suite.getTests()) {
			sb.append("BOOST_AUTO_TEST_CASE( test" + i++ + " ){\n");
			// Set<TCGVariable> declaredVars = new HashSet<TCGVariable>();
			// Initialize Fields
			for (Value v : t.getInitValues()) {
				sb.append(v.getName() + " = " + v.getValue() + ";\n");
				// declaredVars.add(v.getVariable());
			}
			// Initialize function Input parameters
			for (Value v : t.getFunction().getParameters()) {
				String type = switchVarType(((TCGBasicVariable) v.getVariable())
						.getVariableType());
				sb.append("const " + type + " " + v.getName() + " = "
						+ v.getValue() + ";\n");
			}
			// Declare Output and Return Variables for function call
			String returnVar = "";
			String paramList = "";
			for (TCGVariable var : t.getFunction().getActivity().getVariables()) {
				if (var.isIsParameter() && var.getUsage()!=TCGVariableUsage.RETURN_PARAMETER){
					if (!paramList.equals("")){paramList+=", ";}
					paramList+="&"+var.getName();
				}
				if (var.getUsage() == TCGVariableUsage.OUT_PARAMETER) {
					String type = switchVarType(((TCGBasicVariable) var).getVariableType());
					sb.append(type + " " + var.getName() + ";\n");
				}
				if (var.getUsage() == TCGVariableUsage.RETURN_PARAMETER) {
					String type = switchVarType(((TCGBasicVariable) var).getVariableType());
					sb.append(type + " " + var.getName() + ";\n");
					returnVar = var.getName()+" = ";
				}
			}
			sb.append(returnVar + t.getFunction().getName() + "("
					+ paramList + ");\n");
			for (Value v : t.getTestForValue()) {
				switch(((TCGBasicVariable) v.getVariable()).getVariableType()){
				case BOOLEAN:
					sb.append("BOOST_CHECK_EQUAL(" + v.getName() + ","
							+ (v.getValue()==0?"false":"true") + ");\n");
					break;
				case INTEGER:
					sb.append("BOOST_CHECK_EQUAL(" + v.getName() + ","
							+ (int)v.getValue() + ");\n");
					break;
				case REAL:
					sb.append("BOOST_WARN_EQUAL(" + v.getName() + ","
							+ v.getValue() + ");\n");
					sb.append("BOOST_CHECK_CLOSE(" + v.getName() + ","
							+ v.getValue() + ", 0.001);\n");
					break;
				default:
					break;
				
				}
			}
			sb.append("}\n");
		}
		sb.append("");
		return sb.toString();
	}

	private static String switchVarType(TCGBasicVariableType type) {
		switch (type) {
		case BOOLEAN:
			return "bool";
		case INTEGER:
			return "int";
		case REAL:
			return "double";
		}
		return null;
	}

}
