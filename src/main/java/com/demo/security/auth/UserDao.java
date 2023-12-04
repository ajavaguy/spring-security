package com.demo.security.auth;

import com.demo.security.security.UserPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.Set;

public interface UserDao {
    Optional<UserDetails> findBy(String email);
    Set<UserPermission> getPermissionsBy(@Param("userId") Integer userId);
}
