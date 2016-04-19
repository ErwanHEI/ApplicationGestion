package entitie;

import java.util.Date;

public class Virement {
	
	int idVirement;
	String ref;
	double montant;
	String emetteur;
	String recepteur;
	String dateVirement;
	boolean encaisse;
	Evenement eventAssocie;
	User createur;
	Budget budgetAssocie;
	
	
	
	
	
	public Virement(int idVirement,String ref, double montant, String emetteur, String recepteur, String dateVirement,
			boolean encaisse,Evenement eventAssocie, Budget budgetAssocie,User createur) {
		super();
		this.idVirement = idVirement;
		this.ref=ref;
		this.montant = montant;
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.dateVirement = dateVirement;
		this.encaisse = encaisse;
		this.eventAssocie=eventAssocie;
		this.budgetAssocie=budgetAssocie;
		this.createur=createur;
	}
	
	
	
	
	public String getRef() {
		return ref;
	}




	public void setRef(String ref) {
		this.ref = ref;
	}




	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

	public Budget getBudgetAssocie() {
		return budgetAssocie;
	}

	public void setBudgetAssocie(Budget budgetAssocie) {
		this.budgetAssocie = budgetAssocie;
	}

	public int getIdVirement() {
		return idVirement;
	}
	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}
	public String getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}
	public String getDateVirement() {
		return dateVirement;
	}
	public void setDateVirement(String dateVirement) {
		this.dateVirement = dateVirement;
	}
	public boolean isEncaisse() {
		return encaisse;
	}
	public void setEncaisse(boolean encaisse) {
		this.encaisse = encaisse;
	}

	public Evenement getEventAssocie() {
		return eventAssocie;
	}


	public void setEventAssocie(Evenement eventAssocie) {
		this.eventAssocie = eventAssocie;
	}
	
	
}
