package controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import modelTableau.ModeleTableauListeProduit;
import view.PanelEvenement;
import view.QuantiteProduitEvenement;

public class ControleurProduitEvenement extends AbstractAction{
	
	
	private PanelEvenement panelEvenement;
	
	private JTable tableauProduitEvenement;
	private ModeleTableauListeProduit modeleListeProduit;
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
        
        //id des produits s�lectionn�s mis dans une liste
        for(int i=0; i<=row.length-1; i++){
        	cellule = (int) tableauProduitEvenement.getValueAt(row[i], column); 
        	listeIdProduit.add(cellule);
        	System.out.println("Id s�lectionn� : "+cellule);
        }
        //Ouverture de la fen�tre de saisie des quantit�s n�cessaires
        fenQuantiteProduitEvenement = new QuantiteProduitEvenement(panelEvenement, listeIdProduit);
        fenQuantiteProduitEvenement.getBoutonValider().addActionListener(new ControleurAjoutQuantiteProduitEvenement(fenQuantiteProduitEvenement));
	}
	
	
	
	
}
