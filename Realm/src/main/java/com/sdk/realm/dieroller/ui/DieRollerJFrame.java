/*
 * DieRollerJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.dieroller.ui;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author  __USER__
 */
public class DieRollerJFrame extends javax.swing.JFrame {

	private DieRollerFrameController _myController = null;

	/** Creates new form DieRollerJFrame */
	public DieRollerJFrame() {
		initComponents();
	}

	public DieRollerJFrame(DieRollerFrameController aController) {
		_myController = aController;
		initComponents();

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		normalDieJButton = new javax.swing.JButton();
		openEndedDieJButton = new javax.swing.JButton();
		openEndedDownJButton = new javax.swing.JButton();
		openEndedUpJButton = new javax.swing.JButton();
		gmConfiguredJButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		numberOfDiceJSpinner = new javax.swing.JSpinner();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		recentRollsJList = new javax.swing.JList();
		currentRollJSpinner = new javax.swing.JSpinner();
		jLabel5 = new javax.swing.JLabel();
		gmConfiguredSidedJSpinner = new javax.swing.JSpinner();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Die Roller");

		normalDieJButton.setText("Normal");
		normalDieJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				normalDieJButtonActionPerformed(evt);
			}
		});

		openEndedDieJButton.setText("Open Ended");
		openEndedDieJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						openEndedDieJButtonActionPerformed(evt);
					}
				});

		openEndedDownJButton.setText("Open Ended Down");
		openEndedDownJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						openEndedDownJButtonActionPerformed(evt);
					}
				});

		openEndedUpJButton.setText("Open Ended Up");
		openEndedUpJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						openEndedUpJButtonActionPerformed(evt);
					}
				});

		gmConfiguredJButton.setText("GM Configured");
		gmConfiguredJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						gmConfiguredJButtonActionPerformed(evt);
					}
				});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel2.setText("Number of dice:");

		numberOfDiceJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(
				numberOfDiceJSpinner, ""));
		numberOfDiceJSpinner.setValue(1);

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel3.setText("Current Roll");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel4.setText("Recent Rolls");

		recentRollsJList.setModel(_myController.getRecentRollsListModel());
		recentRollsJList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		recentRollsJList.setFocusable(false);
		recentRollsJList
				.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
		recentRollsJList.setVisibleRowCount(1);
		jScrollPane1.setViewportView(recentRollsJList);

		currentRollJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(
				currentRollJSpinner, ""));
		currentRollJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						currentRollJSpinnerStateChanged(evt);
					}
				});

		jLabel5.setText("GM Configured Sided");

		gmConfiguredSidedJSpinner
				.setEditor(new javax.swing.JSpinner.NumberEditor(
						gmConfiguredSidedJSpinner, ""));
		gmConfiguredSidedJSpinner.setValue(4);

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
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(
																				org.jdesktop.layout.GroupLayout.TRAILING,
																				layout
																						.createSequentialGroup()
																						.add(
																								jLabel1)
																						.add(
																								209,
																								209,
																								209))
																		.add(
																				org.jdesktop.layout.GroupLayout.TRAILING,
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
																																jLabel2)
																														.add(
																																18,
																																18,
																																18)
																														.add(
																																numberOfDiceJSpinner,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																44,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																org.jdesktop.layout.LayoutStyle.RELATED))
																										.add(
																												org.jdesktop.layout.GroupLayout.TRAILING,
																												layout
																														.createSequentialGroup()
																														.add(
																																layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.TRAILING)
																																		.add(
																																				normalDieJButton,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				123,
																																				Short.MAX_VALUE)
																																		.add(
																																				openEndedUpJButton,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				123,
																																				Short.MAX_VALUE))
																														.addPreferredGap(
																																org.jdesktop.layout.LayoutStyle.UNRELATED)
																														.add(
																																layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.LEADING)
																																		.add(
																																				gmConfiguredJButton,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				110,
																																				Short.MAX_VALUE)
																																		.add(
																																				openEndedDieJButton,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				110,
																																				Short.MAX_VALUE))
																														.addPreferredGap(
																																org.jdesktop.layout.LayoutStyle.RELATED)
																														.add(
																																layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.LEADING)
																																		.add(
																																				openEndedDownJButton)
																																		.add(
																																				layout
																																						.createSequentialGroup()
																																						.add(
																																								jLabel5)
																																						.addPreferredGap(
																																								org.jdesktop.layout.LayoutStyle.UNRELATED)
																																						.add(
																																								gmConfiguredSidedJSpinner,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																								42,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
																														.add(
																																20,
																																20,
																																20))
																										.add(
																												org.jdesktop.layout.GroupLayout.TRAILING,
																												layout
																														.createSequentialGroup()
																														.add(
																																jScrollPane1,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																300,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																org.jdesktop.layout.LayoutStyle.RELATED)))
																						.add(
																								layout
																										.createParallelGroup(
																												org.jdesktop.layout.GroupLayout.LEADING)
																										.add(
																												layout
																														.createSequentialGroup()
																														.add(
																																jLabel3)
																														.add(
																																32,
																																32,
																																32))
																										.add(
																												layout
																														.createSequentialGroup()
																														.addPreferredGap(
																																org.jdesktop.layout.LayoutStyle.RELATED)
																														.add(
																																currentRollJSpinner,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																94,
																																Short.MAX_VALUE)
																														.addContainerGap()))))
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																layout
																		.createSequentialGroup()
																		.add(
																				jLabel4)
																		.add(
																				228,
																				228,
																				228)))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(jLabel1)
										.add(16, 16, 16)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel2)
														.add(jLabel3)
														.add(
																numberOfDiceJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(18, 18, 18)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(normalDieJButton)
														.add(
																openEndedDieJButton)
														.add(
																openEndedDownJButton)
														.add(
																currentRollJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																20,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(openEndedUpJButton)
														.add(
																gmConfiguredJButton)
														.add(jLabel5)
														.add(
																gmConfiguredSidedJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(28, 28, 28)
										.add(jLabel4)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												37,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(26, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void currentRollJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		_myController.currentRollJSpinnerStateChanged();
	}

	private void gmConfiguredJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.gmConfiguredDieButtonClicked();
	}

	private void openEndedUpJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.openEndedUpDieButtonClicked();
	}

	private void openEndedDownJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.openEndedDieDownButtonClicked();
	}

	private void openEndedDieJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.openEndedDieButtonClicked();
	}

	private void normalDieJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.normalDieButtonClicked();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DieRollerJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JSpinner currentRollJSpinner;
	private javax.swing.JButton gmConfiguredJButton;
	private javax.swing.JSpinner gmConfiguredSidedJSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton normalDieJButton;
	private javax.swing.JSpinner numberOfDiceJSpinner;
	private javax.swing.JButton openEndedDieJButton;
	private javax.swing.JButton openEndedDownJButton;
	private javax.swing.JButton openEndedUpJButton;
	private javax.swing.JList recentRollsJList;

	// End of variables declaration//GEN-END:variables

	JButton getGmConfiguredJButton() {
		return gmConfiguredJButton;
	}

	JButton getNormalDieJButton() {
		return normalDieJButton;
	}

	JSpinner getNumberofDiceJSpinner() {
		return numberOfDiceJSpinner;
	}

	JSpinner getGMConfiguredSidedJSpinner() {
		return gmConfiguredSidedJSpinner;
	}

	JSpinner getCurrentRollJSpinner() {
		return currentRollJSpinner;
	}

	JButton getOpenEndedDieJButton() {
		return openEndedDieJButton;
	}

	JButton getOpenEndedDownJButton() {
		return openEndedDownJButton;
	}

	JButton getOpenEndedUpJButton() {
		return openEndedUpJButton;
	}

	JList getRecentRollsJList() {
		return recentRollsJList;
	}
}