package com.noirix.service;

import com.noirix.repository.springdata.RolesSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesSpringDataRepository repository;

    public Object findAllCustom() {
        return repository.findAllCustom();
    }
}
