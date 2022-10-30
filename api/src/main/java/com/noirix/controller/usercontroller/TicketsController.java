package com.noirix.controller.usercontroller;

import com.noirix.controller.dto.ticket.TicketCreateRequest;
import com.noirix.entity.Ticket;
import com.noirix.entity.User;
import com.noirix.security.util.PrincipalUtil;
import com.noirix.service.impl.MovieServiceImpl;
import com.noirix.service.impl.PlaceServiceImpl;
import com.noirix.service.impl.SessionServiceImpl;
import com.noirix.service.impl.TicketServiceImpl;
import com.noirix.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/tickets")
public class TicketsController {
    private final TicketServiceImpl service;
    private final UserServiceImpl userServiceImpl;
    private final MovieServiceImpl movieServiceImpl;
    private final PlaceServiceImpl placeServiceImpl;
    private final SessionServiceImpl sessionServiceImpl;

    @Operation(summary = "Gets all tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tickets", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllTickets() {
        return new ResponseEntity<>(
                Collections.singletonMap("tickets", service.findAll()),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets all tickets by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tickets", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/user/tickets")
    public ResponseEntity<Object> findAllTicketsByUser(Principal principal) {
        String username = PrincipalUtil.getUsername(principal);
        User result = userServiceImpl.findByLogin(username);
        Long id = result.getId();
        List<Ticket> ticketByUserId = service.findTicketByUserId(id);
        return new ResponseEntity<>(
                Collections.singletonMap("tickets", ticketByUserId),
                HttpStatus.OK);

    }

    @Operation(summary = "Create new ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @Transactional
    @PostMapping
    public ResponseEntity<Object> createTicket(@Valid @RequestBody TicketCreateRequest createRequest,
                                               Principal principal) {

        String username = PrincipalUtil.getUsername(principal);
        User result = userServiceImpl.findByLogin(username);
        Long id = result.getId();

        Ticket ticket = new Ticket();

        ticket.setUser((userServiceImpl.findById(id)));
        ticket.setMovie(movieServiceImpl.findById(createRequest.getMovieId()));
        ticket.setDateOfPurchase(new Timestamp(new Date().getTime()));
        ticket.setPlace(placeServiceImpl.findById(createRequest.getPlaceId()));
        ticket.setSession(sessionServiceImpl.findById(createRequest.getSessionId()));

        service.create(ticket);

        return new ResponseEntity<>(
                Collections.singletonMap("ticket", service.findById(ticket.getId())),
                HttpStatus.CREATED);

    }

}
