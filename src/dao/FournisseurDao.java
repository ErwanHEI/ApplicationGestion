package dao;

import java.util.List;

import entitie.Fournisseur;

public interface FournisseurDao {
	
	public Fournisseur ajoutFournisseur(Fournisseur fournisseur);
	public List<Fournisseur> listerFournisseur();

}
