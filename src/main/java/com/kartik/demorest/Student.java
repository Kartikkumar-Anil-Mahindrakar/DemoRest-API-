package com.kartik.demorest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private int id;
	
	private String name;
	
	
	private int points;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public int getPoints() {
		return points;
	}
	
	@XmlAttribute
	public void setPoints(int points) {
		this.points = points;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", points=" + points + "]";
	}

	@XmlElement
	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
