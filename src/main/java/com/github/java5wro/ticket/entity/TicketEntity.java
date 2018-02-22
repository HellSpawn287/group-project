package com.github.java5wro.ticket.entity;

import com.github.java5wro.event.Event;
import com.github.java5wro.user.model.User;
import java.time.LocalDate;

public class TicketEntity {

    private String uuid;

    private Event event;

    private LocalDate purchaseDate;

    private User owner;

    public TicketEntity(String uuid, Event event, LocalDate purchaseDate, User owner) {

        this.uuid = uuid;
        this.event = event;
        this.purchaseDate = purchaseDate;
        this.owner = owner;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}