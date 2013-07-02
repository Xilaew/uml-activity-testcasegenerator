package net.sf.parteg.base.testcasegraph.dialogs;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.config.Configuration;

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
import org.eclipse.swt.widgets.Text;

public class CreateTestCasesGroupOutputSelection 
implements SelectionListener {

	private Group group = null;
	private Composite composite = null;
	private Label labelOutputFile = null;
	private Text textFileOutput = null;
	private Label labelEventHandlingMethod = null;
	private Text textEventHandlingMethod = null;
	private Label labelOutputFileGenerator = null;
	private Combo comboOutputFileGenerator = null;
	
	private HashMap<String, Configuration.OUTPUTFORMAT> m_colName2OutputFormat;
	
	public CreateTestCasesGroupOutputSelection(Shell in_oShell) {
		createGroup(in_oShell);
	}
	
	private void createGroup(Shell in_oShell) {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		group = new Group(in_oShell, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setText("Output Selection");
		createComposite();
		group.setLayoutData(gridData);
	}
	
	private void createComposite() {
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData4 = new GridData();
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;

		composite = new Composite(group, SWT.NONE);
		composite.setLayout(gridLayout1);
		composite.setLayoutData(gridData1);
		
		labelOutputFile = new Label(composite, SWT.NONE);
		labelOutputFile.setText("Test Suite Class: ");
		textFileOutput = new Text(composite, SWT.BORDER);
		textFileOutput.setLayoutData(gridData2);
		
		labelEventHandlingMethod = new Label(composite, SWT.NONE);
		labelEventHandlingMethod.setText("Event Handling Method: ");
		textEventHandlingMethod = new Text(composite, SWT.BORDER);
		textEventHandlingMethod.setLayoutData(gridData3);
		
		labelOutputFileGenerator = new Label(composite, SWT.NONE);
		labelOutputFileGenerator.setText("Output Format:");
		comboOutputFileGenerator = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboOutputFileGenerator.setLayoutData(gridData4);
		comboOutputFileGenerator.addSelectionListener(this);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource().equals(comboOutputFileGenerator))
		{
			handleComboOutputFileGenerator();
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

	private void updateComboBoxOutputFormat()
	{
		for(String sOutputFormat : getName2OutputFormat().keySet())
		{
			comboOutputFileGenerator.add(sOutputFormat);
			if(getName2OutputFormat().get(sOutputFormat).equals(Configuration.getOutputFormat()))
				comboOutputFileGenerator.select(comboOutputFileGenerator.getItemCount() - 1);
		}
	}

	private HashMap<String, Configuration.OUTPUTFORMAT> getName2OutputFormat()
	{
		if(m_colName2OutputFormat == null)
		{
			m_colName2OutputFormat = new LinkedHashMap<String, Configuration.OUTPUTFORMAT>();
		}
		return m_colName2OutputFormat;
	}
	
	public void initialize() {
		// set text for file output
		if(textFileOutput != null) {
			textFileOutput.setText(Configuration.getTestCaseOutputName());
		}
		// set text for event handling method
		if(textEventHandlingMethod != null) {
			textEventHandlingMethod.setText(Configuration.getHandleEventFunctionName());
		}
		// fill mapping from text to objects for output format
		if(comboOutputFileGenerator != null) {
			for(String sName : Configuration.getOutputFormatCollection().keySet())
			{
				getName2OutputFormat().put(sName, Configuration.getOutputFormatCollection().get(sName));
			}		
		}
		// adapt combo box to output file format
		updateComboBoxOutputFormat();
	}

	public void saveResults() {
		if(textFileOutput != null) {
			Configuration.setTestCaseOutputName(textFileOutput.getText());
		}
		if(textEventHandlingMethod != null) {
			Configuration.setHandleEventFunctionName(textEventHandlingMethod.getText());
		}
	}
}
