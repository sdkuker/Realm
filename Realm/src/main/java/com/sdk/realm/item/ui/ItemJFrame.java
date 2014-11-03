/*
 * ItemJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.item.ui;

/**
 * 
 * @author __USER__
 */
public class ItemJFrame extends javax.swing.JFrame {

	private ItemFrameController myController;

	public ItemJFrame(ItemFrameController anItemFrameController) {
		super();
		myController = anItemFrameController;
		initComponents();
	}

	/** Creates new form ItemJFrame */
	public ItemJFrame() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		nameJTextField = new javax.swing.JTextField();
		willFormattedTextField = new javax.swing.JFormattedTextField();
		idFormattedTextField = new javax.swing.JFormattedTextField();
		jLabel5 = new javax.swing.JLabel();
		willModifierFormattedTextField = new javax.swing.JFormattedTextField();
		saveJButton = new javax.swing.JButton();
		cancelChangesJButton = new javax.swing.JButton();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Item Specifications");

		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel2.setText("ID:");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setText("Name:");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setText("Will:");

		nameJTextField.setText("Aragorn");
		nameJTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameJTextFieldActionPerformed(evt);
			}
		});

		idFormattedTextField.setEditable(false);

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel5.setText("Will Modifier:");

		org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(jLabel3).add(
																jLabel4).add(
																jLabel2).add(
																jLabel5))
										.add(107, 107, 107)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				willModifierFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				53,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				229,
																				Short.MAX_VALUE))
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				idFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				53,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								nameJTextField,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								250,
																								Short.MAX_VALUE)
																						.add(
																								org.jdesktop.layout.GroupLayout.LEADING,
																								willFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								53,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				32,
																				Short.MAX_VALUE)))));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel2)
														.add(
																idFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(11, 11, 11)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel3)
														.add(
																nameJTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																27,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jLabel4)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				jLabel5)
																		.add(
																				25,
																				25,
																				25))
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				willFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				willModifierFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap()))));

		saveJButton.setText("Save");
		saveJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveJButtonActionPerformed(evt);
			}
		});

		cancelChangesJButton.setText("Cancel Changes");
		cancelChangesJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						cancelChangesJButtonActionPerformed(evt);
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
																				19,
																				19,
																				19)
																		.add(
																				jPanel4,
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
																								cancelChangesJButton,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.add(
																								saveJButton,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								109,
																								Short.MAX_VALUE)))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				184,
																				184,
																				184)
																		.add(
																				jLabel1)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(23, 23, 23)
										.add(jLabel1)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				49,
																				49,
																				49)
																		.add(
																				saveJButton)
																		.add(
																				33,
																				33,
																				33)
																		.add(
																				cancelChangesJButton))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				26,
																				26,
																				26)
																		.add(
																				jPanel4,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				145,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myController.saveJButtonClicked();
	}

	private void cancelChangesJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		myController.cancelJButtonClicked();
	}

	private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		// don't have to do anything special here
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ItemJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton cancelChangesJButton;
	private javax.swing.JFormattedTextField idFormattedTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField nameJTextField;
	private javax.swing.JButton saveJButton;
	private javax.swing.JFormattedTextField willFormattedTextField;
	private javax.swing.JFormattedTextField willModifierFormattedTextField;

	// End of variables declaration//GEN-END:variables

	javax.swing.JFormattedTextField getIdFormattedTextField() {
		return idFormattedTextField;
	}

	javax.swing.JTextField getNameJTextField() {
		return nameJTextField;
	}

	javax.swing.JFormattedTextField getWillFormattedTextField() {
		return willFormattedTextField;
	}

	javax.swing.JFormattedTextField getWillModifierFormattedTextField() {
		return willModifierFormattedTextField;
	}

}