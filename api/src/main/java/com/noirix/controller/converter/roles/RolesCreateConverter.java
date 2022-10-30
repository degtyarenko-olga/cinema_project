package com.noirix.controller.converter.roles;

import com.noirix.controller.dto.roles.RolesCreateRequest;
import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolesCreateConverter implements Converter<RolesCreateRequest, Roles> {

    @Override
    public Roles convert(RolesCreateRequest source) {
        Roles roles = new Roles();
        roles.setRoleName(SystemRoles.valueOf(source.getRolesName()));
        return roles;

    }

}
