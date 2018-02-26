package com.github.java5wro.ticket;


import com.github.java5wro.event.EventEntity;
import com.github.java5wro.user.model.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String uuid;
    @ManyToOne
    private EventEntity event;
    @NotNull
    private LocalDate purchaseDate;
    @ManyToOne
    private UserEntity owner;

    protected TicketEntity() {
    }


    public TicketEntity(Integer id, String uuid, EventEntity event, LocalDate purchaseDate, UserEntity owner) {
        this.id = id;
        this.uuid = uuid;
        this.event = event;
        this.purchaseDate = purchaseDate;
        this.owner = owner;
    }

    public TicketEntity(String uuid, EventEntity event, LocalDate purchaseDate, UserEntity owner) {
        this.uuid = uuid;
        this.event = event;
        this.purchaseDate = purchaseDate;
        this.owner = owner;
    }

    public TicketEntity(Integer id, String uuid, EventEntity event, LocalDate purchaseDate) {
        this.id = id;
        this.uuid = uuid;
        this.event = event;
        this.purchaseDate = purchaseDate;
    }

    public TicketEntity(Integer id, String uuid, EventEntity event, UserEntity owner) {
        this.id = id;
        this.uuid = uuid;
        this.event = event;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }
}
