package com.noirix.controller.springdata;

import com.noirix.controller.requests.session.SessionCreateRequest;
import com.noirix.domain.SessionHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.service.SessionService;
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
@RequestMapping("/rest/session")
public class SessionController {

    private final SessionService service;

    private final ConversionService converter;


    @Operation(summary = "Gets all cinema session")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the session", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = SessionHibernate.class)))
                    })
    })
    @GetMapping()
    public ResponseEntity<Object> findAllSession() {
        return new ResponseEntity<>(
                Collections.singletonMap("session", service.findAllSession()),
                HttpStatus.OK);
    }



}
