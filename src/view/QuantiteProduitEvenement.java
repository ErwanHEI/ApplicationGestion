package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelTableau.ModeleTableauListeProduit;
import modelTableau.ModeleTableauQuantiteProduit;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;

public class QuantiteProduitEvenement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private ModeleTableauQuantiteProduit modeleListeProduit = new ModeleTableauQuantiteProduit();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuantiteProduitEvenement frame = new QuantiteProduitEvenement();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuantiteProduitEvenement() {
		setTitle("Saisie des quantités");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		scrollPane.setBounds(0, 83, 618, 351);
		panelSaisie.add(scrollPane);
		
		table = new JTable(modeleListeProduit);
		scrollPane.setViewportView(table);
	}
}
