package com.noirix.service;

import com.noirix.entity.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SessionService {
    @Cacheable("sessions")
    List<Session> findAll();

    Session findById(Long sessionId);

    @Transactional
    Session create(Session session);

    Long delete(Long id);

    @Transactional
    Session update(Session session);
}
