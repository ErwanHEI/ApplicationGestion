package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private double x1 = 1024;
	private double y1 = 768;
	private double adaptx = x/x1;
	private double adapty = y/y1;

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
		labelAuthentification.setFont(new Font("Tahoma", Font.PLAIN, (int) (50*adaptx)));
		labelAuthentification.setBounds((int) (337*adaptx), (int) (38*adapty), (int) (350*adaptx), (int) (91*adaptx));
		frmOutilGestionDes.getContentPane().add(labelAuthentification);
		
		JLabel labelMail = new JLabel("Adresse mail : ");
		labelMail.setForeground(Color.WHITE);
		labelMail.setFont(new Font("Tahoma", Font.PLAIN, (int) (25*adaptx)));
		labelMail.setBounds((int) (169*adaptx), (int) (234*adapty), (int) (261*adaptx), (int) (26*adaptx));
		frmOutilGestionDes.getContentPane().add(labelMail);
		
		champMail = new JTextField("prenom.nom@estaca.eu");
		champMail.setFont(new Font("Tahoma", Font.PLAIN, (int)(12*adaptx)));
		champMail.setForeground(Color.gray);
		champMail.setColumns(10);
		champMail.setBounds((int)(530*adaptx), (int)(237*adapty), (int)(400*adaptx), (int)(26*adapty));
		champMail.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	//Empêche de sélectionner le texte grissé et positonne le curseur au début
		    	if(champMail.getSelectedText().isEmpty()==false && champMail.getText().equals("prenom.nom@estaca.eu")){
		    		champMail.setCaretPosition(0);
		    	}
		    }         
		    @Override
		    public void mousePressed(MouseEvent e) {}          
		    @Override
		    public void mouseExited(MouseEvent e) {}           
		    @Override
		    public void mouseEntered(MouseEvent e) {}          
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	//Positionne le curseur au début si l'utilisateur n'a rien tappé
		    	if(champMail.getText().equals("prenom.nom@estaca.eu")){
		    	champMail.setCaretPosition(0);
		    	}		        	
		    }
		});
		champMail.addKeyListener(new KeyAdapter(){
			public void keyPressed(java.awt.event.KeyEvent e) {   
				//JTextField.getText() contient le texte présent dans le JTextField avant le relachement de la touche
				if(champMail.getText().equals("prenom.nom@estaca.eu") && e.getKeyChar()!=e.VK_BACK_SPACE){
					champMail.setText("");
	            	champMail.getFont().deriveFont(Font.PLAIN);
	            	champMail.setForeground(Color.black);
				}
			}
			public void keyReleased(java.awt.event.KeyEvent e) {
				//JTextField.getText() contient le texte présent dans le JTextField après le relachement de la touche
				if(champMail.getText().equals("")){
					champMail.setText("prenom.nom@estaca.eu");
	            	champMail.setForeground(Color.gray);
	            	champMail.setCaretPosition(0);
				}	
			}
		});
		frmOutilGestionDes.getContentPane().add(champMail);
		
		JLabel labelMotDePasse = new JLabel("Taper le mot de passe :");
		labelMotDePasse.setForeground(Color.WHITE);
		labelMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, (int) (25*adaptx)));
		labelMotDePasse.setBounds((int) (169*adaptx), (int) (294*adapty), (int) (328*adaptx), (int) (31*adaptx));
		frmOutilGestionDes.getContentPane().add(labelMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.black);
		passwordField.setBounds((int)(530*adaptx), (int)(299*adapty), (int)(400*adaptx), (int)(26*adapty));
		frmOutilGestionDes.getContentPane().add(passwordField);
		
		boutonMotDePasseOublie = new JButton("Mot de passe oubli\u00E9 ?");
		boutonMotDePasseOublie.setFont(new Font("Tahoma", Font.PLAIN, (int) (14*adaptx)));
		boutonMotDePasseOublie.setBounds((int) (530*adaptx), (int) (357*adapty), (int) (169*adaptx), (int) (20*adaptx));
		frmOutilGestionDes.getContentPane().add(boutonMotDePasseOublie);
		
		boutonSeConnecter = new JButton("Se connecter");
		boutonSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, (int) (26*adaptx)));
		boutonSeConnecter.setBounds((int) (745*adaptx), (int) (461*adapty), (int) (185*adaptx), (int) (41*adaptx));
		boutonSeConnecter.addActionListener(new AuthentificationControler(this));
		frmOutilGestionDes.getContentPane().add(boutonSeConnecter);
		
		
		frmOutilGestionDes.setBounds(0, 0, x, y);
		frmOutilGestionDes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void execute(){
		frmOutilGestionDes.setTitle("Outil gestion des stocks et des budgets - ESTACA - Authentification");
		frmOutilGestionDes.getContentPane().setBackground(new Color(51, 102, 204));
		frmOutilGestionDes.getContentPane().setLayout(null);
		frmOutilGestionDes.setBounds(0, 0, x, y);
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
