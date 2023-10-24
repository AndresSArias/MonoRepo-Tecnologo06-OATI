package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.*;


import java.util.List;

public interface IUserHandler {

    AuthUserResponse getUsuario (String numberDocument);

    void saveUserCandidate (UserRequestDto userResponseDto);


}
