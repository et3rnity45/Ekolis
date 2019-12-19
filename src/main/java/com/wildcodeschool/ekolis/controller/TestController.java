package com.wildcodeschool.ekolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wildcodeschool.ekolis.entities.Journey;
import com.wildcodeschool.ekolis.entities.Level;
import com.wildcodeschool.ekolis.repository.LevelRepository;
import com.wildcodeschool.ekolis.utils.FilterNode;

@Controller
public class TestController {

	private FilterNode filterNode = new FilterNode();
	
	@Autowired
	private LevelRepository levelRepository;
	
	@GetMapping("/journey/{id}")
	public String toHome(Model model, @PathVariable int id) {
		Level level = levelRepository.findById(id).get();
		List<Journey> journeys1 = filterNode.buildJourneys(level.getPos1(), level.getPos2());
		List<Journey> journeys2 = filterNode.buildJourneys(level.getPos2(), level.getPos3());
		List<Journey> journeys3 = filterNode.buildJourneys(level.getPos3(), level.getPos4());
		model.addAttribute("level", level);
		model.addAttribute("journeys1", journeys1);
		model.addAttribute("journeys2", journeys2);
		model.addAttribute("journeys3", journeys3);
		return "home";
	}
}
