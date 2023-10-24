package com.oati.tecnologo.usermicroservice.domain.api;

import com.oati.tecnologo.usermicroservice.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {
    List<Role> getAllRoles();
}
