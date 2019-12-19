package com.wildcodeschool.ekolis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.ekolis.entities.Journey;
import com.wildcodeschool.ekolis.utils.FilterNode;

@Controller
public class TestController {

	private FilterNode filterNode = new FilterNode();
	
	@GetMapping("/journeys")
	public String toHome(Model model) {
		List<Journey> journeys = filterNode.buildJourneys("1.89514;47.89324", "1.90876;47.9115");
		model.addAttribute("journeys", journeys);
		return "home";
	}
}
