package entitie;

public class Budget {
	
	int idBudget;
	String ref;
	String nomBudget;
	double montantPrevu;
	double montantUtilise;
	User createur;
	
	public Budget(int idBudget, String ref,String nomBudget, double montantPrevu, double montantUtilise, User createur) {
		super();
		this.idBudget = idBudget;
		this.ref=ref;
		this.nomBudget = nomBudget;
		this.montantPrevu = montantPrevu;
		this.montantUtilise = montantUtilise;
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

	public int getIdBudget() {
		return idBudget;
	}

	public void setIdBudget(int idBudget) {
		this.idBudget = idBudget;
	}

	public String getNomBudget() {
		return nomBudget;
	}

	public void setNomBudget(String nomBudget) {
		this.nomBudget = nomBudget;
	}

	public double getMontantPrevu() {
		return montantPrevu;
	}

	public void setMontantPrevu(double montantPrevu) {
		this.montantPrevu = montantPrevu;
	}

	public double getMontantUtilise() {
		return montantUtilise;
	}

	public void setMontantUtilise(double montantUtilise) {
		this.montantUtilise = montantUtilise;
	}
	
	
	
}
