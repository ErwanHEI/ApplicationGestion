package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Evenement;
import entitie.Produit;
import manager.EvenementManager;
import manager.ProduitManager;

	public class ModeleTableauProduitEvenement extends AbstractTableModel{

		private ProduitManager produitManager = new ProduitManager();
	    private Evenement evenement;
	    private List<Integer> listeIdProduit = new ArrayList<Integer>();
	    private List<Produit> listeProduitEvenement = new ArrayList<Produit>();
	    private List<Produit> listeProduit = new ArrayList<Produit>();
	    private List<Integer> listeQuantite = new ArrayList<Integer>();
	 
	    private final String[] entetes = {"Produit", "Quantité nécessaire", "Quantité en stock"};
	 
	    public ModeleTableauProduitEvenement(Evenement evenement) {
	        super();
	        this.evenement = evenement;
	        listeProduitEvenement = evenement.getListePdts();
	        listeProduit = produitManager.listerProduits();
	        for(int i=0; i<evenement.getListePdts().size(); i++){
	        	listeIdProduit.add(listeProduitEvenement.get(i).getIdProduit());
	        }
	        for(int i=0; i<listeIdProduit.size(); i++){
	        	int comp = 0;
	        	while(listeIdProduit.get(i) != listeProduit.get(comp).getIdProduit())
	        		comp = comp+1;
	        	listeQuantite.add(listeProduit.get(comp).getQuantite());
	        }
	    }
	    
	    public int getRowCount() {
	        return evenement.getListePdts().size();
	    }
	 
	    public int getColumnCount() {
	        return entetes.length;
	    }
	 
	    public String getColumnName(int columnIndex) {
	        return entetes[columnIndex];
	    }   
	 
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        switch(columnIndex){
	            case 0:
	                return evenement.getListePdts().get(rowIndex).getNomProduit();
	            case 1:
	                return evenement.getListePdts().get(rowIndex).getQuantite();
	            case 2:
	                return listeQuantite.get(rowIndex);
	            default:
	                return null;
	        }
	    }
}
