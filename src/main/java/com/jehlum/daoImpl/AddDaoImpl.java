package com.jehlum.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jehlum.daoInterface.AddDaoInterface;
import com.jehlum.models.PostAdd;
import com.jehlum.models.User;


@Repository
public class AddDaoImpl implements AddDaoInterface {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(PostAdd add) {
		em.persist(add);
	}
	
	public List<PostAdd> getallAdds(User user){
		Query query = em.createQuery("select p from PostAdd p where p.user.id=:id ")
				.setParameter("id", user.getId());
		return query.getResultList();
	}
	
	public PostAdd find(Long id) {
		Query query = em.createQuery("select p from PostAdd p where p.id=:id ")
				.setParameter("id", id);
		return (PostAdd) query.getSingleResult();
	}

	public void remove(Long id) {
		PostAdd add = em.find(PostAdd.class, id);
		em.remove(add);
	}
	
	public List<PostAdd> getAllJobs(){
		Query query = em.createQuery("select p from PostAdd p");
		return query.getResultList();
	}
}
