package com.oati.tecnologo.usermicroservice.domain.api.usecase;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.domain.exceptions.PhoneLenghtException;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.domain.api.IUserServicePort;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static com.oati.tecnologo.usermicroservice.configuration.Constants.CANDIDATE_ROLE_ID;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IUserEntityMapper userEntityMapper;

    private final PasswordEncoder passwordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IUserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByDocument(String numberDocument) {
        return userPersistencePort.getUserByDocument(numberDocument);
    }


    @Override
    public UserEntity saveUserCandidate(User user) {

        user.setRole(rolePersistencePort.getRol(CANDIDATE_ROLE_ID));
        user.setPassword(passwordEncoder.encode((user.getPassword())));

        return userPersistencePort.saveUser(user);
    }

    public Map<String, String> getHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return  headers;
    }
}
