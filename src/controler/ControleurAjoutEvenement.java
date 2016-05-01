package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import entitie.Evenement;
import entitie.Produit;
import entitie.User;
import manager.EvenementManager;
import modelTableau.ModeleTableauQuantiteProduitEvenement;
import view.Fenetre;
import view.PanelEvenement;
import view.QuantiteProduitEvenement;

public class ControleurAjoutEvenement implements ActionListener{

	private User user;
	private QuantiteProduitEvenement fenQuantiteProduitEvenement;
	private PanelEvenement panelEvenement;
	private String referenceEvenement;
	private String nomEvenement;
	private String dateEvenement;
	private ModeleTableauQuantiteProduitEvenement modeleTableauQuantiteProduit;
	private List<Produit> listeProduitEvenement;
	private EvenementManager evenementManager = new EvenementManager();
	
	public ControleurAjoutEvenement(QuantiteProduitEvenement fenQuantiteProduitEvenement){
		super();
		this.user = fenQuantiteProduitEvenement.getUser();
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
		//VERIFICATION CONSOLE
		for(int i=0; i<listeProduitEvenement.size(); i++)
		System.out.println("Nom produit : "+listeProduitEvenement.get(i).getNomProduit()+
				", Quantité nécessaire : "+listeProduitEvenement.get(i).getQuantite());
		System.out.println("Référence : "+referenceEvenement);
		System.out.println("Nom : "+nomEvenement);
		System.out.println("Date : "+dateEvenement);
			
		Evenement evenement = new Evenement(0, nomEvenement, dateEvenement, user, listeProduitEvenement);
		evenementManager.ajoutEvent(evenement);
		
		fenQuantiteProduitEvenement.fermerFenetre();
		
	}
}
