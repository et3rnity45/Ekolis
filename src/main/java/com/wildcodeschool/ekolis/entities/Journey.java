package com.wildcodeschool.ekolis.entities;

public class Journey {
	
	private String transportType;
	private Integer emissionCo2;
	private Integer duration;
	private Integer walkDuration;
	private String type;
	
	public Journey(String transportType, Integer emissionCo2, Integer duration, Integer walkDuration, String type) {
		this.transportType = transportType;
		this.emissionCo2 = emissionCo2;
		this.duration = duration;
		this.walkDuration = walkDuration;
		this.type = type;
	}
	
	public Journey(String transportType, Integer emissionCo2, Integer walkDuration, String type) {
		this.transportType = transportType;
		this.emissionCo2 = emissionCo2;
		this.walkDuration = walkDuration;
		this.type = type;
	}
	
	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Integer getEmissionCo2() {
		return emissionCo2;
	}

	public void setEmissionCo2(Integer emissionCo2) {
		this.emissionCo2 = emissionCo2;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public Integer getWalkDuration() {
		return walkDuration;
	}

	public void setWalkDuration(Integer walkDuration) {
		this.walkDuration = walkDuration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
