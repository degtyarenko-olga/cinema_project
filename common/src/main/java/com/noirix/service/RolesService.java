package com.noirix.service;

import com.noirix.entity.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> findAll();

    Roles findById(Long id);

    Roles create(Roles role);

    Roles update(Roles role);

}
