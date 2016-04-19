package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Budget;
import entitie.Virement;
import manager.BudgetManager;
import manager.VirementManager;

public class ModeleTableauEncaissement extends AbstractTableModel {

	private VirementManager virementManager = new VirementManager();
    private List<Virement> listeVirement = new ArrayList<Virement>();
 
    private final String[] entetes = {"Référence", "Emetteur", "Récepteur", "Date", "Montant", "Id Virement"};
 
    public ModeleTableauEncaissement() {
        super();
        listeVirement = virementManager.virementNonEncaisse();
        System.out.println(listeVirement.size());
    }
 
    public int getRowCount() {
        return listeVirement.size();
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
                return listeVirement.get(rowIndex).getRef();
            case 1:
                return listeVirement.get(rowIndex).getEmetteur();
            case 2:
                return listeVirement.get(rowIndex).getRecepteur();
            case 3:
                return listeVirement.get(rowIndex).getDateVirement();
            case 4:
                return listeVirement.get(rowIndex).getMontant();
            case 5:
            	return listeVirement.get(rowIndex).getIdVirement();
            default:
                return null;
        }
    }
    
	
    /*public void setValueAt(Boolean value, int rowIndex, int columnIndex) {
      if(this.getColumnName(columnIndex).equals("Encaisser")){
      	listeVirement.get(rowIndex).setEncaisse(value);
      	fireTableCellUpdated(rowIndex, columnIndex);
    	  }
	   }
    
    public Class<?> getColumnClass(int columnIndex){
    	if(columnIndex==5)
    		return Boolean.class;
    	return String.class;
	}
    
	public boolean isCellEditable(int rowIndex, int columnIndex){
		if(columnIndex != 5)
			return false;
		return true;
	}*/
	
    //Supprime un virement non encaissé uniquement dans l'affichage de l'application
    public void removeVirement(int rowIndex) {
    	listeVirement.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    
    
    

	public VirementManager getVirementManager() {
		return virementManager;
	}

	public void setVirementManager(VirementManager virementManager) {
		this.virementManager = virementManager;
	}

	public List<Virement> getListeVirement() {
		return listeVirement;
	}

	public void setListeVirement(List<Virement> listeVirement) {
		this.listeVirement = listeVirement;
	}

	public String[] getEntetes() {
		return entetes;
	}
    
}
