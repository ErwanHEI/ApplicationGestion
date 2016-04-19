package dao;

import entitie.User;

public interface UserDao {
	public User creationUser(User user);
	public User rechercheUser(String email);
	public void modifMdp(String password,Integer id);
	

}
