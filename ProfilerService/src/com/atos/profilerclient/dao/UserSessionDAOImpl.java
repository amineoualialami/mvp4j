package com.atos.profilerclient.dao;

import java.util.ArrayList;
import java.util.List;

import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoConfigurationException;
import org.kahvi.paketti.dtobuilder.DtoDismantler;

import com.atos.profiler.model.Profil;
import com.atos.profiler.model.User;
import com.atos.profiler.services.UserSession;
import com.atos.profilerclient.dto.ProfilDTO;
import com.atos.profilerclient.dto.UserDTO;
import com.atos.profilerclient.locator.ServiceLocator;

public class UserSessionDAOImpl implements UserSessionDAO {

	UserSession userSession;
	
	DtoDismantler<UserDTO, User> userDTODismantler;
	DtoDismantler<ProfilDTO, Profil> profilDTODismantler;
	
	DtoBuilder<UserDTO> userDTOBuilder;
    DtoBuilder<ProfilDTO> profilDTOBuilder;
    
    @Override
	public void addUser(UserDTO userDTO) {
		try {
			User user = getUserDTODismantler().dismantle(userDTO);
			user.setPhone(userDTO.getPhone());
			
			List<Profil> listProfil2 = getUserSession().loadAllProfil();
			for (Profil profil2 : listProfil2) {
				if(profil2.getName().equals(userDTO.getProfil().getName())){
					user.setProfil(profil2);
			}
		}
			getUserSession().addUser(user);
		} catch (DtoConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(long id) {
		getUserSession().deleteUser(id);

	}

	@Override
	public void updateUser(UserDTO userDTO) {

		try {
			Profil profil=getProfilDTODismantler().dismantle(userDTO.getProfil());
			
			User user = getUserDTODismantler().dismantle(userDTO);
			user.setIdUser(userDTO.getIdUser());
			user.setPhone(userDTO.getPhone());
			user.setProfil(profil);
			
			getUserSession().updateUser(user);

		} catch (DtoConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> listUsers = getUserSession().getAllUsers();
		List<UserDTO> listUsersDTO = new ArrayList<UserDTO>();

		for (User user : listUsers) {
			try {
				ProfilDTO profilDTO = getProfilDTOBuilder().build(user.getProfil());
				UserDTO userDTO = new UserDTO();
				userDTO.setProfil(profilDTO);
				userDTO.setIdUser(user.getIdUser());
				userDTO.setName(user.getName());
				userDTO.setPhone(user.getPhone());
				userDTO.setMail(user.getMail());
				userDTO.setDate(user.getDate());
				listUsersDTO.add(userDTO);
			} catch (DtoConfigurationException e) {
				e.printStackTrace();
			}

		}
		return listUsersDTO;
	}

	@Override
	public UserDTO findUser(Long idUser) {
		UserDTO userDTO=null;
		try {
			if(getUserSession().findUser(idUser)==null){
				return null;
			}
			User user = getUserSession().findUser(idUser);
			userDTO = getUserDTOBuilder().build(user);
		} catch (DtoConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDTO;
	}

	public UserSession getUserSession() {
		if (userSession == null) {
			userSession = (UserSession) ServiceLocator
					.getRemoteInterface("UserSession/remote");
		}

		return userSession;
	}

	public DtoDismantler<UserDTO, User> getUserDTODismantler() {
		if (userDTODismantler == null) {
			userDTODismantler = new DtoDismantler<UserDTO, User>(UserDTO.class,
					User.class);
		}
		return userDTODismantler;
	}
	
	public DtoDismantler<ProfilDTO, Profil> getProfilDTODismantler() {
		if (profilDTODismantler == null) {
			profilDTODismantler = new DtoDismantler<ProfilDTO, Profil>(ProfilDTO.class,
					Profil.class);
		}
		return profilDTODismantler;
	}

	public DtoBuilder<UserDTO> getUserDTOBuilder() {
		if (userDTOBuilder == null) {
			userDTOBuilder = new DtoBuilder<UserDTO>(UserDTO.class);
		}
		return userDTOBuilder;
	}

	public DtoBuilder<ProfilDTO> getProfilDTOBuilder() {
		if (profilDTOBuilder == null) {
			profilDTOBuilder = new DtoBuilder<ProfilDTO>(ProfilDTO.class);
		}
		return profilDTOBuilder;
	}
	@Override
	public List<ProfilDTO> loadAllProfils() {
		
		List<Profil> profils=getUserSession().loadAllProfil();
		List<ProfilDTO> profilDTOS=new ArrayList<ProfilDTO>();
		
		for(Profil profil: profils){
			
			ProfilDTO profilDTO;
			try {
				profilDTO = getProfilDTOBuilder().build(profil);
				profilDTOS.add(profilDTO);
			} catch (DtoConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return profilDTOS;
	}

}
