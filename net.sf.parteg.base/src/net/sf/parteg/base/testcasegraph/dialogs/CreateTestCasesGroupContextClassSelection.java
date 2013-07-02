package net.sf.parteg.base.testcasegraph.dialogs;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.config.Configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.StateMachine;

public class CreateTestCasesGroupContextClassSelection
implements SelectionListener, ModifyListener{

	private Group groupClassSelection = null;
	private Composite composite1 = null;
	private Combo comboClasses = null;
	private Combo comboStateMachines = null;

	private Label labelStateMachine = null;
	private Label labelClass = null;

	private HashMap<String, StateMachine> m_colName2StateMachine;
	private HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>> m_colStateMachine2Name2Class;

	public CreateTestCasesGroupContextClassSelection(Shell in_oShell) {
		createGroup(in_oShell);
	}
	
	private void createGroup(Shell in_oShell) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		groupClassSelection = new Group(in_oShell, SWT.NONE);
		groupClassSelection.setText("Context Selection");
		groupClassSelection.setLayout(gridLayout);
		createComposite();
		groupClassSelection.setLayoutData(gridData);
	}
	
	private void createComposite() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite1 = new Composite(groupClassSelection, SWT.NONE);
		labelStateMachine = new Label(composite1, SWT.NONE);
		labelStateMachine.setText("Selected StateMachine:");
		labelClass = new Label(composite1, SWT.NONE);
		labelClass.setText("Selected Class:");
		createComboStateMachines();
		createComboClasses();
		composite1.setLayoutData(gridData);
		composite1.setLayout(gridLayout);
	}

	private void createComboStateMachines() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboStateMachines = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboStateMachines.addModifyListener(this);
		comboStateMachines.addSelectionListener(this);
		comboStateMachines.setLayoutData(gridData);
	}

	private void createComboClasses() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboClasses = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboClasses.addModifyListener(this);
		comboClasses.addSelectionListener(this);
		comboClasses.setLayoutData(gridData);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource().equals(comboStateMachines))
		{
			handleComboStateMachinesEvent();
		}
		else if(e.getSource().equals(comboClasses))
		{
			handleComboClassesEvent();
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		if(e.getSource().equals(comboStateMachines))
		{
			handleComboStateMachinesEvent();
		}
		else if(e.getSource().equals(comboClasses))
		{
			handleComboClassesEvent();
		}			
	}
	
	private void handleComboStateMachinesEvent()
	{
		comboClasses.removeAll();
		if(!(comboStateMachines.getSelectionIndex() == -1))
		{
			StateMachine oStateMachine = getName2StateMachine().get(comboStateMachines.getItem(comboStateMachines.getSelectionIndex()));
			// add all names
			for(String nString : getStateMachine2Name2Class().get(oStateMachine).keySet()) {
				comboClasses.add(nString);
			}
			// select the context class
			for(int i = 0; i < comboClasses.getItemCount(); ++i) {
			//for(String nString : comboClasses.getItems()) {
				String nString = comboClasses.getItems()[i];
				org.eclipse.uml2.uml.Class oClass = Configuration.getContextClass(oStateMachine);
				if(getStateMachine2Name2Class().get(oStateMachine).get(nString).equals(oClass))
				{
					comboClasses.select(i);
					break;
				}
			}
		}
	}
	
	private void handleComboClassesEvent()
	{
		if(!((comboStateMachines.getSelectionIndex() == -1) || (comboClasses.getSelectionIndex() == -1)))
		{
			StateMachine oStateMachine = getName2StateMachine().get(comboStateMachines.getItem(comboStateMachines.getSelectionIndex()));
			Configuration.putContextClass(oStateMachine, getStateMachine2Name2Class().get(oStateMachine).get(
					comboClasses.getItem(comboClasses.getSelectionIndex())));
		}
	}
	
	private HashMap<String, StateMachine> getName2StateMachine()
	{
		if(m_colName2StateMachine == null)
		{
			m_colName2StateMachine = new LinkedHashMap<String, StateMachine>();
			
		}
		return m_colName2StateMachine;
	}
	
	private HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>> getStateMachine2Name2Class()	{
		if(m_colStateMachine2Name2Class == null)
		{
			m_colStateMachine2Name2Class = new LinkedHashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>>();
		}
		return m_colStateMachine2Name2Class;
	}
	
	private void updateComboBoxStatemachines() throws Exception
	{
		comboStateMachines.removeAll();
		for(String sStateMachineName : getName2StateMachine().keySet())
		{
			if(sStateMachineName.equals(""))
				throw new Exception("at least one state machine has no name");
			comboStateMachines.add(sStateMachineName);
		}
		comboStateMachines.select(0);
	}

	public void initialize() throws Exception {
		// initialize state machines
		for(StateMachine oSM : Configuration.getStateMachineClassMap().keySet()) {
			getName2StateMachine().put(oSM.getName(), oSM);
		}
		// initialize context classes
		for(StateMachine oSM : Configuration.getStateMachineClassMap().keySet()) {
			LinkedHashMap<String, org.eclipse.uml2.uml.Class> oTmpHM = new LinkedHashMap<String, org.eclipse.uml2.uml.Class>();
			for(org.eclipse.uml2.uml.Class oClass : Configuration.getPossibleContextClasses(oSM)) {
				if(oClass.getName() == null || oClass.getName().isEmpty()) {
					throw new Exception("at least one possible context class has no name");
				}
				oTmpHM.put(oClass.getName(), oClass);
			}
//			org.eclipse.uml2.uml.Class oClass = Configuration.getStateMachineClassMap().get(oSM);
//			oTmpHM.put(oClass.getName(), oClass);
			getStateMachine2Name2Class().put(oSM, oTmpHM);
		}
		// update combo boxes
		updateComboBoxStatemachines();
	}

	public void saveResults() {
		// nothing to do ...
	}

}
