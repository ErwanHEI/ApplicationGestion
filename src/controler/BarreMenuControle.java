package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Authentification;
import view.CreationCompte;
import view.Fenetre;
import view.PanelBudget;
import view.PanelEvenement;
import view.PanelProduit;

public class BarreMenuControle implements ActionListener{
	
	private Fenetre fen;

	public BarreMenuControle(Fenetre fen) {
		this.fen = fen;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
			
			if(e.getSource()==fen.getMntmCrerUnNouveau()){
				CreationCompte creationCompte = new CreationCompte();
				creationCompte.execute();
				
			}
			
			if(e.getSource()==fen.getMntmStocks()){
				//changement panel produit
				PanelEvenement pan2=new PanelEvenement();
				PanelProduit pan=new PanelProduit();
				fen.changerPanelEvenement(pan2);
			}
			
			if(e.getSource()==fen.getMntmBudget()){
				// changement panel budget
				if(fen.getUserActuel().getTypeUser()==1 ||fen.getUserActuel().getTypeUser()==3){
					PanelBudget pan=new PanelBudget();
					PanelEvenement pan2 = new PanelEvenement();
					fen.changerPanelBudget(pan);
				}else{
					JOptionPane.showMessageDialog(null, "Vous n'avez pas l'autorisation pour y accéder", "ERREUR", 0);
				}
				
			}
			
			if(e.getSource()==fen.getMntmEvenements()){
				//changement panel event
				PanelBudget pan=new PanelBudget();
				PanelEvenement pan2=new PanelEvenement();
				fen.changerPanelEvenement(pan2);
			}
			
			if(e.getSource()==fen.getMntmDconnexion()){
				fen.setUserActuel(null);
				Authentification authen=new Authentification();
				authen.execute();
				fen.fermerFentre();
			}
		
	}

}
