package daoImplTestCase;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.BudgetDao;
import daoImpl.BudgetDaoImpl;
import daoImpl.DataBase;
import entitie.Budget;
import entitie.User;

public class BudgetDaoImplTestCase {
	
	private BudgetDao budgetDao=new BudgetDaoImpl();
	
	
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM budget");
		stmt.executeUpdate("INSERT INTO `budget`(`idBudget`,`nomBudget`,`montantPrevu`,`montantUtilise`,`idUser`,`refB`) VALUES('1','Sport','500','0','1','24A8')");
		stmt.executeUpdate("INSERT INTO `budget`(`idBudget`,`nomBudget`,`montantPrevu`,`montantUtilise`,`idUser`,`refB`) VALUES('2','Soiree','400','5','1','25p8')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testAjoutBudget() {
		User user=new User();
		user.setIdUser(2);
		Budget budget=new Budget(0,  "2748A","Nourriture", 400, 0, user);
		budgetDao.ajoutBudget(budget);
		
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM budget WHERE nomBudget='Nourriture'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idBudget"));
			Assert.assertEquals("2748A", results.getString("refB"));
			Assert.assertEquals(400, results.getInt("montantPrevu"));
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
		List<Budget> budgets = budgetDao.listerBudget();
		Assert.assertEquals(2, budgets.size());
		Assert.assertEquals("Sport", budgets.get(0).getNomBudget());
		Assert.assertEquals("24A8",budgets.get(0).getRef());
		
	}
	
	@Test
	public void testSupprimerBudget(){
		budgetDao.suppressionBudget(1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM budget WHERE idBudget='1'");
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
