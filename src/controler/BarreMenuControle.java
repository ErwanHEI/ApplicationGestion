package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import view.Authentification;
import view.CreationCompte;
import view.Fenetre;
import view.PanelBudget;
import view.PanelEvenement;
import view.PanelProduit;
import view.Parametrage;

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
				PanelProduit pan=new PanelProduit();
				fen.changerPanelStock(pan);
			}
			
			if(e.getSource()==fen.getMntmBudget()){
				// changement panel budget
				if(fen.getUserActuel().getTypeUser()==1 ||fen.getUserActuel().getTypeUser()==3){
					PanelBudget pan=new PanelBudget();
					fen.changerPanelBudget(pan);
				}else{
					JOptionPane.showMessageDialog(null, "Vous n'avez pas l'autorisation pour y accéder", "ERREUR", 0);
				}
				
			}
			
			if(e.getSource()==fen.getMntmEvenements()){
				//changement panel event
				PanelEvenement pan2=new PanelEvenement();
				fen.changerPanelEvenement(pan2);
			}
			
			if(e.getSource()==fen.getMntmDconnexion()){
				fen.setUserActuel(null);
				Authentification authen=new Authentification();
				authen.execute();
				fen.fermerFentre();
			}
			
			if(e.getSource()==fen.getMntmConsulterSurPdf()){
				System.out.println("aide sur pdf");
				try {
					java.awt.Desktop.getDesktop().open(new File("fichiers/SG_LettreMotivation.pdf"));
					
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 }
			}
			
			if(e.getSource()==fen.getMntmParametrage()){
				Parametrage param=new Parametrage();
				param.getBoutonParametrer().addActionListener(new ParametrageControleur(param));
				
			}
		
	}

}
