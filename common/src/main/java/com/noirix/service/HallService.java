package com.noirix.service;

import com.noirix.domain.HallHibernate;
import com.noirix.repository.HallSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallSpringDataRepository repository;

    public Object findAllHall() {
        return repository.findAll();
    }

    public HallHibernate findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Object findHallByName(String name) {
        return repository.findHallHibernateByNameHall(name);
    }

    @Transactional
    public HallHibernate create(HallHibernate hallHibernate) {

        return repository.save(hallHibernate);

    }

    @Transactional
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }
}
