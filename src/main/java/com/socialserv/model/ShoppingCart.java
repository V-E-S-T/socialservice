package com.socialserv.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private int totalPrice;

    private String description;

    private List<Work> workList = new ArrayList<>();

    public ShoppingCart() {
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }

    public List<Work> deleteWork(int index){
        getWorkList().removeIf(work -> getWorkList().indexOf(work) == index);
        return getWorkList();
    }

    public List<Work> addWork(Work work){
        if (work != null) getWorkList().add(work);
        return getWorkList();
    }
}
