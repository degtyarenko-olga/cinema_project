package com.noirix.controller.converter.roles;

import com.noirix.controller.dto.roles.RolesChangeRequest;
import com.noirix.entity.Roles;
import com.noirix.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolesChangeConverter implements Converter<RolesChangeRequest, Roles> {
    private RolesService service;

    @Override
    public Roles convert(RolesChangeRequest source) {
        return service.findById(source.getId());

    }

}
