package com.noirix.controller.converter.place;

import com.noirix.controller.requests.place.PlaceChangeRequest;
import com.noirix.controller.requests.place.PlaceCreateRequest;
import com.noirix.domain.PlaceHibernate;
import com.noirix.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaceCreateConverter implements Converter<PlaceCreateRequest, PlaceHibernate> {

    @Override
    public PlaceHibernate convert(PlaceCreateRequest source) {

        PlaceHibernate place = new PlaceHibernate();

        place.setPlace(source.getPlace());
        place.setIsAvailable(source.getIsAvailable());
        place.setRow(source.getRow());
        place.setPrice(source.getPrice());

        return place;
    }
}
