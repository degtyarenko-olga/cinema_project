package com.noirix.service;

import com.noirix.entity.Ticket;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    Ticket findById(Long id);

    void delete(Long id);

    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    List<Ticket> findTicketByUserId(Long id);

}
