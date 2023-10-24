package com.oati.tecnologo.usermicroservice.adapters.driving.http.endpoints.controller;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.*;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.oati.tecnologo.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class UserRestController {

    private final IUserHandler userHandler;


    @Operation(summary = "Add a new candidate",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Candidate created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Candidate already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for user creation",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/createUserCandidate")
    public ResponseEntity<Map<String, String>> saveUserCandidate(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveUserCandidate(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USER_CANDIDATE_CREATED_MESSAGE));
    }
    @Operation(summary = "Get a user for conect MicroserviceElecciones",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthUserResponse.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})

    @GetMapping("/getUser/{numberDocument}")
    public ResponseEntity<AuthUserResponse> getUser(@PathVariable String numberDocument) {
        return ResponseEntity.ok(userHandler.getUsuario(numberDocument));
    }


}
