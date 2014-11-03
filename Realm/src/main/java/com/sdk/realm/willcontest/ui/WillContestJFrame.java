/*
 * WillContestJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.willcontest.ui;

/**
 * 
 * @author __USER__
 */
public class WillContestJFrame extends javax.swing.JFrame {

	WillContestFrameController myController;

	public WillContestJFrame(WillContestFrameController aController) {
		super();
		myController = aController;
		initComponents();
	}

	/** Creates new form WillContestJFrame */
	public WillContestJFrame() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		contestantOneJComboBox = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		contestantTwoJComboBox = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		openRoundJLabel = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		displayedRoundJSpinner = new javax.swing.JSpinner();
		nextRoundJButton = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		consequenceJTextArea = new javax.swing.JTextArea();
		jLabel14 = new javax.swing.JLabel();
		contestantTwoTotalWilFormattedTextField = new javax.swing.JFormattedTextField();
		temporaryModifierFormattedTextField = new javax.swing.JFormattedTextField();
		roundNumberFormattedTextField = new javax.swing.JFormattedTextField();
		contestantOneTotalWillFormattedTextField = new javax.swing.JFormattedTextField();
		permanentModifierFormattedTextField = new javax.swing.JFormattedTextField();
		temporaryModifierExpirationRoundFormattedTextField = new javax.swing.JFormattedTextField();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Will Contest");

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setText("Contestant One:");

		contestantOneJComboBox.setModel(myController
				.getContestantOneComboBoxModel());

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setText("Contestant Two:");

		contestantTwoJComboBox.setModel(myController
				.getContestantTwoComboBoxModel());

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel1Layout.createSequentialGroup().addContainerGap().add(
						jLabel3).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.UNRELATED).add(
						contestantOneJComboBox,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(53,
						53, 53).add(jLabel4).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.RELATED).add(
						contestantTwoJComboBox,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.add(19, 19, 19)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel3)
														.add(
																contestantOneJComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel4)
														.add(
																contestantTwoJComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(25, Short.MAX_VALUE)));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("Contestants");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel5.setText("Open Round:");

		openRoundJLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
		openRoundJLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		openRoundJLabel.setText("5");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel6.setText("Displayed Round:");

		displayedRoundJSpinner.setModel(new javax.swing.SpinnerNumberModel(
				Integer.valueOf(0), Integer.valueOf(0), null, Integer
						.valueOf(1)));
		displayedRoundJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						displayedRoundJSpinnerStateChanged(evt);
					}
				});

		nextRoundJButton.setText("Next Round");
		nextRoundJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextRoundJButtonActionPerformed(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel7.setText("Displayed Round");

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel8.setText("Round Number:");

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel9.setText("Contestant One Total Will:");

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel10.setText("Contestant Two Total Will:");

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel11.setText("Permanent Modifier:");

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel12.setText("Temporary Modifier:");

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel13.setText("Temporary Modifier Expiration Round:");

		consequenceJTextArea.setColumns(20);
		consequenceJTextArea.setEditable(false);
		consequenceJTextArea.setLineWrap(true);
		consequenceJTextArea.setRows(5);
		jScrollPane1.setViewportView(consequenceJTextArea);

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel14.setText("Consequence");

		contestantTwoTotalWilFormattedTextField.setEditable(false);
		contestantTwoTotalWilFormattedTextField.setText("0");
		contestantTwoTotalWilFormattedTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						contestantTwoTotalWilFormattedTextFieldActionPerformed(evt);
					}
				});

		temporaryModifierFormattedTextField.setEditable(false);
		temporaryModifierFormattedTextField.setText("0");

		roundNumberFormattedTextField.setEditable(false);
		roundNumberFormattedTextField.setText("0");

		contestantOneTotalWillFormattedTextField.setEditable(false);
		contestantOneTotalWillFormattedTextField.setText("0");

		permanentModifierFormattedTextField.setEditable(false);
		permanentModifierFormattedTextField.setText("0");

		temporaryModifierExpirationRoundFormattedTextField.setEditable(false);
		temporaryModifierExpirationRoundFormattedTextField.setText("0");

		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel2Layout
										.createSequentialGroup()
										.add(
												jPanel2Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel2Layout
																		.createSequentialGroup()
																		.add(
																				276,
																				276,
																				276)
																		.add(
																				jLabel14))
														.add(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				jPanel2Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								false)
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								jScrollPane1)
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								jPanel2Layout
																										.createSequentialGroup()
																										.add(
																												jPanel2Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																jLabel8)
																														.add(
																																jLabel10)
																														.add(
																																jLabel9))
																										.add(
																												36,
																												36,
																												36)
																										.add(
																												jPanel2Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																false)
																														.add(
																																contestantOneTotalWillFormattedTextField,
																																0,
																																0,
																																Short.MAX_VALUE)
																														.add(
																																contestantTwoTotalWilFormattedTextField)
																														.add(
																																roundNumberFormattedTextField,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																39,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																										.add(
																												61,
																												61,
																												61)
																										.add(
																												jPanel2Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																jLabel12)
																														.add(
																																jLabel11)
																														.add(
																																jLabel13))
																										.add(
																												18,
																												18,
																												18)
																										.add(
																												jPanel2Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																false)
																														.add(
																																temporaryModifierExpirationRoundFormattedTextField,
																																0,
																																0,
																																Short.MAX_VALUE)
																														.add(
																																temporaryModifierFormattedTextField)
																														.add(
																																org.jdesktop.layout.GroupLayout.TRAILING,
																																jPanel2Layout
																																		.createSequentialGroup()
																																		.add(
																																				permanentModifierFormattedTextField,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																				34,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				org.jdesktop.layout.LayoutStyle.RELATED)))))))
										.addContainerGap(69, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel2Layout
										.createSequentialGroup()
										.add(
												jPanel2Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel2Layout
																		.createSequentialGroup()
																		.add(
																				21,
																				21,
																				21)
																		.add(
																				jLabel8))
														.add(
																jPanel2Layout
																		.createSequentialGroup()
																		.add(
																				19,
																				19,
																				19)
																		.add(
																				jPanel2Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								jPanel2Layout
																										.createParallelGroup(
																												org.jdesktop.layout.GroupLayout.BASELINE)
																										.add(
																												jLabel11)
																										.add(
																												roundNumberFormattedTextField,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								permanentModifierFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jPanel2Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								jPanel2Layout
																										.createParallelGroup(
																												org.jdesktop.layout.GroupLayout.BASELINE)
																										.add(
																												jLabel12)
																										.add(
																												jLabel9)
																										.add(
																												contestantOneTotalWillFormattedTextField,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																						.add(
																								temporaryModifierFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jPanel2Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel13)
																						.add(
																								jLabel10)
																						.add(
																								contestantTwoTotalWilFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								temporaryModifierExpirationRoundFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jLabel14)
										.add(13, 13, 13)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(47, Short.MAX_VALUE)));

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				337,
																				337,
																				337)
																		.add(
																				jLabel1))
														.add(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								false)
																						.add(
																								jPanel2,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.add(
																								jPanel1,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.add(
																				17,
																				17,
																				17)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								layout
																										.createParallelGroup(
																												org.jdesktop.layout.GroupLayout.LEADING)
																										.add(
																												layout
																														.createSequentialGroup()
																														.add(
																																35,
																																35,
																																35)
																														.add(
																																layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.LEADING)
																																		.add(
																																				layout
																																						.createSequentialGroup()
																																						.add(
																																								10,
																																								10,
																																								10)
																																						.add(
																																								openRoundJLabel,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																								43,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																																		.add(
																																				jLabel5))
																														.add(
																																10,
																																10,
																																10))
																										.add(
																												org.jdesktop.layout.GroupLayout.TRAILING,
																												layout
																														.createSequentialGroup()
																														.add(
																																31,
																																31,
																																31)
																														.add(
																																layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.TRAILING)
																																		.add(
																																				nextRoundJButton)
																																		.add(
																																				displayedRoundJSpinner,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																				79,
																																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																														.add(
																																21,
																																21,
																																21)))
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												18,
																												18,
																												18)
																										.add(
																												jLabel6))))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				279,
																				279,
																				279)
																		.add(
																				jLabel2))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				276,
																				276,
																				276)
																		.add(
																				jLabel7)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(jLabel1)
										.add(28, 28, 28)
										.add(jLabel2)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(
												jPanel1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				83,
																				83,
																				83)
																		.add(
																				jLabel5)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				openRoundJLabel)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				jLabel6)
																		.add(
																				11,
																				11,
																				11)
																		.add(
																				displayedRoundJSpinner,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				34,
																				34,
																				34)
																		.add(
																				nextRoundJButton))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				24,
																				24,
																				24)
																		.add(
																				jLabel7)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				jPanel2,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(30, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void contestantTwoTotalWilFormattedTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {

	}

	private void nextRoundJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myController.nextRoundJButtonClicked();
	}

	private void displayedRoundJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		myController.displayedRoundJSpinnerStateChanged();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new WillContestJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea consequenceJTextArea;
	private javax.swing.JComboBox contestantOneJComboBox;
	private javax.swing.JFormattedTextField contestantOneTotalWillFormattedTextField;
	private javax.swing.JComboBox contestantTwoJComboBox;
	private javax.swing.JFormattedTextField contestantTwoTotalWilFormattedTextField;
	private javax.swing.JSpinner displayedRoundJSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton nextRoundJButton;
	private javax.swing.JLabel openRoundJLabel;
	private javax.swing.JFormattedTextField permanentModifierFormattedTextField;
	private javax.swing.JFormattedTextField roundNumberFormattedTextField;
	private javax.swing.JFormattedTextField temporaryModifierExpirationRoundFormattedTextField;
	private javax.swing.JFormattedTextField temporaryModifierFormattedTextField;

	// End of variables declaration//GEN-END:variables

	javax.swing.JFormattedTextField getPermanentModifierFormattedTextField() {
		return permanentModifierFormattedTextField;
	}

	javax.swing.JFormattedTextField getRoundNumberFormattedTextField() {
		return roundNumberFormattedTextField;
	}

	javax.swing.JFormattedTextField getTemporaryModifierFormattedJTextField() {
		return temporaryModifierFormattedTextField;
	}

	javax.swing.JFormattedTextField getTemporaryModifierExpirationRoundFormattedTextField() {
		return temporaryModifierExpirationRoundFormattedTextField;
	}

	javax.swing.JLabel getOpenRoundJLabel() {
		return openRoundJLabel;
	}

	javax.swing.JButton getNextRoundJButton() {
		return nextRoundJButton;
	}

	javax.swing.JTextArea getConsequenceJTextArea() {
		return consequenceJTextArea;
	}

	javax.swing.JComboBox getContestantOneJComboBox() {
		return contestantOneJComboBox;
	}

	javax.swing.JComboBox getContestantTwoJComboBox() {
		return contestantTwoJComboBox;
	}

	javax.swing.JFormattedTextField getContestantOneTotalWillFormattedTextField() {
		return contestantOneTotalWillFormattedTextField;
	}

	javax.swing.JFormattedTextField getContestantTwoTotalWillFormattedTextField() {
		return contestantTwoTotalWilFormattedTextField;
	}

	javax.swing.JSpinner getDisplayedRoundJSpinner() {
		return displayedRoundJSpinner;
	}
}