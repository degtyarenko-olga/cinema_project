package com.noirix.controller.controlleruser;

import com.noirix.entity.Hall;
import com.noirix.service.impl.HallServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/hall")
public class HallController {
    private final HallServiceImpl service;

    @Operation(summary = "Gets all halls")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all halls", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Hall.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllHall() {

        return new ResponseEntity<>(
                Collections.singletonMap("hall", service.findAllHall()),
                HttpStatus.OK);

    }

    @Operation(summary = "Gets hall by Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found hall", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Hall.class)))
                    })
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findHallByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                service.findHallByName(name)), HttpStatus.OK);

    }

}
