package com.usa.grupo13.proyectomoto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jboss.logging.Messages;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "motorbike")
public class Moto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @JoinColumn(name = "year")
    private Integer año;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties({"motorbikes"})
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("motorbikes, messages")
    private List<Message> message;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("motorbikes, reservations")
    private List<Reservation> reservations;

    private String description;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        año= año;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
