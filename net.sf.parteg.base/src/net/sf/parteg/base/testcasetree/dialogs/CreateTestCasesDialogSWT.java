package net.sf.parteg.base.testcasetree.dialogs;

import java.util.HashMap;
import java.util.Set;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.Configuration.OUTPUTFORMAT;
import net.sf.parteg.base.testcasetree.Configuration.TransitionBasedCoverageCriterion;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.StateMachine;

public class CreateTestCasesDialogSWT 
implements ConfigurationSetter, SelectionListener, MouseListener, ModifyListener {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="26,5"
	private Group group = null;
	private Composite composite = null;
	private Label labelOutputFile = null;
	private Text textFileOutput = null;
	private Label labelEventHandlingMethod = null;
	private Label labelPlaceHolder1 = null;
	private Text textEventHandlingMethod = null;
	private Label labelOutputFileExtension = null;
	private Label labelOutputFileGenerator = null;
	private Combo comboOutputFileGenerator = null;
	
	private Group groupClassSelection = null;
	private Composite composite1 = null;
	private Combo comboClasses = null;
	private Combo comboStateMachines = null;
	
	private Composite compositeButtons = null;
	private Button buttonOk = null;
	private Button buttonCancel = null;
	private Label labelStateMachine = null;
	private Label labelClass = null;
	
	private boolean m_bPressedOk;
	private HashMap<String, StateMachine> m_colName2StateMachine;
	private HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>> m_colStateMachine2Name2Class;
	private HashMap<String, Configuration.OUTPUTFORMAT> m_colName2OutputFormat;
	private HashMap<String, Configuration.TransitionBasedCoverageCriterion> m_colName2Coverage;
	private Group groupCoverageCriteria = null;
	private Composite compositeTransitionBasedCriteria = null;
	private Label labelTansitionedBasedCriteria = null;
	private Combo comboTransitionBasedCriteria = null;

	public CreateTestCasesDialogSWT() throws Exception
	{
		Display display = Display.getDefault();
		createSShell();

		sShell.open();

		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	
	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		group = new Group(sShell, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setText("Output Selection");
		createComposite();
		group.setLayoutData(gridData);
	}

	/**
	 * This method initializes composite	
	 *
	 */
	private void createComposite() {
		GridData gridData6 = new GridData();
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData5 = new GridData();
		gridData5.grabExcessHorizontalSpace = false;
		gridData5.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		GridData gridData4 = new GridData();
		gridData4.grabExcessHorizontalSpace = false;
		gridData4.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 3;
		composite = new Composite(group, SWT.NONE);
		composite.setLayout(gridLayout1);
		composite.setLayoutData(gridData1);
		labelOutputFile = new Label(composite, SWT.NONE);
		labelOutputFile.setText("TestOutputFile: ");
		textFileOutput = new Text(composite, SWT.BORDER);
		textFileOutput.setLayoutData(gridData2);
		labelOutputFileExtension = new Label(composite, SWT.NONE);
		labelOutputFileExtension.setText(".java");
		labelOutputFileExtension.setLayoutData(gridData4);
		labelEventHandlingMethod = new Label(composite, SWT.NONE);
		labelEventHandlingMethod.setText("event handling method: ");
		textEventHandlingMethod = new Text(composite, SWT.BORDER);
		textEventHandlingMethod.setLayoutData(gridData3);
		labelPlaceHolder1 = new Label(composite, SWT.NONE);
		labelPlaceHolder1.setText("");
		labelPlaceHolder1.setLayoutData(gridData5);
		labelOutputFileGenerator = new Label(composite, SWT.NONE);
		labelOutputFileGenerator.setText("output format:");
		comboOutputFileGenerator = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboOutputFileGenerator.addSelectionListener(this);
		comboOutputFileGenerator.setLayoutData(gridData6);
	}

	/**
	 * This method initializes groupClassSelection	
	 *
	 */
	private void createGroupClassSelection() {
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 1;
		GridData gridData5 = new GridData();
		gridData5.grabExcessHorizontalSpace = true;
		gridData5.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		groupClassSelection = new Group(sShell, SWT.NONE);
		groupClassSelection.setText("Context Selection");
		groupClassSelection.setLayout(gridLayout2);
		createComposite1();
		groupClassSelection.setLayoutData(gridData5);
	}

	/**
	 * This method initializes composite1	
	 *
	 */
	private void createComposite1() {
		GridData gridData8 = new GridData();
		gridData8.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData8.grabExcessHorizontalSpace = true;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.numColumns = 2;
		composite1 = new Composite(groupClassSelection, SWT.NONE);
		labelStateMachine = new Label(composite1, SWT.NONE);
		labelStateMachine.setText("Selected StateMachine");
		labelClass = new Label(composite1, SWT.NONE);
		labelClass.setText("Selected Class");
		createComboStateMachines();
		createComboClasses();
		composite1.setLayoutData(gridData8);
		composite1.setLayout(gridLayout3);
	}

	/**
	 * This method initializes comboClasses	
	 *
	 */
	private void createComboClasses() {
		GridData gridData7 = new GridData();
		gridData7.grabExcessHorizontalSpace = true;
		gridData7.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboClasses = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboClasses.addModifyListener(this);
		comboClasses.addSelectionListener(this);
		comboClasses.setLayoutData(gridData7);
	}

	/**
	 * This method initializes comboStatemachines	
	 *
	 */
	private void createComboStateMachines() {
		GridData gridData6 = new GridData();
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboStateMachines = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboStateMachines.addModifyListener(this);
		comboStateMachines.addSelectionListener(this);
		comboStateMachines.setLayoutData(gridData6);
	}

	/**
	 * This method initializes compositeButtons	
	 *
	 */
	private void createCompositeButtons() {
		GridData gridData9 = new GridData();
		gridData9.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		gridData9.verticalAlignment = org.eclipse.swt.layout.GridData.END;
		gridData9.grabExcessVerticalSpace = true;
		GridLayout gridLayout4 = new GridLayout();
		gridLayout4.numColumns = 2;
		compositeButtons = new Composite(sShell, SWT.NONE);
		compositeButtons.setLayout(gridLayout4);
		compositeButtons.setLayoutData(gridData9);
		buttonOk = new Button(compositeButtons, SWT.NONE);
		buttonOk.setText("Ok");
		buttonOk.addMouseListener(this);
		buttonCancel = new Button(compositeButtons, SWT.NONE);
		buttonCancel.setText("Cancel");
		buttonCancel.addMouseListener(this);
	}

	/**
	 * This method initializes groupCoverageCriteria	
	 *
	 */
	private void createGroupCoverageCriteria() {
		GridData gridData10 = new GridData();
		gridData10.grabExcessHorizontalSpace = true;
		gridData10.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		groupCoverageCriteria = new Group(sShell, SWT.NONE);
		groupCoverageCriteria.setLayout(new GridLayout());
		groupCoverageCriteria.setText("Coverage Criteria Selection");
		createCompositeTransitionBasedCriteria();
		groupCoverageCriteria.setLayoutData(gridData10);
	}

	/**
	 * This method initializes compositeTransitionBasedCriteria	
	 *
	 */
	private void createCompositeTransitionBasedCriteria() {
		GridLayout gridLayout5 = new GridLayout();
		gridLayout5.numColumns = 2;
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData11.grabExcessHorizontalSpace = true;
		compositeTransitionBasedCriteria = new Composite(groupCoverageCriteria,
				SWT.NONE);
		compositeTransitionBasedCriteria.setLayoutData(gridData11);
		compositeTransitionBasedCriteria.setLayout(gridLayout5);
		labelTansitionedBasedCriteria = new Label(compositeTransitionBasedCriteria, SWT.NONE);
		labelTansitionedBasedCriteria.setText("Transition-Based Criterion:");
		createComboTransitionBasedCriteria();
	}

	/**
	 * This method initializes comboTransitionBasedCriteria	
	 *
	 */
	private void createComboTransitionBasedCriteria() {
		GridData gridData12 = new GridData();
		gridData12.grabExcessHorizontalSpace = true;
		gridData12.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboTransitionBasedCriteria = new Combo(compositeTransitionBasedCriteria, SWT.READ_ONLY);
		comboTransitionBasedCriteria.addSelectionListener(this);
		comboTransitionBasedCriteria.setLayoutData(gridData12);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
		/* Before this is run, be sure to set up the launch configuration (Arguments->VM Arguments)
		 * for the correct SWT library path in order to run with the SWT dlls. 
		 * The dlls are located in the SWT plugin jar.  
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 *       installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */
		Display display = Display.getDefault();
		CreateTestCasesDialogSWT thisClass = new CreateTestCasesDialogSWT();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() throws Exception
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		sShell = new Shell(SWT.APPLICATION_MODAL | SWT.SHELL_TRIM | SWT.ON_TOP | SWT.BORDER);
		sShell.setText("ParTeG");
		sShell.setSize(new Point(342, 328));
		sShell.setLayout(gridLayout);
		createGroup();
		createGroupClassSelection();
		createGroupCoverageCriteria();
		createCompositeButtons();

		initialize();

		sShell.setVisible(true);
	}

	private void initialize() throws Exception
	{
		m_bPressedOk = false;
		Configuration.setValuesToConfigurationSetter(this);
		updateComboBoxOutputFormat();
		updateComboBoxStatemachines();
		updateComboBoxCoverageCriteria();
	}
	
	private void updateComboBoxOutputFormat()
	{
		for(String sOutputFormat : getName2OutputFormat().keySet())
		{
			comboOutputFileGenerator.add(sOutputFormat);
			if(getName2OutputFormat().get(sOutputFormat).equals(Configuration.getOutputFormat()))
				comboOutputFileGenerator.select(comboOutputFileGenerator.getItemCount() - 1);
		}
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
	
	private void updateComboBoxCoverageCriteria()
	{
		comboTransitionBasedCriteria.removeAll();
		for(String sCoverageCriterion : getName2Coverage().keySet())
		{
			comboTransitionBasedCriteria.add(sCoverageCriterion);
		}
		comboTransitionBasedCriteria.select(0);
		handleComboCoverageCriteria();
	}

	@Override
	public boolean getOkPressed() {
		return m_bPressedOk;
	}

	@Override
	public String getOutputFileName() {
		return textFileOutput.getText();
	}

	@Override
	public String getSMEventHandleFunction() {
		return textEventHandlingMethod.getText();
	}

	@Override
	public void setOutputFileName(String in_sFileName) {
		if(in_sFileName != null)
			textFileOutput.setText(in_sFileName);
	}

	@Override
	public void setStateMachineContextClasses(
			HashMap<StateMachine, Set<org.eclipse.uml2.uml.Class>> in_colContexts) {
		if(in_colContexts != null)
			ConfigurationSetterHelper.setStateMachineContextClasses(in_colContexts, this);
	}

	@Override
	public void setCoverageCriteria(
			HashMap<String, Configuration.TransitionBasedCoverageCriterion> in_colName2Criteria)
	{
		if(in_colName2Criteria != null)
			getName2Coverage().putAll(in_colName2Criteria);
	}
	
	@Override
	public void setSMEventHandleFunction(String in_sEventHandleFunction) {
		if(in_sEventHandleFunction != null)
			textEventHandlingMethod.setText(in_sEventHandleFunction);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		if(arg0.getSource().equals(comboStateMachines))
		{
			handleComboStateMachinesEvent();
		}
		else if(arg0.getSource().equals(comboClasses))
		{
			handleComboClassesEvent();
		}
		else if(arg0.getSource().equals(comboOutputFileGenerator))
		{
			handleComboOutputFileGenerator();
		}
		else if(arg0.getSource().equals(comboTransitionBasedCriteria))
		{
			handleComboCoverageCriteria();
		}
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		if(arg0.getSource().equals(buttonOk))
		{
			m_bPressedOk = true;
			Configuration.getValuesFromConfigurationSetter(this);
			sShell.setVisible(false);
			sShell.dispose();
		}
		else if(arg0.getSource().equals(buttonCancel))
		{
			m_bPressedOk = false;
			sShell.setVisible(false);
			sShell.dispose();
		}
	}

	@Override
	public void mouseUp(MouseEvent e) {
	}

	@Override
	public void modifyText(ModifyEvent arg0) {
		if(arg0.getSource().equals(comboStateMachines))
		{
			handleComboStateMachinesEvent();
		}
		else if(arg0.getSource().equals(comboClasses))
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
			
			for(String nString : getStateMachine2Name2Class().get(oStateMachine).keySet())
			{
				comboClasses.add(nString);
				org.eclipse.uml2.uml.Class oClass = Configuration.getContextClass(oStateMachine);
				if(getStateMachine2Name2Class().get(oStateMachine).get(nString).equals(oClass))
				{
					comboClasses.select(comboClasses.getItemCount() - 1);
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
	
	private void handleComboOutputFileGenerator()
	{
		if(!(comboOutputFileGenerator.getSelectionIndex() == -1))
		{
			Configuration.setOutputFormat(m_colName2OutputFormat.get(
					comboOutputFileGenerator.getItem(comboOutputFileGenerator.getSelectionIndex())));
		}
	}
	
	private void handleComboCoverageCriteria()
	{
		if(!(comboTransitionBasedCriteria.getSelectionIndex() == -1))
		{
			Configuration.setTransitionBasedCoverageCriterion(m_colName2Coverage.get(
					comboTransitionBasedCriteria.getItem(comboTransitionBasedCriteria.getSelectionIndex())));
		}
	}
	
	public HashMap<String, StateMachine> getName2StateMachine()
	{
		if(m_colName2StateMachine == null)
		{
			m_colName2StateMachine = new HashMap<String, StateMachine>();
		}
		return m_colName2StateMachine;
	}
	
	public HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>> getStateMachine2Name2Class()
	{
		if(m_colStateMachine2Name2Class == null)
		{
			m_colStateMachine2Name2Class = new HashMap<StateMachine, HashMap<String, org.eclipse.uml2.uml.Class>>();
		}
		return m_colStateMachine2Name2Class;
	}

	private HashMap<String, Configuration.OUTPUTFORMAT> getName2OutputFormat()
	{
		if(m_colName2OutputFormat == null)
		{
			m_colName2OutputFormat = new HashMap<String, Configuration.OUTPUTFORMAT>();
		}
		return m_colName2OutputFormat;
	}
	
	private HashMap<String, TransitionBasedCoverageCriterion> getName2Coverage()
	{
		if(m_colName2Coverage == null)
		{
			m_colName2Coverage = new HashMap<String, TransitionBasedCoverageCriterion>();
		}
		return m_colName2Coverage;
	}

	@Override
	public void setOutputFormat(HashMap<String, OUTPUTFORMAT> in_colOutputFormat) {
		for(String sName : in_colOutputFormat.keySet())
		{
			getName2OutputFormat().put(sName, in_colOutputFormat.get(sName));
		}		
	}
	
}
