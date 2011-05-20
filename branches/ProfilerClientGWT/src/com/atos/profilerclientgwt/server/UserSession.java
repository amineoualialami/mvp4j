package com.atos.profilerclientgwt.server;

import java.util.List;

import javax.ejb.Local;


@Local
public interface UserSession {

	public void updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(long id);
	public void addUser(User user);
	public User findUser(Long idUser);
	
	public List<Profil> loadAllProfil();
	public Profil getProfilByName(String profilName);
	
}
