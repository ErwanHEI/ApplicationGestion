package daoImplTestCase;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.StockageDao;
import daoImpl.DataBase;
import daoImpl.StockageDaoImpl;
import entitie.Fournisseur;
import entitie.Stockage;

public class StockageDaoImplTestCase {
	private StockageDao stockageDao=new StockageDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM stockage");
		stmt.executeUpdate("INSERT INTO `stockage`(`nomStockage`,`localisation`,`remplissage`) VALUES('Armoire rose','Local 1','15')");
		stmt.executeUpdate("INSERT INTO `stockage`(`nomStockage`,`localisation`,`remplissage`) VALUES('Armoire verte','Local 3','35')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testAjoutLieuStockage() {
		Stockage stockage=new Stockage(0, "Local 4", "Armoire noire", 0);
		stockageDao.ajoutStockage(stockage);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM stockage WHERE nomstockage='Armoire noire'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idStockage"));
			Assert.assertEquals("Armoire noire", results.getString("nomStockage"));
			Assert.assertEquals("Local 4", results.getString("localisation"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Test
		public void testerListerStockage() {
			List<Stockage> stockages = stockageDao.listerStockage();
			Assert.assertEquals(2, stockages.size());
			Assert.assertEquals("Armoire rose", stockages.get(0).getNomStockage());
			Assert.assertEquals("Local 1",stockages.get(0).getLocalisation());
			
		
	}
		
		@Test
		public void testSupprimerStockage(){
			stockageDao.suppressionStockage(1);
			DataBase bdd=new DataBase("gestionstock.sqlite");
			bdd.connect();
			try {
				Statement stmt = bdd.getConnection().createStatement();
				ResultSet results = stmt.executeQuery("SELECT * FROM stockage WHERE idStockage='1'");
				Assert.assertFalse(results.next());
				stmt.close();
				bdd.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
