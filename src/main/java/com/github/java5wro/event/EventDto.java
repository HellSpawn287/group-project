package com.github.java5wro.event;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventDto {
    private Long id;
    private String uuid;
    private String name;
    private LocalDate time;
    private String description;
    private Integer price;
    private Long author;

    public EventDto(Long id, String uuid, String name, LocalDate time, String description, Integer price, Long author) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;
        this.author = author;
    }

    public EventDto(Long id, String uuid, String name, String description, Integer price, Long author) {
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

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDto eventDto = (EventDto) o;

        if (id != null ? !id.equals(eventDto.id) : eventDto.id != null) return false;
        if (uuid != null ? !uuid.equals(eventDto.uuid) : eventDto.uuid != null) return false;
        if (name != null ? !name.equals(eventDto.name) : eventDto.name != null) return false;
        if (time != null ? !time.equals(eventDto.time) : eventDto.time != null) return false;
        if (description != null ? !description.equals(eventDto.description) : eventDto.description != null)
            return false;
        if (price != null ? !price.equals(eventDto.price) : eventDto.price != null) return false;
        return author != null ? author.equals(eventDto.author) : eventDto.author == null;
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
        return "EventDto{" +
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
