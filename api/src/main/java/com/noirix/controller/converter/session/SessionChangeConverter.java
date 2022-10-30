package com.noirix.controller.converter.session;

import com.noirix.controller.dto.session.SessionChangeRequest;
import com.noirix.entity.Session;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionChangeConverter implements Converter<SessionChangeRequest, Session> {
    private final SessionService service;

    @Override
    public Session convert(SessionChangeRequest source) {
        return service.findById(source.getId());

    }

}
