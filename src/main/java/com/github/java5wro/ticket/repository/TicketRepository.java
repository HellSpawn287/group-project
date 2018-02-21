package com.github.java5wro.ticket.repository;

import com.github.java5wro.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lenovo on 2018-02-20.
 */
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
