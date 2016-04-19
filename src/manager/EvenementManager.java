package manager;

import java.util.List;

import dao.EvenementDao;
import daoImpl.EvenementDaoImpl;
import entitie.Evenement;

public class EvenementManager {
	
	private static EvenementManager instance;
	private EvenementDao eventDao = new EvenementDaoImpl();

	public static EvenementManager getInstance() {

		if (instance == null) {
			instance = new EvenementManager();
		}
		return instance;
	}
	
	public Evenement ajoutEvent(Evenement event){
		return eventDao.ajoutEvent(event);
	}
	
	public List<Evenement> listerEvent(){
		return eventDao.listerEvent();
	}
	
	public void supprimerEvent(Integer idEvent){
		eventDao.supprimerEvenement(idEvent);
	}

}
