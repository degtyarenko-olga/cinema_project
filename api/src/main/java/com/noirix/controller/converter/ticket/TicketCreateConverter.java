package com.noirix.controller.converter.ticket;

import com.noirix.controller.dto.ticket.TicketCreateRequest;
import com.noirix.entity.Ticket;
import com.noirix.service.MovieService;
import com.noirix.service.PlaceService;
import com.noirix.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TicketCreateConverter implements Converter<TicketCreateRequest, Ticket> {
    private final MovieService movieServiceImpl;
    private final SessionService sessionServiceImpl;
    private final PlaceService placeServiceImpl;

    @Override
    public Ticket convert(TicketCreateRequest source) {
        Ticket ticket = new Ticket();

        ticket.setMovie(movieServiceImpl.findById(source.getMovieId()));
        ticket.setDateOfPurchase(new Timestamp(new Date().getTime()));
        ticket.setPlace(placeServiceImpl.findById(source.getPlaceId()));
        ticket.setSession(sessionServiceImpl.findById(source.getSessionId()));
        return ticket;

    }

}
