package com.noirix.controller;

import com.noirix.controller.requests.hall.HallCreateRequest;
import com.noirix.controller.requests.movie.MovieCreateRequest;
import com.noirix.controller.requests.place.PlaceCreateRequest;
import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.domain.HallHibernate;
import com.noirix.domain.MovieHibernate;
import com.noirix.domain.PlaceHibernate;
import com.noirix.domain.SessionHibernate;
import com.noirix.domain.TicketHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.service.HallService;
import com.noirix.service.MovieService;
import com.noirix.service.PlaceService;
import com.noirix.service.RolesService;
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
@Tag(name = "ADMIN CONTROLLER")
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
                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/all")
    public ResponseEntity<Object> findAllUsers() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findByHQLQuery()), HttpStatus.OK);
    }

    @Operation(summary = "Delete user by ID",
            responses = {@ApiResponse(responseCode = "200", description = "User deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<Object> deleteUsersById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Operation(summary = "Gets user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/id/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(Collections.singletonMap("user", service.findById(id)),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Gets user by login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/user/login/{login}")
    public ResponseEntity<Object> findUserByCredentialsLogin(@PathVariable("login") String login) {

        return new ResponseEntity<>(Collections.singletonMap("user",
                service.findByCredentialsLogin(login)), HttpStatus.OK);
    }

    @Operation(summary = "Gets hall by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/hall/{id}")
    public ResponseEntity<Object> findHallById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(Collections.singletonMap("hall", hallService.findById(id)),
                HttpStatus.OK
        );
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
    public ResponseEntity<Object> create(@Valid @RequestBody HallCreateRequest createRequest) {

        HallHibernate hallHibernate = converter.convert(createRequest, HallHibernate.class);

        hallService.create(hallHibernate);

        return new ResponseEntity<>(
                Collections.singletonMap("hall", hallService.findById(hallHibernate.getId())),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Delete hall by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Hall deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/hall/{id}")
    public ResponseEntity<Object> deleteHallById(@PathVariable Long id) {

        hallService.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Operation(summary = "Gets movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found movie", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = MovieHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/movie/{id}")
    public ResponseEntity<Object> findMovieById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                movieService.findById(id)), HttpStatus.OK);

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
    public ResponseEntity<Object> create(@Valid @RequestBody MovieCreateRequest createRequest) {

        MovieHibernate movie = converter.convert(createRequest, MovieHibernate.class);

        movieService.create(movie);

        return new ResponseEntity<>(
                Collections.singletonMap("movie",movieService.findById(movie.getId())),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Delete movie by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Movie deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/movie/{id}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable Long id) {

        movieService.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Operation(summary = "Gets place by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found place", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/place/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                placeService.findById(id)), HttpStatus.OK);

    }

    @Operation(summary = "Delete place by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Place deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/place/{id}")
    public ResponseEntity<Object> deletePlaceById(@PathVariable Long id) {

        placeService.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
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
    public ResponseEntity<Object> create(@Valid @RequestBody PlaceCreateRequest createRequest) {

        PlaceHibernate place = converter.convert(createRequest, PlaceHibernate.class);

        placeService.create(place);

        return new ResponseEntity<>(
                Collections.singletonMap("place", placeService.findById(place.getId())),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Gets cinema session by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the session", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = SessionHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/session/{id}")
    public ResponseEntity<Object> findSessionById(@PathVariable String id) {
        long sessionId = Long.parseLong(id);
        return new ResponseEntity<>(
                Collections.singletonMap("session", sessionService.findById(sessionId)),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Create new cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Session created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = SessionHibernate.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PostMapping("/create/session")
    public ResponseEntity<Object> create(@Valid @RequestBody SessionCreateRequest createRequest) {

        SessionHibernate session = converter.convert(createRequest, SessionHibernate.class);

        sessionService.create(session);

        return new ResponseEntity<>(
                Collections.singletonMap("session", sessionService.findById(session.getId())),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Delete session by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Session deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/session/{id}")
    public ResponseEntity<Object> deleteSessionById(@PathVariable Long id) {

        sessionService.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Operation(summary = "Gets ticket by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found ticket", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = TicketHibernate.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @GetMapping("/find/ticket/{id}")
    public ResponseEntity<Object> findTicketById(@Valid @PathVariable("id") String id){
        long idTicket = Long.parseLong(id);
        return new ResponseEntity<>(Collections.singletonMap("result",
                ticketService.findById(idTicket)), HttpStatus.OK);

    }

    @Operation(summary = "Delete ticket by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Ticket deleted",
                    content = @Content)
            })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @DeleteMapping("/delete/ticket/{id}")
    public ResponseEntity<Object> deleteTicketById(@PathVariable Long id) {

        ticketService.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }






}
