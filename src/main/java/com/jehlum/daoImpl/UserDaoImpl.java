package com.jehlum.daoImpl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.jehlum.daoInterface.UserDao;
import com.jehlum.models.Role;
import com.jehlum.models.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	EntityManager em;
	@Bean
	PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	public boolean save(User user) {
		Query query=em.createQuery("Select u from User u where u.email = :email and u.number = :number")
									.setParameter("email",user.getEmail()).setParameter("number",user.getNumber());
		if(query.getResultList().isEmpty()) {
			System.err.println(user.getPassword()+"09900909909090909090");
			user.setPassword(getEncoder().encode(user.getPassword()));
			em.persist(user);
			return true;
		}
		return false;
	}
	
	public Role findRole(String rolename) {
		Query query = em.createQuery("select r from Role r where r.name=: rolename") 
				.setParameter("rolename", rolename);
		return (Role) query.getSingleResult();
	}
	/*
	@Override
	public boolean update(User user) {
		Query query=em.createQuery("Select u from User u where u.email = :email and u.number  = :number and u.id != :id")
				.setParameter("email",user.getEmail()).setParameter("number",user.getNumber()).setParameter("id",user.getId());
		if(query.getResultList().isEmpty()) {
			em.merge(user);
			return true;
		}
		return false;
	}

	@Override
	public User findOne(Long id) {
		return em.find(User.class,id);
	}

	@Override
	public void delete(Long id) {
		em.remove(em.find(User.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Query query = em.createQuery("Select u from User u");
		return query.getResultList();
	}*/

	@Override
	public User findByEmail(String email) {
		System.err.println(email + "89897878676765565454456776");
		Query query=em.createQuery("Select u from User u where u.email = :email").setParameter("email", email);
		User user= (User) query.getResultList().get(0);
		System.out.println(user);
		return user;
	}


}
