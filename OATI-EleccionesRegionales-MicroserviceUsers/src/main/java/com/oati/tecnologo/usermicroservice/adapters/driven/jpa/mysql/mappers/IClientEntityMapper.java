package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.oati.tecnologo.usermicroservice.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IClientEntityMapper {
    Client toClient (ClientEntity clientEntity);

    ClientEntity toClientEntity (Client client);
}
