package com.github.java5wro.ticket;

import com.github.java5wro.ticket.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Lenovo on 2018-02-20.
 */
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    Set<TicketEntity> findAllByOwnerUuid(String uuid);
}
