
package com.jehlum.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jehlum.models.Notification;
import com.jehlum.serviceInterface.NotificationServiceinterface;
import com.jehlum.util.Constants;

@Controller
public class RecievingNotificationController{
	
	@Autowired
	private NotificationServiceinterface notificationservice;
	
	
	@RequestMapping("/displayNotification")
	public String displayNotification(Model model) {
		model.addAttribute("JKSSB", notificationservice.getNotificationOnSite(Constants.JKSSB));
		model.addAttribute("JKPSC", notificationservice.getNotificationOnSite(Constants.JKPSC));
		model.addAttribute("KashmirUniversity", notificationservice.getNotificationOnSite(Constants.KASHMIRUNIVERSITY));
		model.addAttribute("CentralUniversity", notificationservice.getNotificationOnSite(Constants.CENTRALUNIVERSITYKASHMIR));
		model.addAttribute("IUST", notificationservice.getNotificationOnSite(Constants.ISLAMICUNIVERSITY));
		model.addAttribute("SSC", notificationservice.getNotificationOnSite(Constants.SSC));
		model.addAttribute("CUJAMMU", notificationservice.getNotificationOnSite(Constants.CENTRALUNIVERSITYJAMMU));
		model.addAttribute("CLUJAMMU", notificationservice.getNotificationOnSite(Constants.CLUSTERUNIVERSITYJAMMU));
		model.addAttribute("CVPP", notificationservice.getNotificationOnSite(Constants.CVPPINDIA));
		model.addAttribute("DPSSRINAGAR", notificationservice.getNotificationOnSite(Constants.DPSSRINAGAR));
		model.addAttribute("GCETKASHMIR", notificationservice.getNotificationOnSite(Constants.GCETKASHMIR));
		model.addAttribute("JKBANK", notificationservice.getNotificationOnSite(Constants.JKBANK));
		model.addAttribute("JKBOPEE", notificationservice.getNotificationOnSite(Constants.JKBOPEE));
		model.addAttribute("JKBOSE", notificationservice.getNotificationOnSite(Constants.JKBOSE));
		model.addAttribute("JKRMSA", notificationservice.getNotificationOnSite(Constants.JKRMSA));
		model.addAttribute("NITSRINAGAR", notificationservice.getNotificationOnSite(Constants.NITSRINAGAR));
		model.addAttribute("SKIMS", notificationservice.getNotificationOnSite(Constants.SKIMS));
		model.addAttribute("SKUAST", notificationservice.getNotificationOnSite(Constants.SKUAST));
		model.addAttribute("SMVDU", notificationservice.getNotificationOnSite(Constants.SMVDU));
		model.addAttribute("UPSC", notificationservice.getNotificationOnSite(Constants.UPSC));
		return "notification";
	}
	
	   @Scheduled(cron = "0 0 8,20 * * ?")
	   public void pullNotifications() throws ParseException {

			Document doc;
			try {
				System.err.println("conecting to "+Constants.JKSSB);
				doc = Jsoup.connect("http://jkssb.nic.in/WriteReadData/File/Home.htm").get();
				Element content = doc.getElementById("notifications");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
				    Notification notification = new Notification();
				    notification.setNotificationText(link.text());
				    notification.setNotificationUrl(link.absUrl("href"));
				    notification.setNotificationFetchedSite(Constants.JKSSB);
					notification.setNotificationFetchedDate(new Date());
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
				System.err.println("conecting to "+Constants.JKPSC);
				doc = Jsoup.connect("http://jkpsc.nic.in/").get();
				Elements content = doc.getElementsByClass("whats-new");
				Elements links = content.get(0).getElementsByTag("a");
				
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedSite(Constants.JKPSC);
    				  notification.setNotificationFetchedDate(new Date());
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
				System.err.println("conecting to "+Constants.KASHMIRUNIVERSITY);
				doc = Jsoup.connect("http://kashmiruniversity.net").get();
				Element content = doc.getElementById("lstNewsAndAnnouncements");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.baseUri()+"/"+link.attr("href").substring(5));
					  notification.setNotificationFetchedSite(Constants.KASHMIRUNIVERSITY);
					  notification.setNotificationFetchedDate(new Date());
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
					  notification.setNotificationFetchedSite(Constants.CENTRALUNIVERSITYKASHMIR);
					  notification.setNotificationFetchedDate(new Date());
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
					  notification.setNotificationFetchedSite(Constants.ISLAMICUNIVERSITY);
					  notification.setNotificationFetchedDate(new Date());
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
				System.err.println("conecting to jammu central university");
				doc = Jsoup.connect("http://www.cujammu.ac.in//Default.aspx?option=article&type=single&id=30434&mnuid=21621&prvtyp=site&pos=Left").get();
				Elements content = doc.getElementsByClass("contents-main");
				Elements links = content.get(0).getElementsByTag("a");
				for (Element link : links) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.parent().text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.CENTRALUNIVERSITYJAMMU);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
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
				System.err.println("conecting to jkrmsa ");
				doc = Jsoup.connect("http://www.jkrmsa.com").get();
				Elements content = doc.getElementsByClass("features-tab-8");
				Elements links = content.get(1).getElementsByTag("a"); 
				for (Element link : links) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.parent().text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.JKRMSA);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
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
				System.err.println("conecting to smvdu ");
				doc = Jsoup.connect("http://www.smvdu.ac.in").get();
				Element content = doc.getElementById("myCarouselv");
				Elements links = content.getElementsByTag("a"); ;
				for (Element link : links) {
					System.err.println(link.text()+"-----------------"+link.absUrl("href"));
				}
				for (Element link : links) {
					if(!(link.absUrl("href").equals("#myCarouselv") || link.text().isEmpty())) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.parent().text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.SMVDU);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
					}
				}	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				   System.err.println("-------- conecting to ssc.nic.in -------");
				   doc = Jsoup.connect("https://ssc.nic.in/").get();
					Element content = doc.getElementById("forScrollNews");
					Elements links = content.getElementsByTag("a"); 

					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.SSC);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 try {
				   System.err.println("-------- conecting to clujammu -------");
				  doc = Jsoup.connect("http://www.clujammu.in/allnotifications.php").get();
					Elements content = doc.getElementsByClass("table");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.CLUSTERUNIVERSITYJAMMU);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to nitsri -------");
				  doc = Jsoup.connect("http://14.139.61.131/Finalss/").get();
					Elements content = doc.getElementsByClass("col-sm-4");

					for(int i=0;i<content.size();i++) {
						Elements links = content.get(i).getElementsByTag("a"); 
						for (Element link : links) {
							if(!link.text().isEmpty()){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.NITSRINAGAR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
						}
					}		
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to skims -------");
				   doc = Jsoup.connect("http://www.skims.ac.in/").get();
					Element content = doc.getElementById("lofarticlessroller64");
					Elements links = content.getElementsByTag("a"); 
					for (Element link : links) {
						if(!link.text().isEmpty()){
						  Notification notification = new Notification();
						  notification.setNotificationText(link.text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.SKIMS);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
									  
						 }

				 	  }
			 		} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to dpssrinagar -------");
				  doc = Jsoup.connect("http://www.dpssrinagar.com/careers/").get();
					Elements content = doc.getElementsByClass("table");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							if(!link.text().isEmpty()){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.attr("title"));
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.DPSSRINAGAR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to skuast -------");
				  doc = Jsoup.connect("http://skuast.org/site/Templates%20HTML/jobs.php").get();
					Elements content = doc.getElementsByClass("table-text");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							if(!(link.text().equals("(in .pdf)") || link.text().equals("(in .docx)"))){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.SKUAST);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
								
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to jkbose -------");
				   doc = Jsoup.connect("http://jkbose.jk.gov.in/jkboseresults.php").get();
					Elements content = doc.getElementsByAttribute("align");
					Elements links = content.get(0).getElementsByTag("a"); 

					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBOSE);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to gcetkashmir -------");
				   doc = Jsoup.connect("http://gcetkashmir.ac.in/information/career/").get();
					Elements content = doc.getElementsByClass("gdl-page-content");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.GCETKASHMIR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 
			 try {
				   System.err.println("-------- conecting to jkbank -------");
				   doc = Jsoup.connect("https://www.jkbank.com/others/common/jobs.php").get();
					Element content = doc.getElementById("accordion1_1");
					Elements links = content.getElementsByTag("blockquote"); 					
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.getElementsByTag("strong").get(0).text());
							  notification.setNotificationUrl(link.getElementsByTag("a").get(0).absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBANK);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			 try {
				   System.err.println("-------- conecting to upsc -------");
				   doc = Jsoup.connect("http://upsc.gov.in/recruitment/recruitment-advertisement").get();
					Elements content = doc.getElementsByClass("view-content");
					Elements links =  content.get(0).getElementsByTag("li"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.getElementsByTag("a").get(0).absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.UPSC);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}	
			 try {
				   System.err.println("-------- conecting to jkbopee -------");
				   doc = Jsoup.connect("http://jkbopee.gov.in/").get();
					Element content = doc.getElementById("Div1");
					Elements links =  content.getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBOPEE);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}	
			 
			 try {
				   System.err.println("-------- conecting to cvppindia -------");
				   doc = Jsoup.connect("https://www.cvppindia.com/topnews.aspx").get();
					Element content = doc.getElementById("lbldata");
					Elements links =  content.getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.CVPPINDIA);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
				}
					
				
	   }
	   
	   
	   @RequestMapping(value="/newurl",method=RequestMethod.GET)
	   public void newUrl() throws ParseException { 
		   
		   Document doc = null;
		   try {
			   System.err.println("-------- conecting to skuastkashmir -------");
			  doc = Jsoup.connect("http://skuastkashmir.net/").get();
			  System.err.println(Jsoup.connect("http://skuastkashmir.net/").get());
			  System.err.println(doc+"--doc");
				Elements content = doc.getElementsByClass("content-block");
				System.err.println(content.size()+"--size");
				//Elements links = content.get(0).getElementsByTag("a"); 
				for(int i=0;i<content.size();i++) {
					Elements links = content.get(i).getElementsByTag("a"); 
					for (Element link : links) {
						if(!link.text().isEmpty())
							System.err.println(link.attr("title")+"-----------------"+link.absUrl("href"));
					}
				}
				/*for(int i=0;i<content.size();i++) {
					Elements links = content.get(i).getElementsByTag("a"); 
					for (Element link : links) {
						if(!link.text().isEmpty()){
						  Notification notification = new Notification();
						  notification.setNotificationText(link.text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite("dpssrinagar");
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
						}		  
					}
				}		*/
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
				
	}
	   
	   @RequestMapping("/pullNotifications")
	   public void pullNotificationsManually() throws ParseException{

			Document doc;
			
			try {
				 
				System.err.println("conecting to islamic university");

				doc = Jsoup.connect("http://www.iustlive.com/Index/Default.aspx").timeout(0).get();
				Element content = doc.getElementById("quicktabs-container-quicktabs");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedSite(Constants.ISLAMICUNIVERSITY);
					  notification.setNotificationFetchedDate(getIndianDate(new Date()));

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
				System.err.println("conecting to "+Constants.JKSSB);
				doc = Jsoup.connect("http://jkssb.nic.in/WriteReadData/File/Home.htm").get();
				Element content = doc.getElementById("notifications");
				Elements links = content.getElementsByTag("a");
				
				for (Element link : links) {
				    Notification notification = new Notification();
				    notification.setNotificationText(link.text());
				    notification.setNotificationUrl(link.absUrl("href"));
				    notification.setNotificationFetchedSite(Constants.JKSSB);
				    notification.setNotificationFetchedDate(getIndianDate(new Date()));
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
				System.err.println("conecting to "+Constants.JKPSC);
				doc = Jsoup.connect("http://jkpsc.nic.in/").get();
				Elements content = doc.getElementsByClass("whats-new");
				Elements links = content.get(0).getElementsByTag("a");
				
				for (Element link : links) {
					  Notification notification = new Notification();
					  notification.setNotificationText(link.text());
					  notification.setNotificationUrl(link.absUrl("href"));
					  notification.setNotificationFetchedSite(Constants.JKPSC);
					  notification.setNotificationFetchedDate(getIndianDate(new Date()));

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
					  notification.setNotificationFetchedSite(Constants.KASHMIRUNIVERSITY);
					  notification.setNotificationFetchedDate(getIndianDate(new Date()));

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
					  notification.setNotificationFetchedSite(Constants.CENTRALUNIVERSITYKASHMIR);
					  notification.setNotificationFetchedDate(getIndianDate(new Date()));

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
			
			try {
				System.err.println("conecting to jammu central university");
				doc = Jsoup.connect("http://www.cujammu.ac.in//Default.aspx?option=article&type=single&id=30434&mnuid=21621&prvtyp=site&pos=Left").get();
				Elements content = doc.getElementsByClass("contents-main");
				Elements links = content.get(0).getElementsByTag("a");
				for (Element link : links) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.parent().text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.CENTRALUNIVERSITYJAMMU);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
					}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  jammu central university----");

				e.printStackTrace();
			}
			
			try {
				System.err.println("conecting to jkrmsa ");
				doc = Jsoup.connect("http://www.jkrmsa.com").get();
				Elements content = doc.getElementsByClass("features-tab-8");
				Elements links = content.get(1).getElementsByTag("a"); 
				for (Element link : links) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.parent().text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.JKRMSA);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
					}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("----error in  jkrmsa----");

				e.printStackTrace();
			}
			
			try {
				System.err.println("conecting to smvdu ");
				doc = Jsoup.connect("http://www.smvdu.ac.in").get();
				Element content = doc.getElementById("myCarouselv");
				Elements links = content.getElementsByTag("a"); 
				for (Element link : links) {
					if(!(link.absUrl("href").contains("#myCarouselv")||link.text().isEmpty())) {
						  Notification notification = new Notification();
						  notification.setNotificationText(link.text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.SMVDU);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
					}
				}	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block'
				System.err.println("----error in  smvdu----");

				e.printStackTrace();
			}

			
			try {
				   System.err.println("-------- conecting to ssc.nic.in -------");
				   doc = Jsoup.connect("https://ssc.nic.in/").get();
					Element content = doc.getElementById("forScrollNews");
					Elements links = content.getElementsByTag("a"); 

					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.SSC);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("----error in  ssc----");
					e.printStackTrace();

				}
			 try {
				   System.err.println("-------- conecting to clujammu -------");
				  doc = Jsoup.connect("http://www.clujammu.in/allnotifications.php").get();
					Elements content = doc.getElementsByClass("table");
					Elements links = content.get(0).getElementsByTag("a"); 

					for (Element link : links) {
						if(!(link.text().isEmpty() || link.absUrl("href").isEmpty())) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.CLUSTERUNIVERSITYJAMMU);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
						}
					}	
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("----error in  cluster university jammu----");
					e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to nitsri -------");
				  doc = Jsoup.connect("http://14.139.61.131/Finalss/").get();
					Elements content = doc.getElementsByClass("col-sm-4");

					for(int i=0;i<content.size();i++) {
						Elements links = content.get(i).getElementsByTag("a"); 
						for (Element link : links) {
							if(!link.text().isEmpty()){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.NITSRINAGAR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
						}
					}		
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("----error in  nit srinagar----");
					e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to skims -------");
				   doc = Jsoup.connect("http://www.skims.ac.in/").get();
					Element content = doc.getElementById("lofarticlessroller64");
					Elements links = content.getElementsByTag("a"); 
					for (Element link : links) {
						if(!link.text().isEmpty()){
						  Notification notification = new Notification();
						  notification.setNotificationText(link.text());
						  notification.setNotificationUrl(link.absUrl("href"));
						  notification.setNotificationFetchedSite(Constants.SKIMS);
						  notification.setNotificationFetchedDate(getIndianDate(new Date()));
						  if(notificationservice.find(notification))
						        notificationservice.save(notification);
						    else {
						    	break;
						  }
									  
						 }

				 	  }
			 		} catch (IOException e) {
					// TODO Auto-generated catch block
			 			System.err.println("----error in  skims----");
						e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to dpssrinagar -------");
				  doc = Jsoup.connect("http://www.dpssrinagar.com/careers/").get();
					Elements content = doc.getElementsByClass("table");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							if(!link.text().isEmpty()){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.attr("title"));
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.DPSSRINAGAR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("----error in  dps----");
					e.printStackTrace();
				}
					
			 try {
				   System.err.println("-------- conecting to skuast -------");
				  doc = Jsoup.connect("http://skuast.org/site/Templates%20HTML/jobs.php").get();
					Elements content = doc.getElementsByClass("table-text");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							if(!(link.text().equals("(in .pdf)") || link.text().equals("(in .docx)"))){
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.SKUAST);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
							}		  
								
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("----error in  skuast----");
					e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to jkbose -------");
				   doc = Jsoup.connect("http://jkbose.jk.gov.in/jkboseresults.php").get();
					Elements content = doc.getElementsByAttribute("align");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBOSE);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
	     			System.err.println("----error in  jkbose----");
					e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to gcetkashmir -------");
				   doc = Jsoup.connect("http://gcetkashmir.ac.in/information/career/").get();
					Elements content = doc.getElementsByClass("gdl-page-content");
					Elements links = content.get(0).getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.GCETKASHMIR);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
	     			System.err.println("----error in  gcetkashmir----");
					e.printStackTrace();
				}
			 
			 try {
				   System.err.println("-------- conecting to jkbank -------");
				   doc = Jsoup.connect("https://www.jkbank.com/others/common/jobs.php").get();
					Element content = doc.getElementById("accordion1_1");
					Elements links = content.getElementsByTag("blockquote"); 					
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.getElementsByTag("strong").get(0).text());
							  notification.setNotificationUrl(link.getElementsByTag("a").get(0).absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBANK);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
	     			System.err.println("----error in  jkbank----");
					e.printStackTrace();
				}
					
			 try {
				   System.err.println("-------- conecting to upsc -------");
				   doc = Jsoup.connect("http://upsc.gov.in/recruitment/recruitment-advertisement").get();
					Elements content = doc.getElementsByClass("view-content");
					Elements links =  content.get(0).getElementsByTag("li"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.getElementsByTag("a").get(0).absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.UPSC);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
	     			System.err.println("----error in  upsc----");
					e.printStackTrace();
				}		
					
			 try {
				   System.err.println("-------- conecting to jkbopee -------");
				   doc = Jsoup.connect("http://jkbopee.gov.in/").get();
					Element content = doc.getElementById("Div1");
					Elements links =  content.getElementsByTag("a"); 
					
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.JKBOPEE);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block
	     			System.err.println("----error in  jkbopee----");
					e.printStackTrace();
				}	
			 
			 try {
				   System.err.println("-------- conecting to cvppindia -------");
				   doc = Jsoup.connect("https://www.cvppindia.com/topnews.aspx").get();
					Element content = doc.getElementById("lbldata");
					Elements links =  content.getElementsByTag("a"); 
					for (Element link : links) {
							  Notification notification = new Notification();
							  notification.setNotificationText(link.text());
							  notification.setNotificationUrl(link.absUrl("href"));
							  notification.setNotificationFetchedSite(Constants.CVPPINDIA);
							  notification.setNotificationFetchedDate(getIndianDate(new Date()));
							  if(notificationservice.find(notification))
							        notificationservice.save(notification);
							    else {
							    	break;
							  }
					}		  
	     		} catch (IOException e) {
					// TODO Auto-generated catch block'
	     			System.err.println("----error in  cvppindia----");
					e.printStackTrace();
				}
				
	   }
	   public Date getIndianDate(Date notificationFetchedDate) throws ParseException {
			SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String date = sdf.format(notificationFetchedDate);
			return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").parse(date);
	   }
	   
}


