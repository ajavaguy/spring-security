package com.demo.security.datasources;

import com.demo.security.auth.UserDao;
import com.demo.security.security.UserPermission;
import com.demo.security.security.UserRole;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class UserDataSource implements UserDao {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataSource(SqlSessionTemplate sqlSessionTemplate,
                          PasswordEncoder passwordEncoder) {
        this.userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserDetails> findBy(String email) {
        return Optional.ofNullable(userMapper.findBy(email));
    }

    @Override
    public Set<UserPermission> getPermissionsBy(Integer userId) {
        return userMapper.getPermissionsBy(userId);
    }
}
