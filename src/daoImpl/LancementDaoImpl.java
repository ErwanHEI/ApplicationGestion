package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.LancementDao;

public class LancementDaoImpl implements LancementDao{
	
	DataBase bdd=new DataBase("gestionstock.sqlite");
	Connection connection;

	@Override
	public int lancement() {
		bdd.connect();
		Integer nbLance=0;
		try {
			Statement stm=bdd.getConnection().createStatement();
			String rqt="SELECT * FROM compteur";
			ResultSet res=stm.executeQuery(rqt);
			nbLance=res.getInt("nbLance");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		return nbLance;
	}

	@Override
	public void updateCompteur() {
		bdd.connect();
		try {
			Statement stm=bdd.getConnection().createStatement();
			String rqt="UPDATE compteur SET nbLance=1";
			stm.execute(rqt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.close();
		
		
	}

}
