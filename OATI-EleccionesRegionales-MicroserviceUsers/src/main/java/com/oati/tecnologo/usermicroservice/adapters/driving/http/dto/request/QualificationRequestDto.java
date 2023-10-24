package com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QualificationRequestDto {

    private String numberDocument;
    private String qualificationService;

}
