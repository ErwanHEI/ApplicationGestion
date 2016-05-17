package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import entitie.Evenement;
import entitie.Virement;
import manager.EvenementManager;
import manager.VirementManager;
import modelTableau.ModeleTableauListeBudget;
import modelTableau.ModeleTableauListeProduit;
import modelTableau.ModeleTableauProduitEvenement;
import modelTableau.ModeleTableauVirementEvenement;

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
	private ModeleTableauVirementEvenement modeleTableauVirementEvenement;

	private JTable tableauProduitEvenement;

	private EvenementManager evenementManager = new EvenementManager();
	private List<Evenement> listeEvenement;
	private Evenement evenement;
	
	private String html1 = "<html><body style = 'margin:0;padding-top:5px;padding-bottom:5px;padding-left:10px;font-size:1.4em;font-family:Verdana'>";
    private String html2 =  "</body></html>";
    private JTextField champRecherche;
	private LayoutManager panelComposantEvenement;
	
	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;
	
	public PanelEvenement() {
		initialize();
	}

	private void initialize() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, (int) (16*adapty), (int) (1002*adaptx), (int) (665*adaptx));
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
		scrollPaneEvenement.setBounds(0, (int) (66*adapty), (int) (997*adaptx), (int) (530*adaptx));
		scrollPaneEvenement.getVerticalScrollBar().setUnitIncrement(30);
		
		for(int i=0; i<listeEvenement.size(); i++){
			evenement = listeEvenement.get(i);
			
			JPanel panel = new JPanel();
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			String nomEvenement = evenement.getNomEvenement();
			String dateEvenement = evenement.getDateEvent();
			
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(0, (int) (200*adaptx)));
			panel.setBorder(border);
			
			JLabel labelEvenement = new JLabel(nomEvenement);
			labelEvenement.setFont(new Font("Tahoma", Font.BOLD, (int) (27*adaptx)));
			labelEvenement.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (600*adaptx), (int) (37*adaptx));
			panel.add(labelEvenement);
			
			JLabel labelDate = new JLabel("Date : "+dateEvenement);
			labelDate.setFont(new Font("Tahoma", Font.PLAIN, (int) (22*adaptx)));
			labelDate.setBounds((int) (765*adaptx), (int) (16*adapty), (int) (220*adaptx), (int) (37*adaptx));
			panel.add(labelDate);
			
			
			modeleTableauProduitEvenement = new ModeleTableauProduitEvenement(evenement);
			JTable tableauProduit = new JTable(modeleTableauProduitEvenement);
			tableauProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
			tableauProduit.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (10*adaptx)));
			tableauProduit.setRowHeight((int) (21*adaptx));
			
			modeleTableauVirementEvenement = new ModeleTableauVirementEvenement(evenement);
			JTable tableauVirement = new JTable(modeleTableauVirementEvenement);
			tableauVirement.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
			tableauVirement.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (10*adaptx)));
			tableauVirement.setRowHeight((int) (21*adaptx));
			
			
			
			JScrollPane scrollPane = new JScrollPane(tableauProduit);
			scrollPane.setBounds((int) (100*adaptx), (int) (69*adapty), (int) (300*adaptx), (int) (100*adaptx));
			panel.add(scrollPane);
			
			JScrollPane scrollPane2 = new JScrollPane(tableauVirement);
			scrollPane2.setBounds((int) (500*adaptx), (int) (69*adapty), (int) (300*adaptx), (int) (100*adaptx));
			panel.add(scrollPane2);

			panelScroll.add(panel);
		}
		
		
		
		scrollPaneEvenement.setViewportView(panelScroll);
		ongletEvenement.add(scrollPaneEvenement);
		
		JPanel panelRecherche = new JPanel();
		panelRecherche.setBounds(0, 0, (int) (997*adaptx), (int) (50*adaptx));
		ongletEvenement.add(panelRecherche);
		panelRecherche.setLayout(null);
		
		JLabel labelRechercher = new JLabel("Rechercher :");
		labelRechercher.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		labelRechercher.setBounds((int) (234*adaptx), (int) (4*adapty), (int) (92*adaptx), (int) (38*adaptx));
		panelRecherche.add(labelRechercher);
		
		champRecherche = new JTextField();
		champRecherche.setBounds((int) (334*adaptx), (int) (17*adapty), (int) (300*adaptx), (int) (26*adaptx));
		panelRecherche.add(champRecherche);
		champRecherche.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds((int) (680*adaptx), (int) (16*adapty), (int) (115*adaptx), (int) (29*adaptx));
		panelRecherche.add(btnNewButton);
		

		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------ONGLET GESTION--------------------------------
------------------------------------------------------------------------------------------------*/

		
		JPanel ongletGestion = new JPanel();
		ongletGestion.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Gestion"+html2, new ImageIcon("../ApplicationGestion/src/image/gestion.png"), ongletGestion, null);
		ongletGestion.setLayout(null);
		
		JPanel panelCreationEvenement = new JPanel();
		panelCreationEvenement.setBounds(0, 0, (int) (997*adaptx), (int) (230*adapty));
		ongletGestion.add(panelCreationEvenement);
		panelCreationEvenement.setLayout(null);
		
		JLabel labelCreationEvenement = new JLabel("Cr\u00E9ation d'un \u00E9v\u00E8nement");
		labelCreationEvenement.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelCreationEvenement.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (334*adaptx), (int) (37*adaptx));
		panelCreationEvenement.add(labelCreationEvenement);
		
		JLabel labelReferenceEvenement = new JLabel("R\u00E9f\u00E9rence :");
		labelReferenceEvenement.setForeground(Color.BLACK);
		labelReferenceEvenement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelReferenceEvenement.setBounds((int) (323*adaptx), (int) (69*adapty), (int) (102*adaptx), (int) (24*adaptx));
		panelCreationEvenement.add(labelReferenceEvenement);
		
		champReferenceEvenement = new JTextField();
		champReferenceEvenement.setColumns(10);
		champReferenceEvenement.setBounds((int) (440*adaptx), (int) (70*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelCreationEvenement.add(champReferenceEvenement);
		
		JLabel labelNomEvenement = new JLabel("Nom :");
		labelNomEvenement.setForeground(Color.BLACK);
		labelNomEvenement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNomEvenement.setBounds((int) (371*adaptx), (int) (109*adapty), (int) (54*adaptx), (int) (24*adaptx));
		panelCreationEvenement.add(labelNomEvenement);
		
		champNomEvenement = new JTextField();
		champNomEvenement.setColumns(10);
		champNomEvenement.setBounds((int) (440*adaptx), (int) (110*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelCreationEvenement.add(champNomEvenement);
		
		JLabel labelDateEvenement = new JLabel("Date de commencement :");
		labelDateEvenement.setForeground(Color.BLACK);
		labelDateEvenement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelDateEvenement.setBounds((int) (193*adaptx), (int) (149*adapty), (int) (232*adaptx), (int) (24*adaptx));
		panelCreationEvenement.add(labelDateEvenement);
		
		champDateEvenement = new JTextField();
		champDateEvenement.setColumns(10);
		champDateEvenement.setBounds((int) (440*adaptx), (int) (150*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelCreationEvenement.add(champDateEvenement);
		
		JLabel labelBudgetPrevu = new JLabel("Virement :");
		labelBudgetPrevu.setForeground(Color.BLACK);
		labelBudgetPrevu.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelBudgetPrevu.setBounds((int) (331*adaptx), (int) (189*adapty), (int) (94*adaptx), (int) (24*adaptx));
		panelCreationEvenement.add(labelBudgetPrevu);
		
		JLabel labelOptionnel = new JLabel("(optionnel)");
		labelOptionnel.setBounds((int) (855*adaptx), (int) (193*adapty), (int) (78*adaptx), (int) (20*adaptx));
		panelCreationEvenement.add(labelOptionnel);
		
		boutonAjouterVirement = new JButton("Ajouter");
		boutonAjouterVirement.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		boutonAjouterVirement.setBounds((int) (440*adaptx), (int) (189*adapty), (int) (400*adaptx), (int) (29*adaptx));
		panelCreationEvenement.add(boutonAjouterVirement);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, (int) (246*adapty), (int) (997*adaptx), (int) (369*adapty));
		ongletGestion.add(panel);
		panel.setLayout(null);
		
		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES PRODUITS--------------------------------
------------------------------------------------------------------------------------------------*/			
		JLabel labelProduitNecessaire = new JLabel("Produits n\u00E9cessaires :");
		labelProduitNecessaire.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (194*adaptx), (int) (24*adaptx));
		panel.add(labelProduitNecessaire);
		labelProduitNecessaire.setForeground(Color.BLACK);
		labelProduitNecessaire.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		
		tableauProduitEvenement = new JTable(modeleListeProduit);
		tableauProduitEvenement.getColumnModel().getColumn(6).setMaxWidth(0);
		tableauProduitEvenement.getColumnModel().getColumn(6).setMinWidth(0);
		tableauProduitEvenement.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		JScrollPane scrollPane = new JScrollPane(tableauProduitEvenement);
		scrollPane.setBounds(0, (int) (48*adapty), (int) (997*adaptx), (int) (259*adapty));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		boutonCreerEvenement = new JButton("Cr\u00E9er");
		boutonCreerEvenement.setBounds((int) (387*adaptx), (int) (323*adapty), (int) (220*adaptx), (int) (30*adaptx));
		panel.add(boutonCreerEvenement);
		boutonCreerEvenement.setFont(new Font("Tahoma", Font.PLAIN, (int) (25*adaptx)));
		
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
	

}
