package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entitie.Produit;
import entitie.Stockage;
import manager.StockageManager;
import modelTableau.ModeleTableauLieuStockage;
import modelTableau.ModeleTableauListeProduit;
import view.Fenetre;
import view.PanelProduit;

public class ControlerAjoutStockage implements ActionListener{
	
	
	private Fenetre fen;
	private PanelProduit pan;
	private boolean erreur;
	private String message;
	
	private ModeleTableauLieuStockage modeleTableauLieuStockage = new ModeleTableauLieuStockage();
	private StockageManager stockageManager = new StockageManager();
	private List<Stockage> listeStockage = new ArrayList<Stockage>();

	
	public ControlerAjoutStockage( Fenetre fen, PanelProduit pan) {
		this.fen = fen;
		this.pan = pan;
		this.modeleTableauLieuStockage = pan.getModeleLieuStockage();
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
				modeleTableauLieuStockage.clear();
				listeStockage = stockageManager.listerStockage();
				modeleTableauLieuStockage.setListeStockage(listeStockage);
			}else{
				JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à effectuer cette action", "ERREUR", 0);
			}
		}
	}

}
