/*
 * CharacterJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.character.ui;

/**
 *
 * @author  __USER__
 */
public class CharacterJFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private CharacterFrameController _myController = null;

	/** Creates new form CharacterJFrame */
	public CharacterJFrame() {
		initComponents();
	}

	public CharacterJFrame(CharacterFrameController aController) {
		super();
		_myController = aController;
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		observationSkillFormattedTextField = new javax.swing.JFormattedTextField();
		stalkSkillFormattedTextField = new javax.swing.JFormattedTextField();
		alertnessSkillFormattedTextField = new javax.swing.JFormattedTextField();
		senseAmbushSkillFormattedTextField = new javax.swing.JFormattedTextField();
		jPanel2 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		armorTypeFormattedTextField = new javax.swing.JFormattedTextField();
		hasAdrenalDefenseJCheckBox = new javax.swing.JCheckBox();
		hasShieldJCheckBox = new javax.swing.JCheckBox();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		playerComboBox = new javax.swing.JComboBox();
		nameJTextField = new javax.swing.JTextField();
		levelFormattedTextField = new javax.swing.JFormattedTextField();
		perceptionFormattedTextField = new javax.swing.JFormattedTextField();
		initiativeFormattedTextField = new javax.swing.JFormattedTextField();
		jLabel17 = new javax.swing.JLabel();
		initiativeModifierFormattedTextField = new javax.swing.JFormattedTextField();
		jLabel7 = new javax.swing.JLabel();
		hitPointsFormattedTextField = new javax.swing.JFormattedTextField();
		willFormattedTextField = new javax.swing.JFormattedTextField();
		willModifierFormattedTextField = new javax.swing.JFormattedTextField();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		hitPointsModifierFormattedTextField = new javax.swing.JFormattedTextField();
		jLabel16 = new javax.swing.JLabel();
		cancelChangesJButton = new javax.swing.JButton();
		saveJButton = new javax.swing.JButton();

		jPanel3.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 100,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 100,
				Short.MAX_VALUE));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Character Specifications");

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel11.setText("Skills");

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel12.setText("Observation:");

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel13.setText("Stalk:");

		jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel15.setText("Alertness:");

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel14.setText("Sense ambush:");

		observationSkillFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		stalkSkillFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		alertnessSkillFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		senseAmbushSkillFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel12)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED,
																				17,
																				Short.MAX_VALUE)
																		.add(
																				observationSkillFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				53,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																org.jdesktop.layout.GroupLayout.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel13)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED,
																				57,
																				Short.MAX_VALUE)
																		.add(
																				stalkSkillFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				53,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jPanel1Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jLabel14)
																						.add(
																								jLabel15))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.add(
																				jPanel1Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								alertnessSkillFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								53,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								senseAmbushSkillFormattedTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								53,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jLabel12,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																observationSkillFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																stalkSkillFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel13,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																alertnessSkillFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel15,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																senseAmbushSkillFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(46, Short.MAX_VALUE)));

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel10.setText("Has adrenal defense:");

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel8.setText("Has shield:");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel6.setText("Armor type:");

		armorTypeFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel2Layout.createSequentialGroup().addContainerGap().add(
						jPanel2Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING).add(
								jLabel6).add(jLabel8).add(jLabel10)).add(36,
						36, 36).add(
						jPanel2Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING).add(
								armorTypeFormattedTextField,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								53,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(hasAdrenalDefenseJCheckBox).add(
										hasShieldJCheckBox)).addContainerGap(
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel2Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																armorTypeFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel6))
										.add(3, 3, 3)
										.add(
												jPanel2Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(hasShieldJCheckBox)
														.add(jLabel8))
										.add(9, 9, 9)
										.add(
												jPanel2Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																hasAdrenalDefenseJCheckBox)
														.add(jLabel10))
										.addContainerGap(70, Short.MAX_VALUE)));

		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel2.setText("Player:");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setText("Name:");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setText("Level:");

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel9.setText("Misc:");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel5.setText("Initiative:");

		playerComboBox.setModel(_myController.getPlayerComboBoxModel());

		nameJTextField.setText("Aragorn");
		nameJTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameJTextFieldActionPerformed(evt);
			}
		});

		levelFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		perceptionFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		initiativeFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

		jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel17.setText("Initative Modifier:");

		initiativeModifierFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));
		initiativeModifierFormattedTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						initiativeModifierFormattedTextFieldActionPerformed(evt);
					}
				});

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel7.setText("Hit Points:");

		hitPointsFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));
		hitPointsFormattedTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						hitPointsFormattedTextFieldActionPerformed(evt);
					}
				});

		willFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));
		willFormattedTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						willFormattedTextFieldActionPerformed(evt);
					}
				});

		willModifierFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));
		willModifierFormattedTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						willModifierFormattedTextFieldActionPerformed(evt);
					}
				});

		jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel18.setText("Will:");

		jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel19.setText("Will Modifier:");

		jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel20.setText("Hit Point Modifier:");

		hitPointsModifierFormattedTextField
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.NumberFormatter(
								new java.text.DecimalFormat("#0"))));

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
														.add(jLabel19)
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jLabel3)
																						.add(
																								jLabel9)
																						.add(
																								jLabel5)
																						.add(
																								jLabel4)
																						.add(
																								jLabel2)
																						.add(
																								jLabel7)
																						.add(
																								jLabel17)
																						.add(
																								jLabel20)
																						.add(
																								jLabel18))
																		.add(
																				41,
																				41,
																				41)
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												jPanel4Layout
																														.createParallelGroup(
																																org.jdesktop.layout.GroupLayout.LEADING)
																														.add(
																																perceptionFormattedTextField,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																53,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.add(
																																initiativeFormattedTextField,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																53,
																																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																														.add(
																																jPanel4Layout
																																		.createParallelGroup(
																																				org.jdesktop.layout.GroupLayout.TRAILING)
																																		.add(
																																				org.jdesktop.layout.GroupLayout.LEADING,
																																				nameJTextField,
																																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																				251,
																																				Short.MAX_VALUE)
																																		.add(
																																				org.jdesktop.layout.GroupLayout.LEADING,
																																				jPanel4Layout
																																						.createParallelGroup(
																																								org.jdesktop.layout.GroupLayout.LEADING,
																																								false)
																																						.add(
																																								levelFormattedTextField,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																																								53,
																																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																																						.add(
																																								playerComboBox,
																																								0,
																																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																								Short.MAX_VALUE))))
																										.addContainerGap(
																												33,
																												Short.MAX_VALUE))
																						.add(
																								jPanel4Layout
																										.createSequentialGroup()
																										.add(
																												initiativeModifierFormattedTextField,
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
																																org.jdesktop.layout.GroupLayout.TRAILING,
																																false)
																														.add(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																willFormattedTextField)
																														.add(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																hitPointsFormattedTextField,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																53,
																																Short.MAX_VALUE)
																														.add(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																willModifierFormattedTextField,
																																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																																53,
																																Short.MAX_VALUE)
																														.add(
																																org.jdesktop.layout.GroupLayout.LEADING,
																																hitPointsModifierFormattedTextField,
																																0,
																																0,
																																Short.MAX_VALUE))
																										.addContainerGap(
																												231,
																												Short.MAX_VALUE)))))));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																playerComboBox,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel2))
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
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				jLabel9,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				14,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				jLabel5,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				14,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED))
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.add(
																				levelFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				perceptionFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				initiativeFormattedTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				4,
																				4,
																				4)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																initiativeModifierFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel17,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																16,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																hitPointsFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel7))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(jLabel20)
														.add(
																hitPointsModifierFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																willFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel18))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel19)
														.add(
																willModifierFormattedTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel16.setText("Defense");

		cancelChangesJButton.setText("Cancel Changes");
		cancelChangesJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						cancelChangesJButtonActionPerformed(evt);
					}
				});

		saveJButton.setText("Save");
		saveJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveJButtonActionPerformed(evt);
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
								layout.createSequentialGroup().add(200, 200,
										200).add(jLabel1).addContainerGap(175,
										Short.MAX_VALUE))
						.add(
								org.jdesktop.layout.GroupLayout.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																jPanel4,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												65,
																												65,
																												65)
																										.add(
																												jLabel11)
																										.add(
																												70,
																												70,
																												70))
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												jPanel1,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
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
																												140,
																												140,
																												140)
																										.add(
																												jLabel16))
																						.add(
																								layout
																										.createSequentialGroup()
																										.add(
																												45,
																												45,
																												45)
																										.add(
																												jPanel2,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
										.add(28, 28, 28)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																saveJButton,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(
																cancelChangesJButton,
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
																		.add(
																				20,
																				20,
																				20)
																		.add(
																				jLabel1)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				jPanel4,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				293,
																				Short.MAX_VALUE))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				72,
																				72,
																				72)
																		.add(
																				saveJButton)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				cancelChangesJButton)))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																jLabel11,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																14,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel16,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																22,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																jPanel1,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(
																jPanel2,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void willModifierFormattedTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here
	}

	private void initiativeModifierFormattedTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here
	}

	private void willFormattedTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void hitPointsFormattedTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.saveJButtonClicked();
	}

	private void cancelChangesJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.cancelJButtonClicked();
	}

	private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		// don't have to do anything special here
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CharacterJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JFormattedTextField alertnessSkillFormattedTextField;
	private javax.swing.JFormattedTextField armorTypeFormattedTextField;
	private javax.swing.JButton cancelChangesJButton;
	private javax.swing.JCheckBox hasAdrenalDefenseJCheckBox;
	private javax.swing.JCheckBox hasShieldJCheckBox;
	private javax.swing.JFormattedTextField hitPointsFormattedTextField;
	private javax.swing.JFormattedTextField hitPointsModifierFormattedTextField;
	private javax.swing.JFormattedTextField initiativeFormattedTextField;
	private javax.swing.JFormattedTextField initiativeModifierFormattedTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JFormattedTextField levelFormattedTextField;
	private javax.swing.JTextField nameJTextField;
	private javax.swing.JFormattedTextField observationSkillFormattedTextField;
	private javax.swing.JFormattedTextField perceptionFormattedTextField;
	private javax.swing.JComboBox playerComboBox;
	private javax.swing.JButton saveJButton;
	private javax.swing.JFormattedTextField senseAmbushSkillFormattedTextField;
	private javax.swing.JFormattedTextField stalkSkillFormattedTextField;
	private javax.swing.JFormattedTextField willFormattedTextField;
	private javax.swing.JFormattedTextField willModifierFormattedTextField;

	// End of variables declaration//GEN-END:variables

	javax.swing.JComboBox getPlayerComboJBox() {
		return playerComboBox;
	}

	javax.swing.JTextField getNameJTextField() {
		return nameJTextField;
	}

	javax.swing.JFormattedTextField getLevelFormattedTextField() {
		return levelFormattedTextField;
	}

	javax.swing.JFormattedTextField getPerceptionFormattedTextField() {
		return perceptionFormattedTextField;
	}

	javax.swing.JFormattedTextField getInitiativeFormattedTextField() {
		return initiativeFormattedTextField;
	}

	javax.swing.JFormattedTextField getInitiativeModifierFormattedTextField() {
		return initiativeModifierFormattedTextField;
	}

	javax.swing.JFormattedTextField getHitPointsFormattedTextField() {
		return hitPointsFormattedTextField;
	}

	javax.swing.JFormattedTextField getObservationSkillFormattedTextField() {
		return observationSkillFormattedTextField;
	}

	javax.swing.JFormattedTextField getStalkSkillFormattedTextField() {
		return stalkSkillFormattedTextField;
	}

	javax.swing.JFormattedTextField getAlertnessSkillFormattedTextField() {
		return alertnessSkillFormattedTextField;
	}

	javax.swing.JFormattedTextField getSenseAmbushSkillFormattedTextField() {
		return senseAmbushSkillFormattedTextField;
	}

	javax.swing.JFormattedTextField getArmorTypeFormattedTextField() {
		return armorTypeFormattedTextField;
	}

	javax.swing.JCheckBox getHasShieldJCheckBox() {
		return hasShieldJCheckBox;
	}

	javax.swing.JCheckBox getHasAdrenalDefenseJCheckBox() {
		return hasAdrenalDefenseJCheckBox;
	}

	javax.swing.JButton getCancelChangesJButton() {
		return cancelChangesJButton;
	}

	javax.swing.JButton getSaveJButton() {
		return saveJButton;
	}

	public void setController(CharacterFrameController aController) {
		_myController = aController;
	}

	javax.swing.JFormattedTextField getWillFormattedTextField() {
		return willFormattedTextField;
	}

	javax.swing.JFormattedTextField getWillModifierFormattedTextField() {
		return willModifierFormattedTextField;
	}
	
	javax.swing.JFormattedTextField getHitPointsModifierFormattedTextField() {
		return hitPointsModifierFormattedTextField;
	}

}