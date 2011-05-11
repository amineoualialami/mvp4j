package com.atos.profiler.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atos.profiler.model.Profil;
import com.atos.profiler.model.User;

@Stateless(name = "UserSession")
public class UserSessionBean implements UserSession {

	@PersistenceContext(unitName = "profilerPU")
	private EntityManager em;

	@Override
	public void updateUser(User userParam) {

		User user = (User) em.find(User.class, userParam.getIdUser());

		user.setName(userParam.getName());
		user.setMail(userParam.getMail());
		user.setPhone(userParam.getPhone());
		user.setProfil(userParam.getProfil());

		em.merge(user);

	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		System.out.println("achieved");
		Query q = em.createQuery("select user from User user");

		List l = q.getResultList();
		if (!l.isEmpty()) {
			for (int i = 0; i < l.size(); i++) {

				User user = (User) l.get(i);
				users.add(user);
			}

		}

		return users;

	}

	@Override
	public void deleteUser(long id) {

		User user = (User) em.find(User.class, id);
		try {
			em.remove(user);
		} catch (Exception e) {

			System.out.println("erreur supression: " + e.getMessage());
		}
	}

	@Override
	public void addUser(User user) {

		User u = new User();
		u.setName(user.getName());
		u.setMail(user.getMail());
		u.setPhone(user.getPhone());
		u.setProfil(user.getProfil());

		try {

			em.persist(u);
		} catch (Exception e) {
			System.out.println("erreur persist: " + e.getMessage());
		}

	}

	public void afficher() {

		System.out.println("Bonjour Application");

	}

	@Override
	public List<Profil> loadAllProfil() {
		Query query = em.createQuery("SELECT profil FROM Profil AS profil");
		List<Profil> listprofils = query.getResultList();
		return listprofils;
	}

	@Override
	public Profil getProfilByName(String profilName) {
		Query query = em
				.createQuery("Select profil FROM Profil AS profil where profil.name=:param");
		query.setParameter("param", profilName);
		Profil profil = (Profil) query.getSingleResult();
		return profil;
	}

	@Override
	public User findUser(Long idUser) {
		try {
			User user = em.find(User.class, idUser);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}

}
