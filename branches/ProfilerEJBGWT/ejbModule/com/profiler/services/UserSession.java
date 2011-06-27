package com.profiler.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.profiler.entity.Profil;
import com.profiler.entity.User;

/**
 * Session Bean implementation class UserSession
 */
@Stateless(name = "UserSession")
public class UserSession implements UserSessionRemote {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName = "profilerPU")
	private EntityManager em;

	public UserSession() {
	}

	public String hello() {

		return "Hello GWT";
	}

	public void updateUser(User user) {
		User user1 = (User) em.find(User.class, user.getIdUser());

		user1.setName(user.getName());
		user1.setMail(user.getMail());
		user1.setPhone(user.getPhone());
		user1.setProfil(user.getProfil());

		em.merge(user1);

	}

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

	public void deleteUser(long id) {
		User user = (User) em.find(User.class, id);
		try {
			em.remove(user);
		} catch (Exception e) {

			System.out.println("erreur supression: " + e.getMessage());
		}

	}

	public void addUser(User user) {
		User u = new User();
		u.setName(user.getName());
		u.setMail(user.getMail());
		u.setPhone(user.getPhone());
		u.setProfil(user.getProfil());
		u.setDate(user.getDate());

		try {

			em.persist(u);
		} catch (Exception e) {
			System.out.println("erreur persist: " + e.getMessage());
		}

	}

	public User findUser(Long idUser) {
		try {
			User user = em.find(User.class, idUser);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Profil> loadAllProfil() {
		Query query = em.createQuery("SELECT profil FROM Profil AS profil");
		List<Profil> listprofils = query.getResultList();
		return listprofils;
	}

	public Profil getProfilByName(String profilName) {
		Query query = em
				.createQuery("Select profil FROM Profil AS profil where profil.name=:param");
		query.setParameter("param", profilName);
		Profil profil = (Profil) query.getSingleResult();
		return profil;
	}

}
