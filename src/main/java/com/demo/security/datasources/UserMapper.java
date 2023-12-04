package com.demo.security.datasources;

import com.demo.security.security.UserPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Mapper
public interface UserMapper {
    UserDetails findBy(@Param("email") String email);
    Set<UserPermission> getPermissionsBy(@Param("userId") Integer userId);
}
