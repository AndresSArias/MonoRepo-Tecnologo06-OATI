package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByNumberDocument(String numberDocument);
}
