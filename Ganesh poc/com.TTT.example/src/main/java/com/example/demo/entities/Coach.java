package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Coach {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double height;
    private double weight;

    // Constructors
    public Coach() {}

    public Coach(int id, double height, double weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
	

}
