package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.impl;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.LoginRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.JwtResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers.IAuthHandler;
import com.oati.tecnologo.usermicroservice.configuration.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements IAuthHandler {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public JwtResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getNumberDocument(), loginRequestDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String[] response = jwtProvider.generateToken(authentication);
        return new JwtResponseDto(response[0],response[1],response[2],response[3]);
    }

    @Override
    public String refresh(String oldToken) throws ParseException {
        String newToken = jwtProvider.refreshToken(oldToken);
        return newToken;
    }
}
