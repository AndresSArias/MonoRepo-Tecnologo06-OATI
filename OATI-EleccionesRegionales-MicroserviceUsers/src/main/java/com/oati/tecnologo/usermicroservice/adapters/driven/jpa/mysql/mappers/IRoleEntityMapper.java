package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.oati.tecnologo.usermicroservice.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {

    List<Role> toRoleList(List<RoleEntity> roleEntityList);

    Role toRole (RoleEntity role);
}
