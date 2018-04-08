package com.example.shoppingwebapplication.Services;

import com.example.shoppingwebapplication.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service for db authentication
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User currentUser = userService.findByUserName(userName);

        UserDetails user = new org.springframework.security.core.userdetails.User(userName, currentUser.getPassword(), true,
                true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
