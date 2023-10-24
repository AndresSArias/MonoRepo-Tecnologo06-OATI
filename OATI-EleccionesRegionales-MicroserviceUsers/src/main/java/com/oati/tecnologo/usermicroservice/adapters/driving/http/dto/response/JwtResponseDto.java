package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtResponseDto {

    private String token;
    private String id;
    private String idMultiplex;
    private String rol;
    private String name;

}
