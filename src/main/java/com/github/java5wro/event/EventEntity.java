package com.github.java5wro.event;

import com.github.java5wro.ticket.TicketEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    @NotBlank
    private String name;
    @NotBlank
    @Future
    private LocalDate time;
    @NotNull
    private String description;
    @NotBlank
    @Range(min = 0)
    private Integer price;
    @NotBlank
    @Length(min = 2)
    private Long author;
    @OneToMany (mappedBy = "event")
    private List<TicketEntity> participants;

    protected EventEntity() {
    }

    public EventEntity(String uuid, String name, LocalDate time, String description, Integer price, Long author) {
        this.uuid = uuid;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
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

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public List<TicketEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TicketEntity> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity eventEntity = (EventEntity) o;

        if (id != null ? !id.equals(eventEntity.id) : eventEntity.id != null) return false;
        if (uuid != null ? !uuid.equals(eventEntity.uuid) : eventEntity.uuid != null) return false;
        if (name != null ? !name.equals(eventEntity.name) : eventEntity.name != null) return false;
        if (time != null ? !time.equals(eventEntity.time) : eventEntity.time != null) return false;
        if (description != null ? !description.equals(eventEntity.description) : eventEntity.description != null) return false;
        if (price != null ? !price.equals(eventEntity.price) : eventEntity.price != null) return false;
        return author != null ? author.equals(eventEntity.author) : eventEntity.author == null;
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
}