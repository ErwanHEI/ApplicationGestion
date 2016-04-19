package modelTableau;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import entitie.Produit;
import manager.ProduitManager;

public class ModeleTableauListeProduit extends AbstractTableModel {
	
	private ProduitManager produitManager = new ProduitManager();
    private List<Produit> listeProduit = new ArrayList<Produit>();
 
    private final String[] entetes = {"Catégorie", "Nom", "Prix unitaire", "Quantité", "Valeur totale", "Lieu de stockage", "Id Produit"};
 
    public ModeleTableauListeProduit() {
        super();
        listeProduit = produitManager.listerProduits();
    }
 
    public int getRowCount() {
        return listeProduit.size();
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
                return listeProduit.get(rowIndex).getCategorie();
            case 1:
                return listeProduit.get(rowIndex).getNomProduit();
            case 2:
                return listeProduit.get(rowIndex).getPrixU();
            case 3:
                return listeProduit.get(rowIndex).getQuantite();
            case 4:
                return listeProduit.get(rowIndex).getPrixU()*listeProduit.get(rowIndex).getQuantite();
            case 5:
                return listeProduit.get(rowIndex).getStockage().getNomStockage();
            case 6:
            	return listeProduit.get(rowIndex).getIdProduit();
            default:
                return null;
        }
    }
 
 
    public void removeProduit(int rowIndex) {
    	listeProduit.remove(rowIndex);
  
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    
    
    

	public ProduitManager getProduitManager() {
		return produitManager;
	}

	public void setProduitManager(ProduitManager produitManager) {
		this.produitManager = produitManager;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public String[] getEntetes() {
		return entetes;
	}
}
