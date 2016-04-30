package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import entitie.Evenement;
import entitie.Produit;
import manager.EvenementManager;
import modelTableau.ModeleTableauQuantiteProduit;
import view.PanelEvenement;
import view.QuantiteProduitEvenement;

public class ControleurAjoutQuantiteProduitEvenement implements ActionListener{

	private QuantiteProduitEvenement fenQuantiteProduitEvenement;
	private PanelEvenement panelEvenement;
	private String referenceEvenement;
	private String nomEvenement;
	private String dateEvenement;
	private ModeleTableauQuantiteProduit modeleTableauQuantiteProduit;
	private List<Produit> listeProduitEvenement;
	private EvenementManager evenementManager = new EvenementManager();
	
	public ControleurAjoutQuantiteProduitEvenement(QuantiteProduitEvenement fenQuantiteProduitEvenement){
		super();
		this.fenQuantiteProduitEvenement = fenQuantiteProduitEvenement;
		this.panelEvenement = fenQuantiteProduitEvenement.getPanelEvenement();
		this.referenceEvenement = panelEvenement.getChampReferenceEvenement().getText();
		this.nomEvenement = panelEvenement.getChampNomEvenement().getText();
		this.dateEvenement = panelEvenement.getChampDateEvenement().getText();
		this.modeleTableauQuantiteProduit = fenQuantiteProduitEvenement.getModeleListeProduit();
		this.listeProduitEvenement = modeleTableauQuantiteProduit.getListeProduitEvenement();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		//BALANCER listeProduitEvenement dans impl//
		
		//VERIFICATION CONSOLE
		for(int i=0; i<listeProduitEvenement.size(); i++)
		System.out.println("Nom produit : "+listeProduitEvenement.get(i).getNomProduit()+
				", Quantité nécessaire : "+listeProduitEvenement.get(i).getQuantite());
		System.out.println("Référence : "+referenceEvenement);
		System.out.println("Nom : "+nomEvenement);
		System.out.println("Date : "+dateEvenement);
		
		Evenement evenement = new Evenement(0, nomEvenement, dateEvenement, null, listeProduitEvenement);
		evenementManager.ajoutEvent(evenement);
		
		fenQuantiteProduitEvenement.fermerFenetre();
		
	}
}
