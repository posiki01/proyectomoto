package com.usa.grupo13.proyectomoto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private String startDate;

    private String devolutionDate;

    private String status;

    @ManyToOne
    //@JoinColumn(name="motorbike")
    @JsonIgnoreProperties({"reservations"})
    private Moto motorbike;

    @ManyToOne
    //@JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    private  String score;


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
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



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Moto getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Moto motorbike) {
        this.motorbike = motorbike;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
