package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IRoleEntityMapper;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.oati.tecnologo.usermicroservice.domain.model.Role;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

import java.util.List;

@RequiredArgsConstructor
public class RoleMysqlAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;
    @Override
    public List<Role> getAllRoles() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        if (roleEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return roleEntityMapper.toRoleList(roleEntityList);
    }
    @Override
    public Role getRol (Long id) {
        Optional<RoleEntity> roleEntity = roleRepository.findById(id);
        if (!roleEntity.isPresent()){
            throw new NoDataFoundException();
        }
        return roleEntityMapper.toRole(roleEntity.get());
    }
}
