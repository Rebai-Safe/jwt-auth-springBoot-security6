package com.jwtauthenticationspring6.repository;

import com.jwtauthenticationspring6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    public User findByUserName(String userName);
}
