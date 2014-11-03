/*
 * CombatJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.combat.ui;

/**
 *
 * @author  __USER__
 */
public class CombatJFrame extends javax.swing.JFrame {

	private CombatFrameController _myController = null;

	/** Creates new form CombatJFrame */
	public CombatJFrame() {
		initComponents();
	}

	public CombatJFrame(CombatFrameController aController) {
		super();
		_myController = aController;
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		combatJTable = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		openRoundJLabel = new javax.swing.JLabel();
		displayedRoundJSpinner = new javax.swing.JSpinner();
		jLabel4 = new javax.swing.JLabel();
		nextRoundJButton = new javax.swing.JButton();
		criticalHitsJButton = new javax.swing.JButton();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Combat");

		combatJTable.setModel(new CombatTableDataModel());
		jScrollPane1.setViewportView(combatJTable);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("Open Round:");

		openRoundJLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
		openRoundJLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		openRoundJLabel.setText("5");

		displayedRoundJSpinner.setModel(new javax.swing.SpinnerNumberModel());
		displayedRoundJSpinner
				.addChangeListener(new javax.swing.event.ChangeListener() {
					public void stateChanged(javax.swing.event.ChangeEvent evt) {
						displayedRoundJSpinnerStateChanged(evt);
					}
				});

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel4.setText("Displayed round:");

		nextRoundJButton.setText("Next Round");
		nextRoundJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextRoundJButtonActionPerformed(evt);
			}
		});

		criticalHitsJButton.setLabel("Critical Hits");
		criticalHitsJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						criticalHitsJButtonActionPerformed(evt);
					}
				});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.add(jScrollPane1,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										755, Short.MAX_VALUE)
								.add(18, 18, 18)
								.add(layout
										.createParallelGroup(
												org.jdesktop.layout.GroupLayout.LEADING)
										.add(org.jdesktop.layout.GroupLayout.TRAILING,
												layout.createSequentialGroup()
														.add(openRoundJLabel,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																43,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(81, 81, 81))
										.add(org.jdesktop.layout.GroupLayout.TRAILING,
												layout.createSequentialGroup()
														.add(layout
																.createParallelGroup(
																		org.jdesktop.layout.GroupLayout.LEADING)
																.add(jLabel2)
																.add(jLabel4)
																.add(layout
																		.createSequentialGroup()
																		.add(10,
																				10,
																				10)
																		.add(displayedRoundJSpinner,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				79,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.TRAILING)
																		.add(criticalHitsJButton)
																		.add(nextRoundJButton)))
														.add(18, 18, 18)))
								.add(18, 18, 18))
				.add(layout.createSequentialGroup().add(336, 336, 336)
						.add(jLabel1).addContainerGap(514, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(6, 6, 6)
						.add(jLabel1)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(12, 12, 12)
										.add(jLabel2)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(openRoundJLabel)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(jLabel4)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(displayedRoundJSpinner,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(27, 27, 27).add(nextRoundJButton)
										.add(28, 28, 28)
										.add(criticalHitsJButton))
								.add(layout
										.createSequentialGroup()
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												275,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(70, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void criticalHitsJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.openCriticalHitsFrame();
	}

	private void displayedRoundJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {
		_myController.displayedRoundJSpinnerStateChanged();
	}

	private void nextRoundJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.nextRoundJButtonClicked();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CombatJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable combatJTable;
	private javax.swing.JButton criticalHitsJButton;
	private javax.swing.JSpinner displayedRoundJSpinner;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton nextRoundJButton;
	private javax.swing.JLabel openRoundJLabel;

	// End of variables declaration//GEN-END:variables

	javax.swing.JLabel getOpenRoundJLabel() {
		return openRoundJLabel;
	}

	javax.swing.JSpinner getDisplayedRoundJSpinner() {
		return displayedRoundJSpinner;
	}

	public void setController(CombatFrameController aController) {
		_myController = aController;
	}

	public CombatTableDataModel getCombatTableModel() {
		return (CombatTableDataModel) combatJTable.getModel();
	}

	javax.swing.JTable getCombatTable() {
		return combatJTable;
	}
}