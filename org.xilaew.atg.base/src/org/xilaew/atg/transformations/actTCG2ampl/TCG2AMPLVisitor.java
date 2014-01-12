package org.xilaew.atg.transformations.actTCG2ampl;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Iterator;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphSwitch;

class TCG2AMPLVisitor extends ActivityTestCaseGraphSwitch<String> {
	
	  private SecureRandom random = new SecureRandom();

	  protected String randomString()
	  {
	    return new BigInteger(64, random).toString(32);
	  }

	@Override
	public String caseTCGControlFlow(TCGControlFlow object) {
		StringBuilder result = new StringBuilder();
		String name = object.getName();
		AbstractTCGConstraint spec = object.getGuard();
		if (spec != null) {
			result.append("set " + name
					+ " within {0..Pathlength} default {};\n");
			result.append("s.t. ");
			result.append(name + "_guard");
			result.append("{i in " + name + "} : ");
			result.append(doSwitch(spec));
			result.append(";\n");
		}
		return result.toString();
	}

	@Override
	public String caseTCGOCLOperationCallExp(TCGOCLOperationCallExp object) {
		String function = "";
		String source = doSwitch(object.getSource());
		StringBuilder argumentList = new StringBuilder();
		for (Iterator<TCGOCLExpression> it = object.getArguments().iterator(); it
				.hasNext();) {
			TCGOCLExpression arg = it.next();
			argumentList.append(doSwitch(arg));
			if (it.hasNext())
				argumentList.append(", ");
		}
		switch (object.getOperation().getValue()) {
		case TCGOCLOperationType.EQUALS_VALUE:
			function = "=";
			break;
		case TCGOCLOperationType.ADDITION_VALUE:
			function = "+";
			break;
		case TCGOCLOperationType.DIVISION_VALUE:
			function = "/";
			break;
		case TCGOCLOperationType.GREATER_EQUALS_VALUE:
			function = ">=";
			break;
		case TCGOCLOperationType.LESS_EQUALS_VALUE:
			function = "<=";
			break;
		case TCGOCLOperationType.MULTIPLICATION_VALUE:
			function = "*";
			break;
		case TCGOCLOperationType.SUBTRACTION_VALUE:
			function = "-";
			break;
		case TCGOCLOperationType.GREATER_THAN_VALUE:
			function = ">";
			break;
		case TCGOCLOperationType.LESS_THAN_VALUE:
			function = "<";
			break;
		case TCGOCLOperationType.UNEQUAL_VALUE:
			function = "<>";
			break;
		default:
			function = " " + object.getOperation().getLiteral() + " ";
		}
		String result = "(" + source + ")" + function + "(" + argumentList
				+ ")";
		// for Unary functions the function symbol is in front of its source
		if (object.getArguments().isEmpty()) {
			result = function + "(" + source + ")" ;
		}
		return result;
	}

	@Override
	public String caseTCGOCLVariableCallExp(TCGOCLVariableCallExp object) {
		StringBuilder result = new StringBuilder();
		TCGVariable var = object.getVariable();
		result.append(var.getName());
		if (!var.isIsParameter()) {
			result.append("[i");
			if (object.isIsPre()) {
				result.append("-1");
			}
			result.append("]");
		}
		return result.toString();
	}

	@Override
	public String caseTCGOCLLiteralExp(TCGOCLLiteralExp object) {
		StringBuilder result = new StringBuilder();
		result.append(object.getValue());
		return result.toString();
	}

	@Override
	public String caseAbstractTCGElement(AbstractTCGElement object) {
		return "";
	}

	@Override
	public String caseTCGActivity(TCGActivity object) {
		String result = "param Pathlength;\n";
		for (TCGVariable var : object.getVariables()) {
			result = result.concat(doSwitch(var));
		}
		for (AbstractTCGNode node : object.getNodes()) {
			result = result.concat(doSwitch(node));
		}
		for (AbstractTCGEdge edge : object.getEdges()) {
			result = result.concat(doSwitch(edge));
		}
		return result;
	}

	@Override
	public String caseTCGAction(TCGAction object) {
		String result = "";
		String name = object.getName().replaceAll("\\s", "_");
		int i = 0;
		result = result.concat("set " + name
				+ " within {0..Pathlength} default {};\n");
		for (AbstractTCGConstraint spec : object.getLocalPostconditions()) {
			result = result.concat("s.t. " + name + "_post" + i++ + "{i in "
					+ name + "} : " + doSwitch(spec))
					+ ";\n";
		}
		return result;
	}

	@Override
	public String caseTCGBasicVariable(TCGBasicVariable object) {
		// XXX here is some type Handling Code. Maybe it is better centralized
		String typeSpec = null;
		if (object.getVariableType().equals(TCGBasicVariableType.INTEGER))
			typeSpec = " : integer >=-10000, <= 10000";
		if (object.getVariableType().equals(TCGBasicVariableType.BOOLEAN))
			typeSpec = " : integer >=0, <= 1";
		if (object.getVariableType().equals(TCGBasicVariableType.REAL))
			typeSpec = ">=-10000, <= 10000";
		String result = "var " + object.getName()
				+ (object.isIsParameter() ? "" : "{0..Pathlength}") + typeSpec
				+ " := 1;\n";
		return result;
	}

}
