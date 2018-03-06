package com.github.java5wro.ticket;

import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;

import java.util.Set;

/**
 * Created by Lenovo on 2018-02-28.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TicketMapper {

    TicketEntity toTicketEntity(TicketDTO ticketDTO);
    Set<TicketEntity> setToTicketEntity(TicketDTO ticketDTO);

    TicketDTO toTicketDTO(TicketEntity entity);
    Set<TicketDTO> setToTicketDTO(TicketEntity entity);
}
