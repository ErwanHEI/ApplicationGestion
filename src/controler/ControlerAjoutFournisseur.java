package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import entitie.Fournisseur;
import manager.FournisseurManager;
import view.AjoutFournisseur;

public class ControlerAjoutFournisseur extends AbstractAction{

	private AjoutFournisseur fenAjoutFournisseur;
	private FournisseurManager fournisseurManager = new FournisseurManager();
	
	public ControlerAjoutFournisseur(AjoutFournisseur fenAjoutFounisseur){
		this.fenAjoutFournisseur = fenAjoutFounisseur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	String nom = fenAjoutFournisseur.getChampNom().getText();
    	String adresse = fenAjoutFournisseur.getChampAdresse().getText();
    	if(fenAjoutFournisseur.getChampNom().getText().length()==0 || fenAjoutFournisseur.getChampAdresse().getText().length()==0){
    		JOptionPane.showMessageDialog(null, "Veuillez ne pas mettre de champ vide", "Message d'information",
    				JOptionPane.WARNING_MESSAGE);
    	}
    	else{
    		fournisseurManager.ajoutFournisseur(new Fournisseur(1, nom, adresse));
    		fenAjoutFournisseur.fermerFenetre();
    		
    	}
	}
	
}
