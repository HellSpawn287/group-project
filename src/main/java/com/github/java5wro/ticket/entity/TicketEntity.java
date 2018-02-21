package com.github.java5wro.ticket.entity;

import com.github.java5wro.event.Event;
import com.github.java5wro.user.model.User;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TicketEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String uuid;
    @NotNull
    private Long event;
    @NotNull
    private LocalDate purchaseDate;
    @NotNull
    private Long owner;

    protected TicketEntity() {
    }

    public TicketEntity(String uuid, Long event, LocalDate purchaseDate, Long owner) {
        this.uuid = uuid;
        this.event = event;
        this.purchaseDate = purchaseDate;
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

    public Long getEvent() {
        return event;
    }

    public void setEvent(Long event) {
        this.event = event;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}
