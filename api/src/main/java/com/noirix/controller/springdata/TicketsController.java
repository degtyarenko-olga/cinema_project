package com.noirix.controller.springdata;

import com.noirix.controller.requests.ticket.TicketCreateRequest;
import com.noirix.domain.TicketHibernate;
import com.noirix.domain.UsersHibernate;
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
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/tickets")
public class TicketsController {

    private final TicketService service;

    private final UserService userService;

    private final MovieService movieService;

    private final PlaceService placeService;

    private final SessionService sessionService;

    private final ConversionService converter;


    @Operation(summary = "Gets all tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tickets", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketHibernate.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllTickets() {

        return new ResponseEntity<>(
                Collections.singletonMap("tickets", service.findAllTickets()),
                HttpStatus.OK
        );
    }


    @Operation(summary = "Gets ticket by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found ticket", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketHibernate.class)))
                    })
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findTicketById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }


    @Operation(summary = "Delete ticket by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Ticket deleted",
                    content = @Content)
            })
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTicketById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
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
    public ResponseEntity<Object> create(@Valid @RequestBody TicketCreateRequest createRequest,
                                         Principal principal) {

        String username = PrincipalUtil.getUsername(principal);
        UsersHibernate result = userService.findByCredentialsLogin(username);

        Long id = result.getId();

        TicketHibernate ticket = new TicketHibernate();

        ticket.setUser((userService.findById(id)));
        ticket.setMovie(movieService.findById(createRequest.getMovieId()));
        ticket.setDateOfPurchase(new Timestamp(new Date().getTime()));
        ticket.setPlace(placeService.findById(createRequest.getPlaceId()));
        ticket.setSession(sessionService.findById(createRequest.getSessionId()));

       service.create(ticket);

        return new ResponseEntity<>(
                Collections.singletonMap("ticket", service.findById(ticket.getId())),
                HttpStatus.CREATED);
    }



}
