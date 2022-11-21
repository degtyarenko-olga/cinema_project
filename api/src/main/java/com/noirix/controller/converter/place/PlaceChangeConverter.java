package com.noirix.controller.converter.place;

import com.noirix.controller.dto.place.PlaceChangeRequest;
import com.noirix.entity.Place;
import com.noirix.service.PlaceService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlaceChangeConverter implements Converter<PlaceChangeRequest, Place> {
    private final PlaceService service;

    public PlaceChangeConverter(PlaceService service) {
        this.service = service;
    }

    @Override
    public Place convert(PlaceChangeRequest source) {
        Place place = service.findById(source.getId());
        place.setPlace(source.getPlace());
        place.setIsAvailable(source.getIsAvailable());
        place.setRow(source.getRow());
        place.setPrice(source.getPrice());
        return place;
    }

}
