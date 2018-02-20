package com.github.java5wro.ticket.DTO;

import java.time.LocalDate;

/**
 * Created by Lenovo on 2018-02-20.
 */
public class TicketDTO {
    private Integer id;
    private String uuid;
    private Event event;
    private LocalDate purchaseDate;
    private User owner;

    public TicketDTO(Integer id, String uuid, Event event, LocalDate purchaseDate, User owner) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", event=" + event +
                ", purchaseDate=" + purchaseDate +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketDTO ticketDTO = (TicketDTO) o;

        if (id != null ? !id.equals(ticketDTO.id) : ticketDTO.id != null) return false;
        if (uuid != null ? !uuid.equals(ticketDTO.uuid) : ticketDTO.uuid != null) return false;
        if (event != null ? !event.equals(ticketDTO.event) : ticketDTO.event != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(ticketDTO.purchaseDate) : ticketDTO.purchaseDate != null)
            return false;
        return owner != null ? owner.equals(ticketDTO.owner) : ticketDTO.owner == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
