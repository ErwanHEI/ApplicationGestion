package entitie;

public class Produit {
	int idProduit;
	String nomProduit;
	String categorie;
	int quantite;
	double prixU;
	Fournisseur fournisseur;
	Stockage stockage;
	User createur;
	
	public Produit(int idProduit, String nomProduit, String categorie,double prixU, int quantite, Stockage stockage,Fournisseur fournisseur, User createur) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.categorie = categorie;
		this.quantite = quantite;
		this.fournisseur=fournisseur;
		this.stockage=stockage;
		this.createur=createur;
		this.prixU=prixU;
	}
	
	
	public User getCreateur() {
		return createur;
	}


	public void setCreateur(User createur) {
		this.createur = createur;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public Stockage getStockage() {
		return stockage;
	}


	public void setStockage(Stockage stockage) {
		this.stockage = stockage;
	}


	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getPrixU() {
		return prixU;
	}


	public void setPrixU(int prixU) {
		this.prixU = prixU;
	}
	
	
	

}
