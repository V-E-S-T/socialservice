package com.socialserv.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "works")
public class Work {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "estimate_time", nullable = false)
    private int estimateTime; //minutes

    @Column(name = "specialization", nullable = false)
    private Specialization specialization;

    @Column(name = "registered", nullable = false)
    private LocalDateTime registered;

    public Work() {
    }

    public Work(Action action, LocalDateTime registered) {
        this.price = action.getPrice();
        this.description = action.getDescription();
        this.estimateTime = action.getEstimateTime();
        this.specialization = action.getSpecialization();
        this.registered = registered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;

        Work work = (Work) o;

        if (!getId().equals(work.getId())) return false;
        return getRegistered().equals(work.getRegistered());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getRegistered().hashCode();
        return result;
    }
}
