package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entitie.Produit;
import entitie.Stockage;
import entitie.User;
import manager.ProduitManager;
import view.Fenetre;
import view.PanelProduit;

public class ControleurModificationProduit implements ActionListener{
	
	Fenetre fen;
	private boolean erreur;
	private String message;
	private PanelProduit pan;
	
public ControleurModificationProduit(Fenetre fen, PanelProduit pan) {
		
		this.fen = fen;
		this.pan=pan;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Integer prix=null;
		String prixT=pan.getChampNouveauPrix().getText();
		Integer quantite=null;
		String quantiteT=pan.getChampNouvelleQuantite().getText();
		//recuperer id du nouveau lieu de stockage
		//Stockage newStockage=pan.getComboxBoxDynamiqueStockage().getBudgetSelect();
		//recuperer l'id du produit selectionne
		Produit pdtModif=pan.getComboxBoxDynamiqueModifierProduit().getPdtSelec();
		User userConnecte=fen.getUserActuel();
		if(fen.getUserActuel().getTypeUser()==2 ||fen.getUserActuel().getTypeUser()==1 ){
			if(!quantiteT.isEmpty()){
				quantite=Integer.parseInt(pan.getChampNouvelleQuantite().getText());
				ProduitManager.getInstance().majQuantite(quantite, pdtModif,userConnecte);
			}
			if(!prixT.isEmpty()){
				prix=Integer.parseInt(pan.getChampNouveauPrix().getText());
				ProduitManager.getInstance().majPrix(prix, pdtModif,userConnecte);
			}
			
			/*if(newStockage.getNomStockage()!=null){
				ProduitManager.getInstance().majStockage(newStockage, pdtModif,userConnecte);
			}*/
		}else{
			JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à effectuer cette action", "ERREUR", 0);
		}
		
		
		
		
	}

}
