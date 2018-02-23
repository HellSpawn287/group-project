package com.github.java5wro.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService service;

    @GetMapping("")
    public Set<EventDto> getEvents() {
        return new HashSet<>(service.findAllEvents());
    }

    @PostMapping("/remove")
    public void removeEvent(EventDto eventDto) {
        service.deleteEvent(eventDto);
    }

    @PostMapping("/add")
    public void addEvent (EventDto eventDto) {
        service.addEvent(eventDto);
    }

    @PostMapping("/edit")
    public void editEvent (EventDto eventDto) {
        service.editEvent(eventDto);
    }
}