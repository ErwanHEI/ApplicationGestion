package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entitie.Stockage;
import manager.StockageManager;
import view.Fenetre;
import view.PanelProduit;

public class ControlerAjoutStockage implements ActionListener{
	
	
	private Fenetre fen;
	private boolean erreur;
	private String message;
	private PanelProduit pan;
	
	
	

	public ControlerAjoutStockage( Fenetre fen, PanelProduit pan) {
		this.fen=fen;
		this.pan=pan;
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nom=pan.getChampNomLieu().getText();
		String localisation=pan.getChampLocalisationLieu().getText();
		Integer remplissage=0;
		
		if(nom==null){
			erreur=true;
			message= "Veuillez saisir un nom";
		}else if(localisation==null){
			erreur=true;
			message="Veuillez saisir la localisation";
		}
		if(erreur){
		
		}else{
			if(fen.getUserActuel().getTypeUser()==2 || fen.getUserActuel().getTypeUser()==1){
				Stockage stockage=new Stockage(0,nom,localisation,remplissage);
				StockageManager.getInstance().ajoutStockage(stockage);
			}else{
				JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à effectuer cette action", "ERREUR", 0);
			}
		}
	}

}
