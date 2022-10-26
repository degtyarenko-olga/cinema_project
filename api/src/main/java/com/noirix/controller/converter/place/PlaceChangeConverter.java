package com.noirix.controller.converter.place;

import com.noirix.controller.requests.place.PlaceChangeRequest;
import com.noirix.domain.PlaceHibernate;
import com.noirix.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaceChangeConverter implements Converter<PlaceChangeRequest, PlaceHibernate> {

    private final PlaceService service;
    @Override
    public PlaceHibernate convert(PlaceChangeRequest source) {

        PlaceHibernate place = service.findById(source.getId());

        return place;
    }
}
