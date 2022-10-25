package com.noirix.controller.converter.session;

import com.noirix.controller.requests.session.SessionChangeRequest;
import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.domain.SessionHibernate;
import com.noirix.repository.SessionSpringDataRepository;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionChangeConverter implements Converter<SessionChangeRequest, SessionHibernate> {

    private final SessionService service;

    @Override
    public SessionHibernate convert(SessionChangeRequest source) {

        SessionHibernate session = service.findById(source.getId());

        return session;
    }
}
