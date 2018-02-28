package com.github.java5wro.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("")
    public Set<EventDto> getEvents() {
        return new HashSet<>(eventService.findAllEvents());
    }

    @PostMapping("/remove")
    public void removeEvent(EventDto eventDto) {
        eventService.deleteEvent(eventDto);
    }

    @PostMapping("/add")
    public void addEvent (EventDto eventDto) {
        eventService.addEvent(eventDto);
    }

    @PostMapping("/edit")
    public void editEvent (EventDto eventDto) {
        eventService.editEvent(eventDto);
    }
}