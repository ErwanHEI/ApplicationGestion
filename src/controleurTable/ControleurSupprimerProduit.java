package controleurTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.ProduitManager;
import modelTableau.ModeleTableauListeProduit;
import view.Fenetre;
import view.PanelProduit;

public class ControleurSupprimerProduit extends AbstractAction {
	
	private PanelProduit panelProduit;
	private JTable tableau;
	private ModeleTableauListeProduit modeleListeProduit;
	private ProduitManager produitManager = new ProduitManager();
	
	public ControleurSupprimerProduit(PanelProduit panelProduit){
		super();
		this.panelProduit = panelProduit;
		this.tableau = panelProduit.getTableauProduit();
		this.modeleListeProduit = panelProduit.getModeleListeProduit();
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
	        
	        if(rep == 0){
	        	for(int i = row.length-1; i >= 0; i--){
	        		cellule = (int) tableau.getValueAt(row[i], column);
	        		produitManager.suppressionProduit(cellule);
	        	}
	         
	        	for(int i = row.length - 1; i >= 0; i--){
	        		modeleListeProduit.removeProduit(row[i]);
	        	}
	        }
        }
	}


}