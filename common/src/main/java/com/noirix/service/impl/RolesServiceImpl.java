package com.noirix.service.impl;

import com.noirix.entity.Roles;
import com.noirix.repository.RolesSpringDataRepository;
import com.noirix.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesSpringDataRepository repository;

    @Override
    public List<Roles> findAll() {
        return repository.findAll();

    }

    @Override
    public Roles findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    @Transactional
    public Roles create(Roles role) {
        return repository.save(role);

    }

    @Override
    public Roles update(Roles role) {
        return repository.save(role);
    }

}
