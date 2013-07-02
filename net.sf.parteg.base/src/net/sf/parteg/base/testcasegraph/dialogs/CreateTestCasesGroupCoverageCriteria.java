package net.sf.parteg.base.testcasegraph.dialogs;

import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.getBoundaryBasedCoverageCriteria;
import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.getBoundaryBasedCoverageCriterion;
import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriteria;
import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.getControlFlowBasedCoverageCriterion;
import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.setBoundaryBasedCoverageCriterion;
import static net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.setControlFlowBasedCoverageCriterion;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.BoundaryBasedCoverageCriterion;
import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CreateTestCasesGroupCoverageCriteria 
implements SelectionListener {

	private Group groupCoverageCriteria = null;
	private Composite compositeCoverageCriteria = null;
	private Label labelControlFlowBasedCriteria = null;
	private Combo comboControlFlowBasedCriteria = null;
	private Label labelBoundaryBasedCriteria = null;
	private Combo comboBoundaryBasedCriteria = null;

	private HashMap<String, ControlFlowBasedCoverageCriterion> m_colName2ControlFlowCoverage;
	private HashMap<String, BoundaryBasedCoverageCriterion> m_colName2BoundaryCoverage;

	public CreateTestCasesGroupCoverageCriteria(Shell in_oShell) {
		createGroup(in_oShell);
	}
	
	private void createGroup(Shell in_oShell) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		groupCoverageCriteria = new Group(in_oShell, SWT.NONE);
		groupCoverageCriteria.setLayout(new GridLayout());
		groupCoverageCriteria.setText("Coverage Criteria Selection");
		createCompositeCoverageCriteria();
		groupCoverageCriteria.setLayoutData(gridData);		
	}
	
	private void createCompositeCoverageCriteria() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		compositeCoverageCriteria = new Composite(groupCoverageCriteria,
				SWT.NONE);
		compositeCoverageCriteria.setLayoutData(gridData);
		compositeCoverageCriteria.setLayout(gridLayout);
		
		labelControlFlowBasedCriteria = new Label(compositeCoverageCriteria, SWT.NONE);
		labelControlFlowBasedCriteria.setText("Control Flow-Based Criterion:");
		createComboTransitionBasedCriteria();
		
		labelBoundaryBasedCriteria = new Label(compositeCoverageCriteria, SWT.NONE);
		labelBoundaryBasedCriteria.setText("Boundary-Based Criterion:");
		createComboBoundaryBasedCriteria();
	}
	
	private void createComboTransitionBasedCriteria() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboControlFlowBasedCriteria = new Combo(compositeCoverageCriteria, SWT.READ_ONLY);
		comboControlFlowBasedCriteria.addSelectionListener(this);
		comboControlFlowBasedCriteria.setLayoutData(gridData);
	}

	private void createComboBoundaryBasedCriteria() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		comboBoundaryBasedCriteria = new Combo(compositeCoverageCriteria, SWT.READ_ONLY);
		comboBoundaryBasedCriteria.addSelectionListener(this);
		comboBoundaryBasedCriteria.setLayoutData(gridData);		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource().equals(comboControlFlowBasedCriteria))
		{
			handleComboControlFlowCoverageCriteria();
		}
		else if(e.getSource().equals(comboBoundaryBasedCriteria))
		{
			handleComboBoundaryCoverageCriteria();
		}
	}
	
	private void handleComboControlFlowCoverageCriteria()
	{
		if(!(comboControlFlowBasedCriteria.getSelectionIndex() == -1))
		{
			setControlFlowBasedCoverageCriterion(m_colName2ControlFlowCoverage.get(
					comboControlFlowBasedCriteria.getItem(comboControlFlowBasedCriteria.getSelectionIndex())));
		}
	}

	private void handleComboBoundaryCoverageCriteria()
	{
		if(!(comboBoundaryBasedCriteria.getSelectionIndex() == -1))
		{
			setBoundaryBasedCoverageCriterion(m_colName2BoundaryCoverage.get(
					comboBoundaryBasedCriteria.getItem(comboBoundaryBasedCriteria.getSelectionIndex())));
		}
	}

	private HashMap<String, ControlFlowBasedCoverageCriterion> getName2ControlFlowCoverage()
	{
		if(m_colName2ControlFlowCoverage == null)
		{
			m_colName2ControlFlowCoverage = new LinkedHashMap<String, ControlFlowBasedCoverageCriterion>();
		}
		return m_colName2ControlFlowCoverage;
	}

	private HashMap<String, BoundaryBasedCoverageCriterion> getName2BoundaryCoverage()
	{
		if(m_colName2BoundaryCoverage == null)
		{
			m_colName2BoundaryCoverage = new LinkedHashMap<String, BoundaryBasedCoverageCriterion>();
		}
		return m_colName2BoundaryCoverage;
	}

	private void updateComboBoxControlFlowCoverageCriteria()
	{
		comboControlFlowBasedCriteria.removeAll();
		for(String sCoverageCriterion : getName2ControlFlowCoverage().keySet())
		{
			comboControlFlowBasedCriteria.add(sCoverageCriterion);
		}
		int x = 0;
		for(String sCoverageCriterion : getName2ControlFlowCoverage().keySet()) {
			if(getName2ControlFlowCoverage().get(sCoverageCriterion).equals(
					getControlFlowBasedCoverageCriterion())) {
				comboControlFlowBasedCriteria.select(x);
				break;
			}
			++x;
		}
		handleComboControlFlowCoverageCriteria();
	}

	private void updateComboBoxBoundaryCoverageCriteria()
	{
		comboBoundaryBasedCriteria.removeAll();
		for(String sCoverageCriterion : getName2BoundaryCoverage().keySet())
		{
			comboBoundaryBasedCriteria.add(sCoverageCriterion);
		}
		int x = 0;
		for(String sCoverageCriterion : getName2BoundaryCoverage().keySet()) {
			if(getName2BoundaryCoverage().get(sCoverageCriterion).equals(
					getBoundaryBasedCoverageCriterion())) {
				comboBoundaryBasedCriteria.select(x);
				break;
			}
			++x;
		}
		handleComboBoundaryCoverageCriteria();
	}
	
	public void initialize() {
		// get selectable control flow coverage criteria
		for(String sName : getControlFlowBasedCoverageCriteria().keySet()) {
			getName2ControlFlowCoverage().put(sName, getControlFlowBasedCoverageCriteria().get(sName));
		}
		// get selectable boundary coverage criteria
		for(String sName : getBoundaryBasedCoverageCriteria().keySet()) {
			getName2BoundaryCoverage().put(sName, getBoundaryBasedCoverageCriteria().get(sName));
		}
		// adapt combo boxes + initial values
		updateComboBoxControlFlowCoverageCriteria();
		updateComboBoxBoundaryCoverageCriteria();
	}
	
	public void saveResults() {
		// nothing to do ...
	}
}
