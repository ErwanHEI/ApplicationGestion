package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.table.TableModel;

import controler.ControlerAjoutStockage;
import controler.ControleurAjoutProduit;
import entitie.Fournisseur;
import entitie.Produit;
import entitie.Stockage;
import modelCombo.ComboBoxDynamiqueFournisseur;
import modelCombo.ComboxBoxDynamiqueModifierProduit;
import modelCombo.ComboxBoxDynamiqueStockage;
import modelFiltres.FiltreJournalProduit;
import modelFiltres.FiltreProduit;
import modelTableau.ModeleTableauJournalProduit;
import modelTableau.ModeleTableauLieuStockage;
import modelTableau.ModeleTableauListeProduit;

public class PanelProduit extends JPanel{

	
	private JLabel labelErreurAjoutProduit;

	private JTextField champRecherche;
	private JTextField champCategorie;
	private JTextField champNomProduit;
	private JTextField champPrixUnitaireProduit;
	private JTextField champQuantiteProduit;
	private JTextField champNouvelleQuantite;
	private JTextField champNouveauPrix;
	private JTextField champCommentaire;
	private JTextField champNomLieu;
	private JTextField champLocalisationLieu;
	private JTextField champFournisseurProduit;
	
	private ModeleTableauListeProduit modeleListeProduit = new ModeleTableauListeProduit();
	private ModeleTableauLieuStockage modeleLieuStockage = new ModeleTableauLieuStockage();
	private ModeleTableauJournalProduit modeleJournalProduit = new ModeleTableauJournalProduit();
	
	private ComboxBoxDynamiqueStockage comboxBoxDynamiqueStockage=new ComboxBoxDynamiqueStockage();
	private ComboxBoxDynamiqueModifierProduit comboxBoxDynamiqueModifierProduit=new ComboxBoxDynamiqueModifierProduit();
	private ComboBoxDynamiqueFournisseur comboBoxDynamiqueFournisseur=new ComboBoxDynamiqueFournisseur();
	
	private FiltreProduit filtreProduit = new FiltreProduit();
	private FiltreJournalProduit filtreJournalProduit = new FiltreJournalProduit();
	
	private JButton boutonSupprimerProduit;
	private JButton boutonSupprimerStockage;
	private JButton boutonModifierCapacite;
	private JButton boutonSupprimerJournalProduit;
	
	private JTable tableauProduit;
	private JTable tableauLieuStockage;
	private JTable tableauJournalStock;
	
	private JButton boutonAjouterProduit; 
	private JButton boutonModifierProduit;
	private JPanel panelLieuStockage;
	private JButton boutonAjouterLieu;
	
	private String html1 = "<html><body style = 'margin:0;padding-top:5px;padding-bottom:5px;padding-left:10px;font-size:1.4em;font-family:Verdana'>";
    private String html2 =  "</body></html>";
    private String html3 = "<html><body style = 'margin:0;font-size:1.2em;font-family:Verdana'>";

	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;

	
	public PanelProduit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 16, 1002, 662);
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel ongletProduit = new JPanel();
		tabbedPane.addTab("Produit", null, ongletProduit, null);
		ongletProduit.setLayout(null);
		
		JLabel rechercherProduit = new JLabel("Rechercher un produit :");
		rechercherProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rechercherProduit.setBounds(101, 48, 215, 20);
		ongletProduit.add(rechercherProduit);
		
		champRecherche = new JTextField();
		champRecherche.setBounds(331, 47, 300, 26);
		ongletProduit.add(champRecherche);
		champRecherche.setColumns(10);
		
		JButton boutonRechercher = new JButton("Rechercher");
		boutonRechercher.setBounds(696, 46, 200, 29);
		ongletProduit.add(boutonRechercher);
		
		JLabel filtres = new JLabel("Filtres :");
		filtres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		filtres.setBounds(243, 106, 73, 20);
		ongletProduit.add(filtres);
		
		JComboBox comboBoxFiltres = new JComboBox();
		comboBoxFiltres = filtreProduit.FiltreProduit(modeleListeProduit);
		comboBoxFiltres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxFiltres.setBounds(331, 105, 300, 26);
		ongletProduit.add(comboBoxFiltres);
		
		JPanel panelListeProduit = new JPanel();
		panelListeProduit.setBounds(0, 169, 997, 427);
		ongletProduit.add(panelListeProduit);
		panelListeProduit.setLayout(new BorderLayout(0, 0));
		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES PRODUITS--------------------------------
------------------------------------------------------------------------------------------------*/		
		
		tableauProduit = new JTable(modeleListeProduit);
		tableauProduit.getColumnModel().getColumn(6).setMaxWidth(0);
		tableauProduit.getColumnModel().getColumn(6).setMinWidth(0);
		tableauProduit.getColumnModel().getColumn(6).setPreferredWidth(0);
		
		
		JScrollPane scrollPaneProduit = new JScrollPane(tableauProduit);
		panelListeProduit.add(scrollPaneProduit, BorderLayout.CENTER);
		
		boutonSupprimerProduit = new JButton("Supprimer");
		boutonSupprimerProduit.setBounds(360, 599, 262, 29);
		ongletProduit.add(boutonSupprimerProduit);
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
		
		JTabbedPane ongletGestion = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Gestion", null, ongletGestion, null);
		
		JPanel panelGestionProduit = new JPanel();
		panelGestionProduit.setBackground(new Color(51, 102, 204));
		ongletGestion.addTab("Gestion des produits", null, panelGestionProduit, null);
		panelGestionProduit.setLayout(null);
		
		JPanel panelAjoutProduit = new JPanel();
		panelAjoutProduit.setBounds(0, 14, 992, 290);
		panelGestionProduit.add(panelAjoutProduit);
		panelAjoutProduit.setLayout(null);
		
		JLabel labelAjoutProduit = new JLabel("Ajout d'un produit");
		labelAjoutProduit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelAjoutProduit.setBounds(15, 16, 251, 37);
		panelAjoutProduit.add(labelAjoutProduit);
		
		JLabel labelReferenceProduit = new JLabel("Catégorie :");
		labelReferenceProduit.setForeground(Color.BLACK);
		labelReferenceProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelReferenceProduit.setBounds(68, 90, 102, 24);
		panelAjoutProduit.add(labelReferenceProduit);
		
		champCategorie = new JTextField();
		champCategorie.setColumns(10);
		champCategorie.setBounds(185, 91, 250, 26);
		panelAjoutProduit.add(champCategorie);
		
		JLabel labelNomProduit = new JLabel("Nom :");
		labelNomProduit.setForeground(Color.BLACK);
		labelNomProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomProduit.setBounds(116, 130, 54, 24);
		panelAjoutProduit.add(labelNomProduit);
		
		champNomProduit = new JTextField();
		champNomProduit.setColumns(10);
		champNomProduit.setBounds(185, 131, 250, 26);
		panelAjoutProduit.add(champNomProduit);
		
		JLabel labelPrixUnitaireProduit = new JLabel("Prix unitaire :");
		labelPrixUnitaireProduit.setForeground(Color.BLACK);
		labelPrixUnitaireProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPrixUnitaireProduit.setBounds(50, 170, 120, 24);
		panelAjoutProduit.add(labelPrixUnitaireProduit);
		
		champPrixUnitaireProduit = new JTextField();
		champPrixUnitaireProduit.setColumns(10);
		champPrixUnitaireProduit.setBounds(185, 171, 250, 26);
		panelAjoutProduit.add(champPrixUnitaireProduit);
		
		JLabel labelQuantiteProduit = new JLabel("Quantit\u00E9 :");
		labelQuantiteProduit.setForeground(Color.BLACK);
		labelQuantiteProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelQuantiteProduit.setBounds(543, 90, 90, 24);
		panelAjoutProduit.add(labelQuantiteProduit);
		
		champQuantiteProduit = new JTextField();
		champQuantiteProduit.setColumns(10);
		champQuantiteProduit.setBounds(648, 91, 250, 26);
		panelAjoutProduit.add(champQuantiteProduit);
		
		JLabel labelFournisseurProduit = new JLabel("Fournisseur :");
		labelFournisseurProduit.setForeground(Color.BLACK);
		labelFournisseurProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelFournisseurProduit.setBounds(518, 130, 115, 24);
		panelAjoutProduit.add(labelFournisseurProduit);
		
		JComboBox comboFournisseur=new JComboBox();
		comboFournisseur=comboBoxDynamiqueFournisseur.ComboxBoxDynamiqueFournisseur();
		comboFournisseur.setBounds(648, 131, 250, 26);
		panelAjoutProduit.add(comboFournisseur);
		
		JLabel labelLieuStockageProduit = new JLabel("Lieu de stockage :");
		labelLieuStockageProduit.setForeground(Color.BLACK);
		labelLieuStockageProduit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLieuStockageProduit.setBounds(470, 170, 163, 24);
		panelAjoutProduit.add(labelLieuStockageProduit);
		
		JComboBox comboBoxLieuStockageProduit = new JComboBox();
		comboBoxLieuStockageProduit=comboxBoxDynamiqueStockage.ComboxBoxDynamiqueLieuStockage();
		comboBoxLieuStockageProduit.setBounds(648, 171, 250, 26);
		panelAjoutProduit.add(comboBoxLieuStockageProduit);
		
		boutonAjouterProduit = new JButton("Ajouter");
		boutonAjouterProduit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonAjouterProduit.setBounds(757, 244, 220, 30);
		panelAjoutProduit.add(boutonAjouterProduit);
		
		labelErreurAjoutProduit = new JLabel("");
		labelErreurAjoutProduit.setForeground(Color.RED);
		labelErreurAjoutProduit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelErreurAjoutProduit.setBounds(333, 237, 409, 37);
		panelAjoutProduit.add(labelErreurAjoutProduit);
		
		JPanel panelModifierProduit = new JPanel();
		panelModifierProduit.setBounds(0, 320, 992, 274);
		panelGestionProduit.add(panelModifierProduit);
		panelModifierProduit.setLayout(null);
		
		JLabel labelModifierProduit = new JLabel("Modifier un produit");
		labelModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelModifierProduit.setBounds(15, 16, 265, 37);
		panelModifierProduit.add(labelModifierProduit);
		
		JComboBox comboBoxModifierProduit = new JComboBox();
		comboBoxModifierProduit=comboxBoxDynamiqueModifierProduit.ComboxBoxDynamiqueModifierProduit();
		comboBoxModifierProduit.setBounds(387, 27, 400, 26);
		panelModifierProduit.add(comboBoxModifierProduit);
		
		JLabel labelNouvelleQuantite = new JLabel("Nouvelle quantit\u00E9 :");
		labelNouvelleQuantite.setForeground(Color.BLACK);
		labelNouvelleQuantite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNouvelleQuantite.setBounds(202, 69, 170, 24);
		panelModifierProduit.add(labelNouvelleQuantite);
		
		champNouvelleQuantite = new JTextField();
		champNouvelleQuantite.setColumns(10);
		champNouvelleQuantite.setBounds(387, 70, 400, 26);
		panelModifierProduit.add(champNouvelleQuantite);
		
		JLabel labelNouveauPrix = new JLabel("Nouveau prix unitaire :");
		labelNouveauPrix.setForeground(Color.BLACK);
		labelNouveauPrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNouveauPrix.setBounds(168, 109, 204, 24);
		panelModifierProduit.add(labelNouveauPrix);
		
		champNouveauPrix = new JTextField();
		champNouveauPrix.setColumns(10);
		champNouveauPrix.setBounds(387, 110, 400, 26);
		panelModifierProduit.add(champNouveauPrix);
		
		JLabel labelNouveauLieuStockage = new JLabel("Nouveau lieu de stockage :");
		labelNouveauLieuStockage.setForeground(Color.BLACK);
		labelNouveauLieuStockage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNouveauLieuStockage.setBounds(130, 149, 242, 24);
		panelModifierProduit.add(labelNouveauLieuStockage);
		
		JLabel labelCommentaire = new JLabel("Commentaires :");
		labelCommentaire.setForeground(Color.BLACK);
		labelCommentaire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCommentaire.setBounds(230, 186, 142, 24);
		panelModifierProduit.add(labelCommentaire);
		
		champCommentaire = new JTextField();
		champCommentaire.setColumns(10);
		champCommentaire.setBounds(387, 187, 400, 26);
		panelModifierProduit.add(champCommentaire);
		
		JComboBox comboBoxNouveauLieu = new JComboBox();
		comboBoxNouveauLieu=comboxBoxDynamiqueStockage.ComboxBoxDynamiqueLieuStockage();
		comboBoxNouveauLieu.setBounds(387, 150, 400, 26);
		panelModifierProduit.add(comboBoxNouveauLieu);
		
		boutonModifierProduit = new JButton("Modifier");
		boutonModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonModifierProduit.setBounds(757, 228, 220, 30);
		panelModifierProduit.add(boutonModifierProduit);
		
		JLabel labelErreurModifierProduit = new JLabel("");
		labelErreurModifierProduit.setForeground(Color.RED);
		labelErreurModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelErreurModifierProduit.setBounds(334, 225, 409, 37);
		panelModifierProduit.add(labelErreurModifierProduit);
		
		JPanel panelGestionLieuStockage = new JPanel();
		panelGestionLieuStockage.setBackground(new Color(51, 102, 204));
		ongletGestion.addTab("Gestion des lieux de stockage", null, panelGestionLieuStockage, null);
		panelGestionLieuStockage.setLayout(null);
		
		JPanel panelAjoutLieuStockage = new JPanel();
		panelAjoutLieuStockage.setLayout(null);
		panelAjoutLieuStockage.setBounds(0, 16, 992, 200);
		panelGestionLieuStockage.add(panelAjoutLieuStockage);
		
		JLabel labelAjoutLieu = new JLabel("Ajout d'un lieu de stockage");
		labelAjoutLieu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelAjoutLieu.setBounds(15, 16, 359, 37);
		panelAjoutLieuStockage.add(labelAjoutLieu);
		
		JLabel labelNomLieu = new JLabel("Nom :");
		labelNomLieu.setForeground(Color.BLACK);
		labelNomLieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomLieu.setBounds(319, 69, 54, 24);
		panelAjoutLieuStockage.add(labelNomLieu);
		
		champNomLieu = new JTextField();
		champNomLieu.setColumns(10);
		champNomLieu.setBounds(388, 70, 400, 26);
		panelAjoutLieuStockage.add(champNomLieu);
		
		JLabel labelLocalisationLieu = new JLabel("Localisation :");
		labelLocalisationLieu.setForeground(Color.BLACK);
		labelLocalisationLieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLocalisationLieu.setBounds(255, 109, 118, 24);
		panelAjoutLieuStockage.add(labelLocalisationLieu);
		
		champLocalisationLieu = new JTextField();
		champLocalisationLieu.setColumns(10);
		champLocalisationLieu.setBounds(388, 110, 400, 26);
		panelAjoutLieuStockage.add(champLocalisationLieu);
		
		boutonAjouterLieu = new JButton("Ajouter");
		boutonAjouterLieu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonAjouterLieu.setBounds(757, 154, 220, 30);
		panelAjoutLieuStockage.add(boutonAjouterLieu);
		
		panelLieuStockage = new JPanel();
		panelLieuStockage.setLayout(null);
		panelLieuStockage.setBounds(0, 232, 992, 62);
		panelGestionLieuStockage.add(panelLieuStockage);
		
		JLabel labelListeLieuStockage = new JLabel("Lieu de stockage");
		labelListeLieuStockage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelListeLieuStockage.setBounds(15, 16, 359, 37);
		panelLieuStockage.add(labelListeLieuStockage);
		
		JPanel panelListeLieuStockage = new JPanel();
		panelListeLieuStockage.setBounds(0, 294, 992, 266);
		panelGestionLieuStockage.add(panelListeLieuStockage);
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES LIEUX DE STOCKAGE----------------------
------------------------------------------------------------------------------------------------*/		
		
panelListeLieuStockage.setLayout(new BorderLayout(0, 0));
		
		tableauLieuStockage = new JTable(modeleLieuStockage);
		tableauLieuStockage.setDefaultRenderer(Color.class, new ColorCellRenderer());
		tableauLieuStockage.getColumnModel().getColumn(4).setMaxWidth(0);
		tableauLieuStockage.getColumnModel().getColumn(4).setMinWidth(0);
		tableauLieuStockage.getColumnModel().getColumn(4).setPreferredWidth(0);
		
		JScrollPane scrollPaneLieuStockage = new JScrollPane(tableauLieuStockage);
		panelListeLieuStockage.add(scrollPaneLieuStockage);
		
		boutonModifierCapacite = new JButton("Modifier la capacit\u00E9 libre");
		boutonModifierCapacite.setBounds(297, 565, 255, 29);
		panelGestionLieuStockage.add(boutonModifierCapacite);
		
		boutonSupprimerStockage = new JButton("Supprimer");
		boutonSupprimerStockage.setBounds(600, 565, 115, 29);
		panelGestionLieuStockage.add(boutonSupprimerStockage);
				
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
		JPanel ongletJournal = new JPanel();
		ongletJournal.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("Journal", null, ongletJournal, null);
		ongletJournal.setLayout(null);
		
		JPanel panelFiltres = new JPanel();
		panelFiltres.setLayout(null);
		panelFiltres.setBounds(0, 0, 997, 50);
		ongletJournal.add(panelFiltres);
		
		JLabel lblFiltres_1 = new JLabel("Filtres :");
		lblFiltres_1.setForeground(Color.BLACK);
		lblFiltres_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltres_1.setBounds(147, 15, 67, 24);
		panelFiltres.add(lblFiltres_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3 = filtreJournalProduit.FiltreProduit(modeleJournalProduit);
		comboBox_3.setBounds(233, 16, 400, 26);
		panelFiltres.add(comboBox_3);
		
		JPanel panelJournalStock = new JPanel();
		panelJournalStock.setBounds(0, 66, 997, 527);
		ongletJournal.add(panelJournalStock);
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DU JOURNAL DES STOCKS----------------------
------------------------------------------------------------------------------------------------*/		
		
panelJournalStock.setLayout(new BorderLayout(0, 0));
		
		tableauJournalStock = new JTable(modeleJournalProduit);
		tableauJournalStock.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauJournalStock.getColumnModel().getColumn(5).setMinWidth(0);
		tableauJournalStock.getColumnModel().getColumn(5).setPreferredWidth(0);
		
		JScrollPane scrollPaneJournalStock = new JScrollPane(tableauJournalStock);
		panelJournalStock.add(scrollPaneJournalStock);
		
		boutonSupprimerJournalProduit = new JButton("Supprimer");
		boutonSupprimerJournalProduit.setBounds(440, 599, 115, 29);
		ongletJournal.add(boutonSupprimerJournalProduit);
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
	}

	public JTextField getChampRecherche() {
		return champRecherche;
	}

	public void setChampRecherche(JTextField champRecherche) {
		this.champRecherche = champRecherche;
	}

	public JTextField getChampCategorie() {
		return champCategorie;
	}

	public void setChampCategorie(JTextField champCategorie) {
		this.champCategorie = champCategorie;
	}

	public JTextField getChampNomProduit() {
		return champNomProduit;
	}

	public void setChampNomProduit(JTextField champNomProduit) {
		this.champNomProduit = champNomProduit;
	}

	public JTextField getChampPrixUnitaireProduit() {
		return champPrixUnitaireProduit;
	}

	public void setChampPrixUnitaireProduit(JTextField champPrixUnitaireProduit) {
		this.champPrixUnitaireProduit = champPrixUnitaireProduit;
	}

	public JTextField getChampQuantiteProduit() {
		return champQuantiteProduit;
	}

	public void setChampQuantiteProduit(JTextField champQuantiteProduit) {
		this.champQuantiteProduit = champQuantiteProduit;
	}

	public JTextField getChampNouvelleQuantite() {
		return champNouvelleQuantite;
	}

	public void setChampNouvelleQuantite(JTextField champNouvelleQuantite) {
		this.champNouvelleQuantite = champNouvelleQuantite;
	}

	public JTextField getChampNouveauPrix() {
		return champNouveauPrix;
	}

	public void setChampNouveauPrix(JTextField champNouveauPrix) {
		this.champNouveauPrix = champNouveauPrix;
	}

	public JTextField getChampCommentaire() {
		return champCommentaire;
	}

	public void setChampCommentaire(JTextField champCommentaire) {
		this.champCommentaire = champCommentaire;
	}

	public JTextField getChampNomLieu() {
		return champNomLieu;
	}

	public void setChampNomLieu(JTextField champNomLieu) {
		this.champNomLieu = champNomLieu;
	}

	public JTextField getChampLocalisationLieu() {
		return champLocalisationLieu;
	}

	public void setChampLocalisationLieu(JTextField champLocalisationLieu) {
		this.champLocalisationLieu = champLocalisationLieu;
	}

	public JTable getTableauProduit() {
		return tableauProduit;
	}

	public void setTableauProduit(JTable tableauProduit) {
		this.tableauProduit = tableauProduit;
	}

	public JTable getTableauLieuStockage() {
		return tableauLieuStockage;
	}

	public void setTableauLieuStockage(JTable tableauLieuStockage) {
		this.tableauLieuStockage = tableauLieuStockage;
	}

	public JTable getTableauJournalStock() {
		return tableauJournalStock;
	}

	public void setTableauJournalStock(JTable tableauJournalStock) {
		this.tableauJournalStock = tableauJournalStock;
	}

	public JTextField getChampFournisseurProduit() {
		return champFournisseurProduit;
	}

	public void setChampFournisseurProduit(JTextField champFournisseurProduit) {
		this.champFournisseurProduit = champFournisseurProduit;
	}

	public JLabel getLabelErreurAjoutProduit() {
		return labelErreurAjoutProduit;
	}

	public void setLabelErreurAjoutProduit(JLabel labelErreurAjoutProduit) {
		this.labelErreurAjoutProduit = labelErreurAjoutProduit;
	}

	public JButton getBoutonAjouterProduit() {
		return boutonAjouterProduit;
	}

	public void setBoutonAjouterProduit(JButton boutonAjouterProduit) {
		this.boutonAjouterProduit = boutonAjouterProduit;
	}

	public JButton getBoutonModifierProduit() {
		return boutonModifierProduit;
	}

	public void setBoutonModifierProduit(JButton boutonModifierProduit) {
		this.boutonModifierProduit = boutonModifierProduit;
	}

	public JPanel getPanelLieuStockage() {
		return panelLieuStockage;
	}

	public void setPanelLieuStockage(JPanel panelLieuStockage) {
		this.panelLieuStockage = panelLieuStockage;
	}

	public JButton getBoutonAjouterLieu() {
		return boutonAjouterLieu;
	}

	public void setBoutonAjouterLieu(JButton boutonAjouterLieu) {
		this.boutonAjouterLieu = boutonAjouterLieu;
	}

	public ComboxBoxDynamiqueStockage getComboxBoxDynamiqueStockage() {
		return comboxBoxDynamiqueStockage;
	}

	public void setComboxBoxDynamiqueStockage(ComboxBoxDynamiqueStockage comboxBoxDynamiqueStockage) {
		this.comboxBoxDynamiqueStockage = comboxBoxDynamiqueStockage;
	}

	public ComboxBoxDynamiqueModifierProduit getComboxBoxDynamiqueModifierProduit() {
		return comboxBoxDynamiqueModifierProduit;
	}

	public void setComboxBoxDynamiqueModifierProduit(ComboxBoxDynamiqueModifierProduit comboxBoxDynamiqueModifierProduit) {
		this.comboxBoxDynamiqueModifierProduit = comboxBoxDynamiqueModifierProduit;
	}

	public ComboBoxDynamiqueFournisseur getComboBoxDynamiqueFournisseur() {
		return comboBoxDynamiqueFournisseur;
	}

	public void setComboBoxDynamiqueFournisseur(ComboBoxDynamiqueFournisseur comboBoxDynamiqueFournisseur) {
		this.comboBoxDynamiqueFournisseur = comboBoxDynamiqueFournisseur;
	}
	
	
	public JButton getBoutonSupprimerProduit() {
		return boutonSupprimerProduit;
	}

	public void setBoutonSupprimerProduit(JButton boutonSupprimerProduit) {
		this.boutonSupprimerProduit = boutonSupprimerProduit;
	}

	public JButton getBoutonModifierCapacite() {
		return boutonModifierCapacite;
	}

	public void setBoutonModifierCapacite(JButton boutonModifierCapacite) {
		this.boutonModifierCapacite = boutonModifierCapacite;
	}

	public JButton getBoutonSupprimerStockage() {
		return boutonSupprimerStockage;
	}

	public void setBoutonSupprimerStockage(JButton boutonSupprimerStockage) {
		this.boutonSupprimerStockage = boutonSupprimerStockage;
	}

	public JButton getBoutonSupprimerJournalProduit() {
		return boutonSupprimerJournalProduit;
	}

	public void setBoutonSupprimerJournalProduit(JButton boutonSupprimerJournalProduit) {
		this.boutonSupprimerJournalProduit = boutonSupprimerJournalProduit;
	}

	public ModeleTableauListeProduit getModeleListeProduit() {
		return modeleListeProduit;
	}

	public void setModeleListeProduit(ModeleTableauListeProduit modeleListeProduit) {
		this.modeleListeProduit = modeleListeProduit;
	}

	public ModeleTableauLieuStockage getModeleLieuStockage() {
		return modeleLieuStockage;
	}

	public void setModeleLieuStockage(ModeleTableauLieuStockage modeleLieuStockage) {
		this.modeleLieuStockage = modeleLieuStockage;
	}

	public ModeleTableauJournalProduit getModeleJournalProduit() {
		return modeleJournalProduit;
	}

	public void setModeleJournalProduit(ModeleTableauJournalProduit modeleJournalProduit) {
		this.modeleJournalProduit = modeleJournalProduit;
	}

	public FiltreProduit getFiltreProduit() {
		return filtreProduit;
	}

	public void setFiltreProduit(FiltreProduit filtreProduit) {
		this.filtreProduit = filtreProduit;
	}

	public FiltreJournalProduit getFiltreJournalProduit() {
		return filtreJournalProduit;
	}

	public void setFiltreJournalProduit(FiltreJournalProduit filtreJournalProduit) {
		this.filtreJournalProduit = filtreJournalProduit;
	}
	
	
	
	

	
	
	
	
}
