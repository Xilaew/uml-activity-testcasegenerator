package org.eclipse.atg.model;

import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.util.ActivityTestCaseGraphSwitch;

public class TCGOCLTypeEvaluatorVisitor extends ActivityTestCaseGraphSwitch<String>{

	@Override
	public String caseTCGOCLOperationCallExp(TCGOCLOperationCallExp object) {
		switch(object.getOperation().getValue()){
		
		}
		// TODO Auto-generated method stub
		return super.caseTCGOCLOperationCallExp(object);
	}

	@Override
	public String caseTCGOCLVariableCallExp(TCGOCLVariableCallExp object) {
		// TODO Auto-generated method stub
		return super.caseTCGOCLVariableCallExp(object);
	}

	@Override
	public String caseTCGOCLLiteralExp(TCGOCLLiteralExp object) {
		// TODO Auto-generated method stub
		return super.caseTCGOCLLiteralExp(object);
	}

}
