package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controler.AuthentificationControler;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Authentification {

	private JFrame frmOutilGestionDes;
	private JTextField champMail;
	private JPasswordField passwordField;
	private JButton boutonMotDePasseOublie;
	private JButton boutonSeConnecter;
	


	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOutilGestionDes = new JFrame();
		
		JLabel labelAuthentification = new JLabel("Authentification");
		labelAuthentification.setForeground(Color.WHITE);
		labelAuthentification.setFont(new Font("Tahoma", Font.PLAIN, 50));
		labelAuthentification.setBounds(337, 38, 350, 91);
		frmOutilGestionDes.getContentPane().add(labelAuthentification);
		
		JLabel labelMail = new JLabel("Adresse mail : ");
		labelMail.setForeground(Color.WHITE);
		labelMail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelMail.setBounds(169, 234, 261, 24);
		frmOutilGestionDes.getContentPane().add(labelMail);
		
		champMail = new JTextField();
		champMail.setColumns(10);
		champMail.setBounds(530, 237, 400, 26);
		frmOutilGestionDes.getContentPane().add(champMail);
		
		JLabel labelMotDePasse = new JLabel("Taper le mot de passe :");
		labelMotDePasse.setForeground(Color.WHITE);
		labelMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelMotDePasse.setBounds(169, 294, 328, 31);
		frmOutilGestionDes.getContentPane().add(labelMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(530, 299, 400, 26);
		frmOutilGestionDes.getContentPane().add(passwordField);
		
		boutonMotDePasseOublie = new JButton("Mot de passe oubli\u00E9 ?");
		boutonMotDePasseOublie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boutonMotDePasseOublie.setBounds(530, 357, 169, 20);
		frmOutilGestionDes.getContentPane().add(boutonMotDePasseOublie);
		
		boutonSeConnecter = new JButton("Se connecter");
		boutonSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 26));
		boutonSeConnecter.setBounds(745, 461, 185, 41);
		boutonSeConnecter.addActionListener(new AuthentificationControler(this));
		frmOutilGestionDes.getContentPane().add(boutonSeConnecter);
		
		
		frmOutilGestionDes.setBounds(100, 100, 1024, 768);
		frmOutilGestionDes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void execute(){
		frmOutilGestionDes.setTitle("Outil gestion des stocks et des budgets - ESTACA - Authentification");
		frmOutilGestionDes.getContentPane().setBackground(new Color(51, 102, 204));
		frmOutilGestionDes.getContentPane().setLayout(null);
		frmOutilGestionDes.setBounds(100, 100, 950,600);
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

	public JTextField getChampMail() {
		return champMail;
	}

	public void setChampMail(JTextField champMail) {
		this.champMail = champMail;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBoutonMotDePasseOublie() {
		return boutonMotDePasseOublie;
	}

	public void setBoutonMotDePasseOublie(JButton boutonMotDePasseOublie) {
		this.boutonMotDePasseOublie = boutonMotDePasseOublie;
	}

	public JButton getBoutonSeConnecter() {
		return boutonSeConnecter;
	}

	public void setBoutonSeConnecter(JButton boutonSeConnecter) {
		this.boutonSeConnecter = boutonSeConnecter;
	}

	
	
	
}
