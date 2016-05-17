package controler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import entitie.Produit;
import manager.ProduitManager;
import modelTableau.ModeleTableauListeProduit;
import view.Fenetre;
import view.PanelProduit;

public class ControleurRecherchePdt implements ActionListener{
	
	private Fenetre fenetre;
	private PanelProduit pan;
	private ModeleTableauListeProduit tab=new ModeleTableauListeProduit();;
	
		
		public ControleurRecherchePdt(Fenetre fenetre,PanelProduit pan)
		{
			this.fenetre=fenetre;
			this.pan=pan;
			this.tab=pan.getModeleListeProduit();
		}
	
		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("sgfsrf");
			
			List<Produit> pdtsRecherche=ProduitManager.getInstance().recherchePdt(pan.getChampRecherche().getText());
			tab.clear();
			tab.setListeProduit(pdtsRecherche);
		}

}
