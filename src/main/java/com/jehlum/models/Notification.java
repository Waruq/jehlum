package com.jehlum.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	@Lob
	public String notificationText;
	
	
	public String notificationUrl;
	

	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	public Date notificationFetchedDate;
	
	public String notificationFetchedSite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	

	public Date getNotificationFetchedDate() {
		return notificationFetchedDate;
	}

	public void setNotificationFetchedDate(Date notificationFetchedDate){
		this.notificationFetchedDate=notificationFetchedDate;
	}

	public String getNotificationFetchedSite() {
		return notificationFetchedSite;
	}

	public void setNotificationFetchedSite(String notificationFetchedSite) {
		this.notificationFetchedSite = notificationFetchedSite;
	}

	
	
	
	

}
