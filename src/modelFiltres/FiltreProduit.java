package modelFiltres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import entitie.Produit;
import manager.ProduitManager;
import modelTableau.ModeleTableauListeProduit;

public class FiltreProduit implements ActionListener{
	private String filtreProduitSelect;
	private ModeleTableauListeProduit modeleTableauListeProduit = new ModeleTableauListeProduit();
	private ProduitManager produitManager = new ProduitManager();
    private List<Produit> listeProduit = new ArrayList<Produit>();
    
	public JComboBox FiltreProduit(ModeleTableauListeProduit modeleTableauListeProduit){
		this.modeleTableauListeProduit = modeleTableauListeProduit;
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Cat�gorie : Ordre alphab�tique");
		comboBox.addItem("Cat�gorie : Ordre alphab�tique inverse");
		comboBox.addItem("Nom : Ordre alphab�tique");
		comboBox.addItem("Nom : Ordre alphab�tique inverse");
		comboBox.addItem("Prix : Ordre croissant");
		comboBox.addItem("Prix : Ordre d�croissant");
		comboBox.addItem("Quantit� : Ordre croissant");
		comboBox.addItem("Quantit� : Ordre d�croissant");
		comboBox.addItem("Lieu de stockage : Ordre alphab�tique");
		comboBox.addItem("Lieu de stockage : Ordre alphab�tique inverse");
        comboBox.addActionListener(this);
		return comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
		filtreProduitSelect =  (String) comboBox.getSelectedItem();
		System.out.println(filtreProduitSelect);
		if(filtreProduitSelect != ""){
			modeleTableauListeProduit.clear();
			listeProduit = produitManager.listerProduitsFiltre(filtreProduitSelect);
			modeleTableauListeProduit.setListeProduit(listeProduit);
		}
	}

	public String getFiltreProduitSelect() {
		return filtreProduitSelect;
	}

	public void setFiltreProduitSelect(String filtreProduitSelect) {
		this.filtreProduitSelect = filtreProduitSelect;
	}

	public ModeleTableauListeProduit getModeleTableauListeProduit() {
		return modeleTableauListeProduit;
	}

	public void setModeleTableauListeProduit(ModeleTableauListeProduit modeleTableauListeProduit) {
		this.modeleTableauListeProduit = modeleTableauListeProduit;
	}

	public ProduitManager getProduitManager() {
		return produitManager;
	}

	public void setProduitManager(ProduitManager produitManager) {
		this.produitManager = produitManager;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	
}
