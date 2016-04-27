package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Produit;
import manager.ProduitManager;

public class ModeleTableauQuantiteProduit extends AbstractTableModel{

	private ProduitManager produitManager = new ProduitManager();
    private List<Produit> listeNomProduit = new ArrayList<Produit>();
 
    private final String[] entetes = {"Nom du produit", "Quantité Nécessaire"};
 
    public ModeleTableauQuantiteProduit() {
        super();
        listeNomProduit = produitManager.listerProduits();
    }
 
    public int getRowCount() {
        return listeNomProduit.size();
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
                return listeNomProduit.get(rowIndex).getNomProduit();
            case 2:
            	return listeNomProduit.get(rowIndex).getIdProduit();
            default:
                return null;
        }
    }
    
    public boolean isCellEditable(int row, int col){
    	if (col == 1)
    	return true; // Modification des données impossible
    	else
    	return false; // Modification des données possible
    }
    
}
