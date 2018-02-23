package com.github.java5wro.ticket;

import com.github.java5wro.email.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private JavaMailSender javaMailSender;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addNewTicket(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getUuid() == null, "If ticket is to be added, it needs it's id to be null but is %s.", ticketDTO.getUuid());
        ticketRepository.save(toEntity(ticketDTO));
    }

    public void edit(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getUuid() != null, "If ticket is to be edited, it needs it's id to be set.");
        ticketRepository.save(toEntity(ticketDTO));
    }

    private TicketEntity toEntity(TicketDTO ticketDTO) {
        return new TicketEntity(ticketDTO.getId(), ticketDTO.getUuid(), ticketDTO.getEvent(), ticketDTO.getPurchaseDate(), ticketDTO.getOwner());
    }

    private TicketDTO toTicketDTO(TicketEntity entity) throws IOException {

        EmailService email = new EmailService(javaMailSender);
        email.sendEmail(entity.getOwner().getName(), entity.getEvent().getName(), entity.getUuid(), entity.getEvent().getPrice().toString(), entity.getPurchaseDate().toString(), entity.getOwner().getEmail());

        return new TicketDTO(entity.getId(), entity.getUuid(), entity.getEvent(), entity.getPurchaseDate(), entity.getOwner());
    }

    public Set<TicketEntity> findAll() {
       return new HashSet<>(ticketRepository.findAll());
    }

    public TicketEntity findByUUID(String uuid){
        return ticketRepository.findAll().stream().filter(t->t.equals(uuid)).findFirst().get();
    }


}
