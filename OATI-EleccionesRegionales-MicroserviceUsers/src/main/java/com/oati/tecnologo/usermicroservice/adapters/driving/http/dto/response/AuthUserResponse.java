package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response;

public record AuthUserResponse(
        String name,
        String numberDocument,
        String role
) {
}
