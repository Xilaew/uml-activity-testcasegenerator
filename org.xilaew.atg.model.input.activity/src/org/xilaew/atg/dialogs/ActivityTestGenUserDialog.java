package org.xilaew.atg.dialogs;

import java.util.Properties;

import org.eclipse.atg.model.pathsearch.PathSearch;
import org.eclipse.atg.model.pathsearch.SatisfiablePathSearch;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ActivityTestGenUserDialog extends Dialog {
	@Override
	protected void okPressed() {
        activityTestGenProperties.setProperty(PathSearch.PROPERTY_MAX_NO_PATHS, text_MAX_NO_PATHS.getText());
        activityTestGenProperties.setProperty(PathSearch.PROPERTY_MAX_PATHLENGTH, text_MAX_PATH_LENGTH.getText());
        activityTestGenProperties.setProperty(SatisfiablePathSearch.PROPERTY_SOLVER, combo_PATHSEARCH_SOLVER.getText());
        activityTestGenProperties.setProperty(SatisfiablePathSearch.PROPERTY_UNCHECKED_STEPS, text_PATHSEARCH_UNCHECKED_STEPS.getText());
		super.okPressed();
	}

	private Text text_PATHSEARCH_UNCHECKED_STEPS;
	private Text text_MAX_NO_PATHS;
	private Text text_MAX_PATH_LENGTH;
	private Label lbMAX_PATH_LENGTH;
	private Label lblUncheckedSteps;
	private Combo combo_PATHSEARCH_SOLVER;
	private Label lblSolver;
    /**
     * The input value; the empty string by default.
     */
    private Properties activityTestGenProperties;//$NON-NLS-1$

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ActivityTestGenUserDialog(Shell parentShell,Properties activityTestGenProperties) {
		super(parentShell);
		this.activityTestGenProperties=activityTestGenProperties;
		if (this.activityTestGenProperties == null){
			this.activityTestGenProperties=new Properties();
		}
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(2, false);
		container.setLayout(gl_container);
		
		Label lblMAX_NO_PATHS = new Label(container, SWT.NONE);
		lblMAX_NO_PATHS.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMAX_NO_PATHS.setText("Max Number of Paths");
		
		text_MAX_NO_PATHS = new Text(container, SWT.BORDER);
		text_MAX_NO_PATHS.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		text_MAX_NO_PATHS.setText(activityTestGenProperties.getProperty(PathSearch.PROPERTY_MAX_NO_PATHS));
		
		lbMAX_PATH_LENGTH = new Label(container, SWT.NONE);
		lbMAX_PATH_LENGTH.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lbMAX_PATH_LENGTH.setText("Max Path length");
		
		text_MAX_PATH_LENGTH = new Text(container, SWT.BORDER);
		text_MAX_PATH_LENGTH.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		text_MAX_PATH_LENGTH.setText(activityTestGenProperties.getProperty(PathSearch.PROPERTY_MAX_PATHLENGTH));

		lblUncheckedSteps = new Label(container, SWT.NONE);
		lblUncheckedSteps.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUncheckedSteps.setText("Unchecked Steps");
		
		text_PATHSEARCH_UNCHECKED_STEPS = new Text(container, SWT.BORDER);
		text_PATHSEARCH_UNCHECKED_STEPS.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		String text = activityTestGenProperties.getProperty(SatisfiablePathSearch.PROPERTY_UNCHECKED_STEPS);
		text = text!=null?text:"";
		text_PATHSEARCH_UNCHECKED_STEPS.setText(text);
		
		lblSolver = new Label(container, SWT.NONE);
		lblSolver.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSolver.setText("Solver");
		
		combo_PATHSEARCH_SOLVER = new Combo(container, SWT.NONE);
		combo_PATHSEARCH_SOLVER.setItems(new String[] {"ilogcp", "cplex", "minos", "gecode", "couenne", "lpsolve", "gurobi"});
		combo_PATHSEARCH_SOLVER.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		combo_PATHSEARCH_SOLVER.setText(activityTestGenProperties.getProperty(SatisfiablePathSearch.PROPERTY_SOLVER));

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

//	/**
//	 * Return the initial size of the dialog.
//	 */
//	@Override
//	protected Point getInitialSize() {
//		return new Point(251, 210);
//	}

	public Properties getActivityTestGenProperties() {
		return activityTestGenProperties;
	}
}
