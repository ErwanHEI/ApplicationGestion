package entitie;

public class Stockage {
	int idStockage;
	String localisation;
	String nomStockage;
	int remplissage;
	
	public Stockage(int idStockage, String localisation, String nomStockage, int remplissage) {
		super();
		this.idStockage = idStockage;
		this.localisation = localisation;
		this.nomStockage=nomStockage;
		this.remplissage=remplissage;
	}
	
	public String getNomStockage() {
		return nomStockage;
	}

	public void setNomStockage(String nomStockage) {
		this.nomStockage = nomStockage;
	}

	public int getRemplissage() {
		return remplissage;
	}

	public void setRemplissage(int remplissage) {
		this.remplissage = remplissage;
	}

	public int getIdStockage() {
		return idStockage;
	}
	public void setIdStockage(int idStockage) {
		this.idStockage = idStockage;
	}

	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
}
