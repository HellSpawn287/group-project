//package com.github.java5wro.ticket;
//
//import com.github.java5wro.ticket.DTO.TicketDTO;
//import com.github.java5wro.ticket.entity.TicketEntity;
//import com.github.java5wro.ticket.repository.TicketRepository;
//import org.springframework.stereotype.Service;
//
//import static com.google.common.base.Preconditions.checkArgument;
//import static com.google.common.base.Preconditions.checkNotNull;
//
//
//@Service
//public class TicketService {
//    private final TicketRepository ticketRepository;
//
//    public TicketService(TicketRepository ticketRepository) {
//        this.ticketRepository = ticketRepository;
//    }
//
//    public void addNewTicket(TicketDTO ticketDTO) {
//        checkNotNull(ticketDTO, "Ticket to add cannot be null");
//        checkArgument(ticketDTO.getId() == null, "If ticket is to be added, it needs it's id to be null but is %s.", ticketDTO.getId());
//        ticketRepository.save(toEntity(ticketDTO));
//    }
//
//    public void edit(TicketDTO ticketDTO) {
//        checkNotNull(ticketDTO, "Ticket to add cannot be null");
//        checkArgument(ticketDTO.getId() != null, "If ticket is to be edited, it needs it's id to be set.");
//        ticketRepository.save(toEntity(ticketDTO));
//    }
//
//    private TicketEntity toEntity(TicketDTO ticketDTO){
//        return new TicketEntity(ticketDTO.getId(), ticketDTO.getUuid(), ticketDTO.getEvent(), ticketDTO.getOwner(), ticketDTO.getPurchaseDate());
//    }
//
//    private TicketDTO toTicketDTO(TicketEntity entity){
//        return TicketDTO(entity.getId(), entity.getUuid(), entity.getEvent(), entity.getOwner(), entity.getPurchaseDate());
//    }
//
//
//
//
//}
