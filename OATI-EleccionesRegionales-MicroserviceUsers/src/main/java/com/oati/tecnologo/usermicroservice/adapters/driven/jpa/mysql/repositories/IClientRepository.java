package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByNumberDocument (String numberDocument);
}
