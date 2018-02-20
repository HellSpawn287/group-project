package com.github.java5wro.event;

import org.h2.engine.User;

import java.time.LocalDate;
import java.util.UUID;

public class EventDto {
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private String name;
    private LocalDate time;
    private String description;
    private Integer price;
    private User author;

    public EventDto(Long id, String uuid, String name, LocalDate time, String description, Integer price, User author) {
        this.id = id;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
