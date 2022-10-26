package com.noirix.controller;

import com.noirix.controller.requests.roles.RolesCreateRequest;
import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.RolesHibernate;
import com.noirix.domain.UsersHibernate;
import com.noirix.service.RolesService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/roles")
public class RolesController {

    private final RolesService service;

    private final ConversionService converter;

    @Operation(summary = "Gets all roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all roles", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = RolesHibernate.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<Object> findAllRoles() {

        return new ResponseEntity<>(
                Collections.singletonMap("result", service.findAll()),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Gets roles by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the role", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = RolesHibernate.class)))
                    })
    })
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findRolesById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(Collections.singletonMap("role", service.findById(id)),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Create new Role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Role created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = RolesCreateRequest.class)))
                    })
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody RolesCreateRequest createRequest) {

        RolesHibernate role = converter.convert(createRequest, RolesHibernate.class);

        service.create(role);

        return new ResponseEntity<>(
                Collections.singletonMap("role", service.findById(role.getId())),
                HttpStatus.CREATED);
    }

}
