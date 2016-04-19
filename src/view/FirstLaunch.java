package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;

public class FirstLaunch {

	private JFrame frmOutilGestionDes;
	private JTextField champAdresseMail;
	private JPasswordField champChoixMotDePasse;
	private JPasswordField champConfirmationMotDePasse;
	JButton boutonCreerCompteAdministrateur ;
	

	
	public FirstLaunch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOutilGestionDes = new JFrame();
		frmOutilGestionDes.setTitle("Outil gestion des stocks et des budgets - ESTACA - 1er D\u00E9marrage");
		frmOutilGestionDes.getContentPane().setBackground(new Color(51, 102, 204));
		frmOutilGestionDes.setBounds(100, 100, 1024, 768);
		frmOutilGestionDes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOutilGestionDes.getContentPane().setLayout(null);
		
		JLabel labelPremierDemarrage = new JLabel("1er D\u00E9marrage");
		labelPremierDemarrage.setForeground(new Color(255, 255, 255));
		labelPremierDemarrage.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelPremierDemarrage.setBounds(343, 49, 350, 91);
		frmOutilGestionDes.getContentPane().add(labelPremierDemarrage);
		
		JLabel labelCreationCompteAdministrateur = new JLabel("Cr\u00E9ation du compte Administrateur");
		labelCreationCompteAdministrateur.setForeground(new Color(255, 255, 255));
		labelCreationCompteAdministrateur.setFont(new Font("Tahoma", Font.PLAIN, 33));
		labelCreationCompteAdministrateur.setBounds(72, 187, 515, 74);
		frmOutilGestionDes.getContentPane().add(labelCreationCompteAdministrateur);
		
		JLabel labelAdresseMail = new JLabel("Adresse mail ESTACA de l'administrateur : ");
		labelAdresseMail.setForeground(new Color(255, 255, 255));
		labelAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAdresseMail.setBounds(72, 332, 406, 24);
		frmOutilGestionDes.getContentPane().add(labelAdresseMail);
		
		champAdresseMail = new JTextField();
		champAdresseMail.setBounds(493, 333, 400, 26);
		frmOutilGestionDes.getContentPane().add(champAdresseMail);
		champAdresseMail.setColumns(10);
		
		JLabel labelChoixMotDePasse = new JLabel("Choisissez un mot de passe :");
		labelChoixMotDePasse.setForeground(new Color(255, 255, 255));
		labelChoixMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelChoixMotDePasse.setBounds(190, 385, 288, 20);
		frmOutilGestionDes.getContentPane().add(labelChoixMotDePasse);
		
		champChoixMotDePasse = new JPasswordField();
		champChoixMotDePasse.setBounds(493, 384, 400, 26);
		frmOutilGestionDes.getContentPane().add(champChoixMotDePasse);
		
		JLabel labelConfirmationMotDePasse = new JLabel("Confirmation du mot de passe :");
		labelConfirmationMotDePasse.setForeground(new Color(255, 255, 255));
		labelConfirmationMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelConfirmationMotDePasse.setBounds(168, 435, 310, 20);
		frmOutilGestionDes.getContentPane().add(labelConfirmationMotDePasse);
		
		boutonCreerCompteAdministrateur = new JButton("Cr\u00E9er le compte administrateur");
		boutonCreerCompteAdministrateur.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		
		champConfirmationMotDePasse = new JPasswordField();
		champConfirmationMotDePasse.setBounds(493, 434, 400, 26);
		frmOutilGestionDes.getContentPane().add(champConfirmationMotDePasse);
		boutonCreerCompteAdministrateur.setBounds(593, 522, 300, 40);
		frmOutilGestionDes.getContentPane().add(boutonCreerCompteAdministrateur);
		
		
	}
	
	public void execute(){
		frmOutilGestionDes.setTitle("Outil gestion des stocks et des budgets - ESTACA - 1er démarrage");
		frmOutilGestionDes.getContentPane().setBackground(new Color(51, 102, 204));
		frmOutilGestionDes.getContentPane().setLayout(null);
		frmOutilGestionDes.setResizable(false);
		frmOutilGestionDes.setVisible(true);
	}
	
	public void fermerFentre(){
		frmOutilGestionDes.dispose();
	}

	public JFrame getFrmOutilGestionDes() {
		return frmOutilGestionDes;
	}

	public void setFrmOutilGestionDes(JFrame frmOutilGestionDes) {
		this.frmOutilGestionDes = frmOutilGestionDes;
	}

	public JTextField getChampAdresseMail() {
		return champAdresseMail;
	}

	public void setChampAdresseMail(JTextField champAdresseMail) {
		this.champAdresseMail = champAdresseMail;
	}

	public JPasswordField getChampChoixMotDePasse() {
		return champChoixMotDePasse;
	}

	public void setChampChoixMotDePasse(JPasswordField champChoixMotDePasse) {
		this.champChoixMotDePasse = champChoixMotDePasse;
	}

	public JPasswordField getChampConfirmationMotDePasse() {
		return champConfirmationMotDePasse;
	}

	public void setChampConfirmationMotDePasse(JPasswordField champConfirmationMotDePasse) {
		this.champConfirmationMotDePasse = champConfirmationMotDePasse;
	}

	public JButton getBoutonCreerCompteAdministrateur() {
		return boutonCreerCompteAdministrateur;
	}

	public void setBoutonCreerCompteAdministrateur(JButton boutonCreerCompteAdministrateur) {
		this.boutonCreerCompteAdministrateur = boutonCreerCompteAdministrateur;
	}

	
	
	
	
}
