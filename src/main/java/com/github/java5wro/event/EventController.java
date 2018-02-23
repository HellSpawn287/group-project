package com.github.java5wro.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;

    @GetMapping("")
    public Set<EventDto> getEvents(){
        return new HashSet<>(eventService.findAllEvents());
    }
}