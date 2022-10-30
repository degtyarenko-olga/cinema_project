package com.noirix.service;

import com.noirix.entity.Roles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RolesService {
    List<Roles> findAll();

    Roles findById(Long id);

    @Transactional
    Roles create(Roles role);
}
