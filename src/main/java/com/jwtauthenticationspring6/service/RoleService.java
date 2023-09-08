package com.jwtauthenticationspring6.service;

import com.jwtauthenticationspring6.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class RoleService {

    private RoleRepository roleRepository;
}
