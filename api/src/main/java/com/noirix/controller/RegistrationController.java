package com.noirix.controller;

import com.noirix.controller.dto.user.UserCreateRequest;
import com.noirix.entity.User;
import com.noirix.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
@Tag(name = "Registration controller")
public class RegistrationController {
    private final UserService service;
    private final ConversionService converter;

    @Operation(summary = "Registration new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully", content = @Content),
            @ApiResponse(responseCode = "409", description = "User not registered", content = @Content),
            @ApiResponse(responseCode = "500", description = "User not registered, Illegal Arguments", content = @Content)
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Object> registration(@Valid @RequestBody UserCreateRequest createRequest) {
        User user = converter.convert(createRequest, User.class);
        service.create(user);
        return new ResponseEntity<>(
                Collections.singletonMap("USER", service.findById(user.getId())),
                HttpStatus.CREATED);

    }

}
