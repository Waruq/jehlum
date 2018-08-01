package com.jehlum.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jehlum.models.User;
import com.jehlum.serviceInterface.AddServiceInterface;

@Controller
public class HomeController {
	
	@Autowired
	AddServiceInterface addservice;
	
	@RequestMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("adds", addservice.getAllJobs());
		model.addAttribute("user", new User());
		return "index";
	}
	

}
