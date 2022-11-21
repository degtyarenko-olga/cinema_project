package com.noirix.controller.controlleradmin;

import com.noirix.controller.dto.hall.HallChangeRequest;
import com.noirix.controller.dto.hall.HallCreateRequest;
import com.noirix.controller.dto.movie.MovieChangeRequest;
import com.noirix.controller.dto.movie.MovieCreateRequest;
import com.noirix.controller.dto.place.PlaceChangeRequest;
import com.noirix.controller.dto.place.PlaceCreateRequest;
import com.noirix.controller.dto.session.SessionChangeRequest;
import com.noirix.controller.dto.session.SessionCreateRequest;
import com.noirix.controller.dto.ticket.TicketChangeRequest;
import com.noirix.entity.Hall;
import com.noirix.entity.Movie;
import com.noirix.entity.Place;
import com.noirix.entity.Session;
import com.noirix.entity.Ticket;
import com.noirix.entity.User;
import com.noirix.service.HallService;
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
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "ADMIN controller")
public class AdminController {

    private final UserService service;
    private final ConversionService converter;
    private final MovieService movieService;
    private final SessionService sessionService;
    private final TicketService ticketService;
    private final PlaceService placeService;
    private final HallService hallService;

    @Operation(summary = "Gets all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the users", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/users")
    public ResponseEntity<Object> findAllUsers() {
        return new ResponseEntity<>(Collections.singletonMap("result",service.findAll()), HttpStatus.OK);
    }

    @Operation(summary = "Delete user by ID",
            responses = {@ApiResponse(responseCode = "200", description = "User deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUsersById(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>("user deleted successful!", HttpStatus.OK);
    }

    @Operation(summary = "Gets user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(Collections.singletonMap("user", service.findById(id)),HttpStatus.OK);
    }

    @Operation(summary = "Gets user by login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/users/{login}")
    public ResponseEntity<Object> findUserByLogin(@PathVariable String login) {
        return new ResponseEntity<>(Collections.singletonMap("user",service.findByLogin(login)), HttpStatus.OK);
    }

    @Operation(summary = "Gets hall by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Hall.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/halls/{id}")
    public ResponseEntity<Object> findHallById(@PathVariable Long id) {
        return new ResponseEntity<>(Collections.singletonMap("hall", hallService.findById(id)),HttpStatus.OK);
    }

    @Operation(summary = "Create new hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hall created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/hall")
    public ResponseEntity<Object> createHall(@Valid @RequestBody HallCreateRequest createRequest) {
        Hall hall = converter.convert(createRequest, Hall.class);
        return new ResponseEntity<>(hallService.create(hall),HttpStatus.CREATED);
    }

    @Operation(summary = "Delete hall by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Hall deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/halls/{id}")
    public ResponseEntity<Object> deleteHallById(@PathVariable Long id) {
        hallService.delete(id);
        return new ResponseEntity<>("hall deleted successful!", HttpStatus.OK);
    }

    @Operation(summary = "Gets movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Movie.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/movies/{id}")
    public ResponseEntity<Object> findMovieById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(Collections.singletonMap("result", movieService.findById(id)), HttpStatus.OK);
    }

    @Operation(summary = "Create new movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/movie")
    public ResponseEntity<Object> createMovie(@Valid @RequestBody MovieCreateRequest createRequest) {
        Movie movie = converter.convert(createRequest, Movie.class);
        return new ResponseEntity<>(movieService.create(movie),HttpStatus.CREATED);
    }

    @Operation(summary = "Delete movie by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Movie deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable Long id) {
        movieService.delete(id);
        return new ResponseEntity<>("movie deleted successful!,", HttpStatus.OK);
    }

    @Operation(summary = "Gets place by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found place", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Place.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/places/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(placeService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete place by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Place deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/places/{id}")
    public ResponseEntity<Object> deletePlaceById(@PathVariable Long id) {
        placeService.delete(id);
        return new ResponseEntity<>("place deleted successful!", HttpStatus.OK);
    }

    @Operation(summary = "Create new place")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Place created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/place")
    public ResponseEntity<Object> createPlace(@Valid @RequestBody PlaceCreateRequest createRequest) {
        Place place = converter.convert(createRequest, Place.class);
        return new ResponseEntity<>(placeService.create(place),HttpStatus.CREATED);
    }

    @Operation(summary = "Update place")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Place update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/place")
    public ResponseEntity<Object> updatePlace(@Valid @RequestBody PlaceChangeRequest changeRequest) {
        Place place = converter.convert(changeRequest, Place.class);
        return new ResponseEntity<>(placeService.update(place),HttpStatus.OK);
    }

    @Operation(summary = "Gets cinema session by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the session", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/sessions/{id}")
    public ResponseEntity<Object> findSessionById(@PathVariable Long id) {
        return new ResponseEntity<>(sessionService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Create new cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Session created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/session")
    public ResponseEntity<Object> createSession(@Valid @RequestBody SessionCreateRequest createRequest) {
        Session session = converter.convert(createRequest, Session.class);
        return new ResponseEntity<>(sessionService.create(session),HttpStatus.CREATED);
    }

    @Operation(summary = "Update cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Session update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/session")
    public ResponseEntity<Object> updateSession(@Valid @RequestBody SessionChangeRequest changeRequest) {
        Session session = converter.convert(changeRequest, Session.class);
        return new ResponseEntity<>(sessionService.update(session),HttpStatus.OK);
    }

    @Operation(summary = "Delete session by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Session deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Object> deleteSessionById(@PathVariable Long id) {
        sessionService.delete(id);
        return new ResponseEntity<>("session deleted successful!", HttpStatus.OK);
    }

    @Operation(summary = "Gets ticket by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found ticket", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/tickets/{id}")
    public ResponseEntity<Object> findTicketById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete ticket by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Ticket deleted",
                    content = @Content)
            })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<Object> deleteTicketById(@PathVariable Long id) {
        ticketService.delete(id);
        return new ResponseEntity<>("ticket deleted successful!", HttpStatus.OK);
    }

    @Operation(summary = "Update movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieChangeRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/movie")
    public ResponseEntity<Object> updateMovie(@Valid @RequestBody MovieChangeRequest createRequest) {
        Movie movie = converter.convert(createRequest, Movie.class);
        return new ResponseEntity<>(movieService.update(movie),HttpStatus.CREATED);
    }

    @Operation(summary = "Update hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallChangeRequest.class)))
                    })
    })
    @PutMapping("/halls")
    public ResponseEntity<Object> updateHall(@Valid @RequestBody HallChangeRequest changeRequest) {
        Hall hall = converter.convert(changeRequest, Hall.class);
        return new ResponseEntity<>(hallService.update(hall),HttpStatus.OK);
    }

    @Operation(summary = "Update ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketChangeRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/tickets")
    public ResponseEntity<Object> createTicket(@Valid @RequestBody TicketChangeRequest changeRequest) {
        Ticket ticket = converter.convert(changeRequest, Ticket.class);
        return new ResponseEntity<>(ticketService.update(ticket),HttpStatus.CREATED);
    }

}
