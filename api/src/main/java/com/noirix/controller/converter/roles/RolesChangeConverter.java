package com.noirix.controller.converter.roles;

import com.noirix.controller.requests.roles.RolesChangeRequest;
import com.noirix.domain.RolesHibernate;
import com.noirix.domain.SystemRoles;
import com.noirix.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolesChangeConverter implements Converter<RolesChangeRequest, RolesHibernate> {

    private RolesService service;

    @Override
    public RolesHibernate convert(RolesChangeRequest source) {

        RolesHibernate roles = service.findById(source.getId());
        return roles;
    }
}
