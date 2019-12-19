package com.wildcodeschool.ekolis.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.wildcodeschool.ekolis.entities.Journey;
import com.wildcodeschool.ekolis.service.ConnectApi;

public class FilterNode {

	private ConnectApi connectApi = new ConnectApi();
	
	public List<Journey> buildJourneys(String from, String to) {
		JsonNode jsonObject = connectApi.createRequest(from, to);
		List<Journey> journeys = new ArrayList<>();
		for (int i = 0; i < jsonObject.size(); i++) {
			Integer emissionCo2 = jsonObject.get(i).get("co2_emission").get("value").intValue();
			String duration = jsonObject.get(i).get("duration").toString();
			Integer distance = jsonObject.get(i).get("distances").get("walking").intValue();
			Integer walkDuration = jsonObject.get(i).get("durations").get("walking").intValue();
			String type = jsonObject.get(i).get("type").toString();
			journeys.add(new Journey(emissionCo2, duration, distance, walkDuration, type));
		}
		return journeys;
	}
	
}
