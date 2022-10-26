package com.noirix.controller.converter.hall;

import com.noirix.controller.requests.hall.HallCreateRequest;
import com.noirix.domain.HallHibernate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HallCreateConverter implements Converter<HallCreateRequest, HallHibernate> {

    @Override
    public HallHibernate convert(HallCreateRequest source) {
        HallHibernate hall = new HallHibernate();
        hall.setNameHall(source.getName());
        return hall;
    }
}
