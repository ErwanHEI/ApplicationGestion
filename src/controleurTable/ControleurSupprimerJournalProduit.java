package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.ProduitManager;
import modelTableau.ModeleTableauJournalProduit;
import view.PanelProduit;

public class ControleurSupprimerJournalProduit extends AbstractAction {
	private PanelProduit panelProduit;
	private JTable tableau;
	private ModeleTableauJournalProduit modeleJournalProduit;
	private ProduitManager produitManager = new ProduitManager();
	
	public ControleurSupprimerJournalProduit(PanelProduit panelProduit){
		super();
		this.panelProduit = panelProduit;
		this.tableau = panelProduit.getTableauJournalStock();
		this.modeleJournalProduit = panelProduit.getModeleJournalProduit();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 5;
        int cellule;
        int test = row.length;
        
        if(test != 0){
	        int rep = JOptionPane.showConfirmDialog(null, "Souhaitez-vous supprimer ?",
	        		"Confirmer la suppression", JOptionPane.CANCEL_OPTION);
	        
	        if(rep==0){
		         for(int i = row.length-1; i >= 0; i--){
		        	cellule = (int) tableau.getValueAt(row[i], column);
		        	produitManager.suppressionJournalProduit(cellule);
		        }
		         
		         for(int i = row.length - 1; i >= 0; i--){
		        	 modeleJournalProduit.removeJournalProduit(row[i]);
		        }
	        }
        }
	}
}
