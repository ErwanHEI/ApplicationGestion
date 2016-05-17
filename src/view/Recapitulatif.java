package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;

public class Recapitulatif extends JPanel {
	
	HashMap <String,Integer> tableQuantite;
	HashMap <String,Double> tableMontant;
	
	public Recapitulatif( HashMap <String,Integer> tableQuantite,HashMap <String,Double> tableMontant) {
		setBackground(new Color(51, 102, 204));
		setLayout(null);
		
		
		
		
		
		
		Set entrees = tableQuantite.entrySet();
		Iterator iterateur = entrees.iterator();
		while(iterateur.hasNext()){
		JLabel textQuantite = new JLabel("");
		  Map.Entry entree = (Map.Entry)iterateur.next();
		  System.out.println("Nom du produit : "+entree.getKey()+", Quantite : "+entree.getValue()+"\n");
		  textQuantite.setText("Nom du produit : "+entree.getKey()+", Quantite : "+entree.getValue()+"\n");
		  add(textQuantite);
		}
		
		
		
		
		
		
		
		Set entrees1 = tableMontant.entrySet();
		Iterator iterateur1 = entrees1.iterator();
		while(iterateur1.hasNext()){
		JLabel textMontant = new JLabel();
		  Map.Entry entree1 = (Map.Entry)iterateur1.next();
		  System.out.println("Nom du budget : "+entree1.getKey()+", montant : "+entree1.getValue()+"\n");
		  textMontant.setText("Nom du budget : "+entree1.getKey()+", montant : "+entree1.getValue()+"\n");
		  add(textMontant);
		}
		
		

	}



	public HashMap<String, Integer> getTableQuantite() {
		return tableQuantite;
	}

	public void setTableQuantite(HashMap<String, Integer> tableQuantite) {
		this.tableQuantite = tableQuantite;
	}

	public HashMap<String, Double> getTableMontant() {
		return tableMontant;
	}

	public void setTableMontant(HashMap<String, Double> tableMontant) {
		this.tableMontant = tableMontant;
	}
	
	
}
