package com.noirix.controller.usercontroller;

import com.noirix.entity.Place;
import com.noirix.service.impl.PlaceServiceImpl;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/place")
public class PlaceController {
    private final PlaceServiceImpl service;

    private final ConversionService converter;

    @Operation(summary = "Gets all places")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Place.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllPlace() {
        return new ResponseEntity<>(Collections.singletonMap("result", service.findAllBy()),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets place by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found place", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Place.class)))
                    })
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable("id") Long id) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }

    @Operation(summary = "Gets all places by Row")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Place.class)))
                    })
    })
    @GetMapping("/{row}")
    public ResponseEntity<Object> findPlaceByRow(@PathVariable("row") int row) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findAllPlaceByRow(row)), HttpStatus.OK);

    }

}
