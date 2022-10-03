package com.usa.grupo13.proyectomoto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startDate;

    private String devolutionDate;

    @ManyToOne
    @JoinColumn(name="motorbikeId")
    @JsonIgnoreProperties({"resevation"})
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({""})
    private Client client;

    @ManyToOne
    @JoinColumn(name="CategoryId")
    @JsonIgnoreProperties({""})
    private Category category;

    @ManyToOne
    @JoinColumn(name="messageId")
    @JsonIgnoreProperties({""})
    private Message message;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
