package com.github.java5wro.ticket;


import com.github.java5wro.event.EventService;
import com.github.java5wro.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/api/ticket")
public class TicketControler {

    private final TicketService service;
    private final UserService userService;
    private EventService eventService;

    public TicketControler(TicketService service, UserService userService, EventService eventService) {
        this.service = service;
        this.userService=userService;
        this.eventService = eventService;
    }

    @GetMapping("all")
    @ResponseBody
    public Set<TicketEntity> getTickets() {
        return new HashSet<>(service.findAll());
    }

    @GetMapping("byEmail/{email}")
    @ResponseBody
    public Set<TicketEntity> getTicketsByEmail(@PathVariable String email) {
        return service.findByUser(userService.findByEmail(email).get());
    }

    @GetMapping("byUUID/{uuid}")
    @ResponseBody
    public TicketEntity getTicketsByUUID(@PathVariable String uuid){
        return service.findByUUID(uuid);
    }

    @GetMapping("byEventName/{name}")
    @ResponseBody
    public Set<TicketEntity> getTicketsByEventName(@PathVariable String name) {
        return service.findByEvent(eventService.toEntity(eventService.eventsByName(name).
                stream().filter(e->e.getName().equals(name)).findFirst().get()));
    }

    @PostMapping("/addTicket")
    public void createTicket (TicketDTO ticketDTO){
        service.addNewTicket(ticketDTO);
    }

    @PostMapping("/editTicket/{uuid}")
    public void editTicket (@PathVariable String uuid){
        service.edit(TicketMapper.toTicketDTO(service.findByUUID(uuid)));
    }

    @PostMapping("/removeTicket/{uuid}")
    public void removeTicket (@PathVariable String uuid){
        service.remove(TicketMapper.toTicketDTO(service.findByUUID(uuid)));
    }


}
