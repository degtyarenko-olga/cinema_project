package com.noirix.controller.converter.session;

import com.noirix.controller.dto.session.SessionCreateRequest;
import com.noirix.entity.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionCreateConverter implements Converter<SessionCreateRequest, Session> {

    @Override
    public Session convert(SessionCreateRequest source) {
        Session session = new Session();

        session.setEndOfSession(source.getEndOfSession());
        session.setSessionStart(source.getSessionStart());
        return session;

    }

}
