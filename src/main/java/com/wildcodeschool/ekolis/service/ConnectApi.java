package com.wildcodeschool.ekolis.service;

import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

public class ConnectApi {

	private String url = "https://api.navitia.io/v1";
	private String token = "a3653e1d-06a1-4edc-b768-c9bd561d3251";
	private JsonNode jsonObject;
	
	
	public JsonNode createUrl() {
		
		WebClient webClient = WebClient.create(url);
		Mono<String> call = webClient.get()
			      .uri(uriBuilder-> uriBuilder
			    		  .path("/coverage/{coverage}/journeys")
			              .queryParam("from", "1.63130;47.77787")
			              .queryParam("to", "1.90544;47.90806")
			              .build("fr-cen"))
			      .headers(headers -> headers.setBasicAuth(token, ""))
			      .retrieve()
			      .bodyToMono(String.class);
		String response = call.block();
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonObject = objectMapper.readTree(response).get("journeys");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
