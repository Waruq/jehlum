package com.jehlum.controllers;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jehlum.models.Notification;
import com.jehlum.serviceInterface.NotificationServiceinterface;

@Controller
public class RecievingNotificationController {
	
	@Autowired
	private NotificationServiceinterface notificationservice;
	
	  @RequestMapping("/pullNotifications")
	   public String pullNotifications() {

			Document doc;
			try {
				System.err.println("conecting to jkssb");
				doc = Jsoup.connect("http://jkssb.nic.in/WriteReadData/File/Home.htm").get();
				Element content = doc.getElementById("notifications");
				Elements links = content.getElementsByTag("a");
				for (Element link : links) {
				    Notification notification = new Notification();
				    notification.setNotificationText(link.text());
				    notification.setNotificationUrl(link.absUrl("href"));
				    notification.setNotificationFetchedDate(new Date().toString());
				    notification.setNotificationFetchedSite("jkssb");
				    if(notificationservice.find(notification))
				        notificationservice.save(notification);
				    else {
				    	break;
				    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				System.err.println("conecting to jkpsc");
				doc = Jsoup.connect("http://jkpsc.nic.in/").get();
				Elements content = doc.getElementsByClass("whats-new");
				Elements links = content.get(0).getElementsByTag("a");
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedDate(new Date().toString());
					  notification.setNotificationFetchedSite("jkpsc");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			try {
				System.err.println("conecting to kashmiruniversity");
				doc = Jsoup.connect("http://kashmiruniversity.net").get();
				Element content = doc.getElementById("lstNewsAndAnnouncements");
				Elements links = content.getElementsByTag("a");
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedDate(new Date().toString());
					  notification.setNotificationFetchedSite("kashmiruniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			try {
				System.err.println("conecting to CU");
				doc = Jsoup.connect("https://www.cukashmir.ac.in/whats-new/View-all-whatsnew.aspx").get();
				Elements content = doc.getElementsByClass("innerlink");
				Elements links = content.get(0).getElementsByTag("a");
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedDate(new Date().toString());
					  notification.setNotificationFetchedSite("centraluniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			try {
				System.err.println("conecting to islamic university");
				doc = Jsoup.connect("http://www.iustlive.com/Index/Default.aspx").get();
				Element content = doc.getElementById("quicktabs-container-quicktabs");
				Elements links = content.getElementsByTag("a");
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedDate(new Date().toString());
					  notification.setNotificationFetchedSite("islamicuniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return "";
	   }
}
