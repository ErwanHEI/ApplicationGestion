package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AjoutFournisseur extends JFrame {

	private JPanel panelFenAjoutFournisseur;
	private JTextField champNom;
	private JTextField champAdresse;
	private JButton boutonAjouterNouveauFournisseur;

	
	public AjoutFournisseur() {
		setTitle("Nouveau fournisseur");
		setLocationRelativeTo(null);
		setVisible(true);
		setBounds(100, 100, 550, 290);
		panelFenAjoutFournisseur = new JPanel();
		panelFenAjoutFournisseur.setBackground(new Color(51, 102, 204));
		panelFenAjoutFournisseur.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelFenAjoutFournisseur);
		panelFenAjoutFournisseur.setLayout(null);
		
		JLabel labelAjoutNouveauFournisseur = new JLabel("Ajout d'un nouveau fournisseur");
		labelAjoutNouveauFournisseur.setForeground(new Color(255, 255, 255));
		labelAjoutNouveauFournisseur.setFont(new Font("Tahoma", Font.BOLD, 27));
		labelAjoutNouveauFournisseur.setBounds(63, 16, 430, 34);
		panelFenAjoutFournisseur.add(labelAjoutNouveauFournisseur);
		
		JLabel labelNom = new JLabel("Nom :");
		labelNom.setForeground(new Color(255, 255, 255));
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNom.setBounds(57, 91, 54, 20);
		panelFenAjoutFournisseur.add(labelNom);
		
		champNom = new JTextField();
		champNom.setBounds(126, 90, 367, 26);
		panelFenAjoutFournisseur.add(champNom);
		champNom.setColumns(10);
		
		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setForeground(new Color(255, 255, 255));
		labelAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAdresse.setBounds(28, 128, 83, 20);
		panelFenAjoutFournisseur.add(labelAdresse);
		
		champAdresse = new JTextField();
		champAdresse.setColumns(10);
		champAdresse.setBounds(126, 127, 367, 26);
		panelFenAjoutFournisseur.add(champAdresse);
		
		boutonAjouterNouveauFournisseur = new JButton("Ajouter");
		boutonAjouterNouveauFournisseur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boutonAjouterNouveauFournisseur.setBounds(398, 189, 115, 29);
		panelFenAjoutFournisseur.add(boutonAjouterNouveauFournisseur);
	}
	
	public void fermerFenetre(){
		dispose();
	}


	public JPanel getPanelFenAjoutFournisseur() {
		return panelFenAjoutFournisseur;
	}

	
	public JTextField getChampNom() {
		return champNom;
	}


	public void setChampNom(JTextField champNom) {
		this.champNom = champNom;
	}


	public JTextField getChampAdresse() {
		return champAdresse;
	}


	public void setChampAdresse(JTextField champAdresse) {
		this.champAdresse = champAdresse;
	}


	public JButton getBoutonAjouterNouveauFournisseur() {
		return boutonAjouterNouveauFournisseur;
	}


	public void setBoutonAjouterNouveauFournisseur(JButton boutonAjouterNouveauFournisseur) {
		this.boutonAjouterNouveauFournisseur = boutonAjouterNouveauFournisseur;
	}
	
	
}
