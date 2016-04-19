package manager;

import dao.LancementDao;
import daoImpl.LancementDaoImpl;

public class LancementManager {
	
	private static LancementManager instance;
	private LancementDao lancementDao = new LancementDaoImpl();

	public static LancementManager getInstance() {

		if (instance == null) {
			instance = new LancementManager();
		}
		return instance;
	}
	
	public int testLancement(){
		return lancementDao.lancement();
	}
	
	public void updateCompteur(){
		lancementDao.updateCompteur();
	}

}
