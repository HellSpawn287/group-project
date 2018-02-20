package com.github.java5wro.ticket;

import com.github.java5wro.ticket.entity.TicketEntity;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addNewTicket(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getId() == null, "If ticket is to be added, it needs it's id to be null but is %s.", ticketDTO.getId());
        ticketRepository.save(toEntity(ticketDTO));
    }

    public void edit(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getId() != null, "If ticket is to be edited, it needs it's id to be set.");
        ticketRepository.save(toEntity(ticketDTO));
    }

    private TicketEntity toEntity(TicketDTO ticketDTO){
        return new TicketEntity(ticketDTO.getId(), ticketDTO.getName);
    }

    private TicketDTO toTicketDTO(TicketEntity entity){
        return TicketDTO(entity.getId(), entity.getName);
    }




}
