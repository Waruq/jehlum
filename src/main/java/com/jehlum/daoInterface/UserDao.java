package com.jehlum.daoInterface;

import com.jehlum.models.User;


public interface UserDao {

	public boolean save(User user);
	public User findByEmail(String email);
}
