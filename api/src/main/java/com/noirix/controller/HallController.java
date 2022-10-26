package com.noirix.controller;

import com.noirix.controller.requests.hall.HallCreateRequest;
import com.noirix.controller.requests.place.PlaceCreateRequest;
import com.noirix.domain.HallHibernate;
import com.noirix.domain.PlaceHibernate;
import com.noirix.service.HallService;
import io.swagger.v3.oas.annotations.Operation;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/hall")
public class HallController {

     private final HallService service;

    private final ConversionService converter;


    @Operation(summary = "Gets all halls")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all halls", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallHibernate.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllHall() {

        return new ResponseEntity<>(
                Collections.singletonMap("hall", service.findAllHall()),
                HttpStatus.OK
        );
    }


    @Operation(summary = "Gets hall by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallHibernate.class)))
                    })
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> findHallById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(Collections.singletonMap("hall", service.findById(id)),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Gets hall by Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallHibernate.class)))
                    })
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findHallByName(@PathVariable("name")String name){

        return new ResponseEntity<>(Collections.singletonMap("result",

                service.findHallByName(name)), HttpStatus.OK);
    }

    @Operation(summary = "Create new hall")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hall created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = HallCreateRequest.class)))
                    })
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody HallCreateRequest createRequest) {

        HallHibernate hallHibernate = converter.convert(createRequest, HallHibernate.class);

        service.create(hallHibernate);

        return new ResponseEntity<>(
                Collections.singletonMap("hall", service.findById(hallHibernate.getId())),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Delete hall by ID",
            responses = {@ApiResponse(responseCode = "200", description = "Hall deleted",
                    content = @Content)
            })
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteHallById(@PathVariable Long id) {

        service.delete(id);

        Map<String, Object> model = new HashMap<>();
        model.put("id", id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
