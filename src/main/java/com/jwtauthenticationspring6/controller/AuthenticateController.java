package com.jwtauthenticationspring6.controller;

import com.jwtauthenticationspring6.model.JwtAuthRequest;
import com.jwtauthenticationspring6.model.JwtAuthResponse;
import com.jwtauthenticationspring6.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 Controller that exposes authenticate web service.
 */

@AllArgsConstructor

@RestController
@CrossOrigin
public class AuthenticateController {

     private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public ResponseEntity<JwtAuthResponse> authenticate(@RequestBody JwtAuthRequest jwtAuthRequest){

        try{
            JwtAuthResponse jwtAuthResponse= jwtService.createJwtToken(jwtAuthRequest);
            return ResponseEntity.ok(jwtAuthResponse);
        } catch (Exception e) {
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }
}
