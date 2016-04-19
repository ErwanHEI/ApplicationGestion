package entitie;


import java.util.List;

public class Evenement {
	
	int idEvenement;
	String nomEvenement;
	String dateEvent;
	User createur;
	List<Produit> listePdts;
	
	
	
	public Evenement(int idEvenement, String nomEvenement, String dateEvent, User createur, List<Produit> listePdts) {
		super();
		this.idEvenement = idEvenement;
		this.nomEvenement = nomEvenement;
		this.dateEvent = dateEvent;
		this.createur = createur;
		this.listePdts = listePdts;
	}


	public int getIdEvenement() {
		return idEvenement;
	}


	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}


	public String getNomEvenement() {
		return nomEvenement;
	}


	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}


	public String getDateEvent() {
		return dateEvent;
	}


	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}


	public User getCreateur() {
		return createur;
	}


	public void setCreateur(User createur) {
		this.createur = createur;
	}


	public List<Produit> getListePdts() {
		return listePdts;
	}


	public void setListePdts(List<Produit> listePdts) {
		this.listePdts = listePdts;
	}

}
