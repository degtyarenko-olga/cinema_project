package com.noirix.service;

import com.noirix.domain.TicketHibernate;
import com.noirix.repository.TicketSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketSpringDataRepository repository;

    public Object findAllTickets() {
        return repository.findByHQLQuery();
    }

    public TicketHibernate findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Long delete(Long id) {

        repository.deleteById(id);

        return id;
    }
}
