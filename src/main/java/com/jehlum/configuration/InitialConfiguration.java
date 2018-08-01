package com.jehlum.configuration;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.jehlum.daoInterface.UserDao;
import com.jehlum.models.Role;
import com.jehlum.models.User;

@Component
public class InitialConfiguration {

  @Autowired
  private UserDao userservice;
	
  @EventListener
  @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event){
	  
	  //creating an admin
        Role adminrole = new Role();
        adminrole.setName("ADMIN");
		User user = new User();
		user.setEmail("admin@admin.com");
		user.setPassword("admin");
		user.setNumber("123456789");
		user.setName("admin");
		user.setRole(adminrole);
		userservice.save(user);
		
		 //creating a user
        Role userrole = new Role();
        userrole.setName("USER");
		User user1 = new User();
		user1.setEmail("test@test.com");
		user1.setPassword("test");
		user1.setNumber("123456789");
		user1.setName("user");
		user1.setRole(userrole);
		userservice.save(user1);
	}
}
