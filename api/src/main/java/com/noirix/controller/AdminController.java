package com.noirix.controller;

import com.noirix.service.HallService;
import com.noirix.service.MovieService;
import com.noirix.service.PlaceService;
import com.noirix.service.RolesService;
import com.noirix.service.SessionService;
import com.noirix.service.TicketService;
import com.noirix.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "ADMIN CONTROLLER")
public class AdminController {

    private final UserService service;

    private final ConversionService converter;

    private final MovieService movieService;

    private final SessionService sessionService;

    private final TicketService ticketService;

    private final PlaceService placeService;

    private final HallService hallService;

    private final RolesService rolesService;


}
