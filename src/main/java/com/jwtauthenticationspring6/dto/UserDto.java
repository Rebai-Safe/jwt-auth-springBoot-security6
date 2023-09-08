package com.jwtauthenticationspring6.dto;

import com.jwtauthenticationspring6.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private String firstName;
    private String lastName;
    private Set<RoleDto> roles;
}
