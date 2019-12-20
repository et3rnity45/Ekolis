package com.wildcodeschool.ekolis.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.wildcodeschool.ekolis.entities.Journey;
import com.wildcodeschool.ekolis.service.ConnectApi;

public class FilterNode {

	private ConnectApi connectApi = new ConnectApi();
	
	public List<Journey> buildJourneys(String from, String to) {
		String transportType = "";
		
		String[] parts = from.split(", ");
		String newFrom = parts[1] + ";" + parts[0];
		parts = to.split(", ");
		String newTo = parts[1] + ";" + parts[0];
		
		JsonNode jsonObject = connectApi.createRequest(newFrom, newTo);
		List<Journey> journeys = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (jsonObject.get(i).get("distances").get("bike").intValue() != 0) {
				transportType = "Vélo";
			} else if (jsonObject.get(i).get("co2_emission").get("value").intValue() != 0) {
				transportType = "Bus/Tram";
			} else {
				transportType = "Marche";
			}
			Integer emissionCo2 = jsonObject.get(i).get("co2_emission").get("value").intValue();
			Integer duration = jsonObject.get(i).get("duration").intValue();
			Integer walkDuration = jsonObject.get(i).get("durations").get("walking").intValue();
			String type = jsonObject.get(i).get("type").toString();
			journeys.add(new Journey(transportType, emissionCo2, duration, walkDuration, type));
		}
		journeys.add(new Journey("Voiture", 412, 502, 0, "voiture"));
		jsonObject = connectApi.createRequest2(newFrom, newTo);
		return journeys;
	}
	
}
