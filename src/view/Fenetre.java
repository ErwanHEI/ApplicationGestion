package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controler.AjoutBudgetControler;
import controler.AjoutVirementControleur;
import controler.BarreMenuControle;
import controler.ChangementMdpControleur;
import controler.ControlerAjoutStockage;
import controler.ControleurAjoutProduit;
import controler.ControleurModificationProduit;
import controler.ControleurProduitEvenement;
import controleurTable.ControleurEncaisserVirement;
import controleurTable.ControleurModifierCapacite;
import controleurTable.ControleurSupprimerBudget;
import controleurTable.ControleurSupprimerEncaissement;
import controleurTable.ControleurSupprimerJournalBudget;
import controleurTable.ControleurSupprimerJournalProduit;
import controleurTable.ControleurSupprimerProduit;
import controleurTable.ControleurSupprimerStockage;
import entitie.User;



public class Fenetre {

    private JFrame fen;
    private PanelProduit panelProduit;
    private PanelBudget panelBudget;
    private PanelEvenement panelEvenement;
    private User userActuel;
    
    JMenuBar menuBar = new JMenuBar();
    
    JMenu mnNewMenu = new JMenu("Fichier");
	JMenuItem mntmNewMenuItem = new JMenuItem("Imprimer l'\u00E9tat des stocks");
	JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
	
	
	JMenu mnAdministrationDesComptes = new JMenu("Administration des comptes");
	JMenuItem mntmCrerUnNouveau = new JMenuItem("Cr\u00E9er un nouveau compte");
	JMenuItem mntmModifierVotreMot = new JMenuItem("Modifier votre mot de passe");
	
	JMenu mnStocks = new JMenu("Stocks");
	JMenuItem mntmStocks=new JMenuItem("Consulter et gérer les stocks");
	
	
	JMenu mnBudgets = new JMenu("Budgets");
	JMenuItem mntmBudget=new JMenuItem("Consulter et gérer le budget");
	
	
	JMenu mnEvnements = new JMenu("Ev\u00E8nements");
	JMenuItem mntmEvenements = new JMenuItem("Consulter et gérer les évènements");
		
	
	JMenu mnAide = new JMenu("Aide");	
	JMenuItem mntmConsulterSurPdf = new JMenuItem("Consulter sur PDF");
    
    
    
    
 	public Fenetre(){
	
	  	fen= new JFrame();
		panelProduit= new PanelProduit();
		panelBudget = new PanelBudget();
		panelEvenement = new PanelEvenement();
		fen.setJMenuBar(menuBar);
		
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmNewMenuItem);
		mnNewMenu.add(mntmDconnexion);
		
		
		
		menuBar.add(mnAdministrationDesComptes);
		
		mnAdministrationDesComptes.add(mntmModifierVotreMot);
		
		mnStocks.add(mntmStocks);
		menuBar.add(mnStocks);
		
		mnBudgets.add(mntmBudget);
		menuBar.add(mnBudgets);
		
		mnEvnements.add(mntmEvenements);
		menuBar.add(mnEvnements);
		
		
		menuBar.add(mnAide);
		mnAide.add(mntmConsulterSurPdf);
		}

	
public void execute(){
	if(userActuel.getTypeUser()==1){
		mnAdministrationDesComptes.add(mntmCrerUnNouveau);
	}
	fen.setTitle("Outil de gestion----Connecté en tant "+userActuel.getEmail());
	fen.getContentPane().setLayout(new BorderLayout());
	//fen.add(panelProduit, BorderLayout.CENTER);
	//fen.getContentPane().setBackground(new Color(51, 102, 204));
	fen.setBounds(100, 100, 1024, 768);
	fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fen.setContentPane(panelProduit);
	fen.setResizable(false);
	fen.setVisible(true);
}

public void changerPanelStock(PanelProduit pan){
	fen.invalidate();
	fen.setContentPane(pan);
	pan.getBoutonModifierProduit().addActionListener(new ControleurModificationProduit(this,pan));
	pan.getBoutonAjouterLieu().addActionListener(new ControlerAjoutStockage(this,pan));
	pan.getBoutonAjouterProduit().addActionListener(new ControleurAjoutProduit(this,pan));
	pan.getBoutonModifierCapacite().addActionListener(new ControleurModifierCapacite(pan));
	pan.getBoutonSupprimerJournalProduit().addActionListener(new ControleurSupprimerJournalProduit(pan));
	pan.getBoutonSupprimerProduit().addActionListener(new ControleurSupprimerProduit(pan));
	pan.getBoutonSupprimerStockage().addActionListener(new ControleurSupprimerStockage(pan));
	fen.validate();
}

public void changerPanelBudget(PanelBudget pan){
	fen.invalidate();
	fen.setContentPane(pan);
	pan.getBoutonAjoutEncaissement().addActionListener(new AjoutVirementControleur(this,pan));
	pan.getBoutonCreerBudget().addActionListener(new AjoutBudgetControler(this,pan));
	pan.getBoutonSupprimerBudget().addActionListener(new ControleurSupprimerBudget(pan));
	pan.getBoutonSupprimerEncaissement().addActionListener(new ControleurSupprimerEncaissement(pan));
	pan.getBoutonEncaisser().addActionListener(new ControleurEncaisserVirement(pan));
	//pan.getBoutonSupprimerJournalBudget().addActionListener(new ControleurSupprimerJournalBudget(pan));
	fen.validate();
}

public void changerPanelEvenement(PanelEvenement pan){
	fen.invalidate();
	fen.setContentPane(pan);
	pan.getBoutonCreerEvenement().addActionListener(new ControleurProduitEvenement(pan));
	fen.validate();
}

public void fermerFentre(){
	fen.dispose();
}




public JMenu getMnBudgets() {
	return mnBudgets;
}


public void setMnBudgets(JMenu mnBudgets) {
	this.mnBudgets = mnBudgets;
}


public JFrame getFen() {
	return fen;
}


public void setFen(JFrame fen) {
	this.fen = fen;
}


public PanelProduit getPanelProduit() {
	return panelProduit;
}


public void setPanelProduit(PanelProduit panelProduit) {
	this.panelProduit = panelProduit;
}


public JMenuBar getMenuBar() {
	return menuBar;
}


public void setMenuBar(JMenuBar menuBar) {
	this.menuBar = menuBar;
}


public JMenu getMnNewMenu() {
	return mnNewMenu;
}


public void setMnNewMenu(JMenu mnNewMenu) {
	this.mnNewMenu = mnNewMenu;
}


public JMenuItem getMntmNewMenuItem() {
	return mntmNewMenuItem;
}


public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
	this.mntmNewMenuItem = mntmNewMenuItem;
}


public JMenuItem getMntmDconnexion() {
	return mntmDconnexion;
}


public void setMntmDconnexion(JMenuItem mntmDconnexion) {
	this.mntmDconnexion = mntmDconnexion;
}



public JMenu getMnAdministrationDesComptes() {
	return mnAdministrationDesComptes;
}


public void setMnAdministrationDesComptes(JMenu mnAdministrationDesComptes) {
	this.mnAdministrationDesComptes = mnAdministrationDesComptes;
}


public JMenuItem getMntmCrerUnNouveau() {
	return mntmCrerUnNouveau;
}


public void setMntmCrerUnNouveau(JMenuItem mntmCrerUnNouveau) {
	this.mntmCrerUnNouveau = mntmCrerUnNouveau;
}


public JMenuItem getMntmModifierVotreMot() {
	return mntmModifierVotreMot;
}


public void setMntmModifierVotreMot(JMenuItem mntmModifierVotreMot) {
	this.mntmModifierVotreMot = mntmModifierVotreMot;
}


public JMenu getMnStocks() {
	return mnStocks;
}


public void setMnStocks(JMenu mnStocks) {
	this.mnStocks = mnStocks;
}





public JMenu getMnEvnements() {
	return mnEvnements;
}


public void setMnEvnements(JMenu mnEvnements) {
	this.mnEvnements = mnEvnements;
}





public JMenu getMnAide() {
	return mnAide;
}


public void setMnAide(JMenu mnAide) {
	this.mnAide = mnAide;
}


public JMenuItem getMntmConsulterSurPdf() {
	return mntmConsulterSurPdf;
}


public void setMntmConsulterSurPdf(JMenuItem mntmConsulterSurPdf) {
	this.mntmConsulterSurPdf = mntmConsulterSurPdf;
}


public PanelBudget getPanelBudget() {
	return panelBudget;
}


public void setPanelBudget(PanelBudget panelBudget) {
	this.panelBudget = panelBudget;
}


public PanelEvenement getPanelEvenement() {
	return panelEvenement;
}


public void setPanelEvenement(PanelEvenement panelEvenement) {
	this.panelEvenement = panelEvenement;
}


public User getUserActuel() {
	return userActuel;
}


public void setUserActuel(User userActuel) {
	this.userActuel = userActuel;
}


public JMenuItem getMntmStocks() {
	return mntmStocks;
}


public void setMntmStocks(JMenuItem mntmStocks) {
	this.mntmStocks = mntmStocks;
}


public JMenuItem getMntmBudget() {
	return mntmBudget;
}


public void setMntmBudget(JMenuItem mntmBudget) {
	this.mntmBudget = mntmBudget;
}


public JMenuItem getMntmEvenements() {
	return mntmEvenements;
}


public void setMntmEvenements(JMenuItem mntmEvenements) {
	this.mntmEvenements = mntmEvenements;
}



	

}