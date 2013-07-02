package net.sf.parteg.core.output;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PrioritizationStatistics {

	List<Double> m_colCreationTime;
	List<Double> m_colTestSuiteTestCases;
	List<Double> m_colTestSuiteSystemCalls;
	List<Double> m_colCreationEarlySatisfiedTestGoals;
	List<Double> m_colDetectedMutants;
	List<Double> m_colTestCasesForDetectedMutants;
	List<Double> m_colTestCasesForAllMutants;
	List<Double> m_colSystemCallsForDetectedMutants;
	List<Double> m_colSystemCallsForAllMutants;
	
	public PrioritizationStatistics() {
		m_colCreationTime = new ArrayList<Double>();
		m_colTestSuiteTestCases = new ArrayList<Double>();
		m_colTestSuiteSystemCalls = new ArrayList<Double>();
		m_colCreationEarlySatisfiedTestGoals = new ArrayList<Double>();
		m_colDetectedMutants = new ArrayList<Double>();
		m_colTestCasesForDetectedMutants = new ArrayList<Double>();
		m_colTestCasesForAllMutants = new ArrayList<Double>();
		m_colSystemCallsForDetectedMutants = new ArrayList<Double>();
		m_colSystemCallsForAllMutants = new ArrayList<Double>();	
	}
	
	public void addCreationTime(Double in_oValue) {
		m_colCreationTime.add(in_oValue);
	}
	public void addTestSuiteTestCases(Double in_oValue) {
		m_colTestSuiteTestCases.add(in_oValue);
	}
	public void addTestSuiteSystemCalls(Double in_oValue) {
		m_colTestSuiteSystemCalls.add(in_oValue);
	}
	public void addCreationEarlySatisfiedTestGoals(Double in_oValue) {
		m_colCreationEarlySatisfiedTestGoals.add(in_oValue);
	}
	public void addDetectedMutants(Double in_oValue) {
		m_colDetectedMutants.add(in_oValue);
	}
	public void addTestCasesForDetectedMutants(Double in_oValue) {
		m_colTestCasesForDetectedMutants.add(in_oValue);
	}
	public void addTestCasesForAllMutants(Double in_oValue) {
		m_colTestCasesForAllMutants.add(in_oValue);
	}
	public void addSystemCallsForDetectedMutants(Double in_oValue) {
		m_colSystemCallsForDetectedMutants.add(in_oValue);
	}
	public void addSystemCallsForAllMutants(Double in_oValue) {
		m_colSystemCallsForAllMutants.add(in_oValue);
	}
	
	public String getStatistics() {
		StringBuffer sRetValue = new StringBuffer();
		sRetValue.append("system creation time            : " + getStatisticsPerValues(m_colCreationTime)
				+ System.getProperty("line.separator"));
		sRetValue.append("test suite size (test cases)    : " + getStatisticsPerValues(m_colTestSuiteTestCases)
				+ System.getProperty("line.separator"));
		sRetValue.append("test suite size (system calls)  : " + getStatisticsPerValues(m_colTestSuiteSystemCalls)
				+ System.getProperty("line.separator"));
		sRetValue.append("early satisfied test goals      : " + getStatisticsPerValues(m_colCreationEarlySatisfiedTestGoals)
				+ System.getProperty("line.separator"));
		sRetValue.append("detected mutants                : " + getStatisticsPerValues(m_colDetectedMutants)
				+ System.getProperty("line.separator"));
		sRetValue.append("test cases per detected mutant  : " + getStatisticsPerValues(m_colTestCasesForDetectedMutants)
				+ System.getProperty("line.separator"));
		sRetValue.append("system calls per detected mutant: " + getStatisticsPerValues(m_colSystemCallsForDetectedMutants)
				+ System.getProperty("line.separator"));
		sRetValue.append("test cases per mutant           : " + getStatisticsPerValues(m_colTestCasesForAllMutants)
				+ System.getProperty("line.separator"));
		sRetValue.append("system calls per mutant         : " + getStatisticsPerValues(m_colSystemCallsForAllMutants)
				+ System.getProperty("line.separator"));
		return sRetValue.toString();
	}
	
	private String getStatisticsPerValues(List<Double> in_colValues) {
		DecimalFormat f = new DecimalFormat("#0.00000"); 
		return f.format(getAverageValue(in_colValues))
		+ "; std.-deviation: " + f.format(getStandardDeviation(in_colValues))
		+ "; min: " + f.format(getMinimum(in_colValues))
		+ "; max: " + f.format(getMaximum(in_colValues));
	}
	
	private Double getAverageValue(List<Double> in_colValues) {
		Double nSize = (double)in_colValues.size();
		Double nResult = 0.0;
		for(Double oValue : in_colValues) {
			nResult += oValue / nSize;
		}
		return nResult;
	}
	
	private Double getMinimum(List<Double> in_colValues) {
		Double oMinimum = Double.MAX_VALUE;
		for(Double tmpValue : in_colValues) {
			if(tmpValue.doubleValue() < oMinimum.doubleValue())
				oMinimum = tmpValue;
		}
		return oMinimum;
	}
	
	private Double getMaximum(List<Double> in_colValues) {
		Double oMaximum = -Double.MAX_VALUE;
		for(Double tmpValue : in_colValues) {
			if(tmpValue.doubleValue() > oMaximum.doubleValue())
				oMaximum = tmpValue;
		}
		return oMaximum;		
	}
	
	private Double getStandardDeviation(List<Double> in_colValues) {
		Double oExpectedValue = getAverageValue(in_colValues);
		Double oVariance = 0.0;
		for(Double tmpValue : in_colValues) {
			oVariance += Math.pow((tmpValue.doubleValue() - oExpectedValue.doubleValue()), 2);
		}
		oVariance /= in_colValues.size();
		return Math.sqrt(oVariance);
	}
}
