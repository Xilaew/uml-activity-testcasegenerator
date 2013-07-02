package net.sf.parteg.base.testcasegraph.ocl.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;

public class TCGOCLVariableClassificator {

	private TCGOCLExpression m_oOCLExpression;
	private HashMap<VariableClassification, ArrayList<TCGOCLAtom>> m_colExpressionClassification;


	public TCGOCLVariableClassificator(TCGOCLExpression in_oOCLExpression)
	{
		// feed all enum values into m_colExpressionClassification
		m_colExpressionClassification = new LinkedHashMap<VariableClassification, ArrayList<TCGOCLAtom>>();
		for(VariableClassification oVarCls : VariableClassification.class.getEnumConstants())
		{
			m_colExpressionClassification.put(oVarCls, new ArrayList<TCGOCLAtom>());
		}
		
		m_oOCLExpression = in_oOCLExpression;
		// TODO entfernen?
		buildMapForClassification(m_oOCLExpression);
	}
	
	public TCGOCLExpression getExpression()
	{
		return m_oOCLExpression;
	}
	
	public TCGOCLOperation getOperation()
	{
		if(m_oOCLExpression instanceof TCGOCLOperation)
		{
			return (TCGOCLOperation)m_oOCLExpression;
		}
		return null;
	}
	
//	public TCGOCLAtom getClassifiedElementInExpression(VariableClassification in_eClassification)
//	{
//		if(m_colExpressionClassification.get(in_eClassification).size() == 1)
//		{
//			return m_colExpressionClassification.get(in_eClassification).get(0);
//		}
//		else
//			return null;
//	}

	public List<TCGOCLAtom> getClassifiedElementsInExpression(VariableClassification in_eClassification)
	{
		return m_colExpressionClassification.get(in_eClassification);
	}

	public void shiftSubexpressionToTheLeft(TCGOCLExpression in_oExpression)
	{
		TCGOCLExpressionHelperClass.shiftSubexpressionToTheLeft(
				in_oExpression, m_oOCLExpression);
	}
	
	
	public boolean expressionIsIsolatedOnLeftSide(TCGOCLExpression in_oOCLExp)
	{
		return TCGOCLExpressionHelperClass.expressionIsIsolatedOnLeftSide(in_oOCLExp, m_oOCLExpression);
	}
	
	public int getNumberOfDependentVariables()
	{
		return m_colExpressionClassification.get(VariableClassification.ACTIVE_DEPENDENT).size() +
		m_colExpressionClassification.get(VariableClassification.PASSIVE_DEPENDENT).size();
	} 
	
	public int getNumberOfInputParameter()
	{
		return m_colExpressionClassification.get(VariableClassification.INPUT_PARAMETER).size();
	}
	
	private void buildMapForClassification(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			buildMapForClassification(oOperation.getLeft());
			buildMapForClassification(oOperation.getRight());
		}
		if(in_oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			m_colExpressionClassification.get(oAtom.getClassification()).add(oAtom);
		}
	}
}
