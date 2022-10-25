package com.noirix.controller.converter.session;

import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.domain.MovieHibernate;
import com.noirix.domain.SessionHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionCreateConverter implements Converter<SessionCreateRequest, SessionHibernate> {


    @Override
    public SessionHibernate convert(SessionCreateRequest source) {

        SessionHibernate sessionHibernate = new SessionHibernate();

        sessionHibernate.setEndOfSession(source.getEndOfSession());
        sessionHibernate.setSessionStart(source.getSessionStart());

        return sessionHibernate;
    }
}
