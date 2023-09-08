package com.jwtauthenticationspring6.service;

import com.jwtauthenticationspring6.dto.UserDto;
import com.jwtauthenticationspring6.entity.User;
import com.jwtauthenticationspring6.model.JwtAuthRequest;
import com.jwtauthenticationspring6.model.JwtAuthResponse;

import com.jwtauthenticationspring6.utils.JwtUtil;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;



//this service exposes authentication functionalities
@Service
public class JwtService implements UserDetailsService {

    private UserService userService;
    private ModelMapper modelMapper;
    private JwtUtil jwtUtil;

    private AuthenticationManager authenticationManager;

    public JwtService(UserService userService, ModelMapper modelMapper, JwtUtil jwtUtil) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
    }

    //use setter injection && @lazy here to avoid circular dependencies
    @Autowired
    public void setAuthenticationManager(@Lazy AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    //implementing loadUserByName method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUserName(username);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getPassword(),
                    getAuthorities(user));
        } else{
            throw new UsernameNotFoundException("User name is invalid");
        }
    }


    //authenticates user && creates a jwt token based on user details
    public JwtAuthResponse createJwtToken(JwtAuthRequest jwtAuthRequest) throws Exception {
        String userName = jwtAuthRequest.getUserName();
        String password = jwtAuthRequest.getUserPassword();


        authenticate(userName, password);

        UserDetails userDetails = loadUserByUsername(userName);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userService.findUserByUserName(userName);

        return new JwtAuthResponse(modelMapper.map(user, UserDto.class), newGeneratedToken);


    }

    //to handle exceptions
    private void authenticate(String username, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
        } catch (DisabledException e) {
            throw new Exception("user is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("bad credentials from user");
        }

    }

    //transforms user roles to a set of SimpleGrantedAuthority, to be used in user Details object
    private Set<SimpleGrantedAuthority> getAuthorities(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        user.getRoles().forEach(role ->
                 authorities.add(new SimpleGrantedAuthority(role.getRole())));


        return authorities;

    }


}
