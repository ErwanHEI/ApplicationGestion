package lanceur;

import controler.AjoutBudgetControler;
import controler.AjoutVirementControleur;
import controler.AuthentificationControler;
import controler.BarreMenuControle;
import controler.ChangementMdpControleur;
import controler.CompteAdministrateurControleur;
import controler.ControlerAjoutStockage;
import controler.ControleurAjoutProduit;
import controler.ControleurModificationProduit;
import controler.MdpOublieControleur;
import entitie.User;
import manager.LancementManager;
import view.Authentification;
import view.Fenetre;
import view.FirstLaunch;

public class Main {

	public static void main(String[] args) {
		
		Integer compteur=LancementManager.getInstance().testLancement();
		if(compteur==0){
			FirstLaunch fi=new FirstLaunch();
			fi.getBoutonCreerCompteAdministrateur().addActionListener(new CompteAdministrateurControleur(fi));
			
			fi.execute();
			System.out.println("FL");
			LancementManager.getInstance().updateCompteur();
		}else{
			Authentification authe=new Authentification();
			authe.getBoutonMotDePasseOublie().addActionListener(new MdpOublieControleur(authe));
			authe.execute();
			System.out.println("AU");
		}
		

		
	}

}
