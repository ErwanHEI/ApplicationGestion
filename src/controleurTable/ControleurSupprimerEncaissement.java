package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.VirementManager;
import modelTableau.ModeleTableauEncaissement;
import view.PanelBudget;

public class ControleurSupprimerEncaissement extends AbstractAction {
	
	private PanelBudget panelBudget;
	private JTable tableau;
	private ModeleTableauEncaissement modeleListeEncaissement;
	private VirementManager virementManager = new VirementManager();
	
	public ControleurSupprimerEncaissement(PanelBudget panelBudget){
		super();
		this.panelBudget = panelBudget;
		this.tableau = panelBudget.getTableauEncaissement();
		this.modeleListeEncaissement = panelBudget.getModeleListeEncaissement();
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
		        	virementManager.suppressionVirement(cellule);;
		        }
		         
		         for(int i = row.length - 1; i >= 0; i--){
		        	 modeleListeEncaissement.removeVirement(row[i]);
		        }
	        }
        }
	}

}
