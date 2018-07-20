package com.jehlum.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jehlum.daoInterface.NotificationDaoInterface;
import com.jehlum.models.Notification;
import com.jehlum.serviceInterface.NotificationServiceinterface;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationServiceinterface {

	@Autowired
	private NotificationDaoInterface notificationdao;
	
	public void save(Notification notification) {
		notificationdao.save(notification);
	}
	public List<Notification> getAllNotifications(){
		return notificationdao.getAllNotifications();
	}
	public boolean find(Notification notification) {
		return notificationdao.find(notification);
	} 
}
