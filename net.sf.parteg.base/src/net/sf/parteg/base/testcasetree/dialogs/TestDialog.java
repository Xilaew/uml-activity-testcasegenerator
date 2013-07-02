package net.sf.parteg.base.testcasetree.dialogs;

import java.awt.ComponentOrientation;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabelOutputFileName = null;

	private JTextField jTextFieldOutputFilename = null;

	private JLabel jLabelOutputFileExtension = null;

	private JButton jButtonOk = null;

	private JPanel jPanelSpace = null;

	/**
	 * @param owner
	 */
	public TestDialog(Frame owner) {
		super(owner);
		initialize();
	}

	public TestDialog() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setModal(true);
		this.setTitle("ParTeG");
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		this.setVisible(true);
		//addWindowListener(new WindowClosingAdapter(true));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.weightx = 100.0D;
			gridBagConstraints4.weighty = 100.0D;
			gridBagConstraints4.gridy = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints3.gridy = 2;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.ipadx = 5;
			gridBagConstraints2.ipady = 5;
			gridBagConstraints2.gridy = 0;
			jLabelOutputFileExtension = new JLabel();
			jLabelOutputFileExtension.setText(".java");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 100.0D;
			gridBagConstraints1.ipadx = 5;
			gridBagConstraints1.ipady = 5;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints.ipadx = 5;
			gridBagConstraints.ipady = 5;
			gridBagConstraints.gridy = 0;
			jLabelOutputFileName = new JLabel();
			jLabelOutputFileName.setText("OutputFile: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			getJButtonOk().addActionListener(this);
			jContentPane.add(jLabelOutputFileName, gridBagConstraints);
			jContentPane.add(getJTextFieldOutputFilename(), gridBagConstraints1);
			jContentPane.add(jLabelOutputFileExtension, gridBagConstraints2);
			jContentPane.add(getJButtonOk(), gridBagConstraints3);
			jContentPane.add(getJPanelSpace(), gridBagConstraints4);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldOutputFilename	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldOutputFilename() {
		if (jTextFieldOutputFilename == null) {
			jTextFieldOutputFilename = new JTextField();
			jTextFieldOutputFilename.setColumns(1);
			jTextFieldOutputFilename.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextFieldOutputFilename;
	}

	/**
	 * This method initializes jButtonOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOk() {
		if (jButtonOk == null) {
			jButtonOk = new JButton();
			jButtonOk.setText("OK");
		}
		return jButtonOk;
	}

	/**
	 * This method initializes jPanelSpace	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSpace() {
		if (jPanelSpace == null) {
			jPanelSpace = new JPanel();
			jPanelSpace.setLayout(new GridBagLayout());
		}
		return jPanelSpace;
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(getJButtonOk()))
		{
			Display display = new Display ();
			Shell shell = new Shell (display);
			
			MessageDialog.openInformation(
					shell,
					"UMLTestCreator Plug-in",
					jTextFieldOutputFilename.getText());
			//shell.open ();
			// start the event loop. We stop when the user has done
			// something to dispose our window.
			/*while (!shell.isDisposed ()) {
				  if (!display.readAndDispatch ())
			    	 display.sleep ();
			}*/
			display.dispose ();
			this.setVisible(false);
			this.dispose();
		}
	}

}
