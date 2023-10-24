package com.oati.tecnologo.usermicroservice.domain.api.usecase;

import com.oati.tecnologo.usermicroservice.domain.exceptions.PhoneLenghtException;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.domain.api.IUserServicePort;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.HashMap;
import java.util.Map;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IUserEntityMapper userEntityMapper;


    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IUserEntityMapper userEntityMapper) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.userEntityMapper = userEntityMapper;

    }

    @Override
    public User getUserByDocument(String numberDocument) {
        return userPersistencePort.getUserByDocument(numberDocument);
    }

    @Override
    public User saveClient(User user) {
        /*if (!validatePhone(user)){
            throw new PhoneLenghtException();
        }
        */
        return userPersistencePort.saveClient(user);
    }

    public Map<String, String> getHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return  headers;
    }
}
