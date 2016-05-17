package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entitie.Budget;
import entitie.User;
import manager.BudgetManager;
import view.Fenetre;
import view.PanelBudget;

public class AjoutBudgetControler implements ActionListener{
	
	private Fenetre fen;
	private boolean erreur;
	private String message;
	private PanelBudget pan;
	
	public AjoutBudgetControler(Fenetre fen,PanelBudget pan) {;
		this.fen = fen;
		this.pan=pan;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(fen.getUserActuel().getEmail());
		erreur=false;
		message="";
		Double montantp=null;
		String ref=pan.getChampReferenceBudget().getText();
		String nomB=pan.getChampNomBudget().getText();
		
		
		if(ref.equals("")){
			erreur=true;
			message="Veuillez saisir une réference";
		}else if(nomB.equals("")){
			erreur=true;
			message="Veuillez saisir un nom";
		}else if(pan.getChampBudgetFixe().getText().equals("")){
			erreur=true;
			message="Veuillez saisir un montant prévu";
		}else{
			 montantp=Double.parseDouble(pan.getChampBudgetFixe().getText());
		}
		
		if(!erreur){
			
			User crea=fen.getUserActuel();
			
			Budget budget=new Budget(1,ref,nomB,montantp,0,crea);
			BudgetManager.getInstance().ajoutBudget(budget);
			System.out.println("ok ajout");
			PanelBudget pan=new PanelBudget();
			fen.changerPanelBudget(pan);
		}else {
			System.out.println("ok erreur");
			//gestion erreur
			pan.getLabelErreurCreationBudget().setText(message);
		}
	}
	
	
	
	
	

}
