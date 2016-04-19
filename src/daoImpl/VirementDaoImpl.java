package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.VirementDao;
import entitie.Budget;
import entitie.Produit;
import entitie.User;
import entitie.Virement;

public class VirementDaoImpl implements VirementDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	public Virement ajoutVirement(Virement virement) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO virement(`montant`,`ref`,`recepteur`,`emeteur`,`dateVirement`,`idEvent`,`idUser`,`idBudget`,`encaisse`) VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, virement.getMontant());
			stmt.setString(2, virement.getRef());
			stmt.setString(4, virement.getEmetteur());
			stmt.setString(3, virement.getRecepteur());
			stmt.setString(5, virement.getDateVirement());
			stmt.setInt(6, virement.getEventAssocie().getIdEvenement());
			stmt.setInt(7, virement.getCreateur().getIdUser());
			stmt.setInt(8, virement.getBudgetAssocie().getIdBudget());
			stmt.setBoolean(9, virement.isEncaisse());
			
			stmt.executeUpdate();
			//stmt.setInt(4, virement.getCreateur().getIdUser());
			//stmt.setInt(5, virement.getBudgetAssocie().getIdBudget());
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idVirement = ids.getInt(1);
				virement.setIdVirement(idVirement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return virement;
	}

	@Override
	public List<Virement> listerVirementNonEncaisse() {
		bdd.connect();
		List<Virement> listeVirement = new ArrayList<Virement>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM virement JOIN user ON virement.idUser=user.idUser WHERE encaisse='0' ";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Double montant=res.getDouble("montant");
				Integer idVirement=res.getInt("idVirement");
				String emetteur=res.getString("emeteur");
				String recepteur=res.getString("recepteur");
				String dateVirement=res.getString("dateVirement");
				String ref=res.getString("ref");
				Integer idE=res.getInt("idEvent");
				
				User createur=new User();
				createur.setIdUser(res.getInt("idUser"));
				createur.setEmail(res.getString("email"));
				createur.setMdp(res.getString("mdp"));
				createur.setNom(res.getString("nomUser"));
				createur.setTypeUser(res.getInt("type"));
				
				Virement virement=new Virement(idVirement,ref,montant, emetteur,recepteur,dateVirement,false,null,null,createur);
				listeVirement.add(virement);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeVirement;
		
	}

	@Override
	public List<Virement> journalVirement() {
		bdd.connect();
		List<Virement> listeVirement = new ArrayList<Virement>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM virement JOIN user ON virement.idUser=user.idUser";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Double montant=res.getDouble("montant");
				Integer idVirement=res.getInt("idVirement");
				String ref=res.getString("ref");
				String emetteur=res.getString("emeteur");
				String recepteur=res.getString("recepteur");
				String dateVirement=res.getString("dateVirement");
				Integer idB=res.getInt("idBudget");
				//Boolean encaisse=res.getBoolean("encaisse");
				Integer idE=res.getInt("idEvent");
				
				PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT * FROM budget WHERE idBudget=?");
				stmt.setInt(1, idB);
				ResultSet res1=stmt.executeQuery();
				
				
				String nomB=res1.getString("nomBudget");
				Double montantP=res1.getDouble("montantPrevu");
				Double montantU=res1.getDouble("montantUtilise");
				String refB=res1.getString("refB");
				Budget budget=new Budget(idB,refB,nomB,montantP,montantU,null);
				
				
				User createur=new User();
				createur.setIdUser(res.getInt("idUser"));
				createur.setEmail(res.getString("email"));
				createur.setMdp(res.getString("mdp"));
				createur.setNom(res.getString("nomUser"));
				createur.setTypeUser(res.getInt("type"));
				
				Virement virement=new Virement(idVirement,ref,montant, emetteur,recepteur,dateVirement,false,null, budget,createur);
				listeVirement.add(virement);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeVirement;
	}

	@Override
	public void passerEncaissement(Integer idVirement) {
		
		bdd.connect();
		try {
			
			PreparedStatement stmt = bdd.getConnection().prepareStatement("UPDATE virement SET encaisse='true' WHERE idVirement=?");
			stmt.setInt(1, idVirement);
			boolean res=stmt.execute();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
	}
	
	

	@Override
	public void suppressionVirement(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM virement WHERE idVirement=?");
			stmt.setInt(1, id);
			stmt.execute();
			//mettre à jour les budgets !!!! ATTENTION OUBLI !!!!
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		bdd.close();
	}
	
	@Override
	public void suppressionJournalBudget(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM virement WHERE idVirement=?");
			stmt.setInt(1, id);
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		bdd.close();
	}

	@Override
	public List<Virement> listerParEvent(Integer idE) {
		bdd.connect();
		List<Virement> liste=new ArrayList<Virement>();
		
		try {
			
			PreparedStatement stm = bdd.getConnection().prepareStatement("SELECT * FROM virement JOIN user ON virement.idUser=user.idUser WHERE idEvent=?");
			stm.setInt(1, idE);
			ResultSet res=stm.executeQuery();
			while (res.next()){
				Double montant=res.getDouble("montant");
				Integer idVirement=res.getInt("idVirement");
				String ref=res.getString("ref");
				String emetteur=res.getString("emeteur");
				String recepteur=res.getString("recepteur");
				String dateVirement=res.getString("dateVirement");
				Integer idB=res.getInt("idBudget");
				//Boolean encaisse=res.getBoolean("encaisse");
				
				
				PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT * FROM budget WHERE idBudget=?");
				stmt.setInt(1, idB);
				ResultSet res1=stmt.executeQuery();
				
				
				String nomB=res1.getString("nomBudget");
				Double montantP=res1.getDouble("montantPrevu");
				Double montantU=res1.getDouble("montantUtilise");
				String refB=res1.getString("refB");
				Budget budget=new Budget(idB,refB,nomB,montantP,montantU,null);
				
				
				User createur=new User();
				createur.setIdUser(res.getInt("idUser"));
				createur.setEmail(res.getString("email"));
				createur.setMdp(res.getString("mdp"));
				createur.setNom(res.getString("nomUser"));
				createur.setTypeUser(res.getInt("type"));
				
				Virement virement=new Virement(idVirement,ref,montant, emetteur,recepteur,dateVirement,false,null, budget,createur);
				liste.add(virement);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return liste;
		
	}

}
