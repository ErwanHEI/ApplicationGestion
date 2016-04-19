package manager;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import entitie.User;

public class UserManager {
	
	private static UserManager instance;
	private UserDao userDao = new UserDaoImpl();

	public static UserManager getInstance() {

		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	public User creationUser(User user){
		return userDao.creationUser(user);
	}
	
	public User rechercheUser(String email){
		return userDao.rechercheUser(email);
	}
	
	public void modif(String password, Integer id){
		userDao.modifMdp(password, id);
	}

}
