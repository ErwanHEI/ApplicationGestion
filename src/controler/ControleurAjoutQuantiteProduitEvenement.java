package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import entitie.Produit;
import modelTableau.ModeleTableauQuantiteProduit;
import view.QuantiteProduitEvenement;

public class ControleurAjoutQuantiteProduitEvenement implements ActionListener{

	private QuantiteProduitEvenement fenQuantiteProduitEvenement;
	private JTable tableauQuantiteProduit;
	private ModeleTableauQuantiteProduit modeleTableauQuantiteProduit;
	private List<Produit> listeProduitEvenement;
	
	public ControleurAjoutQuantiteProduitEvenement(QuantiteProduitEvenement fenQuantiteProduitEvenement){
		super();
		this.fenQuantiteProduitEvenement=fenQuantiteProduitEvenement;
		this.modeleTableauQuantiteProduit=this.fenQuantiteProduitEvenement.getModeleListeProduit();
		this.listeProduitEvenement=this.modeleTableauQuantiteProduit.getListeProduitEvenement();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		//BALANCER listeProduitEvenement dans impl//
		for(int i=0; i<listeProduitEvenement.size(); i++)
		System.out.println(listeProduitEvenement.get(i).getQuantite());
	}
}
