package com.github.java5wro.ticket;
import com.github.java5wro.event.Event;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
public class TicketEntity {
    @NotNull
    private String uuid;
    @NotNull
    private Event event;
    @NotNull
    private LocalDate purchaseDate;
    @NotNull
    private Long owner;
    protected TicketEntity() {
    }
    public TicketEntity(String uuid, Event event, LocalDate purchaseDate, Long owner) {
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
    public Long getOwner() {
        return owner;
    }
    public void setOwner(Long owner) {
        this.owner = owner;
    }
}