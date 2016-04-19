package modelTableau;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entitie.Budget;
import entitie.Produit;
import manager.BudgetManager;
import manager.ProduitManager;

public class ModeleTableauListeBudget extends AbstractTableModel{

	private BudgetManager budgetManager = new BudgetManager();
    private List<Budget> listeBudget = new ArrayList<Budget>();
 
    private final String[] entetes = {"Référence", "Nom", "Budget fixé", "Budget réel", "Restant à encaisser", "Solde réel", "Id Budget"};
 
    public ModeleTableauListeBudget() {
        super();
        listeBudget = budgetManager.listerBudget();
    }
 
    public int getRowCount() {
        return listeBudget.size();
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
                return listeBudget.get(rowIndex).getRef();
            case 1:
                return listeBudget.get(rowIndex).getNomBudget();
            case 2:
                return listeBudget.get(rowIndex).getMontantPrevu();
            case 3:
                return listeBudget.get(rowIndex).getMontantUtilise();
            /*case 4:
                return listeBudget.get(rowIndex).;
            case 5:
                return listeBudget.get(rowIndex).;*/
            case 6:
                return listeBudget.get(rowIndex).getIdBudget();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public void removeBudget(int rowIndex) {
    	listeBudget.remove(rowIndex);
  
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

	public BudgetManager getBudgetManager() {
		return budgetManager;
	}

	public void setBudgetManager(BudgetManager budgetManager) {
		this.budgetManager = budgetManager;
	}

	public List<Budget> getListeBudget() {
		return listeBudget;
	}

	public void setListeBudget(List<Budget> listeBudget) {
		this.listeBudget = listeBudget;
	}

	public String[] getEntetes() {
		return entetes;
	}
    
    
}
