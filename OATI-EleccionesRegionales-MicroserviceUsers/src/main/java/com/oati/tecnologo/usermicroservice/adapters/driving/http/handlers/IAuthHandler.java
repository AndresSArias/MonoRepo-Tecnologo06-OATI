package com.oati.tecnologo.usermicroservice.adapters.driving.http.handlers;

import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.JwtResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.LoginRequestDto;

import java.text.ParseException;

public interface IAuthHandler {
    JwtResponseDto login(LoginRequestDto loginRequestDto);
    String refresh(String token) throws ParseException;

}
