package com.wildcodeschool.ekolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String toHome() {
		return "home";
	}
	
	@GetMapping("/accueil")
	public String toAccueil() {
		return "accueil";
	}
}
