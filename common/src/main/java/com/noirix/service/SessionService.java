package com.noirix.service;

import com.noirix.entity.Session;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SessionService {
    @Cacheable("sessions")
    List<Session> findAll();

    Session findById(Long sessionId);

    Session create(Session session);

    Long delete(Long id);

    Session update(Session session);
}
