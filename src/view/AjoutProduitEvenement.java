package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class AjoutProduitEvenement extends JFrame {

	private JPanel contentPane;
	private JTextField champNom;
	private JTextField champQuantite;
	private JTextField champPrix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutProduitEvenement frame = new AjoutProduitEvenement();
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
	public AjoutProduitEvenement() {
		setTitle("Ajout d'un nouveau produit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitre = new JLabel("Ajout d'un produit non propos\u00E9 n\u00E9cessaire \u00E0 l'\u00E9v\u00E8nement");
		labelTitre.setForeground(Color.WHITE);
		labelTitre.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelTitre.setBounds(15, 0, 498, 86);
		contentPane.add(labelTitre);
		
		JLabel labelNom = new JLabel("Nom du produit :");
		labelNom.setForeground(new Color(255, 255, 255));
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNom.setBounds(49, 112, 151, 25);
		contentPane.add(labelNom);
		
		champNom = new JTextField();
		champNom.setBounds(226, 111, 146, 26);
		contentPane.add(champNom);
		champNom.setColumns(10);
		
		JLabel labelQuantite = new JLabel("Quantit\u00E9 :");
		labelQuantite.setForeground(new Color(255, 255, 255));
		labelQuantite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelQuantite.setBounds(110, 154, 90, 25);
		contentPane.add(labelQuantite);
		
		champQuantite = new JTextField();
		champQuantite.setColumns(10);
		champQuantite.setBounds(226, 153, 146, 26);
		contentPane.add(champQuantite);
		
		JLabel labelPrix = new JLabel("Prix unitaire :");
		labelPrix.setForeground(Color.WHITE);
		labelPrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelPrix.setBounds(80, 196, 120, 20);
		contentPane.add(labelPrix);
		
		champPrix = new JTextField();
		champPrix.setColumns(10);
		champPrix.setBounds(226, 195, 146, 26);
		contentPane.add(champPrix);
		
		JLabel labelOptionnel = new JLabel("(optionnel)");
		labelOptionnel.setForeground(Color.WHITE);
		labelOptionnel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelOptionnel.setBounds(387, 196, 99, 25);
		contentPane.add(labelOptionnel);
		
		JLabel labelLieu = new JLabel("Lieu de stockage :");
		labelLieu.setForeground(Color.WHITE);
		labelLieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLieu.setBounds(37, 236, 163, 25);
		contentPane.add(labelLieu);
		
		JComboBox comboBoxLieu = new JComboBox();
		comboBoxLieu.setBounds(226, 237, 146, 26);
		contentPane.add(comboBoxLieu);
		
		JLabel label = new JLabel("(optionnel)");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(387, 237, 99, 25);
		contentPane.add(label);
		
		JButton boutonAjouter = new JButton("Ajouter");
		boutonAjouter.setBounds(387, 286, 115, 29);
		contentPane.add(boutonAjouter);
	}
}
