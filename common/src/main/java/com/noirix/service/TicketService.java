package com.noirix.service;

import com.noirix.repository.TicketSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketSpringDataRepository repository;

    public Object findAllTickets() {
        return repository.findAllTickets();
    }

    public Object findTicketHibernatesById(Long id) {
        return repository.findTicketHibernatesById(id);
    }
}
