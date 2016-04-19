package entitie;

public class Fournisseur {
	
	int idFournisseur;
	String nomFournisseur;
	String adresse;

	
	
	public Fournisseur(int idFournisseur, String nomFournisseur, String adresse) {
		super();
		this.idFournisseur = idFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.adresse = adresse;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
