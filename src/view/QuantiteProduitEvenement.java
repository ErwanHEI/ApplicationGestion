package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entitie.Evenement;
import modelTableau.ModeleTableauListeProduit;
import modelTableau.ModeleTableauQuantiteProduit;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JButton;

public class QuantiteProduitEvenement extends JFrame {

	private JPanel contentPane;
	private JTable tableauQuantiteProduit;
	private JButton boutonValider;
	private List<Integer> listeIdProduit;
	private ModeleTableauQuantiteProduit modeleListeProduit;
	private PanelEvenement panelEvenement;


	public QuantiteProduitEvenement(PanelEvenement panelEvenement, List<Integer> listeIdProduit) {
		this.panelEvenement = panelEvenement;
		this.listeIdProduit = listeIdProduit;
		
		modeleListeProduit = new ModeleTableauQuantiteProduit(listeIdProduit);
		setTitle("Saisie des quantités");
		setVisible(true);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSaisie = new JPanel();
		panelSaisie.setBackground(new Color(51, 102, 204));
		contentPane.add(panelSaisie, BorderLayout.CENTER);
		panelSaisie.setLayout(null);
		
		JLabel labelSaisieDesQuantites = new JLabel("Saisie des quantit\u00E9s n\u00E9cessaires \u00E0 l'\u00E9v\u00E8nement");
		labelSaisieDesQuantites.setBounds(33, 26, 555, 29);
		labelSaisieDesQuantites.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelSaisieDesQuantites.setForeground(new Color(255, 255, 255));
		panelSaisie.add(labelSaisieDesQuantites);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(30);
		scrollPane.setBounds(0, 83, 618, 290);
		panelSaisie.add(scrollPane);
		
		tableauQuantiteProduit = new JTable(modeleListeProduit);
		scrollPane.setViewportView(tableauQuantiteProduit);
		
		boutonValider = new JButton("Valider");
		boutonValider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boutonValider.setBounds(256, 389, 134, 29);
		panelSaisie.add(boutonValider);
	}
	
	public void fermerFenetre(){
		dispose();
	}

	public JTable getTableauQuantiteProduit() {
		return tableauQuantiteProduit;
	}


	public void setTableauQuantiteProduit(JTable tableauQuantiteProduit) {
		this.tableauQuantiteProduit = tableauQuantiteProduit;
	}


	public ModeleTableauQuantiteProduit getModeleListeProduit() {
		return modeleListeProduit;
	}


	public void setModeleListeProduit(ModeleTableauQuantiteProduit modeleListeProduit) {
		this.modeleListeProduit = modeleListeProduit;
	}


	public JButton getBoutonValider() {
		return boutonValider;
	}


	public void setBoutonValider(JButton boutonValider) {
		this.boutonValider = boutonValider;
	}


	public PanelEvenement getPanelEvenement() {
		return panelEvenement;
	}


	public void setPanelEvenement(PanelEvenement panelEvenement) {
		this.panelEvenement = panelEvenement;
	}
	
	
	
	
	
}
