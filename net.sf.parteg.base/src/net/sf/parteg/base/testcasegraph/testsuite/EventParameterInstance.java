package net.sf.parteg.base.testcasegraph.testsuite;

import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRangeFactory;

public class EventParameterInstance {

	private TCGParameter m_oParameter;
	private ValueTypeRange m_oValueRange;
	private TransitionInstance m_oTransitionInstance;
	
	public EventParameterInstance(
			TCGParameter in_oParameter,
			TransitionInstance in_oTransitionInstance)
	{
		m_oParameter = in_oParameter;
		m_oValueRange = ValueTypeRangeFactory.createValueTypeRangeForParameter(
				in_oParameter);
		m_oTransitionInstance = in_oTransitionInstance;
	}
	
	public TCGParameter getParameter()
	{
		return m_oParameter;
	}
	
	public TCGParameter getSuperParameter()
	{
		TCGParameter oRetValue = m_oParameter;
		while(oRetValue.getContainer() != null)
		{
			oRetValue = oRetValue.getContainer();
		}
		return oRetValue;
	}
	
	public ValueTypeRange getValueRange()
	{
		return m_oValueRange;
	}
	
	public TransitionInstance getTransitionInstance()
	{
		return m_oTransitionInstance;		
	}
	
	public boolean isReturnParameter() {
		return getParameter().getName() == null ||
			getParameter().getName().isEmpty();

	}
}
