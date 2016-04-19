package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.EvenementDao;
import entitie.Evenement;
import entitie.Fournisseur;
import entitie.Produit;
import entitie.Stockage;
import entitie.User;

public class EvenementDaoImpl implements EvenementDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public Evenement ajoutEvent(Evenement event) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO `event`(`nomEvent`,`dateEvent`,`idUser`) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, event.getNomEvenement());
			stmt.setString(2, event.getDateEvent());
			stmt.setInt(3, event.getCreateur().getIdUser());
			stmt.execute();
			for(int i=0;i<event.getListePdts().size();i++){
				PreparedStatement stmt1=bdd.getConnection().prepareStatement("INSERT INTO `utiliser`(`idEvent`,`idProduit`) VALUES(?,?)");
				stmt1.setInt(1, event.getIdEvenement());
				stmt1.setInt(2, event.getListePdts().get(i).getIdProduit());
				stmt.execute();
			}
			
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idEvenement = ids.getInt(1);
				event.setIdEvenement(idEvenement);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		
		return event;
	}

	@Override
	public List<Evenement> listerEvent() {
		bdd.connect();
		List<Evenement> liste=new ArrayList<Evenement>();
		List<Produit> listePdt=new ArrayList<Produit>();
		
try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM evenement ";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idEvent=res.getInt("idEvent");
				String nomEvent=res.getString("nomEvent");
				String dateEvent=res.getString("dateEvent");
				
				Integer idCreateur=res.getInt("idUser");
				PreparedStatement stmt1 = bdd.getConnection().prepareStatement("SELECT * FROM user WHERE idUser=?");
				stmt1.setInt(1, idCreateur);
				ResultSet res2=stmt1.executeQuery();
				User createur=map(res2);
				
				PreparedStatement stmt2 = bdd.getConnection().prepareStatement("SELECT * FROM utiliser INNER JOIN produit ON utiliser.idProduit=produit.idProduit WHERE idEvent=?");
				stmt2.setInt(1, idEvent);
				ResultSet res1=stmt2.executeQuery();
				while(res1.next()){
					String name=res1.getString("nomProduit");
					Integer idProduit=res1.getInt("idProduit");
					String categorie=res1.getString("categorie");
					Integer quantite=res1.getInt("quantite");
					Double prixU=res1.getDouble("prixU");
					
					Produit produit=new Produit(idProduit,name, categorie,prixU, quantite,null,null,null);
					listePdt.add(produit);
				}
				
				Evenement event=new Evenement (idEvent,nomEvent,dateEvent,createur,listePdt);
				liste.add(event);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return liste;
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
	public void supprimerEvenement(Integer idEvent) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM evenement WHERE idEvent=?");
			stmt.setInt(1, idEvent);
			stmt.execute();
			//mettre à jour table utiliser !!!! ATTENTION OUBLI !!!!
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		bdd.close();
		
	}

}
