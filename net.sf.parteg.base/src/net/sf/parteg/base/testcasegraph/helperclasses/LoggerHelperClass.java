package net.sf.parteg.base.testcasegraph.helperclasses;

import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalElements;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGuardConditions;
import net.sf.parteg.core.output.Logger;

public class LoggerHelperClass {

	public static void logTestGoalSatisfactionComplete(Logger in_oLogger, TestCaseGraphHelper in_oTCGHelper)
	{
		logSatisfactionStatistics(in_oLogger, in_oTCGHelper);
		
		in_oLogger.getFormattedOutput().appendln("### unsatisfied test goals");
		in_oLogger.getFormattedOutput().newline();
		int n = 0;
		for(TestGoalBase oTestGoal : in_oTCGHelper.getTestGoalMgr().getTestGoals()) {
			++n;
			if(!oTestGoal.isSatisfied())
				logTestGoal(in_oLogger, n, oTestGoal, " - not satisfied:");
		}

		in_oLogger.getFormattedOutput().newline();
		in_oLogger.getFormattedOutput().appendln("### satisfied test goals");
		in_oLogger.getFormattedOutput().newline();
		n = 0;
		for(TestGoalBase oTestGoal : in_oTCGHelper.getTestGoalMgr().getTestGoals()) {
			++n;
			if(oTestGoal.isSatisfied())
				logTestGoal(in_oLogger, n, oTestGoal, " - satisfied:");
		}

	}

	
	public static void logTestGoalSatisfaction(Logger in_oLogger, TestCaseGraphHelper in_oTCGHelper)
	{
		logSatisfactionStatistics(in_oLogger, in_oTCGHelper);
		
		int n = 0;
		for(TestGoalBase oTestGoal : in_oTCGHelper.getTestGoalMgr().getTestGoals()) {
			++n;
			if(!oTestGoal.isSatisfied())
				logTestGoal(in_oLogger, n, oTestGoal, " - not satisfied:");
		}
	}

	private static void logSatisfactionStatistics(Logger in_oLogger, TestCaseGraphHelper in_oTCGHelper) {
		in_oLogger.getFormattedOutput().appendln("### Test Goal Satisfaction");

		in_oLogger.getFormattedOutput().appendln(" - defined " 
				+ in_oTCGHelper.getTestGoalMgr().getTestGoals().size()
				+ " test goals");
		in_oLogger.getFormattedOutput().appendln(" - satisfied "
				+ in_oTCGHelper.getTestGoalMgr().getNumberOfSatisfiedTestGoals()
				+ " test goals ("
				+ (in_oTCGHelper.getTestGoalMgr().getPercentageOfSatisfiedTestGoals() * 100)
				+ " %)");
		in_oLogger.getFormattedOutput().newline();		
	}
	
	private static void logTestGoal(Logger in_oLogger, int in_nTestGoalNumber, 
			TestGoalBase in_oTestGoal, String in_sPrefix)
	{
//		in_oFormattedOutput.appendln(" - not satisfied: (test goal #" + in_nNumberOfTestGoal + ") " + in_oTestGoal.getElement().toString());
		if(in_oTestGoal instanceof TestGoalElements) {
			TestGoalElements oTestGoalElement = (TestGoalElements)in_oTestGoal;
			if(oTestGoalElement.getElement() instanceof TCGTransition) {
				TCGTransition oTransitionGoal = (TCGTransition)oTestGoalElement.getElement();
				in_oLogger.getFormattedOutput().appendln(in_sPrefix + " (test goal #" + in_nTestGoalNumber + " - transition) "); 
				in_oLogger.getFormattedOutput().appendln("   from " + oTransitionGoal.getSourceNode().getName());
				in_oLogger.getFormattedOutput().appendln("   to   " + oTransitionGoal.getTargetNode().getName());
			}
			else if(oTestGoalElement.getElement() instanceof TCGNode) {
				TCGNode oNodeGoal = (TCGNode)oTestGoalElement.getElement();
				in_oLogger.getFormattedOutput().appendln(in_sPrefix + " (test goal #" + in_nTestGoalNumber + " - node) "); 
				in_oLogger.getFormattedOutput().appendln("   reach state " + oNodeGoal.getName());
			}
		}
		else if(in_oTestGoal instanceof TestGoalGuardConditions) {
			TestGoalGuardConditions oTestGoalGuard = (TestGoalGuardConditions)in_oTestGoal;
			if(oTestGoalGuard.getElement() instanceof TCGNode) {
				if(oTestGoalGuard.getNecessaryTransitionToTraverse() != null) {
					TCGTransition oTransition = oTestGoalGuard.getNecessaryTransitionToTraverse();
					in_oLogger.getFormattedOutput().appendln(in_sPrefix + " (test goal #" + in_nTestGoalNumber + " - traversed transition) ");
					in_oLogger.getFormattedOutput().appendln("   from node " + oTransition.getSourceNode().getName()); 
					in_oLogger.getFormattedOutput().appendln("   to node " + oTransition.getTargetNode().getName());
					for(TCGEvent oEvent : oTransition.getEvents()) {
						in_oLogger.getFormattedOutput().appendln("   triggered by " + oEvent.getName());
					}
				}
				else {
					in_oLogger.getFormattedOutput().appendln(in_sPrefix + " (test goal #" + in_nTestGoalNumber + " - satisfied guard) "); 
					in_oLogger.getFormattedOutput().appendln("   from node " + ((TCGNode)oTestGoalGuard.getElement()).getName());
					if(oTestGoalGuard.getEventToBeCalled() != null)
						in_oLogger.getFormattedOutput().appendln("   call event " + oTestGoalGuard.getEventToBeCalled().getName());
				}
				String sCondition = TCGDisjunctiveNormalFormHelperClass.toString(oTestGoalGuard.getDNFToBeSatisfied());
				if(!sCondition.isEmpty())
					in_oLogger.getFormattedOutput().appendln("   with condition " + sCondition);
			}
		}		
	}
}
