package com.noirix.controller.converter.ticket;

import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.controller.requests.ticket.TicketCreateRequest;
import com.noirix.domain.SessionHibernate;
import com.noirix.domain.TicketHibernate;
import com.noirix.service.MovieService;
import com.noirix.service.PlaceService;
import com.noirix.service.SessionService;
import com.noirix.service.TicketService;
import com.noirix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TicketCreateConverter implements Converter<TicketCreateRequest, TicketHibernate> {

    private final TicketService service;

    private final MovieService movieService;

    private final UserService userService;

    private final SessionService sessionService;

    private PlaceService placeService;

    @Override
    public TicketHibernate convert(TicketCreateRequest source) {

        TicketHibernate ticket = new TicketHibernate();

        //ticket.setUser(userService.findById(source.getUserId()));
        ticket.setMovie(movieService.findById(source.getMovieId()));
        ticket.setDateOfPurchase(new Timestamp(new Date().getTime()));
        ticket.setPlace(placeService.findById(source.getPlaceId()));
        ticket.setSession(sessionService.findById(source.getSessionId()));
        return ticket;
    }
}

