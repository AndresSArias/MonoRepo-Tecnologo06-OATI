package com.oati.tecnologo.usermicroservice.domain.spi;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.PointsClientResponseDto;
import com.oati.tecnologo.usermicroservice.domain.model.Client;
import com.oati.tecnologo.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {

    UserEntity saveUserEmployee (User user);

    PointsClientResponseDto getPoints (String numberDocument);
    User getUserByDocument(String numberDocument);

    List<UserEntity> getAllUserAdmin ();

    MemberEntity getMemberById (String id);

    User saveClient (User user);

    MessageCodeResponseDto isExist(String numDocument);

    ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto);

    User getUserById (long id);

    Client getClientByDocument (String document);

    Client updateClient (Client client);

    void updateRating(QualificationRequestDto qualificationRequestDto);
}
