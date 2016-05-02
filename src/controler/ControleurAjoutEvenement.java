package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import entitie.Evenement;
import entitie.Produit;
import entitie.User;
import entitie.Virement;
import manager.BudgetManager;
import manager.EvenementManager;
import manager.VirementManager;
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
				", Quantit� n�cessaire : "+listeProduitEvenement.get(i).getQuantite());
		System.out.println("R�f�rence : "+referenceEvenement);
		System.out.println("Nom : "+nomEvenement);
		System.out.println("Date : "+dateEvenement);
		
		//R�cup�ration des virements de l'�venement
		List<Virement> listeVirement=panelEvenement.getListeVirementEvenement();
		System.out.println(listeVirement.size());
		
			
		Evenement evenement = new Evenement(0, nomEvenement, dateEvenement, user, listeProduitEvenement);
		Evenement newEvent=evenementManager.ajoutEvent(evenement);
		Integer idEvent=newEvent.getIdEvenement();
		for(int i=0; i<listeVirement.size();i++){
			listeVirement.get(i).setEventAssocie(new Evenement (idEvent, dateEvenement, dateEvenement, user, listeProduitEvenement));
			listeVirement.get(i).setCreateur(user);
			VirementManager.getInstance().ajoutVirement(listeVirement.get(i));
			BudgetManager.getInstance().majMontant(listeVirement.get(i), listeVirement.get(i).getBudgetAssocie().getIdBudget());
		}
		
		
		fenQuantiteProduitEvenement.fermerFenetre();
		
	}
}
