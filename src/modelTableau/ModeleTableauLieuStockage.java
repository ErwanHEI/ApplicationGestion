package modelTableau;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Stockage;
import manager.ProduitManager;
import manager.StockageManager;

public class ModeleTableauLieuStockage extends AbstractTableModel {
	
	private StockageManager stockageManager = new StockageManager();
    private List<Stockage> listeStockage = new ArrayList<Stockage>();
 
    private final String[] entetes = {"Nom", "Localisation", "Etat des stocks", "Remplissage (en %)", "Id Stockage"};
 
    public ModeleTableauLieuStockage() {
        super();
        listeStockage = stockageManager.listerStockage();
    }
 
    public int getRowCount() {
        return listeStockage.size();
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
                return listeStockage.get(rowIndex).getNomStockage();
            case 1:
                return listeStockage.get(rowIndex).getLocalisation();
            case 2:
            	if(listeStockage.get(rowIndex).getRemplissage()<33.3){
            		return Color.GREEN;
            	}
            	if(listeStockage.get(rowIndex).getRemplissage()>=33.3&&listeStockage.get(rowIndex).getRemplissage()<66.6){
            		return Color.YELLOW;
            	}
            	if(listeStockage.get(rowIndex).getRemplissage()>=66.6){
            		return Color.RED;
            	}
            case 3:
                return listeStockage.get(rowIndex).getRemplissage();
            case 4:
            	return listeStockage.get(rowIndex).getIdStockage();
            default:
                return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
    	switch(columnIndex){
    		case 2:
    			return Color.class;
    		default:
    			return Object.class;
    	}
    }

    
    public void setValutAt(int value, int rowIndex, int columnIndex){
    	listeStockage.get(rowIndex).setRemplissage(value);
    	fireTableCellUpdated(rowIndex, columnIndex);
    }
    
   
    public void removeStockage(int rowIndex) {
    	listeStockage.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    
    public void clear(){
    	int size = listeStockage.size();
    	for(int i=0; i<size; i++){
    		listeStockage.remove(0);
            fireTableRowsDeleted(0, 0);
    	}
    }
    
    
	public StockageManager getStockageManager() {
		return stockageManager;
	}

	public void setStockageManager(StockageManager stockageManager) {
		this.stockageManager = stockageManager;
	}

	public List<Stockage> getListeStockage() {
		return listeStockage;
	}

	public void setListeStockage(List<Stockage> listeStockage) {
		this.listeStockage = listeStockage;
	}

	public String[] getEntetes() {
		return entetes;
	}
    
}
