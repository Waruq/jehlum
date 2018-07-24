package com.jehlum.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jehlum.models.Notification;
import com.jehlum.serviceInterface.NotificationServiceinterface;

@Controller
public class RecievingNotificationController {
	
	@Autowired
	private NotificationServiceinterface notificationservice;
	
	
	@RequestMapping("/displayNotification")
	public String displayNotification(Model model) {
		model.addAttribute("JKSSB", notificationservice.getNotificationOnSite("jkssb"));
		model.addAttribute("JKPSC", notificationservice.getNotificationOnSite("jkpsc"));
		model.addAttribute("KashmirUniversity", notificationservice.getNotificationOnSite("kashmiruniversity"));
		model.addAttribute("CentralUniversity", notificationservice.getNotificationOnSite("centraluniversity"));
		model.addAttribute("IUST", notificationservice.getNotificationOnSite("islamicuniversity"));
		return "notification";
	}
	
	   @Scheduled(cron = "0 0 8/20 * * *")
	   public void pullNotifications() {

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
					  notification.setNotificationUrl(link.baseUri()+"/"+link.attr("href").substring(5));
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
			
		
	   }
	   
	   @RequestMapping("/pullNotifications")
	   public void pullNotificationsManually() {

			Document doc;
			
			try {
				 /*URL url = new URL("http://www.iustlive.com/Index/Default.aspx");
				 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http://www.iustlive.com/Index/Default.aspx", 8080)); // or whatever your proxy is
				  HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
				   
				  uc.connect();
				
				 String line = null;
				    StringBuffer tmp = new StringBuffer();
				    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				    while ((line = in.readLine()) != null) {
				    	System.err.println(line);
				      tmp.append(line);
				    }
				    
				   doc = Jsoup.parse(String.valueOf(tmp));
				   System.err.println(tmp);*/ 
				System.err.println("conecting to islamic university");

				System.setProperty("http.proxyHost", "192.168.5.1");
				System.setProperty("http.proxyPort", "1080");

				doc = Jsoup.connect("http://www.iustlive.com/Index/Default.aspx").timeout(0).get();
				Element content = doc.getElementById("quicktabs-container-quicktabs");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedSite("islamicuniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  islamic university----");
				e.printStackTrace();
			}
			try {
				System.err.println("conecting to jkssb");
				doc = Jsoup.connect("http://jkssb.nic.in/WriteReadData/File/Home.htm").get();
				Element content = doc.getElementById("notifications");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
				    Notification notification = new Notification();
				    notification.setNotificationText(link.text());
				    notification.setNotificationUrl(link.absUrl("href"));
				    notification.setNotificationFetchedSite("jkssb");
				    if(notificationservice.find(notification))
				        notificationservice.save(notification);
				    else {
				    	break;
				    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  jkssb----");
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
					  notification.setNotificationFetchedSite("jkpsc");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  jkpsc----");
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
					  notification.setNotificationUrl(link.baseUri()+"/"+link.attr("href").substring(5));
					  notification.setNotificationFetchedSite("kashmiruniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  kashmir university----");
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
					  notification.setNotificationFetchedSite("centraluniversity");
					  if(notificationservice.find(notification))
					        notificationservice.save(notification);
					    else {
					    	break;
					    }
				}
			} catch (IOException e) {
				System.err.println("----error in  cuk----");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

			
		
	   }
}
