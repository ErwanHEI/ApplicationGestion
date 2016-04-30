package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Produit;
import manager.ProduitManager;

public class ModeleTableauQuantiteProduit extends AbstractTableModel{

	private ProduitManager produitManager = new ProduitManager();
    private List<Produit> listeProduitEvenement = new ArrayList<Produit>();
 
    private final String[] entetes = {"Nom du produit", "Quantités Nécessaires"};
    
    public ModeleTableauQuantiteProduit(List<Integer> listeIdProduit) {
        super();
        listeProduitEvenement = produitManager.listerProduitEvenement(listeIdProduit);
    }
 
    public int getRowCount() {
        return listeProduitEvenement.size();
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
                return listeProduitEvenement.get(rowIndex).getNomProduit();
            case 1:
            	if(listeProduitEvenement.get(rowIndex).getQuantite()!=0) //quantité=0 avant saisie utilisateur
            	return listeProduitEvenement.get(rowIndex).getQuantite();
            default:
                return null;
        }
    }
    
    public boolean isCellEditable(int row, int col){
    	if (col == 1)
    	return true; // Modification des données possible dans la colonne quantité
    	else
    	return false; // Modification des données impossible dans la colonne nom
    }
    
    //Récupère la quantité saisie par l'utilisateur
    @Override
    public void setValueAt(Object quantiteSaisie, int rowIndex, int columnIndex) {    	
        if(quantiteSaisie != null){
            Produit produitEvenement = listeProduitEvenement.get(rowIndex);
            switch(columnIndex){
                case 1:
                	produitEvenement.setQuantite(Integer.valueOf((String) quantiteSaisie));
                    break;
            }
            this.clear();
            this.setListeProduitEvenement(listeProduitEvenement);
        }
        //VERIFICATION CONSOLE
        for(int i=0; i<listeProduitEvenement.size(); i++)
        System.out.println("Quantité de "+listeProduitEvenement.get(i).getNomProduit()+" : "+listeProduitEvenement.get(i).getQuantite());
    }
    
    //Supprime le tableau dans l'interface
    public void clear(){
    	int size = listeProduitEvenement.size();
    	for(int i=0; i<size; i++){
            fireTableRowsDeleted(0, 0);
    	}
    }

	public List<Produit> getListeProduitEvenement() {
		return listeProduitEvenement;
	}

	public void setListeProduitEvenement(List<Produit> listeProduitEvenement) {
		this.listeProduitEvenement = listeProduitEvenement;
	}
    
}
