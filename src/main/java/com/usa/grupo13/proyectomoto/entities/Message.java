package com.usa.grupo13.proyectomoto.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String messageText;

    @ManyToOne
    @JoinColumn(name="motorbikeId")
    @JsonIgnoreProperties({"messages"})
    private Moto moto;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties({"messages"})
    private Category category;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages"})
    private Client client;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;

    }

}




