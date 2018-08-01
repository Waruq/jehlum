package com.jehlum.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jehlum.daoInterface.NotificationDaoInterface;
import com.jehlum.models.Notification;

@Repository
public class NotificationDaoImpl implements NotificationDaoInterface {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Notification notification) {
		em.persist(notification);
	}
	
	public List<Notification> getAllNotifications(){
		Query query = em.createQuery("Select n from Notification n group by n.notificationFetchedSite order by n.notificationFetchedDate DESC");
		return query.getResultList();		
	}
	
	public boolean find(Notification notification) {
		Query query = em.createQuery("Select n from Notification n where n.notificationText=:text AND n.notificationUrl=:url")
				     .setParameter("text", notification.getNotificationText()).setParameter("url", notification.getNotificationUrl());
		if(query.getResultList().isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Notification> getNotificationOnSite(String sitename){
		


		Query query = em.createQuery("Select n from Notification n where n.notificationFetchedSite =:site  order by year(n.notificationFetchedDate) Desc,month(n.notificationFetchedDate) Desc, day(n.notificationFetchedDate) Desc ,"
				+ "Hour(n.notificationFetchedDate) Desc, minute(n.notificationFetchedDate) Asc, second(n.notificationFetchedDate) Asc")
				.setMaxResults(10)
				.setParameter("site", sitename);
		return query.getResultList();
	
	}
}
