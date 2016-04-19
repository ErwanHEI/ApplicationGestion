package daoImplTestCase;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.VirementDao;
import daoImpl.DataBase;
import daoImpl.VirementDaoImpl;
import entitie.Budget;
import entitie.ModificationProduit;
import entitie.User;
import entitie.Virement;

public class VirementDaoImplTestCase {
	
	private VirementDao virementDao=new VirementDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM `virement`");
		stmt.executeUpdate("INSERT INTO `virement`(`idVirement`,`montant`,`emeteur`,`recepteur`,`dateVirement`,`idUser`,`idBudget`,`ref`,`encaisse`) VALUES('1','300','BDE', 'Auchan','07/03/2016','1','2','VI2','false')");
		stmt.executeUpdate("INSERT INTO `virement`(`idVirement`,`montant`,`emeteur`,`recepteur`,`dateVirement`,`idUser`,`idBudget`,`ref`,`encaisse`) VALUES('2','500','Cotisation', 'BDE','08/03/2016','1','1','VI45','true')");
		stmt.executeUpdate("DELETE FROM budget");
		stmt.executeUpdate("INSERT INTO `budget`(`idBudget`,`nomBudget`,`montantPrevu`,`montantUtilise`,`idUser`,`refB`) VALUES('1','Sport','500','0','1','24A8')");
		stmt.executeUpdate("INSERT INTO `budget`(`idBudget`,`nomBudget`,`montantPrevu`,`montantUtilise`,`idUser`,`refB`) VALUES('2','Soiree','400','5','1','25p8')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testAjoutVirement() {
		User user=new User();
		user.setIdUser(2);
		Budget budget=new Budget(2, null, null, 0, 0, user);
		Virement virement=new Virement(0, "VI58", 45.5, "BDE", "Salle", "05/03/2016", false, null, budget, user);
		virementDao.ajoutVirement(virement);
		
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM virement WHERE Ref='VI58'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idVirement"));
			Assert.assertEquals("BDE", results.getString("emeteur"));
			Assert.assertEquals(2, results.getInt("idBudget"));
			Assert.assertEquals(false, results.getBoolean("encaisse"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListerVirement(){
		List<Virement> virements =virementDao.journalVirement();
		Assert.assertEquals(2, virements.size());
		Assert.assertEquals("BDE",virements.get(0).getEmetteur());
		Assert.assertEquals("07/03/2016",virements.get(0).getDateVirement());
	}
	
	@Test
	public void testListeVirementNonEncaisse(){
		List<Virement> virementsNonEncaisse=virementDao.listerVirementNonEncaisse();
		Assert.assertEquals(1, virementsNonEncaisse.size());
		Assert.assertEquals("Auchan",virementsNonEncaisse.get(0).getRecepteur());
	}
	
	
	@Test
	public void testSupprimerVirement(){
		virementDao.suppressionVirement(1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM virement WHERE idVirement='1'");
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSupprimerJournalBudget(){
		virementDao.suppressionVirement(1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM virement WHERE idVirement='1'");
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
