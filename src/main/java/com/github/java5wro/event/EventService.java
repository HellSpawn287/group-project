package com.github.java5wro.event;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    private EventDto toDto(Event event) {
        return new EventDto(event.getId(), event.getUuid(), event.getName(), event.getTime(),
                event.getDescription(), event.getPrice(), event.getAuthor());
    }

    private Event toEntity (EventDto eventDto) {
        return new Event(eventDto.getUuid(), eventDto.getName(), eventDto.getTime(), eventDto.getDescription(),
            eventDto.getPrice(), eventDto.getAuthor());
    }

    private List<Event> toEntity (List<EventDto> eventDtoList) {
        return eventDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    private List<EventDto> toDto (List<Event> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void addEvent (Event event) {
        checkNotNull(event, "Event cannot be null");
        checkArgument(event.getId() == null, "If event is to be added, id has to be null");
        repository.save(event);
    }

    public List<EventDto> findAll (){
        return toDto(repository.findAll());
    }

    public void delete (EventDto event) {
        checkNotNull(event,"Event does not exist");
        repository.delete(toEntity(event));
    }

    public void edit (EventDto event) {
        checkNotNull(event, "Event cannot be null");
        repository.save(toEntity(event));
    }
}