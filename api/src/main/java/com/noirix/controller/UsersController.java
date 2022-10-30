package com.noirix.controller;

import com.noirix.controller.dto.user.UserChangeRequest;
import com.noirix.controller.dto.user.UserCreateRequest;
import com.noirix.entity.User;
import com.noirix.security.util.PrincipalUtil;
import com.noirix.service.impl.UserServiceImpl;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/users")
@Tag(name = "USER CONTROLLER")
public class UsersController {
    private final UserServiceImpl service;
    private final ConversionService converter;

    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = UserCreateRequest.class)))
                    })
    })
    @Transactional
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody UserCreateRequest createRequest) {
        User user = converter.convert(createRequest, User.class);
        service.create(user);
        return new ResponseEntity<>(
                Collections.singletonMap("USER", service.findById(user.getId())),
                HttpStatus.CREATED);

    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UserChangeRequest updateRequest) {
        User hibernate = service.findById(id);
        System.out.println("users find + " + hibernate);
        User user = converter.convert(updateRequest, hibernate.getClass());
        service.update(user);
        System.out.println(user);

        return new ResponseEntity<>(
                Collections.singletonMap("USER", service.findById(user.getId())),
                HttpStatus.OK);

    }

//    @Operation(summary = "Update user")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User updated", content =
//                    {@Content(mediaType = "application/json", array =
//                    @ArraySchema(schema = @Schema(implementation = UserChangeRequest.class)))
//                    })
//    })
//    @Transactional
//    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
//    @PutMapping
//    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserChangeRequest userChangeRequest,
//                                             Principal principal) {
//
//        String username = PrincipalUtil.getUsername(principal);
//        User result = service.findByCredentialsLogin(username);
//
//        userChangeRequest.setId(result.getId());
//        User hibernateUser = converter.convert(userChangeRequest, User.class);
//
//        service.update(hibernateUser);
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("user", service.findById(hibernateUser.getId()));
//
//        return new ResponseEntity<>(model, HttpStatus.OK);
//
//    }

}
