package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import entitie.Produit;
import entitie.Stockage;
import entitie.User;
import manager.ProduitManager;
import util.PropertyLoader;
import util.SendMail;
import view.Fenetre;
import view.PanelProduit;

public class ControleurModificationProduit implements ActionListener{
	
	Fenetre fen;
	private boolean erreur;
	private String message;
	private PanelProduit pan;
	private String comment;
	
public ControleurModificationProduit(Fenetre fen, PanelProduit pan) {
		
		this.fen = fen;
		this.pan=pan;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Integer prix=null;
		String prixT=pan.getChampNouveauPrix().getText();
		Integer quantite=null;
		String quantiteT=pan.getChampNouvelleQuantite().getText();
		//recuperer id du nouveau lieu de stockage
		Stockage newStockage=pan.getComboxBoxDynamiqueStockage().getBudgetSelect();
		//recuperer l'id du produit selectionne
		Produit pdtModif=pan.getComboxBoxDynamiqueModifierProduit().getPdtSelec();
		User userConnecte=fen.getUserActuel();
		
		if(pan.getChampCommentaire().getText().equals("Votre commentaire sera afficher dans le journal")){
			comment="";
		}else{
			comment=pan.getChampCommentaire().getText();
		}
		
		if(fen.getUserActuel().getTypeUser()==2 ||fen.getUserActuel().getTypeUser()==1 ){
			if(!quantiteT.equals("Veuillez entrer une valeur entière")){
				quantite=Integer.parseInt(pan.getChampNouvelleQuantite().getText());
				ProduitManager.getInstance().majQuantite(quantite, pdtModif,userConnecte,comment);
				PropertyLoader property=new PropertyLoader();
				try {
					Properties prop=property.load("fichiers/proprietes");
					Integer lim=Integer.parseInt(prop.getProperty("Limitedestock"));
					String mailInformation=prop.getProperty("mailInfo");
					Integer newQuantite=ProduitManager.getInstance().newQuantite(pdtModif.getIdProduit());
					if(newQuantite<lim){
						SendMail mail=new SendMail();
						mail.start(mailInformation, "Attention un stock est jugé comme bas ! Il s'agit de  : "+pdtModif.getNomProduit()+" : "+newQuantite );
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/*if(!prixT.equals("Veuillez utiliser le point pour les centimes")){
				prix=Integer.parseInt(pan.getChampNouveauPrix().getText());
				ProduitManager.getInstance().majPrix(prix, pdtModif,userConnecte,comment);
			}*/
			
			if(newStockage.getNomStockage()!=null){
				ProduitManager.getInstance().majStockage(newStockage, pdtModif,userConnecte,comment);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Vous n'etes pas autorisé à effectuer cette action", "ERREUR", 0);
		}
		
		
		
		
	}

}
