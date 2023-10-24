package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.oati.tecnologo.usermicroservice.configuration.Constants.*;


@RequiredArgsConstructor
@Transactional
public class UserMysqlAdapter implements IUserPersistencePort {


    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserEntityMapper userEntityMapper;

    /*
    @Override
    public UserEntity saveUserEmployee(User user) {

        if (!user.getRole().getId().equals(EMPLOYEE_ROLE_ID))
        {
            throw new RoleNotAllowedForCreationException();
        }
        if (userRepository.findByNumberDocument(user.getNumberDocument()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new MailAlreadyExistsException();
        }
        if (!roleRepository.findById(user.getRole().getId()).isPresent()){
            throw new RoleNotFoundException();
        }

        return userRepository.save(userEntityMapper.toEntity(user));
    }

    */

    @Override
    public User getUserByDocument(String numberDocument) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(numberDocument)).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public UserEntity saveUser(User user) {
        if (!user.getRole().getId().equals(CANDIDATE_ROLE_ID))
        {
            throw new RoleNotAllowedForCreationException();
        }
        if (userRepository.findByNumberDocument(user.getNumberDocument()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        if (!roleRepository.findById(user.getRole().getId()).isPresent()){
            throw new RoleNotFoundException();
        }
        return userRepository.save(userEntityMapper.toEntity(user));
    }


    @Override
    public User getUserById(long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (!userEntity.isPresent()){
            throw new UserNotFoundException();
        }

        return userEntityMapper.toUser(userEntity.get());
    }





}
