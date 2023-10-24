package com.oati.tecnologo.usermicroservice.adapters.driving.http.factory.mapper.request;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.exceptions.NoFormatDataException;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {


    User toModel (UserRequestDto userRequestDto);


}
