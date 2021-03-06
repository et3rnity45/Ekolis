package com.wildcodeschool.ekolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.ekolis.entities.Journey;
import com.wildcodeschool.ekolis.entities.Level;
import com.wildcodeschool.ekolis.repository.LevelRepository;
import com.wildcodeschool.ekolis.utils.FilterNode;

@Controller
public class ParcoursController {

	private FilterNode filterNode = new FilterNode();
	private Level level;
	private int globalEmission = 0;
	private int globalTime = 0;
	private int globalWalk = 0;
	
	@Autowired
	private LevelRepository levelRepository;
		
	@GetMapping("/parcours/{id}")
	public String toParcours(Model model, @PathVariable int id) {
		globalEmission = 0;
		globalTime = 0;
		globalWalk = 0;
		level = levelRepository.findById(id).get();
		List<Journey> journeys1 = filterNode.buildJourneys(level.getPos1(), level.getPos2());
		journeys1.add(new Journey("Voiture", 560, 130, 0, "voiture"));
		model.addAttribute("level", level);
		model.addAttribute("journeys1", journeys1);
		return "parcours1";
	}
	
	@PostMapping("/parcours/{id}")
	public String getAnswer1(Model model, @PathVariable int id, @RequestParam int emission, @RequestParam int time, @RequestParam int walk) {
		globalEmission += emission;
		globalTime += time;
		globalWalk += walk;
		return "redirect:/parcours/" + id + "/etape2";
	}
	
	@GetMapping("/parcours/{id}/etape2")
	public String toFirstEtape(Model model, @PathVariable int id) {
		List<Journey> journeys2 = filterNode.buildJourneys(level.getPos2(), level.getPos3());
		journeys2.add(new Journey("Voiture", 812, 502, 0, "voiture"));
		model.addAttribute("level", level);
		model.addAttribute("journeys2", journeys2);
		return "etape2";
	}
	
	@PostMapping("/parcours/{id}/etape2")
	public String getAnswer2(Model model, @PathVariable int id, @RequestParam int emission, @RequestParam int time, @RequestParam int walk) {
		globalEmission += emission;
		globalTime += time;
		globalWalk += walk;
		return "redirect:/parcours/" + id + "/etape3";
	}
	
	@GetMapping("/parcours/{id}/etape3")
	public String toSecondEtape(Model model, @PathVariable int id) {
		List<Journey> journeys3 = filterNode.buildJourneys(level.getPos3(), level.getPos4());
		journeys3.add(new Journey("Voiture", 680, 260, 0, "voiture"));
		model.addAttribute("level", level);
		model.addAttribute("journeys3", journeys3);
		return "etape3";
	}
	
	@PostMapping("/parcours/{id}/etape3")
	public String getAnswer3(Model model, @PathVariable int id, @RequestParam int emission, @RequestParam int time, @RequestParam int walk) {
		globalEmission += emission;
		globalTime += time;
		globalWalk += walk;
		return "redirect:/results";
	}
	
	@GetMapping("/results")
	public String toResult(Model model) {
		float resultEmission =(float) (2052 - globalEmission)/2052 * 10;
		int calories = globalWalk / 10;
		if (resultEmission > 5) {
			levelRepository.deleteById(2);
			levelRepository.save(new Level(2, "Niveau 2", "47.90701, 1.90576", "47.89098, 1.89761", "47.86642, 1.89823", "47.84567, 1.94082", true));
		}
		model.addAttribute("globalEmission", globalEmission);
		model.addAttribute("resultEmission", resultEmission);
		model.addAttribute("calories", calories);
		model.addAttribute("globalTime", globalTime);
		return "pageResultat";
	}
	
	@GetMapping("/parcours/2")
	public String toParcours2(Model model) {
		globalEmission = 0;
		globalTime = 0;
		globalWalk = 0;
		level = levelRepository.findByName("Niveau 2");
		List<Journey> journeys1 = filterNode.buildJourneys(level.getPos1(), level.getPos2());
		journeys1.add(new Journey("Voiture", 560, 130, 0, "voiture"));
		model.addAttribute("level", level);
		model.addAttribute("journeys1", journeys1);
		return "parcours2";
	}

}

