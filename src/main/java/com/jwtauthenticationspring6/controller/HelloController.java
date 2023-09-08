package com.jwtauthenticationspring6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello world!";
    }

    @GetMapping("/user")
    public String helloUser(){
        return "hello user!";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "hello Admin!";
    }
}
