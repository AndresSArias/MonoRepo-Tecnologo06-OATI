package com.oati.tecnologo.usermicroservice.domain.spi;

import com.oati.tecnologo.usermicroservice.domain.model.Role;

import java.util.List;

public interface IRolePersistencePort {
    List<Role> getAllRoles();

    Role getRol(Long id);
}
