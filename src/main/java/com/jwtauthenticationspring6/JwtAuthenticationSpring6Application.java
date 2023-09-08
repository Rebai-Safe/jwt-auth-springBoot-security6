package com.jwtauthenticationspring6;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtAuthenticationSpring6Application {

	//create model mapper instance and register it as a bean
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationSpring6Application.class, args);
	}

}
