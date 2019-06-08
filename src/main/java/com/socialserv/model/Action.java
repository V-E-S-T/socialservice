package com.socialserv.model;

import java.io.Serializable;

public class Action implements Serializable {

    private int id;

    private int price;

    private String description;

    private int estimateTime; //minutes

    private Specialization specialization;

    public Action(int id, int price, String description, int estimateTime, Specialization specialization) {
        this.price = price;
        this.description = description;
        this.estimateTime = estimateTime;
        this.specialization = specialization;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
