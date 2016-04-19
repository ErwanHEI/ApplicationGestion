package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controler.CreationCompteControleur;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class CreationCompte {

	private JFrame frmOutilGestionDes;
	private JTextField champEntrerMailResponsable;
	private JTextField champErreurMailSaisie;
	private JComboBox comboBoxStatutCompte;

	
	public CreationCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOutilGestionDes = new JFrame();
		
		JLabel labelCreationNouveauCompte = new JLabel("Cr\u00E9ation d'un nouveau compte");
		labelCreationNouveauCompte.setForeground(Color.WHITE);
		labelCreationNouveauCompte.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelCreationNouveauCompte.setBounds(185, 50, 716, 91);
		frmOutilGestionDes.getContentPane().add(labelCreationNouveauCompte);
		
		JLabel labelQuelStatut = new JLabel("Quel est le statut de ce compte ?");
		labelQuelStatut.setForeground(Color.WHITE);
		labelQuelStatut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelQuelStatut.setBounds(158, 223, 307, 24);
		frmOutilGestionDes.getContentPane().add(labelQuelStatut);
		
		String[] statut ={"Administrateur", "Responsable des Stocks", "Responsable des Budgets", "Consultant"};
		comboBoxStatutCompte = new JComboBox(statut);
		comboBoxStatutCompte.setBounds(240, 263, 400, 26);
		frmOutilGestionDes.getContentPane().add(comboBoxStatutCompte);
		
		JLabel labelEntrerMailResponsable = new JLabel("Entrer l'adresse mail du responsable qui utilisera ce compte :");
		labelEntrerMailResponsable.setForeground(Color.WHITE);
		labelEntrerMailResponsable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelEntrerMailResponsable.setBounds(158, 305, 626, 24);
		frmOutilGestionDes.getContentPane().add(labelEntrerMailResponsable);
		
		champEntrerMailResponsable = new JTextField();
		champEntrerMailResponsable.setColumns(10);
		champEntrerMailResponsable.setBounds(240, 345, 400, 26);
		frmOutilGestionDes.getContentPane().add(champEntrerMailResponsable);
				
		JLabel labelInformation = new JLabel("La cr\u00E9ation d'un compte entra\u00EEne l'envoie d'un mot de passe via l'adresse mail entr\u00E9e.");
		labelInformation.setForeground(Color.WHITE);
		labelInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelInformation.setBounds(158, 419, 781, 24);
		frmOutilGestionDes.getContentPane().add(labelInformation);
		
		JButton boutonCreerCompte = new JButton("Cr\u00E9er le compte");
		boutonCreerCompte.setFont(new Font("Tahoma", Font.PLAIN, 25));
		boutonCreerCompte.setBounds(240, 459, 214, 39);
		boutonCreerCompte.addActionListener(new CreationCompteControleur(this));
		frmOutilGestionDes.getContentPane().add(boutonCreerCompte);
		
		
	}
	
	public void execute(){
		frmOutilGestionDes.getContentPane().setBackground(new Color(51, 102, 204));
		frmOutilGestionDes.setTitle("Outil gestion des stocks et des budgets - ESTACA - Cr\u00E9ation d'un nouveau compte");
		frmOutilGestionDes.setBounds(100, 100, 1024, 768);
		frmOutilGestionDes.getContentPane().setLayout(null);
		frmOutilGestionDes.setResizable(false);
		frmOutilGestionDes.setVisible(true);
	}

	public JFrame getFrmOutilGestionDes() {
		return frmOutilGestionDes;
	}

	public void setFrmOutilGestionDes(JFrame frmOutilGestionDes) {
		this.frmOutilGestionDes = frmOutilGestionDes;
	}

	public JTextField getChampEntrerMailResponsable() {
		return champEntrerMailResponsable;
	}

	public void setChampEntrerMailResponsable(JTextField champEntrerMailResponsable) {
		this.champEntrerMailResponsable = champEntrerMailResponsable;
	}

	public JTextField getChampErreurMailSaisie() {
		return champErreurMailSaisie;
	}

	public void setChampErreurMailSaisie(JTextField champErreurMailSaisie) {
		this.champErreurMailSaisie = champErreurMailSaisie;
	}

	public JComboBox getComboBoxStatutCompte() {
		return comboBoxStatutCompte;
	}

	public void setComboBoxStatutCompte(JComboBox comboBoxStatutCompte) {
		this.comboBoxStatutCompte = comboBoxStatutCompte;
	}
	
	
	

}
