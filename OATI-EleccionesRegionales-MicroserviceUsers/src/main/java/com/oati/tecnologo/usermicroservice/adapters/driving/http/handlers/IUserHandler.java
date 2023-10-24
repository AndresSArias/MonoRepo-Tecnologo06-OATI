package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.*;


import java.util.List;

public interface IUserHandler {

    void updateRating (QualificationRequestDto qualificationRequestDto);
    List<AdminResponseDto> getAllAdmins ();

    AuthUserResponse getUsuario (String numberDocument);

    ClienteCreateResponseDto saveClient (UserRequestDto userResponseDto);

    MessageCodeResponseDto isExist (String numDocument);

    ClienteCreateResponseDto saveAdmin (UserAdminRequestDto userAdminRequestDto);

    void updatePoints (String idClient, String points);

    PointsClientResponseDto getPoints (String numberDocument);

}
