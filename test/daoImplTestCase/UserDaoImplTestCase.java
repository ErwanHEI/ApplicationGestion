package daoImplTestCase;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import daoImpl.DataBase;
import daoImpl.UserDaoImpl;
import entitie.Budget;
import entitie.User;

public class UserDaoImplTestCase {
	UserDao userDao=new UserDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM user");
		stmt.executeUpdate("INSERT INTO `user`(`idUser`,`nomUser`,`email`,`mdp`,`type`) VALUES('1','Erwan','erwan.kieffer@hei.fr', 'azerty','1')");
		stmt.executeUpdate("INSERT INTO `user`(`idUser`,`nomUser`,`email`,`mdp`,`type`) VALUES('2','Benjamin','benjamin.leignel@hei.fr', 'azertyui','1')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testCreateUser() {
		User user=new User();
		user.setIdUser(3);
		user.setEmail("coucou@hei.fr");
		user.setMdp("coucou");
		user.setTypeUser(3);
		user.setNom("Romain");
		userDao.creationUser(user);
		
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM user WHERE nomUser='Romain'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idUser"));
			Assert.assertEquals("coucou", results.getString("mdp"));
			Assert.assertEquals(3, results.getInt("type"));
			Assert.assertEquals("coucou@hei.fr", results.getString("email"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testRechercherUser(){
		String email="erwan.kieffer@hei.fr";
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		User user=userDao.rechercheUser(email);
		Assert.assertNotNull(user.getIdUser());
		Assert.assertEquals("Erwan", user.getNom());
		Assert.assertEquals(1, user.getTypeUser());
		
	}
	
	@Test
	public void testModifierMdp(){
		String newMdp="hoho";
		userDao.modifMdp(newMdp, 1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM user WHERE idUSer=1");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idUser"));
			Assert.assertEquals("hoho", results.getString("mdp"));
			Assert.assertEquals("Erwan", results.getString("nomUser"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
