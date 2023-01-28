package com.example.rate_limiter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rate_limiter.model.ApiCallLog;

public interface LogRepo extends JpaRepository<ApiCallLog, String> {

}
