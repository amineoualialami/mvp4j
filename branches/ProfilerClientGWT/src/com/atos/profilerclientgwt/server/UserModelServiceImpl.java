package com.atos.profilerclientgwt.server;

import java.util.ArrayList;
import java.util.List;

import com.atos.profilerclientgwt.model.UserDTO;
import com.atos.profilerclientgwt.model.UserModelService;
import com.atos.profilerclientgwt.utils.EJB3ProxyServlet;

public class UserModelServiceImpl extends EJB3ProxyServlet implements UserModelService {

	
	UserSession userSession;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		List<User> users = getUserSession().getAllUsers();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(user.getName());
			userDTO.setDate(user.getDate());
			userDTO.setIdUser(user.getIdUser());
			userDTO.setMail(user.getMail());
			userDTO.setPhone(user.getPhone());
			usersDTO.add(userDTO);
		}
		System.out.println("Hello");
		return usersDTO;
	}

	@Override
	public void test() {
		System.out.println("Acces au serveur");
		
	}

	public UserSession getUserSession() {
		if(userSession==null){
			userSession = (UserSession) ServiceLocator.getRemoteInterface("UserSession/remote");
		}
		return userSession;
	}

	
	
	

}
