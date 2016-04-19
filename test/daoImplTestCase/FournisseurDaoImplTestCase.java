package daoImplTestCase;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.FournisseurDao;
import daoImpl.DataBase;
import daoImpl.FournisseurDaoImpl;
import entitie.Budget;
import entitie.Fournisseur;
import entitie.User;

public class FournisseurDaoImplTestCase {
	
	private FournisseurDao fournisseurDao=new FournisseurDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM fournisseur");
		stmt.executeUpdate("INSERT INTO `fournisseur`(`nomFournisseur`,`adresse`) VALUES('Auchan','47 rue')");
		stmt.executeUpdate("INSERT INTO `fournisseur`(`nomFournisseur`,`adresse`) VALUES('Leclerc','48 rue')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testAjoutFournisseur() {
		Fournisseur fournisseur=new Fournisseur(3, "Inter", "45 rue Lille");
		fournisseurDao.ajoutFournisseur(fournisseur);
		
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM fournisseur WHERE nomFournisseur='Inter'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idFournisseur"));
			Assert.assertEquals("Inter", results.getString("nomFournisseur"));
			Assert.assertEquals("45 rue Lille", results.getString("adresse"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Test
		public void testerListerBudget() {
			List<Fournisseur> fournisseurs = fournisseurDao.listerFournisseur();
			Assert.assertEquals(2, fournisseurs.size());
			Assert.assertEquals("Auchan", fournisseurs.get(0).getNomFournisseur());
			Assert.assertEquals("47 rue",fournisseurs.get(0).getAdresse());
			
		
	}

}
