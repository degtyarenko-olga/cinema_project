package com.noirix.service;

import com.noirix.domain.RolesHibernate;
import com.noirix.repository.RolesSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesSpringDataRepository repository;

    public Object findAllCustom() {
        return repository.findAllCustom();
    }

    public Optional<RolesHibernate> findOne(long id) {
       return repository.findById(id);
    }
}
