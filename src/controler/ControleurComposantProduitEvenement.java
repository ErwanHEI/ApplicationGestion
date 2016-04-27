package controler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControleurComposantProduitEvenement {

	
	public JPanel ControleurComposantProduitEvenement(){
		JPanel panel = new JPanel();
		
		JLabel labelProduit = new JLabel("produit :");
		panel.add(labelProduit);
		labelProduit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelProduit.setForeground(new Color(0, 0, 0));
				
		JTextField champProduit = new JTextField();
		champProduit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(champProduit);
		champProduit.setColumns(10);
		
		return panel;
	}
}
