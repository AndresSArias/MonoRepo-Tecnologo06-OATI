package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.oati.tecnologo.usermicroservice.domain.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMemberEntityMapper {

    Member toMember (MemberEntity memberEntity);

    MemberEntity toMembetEntity (Member member);
}
