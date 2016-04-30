package controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import entitie.Evenement;
import entitie.Produit;
import manager.ProduitManager;
import modelTableau.ModeleTableauListeProduit;
import modelTableau.ModeleTableauQuantiteProduit;
import view.AjoutFournisseur;
import view.PanelEvenement;
import view.QuantiteProduitEvenement;

public class ControleurProduitEvenement extends AbstractAction{
	
	
	private PanelEvenement panelEvenement;
	private JTable tableauProduitEvenement;
	private JTable tableauQuantiteProduit;
	private ModeleTableauListeProduit modeleListeProduit;
	private ModeleTableauQuantiteProduit modeleTableauQuantiteProduit;
	private ProduitManager produitManager = new ProduitManager();
	private List<Integer> listeIdProduit;
	private QuantiteProduitEvenement fenQuantiteProduitEvenement;
	
	public ControleurProduitEvenement(PanelEvenement panelEvenement){
		super();
		this.panelEvenement = panelEvenement;
		this.tableauProduitEvenement = panelEvenement.getTableauProduitEvenement();
		this.modeleListeProduit = panelEvenement.getModeleListeProduit();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
        int[] row = tableauProduitEvenement.getSelectedRows();
        int column = 6;
        int cellule;
        listeIdProduit = new ArrayList<Integer>();
        
        for(int i=0; i<=row.length-1; i++){
        	cellule = (int) tableauProduitEvenement.getValueAt(row[i], column);
        	listeIdProduit.add(cellule);
        	System.out.println(cellule);
        }
        fenQuantiteProduitEvenement = new QuantiteProduitEvenement(listeIdProduit);
        Evenement event=new Evenement(1, null, null, null, null);
        fenQuantiteProduitEvenement.setEvent(event);
        fenQuantiteProduitEvenement.getBoutonValider().addActionListener(new ControleurAjoutQuantiteProduitEvenement(fenQuantiteProduitEvenement));
	}
	
	
	
	
}
