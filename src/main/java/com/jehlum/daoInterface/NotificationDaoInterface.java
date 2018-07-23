package com.jehlum.daoInterface;

import java.util.List;

import com.jehlum.models.Notification;

public interface NotificationDaoInterface {

	public void save(Notification notification);
	public List<Notification> getAllNotifications();
	public boolean find(Notification notification); 
	public List<Notification> getNotificationOnSite(String sitename);
}
