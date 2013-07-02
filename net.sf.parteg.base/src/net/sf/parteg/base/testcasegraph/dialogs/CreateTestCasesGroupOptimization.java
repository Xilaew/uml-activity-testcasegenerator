package net.sf.parteg.base.testcasegraph.dialogs;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestPathSearchStrategy;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestPathSearchStrategy.TestPathSearchStrategy;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CreateTestCasesGroupOptimization 
implements SelectionListener {

	private Group groupOptimization = null;
	private Composite compositeOptimization = null;
	private Label labelOptimizationSearchStrategy = null;
	private Combo comboOptimizationSearchStrategy = null;
	private Label labelOptimizationTestGoalPrioritization = null;
	private Combo comboOptimizationTestGoalPrioritization = null;
	private Label labelOptimizationSplitChoice = null;
	private Button buttonOptimizationSplitChoice = null;
	private Label labelOptimizationSplitTransitionEvents = null;
	private Button buttonOptimizationSplitTransitionEvents = null;
	private Label labelOptimizationFlattenStateMachine = null;
	private Button buttonOptimizationFlattenStateMachine = null;
	private Label labelOptimizationSplitInequations = null;
	private Button buttonOptimizationSplitInequations = null;

	private HashMap<String, TestPathSearchStrategy> m_colName2SearchStrategy;
	private HashMap<String, TestGoalPrioritization> m_colName2TestGoalPrioritization;

	
	public CreateTestCasesGroupOptimization(Shell in_oShell) {
		createGroup(in_oShell);
	}
	
	private void createGroup(Shell in_oShell) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		groupOptimization = new Group(in_oShell, SWT.NONE);
		groupOptimization.setLayout(new GridLayout());
		groupOptimization.setText("Optimization Selection");
		createCompositeOptimization();
		groupOptimization.setLayoutData(gridData);
	}
	
	private void createCompositeOptimization() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		compositeOptimization = new Composite(groupOptimization,
				SWT.NONE);
		compositeOptimization.setLayoutData(gridData);
		compositeOptimization.setLayout(gridLayout);
		
		labelOptimizationSearchStrategy = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationSearchStrategy.setText("Search Path Strategy:");
		createComboOptimizationSearchStrategy();

		labelOptimizationSplitChoice = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationSplitChoice.setText("Split Choice Nodes:");
		createChoiceOptimizationSplitChoice();

		labelOptimizationTestGoalPrioritization = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationTestGoalPrioritization.setText("Test Goal Prioritization:");
		createComboOptimizationTestGoalPrioritization();

		labelOptimizationSplitTransitionEvents = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationSplitTransitionEvents.setText("Split Transition Events:");
		createChoiceOptimizationSplitTransitionEvents();

		labelOptimizationFlattenStateMachine = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationFlattenStateMachine.setText("Flatten State Machine:");
		createChoiceOptimizationFlattenStateMachine();
		
		labelOptimizationSplitInequations = new Label(compositeOptimization, SWT.NONE);
		labelOptimizationSplitInequations.setText("Split Inequations:");
		createChoiceOptimizationPrintDefaultEvents();
		
	}
	
	private void createComboOptimizationSearchStrategy() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboOptimizationSearchStrategy = new Combo(compositeOptimization, SWT.READ_ONLY);
		comboOptimizationSearchStrategy.addSelectionListener(this);
		comboOptimizationSearchStrategy.setLayoutData(gridData);				
	}

	private void createComboOptimizationTestGoalPrioritization() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboOptimizationTestGoalPrioritization = new Combo(compositeOptimization, SWT.READ_ONLY);
		comboOptimizationTestGoalPrioritization.addSelectionListener(this);
		comboOptimizationTestGoalPrioritization.setLayoutData(gridData);				
	}

	private void createChoiceOptimizationSplitChoice() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 13;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		buttonOptimizationSplitChoice = new Button(compositeOptimization, SWT.CHECK);
		buttonOptimizationSplitChoice.addSelectionListener(this);
		buttonOptimizationSplitChoice.setLayoutData(gridData);				
	}

	private void createChoiceOptimizationSplitTransitionEvents() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 13;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		buttonOptimizationSplitTransitionEvents = new Button(compositeOptimization, SWT.CHECK);
		buttonOptimizationSplitTransitionEvents.addSelectionListener(this);
		buttonOptimizationSplitTransitionEvents.setLayoutData(gridData);				
	}
	
	private void createChoiceOptimizationFlattenStateMachine() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 13;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		buttonOptimizationFlattenStateMachine = new Button(compositeOptimization, SWT.CHECK);
		buttonOptimizationFlattenStateMachine.addSelectionListener(this);
		buttonOptimizationFlattenStateMachine.setLayoutData(gridData);				
	}
	
	private void createChoiceOptimizationPrintDefaultEvents() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 13;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		buttonOptimizationSplitInequations = new Button(compositeOptimization, SWT.CHECK);
		buttonOptimizationSplitInequations.addSelectionListener(this);
		buttonOptimizationSplitInequations.setLayoutData(gridData);				
	}	
	
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource().equals(comboOptimizationSearchStrategy))
		{
			handleComboOptimizationSearchStrategy();
		}
		else if(e.getSource().equals(comboOptimizationTestGoalPrioritization))
		{
			handleComboOptimizationTestGoalPrioritization();
		}		
	}
	
	private void handleComboOptimizationSearchStrategy()
	{
		if(!(comboOptimizationSearchStrategy.getSelectionIndex() == -1))
		{
			ConfigurationTestPathSearchStrategy.setTestPathSearchStrategy(m_colName2SearchStrategy.get(
					comboOptimizationSearchStrategy.getItem(comboOptimizationSearchStrategy.getSelectionIndex())));
		}
	}
	
	private void handleComboOptimizationTestGoalPrioritization()
	{
		if(!(comboOptimizationTestGoalPrioritization.getSelectionIndex() == -1))
		{
			ConfigurationTestGoalPrioritization.setTestGoalPrioritization(m_colName2TestGoalPrioritization.get(
					comboOptimizationTestGoalPrioritization.getItem(comboOptimizationTestGoalPrioritization.getSelectionIndex())));
		}
	}

	private HashMap<String, TestPathSearchStrategy> getName2SearchStrategy()
	{
		if(m_colName2SearchStrategy == null)
		{
			m_colName2SearchStrategy = new LinkedHashMap<String, TestPathSearchStrategy>();
		}
		return m_colName2SearchStrategy;
	}

	private HashMap<String, TestGoalPrioritization> getName2TestGoalPrioritization()
	{
		if(m_colName2TestGoalPrioritization == null)
		{
			m_colName2TestGoalPrioritization = new LinkedHashMap<String, TestGoalPrioritization>();
		}
		return m_colName2TestGoalPrioritization;
	}

	private void updateComboBoxTestGoalPrioritization() {
		comboOptimizationTestGoalPrioritization.removeAll();
		for(String sTestGoalPrioritization : getName2TestGoalPrioritization().keySet())
		{
			comboOptimizationTestGoalPrioritization.add(sTestGoalPrioritization);
		}
		int x = 0;
		for(String sTestGoalPrioritization : getName2TestGoalPrioritization().keySet()) {
			if(getName2TestGoalPrioritization().get(sTestGoalPrioritization).equals(
					ConfigurationTestGoalPrioritization.getTestGoalPrioritization())) {
				comboOptimizationTestGoalPrioritization.select(x);
				break;
			}
			++x;
		}
		handleComboOptimizationTestGoalPrioritization();	
	}

	private void updateComboBoxSearchStrategy() {
		comboOptimizationSearchStrategy.removeAll();
		for(String sSearchStrategy : getName2SearchStrategy().keySet())
		{
			comboOptimizationSearchStrategy.add(sSearchStrategy);
		}
		int x = 0;
		for(String sSearchStrategy : getName2SearchStrategy().keySet()) {
			if(getName2SearchStrategy().get(sSearchStrategy).equals(
					ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy())) {
				comboOptimizationSearchStrategy.select(x);
				break;
			}
			++x;
		}
		handleComboOptimizationSearchStrategy();	
	}
	
	public void initialize() {
		// get all values for search strategy
		for(String sName : ConfigurationTestPathSearchStrategy.getTestPathSearchStrategies().keySet()) {
			getName2SearchStrategy().put(sName, ConfigurationTestPathSearchStrategy.getTestPathSearchStrategies().get(sName));
		}
		// get all values for test goal prioritization
		for(String sName : ConfigurationTestGoalPrioritization.getTestGoalPrioritizations().keySet()) {
			getName2TestGoalPrioritization().put(sName, ConfigurationTestGoalPrioritization.getTestGoalPrioritizations().get(sName));
		}
		// initial value: split choice nodes
		buttonOptimizationSplitChoice.setSelection(
				Configuration.getSplitUpDecisionNodes());
		// initial value: split transition events
		buttonOptimizationSplitTransitionEvents.setSelection(
				Configuration.getSplitUpTransitionsToOneEventLimit());
		// initial value: flatten state machine
		buttonOptimizationFlattenStateMachine.setSelection(
				Configuration.getDuplicateTestGoalsForContainedNodes());
		// initial value: print default events
		buttonOptimizationSplitInequations.setSelection(
				Configuration.getSplitInequationsBeforeTestGoalDefinition());
		
		// init combo boxes
		updateComboBoxSearchStrategy();
		updateComboBoxTestGoalPrioritization();
	}

	public void saveResults() {
		Configuration.setSplitUpDecisionNodes(
				buttonOptimizationSplitChoice.getSelection());
		// warning: transformation is connected to decision node splitting
		Configuration.setTransformInitialAndFinalStates(
				buttonOptimizationSplitChoice.getSelection());

		Configuration.setSplitUpTransitionsToOneEventLimit(
				buttonOptimizationSplitTransitionEvents.getSelection());
		Configuration.setFlattenStateMachineWithStateComposition(
				buttonOptimizationFlattenStateMachine.getSelection());
		Configuration.setSplitInequationsBeforeTestGoalDefinition(
				buttonOptimizationSplitInequations.getSelection());
		
	}

}
