package com.noirix.service;

import com.noirix.entity.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SessionService {
    List<Session> findAllSession();

    Session findById(Long sessionId);

    @Transactional
    Session create(Session session);

    Long delete(Long id);

    Session update(Session session);
}
