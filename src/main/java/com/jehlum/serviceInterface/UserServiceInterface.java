package com.jehlum.serviceInterface;

import com.jehlum.models.Role;
import com.jehlum.models.User;

public interface UserServiceInterface {

	public boolean save(User user);
	public User findByEmail(String email);
	public Role findRole(String rolename);
}
