/*
 * CriticalHitJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.criticalhit.ui;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;

/**
 *
 * @author  __USER__
 */
public class CriticalHitJFrame extends javax.swing.JFrame {

	private CriticalHitFrameController _myController = null;

	/** Creates new form CriticalHitJFrame */
	public CriticalHitJFrame() {
		initComponents();
	}

	public CriticalHitJFrame(CriticalHitFrameController aController) {
		_myController = aController;
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		normalRollJButton = new javax.swing.JButton();
		openEndedRollJButton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		attackTotalJSpinner = new javax.swing.JSpinner();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		getCriticalJButton = new javax.swing.JButton();
		listCriticalsJButton = new javax.swing.JButton();
		typeJComboBox = new javax.swing.JComboBox();
		severityJComboBox = new javax.swing.JComboBox();
		attackerBonusJSpinner = new javax.swing.JSpinner();
		defenderBonusJSpinner = new javax.swing.JSpinner();
		jLabel10 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		defenderJComboBox = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		criticalsJList = new javax.swing.JList();
		deleteCriticalJButton = new javax.swing.JButton();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Critical Results Table");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel2.setText("Roll");

		normalRollJButton.setText("Normal");
		normalRollJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						normalRollJButtonActionPerformed(evt);
					}
				});

		openEndedRollJButton.setText("Open Ended");
		openEndedRollJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						openEndedRollJButtonActionPerformed(evt);
					}
				});

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel3.setText("+");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel4.setText("Attacker Bonus");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel5.setText("-");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel6.setText("Defender Bonus");

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel7.setText("=");

		jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel8.setText("Attack Total");

		attackTotalJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(
				attackTotalJSpinner, ""));
		attackTotalJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						attackTotalJSpinnerStateChanged(evt);
					}
				});

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel9.setText("Type");

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel11.setText("Severity");

		getCriticalJButton.setText("Get Critical");
		getCriticalJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						getCriticalJButtonActionPerformed(evt);
					}
				});

		listCriticalsJButton.setText("List Criticals");
		listCriticalsJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						listCriticalsJButtonActionPerformed(evt);
					}
				});

		typeJComboBox.setModel(_myController.getTypeComboBoxModel());
		typeJComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				typeJComboBoxActionPerformed(evt);
			}
		});

		severityJComboBox.setModel(_myController.getSeverityComboBoxModel());
		severityJComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						severityJComboBoxActionPerformed(evt);
					}
				});

		attackerBonusJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(
				attackerBonusJSpinner, ""));
		attackerBonusJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						attackerBonusJSpinnerStateChanged(evt);
					}
				});

		defenderBonusJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(
				defenderBonusJSpinner, ""));
		defenderBonusJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						defenderBonusJSpinnerStateChanged(evt);
					}
				});

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel10.setText("Criticals for Defender:");

		jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel13.setText("Defender:");

		defenderJComboBox.setModel(_myController.getDefenderComboBoxModel());
		defenderJComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						defenderJComboBoxActionPerformed(evt);
					}
				});

		criticalsJList.setModel(_myController.getCriticalsListModel());
		criticalsJList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(criticalsJList);

		deleteCriticalJButton.setText("Delete");
		deleteCriticalJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteCriticalJButtonActionPerformed(evt);
					}
				});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout.createSequentialGroup().add(312, 312, 312)
						.add(jLabel1).add(496, 496, 496))
				.add(layout
						.createSequentialGroup()
						.addContainerGap()
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(jLabel13)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(defenderJComboBox,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												141,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(817, 817, 817))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(layout
														.createSequentialGroup()
														.add(layout
																.createParallelGroup(
																		org.jdesktop.layout.GroupLayout.LEADING)
																.add(openEndedRollJButton,
																		org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																		160,
																		Short.MAX_VALUE)
																.add(normalRollJButton,
																		org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																		160,
																		Short.MAX_VALUE))
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(jLabel3,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																16,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
												.add(layout
														.createSequentialGroup()
														.add(49, 49, 49)
														.add(jLabel2)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(layout
														.createSequentialGroup()
														.add(jLabel4,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(jLabel6,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																102,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
												.add(layout
														.createSequentialGroup()
														.add(attackerBonusJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																90,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(18, 18, 18)
														.add(jLabel5,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																17,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.UNRELATED)
														.add(defenderBonusJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																90,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.add(18, 18, 18)
										.add(jLabel7,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												24,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(layout
														.createSequentialGroup()
														.add(jLabel8,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																83,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(85, 85, 85)
														.add(jLabel9)
														.add(84, 84, 84)
														.add(jLabel11))
												.add(layout
														.createSequentialGroup()
														.add(attackTotalJSpinner,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																77,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(18, 18, 18)
														.add(typeJComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																156,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(18, 18, 18)
														.add(severityJComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																80,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												9, Short.MAX_VALUE)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.TRAILING)
												.add(listCriticalsJButton,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.add(getCriticalJButton,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														95, Short.MAX_VALUE))
										.add(58, 58, 58))).addContainerGap())
				.add(layout
						.createSequentialGroup()
						.addContainerGap()
						.add(jScrollPane1,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								876, Short.MAX_VALUE)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(deleteCriticalJButton,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								92,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.add(58, 58, 58))
				.add(layout.createSequentialGroup().addContainerGap()
						.add(jLabel10).addContainerGap(907, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(30, 30, 30)
										.add(jLabel1)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												65, Short.MAX_VALUE))
								.add(org.jdesktop.layout.GroupLayout.TRAILING,
										layout.createSequentialGroup()
												.addContainerGap()
												.add(layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel13)
														.add(defenderJComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
												.add(24, 24, 24)))
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(10, 10, 10)
										.add(jLabel2)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(normalRollJButton)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(openEndedRollJButton))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.BASELINE)
												.add(jLabel4,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														46,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(jLabel6,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														24,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(jLabel8,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														24,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(jLabel9).add(jLabel11)
												.add(getCriticalJButton))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.BASELINE)
												.add(jLabel3)
												.add(attackerBonusJSpinner,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(defenderBonusJSpinner,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(jLabel5)
												.add(jLabel7,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														38,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(attackTotalJSpinner,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(typeJComboBox,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(severityJComboBox,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(listCriticalsJButton))))
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(23, 23, 23)
										.add(jLabel10)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												201,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
								.add(layout.createSequentialGroup()
										.add(117, 117, 117)
										.add(deleteCriticalJButton)))
						.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void deleteCriticalJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.deleteCriticalJButtonClicked();
	}

	private void defenderJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.defenderSelected();
	}

	private void defenderBonusJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		_myController.defenderBonusSpinnerStateChanged();
	}

	private void attackerBonusJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		_myController.attackerBonusSpinnerStateChanged();
	}

	private void attackTotalJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		_myController.attackTotalSpinnerStateChanged();
	}

	private void listCriticalsJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.listCriticalsButtonClicked();
	}

	private void getCriticalJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.getCriticalButtonClicked();
	}

	private void openEndedRollJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.openEndedRollButtonClicked();
	}

	private void normalRollJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.normalRollButtonClicked();
	}

	private void severityJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		//String selectedItem = (String) ((JComboBox) evt.getSource())
		//	.getSelectedItem();
		_myController.severityJComboBoxItemSelected();
	}

	private void typeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		//String selectedItem = (String) ((JComboBox) evt.getSource())
		//	.getSelectedItem();
		_myController.typeJComboBoxItemSelected();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CriticalHitJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JSpinner attackTotalJSpinner;
	private javax.swing.JSpinner attackerBonusJSpinner;
	private javax.swing.JList criticalsJList;
	private javax.swing.JSpinner defenderBonusJSpinner;
	private javax.swing.JComboBox defenderJComboBox;
	private javax.swing.JButton deleteCriticalJButton;
	private javax.swing.JButton getCriticalJButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton listCriticalsJButton;
	private javax.swing.JButton normalRollJButton;
	private javax.swing.JButton openEndedRollJButton;
	private javax.swing.JComboBox severityJComboBox;
	private javax.swing.JComboBox typeJComboBox;

	// End of variables declaration//GEN-END:variables

	JComboBox getSeverityJComboBox() {
		return severityJComboBox;
	}

	JComboBox getTypeJComboBox() {
		return typeJComboBox;
	}

	JComboBox getDefenderJComboBox() {
		return defenderJComboBox;
	}

	JSpinner getAttackTotalJSpinner() {
		return attackTotalJSpinner;
	}

	JSpinner getAttackerBonusJSpinner() {
		return attackerBonusJSpinner;
	}

	JSpinner getDefenderBonusJSpinner() {
		return defenderBonusJSpinner;
	}

	JList getCriticalsJList() {
		return criticalsJList;
	}
}