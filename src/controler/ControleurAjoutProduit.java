package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entitie.Fournisseur;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;
import manager.ProduitManager;
import view.Fenetre;
import view.PanelProduit;

public class ControleurAjoutProduit implements ActionListener{
		
	private Fenetre fen;
	private boolean erreur;
	private String message;
	private PanelProduit pan;
	
	public ControleurAjoutProduit(Fenetre fen,PanelProduit pan) {
		
		this.fen = fen;
		this.pan=pan;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("entre");
		erreur=false;
		message="";
		Integer quantite=null;
		Double prix=null;
		String nom=pan.getChampNomProduit().getText();
		String categorie=pan.getChampCategorie().getText();
		//Integer idUser=fen.getUserActuel().getIdUser();
		
		if(nom.equals("Pierre, papier, ciseaux, ...")){
			erreur=true;
			message="Veuillez saisir un nom ";
		}else if(categorie.equals("")||categorie.equals("Boissons, v�tements, ...")){
			erreur=true;
			message="Veuillez saisir une cat�gorie";
		}
		if(pan.getChampQuantiteProduit().getText().equals("Veuillez entrer une valeur enti�re")){
			erreur=true;
			message="Veuilez saisir une quantite valide";
		}else{
			quantite=Integer.parseInt(pan.getChampQuantiteProduit().getText());
		}
		if(pan.getChampPrixUnitaireProduit().getText().equals("Veuillez utiliser le point pour les centimes")){
			erreur=true;
			message="Veuillez saisir un prix valide";
		}else{
			prix=Double.parseDouble(pan.getChampPrixUnitaireProduit().getText());
		}
			
		
		if(!erreur){
			if(fen.getUserActuel().getTypeUser()==2 || fen.getUserActuel().getTypeUser()==1){
				User createur=fen.getUserActuel();
				Fournisseur fournisseur=pan.getComboBoxDynamiqueFournisseur().getFournisseurSelec();
				Stockage stockage=pan.getComboxBoxDynamiqueStockage().getBudgetSelect();
				Produit pdt=new Produit(1,nom,categorie,prix,quantite, stockage,fournisseur,createur);
				ProduitManager.getInstance().ajoutProduit(pdt);
				PanelProduit pan=new PanelProduit();
				fen.changerPanelStock(pan);
			}else{
				JOptionPane.showMessageDialog(null, "Vous n'etes pas autoris� � effectuer cette action", "ERREUR", 0);
			}
		}else{
			pan.getLabelErreurAjoutProduit().setText(message);
		}
		
	}
}
