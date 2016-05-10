package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Parametrage extends JFrame {

	private JPanel panelFenParam;
	private JTextField champCle;
	private JTextField champValeur;
	private JButton boutonParametrer;

	
	public Parametrage() {
		setTitle("Param\u00E8trage d'une cl\u00E9");
		setLocationRelativeTo(null);
		setVisible(true);
		setBounds(100, 100, 550, 290);
		panelFenParam = new JPanel();
		panelFenParam.setBackground(new Color(51, 102, 204));
		panelFenParam.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelFenParam);
		panelFenParam.setLayout(null);
		
		JLabel labelParametrage = new JLabel("Param\u00E8trage");
		labelParametrage.setForeground(new Color(255, 255, 255));
		labelParametrage.setFont(new Font("Tahoma", Font.BOLD, 27));
		labelParametrage.setBounds(180, 16, 176, 34);
		panelFenParam.add(labelParametrage);
		
		JLabel labelCle = new JLabel("Cl\u00E9 :");
		labelCle.setForeground(new Color(255, 255, 255));
		labelCle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCle.setBounds(70, 91, 41, 20);
		panelFenParam.add(labelCle);
		
		champCle = new JTextField();
		champCle.setBounds(126, 90, 367, 26);
		panelFenParam.add(champCle);
		champCle.setColumns(10);
		
		JLabel labelValeur = new JLabel("Valeur :");
		labelValeur.setForeground(new Color(255, 255, 255));
		labelValeur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelValeur.setBounds(41, 128, 70, 20);
		panelFenParam.add(labelValeur);
		
		champValeur = new JTextField();
		champValeur.setColumns(10);
		champValeur.setBounds(126, 127, 367, 26);
		panelFenParam.add(champValeur);
		
		boutonParametrer = new JButton("Param\u00E8trer");
		boutonParametrer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boutonParametrer.setBounds(363, 189, 150, 29);
		panelFenParam.add(boutonParametrer);
	}
	
	public void fermerFenetre(){
		dispose();
	}

	public JPanel getPanelFenParam() {
		return panelFenParam;
	}

	public void setPanelFenParam(JPanel panelFenParam) {
		this.panelFenParam = panelFenParam;
	}

	public JTextField getChampCle() {
		return champCle;
	}

	public void setChampCle(JTextField champCle) {
		this.champCle = champCle;
	}

	public JTextField getChampValeur() {
		return champValeur;
	}

	public void setChampValeur(JTextField champValeur) {
		this.champValeur = champValeur;
	}

	public JButton getBoutonParametrer() {
		return boutonParametrer;
	}

	public void setBoutonParametrer(JButton boutonParametrer) {
		this.boutonParametrer = boutonParametrer;
	}


	
	
}
