package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PanelEvenement extends JPanel {

	private JTextField champReferenceEvenement;
	private JTextField champNomEvenement;
	private JTextField champDateEvenement;
	private JTextField champBudgetPrevu;
	
	private JTable tableauEvenement;
	private JTable tableau2;
	private String supp = "Supprimer la ligne";

	
	public PanelEvenement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 1002, 665);
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel ongletEvenement = new JPanel();
		ongletEvenement.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Ev\u00E8nements", null, ongletEvenement, null);
		ongletEvenement.setLayout(null);
		
		JPanel panelEvenement = new JPanel();
		panelEvenement.setBounds(0, 0, 997, 631);
		ongletEvenement.add(panelEvenement);
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES BUDGETS--------------------------------
------------------------------------------------------------------------------------------------*/
				
				/*Object[][] data1 = {  
			   	         {supp, "", "", "", "", "", "", ""},
			   	         {supp, "", "", "", "", "", "", ""},
			   	         {supp, "", "", "", "", "", "", ""},
			   	         {supp, "", "", "", "", "", "", ""},
			   	      };
					String  title1[] = {"Suppression", "Référence", "Nom", "Date", "Produits associés", "Budget prévu", "Budget réel", "Solde"};
				
					ZModel zModel1 = new ZModel(data1, title1);		
					//this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
					this.tableauEvenement = new JTable(zModel1);
					this.tableauEvenement.setRowHeight(30);
				
					//On définit un éditeur pour la colonne "supprimer"
					this.tableauEvenement.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
					panelEvenement.setLayout(new BorderLayout(0, 0));
				
					//On ajoute le tableau
					JScrollPane scrollPaneEvenement = new JScrollPane(tableauEvenement);
					panelEvenement.add(scrollPaneEvenement);*/
				
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/	
		
		JPanel ongletGestion = new JPanel();
		ongletGestion.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Gestion", null, ongletGestion, null);
		ongletGestion.setLayout(null);
		
		JPanel panelCreationEvenement = new JPanel();
		panelCreationEvenement.setBounds(0, 0, 997, 340);
		ongletGestion.add(panelCreationEvenement);
		panelCreationEvenement.setLayout(null);
		
		JLabel labelCreationEvenement = new JLabel("Cr\u00E9ation d'un \u00E9v\u00E8nement");
		labelCreationEvenement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelCreationEvenement.setBounds(15, 16, 334, 37);
		panelCreationEvenement.add(labelCreationEvenement);
		
		JLabel labelReferenceEvenement = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceEvenement.setForeground(Color.BLACK);
		labelReferenceEvenement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReferenceEvenement.setBounds(323, 69, 102, 24);
		panelCreationEvenement.add(labelReferenceEvenement);
		
		champReferenceEvenement = new JTextField();
		champReferenceEvenement.setColumns(10);
		champReferenceEvenement.setBounds(440, 70, 400, 26);
		panelCreationEvenement.add(champReferenceEvenement);
		
		JLabel labelNomEvenement = new JLabel("Nom :");
		labelNomEvenement.setForeground(Color.BLACK);
		labelNomEvenement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomEvenement.setBounds(371, 109, 54, 24);
		panelCreationEvenement.add(labelNomEvenement);
		
		champNomEvenement = new JTextField();
		champNomEvenement.setColumns(10);
		champNomEvenement.setBounds(440, 110, 400, 26);
		panelCreationEvenement.add(champNomEvenement);
		
		JLabel labelDateEvenement = new JLabel("Date de commencement :");
		labelDateEvenement.setForeground(Color.BLACK);
		labelDateEvenement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDateEvenement.setBounds(193, 149, 232, 24);
		panelCreationEvenement.add(labelDateEvenement);
		
		champDateEvenement = new JTextField();
		champDateEvenement.setColumns(10);
		champDateEvenement.setBounds(440, 150, 400, 26);
		panelCreationEvenement.add(champDateEvenement);
		
		JLabel labelBudgetPrevu = new JLabel("Budget pr\u00E9vu :");
		labelBudgetPrevu.setForeground(Color.BLACK);
		labelBudgetPrevu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelBudgetPrevu.setBounds(293, 189, 132, 24);
		panelCreationEvenement.add(labelBudgetPrevu);
		
		champBudgetPrevu = new JTextField();
		champBudgetPrevu.setColumns(10);
		champBudgetPrevu.setBounds(440, 190, 400, 26);
		panelCreationEvenement.add(champBudgetPrevu);
		
		JLabel labelProduitNecessaire = new JLabel("Produits n\u00E9cessaires :");
		labelProduitNecessaire.setForeground(Color.BLACK);
		labelProduitNecessaire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelProduitNecessaire.setBounds(231, 229, 194, 24);
		panelCreationEvenement.add(labelProduitNecessaire);
		
		JButton boutonCreerEvenement = new JButton("Cr\u00E9er");
		boutonCreerEvenement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonCreerEvenement.setBounds(762, 294, 220, 30);
		panelCreationEvenement.add(boutonCreerEvenement);
		
		JComboBox comboBoxProduitNecessaire = new JComboBox();
		comboBoxProduitNecessaire.setBounds(440, 230, 400, 26);
		panelCreationEvenement.add(comboBoxProduitNecessaire);
		
		JLabel labelOptionnel = new JLabel("(optionnel)");
		labelOptionnel.setBounds(855, 193, 78, 20);
		panelCreationEvenement.add(labelOptionnel);
		
		JLabel labelImage = new JLabel("image");
		labelImage.setBounds(865, 233, 69, 20);
		panelCreationEvenement.add(labelImage);
		
		JPanel ongletJournal = new JPanel();
		tabbedPane.addTab("Journal", null, ongletJournal, null);
	}

}
