package dao;

import java.util.List;

import entitie.Stockage;

public interface StockageDao {
	
	public Stockage ajoutStockage(Stockage stockage);
	public List<Stockage> listerStockage();
	public void suppressionStockage(Integer id);
	public void majCapacite(Integer capacite,Integer id);
}
