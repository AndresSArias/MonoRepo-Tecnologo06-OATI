package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.impl;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.*;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.factory.mapper.response.IUserResponseMapper;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.factory.mapper.request.IUserRequestMapper;
import com.oati.tecnologo.usermicroservice.configuration.security.jwt.JwtProvider;
import com.oati.tecnologo.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    private final JwtProvider jwtProvider;




    /*
        @Override
        public void saveUserOwner(UserRequestDto userRequestDto) {
            userServicePort.saveUserOwner(userRequestMapper.toUserOwner(userRequestDto));
        }

        @Override
        public void saveUserCustomer(UserRequestDto userRequestDto) {
            userServicePort.saveUserCustomer(userRequestMapper.toUserOwner(userRequestDto));
        }
    */
    @Override
    public AuthUserResponse getUsuario(String numberDocument) {
        return userResponseMapper.userToAuthUserResponse(userServicePort.getUserByDocument(numberDocument));
    }

    @Override
    public void saveUserCandidate(UserRequestDto userResponseDto) {
        userServicePort.saveUserCandidate(userRequestMapper.toModel(userResponseDto));
    }


}
