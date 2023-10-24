package com.oati.tecnologo.usermicroservice.domain.api.usecase;

import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import com.oati.tecnologo.usermicroservice.domain.api.IRoleServicePort;
import com.oati.tecnologo.usermicroservice.domain.model.Role;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }
}
