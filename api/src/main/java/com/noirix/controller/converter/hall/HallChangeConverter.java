package com.noirix.controller.converter.hall;

import com.noirix.controller.dto.hall.HallChangeRequest;
import com.noirix.entity.Hall;
import com.noirix.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HallChangeConverter implements Converter<HallChangeRequest, Hall> {
    private HallService service;

    @Override
    public Hall convert(HallChangeRequest source) {
        return service.findById(source.getId());

    }

}
