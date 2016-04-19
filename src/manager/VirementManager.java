package manager;


import java.util.List;

import dao.VirementDao;
import daoImpl.VirementDaoImpl;
import entitie.Virement;

public class VirementManager {
	
	private static VirementManager instance;
	private VirementDao virementDao = new VirementDaoImpl();

	public static VirementManager getInstance() {

		if (instance == null) {
			instance = new VirementManager();
		}
		return instance;
	}
	
	public Virement ajoutVirement(Virement virement){
		return virementDao.ajoutVirement(virement);
	}
	
	public List<Virement> virementNonEncaisse(){
		return virementDao.listerVirementNonEncaisse();
	}
	
	public List<Virement> journalVirement(){
		return virementDao.journalVirement();
	}
	
	public void passerEncaissement(Integer id){
		virementDao.passerEncaissement(id);
	}
	
	public void suppressionVirement(Integer id){
		virementDao.suppressionVirement(id);;
	}
	
	public List<Virement> listerParEvent(Integer idE){
		return virementDao.listerParEvent(idE);
	}
}
