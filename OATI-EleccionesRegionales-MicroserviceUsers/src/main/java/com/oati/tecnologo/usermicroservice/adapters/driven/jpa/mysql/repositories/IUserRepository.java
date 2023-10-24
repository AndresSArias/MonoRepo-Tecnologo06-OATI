package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByRoleEntity(RoleEntity roleEntity);
    List<UserEntity> findAllById(Long idPerson);
    Optional<UserEntity> findByNumberDocument(String numberDocument);

}

