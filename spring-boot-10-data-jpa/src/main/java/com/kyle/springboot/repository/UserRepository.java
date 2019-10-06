package com.kyle.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyle.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
