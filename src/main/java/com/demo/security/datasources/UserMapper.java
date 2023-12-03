package com.demo.security.datasources;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserMapper {
    Optional<UserDetails> findBy(@Param("email") String email);
}
