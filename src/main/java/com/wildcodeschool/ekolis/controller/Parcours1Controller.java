package com.wildcodeschool.ekolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Parcours1Controller {

		
		@GetMapping("/parcours1")
		public String parcours1() {
			
			return "parcours1";
		}
}

