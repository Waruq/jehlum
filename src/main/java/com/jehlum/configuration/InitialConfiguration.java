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
        Role role = new Role();
		role.setName("ADMIN");
		User user = new User();
		user.setEmail("admin@admin.com");
		user.setPassword("admin");
		user.setNumber("123456789");
		user.setName("admin");
		user.setRole(role);
		userservice.save(user);
	}
}
