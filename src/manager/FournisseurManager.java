package manager;

import java.util.List;

import dao.FournisseurDao;
import daoImpl.FournisseurDaoImpl;
import entitie.Fournisseur;

public class FournisseurManager {
	
	private static FournisseurManager instance;
	private FournisseurDao fournisseurDao = new FournisseurDaoImpl();

	public static FournisseurManager getInstance() {

		if (instance == null) {
			instance = new FournisseurManager();
		}
		return instance;
	}
	
	public Fournisseur ajoutFournisseur(Fournisseur fournisseur){
		return fournisseurDao.ajoutFournisseur(fournisseur);
	}
	
	public List<Fournisseur> listerFournisseur(){
		return fournisseurDao.listerFournisseur();
	}

}
