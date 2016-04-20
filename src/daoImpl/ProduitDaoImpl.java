package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ProduitDao;
import entitie.Fournisseur;
import entitie.ModificationProduit;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;

public class ProduitDaoImpl implements ProduitDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;
	
	

	@Override
	public Produit ajout(Produit produit) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO `produit`(`nomProduit`,`categorie`,`quantite`,`prixU`,`idFournisseur`,`idStockage`,`idUser`) VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produit.getNomProduit());
			stmt.setString(2, produit.getCategorie());
			stmt.setInt(3, produit.getQuantite());
			stmt.setDouble(4, produit.getPrixU());
			stmt.setInt(5, produit.getFournisseur().getIdFournisseur());
			stmt.setInt(6, produit.getStockage().getIdStockage());
			stmt.setInt(7, produit.getCreateur().getIdUser());
			stmt.execute();
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idProduit = ids.getInt(1);
				produit.setIdProduit(idProduit);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return produit;
		
	}



	@Override
	public List<Produit> listerProduit() {
		bdd.connect();
		List<Produit> listeProduit = new ArrayList<Produit>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM produit JOIN stockage ON produit.idStockage=stockage.idStockage";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				String name=res.getString("nomProduit");
				Integer idProduit=res.getInt("idProduit");
				String categorie=res.getString("categorie");
				Integer quantite=res.getInt("quantite");
				Double prixU=res.getDouble("prixU");
				Integer idFournisseur=res.getInt("idFournisseur");
				Integer idCreateur=res.getInt("idUser");
				
				Integer idStockage=res.getInt("idStockage");
				String localisation=res.getString("localisation");
				String nomStockage=res.getString("nomStockage");
				Integer remplissage=res.getInt("remplissage");
				Stockage stockage=new Stockage(idStockage,localisation,nomStockage,remplissage);
				
				PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT * FROM fournisseur WHERE idFournisseur=?");
				stmt.setInt(1, idFournisseur);
				ResultSet res1=stmt.executeQuery();
				String nomF=res1.getString("nomFournisseur");
				String adresse=res1.getString("adresse");
				Fournisseur fournisseur=new Fournisseur(idFournisseur,nomF,adresse);
				
				PreparedStatement stmt1 = bdd.getConnection().prepareStatement("SELECT * FROM user WHERE idUser=?");
				stmt1.setInt(1, idCreateur);
				ResultSet res2=stmt1.executeQuery();
				User createur=map(res2);
				
				
				Produit produit=new Produit(idProduit,name, categorie,prixU, quantite,stockage,fournisseur,null);
				listeProduit.add(produit);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeProduit;
		
	}
	
	@Override
	public List<Produit> listerProduitFiltre(String filtre) {
		bdd.connect();
		List<Produit> listeProduit = new ArrayList<Produit>();
		String tri="";
		if(filtre=="Catégorie : Ordre alphabétique"){tri="categorie asc";}
		else if (filtre=="Catégorie : Ordre alphabétique inverse"){tri="categorie desc";}
		else if (filtre=="Nom : Ordre alphabétique"){tri="nomProduit asc";}
		else if (filtre=="Nom : Ordre alphabétique inverse"){tri="nomProduit desc";}
		else if (filtre=="Prix : Ordre croissant"){tri="prixU asc";}
		else if (filtre=="Prix : Ordre décroissant"){tri="prixU desc";}
		else if (filtre=="Quantité : Ordre croissant"){tri="quantite asc";}
		else if (filtre=="Quantité : Ordre décroissant"){tri="quantite desc";}
		/*else if (filtre=="Lieu de stockage : Ordre alphabétique"){tri="categorie desc";}
		else if (filtre=="Lieu de stockage : Ordre alphabétique inverse"){tri="categorie desc";}*/
		
		try {
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM produit JOIN stockage ON produit.idStockage=stockage.idStockage ORDER BY "+tri;
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				String name=res.getString("nomProduit");
				Integer idProduit=res.getInt("idProduit");
				String categorie=res.getString("categorie");
				Integer quantite=res.getInt("quantite");
				Double prixU=res.getDouble("prixU");
				Integer idFournisseur=res.getInt("idFournisseur");
				Integer idCreateur=res.getInt("idUser");
				
				Integer idStockage=res.getInt("idStockage");
				String localisation=res.getString("localisation");
				String nomStockage=res.getString("nomStockage");
				Integer remplissage=res.getInt("remplissage");
				Stockage stockage=new Stockage(idStockage,localisation,nomStockage,remplissage);
				
				PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT * FROM fournisseur WHERE idFournisseur=?");
				stmt.setInt(1, idFournisseur);
				ResultSet res1=stmt.executeQuery();
				String nomF=res1.getString("nomFournisseur");
				String adresse=res1.getString("adresse");
				Fournisseur fournisseur=new Fournisseur(idFournisseur,nomF,adresse);
				
				PreparedStatement stmt1 = bdd.getConnection().prepareStatement("SELECT * FROM user WHERE idUser=?");
				stmt1.setInt(1, 3);
				ResultSet res2=stmt1.executeQuery();
				User createur=map(res2);
				
				
				Produit produit=new Produit(idProduit,name, categorie,prixU, quantite,stockage,fournisseur,null);
				listeProduit.add(produit);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeProduit;
	}

	private static User map(ResultSet resultSet) throws SQLException {

		User utilisateur = new User();
		utilisateur.setIdUser(resultSet.getInt("idUser"));
		utilisateur.setEmail(resultSet.getString("email"));
		utilisateur.setMdp(resultSet.getString("mdp"));
		utilisateur.setNom(resultSet.getString("nomUser"));
		return utilisateur;

	}



	


	@Override
	public void majPrix(Integer prix, Produit produit, User user) {
		bdd.connect();
		Connection connection;
		try {
			PreparedStatement stmt = bdd.getConnection()
					.prepareStatement("UPDATE produit SET  prix=? WHERE idProduit=?");
			stmt.setInt(1, prix);
			stmt.setInt(2, produit.getIdProduit());
			stmt.execute();
			
			PreparedStatement stmt1 = bdd.getConnection()
					.prepareStatement("INSERT INTO`modificationProduit`(`modification`,`datModif`,`utilisateur`, `produit`) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt1.setString(1, "Prix : "+prix.toString());
			Date aujourdhui = new Date();
			List<String> dateA=new ArrayList<String>();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String date=shortDateFormat.format(aujourdhui);
			System.out.println(date);
			
			 for (String retval: date.split(" ")){
		         dateA.add(retval);
		      }
			stmt1.setString(2, dateA.get(0));
			stmt1.setString(3, user.getNom());
			stmt1.setString(4, produit.getNomProduit());
			
			stmt1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		bdd.close();
	}



	@Override
	public void majQuantite(Integer quantite,Produit produit, User user) {
		bdd.connect();
		Connection connection;
		try {
			PreparedStatement stmt = bdd.getConnection()
					.prepareStatement("UPDATE produit SET  quantite=? WHERE idProduit=?");
			stmt.setInt(1, quantite);
			stmt.setInt(2, produit.getIdProduit());
			stmt.execute();
			
			PreparedStatement stmt1 = bdd.getConnection()
					.prepareStatement("INSERT INTO`modificationProduit`(`modification`,`dateModif`,`utilisateur`, `produit`) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt1.setString(1, "Quantité : "+quantite.toString());
			Date aujourdhui = new Date();
			List<String> dateA=new ArrayList<String>();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String date=shortDateFormat.format(aujourdhui);
			System.out.println(date);
			
			 for (String retval: date.split(" ")){
		         dateA.add(retval);
		      }
			stmt1.setString(2, dateA.get(0));
			stmt1.setString(3, user.getNom());
			stmt1.setString(4, produit.getNomProduit());
			
			stmt1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		bdd.close();
	}



	@Override
	public void majStockage(Stockage stockage,Produit produit, User user) {
		bdd.connect();
		Connection connection;
		try {
			PreparedStatement stmt = bdd.getConnection()
					.prepareStatement("UPDATE produit SET  idStockage=? WHERE idProduit=?");
			stmt.setInt(1, stockage.getIdStockage());
			stmt.setInt(2, produit.getIdProduit());
			stmt.execute();
			
			PreparedStatement stmt1 = bdd.getConnection()
					.prepareStatement("INSERT INTO`modificationProduit`(`modification`,`datModif`,`utilisateur`, `produit`) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt1.setString(1, stockage.getNomStockage());
			Date aujourdhui = new Date();
			List<String> dateA=new ArrayList<String>();
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String date=shortDateFormat.format(aujourdhui);
			System.out.println(date);
			
			 for (String retval: date.split(" ")){
		         dateA.add(retval);
		      }
			stmt1.setString(2, dateA.get(0));
			stmt1.setString(3, user.getNom());
			stmt1.setString(4, produit.getNomProduit());
			
			stmt1.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		bdd.close();
	}



	@Override
	public List<ModificationProduit> listerModification() {
		bdd.connect();
		List<ModificationProduit> listeModif = new ArrayList<ModificationProduit>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM modificationProduit";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idModif=res.getInt("idModif");				
				String nomP=res.getString("produit");
				String modification=res.getString("modification");
				String dateModif=res.getString("dateModif");
				String createur=res.getString("utilisateur");
				ModificationProduit modif=new ModificationProduit(idModif, nomP, modification,createur , dateModif);
				listeModif.add(modif);
				
			}	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeModif;
		
	}

	@Override
		public List<ModificationProduit> listerModificationFiltre(String filtre) {
			bdd.connect();
			List<ModificationProduit> listeModif = new ArrayList<ModificationProduit>();
			String tri="";
			if(filtre=="Quantité : Ordre croissant"){tri="quantite asc";}
			else if (filtre=="Quantité : Ordre décroissant"){tri="quantite desc";}
			try {
				Statement stm = bdd.getConnection().createStatement();
				String rqt="SELECT * FROM modificationProduit ORDER BY "+tri;
				ResultSet res=stm.executeQuery(rqt);
				while (res.next()){
					Integer idModif=res.getInt("idModif");				
					String nomP=res.getString("produit");
					String nouveauStockage=res.getString("stockage");
					Integer nouvelleQu=res.getInt("quantite");
					Double nouveauprixU=res.getDouble("prix");
					String createur=res.getString("utilisateur");
					
				ModificationProduit modif=new ModificationProduit(idModif,nouveauprixU,nouvelleQu,nomP,nouveauStockage,createur);
				listeModif.add(modif);
				}	
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bdd.close();
			return listeModif;
		}

	@Override
	public void suppressionProduit(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM produit WHERE idProduit=?");
			stmt.setInt(1, id);
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();	
	}
	
	
	@Override
	public void suppressionJournalProduit(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM modificationProduit WHERE idModif=?");
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
