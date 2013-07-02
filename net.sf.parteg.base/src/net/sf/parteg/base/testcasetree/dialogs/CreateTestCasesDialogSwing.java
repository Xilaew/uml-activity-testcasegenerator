package net.sf.parteg.base.testcasetree.dialogs;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.Configuration.OUTPUTFORMAT;
import net.sf.parteg.base.testcasetree.Configuration.TransitionBasedCoverageCriterion;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class CreateTestCasesDialogSwing 
extends JDialog 
implements ActionListener, ConfigurationSetter, ItemListener {

	public CreateTestCasesDialogSwing() {
		super();
		initialize();
	}

	public CreateTestCasesDialogSwing(Frame arg0) {
		super(arg0);
		initialize();
	}

	/**
	 * This method initializes jWindow	
	 * 	
	 * @return javax.swing.JWindow	
	 */
	@SuppressWarnings("unused")
	private JWindow getJWindow() {
		if (jWindow == null) {
			jWindow = new JWindow(this);
			jWindow.setContentPane(getJContentPane());
		}
		return jWindow;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	private static final long serialVersionUID = 1L;
	private boolean bPressedOk = false;
	private JWindow jWindow = null;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jLabelOutputFile = null;
	private JTextField jFieldOutputText = null;
	private JLabel jLabelFileExtension = null;
	private JLabel jLabelSMHandleFunction = null;
	private JTextField jFieldSMHandleFunction = null;

	private JPanel jComboBoxPanel = null;
	private JComboBox<String> jComboBoxRegions = null;
	private JComboBox jComboBoxClasses = null;
	
	private JLabel jFrameBorderToButtons = null;

	private JPanel jButtonPanel = null;
	private JPanel jSpacePanel = null;
	private JButton jButtonOk = null;
	private JButton jButtonCancel = null;
	
	private HashMap<String, Region> m_colName2Region;
	private HashMap<Region, HashMap<String, org.eclipse.uml2.uml.Class>> m_colRegion2Name2Class;
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagLayout gbl = new GridBagLayout();
			jPanel = new JPanel();
			jPanel.setLayout(gbl);

			// upper left: label "OutputFile"
			getLabelOutputFile();
			// upper middle: textfield "OutputFile"
			getJFieldOutputText();
			// upper right: label ".java"
			getLabelFileExtension();
			
			// left: label "eventhandler"
			getLabelSMHandleFunction();
			// middle: textfield for handling an event
			getJFieldSMHandleFunction();
			
			getComboBoxPanel();
			
			getBorderFramesToButtons();
			
			getJButtonPanel();
		}
		return jPanel;
	}
	
	private JPanel getJButtonPanel() {
		if (jButtonPanel == null) {
			GridBagLayout gbl = new GridBagLayout();
			jButtonPanel = new JPanel();
			jButtonPanel.setLayout(gbl);

			getJPanel().add(jButtonPanel, 
					getGridBagConstraints(0, 5, 4, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));

			// placeholder
			getSpacePanel();
			// lower right button OK
			getJButtonOk();
			// lower right button Cancel
			getJButtonCancel();
		}
		return jButtonPanel;
	}	
	
	private JPanel getSpacePanel()
	{
		if(jSpacePanel == null)
		{
			jSpacePanel = new JPanel();
			getJButtonPanel().add(jSpacePanel, 
					getGridBagConstraints(1, 3, 1, 1, 100, 100, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));
			
		}
		return jSpacePanel;
	}
	
	private JPanel getComboBoxPanel()
	{
		if (jComboBoxPanel == null) {
			GridBagLayout gbl = new GridBagLayout();
			jComboBoxPanel = new JPanel();
			jComboBoxPanel.setLayout(gbl);

			getJPanel().add(jComboBoxPanel, 
					getGridBagConstraints(0, 3, 5, 1, 100, 0, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));

			// left combobox for regions
			getJComboBoxRegions();
			// right combobox for associated classes
			getJComboBoxClasses();
		}
		return jComboBoxPanel;
	}
	
	
	private JLabel getLabelOutputFile()
	{
		if(jLabelOutputFile == null)
		{
			jLabelOutputFile = new JLabel();
			jLabelOutputFile.setText("OutputFile: ");
			getJPanel().add(jLabelOutputFile, 
					getGridBagConstraints(0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH));
		}
		return jLabelOutputFile;
	}

	private JTextField getJFieldOutputText() {
		if (jFieldOutputText == null) {
			jFieldOutputText = new JTextField();
			jFieldOutputText.setText("test");
			getJPanel().add(jFieldOutputText, 
					getGridBagConstraints(1, 0, 1, 1, 100, 0, 1, 1, 1, 1, 
							GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH));
		}
		return jFieldOutputText;
	}
	
	private JLabel getLabelFileExtension()
	{
		if(jLabelFileExtension == null)
		{
			jLabelFileExtension = new JLabel();
			jLabelFileExtension.setText(".java");
			getJPanel().add(jLabelFileExtension, 
					getGridBagConstraints(3, 0, 1, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH));
		}
		return jLabelFileExtension;
	}

	private JLabel getLabelSMHandleFunction()
	{
		if(jLabelSMHandleFunction == null)
		{
			jLabelSMHandleFunction = new JLabel();
			jLabelSMHandleFunction.setText("event method: ");
			getJPanel().add(jLabelSMHandleFunction, 
					getGridBagConstraints(0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH));
		}
		return jLabelSMHandleFunction;
	}
	
	private JTextField getJFieldSMHandleFunction()
	{
		if (jFieldSMHandleFunction == null) {
			jFieldSMHandleFunction = new JTextField();
			jFieldSMHandleFunction.setText("test");
			getJPanel().add(jFieldSMHandleFunction, 
					getGridBagConstraints(1, 1, 1, 1, 100, 0, 1, 1, 1, 1, 
							GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH));
		}
		return jFieldSMHandleFunction;		
	}
	
	private JComboBox<String> getJComboBoxRegions()
	{
		if (jComboBoxRegions == null) {
			jComboBoxRegions = new JComboBox<String>();

			jComboBoxRegions.addActionListener(this);
			jComboBoxRegions.addItemListener(this);
			getComboBoxPanel().add(jComboBoxRegions, 
					getGridBagConstraints(0, 0, 3, 1, 100, 100, 5, 5, 5, 5, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));
		}
		return jComboBoxRegions;
	}
	
	private void updateComboBoxRegions()
	{
		getJComboBoxRegions().removeAllItems();
		for(String sRegionName : getName2Region().keySet())
		{
			getJComboBoxRegions().addItem(sRegionName);
		}
	}

	private JComboBox getJComboBoxClasses()
	{
		if (jComboBoxClasses == null) {
			jComboBoxClasses = new JComboBox();
			jComboBoxClasses.addActionListener(this);
			jComboBoxClasses.addItemListener(this);
			getComboBoxPanel().add(jComboBoxClasses, 
					getGridBagConstraints(3, 0, 3, 1, 100, 100, 5, 5, 5, 5, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));
		}
		return jComboBoxClasses;
	}

	private JLabel getBorderFramesToButtons()
	{
		if (jFrameBorderToButtons == null) {
			jFrameBorderToButtons = new JLabel();
			getJPanel().add(jFrameBorderToButtons, 
					getGridBagConstraints(0, 4, 4, 1, 100, 100, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.BOTH));
		}
		return jFrameBorderToButtons;
	}
	
	private JButton getJButtonOk()
	{
		if (jButtonOk == null) {
			jButtonOk = new JButton();
			jButtonOk.setText("OK");
			jButtonOk.addActionListener(this);
			getJButtonPanel().add(jButtonOk, 
					getGridBagConstraints(2, 3, 1, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE));
		}
		return jButtonOk;
	}

	private JButton getJButtonCancel()
	{
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
			jButtonCancel.addActionListener(this);
			getJButtonPanel().add(jButtonCancel, 
					getGridBagConstraints(3, 3, 1, 1, 0, 0, 1, 1, 1, 1, 
							GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE));
		}
		return jButtonCancel;
	}
	
	
	private GridBagConstraints getGridBagConstraints(int in_nGridX, int in_nGridY,
			int in_GridWidth, int in_GridHeight, int in_nWeightX, int in_nWeightY,
			int in_nInset1, int in_nInset2, int in_nInset3, int in_nInset4, int in_nAnchor,
			int in_nFill)
	{
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = in_nGridX;
		gridBagConstraints.gridy = in_nGridY;
		gridBagConstraints.gridwidth = in_GridWidth;
		gridBagConstraints.gridheight = in_GridHeight;
		gridBagConstraints.weightx = in_nWeightX;
		gridBagConstraints.weighty = in_nWeightY;
		gridBagConstraints.insets = new Insets(in_nInset1, in_nInset2, in_nInset3, in_nInset4);
		gridBagConstraints.anchor = in_nAnchor;
		gridBagConstraints.fill = in_nFill;
		//gridBagConstraints.ipadx
		return gridBagConstraints;
	}
	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		Configuration.setValuesToConfigurationSetter(this);
		updateComboBoxRegions();

		this.setSize(300, 150);
		this.setContentPane(getJPanel());
		this.setTitle("ParTeG");
		this.setName("ParTeG");
		this.setModal(true);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
//		if(arg0.getSource().equals(getJButtonOk()))
//		{
//			bPressedOk = true;
//			Configuration.getValuesFromConfigurationSetter(this);
//			this.setVisible(false);
//			this.dispose();
//		}
//		else if(arg0.getSource().equals(getJButtonCancel()))
//		{
//			bPressedOk = false;
//			this.setVisible(false);
//			this.dispose();
//		}
//		else if(arg0.getSource().equals(getJComboBoxRegions()))
//		{
//			getJComboBoxClasses().removeAllItems();
//			Region oRegion = getName2Region().get(getJComboBoxRegions().getSelectedItem());
//			
//			for(String nString : getRegion2Name2Class().get(oRegion).keySet())
//			{
//				getJComboBoxClasses().addItem(nString);
//				org.eclipse.uml2.uml.Class oClass = Configuration.getContextClass(oRegion);
//				if(getRegion2Name2Class().get(oRegion).get(nString).equals(oClass))
//				{
//					getJComboBoxClasses().setSelectedItem(nString);
//				}
//			}
//		}
//		else if(arg0.getSource().equals(getJComboBoxClasses()))
//		{
//			Region oRegion = getName2Region().get(getJComboBoxRegions().getSelectedItem());
//			Configuration.putContextClass(oRegion, getRegion2Name2Class().get(oRegion).get(getJComboBoxClasses().getSelectedItem()));
//		}	
	}
	
	public void itemStateChanged(ItemEvent arg0) {
//		if(arg0.getSource().equals(getJComboBoxRegions()))
//		{
//			getJComboBoxClasses().removeAllItems();
//			Region oRegion = getName2Region().get(getJComboBoxRegions().getSelectedItem());
//			
//			for(String nString : getRegion2Name2Class().get(oRegion).keySet())
//			{
//				getJComboBoxClasses().addItem(nString);
//				org.eclipse.uml2.uml.Class oClass = Configuration.getContextClass(oRegion);
//				if(getRegion2Name2Class().get(oRegion).get(nString).equals(oClass))
//				{
//					getJComboBoxClasses().setSelectedItem(nString);
//				}
//			}
//		}
//		else if(arg0.getSource().equals(getJComboBoxClasses()))
//		{
//			Region oRegion = getName2Region().get(getJComboBoxRegions().getSelectedItem());
//			Configuration.putContextClass(oRegion, getRegion2Name2Class().get(oRegion).get(getJComboBoxClasses().getSelectedItem()));
//		}	
	}
	
	public HashMap<String, Region> getName2Region()
	{
		if(m_colName2Region == null)
		{
			m_colName2Region = new HashMap<String, Region>();
		}
		return m_colName2Region;
	}
	
	
	public HashMap<Region, HashMap<String, org.eclipse.uml2.uml.Class>> getRegion2Name2Class()
	{
		if(m_colRegion2Name2Class == null)
		{
			m_colRegion2Name2Class = new HashMap<Region, HashMap<String, org.eclipse.uml2.uml.Class>>();
		}
		return m_colRegion2Name2Class;
	}

	public String getOutputFileName() {
		return getJFieldOutputText().getText();
	}

	public String getSMEventHandleFunction() {
		return getJFieldSMHandleFunction().getText();
	}

	public void setOutputFileName(String in_sFileName) {
		getJFieldOutputText().setText(in_sFileName);		
	}

	public void setSMEventHandleFunction(String in_sEventHandleFunction) {
		getJFieldSMHandleFunction().setText(in_sEventHandleFunction);		
	}
	
	public void setRegionContextClasses(HashMap<org.eclipse.uml2.uml.Region, Set<org.eclipse.uml2.uml.Class>> in_colContexts) {
//		ConfigurationSetterHelper.setRegionContextClasses(in_colContexts, this);
	}

	public boolean getOkPressed() {
		return bPressedOk;
	}

	@Override
	public void setOutputFormat(HashMap<String, OUTPUTFORMAT> in_colOutputFormat) {
		
	}

	@Override
	public HashMap<String, StateMachine> getName2StateMachine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<StateMachine, HashMap<String, Class>> getStateMachine2Name2Class() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCoverageCriteria(
			HashMap<String, TransitionBasedCoverageCriterion> in_colName2Criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStateMachineContextClasses(
			HashMap<StateMachine, Set<Class>> in_colContexts) {
		// TODO Auto-generated method stub
		
	}

}
