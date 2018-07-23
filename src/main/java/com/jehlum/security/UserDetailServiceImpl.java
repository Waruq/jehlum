package com.jehlum.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jehlum.daoInterface.UserDao;
import com.jehlum.models.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.err.println(email+"990099090990900990090909");
		User user = userDao.findByEmail(email);
		System.err.println(user);
		 if(user.equals(null)){
			    System.out.println("90090909090909090909090909 not found");
		        throw new UsernameNotFoundException("User not authorized.");
		    }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);	
     }

}
