package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import manager.BudgetManager;
import manager.VirementManager;
import modelTableau.ModeleTableauEncaissement;
import modelTableau.ModeleTableauListeBudget;
import view.PanelBudget;

public class ControleurEncaisserVirement extends AbstractAction{

	private PanelBudget panelBudget;
	private JTable tableau;
	private ModeleTableauEncaissement modeleListeEncaissement;
	private VirementManager virementManager = new VirementManager();
	
	public ControleurEncaisserVirement(PanelBudget panelBudget){
		super();
		this.panelBudget = panelBudget;
		this.tableau = panelBudget.getTableauEncaissement();
		this.modeleListeEncaissement = panelBudget.getModeleListeEncaissement();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 5;
        int cellule;
        
         for(int i = row.length-1; i >= 0; i--){
        	cellule = (int) tableau.getValueAt(row[i], column);
        	virementManager.passerEncaissement(cellule);
        }
         
         for(int i = row.length - 1; i >= 0; i--){
        	 modeleListeEncaissement.removeVirement(row[i]);
        }
        
        
	}
}
