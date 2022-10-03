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
    private Integer Año;

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




}
