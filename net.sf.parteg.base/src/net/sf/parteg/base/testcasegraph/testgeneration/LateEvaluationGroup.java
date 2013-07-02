package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;

/*
 * Each instance of this class describes a group of expressions, 
 * uncovered attributes, and corresponding event input parameter
 * instances.
 * The expressions of each group are used to derive concrete 
 * parameter values after the abstract test generation.
 */
public class LateEvaluationGroup {

	// contains conditions for input parameters that influence each other and
	// that can only be evaluated after the complete test path is created
	private List<TCGOCLExpression> m_colLateSatisfiedConditions;
	
	// contains all elements that have influence on a condition outcome and 
	// for that the corresponding postconditions need to be covered 
	private List<TCGOCLAtom> m_colElementsToFindPostconditionFor;
	
	// map of attributes of the expressions to the corresponding
	// event parameter instances ...
	//private Map<TCGOCLAtom, EventParameterInstance> m_colAtomsToParameter;
	private Map<EventParameterInstance, List<TCGOCLAtom>> m_colParameterToAtom;

	public LateEvaluationGroup() {
		m_colLateSatisfiedConditions = new ArrayList<TCGOCLExpression>();
		m_colElementsToFindPostconditionFor = new ArrayList<TCGOCLAtom>();
//		m_colAtomsToParameter = new LinkedHashMap<TCGOCLAtom, EventParameterInstance>();
		m_colParameterToAtom = new LinkedHashMap<EventParameterInstance, List<TCGOCLAtom>>();
	}

	public LateEvaluationGroup copy() {
		LateEvaluationGroup oOtherGroup = new LateEvaluationGroup();
		oOtherGroup.getLateSatisfiedConditions().addAll(
				getLateSatisfiedConditions());
		oOtherGroup.getElementsToFindPostconditionFor().addAll(
				getElementsToFindPostconditionFor());
		oOtherGroup.getParameterToAtoms().putAll(
				getParameterToAtoms());
		return oOtherGroup;
	}
	
	public List<TCGOCLExpression> getLateSatisfiedConditions() {
		return m_colLateSatisfiedConditions;
	}

	public List<TCGOCLAtom> getElementsToFindPostconditionFor() {
		return m_colElementsToFindPostconditionFor;
	}

	public Map<EventParameterInstance, List<TCGOCLAtom>> getParameterToAtoms() {
		return m_colParameterToAtom;
	}

	public void addGroupValues(LateEvaluationGroup in_oOtherGroup) {
		getElementsToFindPostconditionFor().addAll(
				in_oOtherGroup.getElementsToFindPostconditionFor());
		getLateSatisfiedConditions().addAll(
				in_oOtherGroup.getLateSatisfiedConditions());
		getParameterToAtoms().putAll(
				in_oOtherGroup.getParameterToAtoms());
	}
	
}
