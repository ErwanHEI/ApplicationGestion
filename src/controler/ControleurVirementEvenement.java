package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import entitie.Budget;
import entitie.User;
import entitie.Virement;
import manager.BudgetManager;
import manager.VirementManager;
import view.AjoutVirementEvenement;
import view.Fenetre;
import view.PanelEvenement;

public class ControleurVirementEvenement implements ActionListener{
	
	private PanelEvenement pan;
	private Fenetre fen;
	private User user;
	private AjoutVirementEvenement virE;
	private String message;
	private boolean erreur;
	
	public ControleurVirementEvenement(PanelEvenement pan, Fenetre fen, AjoutVirementEvenement virE){
		this.fen=fen;
		this.pan = pan;
		this.virE=virE;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Virement> liste=pan.getListeVirementEvenement();
		
		System.out.println("taille liste:"+liste.size());
		Double montant=null;
		Budget budget=null;
		message="";
		erreur=false;
		String refE=virE.getChampReference().getText();
		String emetteur=virE.getChampEmetteur().getText();
		String recepteur=virE.getChampRecepteur().getText();
		String dateE=virE.getChampDate().getText();
		
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
			
		}else if(virE.getChampMontant().getText().equals("")){
		
			erreur=true;
			message="Veuillez saisir un montant prévu";
		}else{
			 montant=Double.parseDouble(virE.getChampMontant().getText());
		}
		if(virE.getComboBoxDynamiqueBudget().getBudgetSelect()==null){
			erreur=true;
			message="Veuillez sélectionner un budget";
		}else{
			budget=virE.getComboBoxDynamiqueBudget().getBudgetSelect();
		}
		
		if(!erreur){
			//User crea=fen.getUserActuel();
			
			Virement virement=new Virement(0, refE, montant, emetteur, recepteur, dateE, false, null, budget, null);
			liste.add(virement);
			pan.setListeVirementEvenement(liste);
			System.out.println("ajout à la liste ok");
			
			
		}else{
			System.out.println("erreur ok");
			
		}

		
	}

}
