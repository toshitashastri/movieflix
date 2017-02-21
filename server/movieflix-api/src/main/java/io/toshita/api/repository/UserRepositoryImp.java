package io.toshita.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.toshita.api.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {

		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		else
			return null;
		
	}

	@Override
	public User create(User usr) {
		em.persist(usr);
		return usr;
	}

	@Override
	public User update( User usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(User usr) {

		em.remove(usr);

	}

	@Override
	public User auth(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.auth", User.class);
		query.setParameter("pEmail", email);
		query.setParameter("pPassword", password);
		List<User> users = query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		else
			return null;
	}

}
