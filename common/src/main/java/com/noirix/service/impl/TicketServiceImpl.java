package com.noirix.service.impl;

import com.noirix.entity.Ticket;
import com.noirix.repository.TicketSpringDataRepository;
import com.noirix.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketSpringDataRepository repository;

    @Override
    public List<Ticket> findAllTickets() {
        return repository.findByHQLQuery();

    }

    @Override
    public Ticket findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Transactional
    @Override
    public Ticket create(Ticket ticket) {
        return repository.save(ticket);

    }

}
