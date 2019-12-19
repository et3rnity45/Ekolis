package com.wildcodeschool.ekolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.wildcodeschool.ekolis.service.ConnectApi;

@Controller
public class TestController {

	private ConnectApi connectApi = new ConnectApi();
	
	@GetMapping("/")
	public String toHome() {
		JsonNode jsonNode = connectApi.createUrl();
		System.out.println(jsonNode);
		return "home";
	}
}
