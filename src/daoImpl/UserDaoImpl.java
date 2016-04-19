package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;
import entitie.User;

public class UserDaoImpl implements UserDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public User creationUser(User newUser) {
		bdd.connect();
		try {
			// Password pass=new Password();
			// String passHasch=pass.genererMotDePasse(newUser.getMotDePasse());
			
			PreparedStatement stmt = bdd.getConnection().prepareStatement(
					"INSERT INTO `user`(`nomUser`,`email`,`mdp`,`type`) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newUser.getNom());
			stmt.setString(2, newUser.getEmail());
			stmt.setInt(4, newUser.getTypeUser());
			stmt.setString(3, newUser.getMdp());
			stmt.execute();
			ResultSet ids = stmt.getGeneratedKeys();
			if (ids.next()) {
				Integer idUser = ids.getInt(1);
				newUser.setIdUser(idUser);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bdd.close();
		return newUser;
	}
	
	public User rechercheUser(String emailUser) {
		bdd.connect();
		User user = null;
		Connection connection;
		try {
			
			PreparedStatement stmt = bdd.getConnection().prepareStatement("SELECT * FROM user WHERE email=?");
			stmt.setString(1, emailUser);
			ResultSet res = stmt.executeQuery();
			if (res.next()) {
				user = map(res);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return user;
	}

	private static User map(ResultSet resultSet) throws SQLException {

		User utilisateur = new User();
		utilisateur.setIdUser(resultSet.getInt("idUser"));
		utilisateur.setEmail(resultSet.getString("email"));
		utilisateur.setMdp(resultSet.getString("mdp"));
		utilisateur.setNom(resultSet.getString("nomUser"));
		utilisateur.setTypeUser(resultSet.getInt("type"));
		return utilisateur;

	}
	
	
	public void modifMdp(String password, Integer id) {
		bdd.connect();
		Connection connection;
		try {
			PreparedStatement stmt = bdd.getConnection()
					.prepareStatement("UPDATE user SET mdp=? WHERE idUser=?");
			stmt.setString(1, password);
			stmt.setInt(2, id);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		bdd.close();
	}

}
