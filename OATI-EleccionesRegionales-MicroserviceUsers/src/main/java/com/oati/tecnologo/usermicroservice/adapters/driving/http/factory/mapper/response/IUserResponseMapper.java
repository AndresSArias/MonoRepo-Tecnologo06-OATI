package com.oati.tecnologo.usermicroservice.adapters.driving.http.factory.mapper.response;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.AuthUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    @Mapping(target = "role",source = "role.name")
    AuthUserResponse userToAuthUserResponse(User user);

    @Mapping(target = "idClient", source = "id")
    ClienteCreateResponseDto toClientCreateDto (User user);

}
