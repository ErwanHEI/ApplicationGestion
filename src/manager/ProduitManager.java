package manager;

import java.util.List;

import dao.ProduitDao;
import daoImpl.ProduitDaoImpl;
import entitie.ModificationProduit;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;

public class ProduitManager {
	
	private static ProduitManager instance;
	private ProduitDao produitDao = new ProduitDaoImpl();

	public static ProduitManager getInstance() {

		if (instance == null) {
			instance = new ProduitManager();
		}
		return instance;
	}
	
	public Produit ajoutProduit(Produit produit){
		return produitDao.ajout(produit);
	}
	
	public List<Produit> listerProduits (){
		return produitDao.listerProduit();
	}
	
	public void majPrix(Integer prix, Produit produit, User user, String comment){
		produitDao.majPrix(prix, produit,user, comment);
	}
	
	public void majQuantite(Integer quantite,Produit produit, User user, String comment){
		produitDao.majQuantite(quantite, produit,user, comment);
	}
	
	public void majStockage(Stockage stockage,Produit produit, User user, String comment){
		produitDao.majStockage(stockage, produit,user, comment);
	}
	
	public List<ModificationProduit> listerModif(){
		return produitDao.listerModification();
	}
	
	public void suppressionProduit(Integer id){
		produitDao.suppressionProduit(id);
	}
	
	public void suppressionJournalProduit(Integer id){
		produitDao.suppressionJournalProduit(id);
	}
	
	public List<Produit> listerProduitsFiltre (String filtre){
		return produitDao.listerProduitFiltre(filtre);
	} 
	
	public List<ModificationProduit> listerModifFiltre(String filtre){
		return produitDao.listerModificationFiltre(filtre);
	}
	
	public List<Produit> listerProduitEvenement(List<Integer> listeIdProduit){
		return produitDao.listerProduitEvenement(listeIdProduit);
	}
	public Integer newQuantite(Integer id){
		return produitDao.recupNewQuantite(id);
	}
	
	public List<Produit> recherchePdt(String mot){
		return produitDao.recherche(mot);
	}
}
