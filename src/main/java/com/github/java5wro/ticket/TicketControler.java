package com.github.java5wro.ticket;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("byUUID")
    @ResponseBody
    public String getTickets(@PathVariable String uuid, Model model){
       // model.addAttribute("tickets", service.findByUUID());
        return "tickets";
    }


}
