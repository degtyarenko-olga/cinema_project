package com.noirix.service;

import com.noirix.domain.RolesHibernate;
import com.noirix.repository.RolesSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesSpringDataRepository repository;

    public Object findAll() {
        return repository.findAll();
    }

    public Optional<RolesHibernate> findOne(long id) {
       return repository.findById(id);
    }

    public RolesHibernate findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Object findRoleByName(String roleName) {
        return repository.findRolesHibernateByRoleName(roleName);
    }

    @Transactional
    public Object create(RolesHibernate role) {
        return repository.save(role);

    }
}
