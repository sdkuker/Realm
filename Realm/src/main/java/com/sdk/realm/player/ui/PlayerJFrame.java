/*
 * PlayerJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.player.ui;

/**
 *
 * @author  __USER__
 */
public class PlayerJFrame extends javax.swing.JFrame {

	private PlayerFrameController _myController = null;

	/** Creates new form PlayerJFrame */
	public PlayerJFrame() {
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
		playerJTable = new javax.swing.JTable();
		deletePlayerJButton = new javax.swing.JButton();
		deleteAllJButton = new javax.swing.JButton();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Players");

		playerJTable.setModel(new PlayerTableDataModel());
		jScrollPane1.setViewportView(playerJTable);

		deletePlayerJButton.setText("Delete");
		deletePlayerJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deletePlayerJButtonActionPerformed(evt);
					}
				});

		deleteAllJButton.setText("Delete All");
		deleteAllJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteAllJButtonActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout.createSequentialGroup().add(153, 153,
										153).add(jLabel1).addContainerGap(181,
										Short.MAX_VALUE))
						.add(
								org.jdesktop.layout.GroupLayout.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap(14, Short.MAX_VALUE)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												289,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																deletePlayerJButton,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(
																deleteAllJButton,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
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
																		.addContainerGap()
																		.add(
																				jLabel1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jScrollPane1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				275,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				59,
																				59,
																				59)
																		.add(
																				deletePlayerJButton)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				deleteAllJButton)))
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void deleteAllJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.deleteAllPlayersJButtonClicked();
	}

	private void deletePlayerJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.deletePlayerJButtonClicked();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PlayerJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton deleteAllJButton;
	private javax.swing.JButton deletePlayerJButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable playerJTable;

	// End of variables declaration//GEN-END:variables

	public void setController(PlayerFrameController aController) {
		_myController = aController;
		getTableDataModel().setMyFrameController(aController);
	}

	PlayerTableDataModel getTableDataModel() {
		return (PlayerTableDataModel) playerJTable.getModel();
	}

	javax.swing.JTable getPlayerTable() {
		return playerJTable;
	}
}