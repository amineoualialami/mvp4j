package com.profiler.services;
import java.util.List;

import javax.ejb.Remote;

import com.profiler.entity.Profil;
import com.profiler.entity.User;


@Remote
public interface UserSessionRemote {
	public String hello();
	public void updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(long id);
	public void addUser(User user);
	public User findUser(Long idUser);
	
	public List<Profil> loadAllProfil();
	public Profil getProfilByName(String profilName);

}
