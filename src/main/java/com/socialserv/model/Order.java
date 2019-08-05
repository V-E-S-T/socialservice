package com.socialserv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private int id;

    private int totalPrice;

    private String description;

    private List<Work> workList_bazovij = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Work> getWorkList_bazovij() {
        return workList_bazovij;
    }

    public void setWorkList_bazovij(List<Work> workList_bazovij) {
        this.workList_bazovij = workList_bazovij;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != order.getId()) return false;
        if (getTotalPrice() != order.getTotalPrice()) return false;
        if (getDescription() != null ? !getDescription().equals(order.getDescription()) : order.getDescription() != null)
            return false;
        return getWorkList_bazovij() != null ? getWorkList_bazovij().equals(order.getWorkList_bazovij()) : order.getWorkList_bazovij() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTotalPrice();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getWorkList_bazovij() != null ? getWorkList_bazovij().hashCode() : 0);
        return result;
    }
}
