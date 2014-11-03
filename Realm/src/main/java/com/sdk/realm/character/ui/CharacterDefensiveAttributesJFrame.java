/*
 * CharacterDefensiveAttributesJFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.sdk.realm.character.ui;

/**
 *
 * @author  __USER__
 */
public class CharacterDefensiveAttributesJFrame extends javax.swing.JFrame {

	private CharacterDefensiveAttributesFrameController _myController;

	/** Creates new form CharacterDefensiveAttributesJFrame */
	public CharacterDefensiveAttributesJFrame() {
		initComponents();
	}

	public CharacterDefensiveAttributesJFrame(
			CharacterDefensiveAttributesFrameController aController) {
		_myController = aController;
		aController.setFrame(this);
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		characterNameTextField = new javax.swing.JFormattedTextField();
		cancelChangesJButton = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		shieldChoiceTextField = new javax.swing.JFormattedTextField();
		armorOnArmorTextField = new javax.swing.JFormattedTextField();
		armorChoiceTextField = new javax.swing.JFormattedTextField();
		racialModifierTextField = new javax.swing.JFormattedTextField();
		quicknessBonusTextField = new javax.swing.JFormattedTextField();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		adrenalDefenseTextField = new javax.swing.JFormattedTextField();
		miscItemChoiceTextField = new javax.swing.JFormattedTextField();
		specialAbilityTextField = new javax.swing.JFormattedTextField();
		skillChoice2TextField = new javax.swing.JFormattedTextField();
		skillChoice1TextField = new javax.swing.JFormattedTextField();
		saveJButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		totalTextField = new javax.swing.JFormattedTextField();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setText("Character Defensive Attributes");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel3.setText("Character Name:");

		characterNameTextField.setEditable(false);

		cancelChangesJButton.setText("Cancel");
		cancelChangesJButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						cancelChangesJButtonActionPerformed(evt);
					}
				});

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel4.setText("Quckness Bonus:");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel5.setText("Racial Modifier:");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel6.setText("Armor Choice:");

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel7.setText("Armor on Armor:");

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel8.setText("Shield Choice:");

		shieldChoiceTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						shieldChoiceTextFieldActionPerformed(evt);
					}
				});
		shieldChoiceTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						shieldChoiceTextFieldPropertyChange(evt);
					}
				});

		armorOnArmorTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						armorOnArmorTextFieldActionPerformed(evt);
					}
				});
		armorOnArmorTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						armorOnArmorTextFieldPropertyChange(evt);
					}
				});

		armorChoiceTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						armorChoiceTextFieldActionPerformed(evt);
					}
				});
		armorChoiceTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						armorChoiceTextFieldPropertyChange(evt);
					}
				});

		racialModifierTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						racialModifierTextFieldActionPerformed(evt);
					}
				});
		racialModifierTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						racialModifierTextFieldPropertyChange(evt);
					}
				});

		quicknessBonusTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						quicknessBonusTextFieldActionPerformed(evt);
					}
				});
		quicknessBonusTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						quicknessBonusTextFieldPropertyChange(evt);
					}
				});

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel9.setText("Skill Choice 1:");

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel10.setText("Skill Choice 2:");

		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel11.setText("Special Ability:");

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel12.setText("Misc Item Choice:");

		jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabel13.setText("Adrenal Defense:");

		adrenalDefenseTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						adrenalDefenseTextFieldActionPerformed(evt);
					}
				});
		adrenalDefenseTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						adrenalDefenseTextFieldPropertyChange(evt);
					}
				});

		miscItemChoiceTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						miscItemChoiceTextFieldActionPerformed(evt);
					}
				});
		miscItemChoiceTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						miscItemChoiceTextFieldPropertyChange(evt);
					}
				});

		specialAbilityTextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						specialAbilityTextFieldActionPerformed(evt);
					}
				});
		specialAbilityTextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						specialAbilityTextFieldPropertyChange(evt);
					}
				});

		skillChoice2TextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						skillChoice2TextFieldActionPerformed(evt);
					}
				});
		skillChoice2TextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						skillChoice2TextFieldPropertyChange(evt);
					}
				});

		skillChoice1TextField
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						skillChoice1TextFieldActionPerformed(evt);
					}
				});
		skillChoice1TextField
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						skillChoice1TextFieldPropertyChange(evt);
					}
				});

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
														.add(jLabel4).add(
																jLabel5).add(
																jLabel6).add(
																jLabel7).add(
																jLabel8))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																shieldChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																armorOnArmorTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																armorChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																racialModifierTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																org.jdesktop.layout.GroupLayout.LEADING,
																quicknessBonusTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(87, 87, 87)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(jLabel10).add(
																jLabel9).add(
																jLabel11).add(
																jLabel12).add(
																jLabel13))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																adrenalDefenseTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																specialAbilityTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																skillChoice2TextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																skillChoice1TextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																miscItemChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																53,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(26, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.add(26, 26, 26)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel4)
														.add(
																quicknessBonusTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel9)
														.add(
																skillChoice1TextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.add(13, 13, 13)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(
																racialModifierTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel5)
														.add(jLabel10)
														.add(
																skillChoice2TextField,
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
																armorChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jLabel6,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																18,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel11)
														.add(
																specialAbilityTextField,
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
																armorOnArmorTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel7)
														.add(jLabel12)
														.add(
																miscItemChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel8)
														.add(jLabel13)
														.add(
																adrenalDefenseTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																shieldChoiceTextField,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(25, Short.MAX_VALUE)));

		saveJButton.setText("Save");
		saveJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveJButtonActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel2.setText("Total:");

		totalTextField.setEditable(false);

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
																				74,
																				74,
																				74)
																		.add(
																				jLabel3)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				characterNameTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				280,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				127,
																				127,
																				127)
																		.add(
																				saveJButton,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				91,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				cancelChangesJButton,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				94,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				36,
																				36,
																				36)
																		.add(
																				jPanel1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				44,
																				44,
																				44)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jLabel2)
																						.add(
																								totalTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								53,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				107,
																				107,
																				107)
																		.add(
																				jLabel1)))
										.addContainerGap(51, Short.MAX_VALUE)));
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
																				16,
																				16,
																				16)
																		.add(
																				jLabel1)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								jLabel3,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								14,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																						.add(
																								characterNameTextField,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				jPanel1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				18,
																				18,
																				18)
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.BASELINE)
																						.add(
																								cancelChangesJButton)
																						.add(
																								saveJButton)))
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				139,
																				139,
																				139)
																		.add(
																				jLabel2)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				totalTextField,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void adrenalDefenseTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void miscItemChoiceTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void specialAbilityTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void skillChoice2TextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void skillChoice1TextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void shieldChoiceTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void armorOnArmorTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void armorChoiceTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void racialModifierTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void quicknessBonusTextFieldPropertyChange(
			java.beans.PropertyChangeEvent evt) {
		_myController.attributeTextFieldChanged();
	}

	private void adrenalDefenseTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void racialModifierTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void miscItemChoiceTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void specialAbilityTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void skillChoice2TextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void skillChoice1TextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void shieldChoiceTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void armorOnArmorTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void armorChoiceTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void quicknessBonusTextFieldActionPerformed(
			java.awt.event.ActionEvent evt) {
		// not used - the propertyChangedEvent is what's working here
	}

	private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_myController.saveJButtonClicked();
	}

	private void cancelChangesJButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		_myController.cancelJButtonClicked();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CharacterDefensiveAttributesJFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JFormattedTextField adrenalDefenseTextField;
	private javax.swing.JFormattedTextField armorChoiceTextField;
	private javax.swing.JFormattedTextField armorOnArmorTextField;
	private javax.swing.JButton cancelChangesJButton;
	private javax.swing.JFormattedTextField characterNameTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JFormattedTextField miscItemChoiceTextField;
	private javax.swing.JFormattedTextField quicknessBonusTextField;
	private javax.swing.JFormattedTextField racialModifierTextField;
	private javax.swing.JButton saveJButton;
	private javax.swing.JFormattedTextField shieldChoiceTextField;
	private javax.swing.JFormattedTextField skillChoice1TextField;
	private javax.swing.JFormattedTextField skillChoice2TextField;
	private javax.swing.JFormattedTextField specialAbilityTextField;
	private javax.swing.JFormattedTextField totalTextField;

	// End of variables declaration//GEN-END:variables

	javax.swing.JFormattedTextField getCharacterNameTextField() {
		return characterNameTextField;
	}

	javax.swing.JFormattedTextField getAdrenalDefenseTextField() {
		return adrenalDefenseTextField;
	}

	javax.swing.JFormattedTextField getArmorChoiceTextField() {
		return armorChoiceTextField;
	}

	javax.swing.JFormattedTextField getArmorOnArmorTextField() {
		return armorOnArmorTextField;
	}

	javax.swing.JFormattedTextField getMiscItemChoiceTextField() {
		return miscItemChoiceTextField;
	}

	javax.swing.JFormattedTextField getQuicknessBonusTextField() {
		return quicknessBonusTextField;
	}

	javax.swing.JFormattedTextField getRacialModifierTextField() {
		return racialModifierTextField;
	}

	javax.swing.JFormattedTextField getShieldChoiceTextField() {
		return shieldChoiceTextField;
	}

	javax.swing.JFormattedTextField getSkillChoice1TextField() {
		return skillChoice1TextField;
	}

	javax.swing.JFormattedTextField getSkillChoice2TextField() {
		return skillChoice2TextField;
	}

	javax.swing.JFormattedTextField getSpecialAbilityTextField() {
		return specialAbilityTextField;
	}

	javax.swing.JFormattedTextField getTotalTextField() {
		return totalTextField;
	}

}