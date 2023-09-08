package com.jwtauthenticationspring6.repository;

import com.jwtauthenticationspring6.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
