package com.usa.grupo13.proyectomoto.entities;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startDate;

    private String devolutionDate;

    private String client;

    private String motorbike;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(String motorbike) {
        this.motorbike = motorbike;
    }
}
