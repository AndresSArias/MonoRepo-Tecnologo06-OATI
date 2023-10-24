package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.impl;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.IRoleHandler;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.factory.mapper.response.IRoleResponseMapper;
import com.oati.tecnologo.usermicroservice.domain.api.IRoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleHandlerImpl implements IRoleHandler {
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleServicePort roleServicePort;

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return roleResponseMapper.toResponseList(roleServicePort.getAllRoles());
    }
}
