package com.noirix.controller.converter.place;

import com.noirix.controller.dto.place.PlaceChangeRequest;
import com.noirix.entity.Place;
import com.noirix.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaceChangeConverter implements Converter<PlaceChangeRequest, Place> {
    private final PlaceService service;

    @Override
    public Place convert(PlaceChangeRequest source) {
        return service.findById(source.getId());

    }

}
