package com.noirix.controller.usercontroller;

import com.noirix.entity.Session;
import com.noirix.service.impl.SessionServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/session")
public class SessionController {
    private final SessionServiceImpl service;

    @Operation(summary = "Gets all cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the session", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = Session.class)))
                    })
    })
    @GetMapping()
    public ResponseEntity<Object> findAllSession() {
        return new ResponseEntity<>(
                Collections.singletonMap("session", service.findAll()),
                HttpStatus.OK);

    }

}
