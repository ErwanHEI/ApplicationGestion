package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entitie.Budget;
import entitie.User;
import entitie.Virement;
import manager.BudgetManager;
import manager.VirementManager;
import view.Fenetre;
import view.PanelBudget;

public class AjoutVirementControleur implements ActionListener{
	
	private Fenetre fen;
	private PanelBudget pan;
	private boolean erreur;
	private String message;
	
	public AjoutVirementControleur( Fenetre fen, PanelBudget pan) {
		super();
		this.fen=fen;
		this.pan=pan;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("entree ok");
		Double montant=null;
		Budget budget=null;
		message="";
		erreur=false;
		String refE=pan.getChampReferenceEncaissement().getText();
		String emetteur=pan.getChampEmetteurEncaissement().getText();
		String recepteur=pan.getChampRecepteurEncaissement().getText();
		String dateE=pan.getChampDateEncaissement().getText();
		
		if(refE.equals("")){
			erreur=true;
			message="Veuillez saisir une réference";
		}else if(emetteur.equals("")){
			erreur=true;
			message="Veuillez saisir un emetteur";
		}else if(recepteur.equals("")){
			erreur=true;
			message="Veuillez saisir un recepteur";
		
		}else if(dateE.equals("")){
			erreur=true;
			message="Veuillez saisir une date effective de virement";
			
		}else if(pan.getChampMontantEncaissement().getText().equals("")){
		
			erreur=true;
			message="Veuillez saisir un montant prévu";
		}else{
			 montant=Double.parseDouble(pan.getChampMontantEncaissement().getText());
		}
		if(pan.getComboBoxDynamiqueBudget().getBudgetSelect()==null){
			erreur=true;
			message="Veuillez sélectionner un budget";
		}else{
			budget=pan.getComboBoxDynamiqueBudget().getBudgetSelect();
		}
		
		if(!erreur){
			User crea=fen.getUserActuel();
			
			Virement virement=new Virement(0, refE, montant, emetteur, recepteur, dateE, false, null, budget, crea);
			VirementManager.getInstance().ajoutVirement(virement);
			BudgetManager.getInstance().majMontant(virement, budget.getIdBudget());
			System.out.println("ajout ok");
			
			
		}else{
			System.out.println("erreur ok");
			pan.getLabelErreurAjoutEncaissement().setText(message);
		}
		
			
		
	}
	
	
	

}
