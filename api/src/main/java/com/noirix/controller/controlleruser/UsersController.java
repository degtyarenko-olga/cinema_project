package com.noirix.controller.controlleruser;

import com.noirix.controller.dto.user.UserChangeRequest;
import com.noirix.entity.User;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/users")
@Tag(name = "USER controller")
public class UsersController {

    private final UserService service;
    private final ConversionService converter;

    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content =
                    {@Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = UserChangeRequest.class)))
                    })
    })
    @Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token", required = true)
    @PutMapping("/user")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserChangeRequest userChangeRequest,
                                             Principal principal) {
        String username = PrincipalUtil.getUsername(principal);
        User result = service.findByLogin(username);
        userChangeRequest.setId(result.getId());
        User user = converter.convert(userChangeRequest, User.class);
         return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }

}
