package com.github.java5wro.ticket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/api/ticket")
public class TicketControler {

    private final TicketService service;

    public TicketControler(TicketService service) {
        this.service = service;
    }

    @GetMapping(value = "/find")
    public Set<TicketEntity> getTickets(){
        return new HashSet<>(service.findAll());
    }

        
}
