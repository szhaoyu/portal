package com.brick.service;

import java.util.Collection;
import java.util.Optional;

import com.brick.entities.User;
import com.brick.entities.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
