package com.noirix.controller.converter.hall;

import com.noirix.controller.dto.hall.HallCreateRequest;
import com.noirix.entity.Hall;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HallCreateConverter implements Converter<HallCreateRequest, Hall> {

    @Override
    public Hall convert(HallCreateRequest source) {
        Hall hall = new Hall();
        hall.setNameHall(source.getName());
        return hall;

    }

}
