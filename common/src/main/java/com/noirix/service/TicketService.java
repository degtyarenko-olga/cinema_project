package com.noirix.service;

import com.noirix.repository.TicketSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketSpringDataRepository repository;

    public Object findAllTickets() {
        return repository.findByHQLQuery();
    }

    public Object findById(Long id) {
        return repository.findById(id);
    }
}
