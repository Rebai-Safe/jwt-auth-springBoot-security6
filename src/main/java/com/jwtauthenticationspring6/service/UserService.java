package com.jwtauthenticationspring6.service;

import com.jwtauthenticationspring6.entity.User;
import com.jwtauthenticationspring6.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class UserService {

    private UserRepository userRepository;

    public User findUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
