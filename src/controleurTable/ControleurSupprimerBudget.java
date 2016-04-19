package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.BudgetManager;
import modelTableau.ModeleTableauListeBudget;
import view.PanelBudget;
import view.PanelProduit;

public class ControleurSupprimerBudget extends AbstractAction{
	
	private PanelBudget panelBudget;
	private JTable tableau;
	private ModeleTableauListeBudget modeleListeBudget;
	private BudgetManager budgetManager = new BudgetManager();
	
	public ControleurSupprimerBudget(PanelBudget panelBudget){
		super();
		this.panelBudget = panelBudget;
		this.tableau = panelBudget.getTableauBudget();
		this.modeleListeBudget = panelBudget.getModeleListeBudget();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 6;
        int cellule;
        int test = row.length;
        
        if(test != 0){
	        int rep = JOptionPane.showConfirmDialog(null, "Souhaitez-vous supprimer ?",
	        		"Confirmer la suppression", JOptionPane.CANCEL_OPTION);
	        
	        if(rep==0){
		         for(int i = row.length-1; i >= 0; i--){
		        	cellule = (int) tableau.getValueAt(row[i], column);
		        	budgetManager.suppressionBudget(cellule);;
		        }
		         
		         for(int i = row.length - 1; i >= 0; i--){
		        	 modeleListeBudget.removeBudget(row[i]);
		        }
	        }
        }
	}
}
