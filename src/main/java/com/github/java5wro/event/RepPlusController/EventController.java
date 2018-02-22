package com.github.java5wro.event.RepPlusController;

import com.github.java5wro.event.model.Event;
import com.github.java5wro.event.model.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;

    @GetMapping
    public Set<Event> getEvents(){
    return new HashSet<>();      // zwraca JSona
    }


}