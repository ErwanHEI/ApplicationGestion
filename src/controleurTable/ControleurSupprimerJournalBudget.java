package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.BudgetManager;
import manager.VirementManager;
import modelTableau.ModeleTableauJournalBudget;
import modelTableau.ModeleTableauListeBudget;
import view.PanelBudget;

public class ControleurSupprimerJournalBudget extends AbstractAction{
	private PanelBudget panelBudget;
	private JTable tableau;
	private ModeleTableauJournalBudget modeleJournalBudget;
	private VirementManager budgetManager = new VirementManager();
	
	public ControleurSupprimerJournalBudget(PanelBudget panelBudget){
		super();
		this.panelBudget = panelBudget;
		this.tableau = panelBudget.getTableauJournalBudget();
		this.modeleJournalBudget = panelBudget.getModeleTableauJournalBudget();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 7;
        int cellule;
        int test = row.length;
        
        if(test != 0){
	        int rep = JOptionPane.showConfirmDialog(null, "Souhaitez-vous supprimer ?",
	        		"Confirmer la suppression", JOptionPane.CANCEL_OPTION);
	        
	        if(rep==0){
		         for(int i = row.length-1; i >= 0; i--){
		        	cellule = (int) tableau.getValueAt(row[i], column);
		        	budgetManager.suppressionVirement(cellule);
		        }
		         
		         for(int i = row.length - 1; i >= 0; i--){
		        	 modeleJournalBudget.removeJournalBudget(row[i]);
		        }
	        }
        }
	}
}
