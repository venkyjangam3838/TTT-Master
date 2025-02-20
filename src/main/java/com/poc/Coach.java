package com.poc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double height;
	private double weight;

	// Default Constructor
	public Coach() {
	}

	// Parameterized Constructor
	public Coach(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// toString Method
	@Override
	public String toString() {
		return "Coach{id=" + id + ", height=" + height + ", weight=" + weight + "}";
	}
}
