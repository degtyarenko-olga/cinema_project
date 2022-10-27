package com.noirix.controller;

import com.noirix.controller.requests.user.UserChangeRequest;
import com.noirix.controller.requests.user.UserCreateRequest;
import com.noirix.domain.UsersHibernate;
import com.noirix.security.util.PrincipalUtil;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/users")
@Tag(name = "USER CONTROLLER")
public class UsersController {

    private final UserService service;
    private final ConversionService converter;

//    @Operation(summary = "Gets all users")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the users", content =
//                    {@Content(mediaType = "application/json", array =
//                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
//                    })
//    })
//    @GetMapping("/all")
//    public ResponseEntity<Object> findAllUsers() {
//
//        return new ResponseEntity<>(Collections.singletonMap("result",
//                service.findByHQLQuery()), HttpStatus.OK);
//    }

//    @Operation(summary = "Gets user by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the user", content =
//                    {@Content(mediaType = "application/json", array =
//                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
//                    })
//    })
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Object> findUserById(@PathVariable("id") Long id) {
//
//        return new ResponseEntity<>(Collections.singletonMap("user", service.findById(id)),
//                HttpStatus.OK
//        );
//    }
//
//    @Operation(summary = "Gets user by login")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Found the user", content =
//                    {@Content(mediaType = "application/json", array =
//                    @ArraySchema(schema = @Schema(implementation = UsersHibernate.class)))
//                    })
//    })
//    @GetMapping("/{login}")
//    public ResponseEntity<Object> findUserByCredentialsLogin(@PathVariable("login") String login) {
//
//        return new ResponseEntity<>(Collections.singletonMap("user",
//                service.findByCredentialsLogin(login)), HttpStatus.OK);
//    }

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

        UsersHibernate user = converter.convert(createRequest, UsersHibernate.class);

        service.create(user);

        return new ResponseEntity<>(
                Collections.singletonMap("USER", service.findById(user.getId())),
                HttpStatus.CREATED);
    }

//    @Operation(summary = "Delete user by ID",
//            responses = {@ApiResponse(responseCode = "200", description = "User deleted",
//                    content = @Content)
//            })
//    @Transactional
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Object> deleteUsersById(@PathVariable Long id) {
//
//        service.delete(id);
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("id", id);
//        return new ResponseEntity<>(model, HttpStatus.OK);
//    }

//    @Transactional
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UserChangeRequest updateRequest) {
//        UsersHibernate hibernate = service.findById(id);
//        UsersHibernate user = converter.convert(updateRequest, hibernate.getClass());
//        return new ResponseEntity<>(
//                Collections.singletonMap("USER", service.findById(user.getId())),
//                HttpStatus.OK);
//    }


    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = UserChangeRequest.class)))
                    })
    })
    @Transactional
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserChangeRequest userChangeRequest,
                                             Principal principal) {

        String username = PrincipalUtil.getUsername(principal);
        UsersHibernate result = service.findByCredentialsLogin(username);

        userChangeRequest.setId(result.getId());
        UsersHibernate hibernateUser = converter.convert(userChangeRequest, UsersHibernate.class);

        service.update(hibernateUser);

        Map<String, Object> model = new HashMap<>();
        model.put("user", service.findById(hibernateUser.getId()));

        return new ResponseEntity<>(model, HttpStatus.OK);

    }


}
