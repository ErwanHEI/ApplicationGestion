package daoImplTestCase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.ProduitDao;
import daoImpl.DataBase;
import daoImpl.ProduitDaoImpl;
import entitie.Fournisseur;
import entitie.ModificationProduit;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;

public class ProduitDaoImplTestCase {
	
	private ProduitDao pdtDao=new ProduitDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		Statement stmt = bdd.getConnection().createStatement();
		stmt.executeUpdate("DELETE FROM produit");
		stmt.executeUpdate("INSERT INTO `produit`(`idProduit`,`nomProduit`,`categorie`,`quantite`,`idUser`,`idStockage`,`idFournisseur`,`prixU`) VALUES('1','Lait','Bouteille','15','1','2','1','1.25')");
		stmt.executeUpdate("INSERT INTO `produit`(`idProduit`,`nomProduit`,`categorie`,`quantite`,`idUser`,`idStockage`,`idFournisseur`,`prixU`) VALUES('2','Pain','Nourriture','20','2','1','1','1.0')");
		stmt.executeUpdate("DELETE FROM modificationProduit");
		stmt.executeUpdate("INSERT INTO `modificationProduit`(`idModif`,`modification`,`produit`,`utilisateur`,`dateModif`) VALUES('1','Prix : 1.30','Jus','Erwan','27/05/2016')");
		stmt.executeUpdate("INSERT INTO `modificationProduit`(`idModif`,`modification`,`produit`,`utilisateur`,`dateModif`) VALUES('2','Quantite : 20','Lait','Benjamin','01/05/2016')");
		stmt.close();
		bdd.close();
		}

	@Test
	public void testAjoutProduit() {
		User user=new User();
		user.setIdUser(2);
		Stockage stockage=new Stockage(0, "Local 1", "Armoire noire", 25);
		Fournisseur fournisseur=new Fournisseur(0, "Auchan", "Englos");
		Produit produit=new Produit(0, "Jus", "Liquide", 0.56, 68, stockage, fournisseur, user);
		pdtDao.ajout(produit);
		
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM produit WHERE nomProduit='Jus'");
			Assert.assertTrue(results.next());
			Assert.assertNotNull(results.getInt("idProduit"));
			Assert.assertEquals("Jus", results.getString("nomProduit"));
			//Assert.assertEquals(0.56, results.getDouble("prixU"));
			Assert.assertEquals(68, results.getInt("quantite"));
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testListerProduit(){
		List<Produit> pdts=pdtDao.listerProduit();
		Assert.assertEquals(2, pdts.size());
		Assert.assertEquals("Lait", pdts.get(0).getNomProduit());
		Assert.assertEquals("Bouteille", pdts.get(0).getCategorie());
	}
	
	@Test
	public void testListerModifications(){
		List<ModificationProduit> modifs=pdtDao.listerModification();
		Assert.assertEquals(2, modifs.size());
		Assert.assertEquals("Jus", modifs.get(0).getProduit());
		Assert.assertEquals("27/05/2016", modifs.get(0).getDate());
		Assert.assertEquals("Prix : 1.30", modifs.get(0).getModif());
	}
	
	@Test
	public void testSupprimerProduit(){
		pdtDao.suppressionProduit(1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM produit WHERE idProduit='1'");
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testSupprimerJournalProduit(){
		pdtDao.suppressionJournalProduit(1);
		DataBase bdd=new DataBase("gestionstock.sqlite");
		bdd.connect();
		try {
			Statement stmt = bdd.getConnection().createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM modificationProduit WHERE idModif='1'");
			Assert.assertFalse(results.next());
			stmt.close();
			bdd.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
