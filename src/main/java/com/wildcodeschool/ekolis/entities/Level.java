package com.wildcodeschool.ekolis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String pos1;
	private String pos2;
	private String pos3;
	private String pos4;
	@Column(columnDefinition="tinyint(1)")
	private boolean isUnlock;
	
	public Level() {}
	
	public Level(Integer id, String name, String pos1, String pos2, String pos3, String pos4, boolean isUnlock) {
		this.id = id;
		this.name = name;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.pos3 = pos3;
		this.pos4 = pos4;
		this.isUnlock = isUnlock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos1() {
		return pos1;
	}

	public void setPos1(String pos1) {
		this.pos1 = pos1;
	}

	public String getPos2() {
		return pos2;
	}

	public void setPos2(String pos2) {
		this.pos2 = pos2;
	}

	public String getPos3() {
		return pos3;
	}

	public void setPos3(String pos3) {
		this.pos3 = pos3;
	}

	public String getPos4() {
		return pos4;
	}

	public void setPos4(String pos4) {
		this.pos4 = pos4;
	}

	public boolean isUnlock() {
		return isUnlock;
	}

	public void setUnlock(boolean isUnlock) {
		this.isUnlock = isUnlock;
	}
	
}
