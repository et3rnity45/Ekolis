package com.wildcodeschool.ekolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageResultController {

	@GetMapping("/results")
	public String toHome() {
		return "pageResultat";
	}
}
