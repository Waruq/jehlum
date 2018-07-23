package com.jehlum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@RequestMapping("/Dashboard")
	public String adminDashboard() {
		return "admindashboard";
	}

}
