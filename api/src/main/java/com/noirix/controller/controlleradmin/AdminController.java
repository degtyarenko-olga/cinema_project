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
import org.springframework.transaction.annotation.Transactional;
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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "ADMIN controller")
public class AdminController {
    private final UserService service;
    private final ConversionService converter;
    private final MovieService movieServiceImpl;
    private final SessionService sessionServiceImpl;
    private final TicketService ticketServiceImpl;
    private final PlaceService placeServiceImpl;
    private final HallService hallService;
    private Long someId;

    @Operation(summary = "Gets all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the users", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/all")
    public ResponseEntity<Object> findAllUsers() {
        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findAll()), HttpStatus.OK);

    }

    @Operation(summary = "Delete user by ID",
            responses = {@ApiResponse(responseCode = "200", description = "User deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<Object> deleteUsersById(@PathVariable String id) {
        someId = Long.parseLong(id);
        service.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Operation(summary = "Gets user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/id/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable("id") String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("user", service.findById(someId)),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets user by login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/login/{login}")
    public ResponseEntity<Object> findUserByLogin(@PathVariable("login") String login) {
        return new ResponseEntity<>(Collections.singletonMap("user",
                service.findByLogin(login)), HttpStatus.OK);

    }

    @Operation(summary = "Gets hall by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Hall.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/hall/{id}")
    public ResponseEntity<Object> findHallById(@PathVariable("id") String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("hall", hallService.findById(someId)),
                HttpStatus.OK);

    }

    @Operation(summary = "Create new hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hall created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallCreateRequest.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/create/hall")
    public ResponseEntity<Object> createHall(@Valid @RequestBody HallCreateRequest createRequest) {
        Hall hall = converter.convert(createRequest, Hall.class);
        hallService.create(hall);
        return new ResponseEntity<>(
                Collections.singletonMap("hall", hallService.findById(hall.getId())),
                HttpStatus.CREATED);

    }

    @Operation(summary = "Delete hall by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Hall deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/hall/{id}")
    public ResponseEntity<Object> deleteHallById(@PathVariable String id) {
        someId = Long.parseLong(id);
        hallService.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", someId);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Operation(summary = "Gets movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Movie.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/movie/{id}")
    public ResponseEntity<Object> findMovieById(@Valid @PathVariable("id") String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("result",
                movieServiceImpl.findById(someId)), HttpStatus.OK);

    }

    @Operation(summary = "Create new movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieCreateRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @Transactional
    @PostMapping("/create/movie")
    public ResponseEntity<Object> createMovie(@Valid @RequestBody MovieCreateRequest createRequest) {
        Movie movie = converter.convert(createRequest, Movie.class);
        movieServiceImpl.create(movie);
        return new ResponseEntity<>(
                Collections.singletonMap("movie", movieServiceImpl.findById(movie.getId())),
                HttpStatus.CREATED);

    }

    @Operation(summary = "Delete movie by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Movie deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/movie/{id}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable String id) {
        someId = Long.parseLong(id);
        movieServiceImpl.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", someId);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Operation(summary = "Gets place by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found place", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Place.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/place/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable("id") String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("result",
                placeServiceImpl.findById(someId)), HttpStatus.OK);

    }

    @Operation(summary = "Delete place by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Place deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/place/{id}")
    public ResponseEntity<Object> deletePlaceById(@PathVariable String id) {
        someId = Long.parseLong(id);
        placeServiceImpl.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", someId);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Operation(summary = "Create new place")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Place created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceCreateRequest.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/create/place")
    public ResponseEntity<Object> createPlace(@Valid @RequestBody PlaceCreateRequest createRequest) {
        Place place = converter.convert(createRequest, Place.class);
        placeServiceImpl.create(place);
        return new ResponseEntity<>(
                Collections.singletonMap("place", placeServiceImpl.findById(place.getId())),
                HttpStatus.CREATED);

    }

    @Operation(summary = "Update place")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Place update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceCreateRequest.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/update/place")
    public ResponseEntity<Object> updatePlace(@Valid @RequestBody PlaceChangeRequest changeRequest) {
        Place place = converter.convert(changeRequest, Place.class);
        placeServiceImpl.update(place);
        return new ResponseEntity<>(
                Collections.singletonMap("place", placeServiceImpl.findById(place.getId())),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets cinema session by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the session", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/session/{id}")
    public ResponseEntity<Object> findSessionById(@PathVariable String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(
                Collections.singletonMap("session", sessionServiceImpl.findById(someId)),
                HttpStatus.OK);

    }

    @Operation(summary = "Create new cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Session created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/create/session")
    public ResponseEntity<Object> createSession(@Valid @RequestBody SessionCreateRequest createRequest) {
        Session session = converter.convert(createRequest, Session.class);
        sessionServiceImpl.create(session);
        return new ResponseEntity<>(
                Collections.singletonMap("session", sessionServiceImpl.findById(session.getId())),
                HttpStatus.CREATED);

    }

    @Operation(summary = "Update cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Session update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/update/session")
    public ResponseEntity<Object> updateSession(@Valid @RequestBody SessionChangeRequest changeRequest) {
        Session session = converter.convert(changeRequest, Session.class);
        sessionServiceImpl.update(session);
        return new ResponseEntity<>(
                Collections.singletonMap("session", sessionServiceImpl.findById(session.getId())),
                HttpStatus.OK);

    }

    @Operation(summary = "Delete session by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Session deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/session/{id}")
    public ResponseEntity<Object> deleteSessionById(@PathVariable String id) {
        someId = Long.parseLong(id);
        sessionServiceImpl.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", someId);
        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @Operation(summary = "Gets ticket by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found ticket", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Ticket.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/ticket/{id}")
    public ResponseEntity<Object> findTicketById(@Valid @PathVariable("id") String id) {
        someId = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("result",
                ticketServiceImpl.findById(someId)), HttpStatus.OK);

    }

    @Operation(summary = "Delete ticket by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Ticket deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/ticket/{id}")
    public ResponseEntity<Object> deleteTicketById(@PathVariable String id) {
        someId = Long.parseLong(id);
        ticketServiceImpl.delete(someId);
        Map<String, Object> model = new HashMap<>();
        model.put("id", someId);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Operation(summary = "Update movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieChangeRequest.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/update/movie")
    public ResponseEntity<Object> updateMovie(@Valid @RequestBody MovieChangeRequest createRequest) {
        Movie movie = converter.convert(createRequest, Movie.class);
        movieServiceImpl.update(movie);

        return new ResponseEntity<>(
                Collections.singletonMap("movie", movieServiceImpl.findById(movie.getId())),
                HttpStatus.CREATED);

    }

    @Operation(summary = "Update hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallChangeRequest.class)))
                    })
    })
    @PutMapping("/update/hall")
    public ResponseEntity<Object> updateHall(@Valid @RequestBody HallChangeRequest changeRequest) {
        Hall hall = converter.convert(changeRequest, Hall.class);
        hallService.update(hall);

        return new ResponseEntity<>(Collections.singletonMap("result", hallService.findById(hall.getId())),
                HttpStatus.OK);

    }

    @Operation(summary = "Update ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket update", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketChangeRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @Transactional
    @PutMapping("/update/ticket")
    public ResponseEntity<Object> createTicket(@Valid @RequestBody TicketChangeRequest changeRequest) {

        Ticket ticket = converter.convert(changeRequest, Ticket.class);

        ticketServiceImpl.update(ticket);

        return new ResponseEntity<>(
                Collections.singletonMap("ticket", ticketServiceImpl.findById(ticket.getId())),
                HttpStatus.CREATED);

    }

}
