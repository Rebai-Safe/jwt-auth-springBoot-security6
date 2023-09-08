package com.jwtauthenticationspring6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor

public class JwtAuthRequest {

    private String userName;
    private String userPassword;
}
