package com.noirix.service.impl;

import com.noirix.entity.Session;
import com.noirix.repository.SessionSpringDataRepository;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionSpringDataRepository repository;

    @Override
    public List<Session> findAllSession() {
        return repository.findAllSession();

    }

    @Override
    public Session findById(Long sessionId) {
        return repository.findById(sessionId).orElseThrow(EntityNotFoundException::new);

    }

    @Transactional
    @Override
    public Session create(Session session) {
        return repository.save(session);

    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;

    }

    @Override
    @Transactional
    public Session update(Session session) {
        return repository.save(session);
    }

}
