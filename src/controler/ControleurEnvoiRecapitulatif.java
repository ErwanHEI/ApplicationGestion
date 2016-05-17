package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import manager.ProduitManager;
import util.PropertyLoader;
import util.SendMail;
import view.Recapitulatif;

public class ControleurEnvoiRecapitulatif implements ActionListener{
	
	private Recapitulatif recap;
	private String message="Recapitulatif de la simulation d'évènements : \n";
	

	public ControleurEnvoiRecapitulatif(Recapitulatif recap) {
		super();
		this.recap = recap;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		HashMap <String,Integer> tableQuantite=recap.getTableQuantite();
		HashMap <String,Double> tableMontant=recap.getTableMontant();
		
		Set entrees = tableQuantite.entrySet();
		Iterator iterateur = entrees.iterator();
		while(iterateur.hasNext()){
		  Map.Entry entree = (Map.Entry)iterateur.next();
		  message=message+"Nom du produit : "+entree.getKey()+", Quantite : "+entree.getValue()+"\n";
		}
		
		Set entrees1 = tableMontant.entrySet();
		Iterator iterateur1 = entrees1.iterator();
		while(iterateur1.hasNext()){
		  Map.Entry entree1 = (Map.Entry)iterateur1.next();
		  message=message+"Nom du budget : "+entree1.getKey()+", montant : "+entree1.getValue()+"\n";
		}
		
		PropertyLoader property=new PropertyLoader();
		try {
			Properties prop=property.load("fichiers/proprietes");
			String mailInformation=prop.getProperty("mailInfo");
				SendMail mail=new SendMail();
				mail.start(mailInformation,message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(message);
	}

}
