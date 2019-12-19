package com.wildcodeschool.ekolis.entities;

public class Journey {
	
	private Integer emissionCo2;
	private String duration;
	private Integer distance;
	private Integer walkDuration;
	private String type;
	
	public Journey(Integer emissionCo2, String duration, Integer distance, Integer walkDuration, String type) {
		this.emissionCo2 = emissionCo2;
		this.duration = duration;
		this.distance = distance;
		this.walkDuration = walkDuration;
		this.type = type;
	}

	public Integer getEmissionCo2() {
		return emissionCo2;
	}

	public void setEmissionCo2(Integer emissionCo2) {
		this.emissionCo2 = emissionCo2;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
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
