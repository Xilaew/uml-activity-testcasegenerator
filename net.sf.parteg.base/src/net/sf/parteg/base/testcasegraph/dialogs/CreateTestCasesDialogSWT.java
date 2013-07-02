package net.sf.parteg.base.testcasegraph.dialogs;

import net.sf.parteg.base.testcasegraph.config.Configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CreateTestCasesDialogSWT 
implements MouseListener {

	CreateTestCasesGroupOutputSelection oGroupOutput = null;
	CreateTestCasesGroupContextClassSelection oGroupContextClass = null;
	CreateTestCasesGroupCoverageCriteria oGroupCoverageCriteria = null;
	CreateTestCasesGroupOptimization oGroupOptimization = null;
	
	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="26,5"
	
	private Composite compositeButtons = null;
	private Button buttonOk = null;
	private Button buttonCancel = null;
	
	private boolean m_bPressedOk;
	
	
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
	 * This method initializes sShell
	 */
	private void createSShell() throws Exception
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		sShell = new Shell(SWT.APPLICATION_MODAL | SWT.SHELL_TRIM | SWT.ON_TOP | SWT.BORDER);
//		Image oImage = new Image(Display.getDefault(), "icons/parteg_3_16.gif");
//		sShell.setImage(oImage);
		sShell.setImage(new Image(Display.getDefault(), 
				getClass().getResourceAsStream("/icons/parteg_3_16.gif"))); 
		sShell.setText("ParTeG (Version " + Configuration.getProgramVersion() + ")");
//		sShell.setSize(new Point(335, 350));
//		sShell.setMinimumSize(new Point(335, 350));
		sShell.setSize(new Point(435, 510));
		sShell.setMinimumSize(new Point(435, 510));
		sShell.setLayout(gridLayout);
		
		oGroupOutput = new CreateTestCasesGroupOutputSelection(sShell);
		oGroupContextClass = new CreateTestCasesGroupContextClassSelection(sShell);
		oGroupCoverageCriteria = new CreateTestCasesGroupCoverageCriteria(sShell);
		oGroupOptimization = new CreateTestCasesGroupOptimization(sShell);

		// ok and cancel
		createCompositeButtons();

		initialize();

		sShell.setVisible(true);
	}

	/**
	 * This method initializes compositeButtons	
	 *
	 */
	private void createCompositeButtons() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.END;
		gridData.grabExcessVerticalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		compositeButtons = new Composite(sShell, SWT.NONE);
		compositeButtons.setLayout(gridLayout);
		compositeButtons.setLayoutData(gridData);
		buttonOk = new Button(compositeButtons, SWT.NONE);
		buttonOk.setText("Ok");
		buttonOk.addMouseListener(this);
		buttonCancel = new Button(compositeButtons, SWT.NONE);
		buttonCancel.setText("Cancel");
		buttonCancel.addMouseListener(this);
	}
	
	private void initialize() throws Exception
	{
		m_bPressedOk = false;
		if(oGroupOutput != null) oGroupOutput.initialize();
		if(oGroupContextClass != null) oGroupContextClass.initialize();
		if(oGroupCoverageCriteria != null) oGroupCoverageCriteria.initialize();
		if(oGroupOptimization != null) oGroupOptimization.initialize();
	}
	
	private void saveResults() {
		try {
			if(oGroupOutput != null) oGroupOutput.saveResults();
			if(oGroupContextClass != null) oGroupContextClass.saveResults();
			if(oGroupCoverageCriteria != null) oGroupCoverageCriteria.saveResults();
			if(oGroupOptimization != null) oGroupOptimization.saveResults();
		}
		catch(Exception e) {
			Configuration.handleException(e);
		}
	}

	
	public boolean getOkPressed() {
		return m_bPressedOk;
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		if(arg0.getSource().equals(buttonOk))
		{
			m_bPressedOk = true;
			saveResults();
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
}
