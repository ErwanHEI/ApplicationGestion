package entitie;

public class ModificationProduit {
	
	private Integer idModif;
	private String produit;
	private String modif;
	private String nomUtil;
	private String date;
	
	
	public ModificationProduit(Integer idModif,String produit, String modif,
			String nomUtil,String date) {
		
		this.idModif = idModif;
		this.produit = produit;
		this.nomUtil = nomUtil;
		this.date=date;
		this.modif=modif;
	}


	public Integer getIdModif() {
		return idModif;
	}


	public void setIdModif(Integer idModif) {
		this.idModif = idModif;
	}


	public String getProduit() {
		return produit;
	}


	public void setProduit(String produit) {
		this.produit = produit;
	}


	public String getNomUtil() {
		return nomUtil;
	}


	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getModif() {
		return modif;
	}


	public void setModif(String modif) {
		this.modif = modif;
	}

	
	


	
	
	
	
	
	
	

}
