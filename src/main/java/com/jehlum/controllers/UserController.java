package com.jehlum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jehlum.models.PostAdd;
import com.jehlum.models.User;
import com.jehlum.serviceInterface.AddServiceInterface;
import com.jehlum.serviceInterface.UserServiceInterface;

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	AddServiceInterface addservice;
	
	@Autowired
	UserServiceInterface userservice;
	
	@RequestMapping("/Dashboard")
	public String adminDashboard(Model model) {
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userservice.findByEmail(userDetails.getUsername());
		List<PostAdd> adds = addservice.getallAdds(user);
		model.addAttribute("adds", adds);
			return "userdashboard";
		}

	}

