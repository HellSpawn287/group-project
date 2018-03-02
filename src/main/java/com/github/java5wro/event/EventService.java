package com.github.java5wro.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class EventService {
    private final EventRepository repository;

    @Autowired
    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    private EventDto toDto(EventEntity eventEntity) {
        return new EventDto(eventEntity.getId(), eventEntity.getUuid(), eventEntity.getName(), eventEntity.getTime(),
                eventEntity.getDescription(), eventEntity.getPrice(), eventEntity.getAuthor());
    }

    private EventEntity toEntity (EventDto eventDto) {
        return new EventEntity(eventDto.getUuid(), eventDto.getName(), eventDto.getTime(), eventDto.getDescription(),
            eventDto.getPrice(), eventDto.getAuthor());
    }

    private List<EventEntity> toEntity (List<EventDto> eventDtoList) {
        return eventDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    private List<EventDto> toDto (List<EventEntity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void addEvent (EventDto eventDto) {
        checkNotNull(eventDto, "Event cannot be null");
        checkArgument(eventDto.getId() == null, "If event is to be added, id has to be null");
        repository.save(toEntity(eventDto));
    }

    public List<EventDto> findAllEvents (){
        return toDto(repository.findAll());
    }

    public void deleteEvent (EventDto event) {
        checkNotNull(event,"Event does not exist");
        repository.delete(toEntity(event));
    }

    public void editEvent (EventDto event) {
        checkNotNull(event, "Event cannot be null");
        repository.save(toEntity(event));
    }

    public List<EventDto> allEventsByAuthor (Long author) {
        return toDto(repository.allEventsByAuthor(author));
    }

    public List<EventDto> eventsByName (String name) {
        return toDto(repository.eventsByName(name));
    }
}