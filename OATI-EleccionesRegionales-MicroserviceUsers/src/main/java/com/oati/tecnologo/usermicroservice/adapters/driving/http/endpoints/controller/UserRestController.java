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

    @Operation(summary = "Add a new Admin")
    @PostMapping("/admins/new")
    public ResponseEntity<ClienteCreateResponseDto> saveAdmin(@Valid @RequestBody UserAdminRequestDto userRequestDto) {

        return ResponseEntity.ok(userHandler.saveAdmin(userRequestDto));
    }

    @Operation(summary = "Validate cliente in system if code is 0, no exists, if code is 1 te client exist in system")
    @GetMapping("/client/{numberDocument}")
    public ResponseEntity<MessageCodeResponseDto> isExist(@PathVariable String numberDocument) {
        return ResponseEntity.ok(userHandler.isExist(numberDocument));
    }
    @Operation(summary = "Add a new client")
    @PostMapping("/client/new")
    public ResponseEntity<ClienteCreateResponseDto> saveClient(@Valid @RequestBody UserRequestDto userRequestDto) {

        return ResponseEntity.ok(userHandler.saveClient(userRequestDto));
    }

    @Operation(summary = "Show all admins multiplex in system")
    @GetMapping("/all/admins")
    public ResponseEntity<List<AdminResponseDto>> getAllAdmins() {
        return ResponseEntity.ok(userHandler.getAllAdmins());
    }
    @Operation(summary = "Get a user for conect MicroserviceMultiplex",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthUserResponse.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})

    @GetMapping("/getUser/{numberDocument}")
    public ResponseEntity<AuthUserResponse> getUser(@PathVariable String numberDocument) {
        return ResponseEntity.ok(userHandler.getUsuario(numberDocument));
    }
    @Operation(summary = "Update points of User")
    @PutMapping("/points/{idClient}/{points}")
    public ResponseEntity<Map<String, String>> updatePoints(@PathVariable String idClient, @PathVariable String points) {
        userHandler.updatePoints(idClient, points);
        return ResponseEntity.ok().body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PLATE_UPDATED_MESSAGE));
    }

    @Operation(summary = "Update rating of service Cine Pacho by Client")
    @PutMapping("/qualification/service")
    public ResponseEntity<Map<String, String>> updateRating(@Valid @RequestBody QualificationRequestDto qualificationRequestDto) {
        userHandler.updateRating(qualificationRequestDto);
        return ResponseEntity.ok().body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.RAITING_SERIVE_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get points of client")
    @GetMapping("/client/points/{numberDocument}")
    public ResponseEntity<PointsClientResponseDto> getAllAdmins(@PathVariable String numberDocument) {
        return ResponseEntity.ok(userHandler.getPoints(numberDocument));
    }

}
