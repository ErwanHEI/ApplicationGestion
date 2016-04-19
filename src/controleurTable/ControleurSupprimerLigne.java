package controleurTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import modelTableau.ModeleTableauListeProduit;
import view.Fenetre;
import view.PanelProduit;

public class ControleurSupprimerLigne extends AbstractAction {
	
	private PanelProduit panelProduit;
	private JTable tableau;
	private ModeleTableauListeProduit modeleListeProduit;
	
	public ControleurSupprimerLigne(PanelProduit panelProduit){
		super();
		this.panelProduit = panelProduit;
		tableau = panelProduit.getTableauProduit();
		modeleListeProduit = panelProduit.getModeleListeProduit();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] selection = tableau.getSelectedRows();
        
        		
        for(int i = selection.length - 1; i >= 0; i--){
        	modeleListeProduit.removeProduit(selection[i]);
        }
		
        
        
	}


}