package com.github.java5wro.event.model;

import com.github.java5wro.event.RepPlusController.EventDto;
import com.github.java5wro.event.RepPlusController.EventRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void findAllEvents (){
        return new repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private EventDto toDto(EventDto event) {
        return new EventDto(event.getId(), event.getUuid(), event.getName(), event.getTime(), event.getDescription(), event.getPrice(), event.getAuthor());
    }

    public void addEvent (Event event) {
        checkNotNull(event, "Event cannot be null");
        checkArgument(event.getId() == null, "If event is to be added, id has to be null");
        repository.save(event);
    }



}