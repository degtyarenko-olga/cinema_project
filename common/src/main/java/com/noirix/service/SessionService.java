package com.noirix.service;

import com.noirix.entity.Session;

import java.util.List;

public interface SessionService {

    List<Session> findAll();

    Session findById(Long sessionId);

    Session create(Session session);

    void delete(Long id);

    Session update(Session session);

}
