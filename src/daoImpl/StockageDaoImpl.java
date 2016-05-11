package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.StockageDao;
import entitie.Stockage;
import entitie.User;
import entitie.Virement;

public class StockageDaoImpl implements StockageDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public Stockage ajoutStockage(Stockage stockage) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO `stockage`(`nomStockage`,`localisation`,`remplissage`) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, stockage.getNomStockage());
			stmt.setString(2,  stockage.getLocalisation());
			stmt.setInt(3, stockage.getRemplissage());
			
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idStockage = ids.getInt(1);
				stockage.setIdStockage(idStockage);
			}
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return stockage;
	}

	@Override
	public List<Stockage> listerStockage() {
		bdd.connect();
		List<Stockage> listeStockage = new ArrayList<Stockage>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM stockage";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idSto=res.getInt("idStockage");
				String nom=res.getString("nomStockage");
				String localisation=res.getString("localisation");
				Integer remplissage=res.getInt("remplissage");
				
				Stockage stockage=new Stockage(idSto, nom, localisation, remplissage);
				listeStockage.add(stockage);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeStockage;
		
	}
	
	
	@Override
	public void majCapacite(Integer capacite, Integer idStockage) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("UPDATE stockage SET remplissage=? WHERE idStockage=?");
			stmt.setInt(1, capacite);
			stmt.setInt(2, idStockage);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		bdd.close();
	}
	
	
	@Override
	public void suppressionStockage(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM stockage WHERE idStockage=?");
			stmt.setInt(1, id);
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		bdd.close();
	}

}
