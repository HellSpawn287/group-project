package com.github.java5wro.ticket;


import com.github.java5wro.user.model.UserMapper;
import com.github.java5wro.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/api/ticket")
public class TicketControler {

    private final TicketService service;
    private final UserService userService;

    public TicketControler(TicketService service, UserService userService) {
        this.service = service;
        this.userService=userService;
    }

    @GetMapping("all")
    @ResponseBody
    public Set<TicketEntity> getTickets() {
        return new HashSet<>(service.findAll());
    }

    @GetMapping("byEmail/{email}")
    @ResponseBody
    public Set<TicketEntity> getTickets(@PathVariable String email) {
        return service.findByUser(userService.findByEmail(email).get());
    }

    @GetMapping("byUUID")
    @ResponseBody
    public TicketEntity getTicketsByUUID(@PathVariable String uuid){
        return service.findByUUID(uuid);
    }


}
