package com.github.java5wro.event;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> findAll (){
        return repository.findAll();
    }

    public void addEvent (Event event) {
        checkNotNull(event, "Event cannot be null");
        checkArgument(event.getId() == null, "If event is to be added, id has to be null");
        repository.save(event);
    }


}
