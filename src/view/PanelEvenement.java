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
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

import entitie.Evenement;
import entitie.Virement;
import manager.EvenementManager;
import modelTableau.ModeleTableauListeBudget;
import modelTableau.ModeleTableauListeProduit;
import modelTableau.ModeleTableauProduitEvenement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

public class PanelEvenement extends JPanel{

private JPanel panelScroll;
	
	private JTextField champReferenceEvenement;
	private JTextField champNomEvenement;
	private JTextField champDateEvenement;
	
	private JButton boutonAjouterVirement;
	private JButton boutonCreerEvenement;
	
	private ModeleTableauListeProduit modeleListeProduit = new ModeleTableauListeProduit();
	private ModeleTableauListeBudget modeleListeBudget = new ModeleTableauListeBudget();
	private ModeleTableauProduitEvenement modeleTableauProduitEvenement;

	private JTable tableauProduitEvenement;
	
	private List<Virement> listeVirementEvenement;

	private EvenementManager evenementManager = new EvenementManager();
	private List<Evenement> listeEvenement;
	private Evenement evenement;
	
	private String html1 = "<html><body style = 'margin:0;padding-top:5px;padding-bottom:5px;padding-left:10px;font-size:1.4em;font-family:Verdana'>";
    private String html2 =  "</body></html>";
    private JTextField champRecherche;
	private LayoutManager panelComposantEvenement;
	
	public PanelEvenement() {
		initialize();
	}

	private void initialize() {
		
		listeVirementEvenement = new ArrayList<Virement>();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 1002, 665);
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel ongletEvenement = new JPanel();
		ongletEvenement.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Ev\u00E8nements"+html2, new ImageIcon("../ApplicationGestion/src/image/evenement.png"), ongletEvenement, null);
		ongletEvenement.setLayout(null);
		
		JPanel panelScroll = new JPanel();
		listeEvenement = evenementManager.listerEvent();
		panelScroll.setLayout(new GridLayout(listeEvenement.size(), 1));
		JScrollPane scrollPaneEvenement = new JScrollPane();
		scrollPaneEvenement.setBounds(0, 66, 997, 530);
		scrollPaneEvenement.getVerticalScrollBar().setUnitIncrement(30);
		
		for(int i=0; i<listeEvenement.size(); i++){
			evenement = listeEvenement.get(i);
			
			JPanel panel = new JPanel();
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			String nomEvenement = evenement.getNomEvenement();
			String dateEvenement = evenement.getDateEvent();
			
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(0, 200));
			panel.setBorder(border);
			
			JLabel labelEvenement = new JLabel(nomEvenement);
			labelEvenement.setFont(new Font("Tahoma", Font.BOLD, 27));
			labelEvenement.setBounds(15, 16, 600, 37);
			panel.add(labelEvenement);
			
			JLabel labelDate = new JLabel("Date : "+dateEvenement);
			labelDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
			labelDate.setBounds(765, 16, 220, 37);
			panel.add(labelDate);
			
			
			modeleTableauProduitEvenement = new ModeleTableauProduitEvenement(evenement);
			JTable tableauProduit = new JTable(modeleTableauProduitEvenement);
						
			JScrollPane scrollPane = new JScrollPane(tableauProduit);
			scrollPane.setBounds(100, 69, 300, 100);
			panel.add(scrollPane);

			panelScroll.add(panel);
		}
		
		
		
		scrollPaneEvenement.setViewportView(panelScroll);
		ongletEvenement.add(scrollPaneEvenement);
		
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBounds(0, 0, 997, 50);
		ongletEvenement.add(panelRecherche);
		panelRecherche.setLayout(null);
		
		JLabel lblRechercher = new JLabel("Rechercher :");
		lblRechercher.setBounds(230, 20, 89, 20);
		panelRecherche.add(lblRechercher);
		
		champRecherche = new JTextField();
		champRecherche.setBounds(334, 17, 300, 26);
		panelRecherche.add(champRecherche);
		champRecherche.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(680, 16, 115, 29);
		panelRecherche.add(btnNewButton);
		

		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------ONGLET GESTION--------------------------------
------------------------------------------------------------------------------------------------*/

		
		JPanel ongletGestion = new JPanel();
		ongletGestion.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Gestion"+html2, new ImageIcon("../ApplicationGestion/src/image/gestion.png"), ongletGestion, null);
		ongletGestion.setLayout(null);
		
		JPanel panelCreationEvenement = new JPanel();
		panelCreationEvenement.setBounds(0, 0, 997, 230);
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
		
		JLabel labelBudgetPrevu = new JLabel("Virement :");
		labelBudgetPrevu.setForeground(Color.BLACK);
		labelBudgetPrevu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelBudgetPrevu.setBounds(331, 189, 94, 24);
		panelCreationEvenement.add(labelBudgetPrevu);
		
		JLabel labelOptionnel = new JLabel("(optionnel)");
		labelOptionnel.setBounds(855, 193, 78, 20);
		panelCreationEvenement.add(labelOptionnel);
		
		boutonAjouterVirement = new JButton("Ajouter");
		boutonAjouterVirement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonAjouterVirement.setBounds(440, 189, 400, 29);
		panelCreationEvenement.add(boutonAjouterVirement);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 246, 997, 369);
		ongletGestion.add(panel);
		panel.setLayout(null);
		
		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES PRODUITS--------------------------------
------------------------------------------------------------------------------------------------*/			
		JLabel labelProduitNecessaire = new JLabel("Produits n\u00E9cessaires :");
		labelProduitNecessaire.setBounds(15, 16, 194, 24);
		panel.add(labelProduitNecessaire);
		labelProduitNecessaire.setForeground(Color.BLACK);
		labelProduitNecessaire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		tableauProduitEvenement = new JTable(modeleListeProduit);
		tableauProduitEvenement.getColumnModel().getColumn(6).setMaxWidth(0);
		tableauProduitEvenement.getColumnModel().getColumn(6).setMinWidth(0);
		tableauProduitEvenement.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		JScrollPane scrollPane = new JScrollPane(tableauProduitEvenement);
		scrollPane.setBounds(0, 48, 997, 259);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		boutonCreerEvenement = new JButton("Cr\u00E9er");
		boutonCreerEvenement.setBounds(387, 323, 220, 30);
		panel.add(boutonCreerEvenement);
		boutonCreerEvenement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
		JPanel ongletJournal = new JPanel();
		tabbedPane.addTab(html1+"Journal"+html2, new ImageIcon("../ApplicationGestion/src/image/journal.png"), ongletJournal, null);

	}

	public JTextField getChampReferenceEvenement() {
		return champReferenceEvenement;
	}

	public void setChampReferenceEvenement(JTextField champReferenceEvenement) {
		this.champReferenceEvenement = champReferenceEvenement;
	}

	public JTextField getChampNomEvenement() {
		return champNomEvenement;
	}

	public void setChampNomEvenement(JTextField champNomEvenement) {
		this.champNomEvenement = champNomEvenement;
	}

	public JTextField getChampDateEvenement() {
		return champDateEvenement;
	}

	public void setChampDateEvenement(JTextField champDateEvenement) {
		this.champDateEvenement = champDateEvenement;
	}

	public JButton getBoutonCreerEvenement() {
		return boutonCreerEvenement;
	}

	public JButton getBoutonAjouterVirement() {
		return boutonAjouterVirement;
	}

	public void setBoutonAjouterVirement(JButton boutonAjouterVirement) {
		this.boutonAjouterVirement = boutonAjouterVirement;
	}

	public void setBoutonCreerEvenement(JButton boutonCreerEvenement) {
		this.boutonCreerEvenement = boutonCreerEvenement;
	}

	public ModeleTableauListeProduit getModeleListeProduit() {
		return modeleListeProduit;
	}

	public void setModeleListeProduit(ModeleTableauListeProduit modeleListeProduit) {
		this.modeleListeProduit = modeleListeProduit;
	}

	public ModeleTableauListeBudget getModeleListeBudget() {
		return modeleListeBudget;
	}

	public void setModeleListeBudget(ModeleTableauListeBudget modeleListeBudget) {
		this.modeleListeBudget = modeleListeBudget;
	}

	public JTable getTableauProduitEvenement() {
		return tableauProduitEvenement;
	}

	public void setTableauProduitEvenement(JTable tableauProduitEvenement) {
		this.tableauProduitEvenement = tableauProduitEvenement;
	}
	
	
	public List<Virement> getListeVirementEvenement() {
		return listeVirementEvenement;
	}

	public void setListeVirementEvenement(List<Virement> listeVirementEvenement) {
		this.listeVirementEvenement = listeVirementEvenement;
	}
}

