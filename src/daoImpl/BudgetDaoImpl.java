package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BudgetDao;
import entitie.Budget;
import entitie.User;
import entitie.Virement;

public class BudgetDaoImpl implements BudgetDao {
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public Budget ajoutBudget(Budget budget) {
		bdd.connect();
		
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("INSERT INTO `budget`(`nomBudget`,`refB`,`montantPrevu`,`montantUtilise`,`idUser`) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, budget.getNomBudget());
			stmt.setString(2, budget.getRef());
			stmt.setDouble(3, budget.getMontantPrevu());
			stmt.setDouble(4, budget.getMontantUtilise());
			stmt.setInt(5, budget.getCreateur().getIdUser());
			
			stmt.execute();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				int idBudget = ids.getInt(1);
				budget.setIdBudget(idBudget);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return budget;
	}

	@Override
	public List<Budget> listerBudget() {
		bdd.connect();
		List<Budget> listeBudget = new ArrayList<Budget>();
		
		try {
			
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM budget INNER JOIN user ON budget.idUser=user.idUser";
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idB=res.getInt("idBudget");
				String nomB=res.getString("nomBudget");
				Double montantP=res.getDouble("montantPrevu");
				Double montantU=res.getDouble("montantUtilise");
				String refB=res.getString("refB");
				
				
				User createur=new User();
				createur.setIdUser(res.getInt("idUser"));
				createur.setEmail(res.getString("email"));
				createur.setMdp(res.getString("mdp"));
				createur.setNom(res.getString("nomUser"));
				createur.setTypeUser(res.getInt("type"));
				
				Budget budget=new Budget(idB,refB,nomB,montantP,montantU,createur);
				listeBudget.add(budget);
				
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeBudget;
	}

	@Override
	public List<Budget> listerBudgetFiltre(String filtre) {
		bdd.connect();
		List<Budget> listeBudget = new ArrayList<Budget>();
		String tri="";
		if(filtre=="Référence : Ordre alphabétique"){tri="refB asc";}
		else if (filtre=="Référence : Ordre alphabétique inverse"){tri="refB desc";}
		else if (filtre=="Nom : Ordre alphabétique"){tri="nomBudget asc";}
		else if (filtre=="Nom : Ordre alphabétique inverse"){tri="nomBudget desc";}
		else if (filtre=="Budget fixé : Ordre croissant"){tri="montantPrevu asc";}
		else if (filtre=="Budget fixé : Ordre décroissant"){tri="montantPrevu desc";}
		try {
			Statement stm = bdd.getConnection().createStatement();
			String rqt="SELECT * FROM budget JOIN user ON budget.idUser=user.idUser ORDER BY "+tri;
			ResultSet res=stm.executeQuery(rqt);
			while (res.next()){
				Integer idB=res.getInt("idBudget");
				String nomB=res.getString("nomBudget");
				Double montantP=res.getDouble("montantPrevu");
				Double montantU=res.getDouble("montantUtilise");
				String refB=res.getString("refB");
				
				
				User createur=new User();
				createur.setIdUser(res.getInt("idUser"));
				createur.setEmail(res.getString("email"));
				createur.setMdp(res.getString("mdp"));
				createur.setNom(res.getString("nomUser"));
				createur.setTypeUser(res.getInt("type"));
				
				Budget budget=new Budget(idB,refB,nomB,montantP,montantU,createur);
				listeBudget.add(budget);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return listeBudget;
	}
	
	@Override
	public void majMontant(Virement virement, Integer id) {
		bdd.connect();
		if(virement.getEmetteur().equals("BDE")){
			try {
				PreparedStatement stmt = bdd.getConnection().prepareStatement("UPDATE budget SET montantUtilise=montantUtilise+? WHERE idBudget=?");
				stmt.setDouble(1, virement.getMontant());
				stmt.setInt(2, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (virement.getRecepteur().equals("BDE")){
			try {
				PreparedStatement stmt = bdd.getConnection().prepareStatement("UPDATE budget SET montantUtilise=montantUtilise-? WHERE idBudget=?");
				stmt.setDouble(1, virement.getMontant());
				stmt.setInt(2, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bdd.close();
	}
	
	@Override
	public void suppressionBudget(Integer id) {
		bdd.connect();
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("DELETE FROM budget WHERE idBudget=?");
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
	public Double newMontant(Integer id) {
		bdd.connect();
		Double newMontant=null;
		try {
			PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT montantUtilise, montantPrevu FROM budget WHERE idBudget=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();
			Double montantU =res.getDouble("montantUtilise");
			Double montantP=res.getDouble("montantPrevu");
			newMontant=montantP-montantU;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return newMontant;
	}

}
