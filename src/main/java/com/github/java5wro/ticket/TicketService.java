package com.github.java5wro.ticket;

import com.github.java5wro.event.EventEntity;
import com.github.java5wro.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addNewTicket(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getUuid() == null, "If ticket is to be added, it needs it's id to be null but is %s.", ticketDTO.getUuid());
        ticketRepository.save(TicketMapper.toTicketEntity(ticketDTO));
    }

    public void edit(TicketDTO ticketDTO) {
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getUuid() != null, "If ticket is to be edited, it needs it's id to be set.");
        ticketRepository.save(TicketMapper.toTicketEntity(ticketDTO));
    }
    public void remove (TicketDTO ticketDTO){
        checkNotNull(ticketDTO, "Ticket to add cannot be null");
        checkArgument(ticketDTO.getUuid() != null, "If ticket is to be edited, it needs it's id to be set.");
        ticketRepository.delete(TicketMapper.toTicketEntity(ticketDTO));
    }

    public Set<TicketEntity> findAll() {
       return new HashSet<>(ticketRepository.findAll());
    }

    public TicketEntity findByUUID(String uuid){
        return ticketRepository.findAll().stream().filter(t->t.equals(uuid)).findFirst().get();
    }
    public Set<TicketEntity> findByUser(UserEntity user){
        HashSet<TicketEntity> set = new HashSet<>();
        for (TicketEntity temp:ticketRepository.findAll()) {
            if(temp.getOwner().equals(user))
                set.add(temp);
        }
        return set;
    }
    public Set<TicketEntity> findByEvent(EventEntity event){
        HashSet<TicketEntity> set = new HashSet<>();
        for (TicketEntity temp:ticketRepository.findAll()) {
            if(temp.getEvent().equals(event))
                set.add(temp);
        }
        return set;
    }


}
