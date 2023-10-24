package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRequestDto {

    @Pattern(regexp = "^[0-9]+$" , message = "The DNI must have only numbers")
    private String numberDocument;
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "The name must have only letters")
    private String name;

}
