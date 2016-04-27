package controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import entitie.Produit;
import manager.ProduitManager;
import modelTableau.ModeleTableauListeProduit;
import view.PanelEvenement;

public class ControleurProduitEvenement extends AbstractAction{
	
	private PanelEvenement panelEvenement;
	private JTable tableau;
	private ModeleTableauListeProduit modeleListeProduit;
	private ProduitManager produitManager = new ProduitManager();
	private List<Integer> listeIdProduit;
	
	public ControleurProduitEvenement(PanelEvenement panelEvenement){
		super();
		this.panelEvenement = panelEvenement;
		this.tableau = panelEvenement.getTableauProduitEvenement();
		this.modeleListeProduit = panelEvenement.getModeleListeProduit();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableau.getSelectedRows();
        int column = 6;
        int cellule;
        listeIdProduit = new ArrayList<Integer>();
        
        for(int i=0; i<=row.length-1; i++){
        	cellule = (int) tableau.getValueAt(row[i], column);
        	listeIdProduit.add(cellule);
        	System.out.println(cellule);
        }
	}
	
	
	
	
}
