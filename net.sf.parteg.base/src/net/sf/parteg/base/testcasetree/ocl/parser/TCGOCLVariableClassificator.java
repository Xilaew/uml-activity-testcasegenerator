package net.sf.parteg.base.testcasetree.ocl.parser;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.parteg.base.testcasetree.ocl.ExpressionConverter;
import net.sf.parteg.base.testcasetree.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;

import org.eclipse.uml2.uml.Operation;

public class TCGOCLVariableClassificator {

	private TCGOCLExpression m_oOCLExpression;
	private HashMap<VariableClassification, ArrayList<TCGOCLExpression>> m_colExpressionClassification;
	private static HashMap<String, String> sm_colCorrespondingRelations = initializeRelations();
	private static HashMap<String, String> sm_colCorrespondingOperations = initializeOperations();
	
	private static HashMap<String, String> initializeRelations()
	{
		HashMap<String, String> colCorrespondingRelations = new HashMap<String, String>();
		colCorrespondingRelations.put("<", ">");
		colCorrespondingRelations.put("<=", ">=");
		colCorrespondingRelations.put("=", "=");
		colCorrespondingRelations.put(">=", "<=");
		colCorrespondingRelations.put(">", "<");
		return colCorrespondingRelations;
	}

	private static HashMap<String, String> initializeOperations()
	{
		HashMap<String, String> colCorrespondingOperations = new HashMap<String, String>();
		colCorrespondingOperations.put("+", "-");
		colCorrespondingOperations.put("-", "+");
		colCorrespondingOperations.put("*", "/");
		colCorrespondingOperations.put("/", "*");
		return colCorrespondingOperations;
	}

	public TCGOCLVariableClassificator(TCGOCLExpression in_oOCLExpression)
	{
		// feed all enum values into m_colExpressionClassification
		m_colExpressionClassification = new HashMap<VariableClassification, ArrayList<TCGOCLExpression>>();
		for(VariableClassification oVarCls : VariableClassification.class.getEnumConstants())
		{
			m_colExpressionClassification.put(oVarCls, new ArrayList<TCGOCLExpression>());
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
	
	public TCGOCLExpression getClassifiedElementInExpression(VariableClassification in_eClassification)
	{
		if(m_colExpressionClassification.get(in_eClassification).size() == 1)
		{
			return m_colExpressionClassification.get(in_eClassification).get(0);
		}
		else
			return null;
	}
	
	public void shiftSubexpressionToTheLeft(TCGOCLExpression in_oExpression)
	{
		// TODO boolesche Verknüpfungen noch beachten

		if(m_oOCLExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)m_oOCLExpression;
			if(oOpExp.getLeft() != null)
			{
				// first step: get variable on the left side
				OCLTreeExpressionFindObjectVisitor oVisitor = new OCLTreeExpressionFindObjectVisitor(in_oExpression);
				OCLTreeExpressionIterator.run(oOpExp.getLeft(), oVisitor);
				// variable was not found on the left-hand side -> exchange both sides of the expression
				if(!oVisitor.isFound())
				{
					exchangeSidesOfExpression(oOpExp);
				}
				
				// variable is now on the left side -> now handle all mathematical expressions to isolate variable
				while(!expressionIsIsolatedOnLeftSide(in_oExpression))
				{
					transferLeftNonVariableToRightSide(oOpExp, in_oExpression);
				}
			}
		}
	}
	
	public static void exchangeSidesOfExpression(TCGOCLOperation in_oOpExp)
	{
		TCGOCLExpression o1 = in_oOpExp.getLeft();
		in_oOpExp.setLeft(in_oOpExp.getRight());
		in_oOpExp.setRight(o1);
		in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()));
	}
	
	private void transferLeftNonVariableToRightSide(
			TCGOCLOperation in_oOpExp, 
			TCGOCLExpression in_oVariable)
	{
		if(in_oOpExp.getLeft() instanceof TCGOCLOperation)
		{
			// noch beachten: variable nur mit Negationszeichen!
			
			TCGOCLOperation oOpLeftExp = (TCGOCLOperation)in_oOpExp.getLeft();
			OCLTreeExpressionFindObjectVisitor oVisitor = new OCLTreeExpressionFindObjectVisitor(in_oVariable);
			OCLTreeExpressionIterator.run(oOpLeftExp.getLeft(), oVisitor);
			// variable is on local right side -> exchange on left hand side left and right
			if(!oVisitor.isFound())
			{
				// exchange sides
				TCGOCLExpression oLeftSide = oOpLeftExp.getLeft();
				oOpLeftExp.setLeft(oOpLeftExp.getRight());
				oOpLeftExp.setRight(oLeftSide);
				// influence relation operator correspondingly
				if(oOpLeftExp.getOperationName().equals("+") || oOpLeftExp.getOperationName().equals("*"))
				{
					// nothing
				}
				else if(oOpLeftExp.getOperationName().equals("-"))
				{
					in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()));
					in_oOpExp.setRight(ExpressionConverter.negateTCGOCLExpression(in_oOpExp.getRight()));
				}
				else if(oOpLeftExp.getOperationName().equals("/"))
				{
					// TODO #### Fallunterscheidung einbauen
				}
			}
				
			OCLTreeExpressionIterator.run(oOpLeftExp.getLeft(), oVisitor);
			// variable is on local left side -> transfer local right side to the right
			if(oVisitor.isFound())
			{
				TCGOCLExpression oLeftSide = oOpLeftExp.getLeft();
				oOpLeftExp.setLeft(in_oOpExp.getRight());
				in_oOpExp.setRight(oOpLeftExp);
				in_oOpExp.setLeft(oLeftSide);
				oOpLeftExp.setOperationName(sm_colCorrespondingOperations.get(oOpLeftExp.getOperationName()));
				// multiplication or division with a negative number?
				if((oOpLeftExp.getOperationName().compareTo("*") == 0) || 
					(oOpLeftExp.getOperationName().compareTo("/") == 0))
				{
					// moved expression was negative
					if(expressionIsNegative(oOpLeftExp.getRight()))
					{
						// exchange relation symbol
						in_oOpExp.setOperationName(sm_colCorrespondingRelations.get(in_oOpExp.getOperationName()));
					}
				}
			}
			// variable is on right side
			else
			{
				// TODO #### Problem: Wenn durch Variable geteilt wird, dann wird Fallunterscheidung notwendig
				// (aus 1/x<5 folgt (x > 1/5 oder x < 0))
			}
		}
	}
	
	private boolean expressionIsNegative(TCGOCLExpression in_oExpression)
	{
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExpression;
			if((oOpExp.getLeft() == null || oOpExp.getRight() == null) && 
					(((Operation)oOpExp.getOperation()).getName().compareTo("-") == 0))
			{
				return true;
			}
		}
		// TODO ausrechnen ob in_oExpression einen negativen Wert darstellt
		return false;
	}
	
	public boolean expressionIsIsolatedOnLeftSide(TCGOCLExpression in_oOCLExp)
	{
		// TODO bisher ohne boolesche Ausdrücke betrachtet
		if(m_oOCLExpression instanceof TCGOCLOperation)
		{
			if(((TCGOCLOperation)m_oOCLExpression).getLeft() == null)
				return false;
			else if(((TCGOCLOperation)m_oOCLExpression).getLeft().equals(in_oOCLExp))
			{
				return true;
			}
			else
				return false;
		}
		else if(m_oOCLExpression instanceof TCGOCLAtom)
			return true;
		
		return false;
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
