package com.brick.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brick.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}

