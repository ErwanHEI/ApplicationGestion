package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBase {
	private String DBPath = "Chemin aux base de donnée SQLite";
	private Connection connection = null;
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Statement statement = null;

	public DataBase(String dBPath) {
		DBPath = dBPath;
	}

	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
			statement = connection.createStatement();
			System.out.println("Connexion a " + DBPath + " avec succès");
			
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
			System.out.println("Erreur de connexion");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("Erreur de connexion");
		}
		return connection;
	}

	public void close() {
		try {
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String requet) {
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(requet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requet : " + requet);
		}
		return resultat;

	}

	
}

