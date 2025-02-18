package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Customer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    private double height;
	    private double weight;

	    @ManyToOne
	    @JoinColumn(name = "coach_id", referencedColumnName = "id")
	    private Coach coach;

	    // Constructors
	    public Customer() {}

	    public Customer(int id, double height, double weight, Coach coach) {
	        this.id = id;
	        this.height = height;
	        this.weight = weight;
	        this.coach = coach;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
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

	    public Coach getCoach() {
	        return coach;
	    }

	    public void setCoach(Coach coach) {
	        this.coach = coach;
	    }

	    @Override
	    public String toString() {
	        return "Customer{" +
	                "id=" + id +
	                ", height=" + height +
	                ", weight=" + weight +
	                ", coach=" + coach +
	                '}';
	    }
	
}
