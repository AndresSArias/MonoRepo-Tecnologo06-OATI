package com.oati.tecnologo.usermicroservice.domain.api.usecase;


import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.domain.model.Role;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {
    @InjectMocks
    private UserUseCase userUseCase;

    @Mock
    private IUserPersistencePort userPersistencePort;
    @Mock
    private IRolePersistencePort rolePersistencePort;
    @Mock
    private IUserEntityMapper userEntityMapper;
    @Mock
    private PasswordEncoder passwordEncoder;

    private User requestUser;

    @BeforeEach
    void setUp() {
        requestUser = new User (1L,"nameTest", "123","123"
                , new Role(1L,"ROLE_PRUEBA","ROLE_PRUEBA"));
    }



    @Test
    void saveUserCandidate() {
        UserEntity responseUserEntity = new UserEntity(requestUser.getId(),requestUser.getName(),requestUser.getNumberDocument(),"encrypyedPassword"
                , new RoleEntity(requestUser.getRole().getId(), requestUser.getRole().getName(),requestUser.getRole().getDescription()));
        when(rolePersistencePort.getRol(anyLong())).thenReturn(new Role(1L,"ROLE_PRUEBA","ROLE_PRUEBA"));
        when(passwordEncoder.encode(requestUser.getPassword())).thenReturn("encrypyedPassword");
        when(userPersistencePort.saveUser(requestUser)).thenReturn(responseUserEntity);

        UserEntity responseUserEntityTest = userUseCase.saveUserCandidate(requestUser);

        assertEquals(responseUserEntity, responseUserEntityTest);
    }

}