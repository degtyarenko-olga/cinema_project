package com.noirix.controller.springdata;

import com.noirix.controller.requests.place.PlaceCreateRequest;
import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.PlaceHibernate;
import com.noirix.domain.SessionHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.service.PlaceService;
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
@RequestMapping("/rest/place")
public class PlaceController {

    private final PlaceService service;

    private final ConversionService converter;


    @Operation(summary = "Gets all places")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceHibernate.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllPlace(){
        return new ResponseEntity<>(Collections.singletonMap("result",service.findAllBy()), HttpStatus.OK);
    }


    @Operation(summary = "Gets place by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found place", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceHibernate.class)))
                    })
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findPlaceById(@Valid @PathVariable("id") Long id){

        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findById(id)), HttpStatus.OK);

    }

    @Operation(summary = "Gets all places by Row")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PlaceHibernate.class)))
                    })
    })
    @GetMapping("/{row}")
    public ResponseEntity<Object> findPlaceByRow(@PathVariable("row")int row){

        return new ResponseEntity<>(Collections.singletonMap("result",

                service.findAllPlaceByRow(row)), HttpStatus.OK);
    }


}
