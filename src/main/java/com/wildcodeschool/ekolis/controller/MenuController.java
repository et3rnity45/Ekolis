package com.wildcodeschool.ekolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.ekolis.repository.LevelRepository;

@Controller
public class MenuController {

	@Autowired
	private LevelRepository levelRepository;
	
	@GetMapping("/menu")
	public String toMenu(Model model) {
		model.addAttribute("level1", levelRepository.findByName("Niveau 1").isUnlock());
		model.addAttribute("level2", levelRepository.findByName("Niveau 2").isUnlock());
		model.addAttribute("level3", levelRepository.findByName("Niveau 3").isUnlock());
		return "menu";
	}
}
