package com.demo.security.datasources;

import com.demo.security.auth.UserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDataSource implements UserDao {
    private final UserMapper userMapper;

    public UserDataSource(@Autowired SqlSessionTemplate sqlSessionTemplate) {
        this.userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
    }

    @Override
    public Optional<UserDetails> findBy(String email) {
        return userMapper.findBy(email);
    }
}
