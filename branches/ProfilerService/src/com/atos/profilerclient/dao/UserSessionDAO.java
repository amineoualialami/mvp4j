package com.atos.profilerclient.dao;

import java.util.List;

import com.atos.profilerclient.dto.ProfilDTO;
import com.atos.profilerclient.dto.UserDTO;



public interface UserSessionDAO {
	
	
	
	public void addUser(UserDTO user);
	public void deleteUser(long id);
	public void updateUser(UserDTO user);
	public List<UserDTO> getAllUsers();
	
	
	public UserDTO findUser(Long idUser);
	public List<ProfilDTO> loadAllProfils();

}
