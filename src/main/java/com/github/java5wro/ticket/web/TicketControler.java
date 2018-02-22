package com.github.java5wro.ticket.web;

import com.github.java5wro.ticket.TicketService;
import com.github.java5wro.ticket.entity.TicketEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/api/ticket")
public class TicketControler {

    private final TicketService service;

    public TicketControler(TicketService service) {
        this.service = service;
    }

    @GetMapping(value = "/find")
    public List<TicketEntity> getTickets(){
        return service.findAll();
    }

        
}
