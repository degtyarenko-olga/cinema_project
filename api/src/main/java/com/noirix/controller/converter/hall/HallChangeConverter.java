package com.noirix.controller.converter.hall;

import com.noirix.controller.dto.hall.HallChangeRequest;
import com.noirix.entity.Hall;
import com.noirix.service.HallService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HallChangeConverter implements Converter<HallChangeRequest, Hall> {
    private final HallService service;

    public HallChangeConverter(HallService service) {
        this.service = service;
    }

    @Override
    public Hall convert(HallChangeRequest source) {
        Hall hall = service.findById(source.getId());
        hall.setNameHall(source.getName());
        return hall;
    }

}
