package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {}
