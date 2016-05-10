package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JOptionPane;

import entitie.Fournisseur;
import manager.FournisseurManager;
import util.PropertyLoader;
import view.AjoutFournisseur;
import view.Parametrage;

public class ParametrageControleur implements ActionListener{

	private Parametrage parametrage;
	
	
	
	public ParametrageControleur(Parametrage parametrage) {
		this.parametrage = parametrage;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
    	String cle = parametrage.getChampCle().getText();
    	String valeur = parametrage.getChampValeur().getText();
    	if( valeur.equals("")||cle.equals("") ){
  

    		JOptionPane.showMessageDialog(null, "Veuillez saisir une paire clé valeur valable", "Message d'information",
    				JOptionPane.WARNING_MESSAGE);
    	} else{
    		try{
   	         //modifier la clé avec nouvelle valeur
   	        
   	      }
   	      catch(Exception e1){
   	         e1.printStackTrace();
   	      }
    		parametrage.fermerFenetre();
    		
    	}
	}
	
}



