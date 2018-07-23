package com.jehlum.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import com.jehlum.daoInterface.UserDao;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.UserServiceInterface;


public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserDao userdao;

	public boolean save(User user) {
	  return userdao.save(user);	
	}
	
	@Override
	public User findByEmail(String email) {
		return userdao.findByEmail(email);
	}
}
