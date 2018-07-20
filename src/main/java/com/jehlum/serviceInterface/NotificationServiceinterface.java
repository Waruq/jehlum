package com.jehlum.serviceInterface;

import java.util.List;

import com.jehlum.models.Notification;

public interface NotificationServiceinterface {

	public void save(Notification notification);
	public List<Notification> getAllNotifications();
	public boolean find(Notification notification); 
}
