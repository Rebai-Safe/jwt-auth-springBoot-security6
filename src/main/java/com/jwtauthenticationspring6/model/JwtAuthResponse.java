package com.jwtauthenticationspring6.model;

import com.jwtauthenticationspring6.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor

public class JwtAuthResponse {

    private UserDto user;
    private String jwtToken;
}
