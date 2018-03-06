package com.github.java5wro.ticket;

import com.github.java5wro.event.EventEntity;
import com.github.java5wro.ticket.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Lenovo on 2018-02-20.
 */
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
