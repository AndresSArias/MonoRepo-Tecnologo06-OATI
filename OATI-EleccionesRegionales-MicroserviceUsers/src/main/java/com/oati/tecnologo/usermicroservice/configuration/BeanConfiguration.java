package com.oati.tecnologo.usermicroservice.configuration;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.adapter.UserMysqlAdapter;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IRoleEntityMapper;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.domain.api.IUserServicePort;
import com.oati.tecnologo.usermicroservice.domain.api.usecase.RoleUseCase;
import com.oati.tecnologo.usermicroservice.domain.api.usecase.UserUseCase;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.adapter.RoleMysqlAdapter;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.oati.tecnologo.usermicroservice.domain.api.IRoleServicePort;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }
    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleMysqlAdapter(roleRepository, roleEntityMapper);
    }
    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), rolePersistencePort(), userEntityMapper);
    }
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserMysqlAdapter(userRepository, roleRepository, userEntityMapper);
    }
}
