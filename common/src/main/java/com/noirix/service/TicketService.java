package com.noirix.service;

import com.noirix.entity.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTickets();

    Ticket findById(Long id);

    Long delete(Long id);

    @Transactional
    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);
}
