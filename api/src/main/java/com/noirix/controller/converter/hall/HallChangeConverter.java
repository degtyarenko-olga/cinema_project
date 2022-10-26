package com.noirix.controller.converter.hall;

import com.noirix.controller.requests.hall.HallChangeRequest;
import com.noirix.domain.HallHibernate;
import com.noirix.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HallChangeConverter implements Converter<HallChangeRequest, HallHibernate> {

    private HallService service;

    @Override
    public HallHibernate convert(HallChangeRequest source) {
        HallHibernate hall = service.findById(source.getId());
        return hall;
    }
}
