package com.noirix.controller.converter.roles;

import com.noirix.controller.requests.roles.RolesCreateRequest;
import com.noirix.domain.RolesHibernate;
import com.noirix.domain.SystemRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolesCreateConverter implements Converter<RolesCreateRequest, RolesHibernate> {


    @Override
    public RolesHibernate convert(RolesCreateRequest source) {

        RolesHibernate roles = new RolesHibernate();

        roles.setRoleName(SystemRoles.valueOf(source.getRolesName()));

        return roles;
    }
}
