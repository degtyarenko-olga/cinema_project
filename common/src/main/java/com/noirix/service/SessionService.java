package com.noirix.service;

import com.noirix.repository.SessionSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionSpringDataRepository repository;

    public Object findAllSession() {
        return repository.findAllSession();
    }

    public Object findById(Long sessionId) {
        return repository.findById(sessionId);
    }
}
