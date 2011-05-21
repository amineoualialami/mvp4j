package com.atos.profiler.services;

import java.util.List;

import javax.ejb.Remote;

import com.atos.profiler.model.Profil;
import com.atos.profiler.model.User;

@Remote
public interface UserSession {

	public void updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(long id);
	public void addUser(User user);
	public User findUser(Long idUser);
	
	public List<Profil> loadAllProfil();
	public Profil getProfilByName(String profilName);
	
}
