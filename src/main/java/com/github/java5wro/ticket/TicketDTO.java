package com.github.java5wro.ticket;

import com.github.java5wro.event.EventEntity;

import java.time.LocalDate;

/**
 * Created by Lenovo on 2018-02-20.
 */
public class TicketDTO {

    private String uuid;
    private EventEntity eventEntity;
    private LocalDate purchaseDate;
    private Long owner;

    public TicketDTO() {
    }

    public TicketDTO(String uuid, EventEntity eventEntity, LocalDate purchaseDate, Long owner) {
        this.uuid = uuid;
        this.eventEntity = eventEntity;
        this.purchaseDate = purchaseDate;
        this.owner = owner;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EventEntity getEvent() {
        return eventEntity;
    }

    public void setEvent(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
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

    @Override
    public String toString() {
        return "TicketDTO{" +
                ", eventEntity=" + eventEntity +
                ", purchaseDate=" + purchaseDate +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketDTO ticketDTO = (TicketDTO) o;

        if (uuid != null ? !uuid.equals(ticketDTO.uuid) : ticketDTO.uuid != null) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
