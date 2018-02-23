package com.github.java5wro.ticket;

import java.time.LocalDate;

/**
 * Created by Lenovo on 2018-02-23.
 */
public class TicketForEmail {
    private String username;
    private String eventName;
    private String uuid;
    private String price;
    private LocalDate purchaseDate;
    private String email;

    public TicketForEmail(TicketDTO ticket) {
        this.username = ticket.getOwner().getName();
        this.eventName = ticket.getEvent().toString();
        this.uuid = ticket.getUuid();
        this.price = ticket.getEvent().getPrice().toString();
        this.purchaseDate = ticket.getPurchaseDate();
        this.email = ticket.getOwner().getEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
