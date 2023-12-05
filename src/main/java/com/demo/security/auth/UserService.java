package com.demo.security.auth;

import com.demo.security.security.UserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userDao.findBy(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with email %s is not exist!", email)
                ));
        //Set<UserPermission> permissions = userDao.getPermissionsBy(user.getId());
        return new User(
                user.getRole().getGrantedAuthority(),
                user.getId(),
                user.getRole(),
                user.getPassword(),
                user.getEmail(),
                true,
                true,
                true,
                true
                );
    }
}
