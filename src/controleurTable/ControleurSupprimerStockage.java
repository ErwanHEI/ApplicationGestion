package controleurTable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import manager.StockageManager;
import modelTableau.ModeleTableauLieuStockage;
import view.PanelProduit;

public class ControleurSupprimerStockage extends AbstractAction{
	private PanelProduit panelProduit;
	private JTable tableau;
	private ModeleTableauLieuStockage modeleLieuStockage;
	private StockageManager stockageManager = new StockageManager();
	
	public ControleurSupprimerStockage(PanelProduit panelProduit){
		super();
		this.panelProduit = panelProduit;
		this.tableau = panelProduit.getTableauLieuStockage();
		this.modeleLieuStockage = panelProduit.getModeleLieuStockage();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 4;
        int cellule;
        int test = row.length;
        
        if(test != 0){
	        int rep = JOptionPane.showConfirmDialog(null, "Souhaitez-vous supprimer ?",
	        		"Confirmer la suppression", JOptionPane.CANCEL_OPTION);
	        
	        if(rep==0){
		         for(int i = row.length-1; i >= 0; i--){
		        	cellule = (int) tableau.getValueAt(row[i], column);
		        	stockageManager.suppressionStockage(cellule);
		        }
		         
		         for(int i = row.length - 1; i >= 0; i--){
		        	 modeleLieuStockage.removeStockage(row[i]);
		        }
	        }
        }
	}
	
}
