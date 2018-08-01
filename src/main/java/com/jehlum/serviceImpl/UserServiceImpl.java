package com.jehlum.serviceImpl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jehlum.daoInterface.UserDao;
import com.jehlum.models.Role;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.UserServiceInterface;


@Service
@Transactional
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
	
	public Role findRole(String rolename) {
		return userdao.findRole(rolename);
	}
}
