package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Virement;
import manager.VirementManager;

public class ModeleTableauJournalBudget extends AbstractTableModel {
		
		private VirementManager virementManager = new VirementManager();
	    private List<Virement> listeJournalVirement = new ArrayList<Virement>();
	 
	    private final String[] entetes = {"Emetteur", "Date", "Nom budget", "Mouvement", "Nouveau solde", "Agent", "Id Virement"};
	 
	    public ModeleTableauJournalBudget() {
	        super();
	        listeJournalVirement = virementManager.journalVirement();
	    }
	 
	    public int getRowCount() {
	        return listeJournalVirement.size();
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
	                return listeJournalVirement.get(rowIndex).getEmetteur();
	            case 1:
	                return listeJournalVirement.get(rowIndex).getDateVirement();
	            case 2:
	                return listeJournalVirement.get(rowIndex).getBudgetAssocie().getNomBudget();
	            case 3:
	            	return listeJournalVirement.get(rowIndex).getMontant();
	            //case 4:
	              //  return listeJournalVirement.get(rowIndex);
	            case 5:
	            	return listeJournalVirement.get(rowIndex).getCreateur().getNom();
	            case 6:
	            	return listeJournalVirement.get(rowIndex).getIdVirement();
	            default:
	                return null; //Ne devrait jamais arriver
	        }
	    }
	    
	    public void removeJournalBudget(int rowIndex) {
	    	listeJournalVirement.remove(rowIndex);
	  
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }

		public VirementManager getVirementManager() {
			return virementManager;
		}

		public void setVirementManager(VirementManager virementManager) {
			this.virementManager = virementManager;
		}

		public List<Virement> getListeJournalVirement() {
			return listeJournalVirement;
		}

		public void setListeJournalVirement(List<Virement> listeJournalVirement) {
			this.listeJournalVirement = listeJournalVirement;
		}

		public String[] getEntetes() {
			return entetes;
		}

		public void clear() {
			int size = listeJournalVirement.size();
	    	for(int i=0; i<size; i++){
	    		listeJournalVirement.remove(0);
	            fireTableRowsDeleted(0, 0);
	    	}			
		}
	    
	    

}
