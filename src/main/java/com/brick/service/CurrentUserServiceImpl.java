package com.brick.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.brick.entities.CurrentUser;
import com.brick.entities.Role;

@Service
@Slf4j
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        log.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
