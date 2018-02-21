package com.github.java5wro.event;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;

    @GetMapping
    public List<EventDto> getEvents(){
        List<EventDto> allEvents = new ArrayList<>();
        allEvents = eventService.findAll();
    return allEvents;      // zwraca JSona
    }


}
