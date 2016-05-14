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
import java.awt.Toolkit;

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
	
	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;

	public AjoutVirementEvenement() {
		setBounds((int) ((x/2)-((550*adaptx)/2)), (int) ((y/2)-((400*adapty)/2)), (int) (550*adaptx), (int) (400*adaptx));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder((int) (5*adapty), (int) (5*adapty), (int) (5*adapty), (int) (5*adapty)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panelAjoutVirementEvenement = new JPanel();
		panelAjoutVirementEvenement.setBounds((int) (5*adaptx), (int) (65*adapty), (int) (518*adaptx), (int) (274*adaptx));
		contentPane.add(panelAjoutVirementEvenement);
		panelAjoutVirementEvenement.setLayout(null);
		
		JLabel labelReference = new JLabel("R\u00E9f\u00E9rence :");
		labelReference.setBounds((int) (15*adaptx), (int) (19*adapty), (int) (80*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelReference);
		
		champReference = new JTextField();
		champReference.setBounds((int) (110*adaptx), (int) (16*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(champReference);
		champReference.setColumns(10);
		
		JLabel labelEmetteur = new JLabel("Emetteur :");
		labelEmetteur.setBounds((int) (20*adaptx), (int) (58*adapty), (int) (75*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelEmetteur);
		
		champEmetteur = new JTextField();
		champEmetteur.setColumns(10);
		champEmetteur.setBounds((int) (110*adaptx), (int) (55*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(champEmetteur);
		
		JLabel labelRecepteur = new JLabel("R\u00E9cepteur :");
		labelRecepteur.setBounds((int) (15*adaptx), (int) (97*adapty), (int) (81*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelRecepteur);
		
		champRecepteur = new JTextField();
		champRecepteur.setColumns(10);
		champRecepteur.setBounds((int) (110*adaptx), (int) (94*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(champRecepteur);
		
		JLabel labelDate = new JLabel("Date :");
		labelDate.setBounds((int) (299*adaptx), (int) (22*adapty), (int) (43*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelDate);
		
		champDate = new JTextField();
		champDate.setColumns(10);
		champDate.setBounds((int) (357*adaptx), (int) (19*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(champDate);
		
		JLabel labelMontant = new JLabel("Montant :");
		labelMontant.setBounds((int) (274*adaptx), (int) (61*adapty), (int) (68*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelMontant);
		
		champMontant = new JTextField();
		champMontant.setColumns(10);
		champMontant.setBounds((int) (357*adaptx), (int) (58*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(champMontant);
		
		JLabel labelBudget = new JLabel("Budget :");
		labelBudget.setBounds((int) (282*adaptx), (int) (100*adapty), (int) (60*adaptx), (int) (20*adaptx));
		panelAjoutVirementEvenement.add(labelBudget);
		
		JComboBox comboBox = new JComboBox();
		comboBox = comboBoxDynamiqueBudget.ComboBoxDynamiqueBudget();
		comboBox.setBounds((int) (357*adaptx), (int) (100*adapty), (int) (146*adaptx), (int) (26*adaptx));
		panelAjoutVirementEvenement.add(comboBox);
		
		boutonValider = new JButton("Valider");
		boutonValider.setBounds((int) (198*adaptx), (int) (200*adapty), (int) (115*adaptx), (int) (29*adaptx));
		panelAjoutVirementEvenement.add(boutonValider);
		
		JLabel lblAjoutDunVirement = new JLabel("Ajout d'un virement pour l'\u00E9v\u00E8nement");
		lblAjoutDunVirement.setForeground(new Color(255, 255, 255));
		lblAjoutDunVirement.setFont(new Font("Tahoma", Font.BOLD, (int) (20*adaptx)));
		lblAjoutDunVirement.setBounds((int) (84*adaptx), (int) (16*adapty), (int) (386*adaptx), (int) (25*adaptx));
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

	public ComboBoxDynamiqueBudget getComboBoxDynamiqueBudget() {
		return comboBoxDynamiqueBudget;
	}

	public void setComboBoxDynamiqueBudget(ComboBoxDynamiqueBudget comboBoxDynamiqueBudget) {
		this.comboBoxDynamiqueBudget = comboBoxDynamiqueBudget;
	}
	
	
}
