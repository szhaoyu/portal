package com.brick.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.brick.entities.CurrentUser;
import com.brick.entities.User;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Slf4j
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}