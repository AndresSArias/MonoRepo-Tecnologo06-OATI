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

    @Override
    public void updateRating(QualificationRequestDto qualificationRequestDto) {
        userServicePort.updateRating(qualificationRequestDto);
    }

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        return userServicePort.getAllAdmins();
    }

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
    public ClienteCreateResponseDto saveClient(UserRequestDto userRequestDto) {

        ClienteCreateResponseDto clienteCreateResponseDto = userResponseMapper.toClientCreateDto(userServicePort.saveClient(userRequestMapper.toModel(userRequestDto)));
        clienteCreateResponseDto.setMessage("CorrectData:Create cliente successful");

        return clienteCreateResponseDto;
    }

    @Override
    public MessageCodeResponseDto isExist(String numDocument) {
        return userServicePort.isExist(numDocument);
    }

    @Override
    public ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto) {
        return userServicePort.saveAdmin(userAdminRequestDto);
    }

    @Override
    public void updatePoints(String idClient, String points) {
        userServicePort.updatePoints(Long.parseLong(idClient),Integer.parseInt(points));
    }

    @Override
    public PointsClientResponseDto getPoints(String numberDocument) {
        return userServicePort.getPoints(numberDocument);
    }

}
