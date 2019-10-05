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

    @Column(name = "id_work", nullable = false)
    private int id_Work;

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
        this.id_Work = action.getId();
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

    public int getId_Work() {
        return id_Work;
    }

    public void setId_Work(int id_Work) {
        this.id_Work = id_Work;
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

        if (getId_Work() != work.getId_Work()) return false;
        if (getPrice() != work.getPrice()) return false;
        if (getEstimateTime() != work.getEstimateTime()) return false;
        if (getId() != null ? !getId().equals(work.getId()) : work.getId() != null) return false;
        if (getSpecialization() != work.getSpecialization()) return false;
        return getRegistered() != null ? getRegistered().equals(work.getRegistered()) : work.getRegistered() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getId_Work();
        result = 31 * result + getPrice();
        result = 31 * result + getEstimateTime();
        result = 31 * result + (getSpecialization() != null ? getSpecialization().hashCode() : 0);
        result = 31 * result + (getRegistered() != null ? getRegistered().hashCode() : 0);
        return result;
    }

}
