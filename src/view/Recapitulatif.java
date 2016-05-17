package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Recapitulatif extends JPanel {
	
	HashMap <String,Integer> tableQuantite;
	HashMap <String,Double> tableMontant;
	JButton btnEnvoyerParMail ;
	
	
	public Recapitulatif( HashMap <String,Integer> tableQuantite,HashMap <String,Double> tableMontant) {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 90, 400, 400);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(515, 90, 428, 400);
		add(scrollPane1);
		
		JPanel panel1 = new JPanel();
		scrollPane1.setViewportView(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRcapitulatif = new JLabel("R\u00E9capitulatif");
		lblRcapitulatif.setForeground(Color.WHITE);
		lblRcapitulatif.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRcapitulatif.setBounds(398, 16, 199, 37);
		add(lblRcapitulatif);
		
		
		btnEnvoyerParMail = new JButton("Envoyer par mail");
		btnEnvoyerParMail.setBounds(790, 26, 153, 29);
		add(btnEnvoyerParMail);
		
		setBackground(new Color(51, 102, 204));
		setLayout(null);
		
		JLabel titre=new JLabel("Quantités nécéssaire");
		JLabel titre1=new JLabel("Etats des budgets");
		
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(titre);
		panel.add(Box.createVerticalStrut(15));
		  
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
		panel1.add(titre1);
		panel1.add(Box.createVerticalStrut(15));
		
		
		Set entrees = tableQuantite.entrySet();
		Iterator iterateur = entrees.iterator();
		while(iterateur.hasNext()){
			JLabel textQuantite = new JLabel("");
		  Map.Entry entree = (Map.Entry)iterateur.next();
		  System.out.println("Nom du produit : "+entree.getKey()+", Quantite : "+entree.getValue()+"\n");
		  textQuantite.setText("Nom du produit : "+entree.getKey()+", Quantite : "+entree.getValue()+"\n");
		  panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		  panel.add(textQuantite);
		  panel.add(Box.createVerticalStrut(10));
		  
		}
		
		Set entrees1 = tableMontant.entrySet();
		Iterator iterateur1 = entrees1.iterator();
		while(iterateur1.hasNext()){
		JLabel textMontant = new JLabel();
		  Map.Entry entree1 = (Map.Entry)iterateur1.next();
		  System.out.println("Nom du budget : "+entree1.getKey()+", montant : "+entree1.getValue()+"\n");
		  textMontant.setText("Nom du budget : "+entree1.getKey()+", montant : "+entree1.getValue()+"\n");
		  panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
		  panel1.add(textMontant);
		  panel1.add(Box.createVerticalStrut(10));
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



	public JButton getBtnEnvoyerParMail() {
		return btnEnvoyerParMail;
	}



	public void setBtnEnvoyerParMail(JButton btnEnvoyerParMail) {
		this.btnEnvoyerParMail = btnEnvoyerParMail;
	}
	
	
}
