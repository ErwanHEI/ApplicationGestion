package modelFiltres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import entitie.ModificationProduit;
import entitie.Produit;
import manager.ProduitManager;
import modelTableau.ModeleTableauJournalProduit;

public class FiltreJournalProduit implements ActionListener{
	private String filtreJournalProduitSelect;
	private ModeleTableauJournalProduit modeleTableauJournalProduit = new ModeleTableauJournalProduit();
	private ProduitManager produitManager = new ProduitManager();
    private List<ModificationProduit> listeModifProduit = new ArrayList<ModificationProduit>();
    
	public JComboBox FiltreProduit(ModeleTableauJournalProduit modeleTableauJournalProduit){
		this.modeleTableauJournalProduit = modeleTableauJournalProduit;
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Quantité : Ordre croissant");
		comboBox.addItem("Quantité : Ordre décroissant");
        comboBox.addActionListener(this);
		return comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
		filtreJournalProduitSelect =  (String) comboBox.getSelectedItem();
		System.out.println(filtreJournalProduitSelect);
		if(filtreJournalProduitSelect != ""){
			modeleTableauJournalProduit.clear();
			listeModifProduit = produitManager.listerModifFiltre(filtreJournalProduitSelect);
			modeleTableauJournalProduit.setListeModifProduit(listeModifProduit);
		}
	}

}
