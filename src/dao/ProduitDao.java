package dao;

import java.util.List;

import entitie.ModificationProduit;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;

public interface ProduitDao {
	public Produit ajout(Produit produit);
	public List<Produit> listerProduit();
	public void majPrix(Integer prix, Produit produit, User user);
	public void majQuantite(Integer quantite,Produit produit, User user);
	public void majStockage(Stockage stockage,Produit produit, User user);
	public List<ModificationProduit> listerModification();
	public void suppressionProduit(Integer id);
	public void suppressionJournalProduit(Integer id);
	public List<Produit> listerProduitFiltre(String filtre);
	public List<ModificationProduit> listerModificationFiltre(String filtre);
	public List<String> listerNomProduitEvenement(List<Integer> listeIdProduit);
}
