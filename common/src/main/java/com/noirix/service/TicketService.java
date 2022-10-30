package com.noirix.service;

import com.noirix.entity.Ticket;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {

    @Cacheable("tickets")
    List<Ticket> findAll();

    Ticket findById(Long id);

    Long delete(Long id);

    @Transactional
    Ticket create(Ticket ticket);

    @Transactional
    Ticket update(Ticket ticket);

    List<Ticket> findTicketByUserId(Long id);
}
