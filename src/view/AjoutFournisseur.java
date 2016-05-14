package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AjoutFournisseur extends JFrame {

	private JPanel panelFenAjoutFournisseur;
	private JTextField champNom;
	private JTextField champAdresse;
	private JButton boutonAjouterNouveauFournisseur;

	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;
	
	public AjoutFournisseur() {
		setTitle("Nouveau fournisseur");
		setLocationRelativeTo(null);
		setVisible(true);
		setBounds((int) ((x/2)-((550*adaptx)/2)), (int) ((y/2)-((290*adapty)/2)), (int) (550*adaptx), (int) (290*adaptx));
		panelFenAjoutFournisseur = new JPanel();
		panelFenAjoutFournisseur.setBackground(new Color(51, 102, 204));
		panelFenAjoutFournisseur.setBorder(new EmptyBorder((int) (5*adapty), (int) (5*adapty), (int) (5*adapty), (int) (5*adapty)));
		setContentPane(panelFenAjoutFournisseur);
		panelFenAjoutFournisseur.setLayout(null);
		
		JLabel labelAjoutNouveauFournisseur = new JLabel("Ajout d'un nouveau fournisseur");
		labelAjoutNouveauFournisseur.setForeground(new Color(255, 255, 255));
		labelAjoutNouveauFournisseur.setFont(new Font("Tahoma", Font.BOLD, (int) (27*adaptx)));
		labelAjoutNouveauFournisseur.setBounds((int) (63*adaptx), (int) (16*adapty), (int) (430*adaptx), (int) (34*adaptx));
		panelFenAjoutFournisseur.add(labelAjoutNouveauFournisseur);
		
		JLabel labelNom = new JLabel("Nom :");
		labelNom.setForeground(new Color(255, 255, 255));
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelNom.setBounds((int) (57*adaptx), (int) (91*adapty), (int) (54*adaptx), (int) (20*adaptx));
		panelFenAjoutFournisseur.add(labelNom);
		
		champNom = new JTextField();
		champNom.setBounds((int) (126*adaptx), (int) (90*adapty), (int) (367*adaptx), (int) (26*adaptx));
		panelFenAjoutFournisseur.add(champNom);
		champNom.setColumns(10);
		
		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setForeground(new Color(255, 255, 255));
		labelAdresse.setFont(new Font("Tahoma", Font.PLAIN, (int) (20*adaptx)));
		labelAdresse.setBounds((int) (28*adaptx), (int) (128*adapty), (int) (83*adaptx), (int) (20*adaptx));
		panelFenAjoutFournisseur.add(labelAdresse);
		
		champAdresse = new JTextField();
		champAdresse.setColumns(10);
		champAdresse.setBounds((int) (126*adaptx), (int) (127*adapty), (int) (367*adaptx), (int) (26*adaptx));
		panelFenAjoutFournisseur.add(champAdresse);
		
		boutonAjouterNouveauFournisseur = new JButton("Ajouter");
		boutonAjouterNouveauFournisseur.setFont(new Font("Tahoma", Font.PLAIN, (int) (18*adaptx)));
		boutonAjouterNouveauFournisseur.setBounds((int) (398*adaptx), (int) (189*adapty), (int) (115*adaptx), (int) (29*adaptx));
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
