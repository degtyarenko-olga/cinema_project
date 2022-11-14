package com.noirix.controller.controlleruser;

import com.noirix.controller.dto.ticket.TicketCreateRequest;
import com.noirix.entity.Ticket;
import com.noirix.entity.User;
import com.noirix.security.util.PrincipalUtil;
import com.noirix.service.MovieService;
import com.noirix.service.PlaceService;
import com.noirix.service.SessionService;
import com.noirix.service.TicketService;
import com.noirix.service.UserService;
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
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/tickets")
public class TicketsController {

    private final TicketService service;
    private final UserService userService;
    private final MovieService movieService;
    private final PlaceService placeService;
    private final SessionService sessionService;

    @Operation(summary = "Gets all tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tickets", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @GetMapping
    public ResponseEntity<Object> findAllTickets() {
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Gets all tickets by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tickets", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/users")
    public ResponseEntity<Object> findAllTicketsByUser(Principal principal) {
        String username = PrincipalUtil.getUsername(principal);
        User result = userService.findByLogin(username);
        return new ResponseEntity<>(service.findTicketByUserId(result.getId()), HttpStatus.OK);
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
    public ResponseEntity<Object> createTicket(@Valid @RequestBody TicketCreateRequest createRequest, Principal principal) {
        String username = PrincipalUtil.getUsername(principal);
        User result = userService.findByLogin(username);
        Ticket ticket = new Ticket();
        ticket.setUser((userService.findById(result.getId())));
        ticket.setMovie(movieService.findById(createRequest.getMovieId()));
        ticket.setDateOfPurchase(new Timestamp(new Date().getTime()));
        ticket.setPlace(placeService.findById(createRequest.getPlaceId()));
        ticket.setSession(sessionService.findById(createRequest.getSessionId()));
        return new ResponseEntity<>(service.create(ticket),HttpStatus.CREATED);
    }

}
