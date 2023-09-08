package com.jwtauthenticationspring6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

    @ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "user_role",
       joinColumns = {
            @JoinColumn(name= "userId")
       },
        inverseJoinColumns = {
            @JoinColumn(name = "roleId")
        }
    )
    private Set<Role> roles;
}
