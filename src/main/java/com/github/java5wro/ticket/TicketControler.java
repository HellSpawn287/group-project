package com.github.java5wro.ticket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/api/ticket")
public class TicketControler {

    private final TicketService service;

    public TicketControler(TicketService service) {
        this.service = service;
    }

    @GetMapping("all")
    @ResponseBody
    public Set<TicketEntity> getTickets() {
        return new HashSet<>(service.findAll());
    }

    @GetMapping("byEmail/{email}")
    @ResponseBody
    public TicketEntity getTickets(@PathVariable String email) {
        return service.findByUUID(email);
    }


}
