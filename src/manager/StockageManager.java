package manager;


import java.util.List;

import dao.StockageDao;
import daoImpl.StockageDaoImpl;
import entitie.Stockage;

public class StockageManager {
	
	private static StockageManager instance;
	private StockageDao stockageDao = new StockageDaoImpl();

	public static StockageManager getInstance() {

		if (instance == null) {
			instance = new StockageManager();
		}
		return instance;
	}
	
	public Stockage ajoutStockage(Stockage stockage){
		return stockageDao.ajoutStockage(stockage);
	}
	
	public List<Stockage> listerStockage(){
		return stockageDao.listerStockage();
	}
	public void suppressionStockage(Integer id){
		stockageDao.suppressionStockage(id);
	}
	public void majModifierCapacite(Integer capacite, Integer idStockage){
		stockageDao.majCapacite(capacite, idStockage);
	}
}
