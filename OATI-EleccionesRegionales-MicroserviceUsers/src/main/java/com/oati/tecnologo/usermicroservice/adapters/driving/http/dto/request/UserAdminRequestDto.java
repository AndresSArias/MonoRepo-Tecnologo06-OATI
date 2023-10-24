package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserAdminRequestDto {
    @Pattern(regexp = "^[0-9]+$" , message = "The DNI must have only numbers")
    private String numberDocument;
    @Pattern(regexp = "^[A-Za-zÁ-Úá-ú ]+$", message = "The name must have only letters")
    private String name;

    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-\\d{4}$")
    private String dateBirth;

    @Pattern(regexp = "^[+]?[0-9]+(\s[+]?[0-9]+)?$" , message = "The phone must have only numbers and country code with '+'")
    private String phone;
    @Email
    private String email;
    @Pattern(regexp = "^[0-9]+$" , message = "The salary must have only numbers")
    private String salary;

    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-\\d{4}$")
    private String dateContract;

    @Pattern(regexp = "^[0-9]+$" , message = "The id Multiplex must have only numbers")
    private String idMultiplex;

    @NotBlank
    private String password;

}
