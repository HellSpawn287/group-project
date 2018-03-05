package com.github.java5wro.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("byAuthor/{author}")
    public Set<EventDto> getEventsByAuthor (@PathVariable Long author) {
        return new HashSet<>(eventService.allEventsByAuthor(author));
    }

    @GetMapping("byUuid/{uuid}")
    public EventDto getEventsByUuid (@PathVariable String uuid) {
        return eventService.eventsByUuid(uuid);
    }

    @GetMapping("byName/{name}")
    public Set<EventDto> getEventsByName (@PathVariable String name) {
        return new HashSet<>(eventService.eventsByName(name));
    }

    @GetMapping("")
    public Set<EventDto> getEvents() {
        return new HashSet<>(eventService.findAllEvents());
    }

    @PostMapping("/remove")
    public void removeEvent(EventDto eventDto) {
        eventService.deleteEvent(eventDto);
    }

    @PostMapping("/add")
    public void addEvent (@Valid EventDto eventDto) {
        eventService.addEvent(eventDto);
    }

    @PostMapping("/edit")
    public void editEvent (EventDto eventDto) {
        eventService.editEvent(eventDto);
    }
}