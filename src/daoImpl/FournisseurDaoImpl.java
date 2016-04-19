package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.FournisseurDao;
import entitie.Fournisseur;
import entitie.Stockage;

public class FournisseurDaoImpl implements FournisseurDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public Fournisseur ajoutFournisseur(Fournisseur fournisseur) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO `fournisseur`(`nomFournisseur`,`adresse`) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, fournisseur.getNomFournisseur());
			stmt.setString(2, fournisseur.getAdresse());
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idFournisseur = ids.getInt(1);
				fournisseur.setIdFournisseur(idFournisseur);
			}
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return fournisseur;
	}

	@Override
	public List<Fournisseur> listerFournisseur() {
		bdd.connect();
		List<Fournisseur> listeFournisseur = new ArrayList<Fournisseur>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM fournisseur";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idSto=res.getInt("idFournisseur");
				String nom=res.getString("nomFournisseur");
				String localisation=res.getString("adresse");
				
				Fournisseur fournisseur=new Fournisseur(idSto,nom,localisation);
				listeFournisseur.add(fournisseur);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeFournisseur;
	}

}
