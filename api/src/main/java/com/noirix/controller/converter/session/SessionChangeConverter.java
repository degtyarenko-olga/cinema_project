package com.noirix.controller.converter.session;

import com.noirix.controller.dto.session.SessionChangeRequest;
import com.noirix.entity.Session;
import com.noirix.service.SessionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionChangeConverter implements Converter<SessionChangeRequest, Session> {
    private final SessionService service;

    public SessionChangeConverter(SessionService service) {
        this.service = service;
    }

    @Override
    public Session convert(SessionChangeRequest source) {
        Session session =  service.findById(source.getId());
        session.setEndOfSession(source.getEndOfSession());
        session.setSessionStart(source.getSessionStart());
        return session;

    }

}
