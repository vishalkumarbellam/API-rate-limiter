package com.example.rate_limiter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rate_limiter.model.Api;

public interface ApiRepo extends JpaRepository<Api, String> {

}
