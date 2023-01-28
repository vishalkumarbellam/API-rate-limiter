package com.example.rate_limiter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rate_limiter.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
