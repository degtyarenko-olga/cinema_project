package com.noirix.controller.converter.place;

import com.noirix.controller.dto.place.PlaceCreateRequest;
import com.noirix.entity.Place;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlaceCreateConverter implements Converter<PlaceCreateRequest, Place> {

    @Override
    public Place convert(PlaceCreateRequest source) {
        Place place = new Place();

        place.setPlace(source.getPlace());
        place.setIsAvailable(source.getIsAvailable());
        place.setRow(source.getRow());
        place.setPrice(source.getPrice());
        return place;
    }

}
