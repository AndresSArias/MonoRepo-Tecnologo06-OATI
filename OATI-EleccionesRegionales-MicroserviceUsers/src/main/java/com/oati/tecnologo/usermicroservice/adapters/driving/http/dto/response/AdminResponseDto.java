package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdminResponseDto {
    private String idAdmin;
    private String numberDocument;
    private String name;
    private String dateBirth;
    private String phone;
    private String email;
    private String codeEmployee;
    private String salary;
    private String dateContract;
    private String idMultiplex;
}
