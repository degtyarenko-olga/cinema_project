package com.noirix.service.impl;

import com.noirix.entity.Ticket;
import com.noirix.repository.TicketSpringDataRepository;
import com.noirix.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private static final Logger log = Logger.getLogger(TicketServiceImpl.class);
    private final TicketSpringDataRepository repository;

    @Override
    public List<Ticket> findAll() {
        return repository.findAll();

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

    @Override
    public Ticket create(Ticket ticket) {
        Ticket save = repository.save(ticket);
        log.info("Ticket create");
        return save;

    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket ticketCreate = create(ticket);
        log.info("Ticket update");
        return ticketCreate;

    }

    @Override
    public List<Ticket> findTicketByUserId(Long id) {
        return repository.findAllByUserId(id);
    }

}
