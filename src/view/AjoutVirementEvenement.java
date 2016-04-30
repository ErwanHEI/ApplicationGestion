package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class AjoutVirementEvenement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutVirementEvenement frame = new AjoutVirementEvenement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjoutVirementEvenement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAjoutVirementEvenement = new JPanel();
		panelAjoutVirementEvenement.setBounds(5, 65, 518, 274);
		contentPane.add(panelAjoutVirementEvenement);
		panelAjoutVirementEvenement.setLayout(null);
		
		JLabel labelReference = new JLabel("R\u00E9f\u00E9rence :");
		labelReference.setBounds(123, 19, 80, 20);
		panelAjoutVirementEvenement.add(labelReference);
		
		textField = new JTextField();
		textField.setBounds(218, 16, 146, 26);
		panelAjoutVirementEvenement.add(textField);
		textField.setColumns(10);
		
		JLabel labelEmetteur = new JLabel("Emetteur :");
		labelEmetteur.setBounds(128, 58, 75, 20);
		panelAjoutVirementEvenement.add(labelEmetteur);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 55, 146, 26);
		panelAjoutVirementEvenement.add(textField_1);
		
		JLabel labelRecepteur = new JLabel("R\u00E9cepteur :");
		labelRecepteur.setBounds(123, 97, 81, 20);
		panelAjoutVirementEvenement.add(labelRecepteur);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 94, 146, 26);
		panelAjoutVirementEvenement.add(textField_2);
		
		JLabel labelDate = new JLabel("Date :");
		labelDate.setBounds(160, 136, 43, 20);
		panelAjoutVirementEvenement.add(labelDate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(218, 133, 146, 26);
		panelAjoutVirementEvenement.add(textField_3);
		
		JLabel labelMontant = new JLabel("Montant :");
		labelMontant.setBounds(135, 175, 68, 20);
		panelAjoutVirementEvenement.add(labelMontant);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(218, 172, 146, 26);
		panelAjoutVirementEvenement.add(textField_4);
		
		JLabel labelBudget = new JLabel("Budget :");
		labelBudget.setBounds(143, 214, 60, 20);
		panelAjoutVirementEvenement.add(labelBudget);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(218, 214, 146, 26);
		panelAjoutVirementEvenement.add(comboBox);
		
		JLabel lblAjoutDunVirement = new JLabel("Ajout d'un virement pour l'\u00E9v\u00E8nement");
		lblAjoutDunVirement.setForeground(new Color(255, 255, 255));
		lblAjoutDunVirement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAjoutDunVirement.setBounds(84, 16, 386, 25);
		contentPane.add(lblAjoutDunVirement);
		
		
	}
}
