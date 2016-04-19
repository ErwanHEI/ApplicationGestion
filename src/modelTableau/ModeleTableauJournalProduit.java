package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.ModificationProduit;
import entitie.Produit;
import manager.ProduitManager;

public class ModeleTableauJournalProduit extends AbstractTableModel {
		
		private ProduitManager produitManager = new ProduitManager();
	    private List<ModificationProduit> listeModifProduit = new ArrayList<ModificationProduit>();
	 
	    private final String[] entetes = {"Produit", "Date", "Modification", "Agent", "Commentaire", "Id Modif"};
	 
	    public ModeleTableauJournalProduit() {
	        super();
	        listeModifProduit = produitManager.listerModif();
	    }
	 
	    public int getRowCount() {
	        return listeModifProduit.size();
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
	                return listeModifProduit.get(rowIndex).getProduit();
	            case 1:
	                return listeModifProduit.get(rowIndex).getDate();
	            case 2:
	                return listeModifProduit.get(rowIndex).getModif();
	            case 3:
	                return listeModifProduit.get(rowIndex).getNomUtil();
	            //case 4:
	                //return listeModifProduit.get(rowIndex).;
	            case 5:
	            	return listeModifProduit.get(rowIndex).getIdModif();
	            default:
	                return null; //Ne devrait jamais arriver
	        }
	    }
	    
	    public void removeJournalProduit(int rowIndex) {
	    	listeModifProduit.remove(rowIndex);
	  
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }

		public ProduitManager getProduitManager() {
			return produitManager;
		}

		public void setProduitManager(ProduitManager produitManager) {
			this.produitManager = produitManager;
		}

		public List<ModificationProduit> getListeModifProduit() {
			return listeModifProduit;
		}

		public void setListeModifProduit(List<ModificationProduit> listeModifProduit) {
			this.listeModifProduit = listeModifProduit;
		}

		public String[] getEntetes() {
			return entetes;
		}
	    
	    
	    
}
