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
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

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
	
	private JComboBox comboFournisseur;
	
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
	private JButton boutonRechercher;
	
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
		tabbedPane.setBounds((int) (0*adaptx), (int) (16*adapty), (int) (1002*adaptx), (int) (662*adaptx));
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.CENTER);
		
		JPanel ongletProduit = new JPanel();
		tabbedPane.addTab(html1+"Produit"+html2, new ImageIcon("../ApplicationGestion/src/image/produit.png"), ongletProduit, null);
		ongletProduit.setLayout(null);
		
		JLabel rechercherProduit = new JLabel("Rechercher un produit :");
		rechercherProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		rechercherProduit.setBounds((int) (101*adaptx), (int) (47*adapty), (int) (215*adaptx), (int) (27*adapty));
		ongletProduit.add(rechercherProduit);
		
		champRecherche = new JTextField();
		champRecherche.setFont(new Font("Tahoma", Font.PLAIN, (int)(12*adaptx)));
		champRecherche.setBounds((int) (331*adaptx), (int) (47*adapty), (int) (300*adaptx), (int) (26*adaptx));
		ongletProduit.add(champRecherche);
		champRecherche.setColumns(10);
		
	
		boutonRechercher = new JButton("Rechercher");
		boutonRechercher.setFont(new Font("Tahoma", Font.PLAIN, (int)(12*adaptx)));
		boutonRechercher.setBounds((int) (696*adaptx), (int) (46*adapty), (int) (200*adaptx), (int) (29*adaptx));
		ongletProduit.add(boutonRechercher);
		
		JLabel filtres = new JLabel("Filtres :");
		filtres.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		filtres.setBounds((int) (243*adaptx), (int) (106*adapty), (int) (73*adaptx), (int) (25*adaptx));
		ongletProduit.add(filtres);
		
		JComboBox comboBoxFiltres = new JComboBox();
		comboBoxFiltres = filtreProduit.FiltreProduit(modeleListeProduit);
		comboBoxFiltres.setFont(new Font("Tahoma", Font.PLAIN, (int) (12*adaptx)));
		comboBoxFiltres.setBounds((int) (331*adaptx), (int) (105*adapty), (int) (300*adaptx), (int) (26*adaptx));
		ongletProduit.add(comboBoxFiltres);
		
		JPanel panelListeProduit = new JPanel();
		panelListeProduit.setBounds((int) (0*adaptx), (int) (169*adapty), (int) (997*adaptx), (int) (427*adapty));
		ongletProduit.add(panelListeProduit);
		panelListeProduit.setLayout(new BorderLayout(0, 0));
		
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DES PRODUITS--------------------------------
------------------------------------------------------------------------------------------------*/		
		
		tableauProduit = new JTable(modeleListeProduit);
		tableauProduit.getColumnModel().getColumn(6).setMaxWidth(0);
		tableauProduit.getColumnModel().getColumn(6).setMinWidth(0);
		tableauProduit.getColumnModel().getColumn(6).setPreferredWidth(0);
		tableauProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauProduit.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauProduit.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneProduit = new JScrollPane(tableauProduit);
		panelListeProduit.add(scrollPaneProduit, BorderLayout.CENTER);
		
		boutonSupprimerProduit = new JButton("Supprimer");
		boutonSupprimerProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (12*adaptx)));
		boutonSupprimerProduit.setBounds((int) (360*adaptx), (int) (599*adapty), (int) (262*adaptx), (int) (29*adapty));
		ongletProduit.add(boutonSupprimerProduit);
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
		
		JTabbedPane ongletGestion = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab(html1+"Gestion"+html2, new ImageIcon("../ApplicationGestion/src/image/gestion.png"), ongletGestion, null);
		
		JPanel panelGestionProduit = new JPanel();
		panelGestionProduit.setBackground(new Color(51, 102, 204));
		ongletGestion.addTab(html3+"Gestion des produits"+html2, null, panelGestionProduit, null);
		panelGestionProduit.setLayout(null);
		
		JPanel panelAjoutProduit = new JPanel();
		panelAjoutProduit.setBounds((int) (0*adaptx), (int) (14*adapty), (int) (992*adaptx), (int) (290*adapty));
		panelGestionProduit.add(panelAjoutProduit);
		panelAjoutProduit.setLayout(null);
		
		JLabel labelAjoutProduit = new JLabel("Ajout d'un produit");
		labelAjoutProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelAjoutProduit.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (251*adaptx), (int) (37*adaptx));
		panelAjoutProduit.add(labelAjoutProduit);
		
		JLabel labelReferenceProduit = new JLabel("Catégorie :");
		labelReferenceProduit.setForeground(Color.BLACK);
		labelReferenceProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelReferenceProduit.setBounds((int) (68*adaptx), (int) (90*adapty), (int) (102*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelReferenceProduit);
		
		champCategorie = new JTextField("Boissons, vêtements, ...");
		champCategorie.setForeground(Color.gray);
		champCategorie.setColumns(10);
		champCategorie.setBounds((int) (185*adaptx), (int) (91*adapty), (int) (250*adaptx), (int) (26*adaptx));
		champCategorie.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champCategorie.getSelectedText().isEmpty()==false && champCategorie.getText().equals("Boissons, vêtements, ...")){
		    		champCategorie.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champCategorie.getText().equals("Boissons, vêtements, ...")){
		    		champCategorie.setCaretPosition(0);
		    	}		        	
		    }
		});
		champCategorie.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champCategorie.getText().equals("Boissons, vêtements, ...") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champCategorie.setText("");
					champCategorie.getFont().deriveFont(Font.PLAIN);
					champCategorie.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champCategorie.getText().equals("")){
					champCategorie.setText("Boissons, vêtements, ...");
					champCategorie.setForeground(Color.gray);
					champCategorie.setCaretPosition(0);
				}	
			}
		});
		panelAjoutProduit.add(champCategorie);
		
		JLabel labelNomProduit = new JLabel("Nom :");
		labelNomProduit.setForeground(Color.BLACK);
		labelNomProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNomProduit.setBounds((int) (116*adaptx), (int) (130*adapty), (int) (54*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelNomProduit);
		
		champNomProduit = new JTextField("Pierre, papier, ciseaux, ...");
		champNomProduit.setForeground(Color.gray);
		champNomProduit.setColumns(10);
		champNomProduit.setBounds((int) (185*adaptx), (int) (131*adapty), (int) (250*adaptx), (int) (26*adaptx));
		champNomProduit.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champNomProduit.getSelectedText().isEmpty()==false && champNomProduit.getText().equals("Pierre, papier, ciseaux, ...")){
		    		champNomProduit.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champNomProduit.getText().equals("Pierre, papier, ciseaux, ...")){
		    		champNomProduit.setCaretPosition(0);
		    	}		        	
		    }
		});
		champNomProduit.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champNomProduit.getText().equals("Pierre, papier, ciseaux, ...") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champNomProduit.setText("");
					champNomProduit.getFont().deriveFont(Font.PLAIN);
					champNomProduit.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champNomProduit.getText().equals("")){
					champNomProduit.setText("Pierre, papier, ciseaux, ...");
					champNomProduit.setForeground(Color.gray);
					champNomProduit.setCaretPosition(0);
				}	
			}
		});
		
		panelAjoutProduit.add(champNomProduit);
		
		JLabel labelPrixUnitaireProduit = new JLabel("Prix unitaire :");
		labelPrixUnitaireProduit.setForeground(Color.BLACK);
		labelPrixUnitaireProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelPrixUnitaireProduit.setBounds((int) (50*adaptx), (int) (170*adapty), (int) (120*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelPrixUnitaireProduit);
		
		champPrixUnitaireProduit = new JTextField("Veuillez utiliser le point pour les centimes");
		champPrixUnitaireProduit.setForeground(Color.gray);
		champPrixUnitaireProduit.setColumns(10);
		champPrixUnitaireProduit.setBounds((int) (185*adaptx), (int) (171*adapty), (int) (250*adaptx), (int) (26*adaptx));
		champPrixUnitaireProduit.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champPrixUnitaireProduit.getSelectedText().isEmpty()==false && champPrixUnitaireProduit.getText().equals("Veuillez utiliser le point pour les centimes")){
		    		champPrixUnitaireProduit.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champPrixUnitaireProduit.getText().equals("Veuillez utiliser le point pour les centimes")){
		    		champPrixUnitaireProduit.setCaretPosition(0);
		    	}		        	
		    }
		});
		champPrixUnitaireProduit.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champPrixUnitaireProduit.getText().equals("Veuillez utiliser le point pour les centimes") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champPrixUnitaireProduit.setText("");
					champPrixUnitaireProduit.getFont().deriveFont(Font.PLAIN);
					champPrixUnitaireProduit.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champPrixUnitaireProduit.getText().equals("")){
					champPrixUnitaireProduit.setText("Veuillez utiliser le point pour les centimes");
					champPrixUnitaireProduit.setForeground(Color.gray);
					champPrixUnitaireProduit.setCaretPosition(0);
				}	
			}
		});
		panelAjoutProduit.add(champPrixUnitaireProduit);
		
		JLabel labelQuantiteProduit = new JLabel("Quantit\u00E9 :");
		labelQuantiteProduit.setForeground(Color.BLACK);
		labelQuantiteProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelQuantiteProduit.setBounds((int) (543*adaptx), (int) (90*adapty), (int) (90*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelQuantiteProduit);
		
		champQuantiteProduit = new JTextField("Veuillez entrer une valeur entière");
		champQuantiteProduit.setForeground(Color.gray);
		champQuantiteProduit.setColumns(10);
		champQuantiteProduit.setBounds((int) (648*adaptx), (int) (91*adapty), (int) (250*adaptx), (int) (26*adaptx));
		champQuantiteProduit.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champQuantiteProduit.getSelectedText().isEmpty()==false && champQuantiteProduit.getText().equals("Veuillez entrer une valeur entière")){
		    		champQuantiteProduit.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champQuantiteProduit.getText().equals("Veuillez entrer une valeur entière")){
		    		champQuantiteProduit.setCaretPosition(0);
		    	}		        	
		    }
		});
		champQuantiteProduit.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champQuantiteProduit.getText().equals("Veuillez entrer une valeur entière") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champQuantiteProduit.setText("");
					champQuantiteProduit.getFont().deriveFont(Font.PLAIN);
					champQuantiteProduit.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champQuantiteProduit.getText().equals("")){
					champQuantiteProduit.setText("Veuillez entrer une valeur entière");
					champQuantiteProduit.setForeground(Color.gray);
					champQuantiteProduit.setCaretPosition(0);
				}	
			}
		});
		panelAjoutProduit.add(champQuantiteProduit);
		
		JLabel labelFournisseurProduit = new JLabel("Fournisseur :");
		labelFournisseurProduit.setForeground(Color.BLACK);
		labelFournisseurProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelFournisseurProduit.setBounds((int) (518*adaptx), (int) (130*adapty), (int) (115*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelFournisseurProduit);
		
		comboFournisseur = new JComboBox();
		comboFournisseur=comboBoxDynamiqueFournisseur.ComboxBoxDynamiqueFournisseur();

		JComboBox comboFournisseur=new JComboBox();
		comboFournisseur=comboBoxDynamiqueFournisseur.ComboxBoxDynamiqueFournisseur();
		comboFournisseur.setBounds((int) (648*adaptx), (int) (131*adapty), (int) (250*adaptx), (int) (26*adaptx));
		panelAjoutProduit.add(comboFournisseur);
		
		JLabel labelLieuStockageProduit = new JLabel("Lieu de stockage :");
		labelLieuStockageProduit.setForeground(Color.BLACK);
		labelLieuStockageProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelLieuStockageProduit.setBounds((int) (470*adaptx), (int) (170*adapty), (int) (163*adaptx), (int) (24*adaptx));
		panelAjoutProduit.add(labelLieuStockageProduit);
		
		JComboBox comboBoxLieuStockageProduit = new JComboBox();
		comboBoxLieuStockageProduit=comboxBoxDynamiqueStockage.ComboxBoxDynamiqueLieuStockage();
		comboBoxLieuStockageProduit.setBounds((int) (648*adaptx), (int) (171*adapty), (int) (250*adaptx), (int) (26*adaptx));
		panelAjoutProduit.add(comboBoxLieuStockageProduit);
		
		boutonAjouterProduit = new JButton("Ajouter");
		boutonAjouterProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonAjouterProduit.setBounds((int) (757*adaptx), (int) (244*adapty), (int) (220*adaptx), (int) (30*adapty));
		panelAjoutProduit.add(boutonAjouterProduit);
		
		labelErreurAjoutProduit = new JLabel("");
		labelErreurAjoutProduit.setForeground(Color.RED);
		labelErreurAjoutProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (25*adaptx)));
		labelErreurAjoutProduit.setBounds((int) (333*adaptx), (int) (237*adapty), (int) (409*adaptx), (int) (37*adaptx));
		panelAjoutProduit.add(labelErreurAjoutProduit);
		
		JPanel panelModifierProduit = new JPanel();
		panelModifierProduit.setBounds((int) (0*adaptx), (int) (320*adapty), (int) (992*adaptx), (int) (274*adapty));
		panelGestionProduit.add(panelModifierProduit);
		panelModifierProduit.setLayout(null);
		
		JLabel labelModifierProduit = new JLabel("Modifier un produit");
		labelModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelModifierProduit.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (265*adaptx), (int) (37*adaptx));
		panelModifierProduit.add(labelModifierProduit);
		
		JComboBox comboBoxModifierProduit = new JComboBox();
		comboBoxModifierProduit=comboxBoxDynamiqueModifierProduit.ComboxBoxDynamiqueModifierProduit();
		comboBoxModifierProduit.setBounds((int) (387*adaptx), (int) (27*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelModifierProduit.add(comboBoxModifierProduit);
		
		JLabel labelNouvelleQuantite = new JLabel("Nouvelle quantit\u00E9 :");
		labelNouvelleQuantite.setForeground(Color.BLACK);
		labelNouvelleQuantite.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNouvelleQuantite.setBounds((int) (202*adaptx), (int) (69*adapty), (int) (170*adaptx), (int) (24*adaptx));
		panelModifierProduit.add(labelNouvelleQuantite);
		
		champNouvelleQuantite = new JTextField("Veuillez entrer une valeur entière");
		champNouvelleQuantite.setForeground(Color.gray);
		champNouvelleQuantite.setColumns(10);
		champNouvelleQuantite.setBounds((int) (387*adaptx), (int) (70*adapty), (int) (400*adaptx), (int) (26*adaptx));
		champNouvelleQuantite.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champNouvelleQuantite.getSelectedText().isEmpty()==false && champNouvelleQuantite.getText().equals("Veuillez entrer une valeur entière")){
		    		champNouvelleQuantite.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champNouvelleQuantite.getText().equals("Veuillez entrer une valeur entière")){
		    		champNouvelleQuantite.setCaretPosition(0);
		    	}		        	
		    }
		});
		champNouvelleQuantite.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champNouvelleQuantite.getText().equals("Veuillez entrer une valeur entière") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champNouvelleQuantite.setText("");
					champNouvelleQuantite.getFont().deriveFont(Font.PLAIN);
					champNouvelleQuantite.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champNouvelleQuantite.getText().equals("")){
					champNouvelleQuantite.setText("Veuillez entrer une valeur entière");
					champNouvelleQuantite.setForeground(Color.gray);
					champNouvelleQuantite.setCaretPosition(0);
				}	
			}
		});
		panelModifierProduit.add(champNouvelleQuantite);
		
		JLabel labelNouveauPrix = new JLabel("Nouveau prix unitaire :");
		labelNouveauPrix.setForeground(Color.BLACK);
		labelNouveauPrix.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNouveauPrix.setBounds((int) (168*adaptx), (int) (109*adapty), (int) (204*adaptx), (int) (24*adaptx));
		panelModifierProduit.add(labelNouveauPrix);
		
		champNouveauPrix = new JTextField("Veuillez utiliser le point pour les centimes");
		champNouveauPrix.setForeground(Color.gray);
		champNouveauPrix.setColumns(10);
		champNouveauPrix.setBounds((int) (387*adaptx), (int) (110*adapty), (int) (400*adaptx), (int) (26*adaptx));
		champNouveauPrix.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champNouveauPrix.getSelectedText().isEmpty()==false && champNouveauPrix.getText().equals("Veuillez utiliser le point pour les centimes")){
		    		champNouveauPrix.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champNouveauPrix.getText().equals("Veuillez utiliser le point pour les centimes")){
		    		champNouveauPrix.setCaretPosition(0);
		    	}		        	
		    }
		});
		champNouveauPrix.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champNouveauPrix.getText().equals("Veuillez utiliser le point pour les centimes") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champNouveauPrix.setText("");
					champNouveauPrix.getFont().deriveFont(Font.PLAIN);
					champNouveauPrix.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champNouveauPrix.getText().equals("")){
					champNouveauPrix.setText("Veuillez utiliser le point pour les centimes");
					champNouveauPrix.setForeground(Color.gray);
					champNouveauPrix.setCaretPosition(0);
				}	
			}
		});
		panelModifierProduit.add(champNouveauPrix);
		
		JLabel labelNouveauLieuStockage = new JLabel("Nouveau lieu de stockage :");
		labelNouveauLieuStockage.setForeground(Color.BLACK);
		labelNouveauLieuStockage.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNouveauLieuStockage.setBounds((int) (130*adaptx), (int) (149*adapty), (int) (242*adaptx), (int) (24*adaptx));
		panelModifierProduit.add(labelNouveauLieuStockage);
		
		JLabel labelCommentaire = new JLabel("Commentaires :");
		labelCommentaire.setForeground(Color.BLACK);
		labelCommentaire.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelCommentaire.setBounds((int) (230*adaptx), (int) (186*adapty), (int) (142*adaptx), (int) (24*adaptx));
		panelModifierProduit.add(labelCommentaire);

		champCommentaire = new JTextField("Votre commentaire sera afficher dans le journal");
		champCommentaire.setForeground(Color.gray);
		champCommentaire.setColumns(10);
		champCommentaire.setBounds((int) (387*adaptx), (int) (187*adapty), (int) (400*adaptx), (int) (26*adaptx));
		champCommentaire.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champCommentaire.getSelectedText().isEmpty()==false && champCommentaire.getText().equals("Votre commentaire sera afficher dans le journal")){
		    		champCommentaire.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champCommentaire.getText().equals("Votre commentaire sera afficher dans le journal")){
		    		champCommentaire.setCaretPosition(0);
		    	}		        	
		    }
		});
		champCommentaire.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champCommentaire.getText().equals("Votre commentaire sera afficher dans le journal") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champCommentaire.setText("");
					champCommentaire.getFont().deriveFont(Font.PLAIN);
					champCommentaire.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champCommentaire.getText().equals("")){
					champCommentaire.setText("Votre commentaire sera afficher dans le journal");
					champCommentaire.setForeground(Color.gray);
					champCommentaire.setCaretPosition(0);
				}	
			}
		});
		panelModifierProduit.add(champCommentaire);
		
		JComboBox comboBoxNouveauLieu = new JComboBox();
		comboBoxNouveauLieu=comboxBoxDynamiqueStockage.ComboxBoxDynamiqueLieuStockage();
		comboBoxNouveauLieu.setBounds((int) (387*adaptx), (int) (150*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelModifierProduit.add(comboBoxNouveauLieu);
		
		boutonModifierProduit = new JButton("Modifier");
		boutonModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonModifierProduit.setBounds((int) (757*adaptx), (int) (228*adapty), (int) (220*adaptx), (int) (30*adapty));
		panelModifierProduit.add(boutonModifierProduit);
		
		JLabel labelErreurModifierProduit = new JLabel("");
		labelErreurModifierProduit.setForeground(Color.RED);
		labelErreurModifierProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (25*adaptx)));
		labelErreurModifierProduit.setBounds((int) (334*adaptx), (int) (225*adapty), (int) (409*adaptx), (int) (37*adaptx));
		panelModifierProduit.add(labelErreurModifierProduit);
		
		JPanel panelGestionLieuStockage = new JPanel();
		panelGestionLieuStockage.setBackground(new Color(51, 102, 204));
		
		ongletGestion.addTab(html3+"Gestion des lieux de stockage"+html1, null, panelGestionLieuStockage, null);
		panelGestionLieuStockage.setLayout(null);
		
		JPanel panelAjoutLieuStockage = new JPanel();
		panelAjoutLieuStockage.setLayout(null);
		panelAjoutLieuStockage.setBounds((int) (0*adaptx), (int) (16*adapty), (int) (992*adaptx), (int) (200*adapty));
		panelGestionLieuStockage.add(panelAjoutLieuStockage);
		
		JLabel labelAjoutLieu = new JLabel("Ajout d'un lieu de stockage");
		labelAjoutLieu.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adaptx)));
		labelAjoutLieu.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (359*adaptx), (int) (37*adaptx));
		panelAjoutLieuStockage.add(labelAjoutLieu);
		
		JLabel labelNomLieu = new JLabel("Nom :");
		labelNomLieu.setForeground(Color.BLACK);
		labelNomLieu.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNomLieu.setBounds((int) (319*adaptx), (int) (69*adapty), (int) (54*adaptx), (int) (24*adaptx));
		panelAjoutLieuStockage.add(labelNomLieu);
		
		champNomLieu = new JTextField("Nom du lieu de stockage");
		champNomLieu.setForeground(Color.gray);
		champNomLieu.setColumns(10);
		champNomLieu.setBounds((int) (388*adaptx), (int) (70*adapty), (int) (400*adaptx), (int) (26*adaptx));
		champNomLieu.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champNomLieu.getSelectedText().isEmpty()==false && champNomLieu.getText().equals("Nom du lieu de stockage")){
		    		champNomLieu.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champNomLieu.getText().equals("Nom du lieu de stockage")){
		    		champNomLieu.setCaretPosition(0);
		    	}		        	
		    }
		});
		champNomLieu.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champNomLieu.getText().equals("Nom du lieu de stockage") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champNomLieu.setText("");
					champNomLieu.getFont().deriveFont(Font.PLAIN);
					champNomLieu.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champNomLieu.getText().equals("")){
					champNomLieu.setText("Nom du lieu de stockage");
					champNomLieu.setForeground(Color.gray);
					champNomLieu.setCaretPosition(0);
				}	
			}
		});
		panelAjoutLieuStockage.add(champNomLieu);
		
		JLabel labelLocalisationLieu = new JLabel("Localisation :");
		labelLocalisationLieu.setForeground(Color.BLACK);
		labelLocalisationLieu.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelLocalisationLieu.setBounds((int) (255*adaptx), (int) (109*adapty), (int) (118*adaptx), (int) (24*adaptx));
		panelAjoutLieuStockage.add(labelLocalisationLieu);
		
		champLocalisationLieu = new JTextField("Localisation du lieu de stockage");
		champLocalisationLieu.setForeground(Color.gray);
		champLocalisationLieu.setColumns(10);
		champLocalisationLieu.setBounds((int) (388*adaptx), (int) (110*adapty), (int) (400*adaptx), (int) (26*adaptx));
		champLocalisationLieu.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champLocalisationLieu.getSelectedText().isEmpty()==false && champLocalisationLieu.getText().equals("Localisation du lieu de stockage")){
		    		champLocalisationLieu.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champLocalisationLieu.getText().equals("Localisation du lieu de stockage")){
		    		champLocalisationLieu.setCaretPosition(0);
		    	}		        	
		    }
		});
		champLocalisationLieu.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champLocalisationLieu.getText().equals("Localisation du lieu de stockage") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champLocalisationLieu.setText("");
					champLocalisationLieu.getFont().deriveFont(Font.PLAIN);
					champLocalisationLieu.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champLocalisationLieu.getText().equals("")){
					champLocalisationLieu.setText("Localisation du lieu de stockage");
					champLocalisationLieu.setForeground(Color.gray);
					champLocalisationLieu.setCaretPosition(0);
				}	
			}
		});
		panelAjoutLieuStockage.add(champLocalisationLieu);
		
		boutonAjouterLieu = new JButton("Ajouter");
		boutonAjouterLieu.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonAjouterLieu.setBounds((int) (757*adaptx), (int) (154*adapty), (int) (220*adaptx), (int) (30*adapty));
		panelAjoutLieuStockage.add(boutonAjouterLieu);
		
		panelLieuStockage = new JPanel();
		panelLieuStockage.setLayout(null);
		panelLieuStockage.setBounds((int) (0*adaptx), (int) (232*adapty), (int) (992*adaptx), (int) (62*adapty));
		panelGestionLieuStockage.add(panelLieuStockage);
		
		JLabel labelListeLieuStockage = new JLabel("Lieu de stockage");
		labelListeLieuStockage.setFont(new Font("Tahoma", Font.PLAIN, (int) (30*adapty)));
		labelListeLieuStockage.setBounds((int) (15*adaptx), (int) (16*adapty), (int) (359*adaptx), (int) (37*adaptx));
		panelLieuStockage.add(labelListeLieuStockage);
		
		JPanel panelListeLieuStockage = new JPanel();
		panelListeLieuStockage.setBounds((int) (0*adaptx), (int) (294*adapty), (int) (992*adaptx), (int) (266*adapty));
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
		tableauLieuStockage.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauLieuStockage.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauLieuStockage.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneLieuStockage = new JScrollPane(tableauLieuStockage);
		panelListeLieuStockage.add(scrollPaneLieuStockage);
		
		boutonModifierCapacite = new JButton("Modifier la capacit\u00E9 libre");
		boutonModifierCapacite.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonModifierCapacite.setBounds((int) (297*adaptx), (int) (565*adapty), (int) (255*adaptx), (int) (29*adapty));
		panelGestionLieuStockage.add(boutonModifierCapacite);
		
		boutonSupprimerStockage = new JButton("Supprimer");
		boutonSupprimerStockage.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonSupprimerStockage.setBounds((int) (600*adaptx), (int) (565*adapty), (int) (115*adaptx), (int) (29*adapty));
		panelGestionLieuStockage.add(boutonSupprimerStockage);
				
/*----------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------*/
		
		JPanel ongletJournal = new JPanel();
		ongletJournal.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab(html1+"Journal"+html2, new ImageIcon("../ApplicationGestion/src/image/journal.png"), ongletJournal, null);
		ongletJournal.setLayout(null);
		
		JPanel panelFiltres = new JPanel();
		panelFiltres.setLayout(null);
		panelFiltres.setBounds(0, 0, (int) (997*adaptx), (int) (50*adaptx));
		ongletJournal.add(panelFiltres);
		
		JLabel lblFiltres_1 = new JLabel("Filtres :");
		lblFiltres_1.setForeground(Color.BLACK);
		lblFiltres_1.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		lblFiltres_1.setBounds((int) (147*adaptx), (int) (15*adapty), (int) (67*adaptx), (int) (24*adaptx));
		panelFiltres.add(lblFiltres_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3 = filtreJournalProduit.FiltreProduit(modeleJournalProduit);
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		comboBox_3.setBounds((int) (233*adaptx), (int) (16*adapty), (int) (400*adaptx), (int) (26*adaptx));
		panelFiltres.add(comboBox_3);
		
		JPanel panelJournalStock = new JPanel();
		panelJournalStock.setBounds(0, (int) (66*adapty), (int) (997*adaptx), (int) (527*adapty));
		ongletJournal.add(panelJournalStock);
		
/*----------------------------------------------------------------------------------------------
---------------------------------------------TABLEAU DU JOURNAL DES STOCKS----------------------
------------------------------------------------------------------------------------------------*/		
		
		panelJournalStock.setLayout(new BorderLayout(0, 0));
		panelJournalStock.setLayout(new BorderLayout(0, 0));
		
		tableauJournalStock = new JTable(modeleJournalProduit);
		tableauJournalStock.getColumnModel().getColumn(5).setMaxWidth(0);
		tableauJournalStock.getColumnModel().getColumn(5).setMinWidth(0);
		tableauJournalStock.getColumnModel().getColumn(5).setPreferredWidth(0);
		tableauJournalStock.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		tableauJournalStock.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		tableauJournalStock.setRowHeight((int) (21*adaptx));
		
		JScrollPane scrollPaneJournalStock = new JScrollPane(tableauJournalStock);
		panelJournalStock.add(scrollPaneJournalStock);
		
		boutonSupprimerJournalProduit = new JButton("Supprimer");
		boutonSupprimerJournalProduit.setFont(new Font("Tahoma", Font.PLAIN, (int) (16*adaptx)));
		boutonSupprimerJournalProduit.setBounds((int) (440*adaptx), (int) (599*adapty), (int) (115*adaptx), (int) (29*adapty));
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


	public JComboBox getComboFournisseur() {
		return comboFournisseur;
	}

	public void setComboFournisseur(JComboBox comboFournisseur) {
		this.comboFournisseur = comboFournisseur;
	}

	public JButton getBoutonRechercher() {
		return boutonRechercher;
	}

	public void setBoutonRechercher(JButton boutonRechercher) {
		this.boutonRechercher = boutonRechercher;
	}
	
	
	
	

}
