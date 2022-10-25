package com.noirix.service;

import com.noirix.domain.SessionHibernate;
import com.noirix.repository.SessionSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionSpringDataRepository repository;

    public Object findAllSession() {
        return repository.findAllSession();
    }

    public SessionHibernate findById(Long sessionId) {
        return repository.findById(sessionId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Object create(SessionHibernate session) {

        return  repository.save(session);

    }

    @Transactional
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }
}
