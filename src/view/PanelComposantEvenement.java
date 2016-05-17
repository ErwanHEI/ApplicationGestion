package view;

import javax.swing.JPanel;

import entitie.Evenement;
import entitie.Produit;
import manager.EvenementManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class PanelComposantEvenement extends JPanel{

	private EvenementManager evenementManager = new EvenementManager();
    private List<Evenement> listeEvenement = new ArrayList<Evenement>();
    private JPanel panelScroll = null;
    private JPanel panelComposantEvenement;
	private String nomEvenement;
    
	public PanelComposantEvenement() {
		setLayout(null);
		
		listeEvenement = evenementManager.listerEvent();
		panelScroll = new JPanel();
		
		
		for(int i=0; i<listeEvenement.size(); i++){
			
			panelComposantEvenement = new JPanel();
			//nomEvenement = listeEvenement.get(i).getNomEvenement();
			JLabel labelEvenement = new JLabel("nomEvenement");
			labelEvenement.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelEvenement.setBounds(15, 16, 147, 25);
			panelComposantEvenement.add(labelEvenement);
			
			panelScroll.add(panelComposantEvenement);
		}
	}

	public JPanel getPanelScroll() {
		return panelScroll;
	}

	public void setPanelScroll(JPanel panelScroll) {
		this.panelScroll = panelScroll;
	}
	
	
}
