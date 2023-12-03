package com.demo.security.auth;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDao {
    Optional<UserDetails> findBy(String email);
}
