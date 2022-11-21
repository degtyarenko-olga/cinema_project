package com.noirix.service.impl;

import com.noirix.entity.Session;
import com.noirix.repository.SessionSpringDataRepository;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SessionServiceImpl implements SessionService {

    private final SessionSpringDataRepository repository;

    @Override
    @Cacheable("sessions")
    public List<Session> findAll() {
        return repository.findAll();
    }

    @Override
    public Session findById(Long sessionId) {
        return repository.findById(sessionId).orElse(new Session());
    }

    @Override
    @Transactional
    public Session create(Session session) {
        return repository.save(session);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Session update(Session session) {
        return create(session);
    }

}
