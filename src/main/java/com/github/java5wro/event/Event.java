package com.github.java5wro.event;

import com.github.java5wro.ticket.TicketEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String uuid = UUID.randomUUID().toString();
    @NotNull
    private String name;
    @NotNull
    private LocalDate time;
    @NotNull
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Long author;
    @OneToMany (mappedBy = "event")
    private List<TicketEntity> participants;

    protected Event() {
    }

    public Event(String uuid, String name, LocalDate time, String description, Integer price, Long author) {
        this.uuid = uuid;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
        this.author = author;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (uuid != null ? !uuid.equals(event.uuid) : event.uuid != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (time != null ? !time.equals(event.time) : event.time != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (price != null ? !price.equals(event.price) : event.price != null) return false;
        return author != null ? author.equals(event.author) : event.author == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}