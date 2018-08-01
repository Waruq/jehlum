package com.jehlum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jehlum.models.Role;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.UserServiceInterface;

@Controller
public class RegistrationController {
	
	@Autowired
	UserServiceInterface userservice;
	
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(User user,Model model,@RequestParam("usertype") String usertype) {
		Role role =  userservice.findRole(usertype);
		user.setRole(role);
		if(userservice.save(user)) {
			model.addAttribute("success", "User Registered Successfully, You Can Login Now");
		}
		else {
			model.addAttribute("fail", "Email Address Already Exists,Please Register Using Another Email");
		 }
		return "index";
		
		
	}

}
