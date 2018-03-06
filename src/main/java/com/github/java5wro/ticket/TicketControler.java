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

    public Set<TicketEntity> getTickets() {
        return new HashSet<>(service.findAll());
    }

    @GetMapping("byEmail/{email}")

    public Set<TicketEntity> getTicketsByEmail(@PathVariable String email) {
        return service.findByUser(userService.findByEmail(email).get());
    }

    @GetMapping("byUUID/{uuid}")

    public TicketEntity getTicketsByUUID(@PathVariable String uuid){
        return service.findByUUID(uuid);
    }

    @GetMapping("byEventName/{name}")

    public Set<TicketEntity> getTicketsByEventName(@PathVariable String name) {
        return service.findByEvent(eventService.toEntity(eventService.eventsByName(name).
                stream().filter(e->e.getName().equals(name)).findFirst().get()));
    }

    @PostMapping("/addTicket")
    @ResponseBody
    public void createTicket (TicketDTO ticketDTO){
        service.addNewTicket(ticketDTO);
    }

    @PostMapping("/editTicket/{uuid}")
    @ResponseBody
    public void editTicket (@PathVariable String uuid){
        service.edit(TicketMapper.toTicketDTO(service.findByUUID(uuid)));
    }

    @PostMapping("/removeTicket/{uuid}")
    @ResponseBody
    public void removeTicket (@PathVariable String uuid){
        service.remove(TicketMapper.toTicketDTO(service.findByUUID(uuid)));
    }


}
