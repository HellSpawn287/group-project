package com.github.java5wro.ticket;

/**
 * Created by Lenovo on 2018-02-28.
 */
public class TicketMapper {
    public static TicketEntity toTicketEntity(TicketDTO ticketDTO){
        return new TicketEntity(ticketDTO.getId(),ticketDTO.getUuid(),ticketDTO.getEvent(),ticketDTO.getPurchaseDate(),ticketDTO.getOwner());
    }
    public static TicketDTO toTicketDTO(TicketEntity entity){
        return new TicketDTO(entity.getId(), entity.getUuid(),entity.getEvent(),entity.getPurchaseDate(),entity.getOwner());
    }
}
