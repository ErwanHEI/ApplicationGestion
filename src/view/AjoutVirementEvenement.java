package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelCombo.ComboBoxDynamiqueBudget;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AjoutVirementEvenement extends JFrame {

	private JPanel contentPane;
	private JTextField champReference;
	private JTextField champEmetteur;
	private JTextField champRecepteur;
	private JTextField champDate;
	private JTextField champMontant;
	private ComboBoxDynamiqueBudget comboBoxDynamiqueBudget = new ComboBoxDynamiqueBudget();
	private JButton boutonValider;

	public AjoutVirementEvenement() {
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panelAjoutVirementEvenement = new JPanel();
		panelAjoutVirementEvenement.setBounds(5, 65, 518, 274);
		contentPane.add(panelAjoutVirementEvenement);
		panelAjoutVirementEvenement.setLayout(null);
		
		JLabel labelReference = new JLabel("R\u00E9f\u00E9rence :");
		labelReference.setBounds(15, 19, 80, 20);
		panelAjoutVirementEvenement.add(labelReference);
		
		champReference = new JTextField();
		champReference.setBounds(110, 16, 146, 26);
		panelAjoutVirementEvenement.add(champReference);
		champReference.setColumns(10);
		
		JLabel labelEmetteur = new JLabel("Emetteur :");
		labelEmetteur.setBounds(20, 58, 75, 20);
		panelAjoutVirementEvenement.add(labelEmetteur);
		
		champEmetteur = new JTextField();
		champEmetteur.setColumns(10);
		champEmetteur.setBounds(110, 55, 146, 26);
		panelAjoutVirementEvenement.add(champEmetteur);
		
		JLabel labelRecepteur = new JLabel("R\u00E9cepteur :");
		labelRecepteur.setBounds(15, 97, 81, 20);
		panelAjoutVirementEvenement.add(labelRecepteur);
		
		champRecepteur = new JTextField();
		champRecepteur.setColumns(10);
		champRecepteur.setBounds(110, 94, 146, 26);
		panelAjoutVirementEvenement.add(champRecepteur);
		
		JLabel labelDate = new JLabel("Date :");
		labelDate.setBounds(299, 22, 43, 20);
		panelAjoutVirementEvenement.add(labelDate);
		
		champDate = new JTextField();
		champDate.setColumns(10);
		champDate.setBounds(357, 19, 146, 26);
		panelAjoutVirementEvenement.add(champDate);
		
		JLabel labelMontant = new JLabel("Montant :");
		labelMontant.setBounds(274, 61, 68, 20);
		panelAjoutVirementEvenement.add(labelMontant);
		
		champMontant = new JTextField();
		champMontant.setColumns(10);
		champMontant.setBounds(357, 58, 146, 26);
		panelAjoutVirementEvenement.add(champMontant);
		
		JLabel labelBudget = new JLabel("Budget :");
		labelBudget.setBounds(282, 100, 60, 20);
		panelAjoutVirementEvenement.add(labelBudget);
		
		JComboBox comboBox = new JComboBox();
		comboBox = comboBoxDynamiqueBudget.ComboBoxDynamiqueBudget();
		comboBox.setBounds(357, 100, 146, 26);
		panelAjoutVirementEvenement.add(comboBox);
		
		boutonValider = new JButton("Valider");
		boutonValider.setBounds(198, 200, 115, 29);
		panelAjoutVirementEvenement.add(boutonValider);
		
		JLabel lblAjoutDunVirement = new JLabel("Ajout d'un virement pour l'\u00E9v\u00E8nement");
		lblAjoutDunVirement.setForeground(new Color(255, 255, 255));
		lblAjoutDunVirement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAjoutDunVirement.setBounds(84, 16, 386, 25);
		contentPane.add(lblAjoutDunVirement);
		
		
	}

	public JTextField getChampReference() {
		return champReference;
	}

	public void setChampReference(JTextField champReference) {
		this.champReference = champReference;
	}

	public JTextField getChampEmetteur() {
		return champEmetteur;
	}

	public void setChampEmetteur(JTextField champEmetteur) {
		this.champEmetteur = champEmetteur;
	}

	public JTextField getChampRecepteur() {
		return champRecepteur;
	}

	public void setChampRecepteur(JTextField champRecepteur) {
		this.champRecepteur = champRecepteur;
	}

	public JTextField getChampDate() {
		return champDate;
	}

	public void setChampDate(JTextField champDate) {
		this.champDate = champDate;
	}

	public JTextField getChampMontant() {
		return champMontant;
	}

	public void setChampMontant(JTextField champMontant) {
		this.champMontant = champMontant;
	}

	public JButton getBoutonValider() {
		return boutonValider;
	}

	public void setBoutonValider(JButton boutonValider) {
		this.boutonValider = boutonValider;
	}
	
}
